/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Zaragoza
 */
@Stateless
@LocalBean
public class UsuarioFacade {

    @PersistenceContext(unitName = "Evidencia_8-ejbPU")
    private EntityManager em;
    
    public List<Usuario> findAll(){
        TypedQuery <Usuario> query;
        query = em.createQuery("SELECT h FROM Usuario h", Usuario.class);
        return query.getResultList();
    }
    
    public void insert(Usuario p){
        em.persist(p);
    }
    
    public void update(Usuario p){
        em.merge(p);
    }
    
    public void delete(Usuario p){
        em.remove(em.merge(p));
    }
}
