/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Estados;
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
public class EstadosFacade {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext(unitName = "Evidencia_8-ejbPU")
    private EntityManager em;
    
    public List<Estados> findAllTyped() {
        TypedQuery <Estados> query;
        query = em.createQuery("SELECT h FROM Estados h", Estados.class);
        return query.getResultList();
    }
    
    public List<Estados> findAllNamed() {
        Query query;
        query = em.createNamedQuery("findEstados");
        return query.getResultList();
    }
    
    public void insert(Estados p){
        em.persist(p);
    }
    
    public void update(Estados p){
        em.merge(p);
    }
    
    public void delete(Estados p){
        em.remove(em.merge(p));
    }
    
    public Estados find(Long id){
        return em.find(Estados.class, id);
    }
}
