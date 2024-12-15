package DaosImplementacion;
import Daos.BedelDAO;
import Clases.Bedel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BedelDaoImp implements BedelDAO{
    private static Connection con;
    private static final String driver = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "pepe123";
    
    public void registrarBedel(Bedel b)throws SQLException, ClassNotFoundException{
        Connection connection = getConnection();
        try {
            connection.setAutoCommit(false); 
            String sqlUsuario = "INSERT INTO public.usuario (nombreusuario, contrasena, apellido, nombre) VALUES (?, ?, ?, ?)";

            try(PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario)) {
                pstmtUser.setString(1, b.getNombreUsuario());
                pstmtUser.setString(2, b.getContrasenia());
                pstmtUser.setString(3, b.getApellido());
                pstmtUser.setString(4, b.getNombre());
                pstmtUser.executeUpdate();
            }

            String sqlBedel = "INSERT INTO public.bedel (nombreusuario,turno,eliminado) VALUES (?, ?, ?)";
            try(PreparedStatement pstmtBedel = connection.prepareStatement(sqlBedel)) {
                pstmtBedel.setString(1, b.getNombreUsuario());
                pstmtBedel.setString(2, b.getTurno());
                pstmtBedel.setBoolean(3, b.isEliminado());
                pstmtBedel.executeUpdate();
            }
            connection.commit();    
        }catch(SQLException ex){
            if (connection != null) {
                connection.rollback();
            }
            throw ex;
        }finally {
            if (connection != null) {
                connection.setAutoCommit(true);
                connection.close();
            }
        }
    }
    
    public ArrayList<Bedel> buscarBedel(String apellido,String turno) throws SQLException, ClassNotFoundException{
        ArrayList<Bedel> bedeles = new ArrayList<>();
        Connection connection = getConnection();
        try{
            connection.setAutoCommit(false);
            //si no selecciona nada
            if((apellido.equals("Escribe aquí...") && turno.equals("Seleccionar")) || ((apellido.equals("") && turno.equals("Seleccionar")))){

                String sqlUsuario = "SELECT us.apellido,us.nombre,b.turno,b.nombreusuario "
                        + "FROM public.bedel b JOIN public.usuario us ON(b.nombreusuario=us.nombreusuario) "
                        + "WHERE b.eliminado = false";
                try(PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario)){
                    ResultSet rs = pstmtUser.executeQuery();

                    while(rs.next()){
                        String apellido1 = rs.getString("apellido");
                        String nombre = rs.getString("nombre");
                        String turno1 = rs.getString("turno");
                        String nombreUsuario = rs.getString("nombreusuario");

                        
                        Bedel bedel = new Bedel( nombre, apellido1, nombreUsuario, turno1);

                        
                        bedeles.add(bedel);
                    }
                }
            //selecciona turno pero no apellido
            }else{    
                if(apellido.equals("Escribe aquí...") || apellido.equals("")){
                    //Connection connection = getConnection();
                    String sqlUsuario = "SELECT DISTINCT us.apellido,us.nombre,b.turno,b.nombreusuario "
                            + "FROM public.bedel b JOIN public.usuario us ON(b.nombreusuario=us.nombreusuario)"
                            + "WHERE (b.eliminado = false) and b.turno = ?";
                    try(PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario)){
                        pstmtUser.setString(1, turno);
                        ResultSet rs = pstmtUser.executeQuery();

                        while(rs.next()){
                            String apellido1 = rs.getString("apellido");
                            String nombre = rs.getString("nombre");
                            String turno1 = rs.getString("turno");
                            String nombreUsuario = rs.getString("nombreusuario");

                            
                            Bedel bedel = new Bedel( nombre, apellido1, nombreUsuario, turno1);

                            
                            bedeles.add(bedel);
                        } 
                    }
                    //selecciona apellido pero no turno
                }else if(turno.equals("Seleccionar")){
                    String sqlUsuario = "SELECT DISTINCT us.apellido,us.nombre,b.turno,b.nombreusuario "
                            + "FROM public.bedel b JOIN public.usuario us ON(b.nombreusuario=us.nombreusuario)"
                            + "WHERE (b.eliminado = false) and us.apellido= ?";
                    try(PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario)){
                        pstmtUser.setString(1, apellido);
                        ResultSet rs = pstmtUser.executeQuery();

                        while(rs.next()){
                            String apellido1 = rs.getString("apellido");
                            String nombre = rs.getString("nombre");
                            String turno1 = rs.getString("turno");
                            String nombreUsuario = rs.getString("nombreusuario");

                            // Crea un objeto Bedel con los datos obtenidos
                            Bedel bedel = new Bedel( nombre, apellido1, nombreUsuario, turno1);

                            // Agrega el objeto a la lista
                            bedeles.add(bedel);
                        }
                    }
                    //llenó ambos campos
                }else{
                    String sqlUsuario = "SELECT DISTINCT us.apellido,us.nombre,b.turno,b.nombreusuario "
                            + "FROM public.bedel b JOIN public.usuario us ON(b.nombreusuario=us.nombreusuario)"
                            + "WHERE (b.eliminado = false) and ((us.apellido = ?) and (b.turno = ?))";
                    try(PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario)){
                        pstmtUser.setString(1, apellido);
                        pstmtUser.setString(2, turno);
                        ResultSet rs = pstmtUser.executeQuery();

                        while(rs.next()){
                            String apellido1 = rs.getString("apellido");
                            String nombre = rs.getString("nombre");
                            String turno1 = rs.getString("turno");
                            String nombreUsuario = rs.getString("nombreusuario");

                            Bedel bedel = new Bedel( nombre, apellido1, nombreUsuario, turno1); 
                            bedeles.add(bedel);
                        }
                    }
                }
            }
            connection.commit();
        }catch(SQLException ex){
            if (connection != null) {
                connection.rollback(); // Revertir transacción en caso de error.
            }
            throw ex;
        }finally{
            if (connection != null) {
                connection.setAutoCommit(true);
                connection.close();
            }
        }
        return bedeles;
    }
    
    public Bedel buscarBedel(String nombreUsuario) throws SQLException, ClassNotFoundException{
        Connection connection = getConnection();
        
        try{
            String sqlUsuario = "SELECT * "
                    + "FROM public.bedel b JOIN public.usuario us ON(b.nombreusuario=us.nombreusuario) "
                    + "WHERE b.nombreusuario = ?";
            try(PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario)){
                pstmtUser.setString(1, nombreUsuario);
                ResultSet rs = pstmtUser.executeQuery();
                if(rs.next()){
                    String apellido1 = rs.getString("apellido");
                    String nombre = rs.getString("nombre");
                    String turno1 = rs.getString("turno");
                    String nombreUsuario1 = rs.getString("nombreusuario");
                    Boolean eliminado = rs.getBoolean("eliminado");
                    String contrasena = rs.getString("contrasena");
                    Bedel bedel = new Bedel(turno1,eliminado,nombre,apellido1,nombreUsuario1,contrasena);
                    connection.close();
                    return bedel;
                }
            }
            
        }catch(SQLException ex){
            if (connection != null) {
                connection.rollback(); // Revertir transacción en caso de error.
            }
            throw ex;
        }finally{
            connection.close();
        }
        return null;
    }
    
    public void eliminarBedel(Bedel bedel)throws SQLException, ClassNotFoundException{
        Connection connection= getConnection();
        String usuario = bedel.getNombreUsuario();
        try { 
            connection.setAutoCommit(false);
            String sqlUsuario = "UPDATE public.bedel "
                + "SET eliminado = true "
                + "WHERE nombreusuario = ?";
            try(PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario)){
                pstmtUser.setString(1, usuario);
                pstmtUser.executeUpdate();
            }
            connection.commit();
        } catch(SQLException ex){
            if (connection != null) {
                connection.rollback(); // Revertir transacción en caso de error.
            }
            throw ex;
        }finally{
            if (connection != null) {
                connection.setAutoCommit(true);
                connection.close();
            }
        }
    }
    
    @Override
    public void modificarBedel(Bedel bedel) throws SQLException,ClassNotFoundException{
        Connection connection = getConnection();
        try {
            connection.setAutoCommit(false); //comienza la transacción.
            String sqlUsuario = "UPDATE public.usuario "
                + "SET nombre = ?, apellido = ?, contrasena = ? "
                + "WHERE nombreusuario = ?";

            try(PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario)){        
            pstmtUser.setString(1, bedel.getNombre());
            pstmtUser.setString(2, bedel.getApellido());
            pstmtUser.setString(3, bedel.getContrasenia());
            pstmtUser.setString(4, bedel.getNombreUsuario());
            pstmtUser.executeUpdate();
            }

            String sqlUsuario2 = "UPDATE public.bedel "
                + "SET turno = ? "
                + "WHERE nombreusuario = ? ";

            try(PreparedStatement pstmtUser2 = connection.prepareStatement(sqlUsuario2)){           
            pstmtUser2.setString(1,  bedel.getTurno());
            pstmtUser2.setString(2, bedel.getNombreUsuario());
            pstmtUser2.executeUpdate();
            }
            connection.commit();
            System.out.println("Usuario y bedel modificados.");
        } catch(SQLException ex){
            if (connection != null) {
                connection.rollback(); // Revertir transacción en caso de error.
            }
            throw ex;
        }finally{
            if (connection != null) {
                connection.setAutoCommit(true);
                connection.close();
            }
        }
    }
    
   
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
