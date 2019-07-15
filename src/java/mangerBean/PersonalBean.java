package mangerBean;

import dao.PersonalDao;
import entidades.Personal;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author PC-JHONROMERO
 */
@ManagedBean
@ViewScoped
public class PersonalBean {

    private Personal personal;
    private PersonalDao personalDao;
    private boolean respuesta;

    public PersonalBean() {
        this.personal = new Personal();
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public ArrayList<Personal> listPersonal() {

        ArrayList<Personal> list = new ArrayList<>();
        personalDao = new PersonalDao();
        list = personalDao.listPersonal();
        return list;

    }

    public String insertPersonal() {

        personalDao = new PersonalDao();
        respuesta = personalDao.insertPersonal(personal);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro insertado con exito", "exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/Personal";

    }

    public String clean() {
        return "/Personal";
    }

    public String updatePersonal() {

        personalDao = new PersonalDao();
        respuesta = personalDao.updatePersonal(personal);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro actualizado con exito", "exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/Personal";

    }

    public String deletePersonal(Personal personal) {

        personalDao = new PersonalDao();
        respuesta = personalDao.deletePersonal(personal);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro eliminado con exito", "exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/Personal";

    }

}
