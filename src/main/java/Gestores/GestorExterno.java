package Gestores;

import DaosImplementacion.ExternoDaoImp;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GestorExterno {
    
    public ArrayList<String> obtenerDocentes(){
        ArrayList<String> docentes = new ArrayList<>();
        
        try {
            ExternoDaoImp extDao = new ExternoDaoImp();
            docentes=extDao.obtenerDocentes();
        } catch (SQLException ex) {
            Logger.getLogger(GestorAula.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAula.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return docentes;
    }
    
    public ArrayList<String> obtenerCatedras(){
        ArrayList<String> catedras = new ArrayList<>();
        
        try {
            ExternoDaoImp extDao = new ExternoDaoImp();
            catedras=extDao.obtenerCatedras();
        } catch (SQLException ex) {
            Logger.getLogger(GestorAula.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAula.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return catedras;
    }
    
    public String obtenerNombreDocente(String docente) throws SQLException, ClassNotFoundException{
        ExternoDaoImp extDao = new ExternoDaoImp();
        String nombre=extDao.obtenerNombreDocente(docente);
        return nombre;
    }
            
    public String obtenerApellidDocente(String docente)throws SQLException, ClassNotFoundException{
        ExternoDaoImp extDao = new ExternoDaoImp();
        String apellido=extDao.obtenerApellidoDocente(docente);
        return apellido;
    }
    
    public String buscarNombreActividad(String actividad)throws SQLException, ClassNotFoundException{
        ExternoDaoImp extDao = new ExternoDaoImp();
        String actividad1=extDao.buscarNombreActividad(actividad);
        return actividad1;
    }
    
    public int buscarIdActividad(String actividad)throws SQLException, ClassNotFoundException{
        ExternoDaoImp extDao = new ExternoDaoImp();
        int actividad1=extDao.buscarIdActividad(actividad);
        return actividad1;
    }
    
}
