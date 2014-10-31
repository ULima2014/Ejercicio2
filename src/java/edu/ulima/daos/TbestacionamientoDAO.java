package edu.ulima.daos;

import edu.ulima.entidades.Tbestacionamiento;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TbestacionamientoDAO {
    EntityManagerFactory emf = null;
    EntityManager em = null;
    
    public TbestacionamientoDAO(){
        emf = Persistence.createEntityManagerFactory("PU-1");
        em = emf.createEntityManager();
    }
    public void persist(Tbestacionamiento e) {
        em.getTransaction().begin();
        try{
            em.persist(e);
            em.flush();
            em.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
    }
}
