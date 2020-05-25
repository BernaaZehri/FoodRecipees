/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.RecipeCategory;
import java.util.List;
public interface RecipeCategoryInterface {
    void create(RecipeCategory en) throws RecetaException;
    void edit(RecipeCategory en) throws RecetaException;
    void delete(RecipeCategory en) throws RecetaException;
    List<RecipeCategory> findAll() throws RecetaException;
    RecipeCategory findByID(Integer ID) throws RecetaException;
}