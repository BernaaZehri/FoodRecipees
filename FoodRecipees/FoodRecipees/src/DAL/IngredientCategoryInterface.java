/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.IngredientCategory;
import java.util.List;
public interface IngredientCategoryInterface {
    void create(IngredientCategory en) throws RecetaException;
    void edit(IngredientCategory en) throws RecetaException;
    void delete(IngredientCategory en) throws RecetaException;
    List<IngredientCategory> findAll() throws RecetaException;
    IngredientCategory findByID(Integer ID) throws RecetaException;
}