
package service;

import entidades.Sexo;
import java.util.ArrayList;

/**
 *
 * @author PC-JHONROMERO
 */
public interface ISexo {
    public abstract boolean guardarSexo(Sexo sexo);

    public abstract ArrayList<Sexo> listarSexo();

    public abstract boolean actualizarSexo(Sexo sexo);

    public abstract boolean eliminarSexo(Sexo sexo);
}
