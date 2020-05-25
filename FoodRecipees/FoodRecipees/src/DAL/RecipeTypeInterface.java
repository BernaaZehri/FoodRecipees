/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.RecipeType;
import java.util.List;
public interface RecipeTypeInterface {
    void create(RecipeType en) throws RecetaException;
    void edit(RecipeType en) throws RecetaException;
    void delete(RecipeType en) throws RecetaException;
    List<RecipeType> findAll() throws RecetaException;
    RecipeType findByID(Integer ID) throws RecetaException;
}