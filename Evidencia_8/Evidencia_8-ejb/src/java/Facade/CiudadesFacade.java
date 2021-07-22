/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Ciudades;
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
public class CiudadesFacade {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext(unitName = "Evidencia_8-ejbPU")
    private EntityManager em;
    
    public List<Ciudades> finAllTyped() {
        TypedQuery <Ciudades> query;
        query = em.createQuery("SELECT h FROM Ciudades h", Ciudades.class);
        return query.getResultList();
    }
    
    public List<Ciudades> findAllNamed() {
        Query query;
        query = em.createNamedQuery("findAviones");
        return query.getResultList();
    }
    
    public List <Ciudades> findNombre(String nombre, Long estado) {
        TypedQuery <Ciudades> query;
        query = em.createQuery("SELECT p FROM Ciudades p WHERE UPPER(p.nombre)=:nombre AND p.estado.id=:estado", Ciudades.class);
        query.setParameter("nombre", nombre.toUpperCase());
        query.setParameter("estado", estado);
        return query.getResultList();
    }
    
    public Ciudades findByEstado(String estado) {
        TypedQuery <Ciudades> query;
        query = em.createQuery("SELECT p FROM Ciudades p WHERE p.estado.id=:estado", Ciudades.class);
        query.setParameter("estado", estado);
        return query.getSingleResult();
    }
    
    public List <Ciudades> findEstado(Long estado) {
        TypedQuery <Ciudades> query;
        query = em.createQuery("SELECT p FROM Ciudades p WHERE p.estado.id=:estado", Ciudades.class);
        query.setParameter("estado", estado);
        return query.getResultList();
    }
    
    public Ciudades findByPais(String pais) {
        Query query;
        query = em.createNamedQuery("findByPais");
        query.setParameter("pais", pais);
        return (Ciudades) query.getSingleResult();
    }
    
    public void insert(Ciudades p){
        em.persist(p);
    }
    
    public void update(Ciudades p){
        em.merge(p);
    }
    
    public void delete(Ciudades p){
        em.remove(em.merge(p));
    }
    
    public Ciudades find(Long id){
        return em.find(Ciudades.class, id);
    }
}
