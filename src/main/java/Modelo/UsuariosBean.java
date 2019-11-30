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
public class UsuariosBean {
    private String username;
    private String clave;
    private String rol;
    private ApoderadoBean idApoderado;

    public UsuariosBean() {
    }

    public UsuariosBean(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public ApoderadoBean getIdApoderado() {
        return idApoderado;
    }

    public void setIdApoderado(ApoderadoBean idApoderado) {
        this.idApoderado = idApoderado;
    }
        
}
