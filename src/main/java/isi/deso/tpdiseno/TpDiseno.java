
package isi.deso.tpdiseno;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TpDiseno {

    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        //PRegistrarBedel p = new PRegistrarBedel();
        //p.setVisible(true);
        //p.setLocationRelativeTo(null);
        //p.setResizable(false);
        Connection connection = DataBaseConnection.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("select nombreusuario from usuario");
        
       while (rs.next()) {
            System.out.println(rs.getString("nombreusuario"));
        }
        
        connection.close(); 
        /*try {
            
            if (connection != null && !connection.isClosed()) {
                System.out.println("La conexión está abierta y lista para usarse.");
                
                connection.close(); // Cierra la conexión después de probarla
            }
        } catch (SQLException e) {
            System.err.println("No se pudo establecer la conexión: " + e.getMessage());
        }
        */
    }
}

