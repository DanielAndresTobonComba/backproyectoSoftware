package com.example.backproyecto.FacturaAlqueria.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class FacturaRequestDto {
    private List<ProductoItemDto> productos;
    private BigDecimal total;
    private Map<String, Object> usuario; // se espera { id: <numero> }
    private String fecha; // Nuevo campo (si es necesario)

    public FacturaRequestDto() {}
    public List<ProductoItemDto> getProductos() { return productos; }
    public void setProductos(List<ProductoItemDto> productos) { this.productos = productos; }
    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
    public Map<String, Object> getUsuario() { return usuario; }
    public void setUsuario(Map<String, Object> usuario) { this.usuario = usuario; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
}
