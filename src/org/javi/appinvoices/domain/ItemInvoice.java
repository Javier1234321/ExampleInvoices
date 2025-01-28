package org.javi.appinvoices.domain;

public class ItemInvoice {
    private int cantidad;
    private Product product;

    public ItemInvoice(int cantidad, Product product) {
        this.cantidad = cantidad;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public float calcularImporte()
    {
        return this.cantidad*this.product.getPrecio();
    }
}
