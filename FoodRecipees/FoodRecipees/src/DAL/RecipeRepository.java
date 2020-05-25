package DAL;

import BL.Recipe;
import GUI.JournalForm;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaUpdate;

public class RecipeRepository extends EntMngClass implements RecipeInterface {
    
    @Override
    public void create(Recipe u) throws RecetaException {
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RecetaException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Recipe u) throws RecetaException {
        try {
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RecetaException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Recipe u) throws RecetaException {
        try {
            em.getTransaction().begin();
            em.remove(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RecetaException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Recipe> findAll() throws RecetaException {
        try {
            return em.createNamedQuery("Recipe.findAll").getResultList();
        } catch (Exception e) {
            throw new RecetaException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Recipe findByID(Integer ID) throws RecetaException {
        try {
            Query query = em.createQuery("SELECT p FROM Recipe p WHERE p.ID = :ID");
            query.setParameter("ID", ID);
            return (Recipe) query.getSingleResult();
        } catch (Exception e) {
            throw new RecetaException("Msg! \n" + e.getMessage());
        }
    }

    /**
     *
     * @param rating
     * @param title
     * @return
     * @throws RecetaException
     */
    @Override
       public void submitRating() throws RecetaException {
           System.out.println("submitRating test 1");
        try {
              System.out.println("submitRating test 2");
               em.getTransaction().begin();
               em.createNamedQuery("Recipe.addRating");
              // em.createQuery("UPDATE Recipe r SET r.rating = 567 WHERE r.recipeNumber = 1 ");
               em.getTransaction().commit();
              System.out.println("submitRating test 3");
            //query.setParameter("Title",title);
        } catch (Exception e) {
              System.out.println("submitRating test 4");
            throw new RecetaException("Msg! \n" + e.getMessage());
        }
    }  
}
