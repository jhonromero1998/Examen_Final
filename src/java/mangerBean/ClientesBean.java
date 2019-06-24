/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mangerBean;

import dao.ClientesDao;
import entidades.Clientes;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author IVAN
 */
@ManagedBean
@ViewScoped
public class ClientesBean {
    
     private Clientes clientes;
    private ClientesDao clientesDao;
    private boolean respuesta;
    
    public ClientesBean() {
        this.clientes = new Clientes();
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }
    
    public ArrayList<Clientes> listClientes() {

        ArrayList<Clientes> list = new ArrayList<>();
        clientesDao = new ClientesDao();
        list = clientesDao.listClientes();
        return list;

    }
    
    public String insertClientes(){
        
        clientesDao = new ClientesDao();
        respuesta = clientesDao.insertClientes(clientes);
        if(respuesta){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro insertado con exito", "exito"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/Clientes";
        
    }
    
    public String clean(){
        return "/Clientes";
    }
    
    public String updateClientes(){
        
        clientesDao = new ClientesDao();
        respuesta = clientesDao.updateClientes(clientes);
        if(respuesta){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro actualizado con exito", "exito"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/Clientes";
        
    }
    
    public String deleteClientes(Clientes clientes){
        
        clientesDao = new ClientesDao();
        respuesta = clientesDao.deleteClientes(clientes);
        if(respuesta){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro eliminado con exito", "exito"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/Clientes";
        
    }
    
}
