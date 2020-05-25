/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.Difficulty;
import java.util.List;
public interface DifficultyInterface {
    void create(Difficulty en) throws RecetaException;
    void edit(Difficulty en) throws RecetaException;
    void delete(Difficulty en) throws RecetaException;
    List<Difficulty> findAll() throws RecetaException;
    Difficulty findByID(Integer ID) throws RecetaException;
}