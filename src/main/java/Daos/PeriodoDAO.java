
package Daos;

import Clases.Periodo;
import java.sql.SQLException;

public interface PeriodoDAO {
    public Periodo obtenerPeriodo(String nombre,int anio)throws SQLException, ClassNotFoundException;

}
