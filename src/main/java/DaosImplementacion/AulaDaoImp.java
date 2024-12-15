
package DaosImplementacion;

import Clases.Aula;
import Clases.AulaInformatica;
import Clases.AulaMultimedios;
import Clases.AulaSinRecursos;
import Daos.AulaDAO;
import Dtos.AulaDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AulaDaoImp implements AulaDAO{
    private static Connection con;
    private static final String driver = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "pepe123";
    
    public ArrayList<AulaDTO> buscarAulas(String numero,String tipo,int capacidad) throws SQLException, ClassNotFoundException{
        
        ArrayList<AulaDTO> aulas = new ArrayList<>();
        Connection connection = getConnection();
        String sqlUsuario;
        
        if(numero.equals("Seleccionar") && tipo.equals("MULTIMEDIOS")){
            sqlUsuario = "SELECT a.numero,au.capacidad,au.piso,au.disponible,a.descripcion "
                + "FROM public.aulamultimedios AS a "
                    + "JOIN public.aula as au ON (a.numero = au.numero) "
                + "WHERE au.capacidad>=? ";
        }else if(tipo.equals("MULTIMEDIOS")){
            int num = Integer.parseInt(numero.toString());
            sqlUsuario = "SELECT a.numero,au.capacidad,au.piso,au.disponible,a.descripcion "
                + "FROM public.aulamultimedios AS a "
                    + "JOIN public.aula as au ON (a.numero = au.numero) "
                + "WHERE a.numero=? "
                    + "and au.capacidad>=? ";
        }
        
        
        else if(numero.equals("Seleccionar") && tipo.equals("INFORMATICA")){
            sqlUsuario = "SELECT a.numero,au.capacidad,au.piso,au.disponible,a.descripcion "
                + "FROM public.aulainformatica AS a "
                    + "JOIN public.aula as au ON (a.numero = au.numero) "
                + "WHERE au.capacidad>=? ";
        }else if(tipo.equals("INFORMATICA")){
            int num = Integer.parseInt(numero.toString());
            sqlUsuario = "SELECT a.numero,au.capacidad,au.piso,au.disponible,a.descripcion "
                + "FROM public.aulainformatica AS a "
                    + "JOIN public.aula as au ON (a.numero = au.numero) "
                + "WHERE a.numero=? "
                    + "and au.capacidad>=? ";
        }
        
        else if(numero.equals("Seleccionar") && tipo.equals("SIN RECURSOS")){
            sqlUsuario = "SELECT a.numero,au.capacidad,au.piso,au.disponible,a.descripcion "
                + "FROM public.aulasinrecursos AS a "
                    + "JOIN public.aula au on (a.numero = au.numero) "
                + "WHERE au.capacidad>=? ";
        }else if(tipo.equals("SIN RECURSOS")){
            int num = Integer.parseInt(numero.toString());
            sqlUsuario = "SELECT a.numero,au.capacidad,au.piso,au.disponible,a.descripcion "
                + "FROM public.aulasinrecursos AS a "
                    + "JOIN public.aula as au ON (a.numero = au.numero) "
                + "WHERE a.numero=? "
                    + "and au.capacidad>=? ";
        }
        
        else if(numero.equals("Seleccionar") && tipo.equals("Seleccionar")){ 
            sqlUsuario = "((SELECT a.numero,au.capacidad,au.piso,au.disponible,a.descripcion "
                + "FROM public.aulainformatica AS a "
                    + "JOIN public.aula as au ON (a.numero = au.numero) "
                + "WHERE au.capacidad>=?) "
                +"UNION "
                + "(SELECT a.numero,au.capacidad,au.piso,au.disponible,a.descripcion "
                + "FROM public.aulamultimedios AS a "
                    + "JOIN public.aula as au ON (a.numero = au.numero) "
                + "WHERE au.capacidad>=?) "
                + "UNION "
                + "(SELECT a.numero,au.capacidad,au.piso,au.disponible,a.descripcion "
                + "FROM public.aulasinrecursos AS a "
                    + "JOIN public.aula au on (a.numero = au.numero) "
                + "WHERE au.capacidad>=?)) "
                + "ORDER BY descripcion ";
        }else{
            sqlUsuario = "(SELECT a.numero,au.capacidad,au.piso,au.disponible,a.descripcion "
                + "FROM public.aulamultimedios AS a "
                    + "JOIN public.aula as au ON (a.numero = au.numero) "
                + "WHERE a.numero=? "
                    + "and au.capacidad>=?) "
                + "UNION "
                +"(SELECT a.numero,au.capacidad,au.piso,au.disponible,a.descripcion "
                + "FROM public.aulainformatica AS a "
                    + "JOIN public.aula as au ON (a.numero = au.numero) "
                + "WHERE a.numero=? "
                    + "and au.capacidad>=?) "
                + "UNION "
                + "(SELECT a.numero,au.capacidad,au.piso,au.disponible,a.descripcion "
                + "FROM public.aulasinrecursos AS a "
                    + "JOIN public.aula as au ON (a.numero = au.numero) "
                + "WHERE a.numero=? "
                    + "and au.capacidad>=?) ";
        }
        
        PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario);
        
        if(numero.equals("Seleccionar") && !tipo.equals("Seleccionar")){
            pstmtUser.setInt(1,capacidad);
        }else if(!tipo.equals("Seleccionar")){
            int num = Integer.parseInt(numero.toString());
            pstmtUser.setInt(1,num);
            pstmtUser.setInt(2,num);
            pstmtUser.setInt(3,capacidad);
            pstmtUser.setInt(4,capacidad);
        }else if(numero.equals("Seleccionar") && tipo.equals("Seleccionar")){
            pstmtUser.setInt(1,capacidad);
            pstmtUser.setInt(2,capacidad);
            pstmtUser.setInt(3,capacidad);   
        }else{
            int num = Integer.parseInt(numero.toString());
            pstmtUser.setInt(1,num);
            pstmtUser.setInt(2,capacidad);
            pstmtUser.setInt(3,num);
            pstmtUser.setInt(4,capacidad); 
            pstmtUser.setInt(5,num);
            pstmtUser.setInt(6,capacidad);
        }
        
        ResultSet rs = pstmtUser.executeQuery();
        
        while(rs.next()){
            String disp;
            int num = rs.getInt("numero");
            int cap = rs.getInt("capacidad");
            int pis = rs.getInt("piso");
            if(rs.getBoolean("disponible")){ disp = "Disponible";}
            else{ disp = "No disponible";}
            String tipo1 = rs.getString("descripcion");
            
            AulaDTO aula = new AulaDTO(cap,num,pis,disp,tipo1);
            aulas.add(aula);
        }
        
        connection.close();
        return aulas;
    }
    
    public ArrayList<String> buscarIds() throws SQLException, ClassNotFoundException{
        ArrayList<String> ids = new ArrayList<>();
        Connection connection = getConnection();
        
        String sqlUsuario = "SELECT numero "
                + "FROM public.aula "
                + "ORDER BY numero";
        PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario);
        ResultSet rs = pstmtUser.executeQuery();
        
        while(rs.next()){
            String num = String.valueOf(rs.getInt("numero"));
            ids.add(num);
        }
        connection.close();
        return ids;
    }
    
    public AulaMultimedios buscarMultimedios(String numero) throws SQLException, ClassNotFoundException{
        
        AulaMultimedios datosAula = new AulaMultimedios();
        Connection connection = getConnection();
        int num = Integer.parseInt(numero.toString());
        
        String sqlUsuario = "SELECT a.numero,au.piso,au.capacidad,a.computadora,a.ventiladores,a.tipodepizarron,a.canon,a.aireacondicionado,a.televisor "
                + "FROM public.aulamultimedios AS a "
                    + "JOIN public.aula as au ON (a.numero = au.numero) "
                + "WHERE a.numero=? ";
        
        PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario);
        pstmtUser.setInt(1,num);
        ResultSet rs = pstmtUser.executeQuery();
        
        //System.out.print(rs.getInt("numero"));
        
        if(rs.next()){
            datosAula.setNumero(rs.getInt("numero"));
            datosAula.setPiso(rs.getInt("piso"));
            datosAula.setCapacidad(rs.getInt("capacidad"));
            datosAula.setComputadora(rs.getBoolean("computadora"));
            datosAula.setVentiladores(rs.getBoolean("ventiladores"));
            datosAula.setTipoDePizarron(rs.getString("tipodepizarron"));
            datosAula.setCanon(rs.getBoolean("canon"));
            datosAula.setAireAcondicionado(rs.getBoolean("aireacondicionado"));
            datosAula.setTelevisor(rs.getBoolean("televisor")); 
        }
        connection.close();
        
        return datosAula;
    }
    
    public void modificarAulaMultimedios(AulaMultimedios aula) throws SQLException, ClassNotFoundException{
        
        Connection connection = getConnection();
        try{
            connection.setAutoCommit(false); //comienza la transacción.

            String sqlUsuario = "UPDATE public.aula "
                + "SET capacidad = ? "
                + "WHERE numero = ? ";

            try(PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario)){        
                pstmtUser.setInt(1, aula.getCapacidad());
                pstmtUser.setInt(2, aula.getNumero());
                pstmtUser.executeUpdate();
            }

            String sqlUsuario2 = "UPDATE public.aulamultimedios "
                + "SET televisor = ?,canon = ?,computadora = ?,tipodepizarron = ?,aireacondicionado = ?,ventiladores = ?  "
                + "WHERE numero = ? ";

            try(PreparedStatement pstmtUser2 = connection.prepareStatement(sqlUsuario2)){        
                pstmtUser2.setBoolean(1, aula.isTelevisor());
                pstmtUser2.setBoolean(2, aula.isCanon());
                pstmtUser2.setBoolean(3, aula.isComputadora());
                pstmtUser2.setString(4, aula.getTipoDePizarron());
                pstmtUser2.setBoolean(5, aula.isAireAcondicionado());
                pstmtUser2.setBoolean(6, aula.isVentiladores());
                pstmtUser2.setInt(7, aula.getNumero());
                pstmtUser2.executeUpdate();
            }
            connection.commit();
        }catch(SQLException ex){
            if (connection != null) {
                connection.rollback(); // Revertir transacción en caso de error.
            }
            throw ex;
        }finally {
            if (connection != null) {
                connection.setAutoCommit(true);
                connection.close();
            }
        }
    }
    
    public AulaInformatica buscarInformatica(String numero) throws SQLException, ClassNotFoundException{     
        AulaInformatica datosAula = new AulaInformatica();
        Connection connection = getConnection();
        int num = Integer.parseInt(numero.toString());
        
        String sqlUsuario = "SELECT a.numero,au.piso,au.capacidad,a.cantidaddepcs,a.tipodepizarron,a.canon,a.aireacondicionado "
                + "FROM public.aulainformatica AS a "
                    + "JOIN public.aula as au ON (a.numero = au.numero) "
                + "WHERE a.numero=? ";
        
        PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario);
        pstmtUser.setInt(1,num);
        ResultSet rs = pstmtUser.executeQuery();
        
        if(rs.next()){
            datosAula.setNumero(rs.getInt("numero"));
            datosAula.setPiso(rs.getInt("piso"));
            datosAula.setCapacidad(rs.getInt("capacidad"));
            datosAula.setCantidadDePcs(rs.getInt("cantidaddepcs"));
            datosAula.setTipoDePizarron(rs.getString("tipodepizarron"));
            datosAula.setCanon(rs.getBoolean("canon"));
            datosAula.setAireAcondicionado(rs.getBoolean("aireacondicionado")); 
        }
        connection.close();
        
        return datosAula;
    }
    
    public void modificarAulaInformatica(AulaInformatica aula) throws SQLException, ClassNotFoundException{
        
        Connection connection = getConnection();
        try{
            connection.setAutoCommit(false); //comienza la transacción.

            String sqlUsuario = "UPDATE public.aula "
                + "SET capacidad = ? "
                + "WHERE numero = ? ";

            try(PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario)){        
                pstmtUser.setInt(1, aula.getCapacidad());
                pstmtUser.setInt(2, aula.getNumero());
                pstmtUser.executeUpdate();
            }

            String sqlUsuario2 = "UPDATE public.aulainformatica "
                + "SET canon = ?,tipodepizarron = ?,aireacondicionado = ?,cantidaddepcs = ?  "
                + "WHERE numero = ? ";

            try(PreparedStatement pstmtUser2 = connection.prepareStatement(sqlUsuario2)){        
                pstmtUser2.setBoolean(1, aula.isCanon());
                pstmtUser2.setString(2, aula.getTipoDePizarron());
                pstmtUser2.setBoolean(3, aula.isAireAcondicionado());
                pstmtUser2.setInt(4, aula.getCantidadDePcs());
                pstmtUser2.setInt(5, aula.getNumero());
                pstmtUser2.executeUpdate();
            }
            connection.commit();
        }catch(SQLException ex){
            if (connection != null) {
                connection.rollback(); // Revertir transacción en caso de error.
            }
            throw ex;
        }finally {
            if (connection != null) {
                connection.setAutoCommit(true);
                connection.close();
            }
        }
    }
    
    public AulaSinRecursos buscarSinRecursos(String numero) throws SQLException, ClassNotFoundException{     
        AulaSinRecursos datosAula = new AulaSinRecursos();
        Connection connection = getConnection();
        int num = Integer.parseInt(numero.toString());
        
        String sqlUsuario = "SELECT a.numero,au.piso,au.capacidad,a.ventiladores,a.tipodepizarron,a.aireacondicionado "
                + "FROM public.aulasinrecursos AS a "
                    + "JOIN public.aula as au ON (a.numero = au.numero) "
                + "WHERE a.numero=? ";
        
        PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario);
        pstmtUser.setInt(1,num);
        ResultSet rs = pstmtUser.executeQuery();
        
        if(rs.next()){
            datosAula.setNumero(rs.getInt("numero"));
            datosAula.setPiso(rs.getInt("piso"));
            datosAula.setCapacidad(rs.getInt("capacidad"));
            datosAula.setTipoDePizarron(rs.getString("tipodepizarron"));
            datosAula.setAireAcondicionado(rs.getBoolean("aireacondicionado")); 
            datosAula.setVentiladores(rs.getBoolean("ventiladores"));
        }
        connection.close();
        
        return datosAula;
    }
    
    public void modificarAulaSinRecursos(AulaSinRecursos aula) throws SQLException, ClassNotFoundException{
        
        Connection connection = getConnection();
        try{
            connection.setAutoCommit(false); //comienza la transacción.

            String sqlUsuario = "UPDATE public.aula "
                + "SET capacidad = ? "
                + "WHERE numero = ? ";

            try(PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario)){        
                pstmtUser.setInt(1, aula.getCapacidad());
                pstmtUser.setInt(2, aula.getNumero());
                pstmtUser.executeUpdate();
            }

            String sqlUsuario2 = "UPDATE public.aulasinrecursos "
                + "SET tipodepizarron = ?,aireacondicionado = ?,ventiladores = ?  "
                + "WHERE numero = ? ";

            try(PreparedStatement pstmtUser2 = connection.prepareStatement(sqlUsuario2)){        
                pstmtUser2.setString(1, aula.getTipoDePizarron());
                pstmtUser2.setBoolean(2, aula.isAireAcondicionado());
                pstmtUser2.setBoolean(3, aula.isVentiladores());
                pstmtUser2.setInt(4, aula.getNumero());
                pstmtUser2.executeUpdate();
            }
            connection.commit();
        }catch(SQLException ex){
            if (connection != null) {
                connection.rollback(); // Revertir transacción en caso de error.
            }
            throw ex;
        }finally {
            if (connection != null) {
                connection.setAutoCommit(true);
                connection.close();
            }
        }
    }
    public ArrayList<Aula> obtenerAulasCriterio(String cantidad,String tipoAula) throws SQLException, ClassNotFoundException{
        Connection connection = getConnection();
        ArrayList<Aula> lista = new ArrayList<>();
        int cant = Integer.parseInt(cantidad);
        String sqlAula;
        try{
            if(tipoAula.equals("MULTIMEDIOS")){
                sqlAula = "SELECT * "
                + "FROM public.aulamultimedios AS a "
                    + "JOIN public.aula as au ON (a.numero = au.numero) "
                + "WHERE au.capacidad>=? and au.disponible is true "
                        + "ORDER BY capacidad";
            }else if(tipoAula.equals("INFORMATICA")){
                sqlAula = "SELECT * "
                + "FROM public.aulainformatica AS a "
                    + "JOIN public.aula as au ON (a.numero = au.numero) "
                + "WHERE au.capacidad>=? and au.disponible is true "
                        + "ORDER BY capacidad";
                     
            }else{
                 sqlAula = "SELECT * "
                + "FROM public.aulasinrecursos AS a "
                    + "JOIN public.aula as au ON (a.numero = au.numero) "
                + "WHERE au.capacidad>=? and au.disponible is true "
                         + "ORDER BY capacidad";
            }
            try(PreparedStatement pstmtUser = connection.prepareStatement(sqlAula)){ 
                pstmtUser.setInt(1,cant); 
                ResultSet rs = pstmtUser.executeQuery();
        
                if(tipoAula.equals("MULTIMEDIOS")){
                    while(rs.next()){    
                        AulaMultimedios aula = new AulaMultimedios();
                        aula.setAireAcondicionado(rs.getBoolean("aireacondicionado"));
                        aula.setCanon(rs.getBoolean("canon"));
                        aula.setCapacidad(rs.getInt("capacidad"));
                        aula.setComputadora(rs.getBoolean("computadora"));
                        aula.setDisponible(true);
                        aula.setNumero(rs.getInt("numero"));
                        aula.setPiso(rs.getInt("piso"));
                        aula.setTelevisor(rs.getBoolean("televisor"));
                        aula.setTipoDePizarron(rs.getString("tipodepizarron"));
                        aula.setVentiladores(rs.getBoolean("ventiladores"));
                        aula.setDescripcion(rs.getString("descripcion"));
                        lista.add(aula);
                    }
                }else if(tipoAula.equals("INFORMATICA")){
                    while(rs.next()){    
                        AulaInformatica aula = new AulaInformatica();
                        aula.setAireAcondicionado(rs.getBoolean("aireacondicionado"));
                        aula.setCanon(rs.getBoolean("canon"));
                        aula.setCapacidad(rs.getInt("capacidad"));
                        aula.setDisponible(true);
                        aula.setNumero(rs.getInt("numero"));
                        aula.setPiso(rs.getInt("piso"));
                        aula.setTipoDePizarron(rs.getString("tipodepizarron"));
                        aula.setCantidadDePcs(rs.getInt("cantidaddepcs"));
                        aula.setDescripcion(rs.getString("descripcion"));
                        lista.add(aula);
                    }
                }else{
                     while(rs.next()){    
                        AulaSinRecursos aula = new  AulaSinRecursos();
                        aula.setAireAcondicionado(rs.getBoolean("aireacondicionado"));
                        aula.setCapacidad(rs.getInt("capacidad"));
                        aula.setDisponible(true);
                        aula.setNumero(rs.getInt("numero"));
                        aula.setPiso(rs.getInt("piso"));
                        aula.setTipoDePizarron(rs.getString("tipodepizarron"));
                        aula.setVentiladores(rs.getBoolean("ventiladores"));
                        aula.setDescripcion(rs.getString("descripcion"));
                        lista.add(aula);
                    }
                }   
            }
        }catch(SQLException ex){
            throw ex;
        }finally {
                connection.close();
        }
        
        
        return lista;
    }

    public int obtenerMaxCapacidad(String tipoAula) throws SQLException, ClassNotFoundException{
        int capacidad = 0 ;
        Connection connection = getConnection();
        String sqlUsuario;
        try{
            if(tipoAula.equals("MULTIMEDIOS")){
                 sqlUsuario = "SELECT au.capacidad " +
                    "FROM public.aulamultimedios as a " +
                    "JOIN public.aula as au ON (a.numero = au.numero) " +
                    "GROUP BY au.capacidad " +
                    "having au.capacidad>=all(SELECT max(au.capacidad) " +
                    "FROM public.aulamultimedios as a " +
                    "JOIN public.aula as au ON (a.numero = au.numero) " +
                    "GROUP BY au.capacidad)";
            }else if(tipoAula.equals("INFORMATICA")){
                sqlUsuario = "SELECT au.capacidad " +
                    "FROM public.aulainformatica as a " +
                    "JOIN public.aula as au ON (a.numero = au.numero) " +
                    "GROUP BY au.capacidad " +
                    "having au.capacidad>=all(SELECT max(au.capacidad) " +
                    "FROM public.aulainformatica as a " +
                    "JOIN public.aula as au ON (a.numero = au.numero) " +
                    "GROUP BY au.capacidad)";
            }else{
                sqlUsuario = "SELECT au.capacidad " +
                    "FROM public.aulasinrecursos as a " +
                    "JOIN public.aula as au ON (a.numero = au.numero) " +
                    "GROUP BY au.capacidad " +
                    "having au.capacidad>=all(SELECT max(au.capacidad) " +
                    "FROM public.aulasinrecursos as a " +
                    "JOIN public.aula as au ON (a.numero = au.numero) " +
                    "GROUP BY au.capacidad)";
            }
    
            try(PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario)){        
                ResultSet rs = pstmtUser.executeQuery();
                if(rs.next()){
                    capacidad = rs.getInt("capacidad");
                }
            }
        }catch(SQLException ex){
            throw ex;
        }finally {
            connection.close();            
        }
        return capacidad;
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
