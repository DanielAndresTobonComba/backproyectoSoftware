package com.example.backproyecto.FacturaSurtitiendas.Infrastructure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import com.example.backproyecto.FacturaSurtitiendas.application.IFacturaSurtitiendasService;
import com.example.backproyecto.FacturaSurtitiendas.domain.FacturaSurtitiendas;
import com.example.backproyecto.FacturaSurtitiendas.domain.ProductoFacturaDetalleDto;
import com.example.backproyecto.FacturaSurtitiendas.domain.ProductosSurtitiendasFactura;
import com.example.backproyecto.FacturaSurtitiendas.domain.ProductosSurtitiendasFacturaId;
import com.example.backproyecto.Usuario.infrastructure.UsuarioRepository;
import com.example.backproyecto.productoSurtitiendas.domain.ProductoSurtitiendas;
import com.example.backproyecto.FacturaSurtitiendas.domain.FacturaDetalleDto;
import com.example.backproyecto.FacturaSurtitiendas.domain.FacturaRequestDto;
import com.example.backproyecto.FacturaSurtitiendas.domain.ProductoSurtitiendasItemDto;



@Service
public class FacturaSurtitiendasService implements IFacturaSurtitiendasService {

    @Autowired
    private FacturaSurtitiendasRepository facturaRepo;

    @Autowired
    private ProductoFacturaSurtitiendasRepository productoRepo;

    @Autowired
    private ProductosSurtitiendasFacturaRepository productosFacturaRepo;

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Override
    @Transactional
    public FacturaSurtitiendas crearFactura(FacturaRequestDto request) {

        FacturaSurtitiendas factura = new FacturaSurtitiendas();
        factura.setTotal(request.getTotal());
        factura.setFecha(request.getFecha());

        Long usuarioId = Long.parseLong(request.getUsuario().get("id").toString());
        factura.setIdUsuario(usuarioId);

        FacturaSurtitiendas saved = facturaRepo.save(factura);

        for (ProductoSurtitiendasItemDto item : request.getProductos()) {

            ProductoSurtitiendas producto = productoRepo.findById(item.getIdProducto())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            ProductosSurtitiendasFacturaId id =
                    new ProductosSurtitiendasFacturaId(saved.getIdFactura(), item.getIdProducto());

            ProductosSurtitiendasFactura detalle = new ProductosSurtitiendasFactura();
            detalle.setId(id);
            detalle.setFactura(saved);
            detalle.setProducto(producto);
            detalle.setCantidad(item.getCantidad());
            detalle.setSubtotal(item.getSubtotal());
            detalle.setPrecioBase(item.getPrecioUnitario());
            

            productosFacturaRepo.save(detalle);
        }

        return saved;
    }



    @Override
    public List<FacturaDetalleDto> obtenerFacturasPorNombre(String nombreUsuario) {

        var usuario = usuarioRepo.findByNombre(nombreUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        var facturas = facturaRepo.findByIdUsuario(usuario.getId());

        return facturas.stream().map(f -> {

            var productos = productosFacturaRepo.findByFactura_IdFactura(f.getIdFactura())
                    .stream()
                    .map(det -> new ProductoFacturaDetalleDto(
                            det.getProducto().getIdProducto(),
                            det.getProducto().getNombre(),
                            det.getProducto().getTamano(),
                            det.getProducto().getImagenUrl(),
                            det.getPrecioBase(),
                            det.getCantidad(),
                            det.getSubtotal()
                    ))
                    .toList();

            return new FacturaDetalleDto(
                    f.getIdFactura(),
                    f.getTotal(),
                    f.getFecha(),
                    productos
            );
        }).toList();
    }
}
