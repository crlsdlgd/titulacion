package ec.edu.uce.titulacion.session;

import ec.edu.uce.titulacion.entidades.Plan;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class PlanFacade extends AbstractFacade<Plan> implements PlanFacadeLocal {

    @EJB
    private PlanFacadeLocal planFacade;

    @PersistenceContext(unitName = "titulacion-ear-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlanFacade() {
        super(Plan.class);
    }

    public void barrerPlanes() {
        List<Plan> lista;
        try {
            System.out.println("-----------------------aaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            Query query = em.createQuery("SELECT p FROM Plan p");
            System.out.println("-----------------------bbbbbbbbbbbbbbbbbbbbbbbbbbbb");
            lista = query.getResultList();
            System.out.println("-----------------------cccccccccccccccccccccccccccc");
            if(!lista.isEmpty()){
                for(int i =0;i<lista.size();i++){
                    System.out.println("------------------"+lista.get(i).getTema().toString());
                }
            }
        } catch (Exception e) {
            System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeee");
            e.printStackTrace();
            System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeee");
        }
    }

    public List<Plan> buscarTodos(){
        
        List<Plan> lista;
        try {
            Query query = em.createQuery("SELECT p FROM Plan p");
            lista=query.getResultList();
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Plan> buscarTodos2(){
        try{
        Query consulta = getEntityManager().createNamedQuery("Plan.findAll");
        List<Plan> lista = consulta.getResultList();
        return lista;
        }catch(Exception e){
            System.out.println("eeeeeeeeeeeeeeeeeee");
            e.printStackTrace();
            System.out.println("eeeeeeeeeeeeeeeeeee");
            return null;
        }
    }
    
}
