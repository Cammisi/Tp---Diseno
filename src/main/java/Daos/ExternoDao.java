
package Daos;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ExternoDao {
    public ArrayList<String> obtenerDocentes()throws SQLException, ClassNotFoundException;
    public ArrayList<String> obtenerCatedras()throws SQLException, ClassNotFoundException;
}
