/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entidades.Usuario;
import java.util.ArrayList;
import org.hibernate.Session;

/**
 *
 * @author PC-JHONROMERO
 */
public interface IUsuario {
    
    public abstract ArrayList<Usuario> listUsuario ();
    
    public abstract boolean insertUsuario (Usuario objUsuario);
    
    public abstract boolean updateUsuario (Usuario objUsuario);
    
    public abstract boolean deleteUsuario (Usuario objUsuario);
    
    
    
  
    
}
