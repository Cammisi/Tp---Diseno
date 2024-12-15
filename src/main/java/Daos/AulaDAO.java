
package Daos;

import Clases.Aula;
import Clases.Periodo;
import Dtos.AulaDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public interface AulaDAO {
    public ArrayList<AulaDTO> buscarAulas(String numero,String tipo,int capacidad) throws SQLException, ClassNotFoundException;
    public ArrayList<String> buscarIds() throws SQLException, ClassNotFoundException;
    public Connection getConnection() throws SQLException, ClassNotFoundException;
    public ArrayList<Aula> obtenerAulasCriterio(String cantidad,String tipoAula)  throws SQLException, ClassNotFoundException;
}
