/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.Ingredient;
import java.util.List;
public interface IngredientInterface {
    void create(Ingredient en) throws RecetaException;
    void edit(Ingredient en) throws RecetaException;
    void delete(Ingredient en) throws RecetaException;
    List<Ingredient> findAll() throws RecetaException;
    Ingredient findByID(Integer ID) throws RecetaException;
}