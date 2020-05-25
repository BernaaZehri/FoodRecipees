/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.Recipe;
import java.util.List;
public interface RecipeInterface {
    void create(Recipe en) throws RecetaException;
    void edit(Recipe en) throws RecetaException;
    void delete(Recipe en) throws RecetaException;
    List<Recipe> findAll() throws RecetaException;
    Recipe findByID(Integer ID) throws RecetaException;
    void submitRating() throws RecetaException;
}