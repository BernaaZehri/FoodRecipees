package DAL;

import BL.Ingredient;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class IngredientRepository extends EntMngClass implements IngredientInterface {

    @Override
    public void create(Ingredient u) throws RecetaException {
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RecetaException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Ingredient u) throws RecetaException {
        try {
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RecetaException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Ingredient u) throws RecetaException {
        try {
            em.getTransaction().begin();
            em.remove(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RecetaException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Ingredient> findAll() throws RecetaException {
        try {
            return em.createNamedQuery("Ingredient.findAll").getResultList();
        } catch (Exception e) {
            throw new RecetaException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Ingredient findByID(Integer ID) throws RecetaException {
        try {
            Query query = em.createQuery("SELECT p FROM Ingredient p WHERE p.ID = :ID");
            query.setParameter("ID", ID);
            return (Ingredient) query.getSingleResult();
        } catch (Exception e) {
            throw new RecetaException("Msg! \n" + e.getMessage());
        }
    }

   

    
}
