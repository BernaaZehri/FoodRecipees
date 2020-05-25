/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.UnitDetails;
import java.util.List;
public interface UnitDetailsInterface {
    void create(UnitDetails en) throws RecetaException;
    void edit(UnitDetails en) throws RecetaException;
    void delete(UnitDetails en) throws RecetaException;
    List<UnitDetails> findAll() throws RecetaException;
    UnitDetails findByID(Integer ID) throws RecetaException;
}