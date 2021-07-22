/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Vuelos;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Zaragoza
 */
@Stateless
@LocalBean
public class VuelosFacade {
    
    @PersistenceContext(unitName = "Evidencia_8-ejbPU")
    private EntityManager em;
    
    public List<Vuelos> findAllTyped() {
        TypedQuery<Vuelos> query;
        query = em.createQuery("SELECT h FROM Vuelos h", Vuelos.class);
        return query.getResultList();
    }
    
    public List<Vuelos> findAllNamed() {
        Query query;
        query = em.createNamedQuery("findVuelos");
        return query.getResultList();
    }
    
    public Vuelos findByNoDeVuelo(int noVuelo) {
        TypedQuery<Vuelos> query;
        query = em.createQuery("SELECT p FROM Vuelos p WHERE p.noVuelo=:noVuelo", Vuelos.class);
        query.setParameter("noVuelo", noVuelo);
        return (Vuelos) query.getSingleResult();
    }
    
    public List <Vuelos> findNoVuelo(int noVuelo) {
        TypedQuery<Vuelos> query;
        query = em.createQuery("SELECT p FROM Vuelos p WHERE p.noVuelo=:noVuelo", Vuelos.class);
        query.setParameter("noVuelo", noVuelo);
        return query.getResultList();
    }
    
    public void insert(Vuelos p) {
        em.persist(p);
    }
    
    public void update(Vuelos p) {
        em.merge(p);
    }
    
    public void delete(Vuelos p) {
        em.remove(em.merge(p));
    }
    
}
