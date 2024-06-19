
package controller;

import conexion.Conexion;
import dao.UsuarioDAO;
import modelo.DatosUsuario;


public class UsuarioController {

    private final UsuarioDAO usuarioDAO;
    
    public UsuarioController() {
        Conexion conexion = new Conexion();
        this.usuarioDAO = new UsuarioDAO(conexion.recuperaConexion());
    }
    
    public boolean validar(DatosUsuario datosUsuario) {
        return usuarioDAO.validar(datosUsuario);
    }

    public boolean registrar(DatosUsuario datosUsuario) {
        return usuarioDAO.registrar(datosUsuario);
    }
    
    
}
