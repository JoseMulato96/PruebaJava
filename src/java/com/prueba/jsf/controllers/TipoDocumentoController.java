
package com.prueba.jsf.controllers;

import com.prueba.jpa.entities.TipoDocumento;
import com.prueba.jpa.sessions.TipoDocumentoSession;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class TipoDocumentoController implements Serializable {
    @EJB
    
    private TipoDocumentoSession tipodocumentoSession;
    private TipoDocumento selectedTipoDocumento;
    private List<TipoDocumento> ListTipoDocumento;
    
    
     public void create (){
        
        getTipoDocumentoSession().create(selectedTipoDocumento);
        selectedTipoDocumento = getSelectedTipoDocumento();
    }

    public TipoDocumentoSession getTipoDocumentoSession() {
        return tipodocumentoSession;
    }

    public void setTipoDocumentoSession(TipoDocumentoSession tipodocumentoSession) {
        this.tipodocumentoSession = tipodocumentoSession;
    }

    public TipoDocumento getSelectedTipoDocumento() {
        if(selectedTipoDocumento==null){
            selectedTipoDocumento=new TipoDocumento();
        }
    
        return selectedTipoDocumento;
    }

    public void setSelectedTipoDocumento(TipoDocumento selectedTipoDocumento) {
        this.selectedTipoDocumento = selectedTipoDocumento;
    }

    public List<TipoDocumento> getListTipoDocumento() {
            if(ListTipoDocumento==null){
                ListTipoDocumento=getTipoDocumentoSession().findAll();
            }
        return ListTipoDocumento;
    }

    public void setListTipoDocumento(List<TipoDocumento> ListTipoDocumento) {
        this.ListTipoDocumento = ListTipoDocumento;
    }
}
