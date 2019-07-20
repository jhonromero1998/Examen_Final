/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mangerBean;

import dao.ClientesDao;
import dao.PersonalDao;
import dao.UsuarioDao;
import entidades.Cliente;
import entidades.Personal;
import entidades.Usuario;

import java.util.ArrayList;
import java.util.LinkedList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import service.IUsuario;

/**
 *
 * @author PC-JHONROMERO
 */
@ManagedBean
@ViewScoped
public class UsuarioBean {

    /*Session session;
    Transaction transaction;*/
    private Usuario usuario;
    private UsuarioDao usuariodao;
    private boolean respuesta;
    private boolean banderaSelect = false;    
    
    
    private Personal personal;
    private Cliente cliente;
    private ArrayList listaCliente; 
    private ArrayList listaPersonal;
    
    private int idCliente;
    private int idPersonal;
    
    
    public UsuarioBean() {
        this.usuario = new Usuario();
         listaCliente=new ArrayList();
        listaPersonal=new ArrayList();
        personal=new Personal();
        cliente=new Cliente();
        usuario=new Usuario();
        listarCombos();   
    }
    public  void   listarCombos(){
    ClientesDao  clientesDao=new ClientesDao();
    listaCliente=clientesDao.listClientes();
    PersonalDao  personalDao =new PersonalDao();
    listaPersonal=personalDao.listPersonal();
            
}
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

   

    
    public ArrayList<Usuario> listUsuario() {

        ArrayList<Usuario> list = new ArrayList<>();
        usuariodao = new UsuarioDao();
        list = usuariodao.listUsuario();
        return list;

    }
    
    public String insertUsuario(){
        
        usuariodao = new UsuarioDao();
        respuesta = usuariodao.insertUsuario(usuario);
        if(respuesta){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro insertado con exito", "exito"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/Usuario";
        
    }
    
    public String clean(){
        return "/Usuario";
    }
    
    public String updateUsuario(){
        
        usuariodao = new UsuarioDao();
        respuesta = usuariodao.updateUsuario(usuario);
        if(respuesta){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro actualizado con exito", "exito"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/Usuario";
        
    }
    
    public String deleteUsuario(){
        
        usuariodao = new UsuarioDao();
        respuesta = usuariodao.deleteUsuario(usuario);
        if(respuesta){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro eliminado con exito", "exito"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/Usuario";
        
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

    public UsuarioDao getUsuariodao() {
        return usuariodao;
    }

    public void setUsuariodao(UsuarioDao usuariodao) {
        this.usuariodao = usuariodao;
    }

    public boolean isRespuesta() {
        return respuesta;
    }

    public void setRespuesta(boolean respuesta) {
        this.respuesta = respuesta;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(ArrayList listaCliente) {
        this.listaCliente = listaCliente;
    }

    public ArrayList getListaPersonal() {
        return listaPersonal;
    }

    public void setListaPersonal(ArrayList listaPersonal) {
        this.listaPersonal = listaPersonal;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

}
