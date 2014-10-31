package edu.ulima.daos;

import edu.ulima.entidades.Tbalumno;
import edu.ulima.entidades.Tbestacionamiento;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class TbalumnoDAO {
    EntityManagerFactory emf = null;
    EntityManager em = null;
    
    public TbalumnoDAO() {
        emf = Persistence.createEntityManagerFactory("PU-1");
        em = emf.createEntityManager();
    }

    public void persist(Tbalumno a) {
        em.getTransaction().begin();
        try{
            em.persist(a);
            em.flush();
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
    }
    
    public Tbalumno login(int id, String password){
        String jpql = "SELECT a FROM Tbalumno a WHERE a.id = ?1 and a.password = ?2";
        Query q = em.createQuery(jpql);
        q.setParameter(1, id);
        q.setParameter(2, password);
        Tbalumno a = (Tbalumno)q.getSingleResult();
        
        return a;
    }
    public void actualizar(Tbalumno a, Tbestacionamiento e){
        TbestacionamientoDAO dao = new TbestacionamientoDAO();
        dao.persist(e);
        
        a.setFkeyestacionamiento(e);
        em.getTransaction().begin();
        em.merge(a);
        em.getTransaction().commit();
        
    }

    
    
    
    
}
