/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Aviones;
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
public class AvionesFacade {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext(unitName = "Evidencia_8-ejbPU")
    private EntityManager em;
    
    public List<Aviones> findAllTyped(){
        TypedQuery <Aviones> query;
        query = em.createQuery("Select h from Aviones h", Aviones.class);
        return query.getResultList();
    }
    
    public List<Aviones> fineAllNamed() {
        Query query;
        query = em.createNamedQuery("findAviones");
        return query.getResultList();
    }
    
    public Aviones findBynoDeAvion(int noDeAvion) {
        TypedQuery <Aviones> query;
        query = em.createQuery("SELECT p FROM Aviones p WHERE p.noDeAvion=:noDeAvion", Aviones.class);
        query.setParameter("noDeAvion", noDeAvion);
        return query.getSingleResult();
    }
    
    public List <Aviones> findNoAvion(int noDeAvion) {
        TypedQuery <Aviones> query;
        query = em.createQuery("SELECT p FROM Aviones p WHERE p.noDeAvion=:noDeAvion", Aviones.class);
        query.setParameter("noDeAvion", noDeAvion);
        return query.getResultList();
    }
    
    public Aviones findByNoyCapacidad(int noDeAvion, int capacidad) {
        Query query;
        query = em.createNamedQuery("findNoDeAvion");
        query.setParameter("noDeAvion", noDeAvion);
        query.setParameter("capacidad", capacidad);
        return (Aviones) query.getSingleResult();
    }
    
    public void insert(Aviones p){
        em.persist(p);
    }
    
    public void update(Aviones p){
        em.merge(p);
    }
    
    public void delete(Aviones p){
        em.remove(em.merge(p));
    }
    
    public Aviones find(Long id){
        return em.find(Aviones.class, id);
    }
    
}
