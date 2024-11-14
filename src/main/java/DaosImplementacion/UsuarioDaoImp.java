
package DaosImplementacion;

import Daos.UsuarioDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDaoImp implements UsuarioDAO{
    
    private static Connection con;
    private static final String driver = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "pepe123";
    
    public boolean esBedel(String usuario, String contrasena){
        boolean existe=true; 
        Connection connection;
        try {
            connection = getConnection();

             String sqlUsuario = "SELECT b.nombreusuario,us.contrasena  "
                     + "FROM public.usuario us JOIN public.bedel b ON(us.nombreusuario=b.nombreusuario)  "
                     + " WHERE (b.nombreusuario=?) and (us.contrasena=?)";
        
            PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario);
            pstmtUser.setString(1, usuario);
            pstmtUser.setString(2, contrasena);
            
            ResultSet rs = pstmtUser.executeQuery();
            if(!rs.next()){
                existe=false;
            }
            connection.close(); 
        } catch (SQLException ex) {
            existe=false;
            Logger.getLogger(UsuarioDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            existe=false;
            Logger.getLogger(UsuarioDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return existe; 
    }
    
    public boolean esAdministrador(String usuario,String contrasena){
        boolean existe=true;
        Connection connection;
        try {
            connection = getConnection();

             String sqlUsuario = "SELECT ad.nombreusuario,us.contrasena "
                     + "FROM public.usuario us JOIN public.administrador ad ON(us.nombreusuario=ad.nombreusuario)  "
                     + "WHERE (ad.nombreusuario=?) and (us.contrasena=?)";
        
            PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario);
            pstmtUser.setString(1, usuario);
            pstmtUser.setString(2, contrasena);
            
            ResultSet rs = pstmtUser.executeQuery();
            if(!rs.next()){
                existe=false;
            }
            connection.close(); 
        } catch (SQLException ex) {
            existe=false;
            Logger.getLogger(UsuarioDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            existe=false;
            Logger.getLogger(UsuarioDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }

        return existe; 
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
