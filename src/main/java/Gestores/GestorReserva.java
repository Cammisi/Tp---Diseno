
package Gestores;

import Clases.Bedel;
import Clases.Dia;
import Clases.Esporadica;
import Clases.Periodica;
import Clases.Periodo;
import DaosImplementacion.BedelDaoImp;
import DaosImplementacion.PeriodoDaoImp;
import DaosImplementacion.ReservaDaoImp;
import Dtos.ListaReservaDTO;
import Dtos.ReservaEDTO;
import Dtos.ReservaPDTO;
//import InterfazGrafica.RegistrarReservaEsporadica;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorReserva {
    
    public ArrayList<ListaReservaDTO> buscarReserva(String tipoAula, Date fecha){
        ArrayList<ListaReservaDTO> reservas = new ArrayList<>();
        ReservaDaoImp rDao = new ReservaDaoImp();
        
        try {
            reservas = rDao.buscarReserva(tipoAula,fecha);
        } catch (SQLException ex) {
            Logger.getLogger(GestorReserva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return reservas;
    }
    
    public ArrayList<ListaReservaDTO> buscarReservaCurso(String ano,String materia){
        ArrayList<ListaReservaDTO> reservas = new ArrayList<>();
        ReservaDaoImp rDao = new ReservaDaoImp();
        
        try {
            reservas = rDao.buscarReservaCurso(ano,materia);
        } catch (SQLException ex) {
            Logger.getLogger(GestorReserva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return reservas;
    }
    
    public boolean registrarReservaEsporadica(ArrayList<ReservaEDTO> lista) throws SQLException, ClassNotFoundException{
        boolean flag = true;
        ReservaEDTO reserva = lista.getFirst();
        GestorExterno gExterno = new GestorExterno();
        BedelDaoImp bDao = new BedelDaoImp();
        ReservaDaoImp rDao = new ReservaDaoImp();
        Bedel bedel = new Bedel();
        Date hoy= eliminarHora(new Date());
        int dni = Integer.parseInt(reserva.getDocente());
        String nombre = "";
        String apellido="";
        
        try{
            nombre = gExterno.obtenerNombreDocente(reserva.getDocente());
            apellido = gExterno.obtenerApellidDocente(reserva.getDocente());
        }catch (SQLException ex) {
             throw ex;
            //Logger.getLogger(RegistrarReservaEsporadica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
             throw ex;
            //Logger.getLogger(RegistrarReservaEsporadica.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        flag = validarDatos(lista);
        if(flag){
            Esporadica esporadica = new Esporadica();
            esporadica.inicializarDias();
            esporadica.setEmailDocente(reserva.getEmail());
            esporadica.setFechaCreacion(hoy);
            esporadica.setDniDocente(dni);
            esporadica.setNombreDocente(nombre);
            esporadica.setApellidoDocente(apellido);
        
            try{
                bedel = bDao.buscarBedel(reserva.getBedel());
            }catch (SQLException ex) {
                throw ex;
            } catch (ClassNotFoundException ex) {
                throw ex;
            }
            
            esporadica.setBedel(bedel);
        
            for(ReservaEDTO i: lista){
                java.sql.Date sqlDia = new java.sql.Date(i.getDia().getTime());

                Dia dia = new Dia();
                dia.setCantidadAlumnos(i.getCantidadAlumnos());
                dia.setFecha(sqlDia);
                dia.setDuracion(i.getDuracion()); 
                dia.setHoraInicio(i.getHoraInicio());

                String nombreActividad = "";
                int idActividad = 0;
                try{
                    nombreActividad = gExterno.buscarNombreActividad(i.getCatedra());
                    idActividad = gExterno.buscarIdActividad(i.getCatedra());
                }catch (SQLException ex) {
                    throw ex;      
                }catch (ClassNotFoundException ex) {
                    throw ex;
                }  
                dia.setIdActividad(idActividad);
                dia.setNombreActividad(nombreActividad);
                dia.setAula(i.getAula());

                esporadica.setDiaEspecifico(dia);
            }
            rDao.registrarReserva(esporadica);
        }
        return flag;
    }
    
    public boolean validarDatos(ArrayList<ReservaEDTO> lista){
        boolean flag = true;
        ReservaEDTO reserva = lista.getFirst();
        String dni = reserva.getDocente();
        String email = reserva.getEmail();
        boolean campoVacioFecha = false;
        boolean campoVacioHora = false;
        boolean campoVacioDuracion = false;
        boolean campoVacioAlumnos = false;  
         
        
        if(dni.length()==0){flag =false;}
       
        if(email.length()!=0){
            if(!esEmailValido(email)){
                flag = false;
            }
        }else{
            flag = false;
        }
        
        for(ReservaEDTO i: lista){
            int cantidad = i.getCantidadAlumnos();
            Time hora = i.getHoraInicio();
            Date fecha = i.getDia();
            int duracion = i.getDuracion();
            String cant = String.valueOf(cantidad);
            String dur = String.valueOf(duracion);
            String horastr = hora.toString();
            String horaBien = horastr.substring(0, horastr.length()-3);
            Date hoy= eliminarHora(new Date());
            
            
            if(!validarVacio(cant)){
                campoVacioAlumnos = true; 
                flag = false;
            }
            
            if(!validarVacio(dur)){
                campoVacioDuracion = true;
                flag = false;
            }
           
            if(!validarVacio(horastr)){
                campoVacioHora = true;
                flag = false;
            }
            
            if(fecha == null){
                campoVacioFecha = true;
                flag = false;
            }
            
            if(!campoVacioDuracion && flag){
                if(!((duracion % 30==0) && duracion!=0)){
                    flag = false;  
                }
            }
            
            if(!campoVacioAlumnos && flag){
                if(!cant.matches("[0-9]+")){
                    flag = false;
                }else{
                    if(cantidad<1){
                        flag = false;
                    }
                }
            }
            
            if(!campoVacioHora && flag){
                if(horaBien.length()==5){
                    if(!validarHora(horaBien) ){    
                        flag = false;
                    }else{
                        if(fecha.compareTo(hoy)==0){
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                            LocalTime horaIngresadaTime = LocalTime.parse(horaBien, formatter);
                            LocalTime horaActual = LocalTime.now();
                            if(!horaIngresadaTime.isAfter(horaActual)){
                               flag=false;
                            } 
                        }
                    }
                }else{
                    flag = false;
                }            
            }
        }
        return flag;
    }
    
    public boolean validarVacio(String str){
        boolean flag=true;
        if(str.isBlank() || str.equals("Escribe aquí...") || str.equals("Seleccionar") ||str.equals("HH:MM")){
            flag=false;
        }
       return flag;  
    }
    
    public static boolean esEmailValido(String email) {
        // Expresión regular para validar un correo electrónico
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        // Validar el formato usando matches
        return email != null && email.matches(regex);
    }
    
    public static Date eliminarHora(Date fecha){
        return new Date(fecha.getYear(),fecha.getMonth(),fecha.getDate());
    }
    
    public static boolean validarHora(String hora) {
        
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        sdf.setLenient(false); // Desactiva la tolerancia para horas inválidas (e.g., 25:00)
        try {
            sdf.parse(hora); // Intenta analizar el string
            return true;     // Si no lanza excepción, la hora es válida
        } catch (ParseException e) {
            return false;    // Si lanza excepción, la hora es inválida
        }
    }
    
    public boolean registrarReservaPeriodica(ArrayList<ReservaPDTO> lista) throws SQLException, ClassNotFoundException{
        boolean flag = true;
        ReservaPDTO reserva = lista.getFirst();
        GestorExterno gExterno = new GestorExterno();
        PeriodoDaoImp pDao = new PeriodoDaoImp();
        BedelDaoImp bDao = new BedelDaoImp();
        ReservaDaoImp rDao = new ReservaDaoImp();
        Periodo periodo1 = new Periodo();
        Bedel bedel = new Bedel();
        Date hoy= eliminarHora(new Date());
        int dni = Integer.parseInt(reserva.getDocente());
        String nombre = "";
        String apellido="";
        
        try{
            nombre = gExterno.obtenerNombreDocente(reserva.getDocente());
            apellido = gExterno.obtenerApellidDocente(reserva.getDocente());
        }catch (SQLException ex) {
             throw ex;
            //Logger.getLogger(RegistrarReservaEsporadica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
             throw ex;
            //Logger.getLogger(RegistrarReservaEsporadica.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        flag = validarDatos1(lista);
        if(flag){
            Periodica periodica = new Periodica();
            periodica.inicializarDias();
            periodica.setEmailDocente(reserva.getEmail());
            periodica.setFechaCreacion(hoy);
            periodica.setDniDocente(dni);
            periodica.setNombreDocente(nombre);
            periodica.setApellidoDocente(apellido);
        
            try{
                bedel = bDao.buscarBedel(reserva.getBedel());
            }catch (SQLException ex) {
                throw ex;
                //Logger.getLogger(RegistrarReservaEsporadica.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                throw ex;
                //Logger.getLogger(RegistrarReservaEsporadica.class.getName()).log(Level.SEVERE, null, ex);
            }
            periodica.setBedel(bedel);
        
            periodo1 = pDao.obtenerPeriodo(reserva.getPeriodo(), 2025);
            periodica.setUnPeriodo(periodo1);
            
            for(ReservaPDTO i: lista){
                ArrayList<Date> fechas = new ArrayList<>();
                fechas = obtenerDias(periodo1,i.getDia());
                
                String nombreActividad = "";
                int idActividad = 0;
                try{
                    nombreActividad = gExterno.buscarNombreActividad(i.getCatedra());
                    idActividad = gExterno.buscarIdActividad(i.getCatedra());
                }catch (SQLException ex) {
                    //mensajeError();       
                }catch (ClassNotFoundException ex) {
                    //mensajeError();       
                }  

                for(Date j: fechas){
                    java.sql.Date sqlDia = new java.sql.Date(j.getTime());
                    
                    Dia dia = new Dia();
                    dia.setCantidadAlumnos(i.getCantidadAlumnos());
                    dia.setFecha(sqlDia);
                    dia.setDuracion(i.getDuracion()); 
                    dia.setHoraInicio(i.getHoraInicio());
                    dia.setIdActividad(idActividad);
                    dia.setNombreActividad(nombreActividad);
                    dia.setAula(i.getAula());

                    periodica.setDiaEspecifico(dia);
                }
            }
            rDao.registrarReserva(periodica);
        }
        return flag;
    }
    
    public boolean validarDatos1(ArrayList<ReservaPDTO> lista){
        boolean flag = true;
        ReservaPDTO reserva = lista.getFirst();
        String dni = reserva.getDocente();
        String email = reserva.getEmail();
        boolean campoVacioFecha = false;
        boolean campoVacioHora = false;
        boolean campoVacioDuracion = false;
        boolean campoVacioAlumnos = false;  
         
        
        if(dni.length()==0){flag =false;}
       
        if(email.length()!=0){
            if(!esEmailValido(email)){
                flag = false;
            }
        }else{
            flag = false;
        }
        
        for(ReservaPDTO i: lista){
            int cantidad = i.getCantidadAlumnos();
            Time hora = i.getHoraInicio();
            int duracion = i.getDuracion();
            String cant = String.valueOf(cantidad);
            String dur = String.valueOf(duracion);
            String horastr = hora.toString();
            String horaBien = horastr.substring(0, horastr.length()-3);
            Date hoy= eliminarHora(new Date());
            
            
            if(i.getDia().length()==0){
                flag=false;
            }
            
            if(!validarVacio(cant)){
                campoVacioAlumnos = true; 
                flag = false;
            }
            
            if(!validarVacio(dur)){
                campoVacioDuracion = true;
                flag = false;
            }
           
            if(!validarVacio(horastr)){
                campoVacioHora = true;
                flag = false;
            }
            
            if(!campoVacioDuracion && flag){
                if(!((duracion % 30==0) && duracion!=0)){
                    flag = false;  
                }
            }
            
            if(!campoVacioAlumnos && flag){
                if(!cant.matches("[0-9]+")){
                    flag = false;
                }else{
                    if(cantidad<1){
                        flag = false;
                    }
                }
            }
            
            if(!campoVacioHora && flag){
                if(horaBien.length()==5){
                    if(!validarHora(horaBien) ){    
                        flag = false;
                    }
                }else{
                    flag = false;
                }            
            }
        }
        return flag;
    }
    
    private static ArrayList<Date> obtenerDias(Periodo periodo,String dia){
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
    
}
