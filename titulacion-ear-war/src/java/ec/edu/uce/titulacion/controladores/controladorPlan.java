package ec.edu.uce.titulacion.controladores;

import ec.edu.uce.titulacion.entidades.Plan;
import ec.edu.uce.titulacion.session.PlanFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "controladorPlan")
@SessionScoped
public class controladorPlan implements Serializable {

    @EJB
    private PlanFacadeLocal planFacade;
    
    private List<Plan> listaPlan;
    
    private String usuariosPlan;

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    private String tema;
    private Date fecha;

    public String getUsuariosPlan() {
        return usuariosPlan;
    }

    public void setUsuariosPlan(String usuariosPlan) {
        this.usuariosPlan = usuariosPlan;
    }
    

    public List<Plan> getListaPlan() {
        return listaPlan;
    }

    public void setListaPlan(List<Plan> listaPlan) {
        this.listaPlan = listaPlan;
    }

    public controladorPlan() {
    }
    
    @PostConstruct
    public void init(){
        System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        cargarPlan();
        //mostrarPlan();
    }

    public void cargarPlan() {
        listaPlan=planFacade.findAll();  
        mostrarPlan();
        
//        for(int i=0;i<listaPlan.size();i++){
//            for(int j=0;j<listaPlan.get(i).getUsuarioList().size();j++){
//                usuariosPlan+=listaPlan.get(i).getUsuarioList().get(j).getNombre()+", ";
//            }
//        }
//        System.out.println("lista de usuarios "+usuariosPlan);
    }

    public void mostrarPlan() {
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaas");
        
        if(listaPlan.size()<0){
            System.out.println("No hay planes");
        }else{
            for(int i=0;i<listaPlan.size();i++){
                System.out.println("cccccccccccccccccccccccc");
                System.out.println(listaPlan.get(i).getUsuarioList().size());
                System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
                for(int j=0;j<listaPlan.get(i).getUsuarioList().size();j++){
                    System.out.println("dddddddddddddddddddddddddddd"+listaPlan.get(i).getUsuarioList().size());
                    System.out.println(listaPlan.get(i).getUsuarioList().get(j).getNombre());
                }
            }
        }
    }
    
    public void guardarPlan(){
        Plan p = new Plan();
        p.setTema(tema);
        p.setFecha(fecha);
        planFacade.create(p);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Plan creado correctamente.", null));
    }
    
}
