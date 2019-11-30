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
public class BusesChoferBean {
    private int idBusesChofer;
    private BusesBean idBuses;
    private ChoferBean idChofer;
    private AsistenteBean idAsistente;

    public BusesChoferBean() {
    }

    public BusesChoferBean(int idBusesChofer) {
        this.idBusesChofer = idBusesChofer;
    }

    public int getIdBusesChofer() {
        return idBusesChofer;
    }

    public void setIdBusesChofer(int idBusesChofer) {
        this.idBusesChofer = idBusesChofer;
    }

    public BusesBean getIdBuses() {
        return idBuses;
    }

    public void setIdBuses(BusesBean idBuses) {
        this.idBuses = idBuses;
    }

    public ChoferBean getIdChofer() {
        return idChofer;
    }

    public void setIdChofer(ChoferBean idChofer) {
        this.idChofer = idChofer;
    }

    public AsistenteBean getIdAsistente() {
        return idAsistente;
    }

    public void setIdAsistente(AsistenteBean idAsistente) {
        this.idAsistente = idAsistente;
    }
    
}
