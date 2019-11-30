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
public class ChoferBean {
    private int idChofer;
    private String dui;
    private String nombreChofer;
    private String apellidoChofer;
    private String licencia;

    public ChoferBean() {
    }

    public ChoferBean(int idChofer) {
        this.idChofer = idChofer;
    }

    public int getIdChofer() {
        return idChofer;
    }

    public void setIdChofer(int idChofer) {
        this.idChofer = idChofer;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNombreChofer() {
        return nombreChofer;
    }

    public void setNombreChofer(String nombreChofer) {
        this.nombreChofer = nombreChofer;
    }

    public String getApellidoChofer() {
        return apellidoChofer;
    }

    public void setApellidoChofer(String apellidoChofer) {
        this.apellidoChofer = apellidoChofer;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }
        
}
