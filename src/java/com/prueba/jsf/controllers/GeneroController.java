
package com.prueba.jsf.controllers;

import com.prueba.jpa.entities.Genero;
import com.prueba.jpa.sessions.GeneroSession;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class GeneroController implements Serializable {
@EJB
    
    private GeneroSession generoSession;
    private Genero selectedGenero;
    private List<Genero> ListGenero;
    
    
     public void create (){
        
        getGeneroSessions().create(selectedGenero);
        selectedGenero = getSelectedGenero();
    }

    public GeneroSession getGeneroSessions() {
        return generoSession;
    }

    public void setGeneroSessions(GeneroSession generoSessions) {
        this.generoSession = generoSessions;
    }

    public Genero getSelectedGenero() {
        if(selectedGenero==null){
            selectedGenero=new Genero();
        }
    
        return selectedGenero;
    }

    public void setSelectedGenero(Genero selectedGenero) {
        this.selectedGenero = selectedGenero;
    }

    public List<Genero> getListGenero() {
            if(ListGenero==null){
                ListGenero=getGeneroSessions().findAll();
            }
        return ListGenero;
    }

    public void setListGenero(List<Genero> ListGenero) {
        this.ListGenero = ListGenero;
    }
}