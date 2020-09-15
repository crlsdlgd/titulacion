/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uce.titulacion.session;

import ec.edu.uce.titulacion.entidades.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Eilfil
 */
@Local
public interface UsuarioFacadeLocal {

    void create(Usuario usuario);

    void edit(Usuario usuario);

    void remove(Usuario usuario);

    Usuario find(Object id);
    
    Usuario buscarUsuarioLogin(String nick, String pass);

    List<Usuario> findAll();

    List<Usuario> findRange(int[] range);

    int count();
    
}
