
package isi.deso.tpdiseno;
//importar implementaciones 

import static java.lang.Character.isDigit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class GestorBedel {
    
    /*public boolean validarDatos(String apellido,String nombre, String usuario, String contrasenia,String cContrasenia){
       boolean validado = false; 
       return validado;
    }*/
   
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
    
    public boolean validarUsuario(String nombreUsuario) throws SQLException, ClassNotFoundException{
        boolean distintos=true;
        BedelDaoImp bdao = new BedelDaoImp(); 
        Connection connection = bdao.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("select nombreusuario from usuario");
        
        while (rs.next()) {
            if(nombreUsuario.compareTo(rs.getString("nombreusuario"))==0){
                distintos=false;
            }
        }
        connection.close(); 
        return distintos;
    }
    
   public void crearBedel(String nombre,String apellido,String turno, String nombreUsuario,String contraseña){
        Bedel b = new Bedel(turno,false,nombre,apellido,nombreUsuario,contraseña);
        BedelDaoImp bdao = new BedelDaoImp(); 
       
        bdao.registrarBedel(b);
     
   }
   
    
}
