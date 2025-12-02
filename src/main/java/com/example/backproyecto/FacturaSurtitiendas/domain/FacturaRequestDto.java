package com.example.backproyecto.FacturaSurtitiendas.domain;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class FacturaRequestDto {

    private List<ProductoSurtitiendasItemDto> productos;
    private BigDecimal total;
    private Map<String, Object> usuario;
    private String fecha;

    public List<ProductoSurtitiendasItemDto> getProductos() { return productos; }
    public void setProductos(List<ProductoSurtitiendasItemDto> productos) { this.productos = productos; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }

    public Map<String, Object> getUsuario() { return usuario; }
    public void setUsuario(Map<String, Object> usuario) { this.usuario = usuario; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
}
