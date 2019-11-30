/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author christian.ramirezusa
 */
public class ViajesBean {
    private int idViaje;
    private Date llegadaColegio;
    private Date retornoCochera;
    private int kmInicio;
    private int kmFin;
    private String descripcion;
    private Date Fecha;
    private RecorridoNinoBean idRecorridoNino;

    public ViajesBean() {
    }

    public ViajesBean(int idViaje) {
        this.idViaje = idViaje;
    }

    public int getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }

    public Date getLlegadaColegio() {
        return llegadaColegio;
    }

    public void setLlegadaColegio(Date llegadaColegio) {
        this.llegadaColegio = llegadaColegio;
    }

    public Date getRetornoCochera() {
        return retornoCochera;
    }

    public void setRetornoCochera(Date retornoCochera) {
        this.retornoCochera = retornoCochera;
    }

    public int getKmInicio() {
        return kmInicio;
    }

    public void setKmInicio(int kmInicio) {
        this.kmInicio = kmInicio;
    }

    public int getKmFin() {
        return kmFin;
    }

    public void setKmFin(int kmFin) {
        this.kmFin = kmFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public RecorridoNinoBean getIdRecorridoNino() {
        return idRecorridoNino;
    }

    public void setIdRecorridoNino(RecorridoNinoBean idRecorridoNino) {
        this.idRecorridoNino = idRecorridoNino;
    }
        
}
