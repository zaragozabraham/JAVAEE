/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Paises;
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
public class PaisesFacade {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext(unitName = "Evidencia_8-ejbPU")
    private EntityManager em;
    
    public List<Paises> findAllTyped() {
        TypedQuery <Paises> query;
        query = em.createQuery("SELECT h FROM Paises h", Paises.class);
        return query.getResultList();
    }
    
    public List<Paises> findAllNamed() {
        Query query;
        query = em.createNamedQuery("findPaises");
        return query.getResultList();
    }
    
    public Paises findByName(String nombre) {
        Query query;
        query = em.createNamedQuery("findByName");
        query.setParameter("nombre", nombre);
        return (Paises) query.getSingleResult();
    }
    
    public void insert(Paises p){
        em.persist(p);
    }
    
    public void update(Paises p){
        em.merge(p);
    }
    
    public void delete(Paises p){
        em.remove(em.merge(p));
    }
    
    public Paises find(Long id){
        return em.find(Paises.class, id);
    }
}
