/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mangerBean;

import dao.ClientesDao;
import dao.PersonalDao;
import dao.ReservaCitaDao;
import entidades.Cliente;
import entidades.Personal;
import entidades.Reservacita;

import java.util.ArrayList;
import java.util.LinkedList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import service.IReservaCita;

/**
 *
 * @author PC-JHONROMERO
 */
@ManagedBean
@ViewScoped
public class ReservaCitaBean {

    /*Session session;
    Transaction transaction;*/
    private Reservacita Reservacita;
    private ReservaCitaDao Reservacitadao;
    private boolean respuesta;
    private boolean banderaSelect = false;    
    
    
    private Personal personal;
    private Cliente cliente;
    private ArrayList listaCliente; 
    private ArrayList listaPersonal;
    
    private int idCliente;
    private int idPersonal;
    
    
    public ReservaCitaBean() {
        this.Reservacita = new Reservacita();
         listaCliente=new ArrayList();
        listaPersonal=new ArrayList();
        personal=new Personal();
        cliente=new Cliente();
        Reservacita=new Reservacita();
        listarCombos();   
    }
    public  void   listarCombos(){
    ClientesDao  clientesDao=new ClientesDao();
    listaCliente=clientesDao.listClientes();
    PersonalDao  personalDao =new PersonalDao();
    listaPersonal=personalDao.listPersonal();
            
}
    public Reservacita getReservaCita() {
        return Reservacita;
    }

    public void setReservaCita(Reservacita Reservacita) {
        this.Reservacita = Reservacita;
    }

   

    
    public ArrayList<Reservacita> listReservaCita() {

        ArrayList<Reservacita> list = new ArrayList<>();
        Reservacitadao = new ReservaCitaDao();
        list = Reservacitadao.listReservacita();
        return list;

    }
    
    public String insertReservaCita(){
        
        Reservacitadao = new ReservaCitaDao();
        respuesta = Reservacitadao.insertReservacita(Reservacita);
        if(respuesta){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro insertado con exito", "exito"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/ReservaCita";
        
    }
    
    public String clean(){
        return "/ReservaCita";
    }
    
    public String updateReservaCita(){
        
        Reservacitadao = new ReservaCitaDao();
        respuesta = Reservacitadao.updateReservacita(Reservacita);
        if(respuesta){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro actualizado con exito", "exito"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/ReservaCita";
        
    }
    
    public String deleteReservaCita(){
        
        Reservacitadao = new ReservaCitaDao();
        respuesta = Reservacitadao.deleteReservacita(Reservacita);
        if(respuesta){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro eliminado con exito", "exito"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/ReservaCita";
        
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

    public ReservaCitaDao getReservaCitadao() {
        return Reservacitadao;
    }

    public void setReservaCitadao(ReservaCitaDao Reservacitadao) {
        this.Reservacitadao = Reservacitadao;
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
