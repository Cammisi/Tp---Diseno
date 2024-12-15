
package Gestores;
//importar implementaciones 

import Clases.Bedel;
import DaosImplementacion.BedelDaoImp;
import Dtos.BedelDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class GestorBedel {
    
    public boolean crearBedel(String nombre,String apellido,String turno, String nombreUsuario,String contraseña,String confirmarContraseña) throws SQLException, ClassNotFoundException{
        //boolean flagEliminado=false;
        boolean flag=true;
        int i=0;
        ArrayList<String> datos = new ArrayList();
        datos.add(apellido);
        datos.add(nombre);
        datos.add(turno);
        datos.add(nombreUsuario);
        datos.add(contraseña);
        datos.add(confirmarContraseña);
       
        while(i<6 && flag){
            flag=validarVacio(datos.get(i));          
            if((i==0 && flag) || (i==1 && flag)){
                flag=validarLongitud(datos.get(i),i);
                if(flag){flag=validarNotDigit(datos.get(i));}
            }
            if(i==3 && flag){
                flag=validarCampoUsuario(datos.get(i));
            }
            if(i==4 && flag){
                flag=validarContrasena(datos.get(i));
                if(flag){flag=validarConfirmarContrasena(datos.get(i),datos.get(i+1));}
            }
            i++;
        }

        if(flag){flag=validarUsuario(nombreUsuario);}
        //if(flag){flagEliminado=validarEliminado(nombreUsuario);}
        
        BedelDaoImp bdao = new BedelDaoImp(); 
        if(flag /*&& !flagEliminado*/){
            Bedel b = new Bedel(turno,false,nombre,apellido,nombreUsuario,contraseña);
            bdao.registrarBedel(b);
        }/*else if(flag && flagEliminado){
            Bedel b = new Bedel(turno,false,nombre,apellido,nombreUsuario,contraseña);
            bdao.modificarBedel(b);
        }*/
      
        return flag;
    }
    
    public boolean validarVacio(String str){
        boolean flag=true;
        if(str.isBlank() || str.equals("Escribe aquí...") || str.equals("Seleccionar")){
            flag=false;
        }
       return flag;  
    }
    
    public boolean validarLongitud(String str,int i){
        boolean flag=true;
        switch(i){
            case 0:
                if(str.length()>100){flag=false;}
                break;
            case 1:
                if(str.length()>100){flag=false;}
                break;
            case 3:
                if(str.length()>20){flag=false;}
                break;
            case 5:
                if(str.length()>30){flag=false;}
                break;        
        }
        return flag;
    }
    
    public boolean validarNotDigit(String str){
        boolean flag=true;
        if(!str.matches("[a-zA-ZáéíóúüñÁÉÍÓÚÜÑ ]+")){
            flag = false;
        }
        return flag;
    }
    
    public boolean validarContrasena(String str){
       boolean flag=true;
       int cantMayusculas=0, cantNumeros=0;
       if(str.length()>7 && str.length()<31){
           for(int i=0; i<str.length(); i++){
               if(str.charAt(i)>64 && str.charAt(i)<91){
                   cantMayusculas++;
               }else{
                    if(str.charAt(i)>47 && str.charAt(i)<58){
                        cantNumeros++;
                    }
               }
           } 
           if(!(cantNumeros>0 && cantMayusculas>0)){
               flag=false;
           }
        }else{
           flag = false;
        }
        return flag;
    }
    
    public boolean validarConfirmarContrasena(String str1, String str2){
        boolean flag=true;
        if(str1.compareTo(str2)!=0){
            flag=false;
        }
        return flag;
    }
    
    public boolean validarCampoUsuario(String str){
       boolean flag=true;
       int cantLetras=0, cantNumeros=0;
       if(str.length()>3 && str.length()<21){
           for(int i=0; i<str.length(); i++){
               if((str.charAt(i)>64 && str.charAt(i)<91) || (str.charAt(i)>94 && str.charAt(i)<123)){
                   cantLetras++;
               }else{
                    if(str.charAt(i)>47 && str.charAt(i)<58){
                        cantNumeros++;
                    }
               }
               if(str.charAt(i)==' '){
                   flag=false;
               }
           } 
           if(!(cantNumeros>0 && cantLetras>0)){
               flag=false;
           }
        }else{
           flag = false;
        }
        return flag;
    }
    
    public ArrayList<BedelDTO> transformarABedelDTO(ArrayList<Bedel> listaBedeles) {
        ArrayList<BedelDTO> listaDTO = new ArrayList<>();

        for (Bedel bedel : listaBedeles) {
            BedelDTO dto = new BedelDTO(
                bedel.getNombre(),
                bedel.getApellido(),
                bedel.getTurno(),
                bedel.getNombreUsuario()
            );
            listaDTO.add(dto);
        }

        return listaDTO;
    }
    
    public ArrayList<BedelDTO> buscarBedeles(String apellido,String turno) throws SQLException, ClassNotFoundException{
        ArrayList<Bedel> bedeles = new ArrayList<>();
        ArrayList<BedelDTO> listaDTO = new ArrayList<>();
        BedelDaoImp bdao = new BedelDaoImp();
       
        bedeles = bdao.buscarBedel(apellido,turno);
        listaDTO = transformarABedelDTO(bedeles);
        return listaDTO;
    }
    
    
    public boolean validarUsuario(String nombreUsuario) throws SQLException, ClassNotFoundException{
        boolean distintos=true;
        BedelDaoImp bdao = new BedelDaoImp(); 
        Connection connection = bdao.getConnection();
        try{
            connection.setAutoCommit(false);
            String sqlUsuario = "SELECT nombreusuario FROM public.bedel WHERE nombreusuario=?";
            try(PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario)){
                pstmtUser.setString(1, nombreUsuario);
                ResultSet rs = pstmtUser.executeQuery();
                
                if(rs.next()){
                    distintos=false;
                }
                connection.commit();
            }
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
            
        return distintos;
    }
    
    public boolean validarEliminado(String nombreUsuario) throws SQLException, ClassNotFoundException{
        boolean eliminado=true;
        BedelDaoImp bdao = new BedelDaoImp(); 
        Connection connection = bdao.getConnection();
        try{
            connection.setAutoCommit(false);
            String sqlUsuario = "SELECT eliminado FROM public.bedel WHERE nombreusuario=?";
            try(PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario)){
                pstmtUser.setString(1, nombreUsuario);
                ResultSet rs = pstmtUser.executeQuery();
                
                if(rs.next()){
                    if(!rs.getBoolean("eliminado")){
                        eliminado=false;
                    }  
                }else{
                    eliminado=false;
                }
                
                connection.commit();
            }
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
            
        return eliminado;
    }
    
    
    public void eliminarBedel(BedelDTO unBedel) throws SQLException, ClassNotFoundException{
        BedelDaoImp bdao = new BedelDaoImp(); 
        Bedel bedel = bdao.buscarBedel(unBedel.getNombreUsuario());
        bedel.setEliminado(true);
        bdao.eliminarBedel(bedel);
    }
    
    public String recuperarContrasena(String nombreUsuario) throws SQLException, ClassNotFoundException{
        String clave = "";
        
        BedelDaoImp bdao = new BedelDaoImp(); 
        Connection connection = bdao.getConnection();
        String sqlUsuario = "SELECT contrasena FROM public.usuario WHERE nombreusuario=?";
        PreparedStatement pstmtUser = connection.prepareStatement(sqlUsuario);
        pstmtUser.setString(1, nombreUsuario);
        ResultSet rs = pstmtUser.executeQuery();
        
        if(rs.next()){
            clave = rs.getString("contrasena");;
        }
        connection.close();
        return clave; 
    }
    
    public boolean modificarBedel(String nombre,String  apellido,String turno,String nombreUsuario,String  contraseña,String confirmarContraseña) throws SQLException, ClassNotFoundException{
        boolean flag=true;
        int i=0;
        ArrayList<String> datos = new ArrayList();
        datos.add(apellido);
        datos.add(nombre);
        datos.add(turno);
        datos.add(contraseña);
        datos.add(confirmarContraseña);
       
        while(i<5 && flag){
            flag=validarVacio(datos.get(i));          
            if((i==0 && flag) || (i==1 && flag)){
                flag=validarLongitud(datos.get(i),i);
                if(flag){flag=validarNotDigit(datos.get(i));}
            }
            if(i==3 && flag){
                flag=validarContrasena(datos.get(i));
                if(flag){flag=validarConfirmarContrasena(datos.get(i),datos.get(i+1));}
            }
            i++;
        }

        if(flag){
            
            BedelDaoImp bdao = new BedelDaoImp();         
            Bedel bedel = bdao.buscarBedel(nombreUsuario);
            bedel.setEliminado(false);
            bedel.setApellido(apellido);
            bedel.setNombre(nombre);
            bedel.setContrasenia(contraseña);
            bedel.setTurno(turno);
            
            bdao.modificarBedel(bedel);
        }
        return flag;
    }
}

