package DAL;

import BL.RecipeType;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class RecipeTypeRepository extends EntMngClass implements RecipeTypeInterface {

    @Override
    public void create(RecipeType u) throws RecetaException {
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RecetaException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(RecipeType u) throws RecetaException {
        try {
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RecetaException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(RecipeType u) throws RecetaException {
        try {
            em.getTransaction().begin();
            em.remove(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RecetaException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<RecipeType> findAll() throws RecetaException {
        try {
            return em.createNamedQuery("RecipeType.findAll").getResultList();
        } catch (Exception e) {
            throw new RecetaException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public RecipeType findByID(Integer ID) throws RecetaException {
        try {
            Query query = em.createQuery("SELECT p FROM RecipeType p WHERE p.ID = :ID");
            query.setParameter("ID", ID);
            return (RecipeType) query.getSingleResult();
        } catch (Exception e) {
            throw new RecetaException("Msg! \n" + e.getMessage());
        }
    }

   

    
}
