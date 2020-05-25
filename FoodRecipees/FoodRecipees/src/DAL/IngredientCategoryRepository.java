package DAL;

import BL.IngredientCategory;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class IngredientCategoryRepository extends EntMngClass implements IngredientCategoryInterface {

    @Override
    public void create(IngredientCategory u) throws RecetaException {
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RecetaException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(IngredientCategory u) throws RecetaException {
        try {
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RecetaException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(IngredientCategory u) throws RecetaException {
        try {
            em.getTransaction().begin();
            em.remove(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RecetaException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<IngredientCategory> findAll() throws RecetaException {
        try {
            return em.createNamedQuery("IngredientCategory.findAll").getResultList();
        } catch (Exception e) {
            throw new RecetaException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public IngredientCategory findByID(Integer ID) throws RecetaException {
        try {
            Query query = em.createQuery("SELECT p FROM IngredientCategory p WHERE p.ID = :ID");
            query.setParameter("ID", ID);
            return (IngredientCategory) query.getSingleResult();
        } catch (Exception e) {
            throw new RecetaException("Msg! \n" + e.getMessage());
        }
    }

   

    
}
