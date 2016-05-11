
package com.prueba.jsf.controllers;

import com.prueba.jpa.entities.Cliente;
import com.prueba.jpa.sessions.ClienteSession;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class ClienteController implements Serializable {
    
 @EJB
    
    private ClienteSession clienteSession;
    private Cliente selectedCliente;
    private List<Cliente> ListCliente;
    
    
     public void create (){
        
        getClienteSession().create(selectedCliente);
        selectedCliente = getSelectedCliente();
    }

    public ClienteSession getClienteSession() {
        return clienteSession;
    }

    public void setClienteSession(ClienteSession clienteSession) {
        this.clienteSession = clienteSession;
    }

    public Cliente getSelectedCliente() {
        if(selectedCliente==null){
            selectedCliente=new Cliente();
        }
    
        return selectedCliente;
    }

    public void setSelectedCliente(Cliente selectedCliente) {
        this.selectedCliente = selectedCliente;
    }

    public List<Cliente> getListCliente() {
            if(ListCliente==null){
                ListCliente=getClienteSession().findAll();
            }
        return ListCliente;
    }

    public void setListCliente(List<Cliente> ListCliente) {
        this.ListCliente = ListCliente;
    }
}