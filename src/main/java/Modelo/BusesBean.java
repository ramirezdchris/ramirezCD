/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author christian.ramirezusa
 */
public class BusesBean {
    private int idBuses;
    private String placa;
    private String marca;
    private String modelo;
    private int asientos;

    public BusesBean() {
    }

    public BusesBean(int idBuses) {
        this.idBuses = idBuses;
    }

    public int getIdBuses() {
        return idBuses;
    }

    public void setIdBuses(int idBuses) {
        this.idBuses = idBuses;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAsientos() {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }        
    
}
