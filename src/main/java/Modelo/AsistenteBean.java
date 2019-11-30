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
public class AsistenteBean {
    private int idAsistente;
    private String dui;
    private String nombreAsistente;
    private String apellidoAsistente;

    public AsistenteBean() {
    }

    public AsistenteBean(int idAsistente) {
        this.idAsistente = idAsistente;
    }

    public int getIdAsistente() {
        return idAsistente;
    }

    public void setIdAsistente(int idAsistente) {
        this.idAsistente = idAsistente;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNombreAsistente() {
        return nombreAsistente;
    }

    public void setNombreAsistente(String nombreAsistente) {
        this.nombreAsistente = nombreAsistente;
    }

    public String getApellidoAsistente() {
        return apellidoAsistente;
    }

    public void setApellidoAsistente(String apellidoAsistente) {
        this.apellidoAsistente = apellidoAsistente;
    }
    
}
