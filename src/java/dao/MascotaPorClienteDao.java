/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Mascotaporcliente;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.IMascotaPorCliente;
import utilitarios.HibernateUtil;

/**
 *
 * @author PC-JHONROMERO
 */
public class MascotaPorClienteDao implements IMascotaPorCliente {

    private String hql;
    private Query query;
    private Session session;
    private Transaction transaccion;

    @Override
    public ArrayList<Mascotaporcliente> listMascotaporcliente() {

        session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Mascotaporcliente> list;
        hql = " from Cliente";

        query = session.createQuery(hql);
        list = (ArrayList<Mascotaporcliente>) query.list();

        session.close();
        return list;
    }

    @Override
    public boolean insertMascotaporcliente(Mascotaporcliente objMascotaporcliente) {

        boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.save(objMascotaporcliente);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en MascotaPorClienteDao.insertMascotaporcliente...!");
        }

        session.close();
        return respuesta;

    }

    @Override
    public boolean updateMascotaporcliente(Mascotaporcliente objMascotaporcliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteMascotaporcliente(Mascotaporcliente objMascotaporcliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
