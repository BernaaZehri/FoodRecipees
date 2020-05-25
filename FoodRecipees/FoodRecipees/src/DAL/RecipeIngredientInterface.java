/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.RecipeIngredient;
import java.util.List;

/**
 *
 * @author User
 */
public interface RecipeIngredientInterface {

    void create(RecipeIngredient en) throws RecetaException;

    void edit(RecipeIngredient en) throws RecetaException;

    void delete(RecipeIngredient en) throws RecetaException;

    List<RecipeIngredient> findAll() throws RecetaException;

}
