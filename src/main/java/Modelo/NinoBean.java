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
public class NinoBean {
    private int idNino;
    private String nombreNino;
    private String apellidoNino;
    private ApoderadoBean idApoderado;

    public NinoBean() {
    }

    public NinoBean(int idNino) {
        this.idNino = idNino;
    }

    public int getIdNino() {
        return idNino;
    }

    public void setIdNino(int idNino) {
        this.idNino = idNino;
    }

    public String getNombreNino() {
        return nombreNino;
    }

    public void setNombreNino(String nombreNino) {
        this.nombreNino = nombreNino;
    }

    public String getApellidoNino() {
        return apellidoNino;
    }

    public void setApellidoNino(String apellidoNino) {
        this.apellidoNino = apellidoNino;
    }

    public ApoderadoBean getIdApoderado() {
        return idApoderado;
    }

    public void setIdApoderado(ApoderadoBean idApoderado) {
        this.idApoderado = idApoderado;
    }
       
}
