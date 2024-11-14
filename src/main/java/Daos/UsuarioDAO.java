
package Daos;


public interface UsuarioDAO {
    
   public boolean esBedel(String usuario, String contrasena); 
    public boolean esAdministrador(String usuario,String contrasena);
}
