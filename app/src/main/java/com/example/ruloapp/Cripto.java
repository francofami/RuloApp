package com.example.ruloapp;
import java.io.Serializable;

public class Cripto {

    private String nombreExchange;
    private String nombreCriptomoneda;
    private Float precio;

    public Cripto(String nombreExchange, String nombreCriptomoneda, Float precio) {
        this.nombreExchange = nombreExchange;
        this.nombreCriptomoneda = nombreCriptomoneda;
        this.precio = precio;
    }

    public String getNombreExchange() {
        return nombreExchange;
    }

    public String getNombreCriptomoneda() {
        return nombreCriptomoneda;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setNombreExchange(String nombreExchange) {
        this.nombreExchange = nombreExchange;
    }

    public void setNombreCriptomoneda(String nombreCriptomoneda) {
        this.nombreCriptomoneda = nombreCriptomoneda;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Cripto{" +
                "nombreExchange='" + nombreExchange + '\'' +
                ", nombreCriptomoneda='" + nombreCriptomoneda + '\'' +
                ", precio=" + precio +
                '}';
    }
}
