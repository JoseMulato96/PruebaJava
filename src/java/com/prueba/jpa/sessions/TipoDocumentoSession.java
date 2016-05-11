/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.jpa.sessions;

import com.prueba.jpa.entities.TipoDocumento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class TipoDocumentoSession {
     @PersistenceContext
    private EntityManager entityManager;

    public void create(TipoDocumento tipodocumento) {
        entityManager.persist(tipodocumento);
    }

    public void update(TipoDocumento tipodocumento) {
        entityManager.merge(tipodocumento);

    }

    public void remove(TipoDocumento tipodocumento) {
        entityManager.remove(tipodocumento);

    }

    public List<TipoDocumento> findAll() {
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(TipoDocumento.class));
        return entityManager.createQuery(cq).getResultList();
    }
}
