package ec.edu.uce.titulacion.session;

import ec.edu.uce.titulacion.entidades.Plan;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
    public void barrerPlanes(){
        Date fechaPlan;
        Date fechaActual=new Date();
        System.out.println("asdasdasd");
        //List<Plan> listaPlan = this.findAll();
        List<Plan> listaPlan = planFacade.findAll();
        System.out.println("lkjlkjlkj");
        for(int i=0;i<listaPlan.size();i++){
            fechaPlan=listaPlan.get(i).getFecha();
            System.out.println("-------------------->>>>>>>>>>>>"+fechaActual.compareTo(fechaPlan)+"-------------------->>>>>>>>>>>>");
            if(fechaActual.compareTo(fechaPlan)>0){
                System.out.println("-------------------->>>>>>>>>>>>"+fechaActual.compareTo(fechaPlan));
            }
        }
    }
    
}
