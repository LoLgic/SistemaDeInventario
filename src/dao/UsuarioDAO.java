
package dao;

import error.ErrorHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.usuario.DatosAutenticacionUsuario;
import modelo.usuario.DatosRegistroUsuario;
import modelo.usuario.DatosRespuestaUsuario;


public class UsuarioDAO {

    final private Connection con;
    
    public UsuarioDAO(Connection con) {
        this.con = con;
    }
    
    public DatosRespuestaUsuario validar(DatosAutenticacionUsuario datosUsuario) {
        String sql = "SELECT COUNT(*) FROM usuarios WHERE"
                + " usuario = BINARY ?"
                + " AND clave = BINARY ?";
        
        try (PreparedStatement statement = con.prepareStatement(sql)){
            statement.setString(1, datosUsuario.getUsuario());
            statement.setString(2, datosUsuario.getClave());
            
            try (ResultSet resultSet = statement.executeQuery()){
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    if (count > 0) {
                        return new DatosRespuestaUsuario(true, "");
                    }
                }
            }
            return new DatosRespuestaUsuario(false, "Usuario o clave incorrecta.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }


    public DatosRespuestaUsuario registrar(DatosRegistroUsuario datosUsuario) {
        String sql = "INSERT INTO usuarios"
                + "(nombre, documento, celular, usuario, clave)"
                + "VALUES (?,?,?,?,?)";
        try (PreparedStatement statement = con.prepareStatement(sql)){
            statement.setString(1, datosUsuario.getNombre());
            statement.setString(2, datosUsuario.getDocumento());
            statement.setString(3, datosUsuario.getCelular());
            statement.setString(4, datosUsuario.getUsuario());
            statement.setString(5, datosUsuario.getClave());
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                return new DatosRespuestaUsuario(true,"Usuario registrado exitosamente.");
            }
        } catch (SQLException e) {
            String mensaje = ErrorHandler.handle(e);
            return new DatosRespuestaUsuario(false, mensaje);
        }
        return new DatosRespuestaUsuario(false, "Error desconocido al registrar el usuario.");
    }
    
}
