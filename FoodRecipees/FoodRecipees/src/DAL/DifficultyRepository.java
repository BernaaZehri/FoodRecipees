package DAL;

import BL.Difficulty;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class DifficultyRepository extends EntMngClass implements DifficultyInterface {

    @Override
    public void create(Difficulty u) throws RecetaException {
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RecetaException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Difficulty u) throws RecetaException {
        try {
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RecetaException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Difficulty u) throws RecetaException {
        try {
            em.getTransaction().begin();
            em.remove(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RecetaException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Difficulty> findAll() throws RecetaException {
        try {
            return em.createNamedQuery("Difficulty.findAll").getResultList();
        } catch (Exception e) {
            throw new RecetaException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Difficulty findByID(Integer ID) throws RecetaException {
        try {
            Query query = em.createQuery("SELECT p FROM Difficulty p WHERE p.ID = :ID");
            query.setParameter("ID", ID);
            return (Difficulty) query.getSingleResult();
        } catch (Exception e) {
            throw new RecetaException("Msg! \n" + e.getMessage());
        }
    }

   

    
}
