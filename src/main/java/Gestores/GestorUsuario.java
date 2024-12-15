package Gestores;
//aca hay q importar las implementaciones

import DaosImplementacion.UsuarioDaoImp;
import InterfazGrafica.MenuAdministrador;
import InterfazGrafica.MenuBedel;

public class GestorUsuario {
    UsuarioDaoImp usuarioDao = new UsuarioDaoImp();
    
    public boolean realizarAutenticacionYAutorizacion(String usuario, String contrasena){
        boolean encontrado = false;
        if(usuarioDao.esBedel(usuario,contrasena)){
            encontrado=true;
            MenuBedel mBedel = new MenuBedel(usuario);
            mBedel.setVisible(true);
            mBedel.setLocationRelativeTo(null);
            mBedel.setResizable(false);
        }else{
            if(usuarioDao.esAdministrador(usuario,contrasena)){
                encontrado=true;
                MenuAdministrador mAdministrador = new MenuAdministrador();
                mAdministrador.setVisible(true);
                mAdministrador.setLocationRelativeTo(null);
                mAdministrador.setResizable(false);
            }
        }
        
        return encontrado; 
    }
}
