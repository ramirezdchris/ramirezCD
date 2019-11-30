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
public class RecorridoNinoBean {
    private int idRecorridoNino;
    private RecorridoBean idRecorrido;
    private NinoBean idNino;

    public RecorridoNinoBean() {
    }

    public RecorridoNinoBean(int idRecorridoNino) {
        this.idRecorridoNino = idRecorridoNino;
    }

    public int getIdRecorridoNino() {
        return idRecorridoNino;
    }

    public void setIdRecorridoNino(int idRecorridoNino) {
        this.idRecorridoNino = idRecorridoNino;
    }

    public RecorridoBean getIdRecorrido() {
        return idRecorrido;
    }

    public void setIdRecorrido(RecorridoBean idRecorrido) {
        this.idRecorrido = idRecorrido;
    }

    public NinoBean getIdNino() {
        return idNino;
    }

    public void setIdNino(NinoBean idNino) {
        this.idNino = idNino;
    }
    
    
}
