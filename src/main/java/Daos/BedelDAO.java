package Daos;
import Clases.Bedel;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public interface BedelDAO {
    public void registrarBedel(Bedel b);
    public void modificarBedel();
    public void eliminarBedel();
    public ArrayList<Bedel> buscarBedel(String apellido,String turno) throws SQLException, ClassNotFoundException;
    //public Bedel buscarBedel(String nombreUsuario);
    public void actualizarBedel(Bedel bedel);
    public Connection getConnection() throws SQLException, ClassNotFoundException;
}
