package com.example.ruloapp;
import java.io.Serializable;

public class Cripto {

    private String nombreExchange;
    private String nombreCriptomoneda;
    private Double precioVenta;
    private Double precioCompra;

    public Cripto(String nombreExchange, String nombreCriptomoneda, Double precioVenta, Double precioCompra) {
        this.nombreExchange = nombreExchange;
        this.nombreCriptomoneda = nombreCriptomoneda;
        this.precioVenta = precioVenta;
        this.precioCompra = precioCompra;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public String getNombreExchange() {
        return nombreExchange;
    }

    public String getNombreCriptomoneda() {
        return nombreCriptomoneda;
    }

    public void setNombreExchange(String nombreExchange) {
        this.nombreExchange = nombreExchange;
    }

    public void setNombreCriptomoneda(String nombreCriptomoneda) {
        this.nombreCriptomoneda = nombreCriptomoneda;
    }

    @Override
    public String toString() {
        return "Cripto{" +
                "nombreExchange='" + nombreExchange + '\'' +
                ", nombreCriptomoneda='" + nombreCriptomoneda + '\'' +
                ", precioVenta=" + precioVenta +
                ", precioCompra=" + precioCompra +
                '}';
    }
}
