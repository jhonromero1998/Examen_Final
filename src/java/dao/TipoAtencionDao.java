/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Tipoatencion;
import service.ITipoAtencion;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilitarios.HibernateUtil;

/**
 *
 * @author PC-JHONROMERO
 */
public class TipoAtencionDao implements ITipoAtencion {

    private String hql;
    private Query query;
    private Session session;
    private Transaction transaccion;

    @Override
    public ArrayList<Tipoatencion> listTipoatencion() {

        session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Tipoatencion> list = new ArrayList<>();
        hql = " from Tipoatencion";

        query = session.createQuery(hql);
        list = (ArrayList<Tipoatencion>) query.list();

        session.close();
        return list;

    }

    @Override
    public boolean insertTipoatencion(Tipoatencion objTipoatencion) {

        boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.save(objTipoatencion);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en Tipoatenciondao.insertTipoatencion...!");
        }

        session.close();
        return respuesta;

    }

    @Override
    public boolean updateTipoatencion(Tipoatencion objTipoatencion) {

        boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.update(objTipoatencion);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en Tipoatenciondao.updateTipoatencion...!");
        }

        session.close();
        return respuesta;

    }

    @Override
    public boolean deleteTipoatencion(Tipoatencion objTipoatencion) {
        
        boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.delete(objTipoatencion);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en Tipoatenciondao.deleteTipoatencion...!");
        }

        session.close();
        return respuesta;
        
    }

    


}
