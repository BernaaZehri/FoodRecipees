package DAL;

import BL.RecipeCategory;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class RecipeCategoryRepository extends EntMngClass implements RecipeCategoryInterface {

    @Override
    public void create(RecipeCategory u) throws RecetaException {
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RecetaException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(RecipeCategory u) throws RecetaException {
        try {
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RecetaException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(RecipeCategory u) throws RecetaException {
        try {
            em.getTransaction().begin();
            em.remove(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RecetaException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<RecipeCategory> findAll() throws RecetaException {
        try {
            return em.createNamedQuery("RecipeCategory.findAll").getResultList();
        } catch (Exception e) {
            throw new RecetaException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public RecipeCategory findByID(Integer ID) throws RecetaException {
        try {
            Query query = em.createQuery("SELECT p FROM RecipeCategory p WHERE p.ID = :ID");
            query.setParameter("ID", ID);
            return (RecipeCategory) query.getSingleResult();
        } catch (Exception e) {
            throw new RecetaException("Msg! \n" + e.getMessage());
        }
    }

   

    
}