package DAL;

import BL.PreparationWay;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class PreparationWayRepository extends EntMngClass implements PreparationWayInterface {

    @Override
    public void create(PreparationWay u) throws RecetaException {
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RecetaException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(PreparationWay u) throws RecetaException {
        try {
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RecetaException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(PreparationWay u) throws RecetaException {
        try {
            em.getTransaction().begin();
            em.remove(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RecetaException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<PreparationWay> findAll() throws RecetaException {
        try {
            return em.createNamedQuery("PreparationWay.findAll").getResultList();
        } catch (Exception e) {
            throw new RecetaException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public PreparationWay findByID(Integer ID) throws RecetaException {
        try {
            Query query = em.createQuery("SELECT p FROM PreparationWay p WHERE p.ID = :ID");
            query.setParameter("ID", ID);
            return (PreparationWay) query.getSingleResult();
        } catch (Exception e) {
            throw new RecetaException("Msg! \n" + e.getMessage());
        }
    }

   

    
}
