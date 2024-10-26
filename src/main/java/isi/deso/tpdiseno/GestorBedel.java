
package isi.deso.tpdiseno;
//importar implementaciones 

import static java.lang.Character.isDigit;


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
                if(str.length()>5){flag=false;}
                break;
            case 1:
                if(str.length()>5){flag=false;}
                break;
            case 3:
                if(str.length()>5){flag=false;}
                break;
            case 4:
                if(str.length()>5){flag=false;}
                break;
            case 5:
                if(str.length()>5){flag=false;}
                break;        
        }
        return flag;
    }
    
    public boolean validarNotDigit(String str){
        boolean flag=true;
        for(int i=0; i<str.length(); i++){
            if( isDigit(str.charAt(i)) ){
                flag=false;
            }
        }
        return flag;
    }
}
