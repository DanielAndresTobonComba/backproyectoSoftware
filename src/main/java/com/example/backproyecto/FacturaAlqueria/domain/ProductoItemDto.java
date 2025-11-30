package com.example.backproyecto.FacturaAlqueria.domain;

public class ProductoItemDto {

    private String idProducto;
    private Integer cantidad;
    private Double precioUnitario; // Nuevo campo
    private Double subtotal; // Nuevo campo

    public ProductoItemDto() {}

    public String getIdProducto() { return idProducto; }
    public void setIdProducto(String idProducto) { this.idProducto = idProducto; }
    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
    public Double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(Double precioUnitario) { this.precioUnitario = precioUnitario; }
    public Double getSubtotal() { return subtotal; }
    public void setSubtotal(Double subtotal) { this.subtotal = subtotal; }
}
