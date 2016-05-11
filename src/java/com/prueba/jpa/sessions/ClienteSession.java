/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.jpa.sessions;

import com.prueba.jpa.entities.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;


@Stateless
public class ClienteSession {
     @PersistenceContext
    private EntityManager entityManager;

    public void create(Cliente cliente) {
        entityManager.persist(cliente);
    }

    public void update(Cliente cliente) {
        entityManager.merge(cliente);

    }

    public void remove(Cliente cliente) {
        entityManager.remove(cliente);

    }

    public List<Cliente> findAll() {
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Cliente.class));
        return entityManager.createQuery(cq).getResultList();
    }
}
