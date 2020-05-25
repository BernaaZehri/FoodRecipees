package DAL;

import BL.UnitDetails;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class UnitDetailsRepository extends EntMngClass implements UnitDetailsInterface {

    @Override
    public void create(UnitDetails u) throws RecetaException {
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RecetaException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(UnitDetails u) throws RecetaException {
        try {
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RecetaException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(UnitDetails u) throws RecetaException {
        try {
            em.getTransaction().begin();
            em.remove(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RecetaException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<UnitDetails> findAll() throws RecetaException {
        try {
            return em.createNamedQuery("UnitDetails.findAll").getResultList();
        } catch (Exception e) {
            throw new RecetaException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public UnitDetails findByID(Integer ID) throws RecetaException {
        try {
            Query query = em.createQuery("SELECT p FROM UnitDetails p WHERE p.ID = :ID");
            query.setParameter("ID", ID);
            return (UnitDetails) query.getSingleResult();
        } catch (Exception e) {
            throw new RecetaException("Msg! \n" + e.getMessage());
        }
    }

   

    
}
