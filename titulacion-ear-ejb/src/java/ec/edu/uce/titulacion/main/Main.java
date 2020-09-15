
package ec.edu.uce.titulacion.main;

import ec.edu.uce.titulacion.session.PlanFacade;
import ec.edu.uce.titulacion.utilities.SendMailGmail;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class Main {

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init){
               
        System.out.println("--------------<<<<<Hola a todos!!!<<<<<<<<<<<<");
        
        //SendMailGmail correoTexto = new SendMailGmail();
        //correoTexto.enviarMail();
        
        //PlanFacade plan = new PlanFacade();
        //plan.barrerPlanes();
        
    }
    
}
