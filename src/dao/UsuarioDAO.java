
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import modelo.DatosUsuario;


public class UsuarioDAO {

    final private Connection con;
    
    public UsuarioDAO(Connection con) {
        this.con = con;
    }

    public boolean validar(DatosUsuario datosUsuario) {
        boolean usuarioExiste = false;
        String sql = "SELECT COUNT(*) FROM usuarios WHERE"
                + " usuario = BINARY ?"
                + " AND clave = BINARY ?";
        
        try (PreparedStatement statement = con.prepareStatement(sql)){
            statement.setString(1, datosUsuario.getUsuario());
            statement.setString(2, datosUsuario.getClave());
            
            try (ResultSet resultSet = statement.executeQuery()){
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    usuarioExiste = count > 0;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuarioExiste;
    }

    public boolean registrar(DatosUsuario datosUsuario) {
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
                return true;
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            //throw new RuntimeException("Duplicaste documento."); 
            //System.out.println("Duplicas el documento");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    
}
