/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Usuario;
import service.IUsuario;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilitarios.HibernateUtil;

/**
 *
 * @author PC-JHONROMERO
 */
public class UsuarioDao implements IUsuario {

    private String hql;
    private Query query;
    private Session session;
    private Transaction transaccion;

    @Override
    public ArrayList<Usuario> listUsuario() {

        session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Usuario> list = new ArrayList<>();
        hql = " from Usuario";

        query = session.createQuery(hql);
        list = (ArrayList<Usuario>) query.list();

        session.close();
        return list;

    }

    @Override
    public boolean insertUsuario(Usuario objUsuario) {

        boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.save(objUsuario);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en Usuariodao.insertUsuario...!");
        }

        session.close();
        return respuesta;

    }

    @Override
    public boolean updateUsuario(Usuario objUsuario) {

        boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.update(objUsuario);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en Usuariodao.updateUsuario...!");
        }

        session.close();
        return respuesta;

    }

    @Override
    public boolean deleteUsuario(Usuario objUsuario) {
        
        boolean respuesta = true;
        session = HibernateUtil.getSessionFactory().openSession();
        transaccion = session.beginTransaction();
        try {
            session.delete(objUsuario);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("Error en Usuariodao.deleteUsuario...!");
        }

        session.close();
        return respuesta;
        
    }

    


}
