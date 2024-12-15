
package Gestores;

import Clases.Aula;
import Clases.AulaInformatica;
import Clases.AulaMultimedios;
import Clases.AulaSinRecursos;
import Clases.Periodo;
import DaosImplementacion.AulaDaoImp;
import DaosImplementacion.PeriodoDaoImp;
import DaosImplementacion.ReservaDaoImp;
import Dtos.AulaDTO;
import Dtos.ReservasSolapadasDTO;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorAula {
    
    public ArrayList<AulaDTO> buscarAulas(String numero,String tipo,int capacidad){
        AulaDaoImp aDao = new AulaDaoImp();
        ArrayList<AulaDTO> aulas = new ArrayList<>();
        
        try {
            aulas = aDao.buscarAulas(numero,tipo,capacidad);
        } catch (SQLException ex) {
            Logger.getLogger(GestorAula.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAula.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return aulas;
    }
    
    public ArrayList<String> buscarIds(){
        AulaDaoImp aDao = new AulaDaoImp();
        ArrayList<String> ids = new ArrayList<>();
        
        try {
            ids = aDao.buscarIds();
        } catch (SQLException ex) {
            Logger.getLogger(GestorAula.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAula.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ids;
    }
    
    public AulaMultimedios buscarMultimedios(String numero){
        AulaDaoImp aDao = new AulaDaoImp();
        AulaMultimedios datosAulaM = new AulaMultimedios();
        
        try {
            datosAulaM = aDao.buscarMultimedios(numero);
        } catch (SQLException ex) {
            Logger.getLogger(GestorAula.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAula.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datosAulaM;
    }
    
    public boolean modificarMultimedios(int capacidad,String compu,String venti,String pizarra,String canon1,String aireAcond,String tele, AulaMultimedios aula) throws SQLException, ClassNotFoundException{
        boolean flag = true;
        AulaDaoImp aDao = new AulaDaoImp();
        AulaMultimedios aulaModificada = aula;
        aulaModificada.setCapacidad(capacidad);
        
        if(compu.equals("SI")){aulaModificada.setComputadora(true);}
        else{aulaModificada.setComputadora(false);}
        
        if(venti.equals("SI")){aulaModificada.setVentiladores(true);}
        else{aulaModificada.setVentiladores(false);}
        
        aulaModificada.setTipoDePizarron(pizarra);
        
        if(canon1.equals("SI")){aulaModificada.setCanon(true);}
        else{aulaModificada.setCanon(false);}
        
        if(aireAcond.equals("SI")){aulaModificada.setAireAcondicionado(true);}
        else{aulaModificada.setAireAcondicionado(false);}
        
        if(tele.equals("SI")){aulaModificada.setTelevisor(true);}
        else{aulaModificada.setTelevisor(false);}
        
        aDao.modificarAulaMultimedios(aulaModificada);
        return flag; 
    }
        
    public AulaInformatica buscarInformatica(String numero){
        AulaDaoImp aDao = new AulaDaoImp();
        AulaInformatica datosAulaI = new AulaInformatica();
        
        try {
            datosAulaI = aDao.buscarInformatica(numero);
        } catch (SQLException ex) {
            Logger.getLogger(GestorAula.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAula.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datosAulaI;
    }
    
    public boolean modificarInformatica(int capacidad,int cantidadPcs,String pizarra,String canon,String aireAcond,AulaInformatica aula) throws SQLException, ClassNotFoundException{
        boolean flag = true;
        AulaDaoImp aDao = new AulaDaoImp();
        AulaInformatica aulaModificada = aula;
        
        aulaModificada.setCapacidad(capacidad);
        aulaModificada.setCantidadDePcs(cantidadPcs);
        aulaModificada.setTipoDePizarron(pizarra);
        
        if(canon.equals("SI")){aulaModificada.setCanon(true);}
        else{aulaModificada.setCanon(false);}
        
        if(aireAcond.equals("SI")){aulaModificada.setAireAcondicionado(true);}
        else{aulaModificada.setAireAcondicionado(false);}
        
        aDao.modificarAulaInformatica(aulaModificada);
        return flag;
    }
    
    public AulaSinRecursos buscarSinRecursos(String numero){
        AulaDaoImp aDao = new AulaDaoImp();
        AulaSinRecursos datosAula = new AulaSinRecursos();
        
        try {
            datosAula = aDao.buscarSinRecursos(numero);
        } catch (SQLException ex) {
            Logger.getLogger(GestorAula.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAula.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datosAula;
    }
    
    public boolean modificarSinRecursos(int capacidad,String pizarra,String aireAcond,String ventilador,AulaSinRecursos aula) throws SQLException, ClassNotFoundException{
        boolean flag = true;
        AulaDaoImp aDao = new AulaDaoImp();
        AulaSinRecursos aulaModificada = aula;
        
        aulaModificada.setCapacidad(capacidad);
        aulaModificada.setTipoDePizarron(pizarra);
        
        if(ventilador.equals("SI")){aulaModificada.setVentiladores(true);}
        else{aulaModificada.setVentiladores(false);}
        
        if(aireAcond.equals("SI")){aulaModificada.setAireAcondicionado(true);}
        else{aulaModificada.setAireAcondicionado(false);}
        
        aDao.modificarAulaSinRecursos(aulaModificada);
        return flag;
    }
    
    public ArrayList obtenerDisponibilidadAulas(Date fecha,String hora,String duracion, String cantidad, String docente, String email,String catedra, String tipoAula) throws SQLException, ClassNotFoundException{
        
        AulaDaoImp aDao = new AulaDaoImp();
        ReservaDaoImp rDao = new ReservaDaoImp();
        ArrayList<Aula> criterio = new  ArrayList<>();
        ArrayList<Aula> disponibles = new  ArrayList<>();
        ArrayList<Aula> criterio2 = new  ArrayList<>();
        
        criterio = aDao.obtenerAulasCriterio(cantidad,tipoAula);
        criterio2 = aDao.obtenerAulasCriterio(cantidad,tipoAula);
        ArrayList retorno = new ArrayList<>();
        
        int dur = Integer.parseInt(duracion);
        
        Time time = null;
        if (hora.length() == 5) {
            hora += ":00";
        }
        time = Time.valueOf(hora);
        
        disponibles = rDao.aulasDisponibles(criterio, fecha, time, dur);
        
        if(disponibles.isEmpty()){
            retorno = rDao.aulasSolapadas(criterio2,fecha, time, dur); 
        }else{
            retorno = disponibles; //terminado
        }
        
        
        return retorno;
    }
    
     public ArrayList obtenerDisponibilidadAulas(String dia,String hora,String duracion,String periodo, String cantidad, String docente, String email,String catedra, String tipoAula) throws SQLException, ClassNotFoundException{
        AulaDaoImp aDao = new AulaDaoImp();
        ReservaDaoImp rDao = new ReservaDaoImp();
        PeriodoDaoImp pDao = new PeriodoDaoImp();
        Periodo periodo1 = new Periodo();
        ArrayList<Aula> criterio = new  ArrayList<>();
        ArrayList<Aula> disponibles = new  ArrayList<>();
        ArrayList retorno = new ArrayList<>();
        ArrayList<Aula> criterio2 = new  ArrayList<>();
        
        criterio = aDao.obtenerAulasCriterio(cantidad,tipoAula);
        criterio2 = aDao.obtenerAulasCriterio(cantidad,tipoAula);
        
        periodo1  =  pDao.obtenerPeriodo(periodo, 2025);
   
        int dur = Integer.parseInt(duracion);
        
        Time time = null;
        if (hora.length() == 5){ 
            hora += ":00";
        }
        time = Time.valueOf(hora);
        
        disponibles = rDao.aulasDisponibles(criterio, dia, time, dur, periodo1);
        
        if(disponibles.isEmpty()){
            retorno = rDao.aulasSolapadas(criterio2, dia, time, dur, periodo1); 
        }else{
            retorno = disponibles;
        }
        
        
        return retorno;
     }
    
    public int obtenerMaxCapacidad(String tipoAula)throws SQLException, ClassNotFoundException{
        AulaDaoImp aDao = new AulaDaoImp();
        int capacidad = aDao.obtenerMaxCapacidad(tipoAula);
        return capacidad;
    }
     
}
    

