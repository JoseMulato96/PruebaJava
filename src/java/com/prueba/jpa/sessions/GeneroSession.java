/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.jpa.sessions;

import com.prueba.jpa.entities.Genero;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;


@Stateless
public class GeneroSession {
     @PersistenceContext
    private EntityManager entityManager;

    public void create(Genero genero) {
        entityManager.persist(genero);
    }

    public void update(Genero genero) {
        entityManager.merge(genero);

    }

    public void remove(Genero genero) {
        entityManager.remove(genero);

    }

    public List<Genero> findAll() {
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Genero.class));
        return entityManager.createQuery(cq).getResultList();
    }
}
