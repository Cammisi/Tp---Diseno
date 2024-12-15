
package DaosImplementacion;

import Clases.Periodo;
import Daos.PeriodoDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeriodoDaoImp implements PeriodoDAO{
    private static Connection con;
    private static final String driver = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "pepe123";
    
    public Periodo obtenerPeriodo(String nombre,int anio) throws SQLException, ClassNotFoundException{
        Periodo periodo = new Periodo();
        
        Connection connection = getConnection();
        try{

            String sqlUsuario ="SELECT * "
                    + "FROM public.periodo "
                    + "where nombre = ? and anolectivo = ? ";

            try(PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario)){        
                pstmtUser.setString(1, nombre);
                pstmtUser.setInt(2, anio);
                ResultSet rs = pstmtUser.executeQuery();
                
                if(rs.next()){
                    periodo.setAnoLectivo(rs.getInt("anolectivo"));
                    periodo.setFechaFin(rs.getDate("fechafin"));
                    periodo.setFechaInicio(rs.getDate("fechainicio"));
                    periodo.setIdentificador(rs.getString("identificador"));
                    periodo.setNombre(rs.getString("nombre"));   
                }
            }
        }catch(SQLException ex){
            throw ex;
        }finally {
            connection.close();
        }
        
        return periodo;
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
