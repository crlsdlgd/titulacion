/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uce.titulacion.session;

import ec.edu.uce.titulacion.entidades.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
//import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Eilfil
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "titulacion-ear-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public Usuario buscarUsuarioLogin(String nick, String pass) {
        List<Usuario> lista;
        try {
            String query = "select u from Usuario u where u.nick = :nick and u.password = :password";
            Query consulta = getEntityManager().createQuery(query);
            consulta.setParameter("nick", nick);
            consulta.setParameter("password", pass);
            //consulta.setParameter(2, DigestUtils.md5Hex(password));

            lista = consulta.getResultList();

            if (lista.isEmpty()) {
                return null;
            }
            return lista.get(0);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    @Override
    public List<Usuario> findByPlan() {
        List<Usuario> lista;
        try {
            String query = "select u from Usuario u, Plan p, plan_usuario pu\n" +
                            "where u.id_usuario = pu.id_usuario and\n" +
                            "pu.id_plan=p.id_plan and p.id_plan=:id_plan";
        } catch (Exception e) {
        }

    }

}
