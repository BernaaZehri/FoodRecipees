package DAL;

import BL.Useri;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class UserRepository extends EntMngClass implements UserInterface {

    @Override
    public void create(Useri u) throws RecetaException {
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RecetaException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Useri u) throws RecetaException {
        try {
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RecetaException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Useri u) throws RecetaException {
        try {
            em.getTransaction().begin();
            em.remove(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RecetaException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Useri> findAll() throws RecetaException {
        try {
            return em.createNamedQuery("Useri.findAll").getResultList();
        } catch (Exception e) {
            throw new RecetaException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Useri findByID(Integer ID) throws RecetaException {
        try {
            Query query = em.createQuery("SELECT p FROM Useri p WHERE p.ID = :ID");
            query.setParameter("ID", ID);
            return (Useri) query.getSingleResult();
        } catch (Exception e) {
            throw new RecetaException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Useri loginByUsernameAndPassword(String u, String p) throws RecetaException {
        try {
            Query query
                    = em.createQuery("SELECT p FROM Useri p WHERE p.username = :us AND p.password= :psw");
            query.setParameter("us", u);
            query.setParameter("psw", p);
            return (Useri) query.getSingleResult();
        } catch (Exception e) {
            throw new RecetaException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public boolean isRegistered(String username, String email) throws RecetaException {
        try {
            Query query
                    = em.createQuery("SELECT p FROM Useri p WHERE p.username = :us OR p.email= :em");
            query.setParameter("us", username);
            query.setParameter("em", email);
            try{
                 query.getSingleResult();
            }catch(NoResultException nre) {
                return false;
            }
            
           
        } catch (Exception e) {
            throw new RecetaException("Msg! \n" + e.getMessage());
        }
        return true;
    }
    
    public String toString(Useri u){
        return  " UserId" + u.getUserID();
    }
}
    
    
   