/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mangerBean;

import dao.TipoReservaDao;
import entidades.Tiporeserva;

import java.util.ArrayList;
import java.util.LinkedList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import service.ITipoReserva;

/**
 *
 * @author PC-JHONROMERO
 */
@ManagedBean
@ViewScoped
public class TipoReservaBean {

    /*Session session;
    Transaction transaction;*/
    private Tiporeserva tipoatencion;
    public TipoReservaDao tipoatenciondao;
    boolean respuesta;
    private boolean banderaSelect = false;    

    public TipoReservaBean() {
        this.tipoatencion = new Tiporeserva();
    }

    public Tiporeserva getTipoReserva() {
        return tipoatencion;
    }

    public void setTipoReserva(Tiporeserva tipoatencion) {
        this.tipoatencion = tipoatencion;
    }

    public ArrayList<Tiporeserva> listTipoReserva() {

        ArrayList<Tiporeserva> list = new ArrayList<>();
        tipoatenciondao = new TipoReservaDao();
        list = tipoatenciondao.listTiporeserva();
        return list;

    }
    
    public String insertTipoReserva(){
        
        tipoatenciondao = new TipoReservaDao();
        respuesta = tipoatenciondao.insertTiporeserva(tipoatencion);
        if(respuesta){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro insertado con exito", "exito"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/TipoReserva";
        
    }
    
    public String clean(){
        return "/TipoReserva";
    }
    
    public String updateTipoReserva(){
        
        tipoatenciondao = new TipoReservaDao();
        respuesta = tipoatenciondao.updateTiporeserva(tipoatencion);
        if(respuesta){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro actualizado con exito", "exito"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/TipoReserva";
        
    }
    
    public String deleteTipoReserva(){
        
        tipoatenciondao = new TipoReservaDao();
        respuesta = tipoatenciondao.deleteTiporeserva(tipoatencion);
        if(respuesta){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro eliminado con exito", "exito"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/TipoReserva";
        
    }
    
    public void selectBandera(){
        banderaSelect = true;
    }

    public boolean isBanderaSelect() {
        return banderaSelect;
    }

    public void setBanderaSelect(boolean banderaSelect) {
        this.banderaSelect = banderaSelect;
    }

}
