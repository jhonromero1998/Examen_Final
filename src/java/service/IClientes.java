package service;

import entidades.Clientes;
import java.util.ArrayList;

/**
 *
 * @author IVAN
 */
public interface IClientes {
    
    public abstract ArrayList<Clientes> listClientes ();
    
    public abstract boolean insertClientes (Clientes objClientes);
    
    public abstract boolean updateClientes (Clientes objClientes);
    
    public abstract boolean deleteClientes (Clientes objClientes);
    
}
