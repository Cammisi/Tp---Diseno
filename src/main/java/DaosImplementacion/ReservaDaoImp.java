
package DaosImplementacion;

import Clases.Aula;
import Clases.Dia;
import Clases.Esporadica;
import Clases.Periodica;
import Clases.Periodo;
import Daos.ReservaDAO;
import Dtos.ListaReservaDTO;
import Dtos.ReservasSolapadasDTO;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;


public class ReservaDaoImp implements ReservaDAO{
    
    private static Connection con;
    private static final String driver = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "pepe123";
    
    public ArrayList<ListaReservaDTO> buscarReserva(String tipoAula, Date fecha) throws SQLException, ClassNotFoundException{
        ArrayList<ListaReservaDTO> reservas = new ArrayList<>();
        Connection connection = getConnection();
        java.sql.Date sqlFecha = new java.sql.Date(fecha.getTime());
        String sqlUsuario;
        if(tipoAula.equals("MULTIMEDIOS")){
            sqlUsuario = "SELECT a.numero,r.dnidocente,r.nombreactividad,d.horainicio,d.duracion "
                + "FROM public.reserva AS r "
                + "JOIN public.dia AS d ON (d.idreserva = r.idreserva) "
                + "JOIN public.aula AS a ON (a.numero = d.numero) "
                + "JOIN public.aulamultimedios AS am ON (a.numero = am.numero) "
                + "WHERE d.fecha = ?";
        }else if(tipoAula.equals("INFORMATICA")){
            sqlUsuario = "SELECT a.numero,r.dnidocente,r.nombreactividad,d.horainicio,d.duracion "
                + "FROM public.reserva AS r "
                + "JOIN public.dia AS d ON (d.idreserva = r.idreserva) "
                + "JOIN public.aula AS a ON (a.numero = d.numero) "
                + "JOIN public.aulainformatica AS ai ON (a.numero = ai.numero) "
                + "WHERE d.fecha = ?";
        }else if(tipoAula.equals("SIN RECURSOS")){
            sqlUsuario = "SELECT a.numero,r.dnidocente,r.nombreactividad,d.horainicio,d.duracion "
                + "FROM public.reserva AS r "
                + "JOIN public.dia AS d ON (d.idreserva = r.idreserva) "
                + "JOIN public.aula AS a ON (a.numero = d.numero) "
                + "JOIN public.aulasinrecursos AS asr ON (a.numero = asr.numero) "
                + "WHERE d.fecha = ?";
        }else{ 
            sqlUsuario = "(SELECT a.numero,r.dnidocente,r.nombreactividad,d.horainicio,d.duracion "
                + "FROM public.reserva AS r "
                + "JOIN public.dia AS d ON (d.idreserva = r.idreserva) "
                + "JOIN public.aula AS a ON (a.numero = d.numero) "
                + "JOIN public.aulamultimedios AS am ON (a.numero = am.numero) "
                + "WHERE d.fecha = ?) "
                + "UNION "
                +"(SELECT a.numero,r.dnidocente,r.nombreactividad,d.horainicio,d.duracion "
                + "FROM public.reserva AS r "
                + "JOIN public.dia AS d ON (d.idreserva = r.idreserva) "
                + "JOIN public.aula AS a ON (a.numero = d.numero) "
                + "JOIN public.aulainformatica AS ai ON (a.numero = ai.numero) "
                + "WHERE d.fecha = ?) "
                + "UNION "
                +"(SELECT a.numero,r.dnidocente,r.nombreactividad,d.horainicio,d.duracion "
                + "FROM public.reserva AS r "
                + "JOIN public.dia AS d ON (d.idreserva = r.idreserva) "
                + "JOIN public.aula AS a ON (a.numero = d.numero) "
                + "JOIN public.aulasinrecursos AS asr ON (a.numero = asr.numero) "
                + "WHERE d.fecha = ?)";
        } 
        
        PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario);
        
        if(tipoAula.equals("TODAS")){
            pstmtUser.setDate(1, sqlFecha);
            pstmtUser.setDate(2, sqlFecha);
            pstmtUser.setDate(3, sqlFecha);
        }else{
            pstmtUser.setDate(1, sqlFecha);
        }

        ResultSet rs = pstmtUser.executeQuery();
        
        while(rs.next()){
            int dni = rs.getInt("dnidocente");
            int numero = rs.getInt("numero");
            String actividad = rs.getString("nombreactividad");
            Time horaInicio = rs.getTime("horainicio");
            int duracion = rs.getInt("duracion");

            LocalTime pasaje = horaInicio.toLocalTime().plusMinutes(duracion);
            Time horaFin = Time.valueOf(pasaje);
            
            ListaReservaDTO fila = new ListaReservaDTO( numero,dni,actividad,horaInicio,horaFin);
            reservas.add(fila);
        }
        
        return reservas;
    }
    
    public ArrayList<ListaReservaDTO> buscarReservaCurso(String ano,String materia) throws SQLException, ClassNotFoundException{
        ArrayList<ListaReservaDTO> reservas = new ArrayList<>();
        Connection connection = getConnection();
        String sqlUsuario;
        
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, Integer.parseInt(ano));
        cal.set(Calendar.DAY_OF_YEAR, 1);
        Date inicioAno = new Date(cal.getTimeInMillis());

        cal.set(Calendar.DAY_OF_YEAR, cal.getActualMaximum(Calendar.DAY_OF_YEAR));
        Date finAno = new Date(cal.getTimeInMillis());
        
        java.sql.Date inicio = new java.sql.Date(inicioAno.getTime());
        java.sql.Date fin = new java.sql.Date(finAno.getTime());
        
        sqlUsuario = "SELECT a.numero,d.horainicio,d.duracion,d.fecha "
                + "FROM public.reserva AS r "
                + "JOIN public.dia AS d ON (d.idreserva = r.idreserva) "
                + "JOIN public.aula AS a ON (a.numero = d.numero) "
                + "WHERE r.nombreactividad = ? "
                      + "and d.fecha between ? and ?";
        
        PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario);
        
        pstmtUser.setString(1, materia);
        pstmtUser.setDate(2, inicio);
        pstmtUser.setDate(3, fin);
        
        ResultSet rs = pstmtUser.executeQuery();
        while(rs.next()){
            int numero = rs.getInt("numero");
            Time horaInicio = rs.getTime("horainicio");
            int duracion = rs.getInt("duracion");
            Date dia = rs.getDate("fecha");

            ListaReservaDTO fila = new ListaReservaDTO(numero,horaInicio,duracion,dia);
            reservas.add(fila);
        }
        
        
        return reservas;
    }
    
    public ArrayList<Aula> aulasDisponibles(ArrayList<Aula> listaAulas,Date fecha ,Time horaInicio ,int duracion)throws SQLException, ClassNotFoundException {
        ArrayList<Aula> disponibles = listaAulas;
        ArrayList<Integer> noDisponibles = new  ArrayList<>();
        java.sql.Date sqlFecha = new java.sql.Date(fecha.getTime());
        LocalTime pasaje = horaInicio.toLocalTime().plusMinutes(duracion);
        Time horaFin = Time.valueOf(pasaje);
        Connection connection = getConnection();
        try{
            for (Aula i : listaAulas){
                String sqlUsuario = "SELECT distinct d.numero "
                    + "FROM public.reserva r "
                    + "JOIN public.dia d on(r.idReserva = d.idReserva) "
                    + "where d.numero = ? and d.fecha = ? and d.horainicio = ? "
                    + "UNION "
                    + "SELECT distinct d.numero "
                    + "FROM public.reserva r "
                    + "JOIN public.dia d on(r.idReserva = d.idReserva) "
                    + "where d.numero = ? and d.fecha = ? and (d.horainicio < ? AND d.horainicio + (d.duracion * interval '1 minute') > ?) "
                    + "UNION "
                    + "SELECT distinct d.numero "
                    + "FROM public.reserva r "
                    + "JOIN public.dia d on(r.idReserva = d.idReserva) "
                    + "where d.numero = ? and d.fecha = ? and (d.horainicio > ? AND ? > d.horainicio) ";
                
                try(PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario)){        
                    pstmtUser.setInt(1,i.getNumero());
                    pstmtUser.setDate(2,sqlFecha);
                    pstmtUser.setTime(3,horaInicio);

                    pstmtUser.setInt(4,i.getNumero());
                    pstmtUser.setDate(5,sqlFecha);
                    pstmtUser.setTime(6,horaInicio);
                    pstmtUser.setTime(7,horaInicio);

                    pstmtUser.setInt(8,i.getNumero());
                    pstmtUser.setDate(9,sqlFecha);
                    pstmtUser.setTime(10,horaInicio);
                    pstmtUser.setTime(11,horaFin);
                    ResultSet rs = pstmtUser.executeQuery();
                    if(rs.next()){
                        noDisponibles.add(rs.getInt("numero"));
                    } 
                }   
            }
            
            for(int i : noDisponibles){
                Iterator<Aula> iterador = disponibles.iterator();
                while(iterador.hasNext()){
                    Aula siguiente = iterador.next();
                    if(siguiente.getNumero() == i){
                        iterador.remove();
                    }  
                }
            } 
            
        }catch(SQLException ex){ 
            throw ex;
        }finally {
                connection.close();       
        }

        return disponibles;
    }
    
    public ArrayList<Aula> aulasDisponibles(ArrayList<Aula> listaAulas,String dia,Time horaInicio,int duracion,Periodo periodo)throws SQLException, ClassNotFoundException{
        ArrayList<Integer> noDisponibles = new  ArrayList<>();
        ArrayList<Aula> disponibles = listaAulas;
        ArrayList<Date> fechas = new ArrayList<>();
        
        LocalTime pasaje = horaInicio.toLocalTime().plusMinutes(duracion);
        Time horaFin = Time.valueOf(pasaje);
        
        Connection connection = getConnection();
        try{
            fechas = obtenerFechas(periodo,dia);
            for(Date j: fechas){
                java.sql.Date sqlFecha = new java.sql.Date(j.getTime());
                for (Aula i : listaAulas){
                    String sqlUsuario = "SELECT distinct d.numero "
                        + "FROM public.reserva r "
                        + "JOIN public.dia d on(r.idReserva = d.idReserva) "
                        + "where d.numero = ? and d.fecha = ? and d.horainicio = ? "
                        + "UNION "
                        + "SELECT distinct d.numero "
                        + "FROM public.reserva r "
                        + "JOIN public.dia d on(r.idReserva = d.idReserva) "
                        + "where d.numero = ? and d.fecha = ? and (d.horainicio < ? AND d.horainicio + (d.duracion * interval '1 minute') > ?) "
                        + "UNION "
                        + "SELECT distinct d.numero "
                        + "FROM public.reserva r "
                        + "JOIN public.dia d on(r.idReserva = d.idReserva) "
                        + "where d.numero = ? and d.fecha = ? and (d.horainicio > ? AND ? > d.horainicio) ";

                    try(PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario)){        
                        pstmtUser.setInt(1,i.getNumero());
                        pstmtUser.setDate(2,sqlFecha);
                        pstmtUser.setTime(3,horaInicio);

                        pstmtUser.setInt(4,i.getNumero());
                        pstmtUser.setDate(5,sqlFecha);
                        pstmtUser.setTime(6,horaInicio);
                        pstmtUser.setTime(7,horaInicio);

                        pstmtUser.setInt(8,i.getNumero());
                        pstmtUser.setDate(9,sqlFecha);
                        pstmtUser.setTime(10,horaInicio);
                        pstmtUser.setTime(11,horaFin);
                        ResultSet rs = pstmtUser.executeQuery();
                        if(rs.next()){
                            noDisponibles.add(rs.getInt("numero"));
                        } 
                    }   
                }
            }

            for(int i : noDisponibles){
                Iterator<Aula> iterador = disponibles.iterator();
                while(iterador.hasNext()){
                    Aula siguiente = iterador.next();
                    if(siguiente.getNumero() == i){
                        iterador.remove();
                    }  
                }
            }
               
        }catch(SQLException ex){ 
            throw ex;
        }finally {
            connection.close();       
        }
        return disponibles;
    }
    
    public ArrayList<ReservasSolapadasDTO> aulasSolapadas(ArrayList<Aula> listaAulas,Date fecha ,Time horaInicio ,int duracion) throws SQLException, ClassNotFoundException{
        ArrayList<ReservasSolapadasDTO> menosSolapadas = new  ArrayList<>();
        java.sql.Date sqlFecha = new java.sql.Date(fecha.getTime());
       
        
        Connection connection = getConnection();
        try{
            for (Aula i : listaAulas){
                String sqlUsuario = "WITH nueva_reserva AS ( " +
                "SELECT " +
                "? ::date AS fecha_nueva, "+
                "? ::time AS hora_inicio_nueva, "+
                "? AS duracion_nueva,  "+
                "? AS numero_aula  "+
                "), "+
                "solapamientos AS ( "+
                    "SELECT "+
                        "r.nombredocente, "+
                        "r.apellidodocente, "+
                        "r.emaildocente, "+
                        "a.numero AS aula, "+
                        "d.horainicio, "+
                        " (d.horainicio + (d.duracion * interval '1 minute'))::time AS horafin, "+
                        "d.nombreactividad, "+
                        "FLOOR(EXTRACT(EPOCH FROM ( "+
                            "LEAST( "+
                                "(d.horainicio + (d.duracion * interval '1 minute')), "+
                                "(nueva_reserva.hora_inicio_nueva + (nueva_reserva.duracion_nueva * interval '1 minute')) "+
                            ") - GREATEST(d.horainicio, nueva_reserva.hora_inicio_nueva) "+
                        ")) / 60)::integer AS solapamiento "+
                    "FROM dia d "+
                    "JOIN reserva r ON d.idreserva = r.idreserva "+
                    "JOIN aula a ON d.numero = a.numero "+
                    "JOIN nueva_reserva ON d.fecha = nueva_reserva.fecha_nueva "+
                    "WHERE "+
                        "d.numero = nueva_reserva.numero_aula AND "+
                        "GREATEST(d.horainicio, nueva_reserva.hora_inicio_nueva) < "+
                        "LEAST( "+
                            "(d.horainicio + (d.duracion * interval '1 minute')), "+
                            "(nueva_reserva.hora_inicio_nueva + (nueva_reserva.duracion_nueva * interval '1 minute')) "+
                        ") "+
                ") "+
                "SELECT nombredocente,apellidodocente,emaildocente,aula,horainicio,horafin,nombreactividad "+
                "FROM solapamientos "+
                "WHERE solapamiento =( " +
                                       "SELECT MIN(solapamiento) " +
                                       "FROM solapamientos) ";
  
                try(PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario)){        
                    pstmtUser.setDate(1, sqlFecha); 
                    pstmtUser.setTime(2, horaInicio); 
                    pstmtUser.setInt(3, duracion); 
                    pstmtUser.setInt(4, i.getNumero()); 
                    ResultSet rs = pstmtUser.executeQuery();
                    while(rs.next()){
                        String docente = rs.getString("nombredocente") + " " + rs.getString("apellidodocente");
                        ReservasSolapadasDTO item = new ReservasSolapadasDTO();
                        item.setAula(i);
                        item.setNombreDocente(docente);
                        item.setCatedra(rs.getString("nombreactividad"));
                        item.setEmail(rs.getString("emaildocente"));
                        item.setHoraInicio(rs.getTime("horainicio"));
                        item.setHoraFin(rs.getTime("horafin"));
                        menosSolapadas.add(item);
                    } 
                }   
            }
        }catch(SQLException ex){ 
            throw ex;
        }finally {
            connection.close();       
        }
        return menosSolapadas;
    }
    
    public ArrayList<ReservasSolapadasDTO> aulasSolapadas(ArrayList<Aula> listaAulas,String dia,Time horaInicio,int duracion,Periodo periodo)throws SQLException, ClassNotFoundException{
        ArrayList<ReservasSolapadasDTO> menosSolapadas = new  ArrayList<>();
        ArrayList<Date> fechas = new ArrayList<>();
        
        
        Connection connection = getConnection();
        try{
            fechas = obtenerFechas(periodo,dia);
            for(Date j: fechas){
                java.sql.Date sqlFecha = new java.sql.Date(j.getTime());
                for (Aula i : listaAulas){
                String sqlUsuario = "WITH nueva_reserva AS ( " +
                "SELECT " +
                "? ::date AS fecha_nueva, "+
                "? ::time AS hora_inicio_nueva, "+
                "? AS duracion_nueva,  "+
                "? AS numero_aula  "+
                "), "+
                "solapamientos AS ( "+
                    "SELECT "+
                        "r.nombredocente, "+
                        "r.apellidodocente, "+
                        "r.emaildocente, "+
                        "a.numero AS aula, "+
                        "d.horainicio, "+
                        " (d.horainicio + (d.duracion * interval '1 minute'))::time AS horafin, "+
                        "d.nombreactividad, "+
                        "FLOOR(EXTRACT(EPOCH FROM ( "+
                            "LEAST( "+
                                "(d.horainicio + (d.duracion * interval '1 minute')), "+
                                "(nueva_reserva.hora_inicio_nueva + (nueva_reserva.duracion_nueva * interval '1 minute')) "+
                            ") - GREATEST(d.horainicio, nueva_reserva.hora_inicio_nueva) "+
                        ")) / 60)::integer AS solapamiento "+
                    "FROM dia d "+
                    "JOIN reserva r ON d.idreserva = r.idreserva "+
                    "JOIN aula a ON d.numero = a.numero "+
                    "JOIN nueva_reserva ON d.fecha = nueva_reserva.fecha_nueva "+
                    "WHERE "+
                        "d.numero = nueva_reserva.numero_aula AND "+
                        "GREATEST(d.horainicio, nueva_reserva.hora_inicio_nueva) < "+
                        "LEAST( "+
                            "(d.horainicio + (d.duracion * interval '1 minute')), "+
                            "(nueva_reserva.hora_inicio_nueva + (nueva_reserva.duracion_nueva * interval '1 minute')) "+
                        ") "+
                ") "+
                "SELECT nombredocente,apellidodocente,emaildocente,aula,horainicio,horafin,nombreactividad "+
                "FROM solapamientos "+
                "WHERE solapamiento =( " +
                                       "SELECT MIN(solapamiento) " +
                                       "FROM solapamientos) ";
                try(PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario)){
                     boolean flag2;
                    pstmtUser.setDate(1, sqlFecha); 
                    pstmtUser.setTime(2, horaInicio); 
                    pstmtUser.setInt(3, duracion); 
                    pstmtUser.setInt(4, i.getNumero()); 
                    ResultSet rs = pstmtUser.executeQuery();
                    while(rs.next()){
                        String docente = rs.getString("nombredocente") + " " + rs.getString("apellidodocente");
                        ReservasSolapadasDTO item = new ReservasSolapadasDTO();
                        item.setAula(i);
                        item.setNombreDocente(docente);
                        item.setCatedra(rs.getString("nombreactividad"));
                        item.setEmail(rs.getString("emaildocente"));
                        item.setHoraInicio(rs.getTime("horainicio"));
                        item.setHoraFin(rs.getTime("horafin"));
                        flag2=true;
                        for(ReservasSolapadasDTO k: menosSolapadas){
                            if((item.getAula().getNumero() == k.getAula().getNumero()) && (item.getCatedra().equals(k.getCatedra())) && (item.getEmail().equals(k.getEmail())) && (item.getNombreDocente().equals(k.getNombreDocente())) && (item.getHoraFin().compareTo(k.getHoraFin())==0) && (item.getHoraInicio().compareTo(k.getHoraInicio())==0)){
                                flag2 = false;
                            } 
                        }
                        if(flag2){
                            menosSolapadas.add(item);
                        }
                        } 
                    }   
                }
            }
        }catch(SQLException ex){ 
            throw ex;
        }finally {
            connection.close();       
        }
        
        
        return menosSolapadas;
    }
    
    private static ArrayList<Date> obtenerFechas(Periodo periodo,String dia){
        ArrayList<Date> lista = new ArrayList<>();
        Map<String, Integer> diasSemana = new HashMap<>();
        diasSemana.put("domingo", Calendar.SUNDAY);
        diasSemana.put("lunes", Calendar.MONDAY);
        diasSemana.put("martes", Calendar.TUESDAY);
        diasSemana.put("miercoles", Calendar.WEDNESDAY);
        diasSemana.put("jueves", Calendar.THURSDAY);
        diasSemana.put("viernes", Calendar.FRIDAY);
        diasSemana.put("sabado", Calendar.SATURDAY);
        Integer diaSemana = diasSemana.get(dia.toLowerCase());
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(periodo.getFechaInicio());
        
        while (!cal.getTime().after(periodo.getFechaFin())) {
            
            if (cal.get(Calendar.DAY_OF_WEEK) == diaSemana) {
                lista.add(cal.getTime());
            }
            
            cal.add(Calendar.DAY_OF_MONTH, 1);
        }
        return lista;
    }
    
    public void registrarReserva(Esporadica esporadica)throws SQLException, ClassNotFoundException{
        
        int idReserva=0;
        java.sql.Date sqlFecha = new java.sql.Date(esporadica.getFechaCreacion().getTime());
        Connection connection = getConnection();
        try {
            connection.setAutoCommit(false);
            String sqlUsuario =   "INSERT INTO public.reserva (nombreusuario, dnidocente, nombredocente, apellidodocente, emaildocente, fechacreacion) VALUES (?, ?, ?, ?, ?, ?) RETURNING idreserva;";
            try(PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario)) {
                pstmtUser.setString(1, esporadica.getBedel().getNombreUsuario());
                pstmtUser.setInt(2, esporadica.getDniDocente());
                pstmtUser.setString(3, esporadica.getNombreDocente());
                pstmtUser.setString(4, esporadica.getApellidoDocente());
                pstmtUser.setString(5, esporadica.getEmailDocente());
                pstmtUser.setDate(6, sqlFecha);
                
                try (ResultSet rs = pstmtUser.executeQuery()) {
                    if (rs.next()) {
                        idReserva = rs.getInt("idreserva");
                        String insertarEsporadicaSQL = "INSERT INTO public.esporadica (idreserva) VALUES (?)";
                        try (PreparedStatement pstmtEsporadica = connection.prepareStatement(insertarEsporadicaSQL)) {
                            pstmtEsporadica.setInt(1, idReserva);
                            pstmtEsporadica.executeUpdate();
                        }
                    }
                }
            }
            for(Dia i: esporadica.getDias()){  
                String sqlDia = "INSERT INTO public.dia VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try(PreparedStatement pstmtDia = connection.prepareStatement(sqlDia)) {
                    pstmtDia.setDate(1, i.getFecha());
                    pstmtDia.setInt(2, i.getAula().getNumero());
                    pstmtDia.setInt(3, idReserva);
                    pstmtDia.setString(4, i.getNombreDia());
                    pstmtDia.setTime(5, i.getHoraInicio());
                    pstmtDia.setInt(6, i.getDuracion());
                    pstmtDia.setInt(7, i.getIdActividad());
                    pstmtDia.setString(8, i.getNombreActividad());
                    pstmtDia.setInt(9,i.getCantidadAlumnos()); 
                    pstmtDia.executeUpdate();
                }
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
    
    public void registrarReserva(Periodica periodica)throws SQLException, ClassNotFoundException{
        Connection connection = getConnection();
        int idReserva=0;
        java.sql.Date sqlFecha = new java.sql.Date(periodica.getFechaCreacion().getTime());
        try {
            connection.setAutoCommit(false);
            String sqlUsuario =  "INSERT INTO public.reserva (nombreusuario, dnidocente, nombredocente, apellidodocente, emaildocente, fechacreacion) VALUES (?, ?, ?, ?, ?, ?) RETURNING idreserva;";
            try(PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario)) {
                pstmtUser.setString(1, periodica.getBedel().getNombreUsuario());
                pstmtUser.setInt(2, periodica.getDniDocente());
                pstmtUser.setString(3, periodica.getNombreDocente());
                pstmtUser.setString(4, periodica.getApellidoDocente());
                pstmtUser.setString(5, periodica.getEmailDocente());
                pstmtUser.setDate(6, sqlFecha);
               
                try (ResultSet rs = pstmtUser.executeQuery()) {
                    if (rs.next()) {
                        idReserva = rs.getInt("idreserva");
                        String insertarPeriodicaSQL = "INSERT INTO public.periodica (idreserva,identificador) VALUES (?,?)";
                        try (PreparedStatement pstmtPeriodica = connection.prepareStatement(insertarPeriodicaSQL)) {
                            pstmtPeriodica.setInt(1, idReserva);
                            pstmtPeriodica.setString(2, periodica.getUnPeriodo().getIdentificador());
                            pstmtPeriodica.executeUpdate();
                        }
                    }
                }
            }
            for(Dia i: periodica.getDias()){  
                String sqlDia = "INSERT INTO public.dia VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try(PreparedStatement pstmtDia = connection.prepareStatement(sqlDia)) {
                    pstmtDia.setDate(1, i.getFecha());
                    pstmtDia.setInt(2, i.getAula().getNumero());
                    pstmtDia.setInt(3, idReserva);
                    pstmtDia.setString(4, i.getNombreDia());
                    pstmtDia.setTime(5, i.getHoraInicio());
                    pstmtDia.setInt(6, i.getDuracion());
                    pstmtDia.setInt(7, i.getIdActividad());
                    pstmtDia.setString(8, i.getNombreActividad());
                    pstmtDia.setInt(9,i.getCantidadAlumnos()); 
                    pstmtDia.executeUpdate();
                }
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
