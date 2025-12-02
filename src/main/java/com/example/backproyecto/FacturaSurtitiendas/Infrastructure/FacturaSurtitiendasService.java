package com.example.backproyecto.FacturaSurtitiendas.Infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import com.example.backproyecto.FacturaSurtitiendas.application.IFacturaSurtitiendasService;
import com.example.backproyecto.FacturaSurtitiendas.domain.FacturaSurtitiendas;
import com.example.backproyecto.FacturaSurtitiendas.domain.ProductosSurtitiendasFactura;
import com.example.backproyecto.FacturaSurtitiendas.domain.ProductosSurtitiendasFacturaId;
import com.example.backproyecto.productoSurtitiendas.domain.ProductoSurtitiendas;
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
}
