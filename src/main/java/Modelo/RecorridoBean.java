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
public class RecorridoBean {
    private int idRecorrido;
    private ModalidadBean idModalidad;
    private BarrioBean idBarrio;
    private ColegioBean idColegio;
    private BusesChoferBean idBusesChofer;

    public RecorridoBean() {
    }

    public RecorridoBean(int idRecorrido) {
        this.idRecorrido = idRecorrido;
    }

    public int getIdRecorrido() {
        return idRecorrido;
    }

    public void setIdRecorrido(int idRecorrido) {
        this.idRecorrido = idRecorrido;
    }

    public ModalidadBean getIdModalidad() {
        return idModalidad;
    }

    public void setIdModalidad(ModalidadBean idModalidad) {
        this.idModalidad = idModalidad;
    }

    public BarrioBean getIdBarrio() {
        return idBarrio;
    }

    public void setIdBarrio(BarrioBean idBarrio) {
        this.idBarrio = idBarrio;
    }

    public ColegioBean getIdColegio() {
        return idColegio;
    }

    public void setIdColegio(ColegioBean idColegio) {
        this.idColegio = idColegio;
    }

    public BusesChoferBean getIdBusesChofer() {
        return idBusesChofer;
    }

    public void setIdBusesChofer(BusesChoferBean idBusesChofer) {
        this.idBusesChofer = idBusesChofer;
    }
        
}
