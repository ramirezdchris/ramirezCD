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
public class ModalidadBean {
    private int idModalidad;
    private String modalidad;
    private Date recoger;
    private Date dejar;

    public ModalidadBean() {
    }

    public ModalidadBean(int idModalidad) {
        this.idModalidad = idModalidad;
    }

    public int getIdModalidad() {
        return idModalidad;
    }

    public void setIdModalidad(int idModalidad) {
        this.idModalidad = idModalidad;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public Date getRecoger() {
        return recoger;
    }

    public void setRecoger(Date recoger) {
        this.recoger = recoger;
    }

    public Date getDejar() {
        return dejar;
    }

    public void setDejar(Date dejar) {
        this.dejar = dejar;
    }
    
}
