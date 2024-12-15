
package DaosImplementacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Daos.ExternoDao;

public class ExternoDaoImp implements ExternoDao{
    private static Connection con;
    private static final String driver = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "pepe123";
    
    public ArrayList<String> obtenerDocentes() throws SQLException, ClassNotFoundException{
        Connection connection = getConnection();
        ArrayList<String> docentes = new  ArrayList<>();
        try{
            String sqlUsuario = "SELECT DNI "
                    + "FROM public.profesor ";

            try(PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario)){        
               ResultSet rs = pstmtUser.executeQuery();
        
                while(rs.next()){
                    String dni = String.valueOf(rs.getInt("DNI"));
                    docentes.add(dni);
                }
            }
  
        }catch(SQLException ex){ 
            throw ex;
        }finally {
                connection.close();       
        }
        return docentes;
    }
     public ArrayList<String> obtenerCatedras() throws SQLException, ClassNotFoundException{
        Connection connection = getConnection(); 
        ArrayList<String> catedras = new ArrayList<>();
          
        try{
            String sqlUsuario = "SELECT nombre "
                    + "FROM public.actividad ";

            try(PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario)){        
               ResultSet rs = pstmtUser.executeQuery();
        
                while(rs.next()){
                    String dni = (rs.getString("nombre"));
                    catedras.add(dni);
                }
            }
  
        }catch(SQLException ex){ 
            throw ex;
        }finally {
            connection.close();       
        }  
          
        return catedras;
     }
    
    public String obtenerNombreDocente(String docente) throws SQLException, ClassNotFoundException{
        String nombre = "";
        int dni = Integer.parseInt(docente);
        Connection connection = getConnection();   
        try{
            String sqlUsuario = "SELECT nombre "
                    + "FROM public.profesor "
                    + "WHERE dni = ? ";

            try(PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario)){        
                pstmtUser.setInt(1,dni);
                ResultSet rs = pstmtUser.executeQuery();
        
                if(rs.next()){
                    nombre = rs.getString("nombre");
                }
            }
  
        }catch(SQLException ex){ 
            throw ex;
        }finally {
            connection.close();       
        } 
        
        return nombre;
    }
     
    public String obtenerApellidoDocente(String docente)throws SQLException, ClassNotFoundException{
        String apellido = "";
        int dni = Integer.parseInt(docente);
        Connection connection = getConnection();   
        try{
            String sqlUsuario = "SELECT apellido "
                    + "FROM public.profesor "
                    + "WHERE dni = ? ";

            try(PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario)){        
                pstmtUser.setInt(1,dni);
                ResultSet rs = pstmtUser.executeQuery();
        
                if(rs.next()){
                    apellido = rs.getString("apellido");
                }
            }
  
        }catch(SQLException ex){ 
            throw ex;
        }finally {
            connection.close();       
        } 
        
        return apellido;
    }
    
    public String buscarNombreActividad(String actividad)throws SQLException, ClassNotFoundException{
        String actividad1 = "";
        Connection connection = getConnection();   
        try{
            String sqlUsuario = "SELECT nombre "
                    + "FROM public.actividad "
                    + "WHERE nombre = ? ";

            try(PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario)){        
                pstmtUser.setString(1,actividad);
                ResultSet rs = pstmtUser.executeQuery();
        
                if(rs.next()){
                    actividad1 = rs.getString("nombre");
                }
            }
  
        }catch(SQLException ex){ 
            throw ex;
        }finally {
            connection.close();       
        } 
        
        return actividad1;
    }
    
    public int buscarIdActividad(String actividad)throws SQLException, ClassNotFoundException{
        int id = 0;
        Connection connection = getConnection();   
        try{
            String sqlUsuario = "SELECT id_actividad "
                    + "FROM public.actividad "
                    + "WHERE nombre = ? ";

            try(PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario)){        
                pstmtUser.setString(1,actividad);
                ResultSet rs = pstmtUser.executeQuery();
        
                if(rs.next()){
                    id = rs.getInt("id_actividad");
                }
            }
  
        }catch(SQLException ex){ 
            throw ex;
        }finally {
            connection.close();       
        } 
        
        return id;
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
