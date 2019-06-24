/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Clientes;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.IClientes;
import utilitarios.HibernateUtil;

/**
 *
 * @author IVAN
 */
public class ClientesDao implements IClientes {

    private String hql;
    private Query query;
    private Session session;
    private Transaction transaccion;

    @Override
    public ArrayList<Clientes> listClientes() {

        session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Clientes> list = new ArrayList<>();
        hql = " from Clientes";

        try {
            query = session.createQuery(hql);
            list = (ArrayList<Clientes>) query.list();
        } catch (Exception e) {
            System.out.println("Error en ClientesDao.listClientes...!");
        }

        return list;

    }

    @Override
    public boolean insertClientes(Clientes objClientes) {

        boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.save(objClientes);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en ClientesDao.insertClientes...!");
        }

        session.close();
        return respuesta;

    }

    @Override
    public boolean updateClientes(Clientes objClientes) {

        boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.update(objClientes);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en ClientesDao.updateClientes...!");
        }

        session.close();
        return respuesta;

    }

    @Override
    public boolean deleteClientes(Clientes objClientes) {

        boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.delete(objClientes);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en ClientesDao.deleteClientes...!");
        }

        session.close();
        return respuesta;

    }

}
