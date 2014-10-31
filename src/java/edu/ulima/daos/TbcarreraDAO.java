package edu.ulima.daos;

import edu.ulima.entidades.Tbcarrera;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TbcarreraDAO {
    EntityManagerFactory emf = null;
    EntityManager em = null;
    
    public TbcarreraDAO() {
        emf = Persistence.createEntityManagerFactory("PU-1");
        em = emf.createEntityManager();
    }
    
    public List<Tbcarrera> retornarTodos(){
        Query q = em.createNamedQuery("Tbcarrera.findAll");
        List<Tbcarrera> li = q.getResultList();
        return li;
    }
    
    public Tbcarrera retornarEspecifico(int pkeycarrera){
        Query q = em.createNamedQuery("Tbcarrera.findByPkeycarrera");
        q.setParameter("pkeycarrera", pkeycarrera);
        Tbcarrera c = (Tbcarrera)q.getSingleResult();
        return c;
    }
    
}
