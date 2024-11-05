package DaosImplementacion;
import Daos.BedelDAO;
import Clases.Bedel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BedelDaoImp implements BedelDAO{
    private static Connection con;
    private static final String driver = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "pepe123";
    
    public void registrarBedel(Bedel b){
        try {
            Connection connection = getConnection();
            try {

                //Statement stmt = connection.createStatement();
                connection.setAutoCommit(false); //comienza la transacción.
                String sqlUsuario = "INSERT INTO public.usuario (nombreusuario, contrasena, apellido, nombre) VALUES (?, ?, ?, ?)";
                
                try(PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario)) {
                    pstmtUser.setString(1, b.getNombreUsuario());
                    pstmtUser.setString(2, b.getContrasenia());
                    pstmtUser.setString(3, b.getApellido());
                    pstmtUser.setString(4, b.getNombre());
                    pstmtUser.executeUpdate();
                }
                
                String sqlBedel = "INSERT INTO public.bedel (nombreusuario,  eliminado,turno) VALUES (?, ?, ?)";
                try(PreparedStatement pstmtBedel = connection.prepareStatement(sqlBedel)) {
                    pstmtBedel.setString(1, b.getNombreUsuario());
                    pstmtBedel.setBoolean(2, b.isEliminado());
                    pstmtBedel.setString(3, b.getTurno());
                    pstmtBedel.executeUpdate();
                }
                
                
                connection.commit();
                System.out.println("Usuario y Bedel registrados exitosamente.");
                /*
                } catch (SQLException ex) {
                Logger.getLogger(BedelDaoImp.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                Logger.getLogger(BedelDaoImp.class.getName()).log(Level.SEVERE, null, ex);
                }*/
            } catch (SQLException ex) {
                Logger.getLogger(BedelDaoImp.class.getName()).log(Level.SEVERE, "Error en la transacción, se revertirán los cambios.", ex);
                try {
                    // Revertir la transacción en caso de error
                    if(connection != null) {
                        connection.rollback();
                        System.out.println("Transacción revertida.");
                    }
                } catch (SQLException rollbackEx) {
                    Logger.getLogger(BedelDaoImp.class.getName()).log(Level.SEVERE, "Error al intentar hacer rollback.", rollbackEx);
                }
            } finally {
                // Cerrar la conexión y restaurar el auto-commit
                if (connection != null) {
                    try {
                        connection.setAutoCommit(true); // Restaurar auto-commit
                        connection.close(); // Cerrar conexión
                        System.out.println("Se cerró la conexion con la bdd");
                    } catch (SQLException e) {
                        Logger.getLogger(BedelDaoImp.class.getName()).log(Level.SEVERE, "Error al cerrar la conexión.", e);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BedelDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BedelDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void buscarBedel(){
        
    }
    public void modificarBedel(){
        
    }
    public void eliminarBedel(){
        
    }
   /* public ArrayList<Bedel> buscarBedel(String apellido, Turno turno){
        
    }*/
    /*public Bedel buscarBedel(String nombreUsuario){
        
    }*/
    public void actualizarBedel(Bedel bedel){
        
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        con = null;
        try {
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
            if(con != null){
                System.out.println("Conexión exitosa a la base de datos.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            throw e; 
        }
        return con;
    }
    
    
}
