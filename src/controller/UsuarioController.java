
package controller;

import conexion.Conexion;
import dao.UsuarioDAO;
import modelo.DatosUsuario;
import modelo.StatusRegistro;


public class UsuarioController {

    private final UsuarioDAO usuarioDAO;
    
    public UsuarioController() {
        Conexion conexion = new Conexion();
        this.usuarioDAO = new UsuarioDAO(conexion.recuperaConexion());
    }
    
    public DatosUsuario validar(DatosUsuario datosUsuario) {
        return usuarioDAO.validar(datosUsuario);
    }

    public StatusRegistro registrar(DatosUsuario datosUsuario) {
        return usuarioDAO.registrar(datosUsuario);
    }
    
    
}
