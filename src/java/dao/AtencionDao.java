/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Atencion;
import service.IAtencion;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilitarios.HibernateUtil;

/**
 *
 * @author PC-JHONROMERO
 */
public class AtencionDao implements IAtencion {

    private String hql;
    private Query query;
    private Session session;
    private Transaction transaccion;

    @Override
    public ArrayList<Atencion> listAtencion() {

        session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Atencion> list = new ArrayList<>();
        hql = " from Atencion";

        query = session.createQuery(hql);
        list = (ArrayList<Atencion>) query.list();

        session.close();
        return list;

    }

    @Override
    public boolean insertAtencion(Atencion objAtencion) {

        boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.save(objAtencion);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en Atenciondao.insertAtencion...!");
        }

        session.close();
        return respuesta;

    }

    @Override
    public boolean updateAtencion(Atencion objAtencion) {

        boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.update(objAtencion);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en Atenciondao.updateAtencion...!");
        }

        session.close();
        return respuesta;

    }

    @Override
    public boolean deleteAtencion(Atencion objAtencion) {
        
        boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.delete(objAtencion);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en Atenciondao.deleteAtencion...!");
        }

        session.close();
        return respuesta;
        
    }

    


}
