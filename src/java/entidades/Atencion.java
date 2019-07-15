package entidades;
// Generated 12-jul-2019 10:45:07 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Atencion generated by hbm2java
 */
public class Atencion  implements java.io.Serializable {


     private int idAtencion;
     private Mascotaporcliente mascotaporcliente;
     private Personal personal;
     private String fechaAtencion;
     private String date;
     private Date horaAtencion;

    public Atencion() {
    }

    public Atencion(int idAtencion, Mascotaporcliente mascotaporcliente, Personal personal, String fechaAtencion, String date, Date horaAtencion) {
       this.idAtencion = idAtencion;
       this.mascotaporcliente = mascotaporcliente;
       this.personal = personal;
       this.fechaAtencion = fechaAtencion;
       this.date = date;
       this.horaAtencion = horaAtencion;
    }
   
    public int getIdAtencion() {
        return this.idAtencion;
    }
    
    public void setIdAtencion(int idAtencion) {
        this.idAtencion = idAtencion;
    }
    public Mascotaporcliente getMascotaporcliente() {
        return this.mascotaporcliente;
    }
    
    public void setMascotaporcliente(Mascotaporcliente mascotaporcliente) {
        this.mascotaporcliente = mascotaporcliente;
    }
    public Personal getPersonal() {
        return this.personal;
    }
    
    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
    public String getFechaAtencion() {
        return this.fechaAtencion;
    }
    
    public void setFechaAtencion(String fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }
    public String getDate() {
        return this.date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    public Date getHoraAtencion() {
        return this.horaAtencion;
    }
    
    public void setHoraAtencion(Date horaAtencion) {
        this.horaAtencion = horaAtencion;
    }




}

