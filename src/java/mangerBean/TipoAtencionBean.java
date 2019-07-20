/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mangerBean;

import dao.TipoAtencionDao;
import entidades.Tipoatencion;

import java.util.ArrayList;
import java.util.LinkedList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import service.ITipoAtencion;

/**
 *
 * @author PC-JHONROMERO
 */
@ManagedBean
@ViewScoped
public class TipoAtencionBean {

    /*Session session;
    Transaction transaction;*/
    private Tipoatencion tipoatencion;
    public TipoAtencionDao tipoatenciondao;
    boolean respuesta;
    private boolean banderaSelect = false;    

    public TipoAtencionBean() {
        this.tipoatencion = new Tipoatencion();
    }

    public Tipoatencion getTipoAtencion() {
        return tipoatencion;
    }

    public void setTipoAtencion(Tipoatencion tipoatencion) {
        this.tipoatencion = tipoatencion;
    }

    public ArrayList<Tipoatencion> listTipoAtencion() {

        ArrayList<Tipoatencion> list = new ArrayList<>();
        tipoatenciondao = new TipoAtencionDao();
        list = tipoatenciondao.listTipoatencion();
        return list;

    }
    
    public String insertTipoAtencion(){
        
        tipoatenciondao = new TipoAtencionDao();
        respuesta = tipoatenciondao.insertTipoatencion(tipoatencion);
        if(respuesta){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro insertado con exito", "exito"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/TipoAtencion";
        
    }
    
    public String clean(){
        return "/TipoAtencion";
    }
    
    public String updateTipoAtencion(){
        
        tipoatenciondao = new TipoAtencionDao();
        respuesta = tipoatenciondao.updateTipoatencion(tipoatencion);
        if(respuesta){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro actualizado con exito", "exito"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/TipoAtencion";
        
    }
    
    public String deleteTipoAtencion(){
        
        tipoatenciondao = new TipoAtencionDao();
        respuesta = tipoatenciondao.deleteTipoatencion(tipoatencion);
        if(respuesta){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro eliminado con exito", "exito"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/TipoAtencion";
        
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
