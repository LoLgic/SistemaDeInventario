
package controller;

import conexion.Conexion;
import dao.UsuarioDAO;
import modelo.usuario.DatosAutenticacionUsuario;
import modelo.usuario.DatosRegistroUsuario;
import modelo.usuario.DatosRespuestaUsuario;


public class UsuarioController {

    private final UsuarioDAO usuarioDAO;
    
    public UsuarioController() {
        Conexion conexion = new Conexion();
        this.usuarioDAO = new UsuarioDAO(conexion.recuperaConexion());
    }
    
    public DatosRespuestaUsuario validar(DatosAutenticacionUsuario datosUsuario) {
        return usuarioDAO.validar(datosUsuario);
    }

    public DatosRespuestaUsuario registrar(DatosRegistroUsuario datosUsuario) {
        return usuarioDAO.registrar(datosUsuario);
    }
    
    
}
