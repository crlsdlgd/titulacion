
package ec.edu.uce.titulacion.main;

import ec.edu.uce.titulacion.entidades.Plan;
import ec.edu.uce.titulacion.session.PlanFacadeLocal;
import ec.edu.uce.titulacion.utilities.SendMailGmail;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class Main {

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init){
               
        System.out.println("--------------<<<<<Hola a todos!!!<<<<<<<<<<<<");
        
        //SendMailGmail correoTexto = new SendMailGmail();
        //correoTexto.enviarMail();
     
        PlanFacadeLocal plan = null;
        //plan.barrerPlanes();
        List<Plan> lista= plan.findAll();
        
        if(lista==null){
            System.out.println("----------Lista nula-------");
        }else if(lista.isEmpty()){
            System.out.println("----------Lista vacia-------");
        }else{
            System.out.println("----------Lista con datos-------");
            for(int i=0;i<lista.size();i++){
                System.out.println(lista.get(i).getTema());
            }
        }
    }
    
}
