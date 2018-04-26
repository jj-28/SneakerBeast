/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbp.db;

import sbp.api.Sneaker;

import io.dropwizard.hibernate.AbstractDAO;
import java.util.List;
import jersey.repackaged.com.google.common.base.Optional;
import org.hibernate.SessionFactory;
/**
 *
 * @author Jeffrey
 */
public class SneakerDAO extends AbstractDAO<Sneaker> {
    
    public SneakerDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    
    public Sneaker create(Sneaker sneaker) {
        return persist(sneaker);
    }
    public List<Sneaker>getAllSneakers() {
        return (List<Sneaker>) currentSession().createCriteria(Sneaker.class).list();
    }
   public Sneaker findById(Long id) {
        return get(id);
    }
   public void delete(Sneaker s){
        currentSession().delete(s);
}
}
