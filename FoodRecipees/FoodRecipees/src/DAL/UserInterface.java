

package DAL;

import BL.Useri;
import java.util.List;
public interface UserInterface {
    void create(Useri en) throws RecetaException;
    void edit(Useri en) throws RecetaException;
    void delete(Useri en) throws RecetaException;
    List<Useri> findAll() throws RecetaException;
    Useri findByID(Integer ID) throws RecetaException;
    Useri loginByUsernameAndPassword(String u, String p) throws RecetaException;
    boolean isRegistered(String username, String email) throws RecetaException;
}
