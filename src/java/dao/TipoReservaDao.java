/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Tiporeserva;
import service.ITipoReserva;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilitarios.HibernateUtil;

/**
 *
 * @author PC-JHONROMERO
 */
public class TipoReservaDao implements ITipoReserva {

    private String hql;
    private Query query;
    private Session session;
    private Transaction transaccion;

    @Override
    public ArrayList<Tiporeserva> listTiporeserva() {

        session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Tiporeserva> list = new ArrayList<>();
        hql = " from Tiporeserva";

        query = session.createQuery(hql);
        list = (ArrayList<Tiporeserva>) query.list();

        session.close();
        return list;

    }

    @Override
    public boolean insertTiporeserva(Tiporeserva objTiporeserva) {

        boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.save(objTiporeserva);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en Tiporeservadao.insertTiporeserva...!");
        }

        session.close();
        return respuesta;

    }

    @Override
    public boolean updateTiporeserva(Tiporeserva objTiporeserva) {

        boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.update(objTiporeserva);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en Tiporeservadao.updateTiporeserva...!");
        }

        session.close();
        return respuesta;

    }

    @Override
    public boolean deleteTiporeserva(Tiporeserva objTiporeserva) {
        
        boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.delete(objTiporeserva);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en Tiporeservadao.deleteTiporeserva...!");
        }

        session.close();
        return respuesta;
        
    }

    


}
