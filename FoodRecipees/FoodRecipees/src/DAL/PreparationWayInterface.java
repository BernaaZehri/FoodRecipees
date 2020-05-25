/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.PreparationWay;
import java.util.List;
public interface PreparationWayInterface {
    void create(PreparationWay en) throws RecetaException;
    void edit(PreparationWay en) throws RecetaException;
    void delete(PreparationWay en) throws RecetaException;
    List<PreparationWay> findAll() throws RecetaException;
    PreparationWay findByID(Integer ID) throws RecetaException;
}