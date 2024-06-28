
package dao;

import error.ErrorHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.cliente.DatosEliminarCliente;
import modelo.cliente.DatosListadoCliente;
import modelo.cliente.DatosRegistrarCliente;
import modelo.cliente.DatosRespuestaCliente;
import modelo.producto.DatosRespuestaProducto;


public class ClienteDAO {
    
    final private Connection con;

    public ClienteDAO(Connection con) {
        this.con = con;
    }

    public DatosRespuestaCliente registrar(DatosRegistrarCliente datosCliente) {
        String sql = "INSERT INTO clientes"
                + "(nombre, apellido, email, celular, documento)"
                + "VALUES (?,?,?,?,?)";
        
        try (PreparedStatement statement = con.prepareStatement(sql)){
            statement.setString(1, datosCliente.getNombre());
            statement.setString(2, datosCliente.getApellido());
            statement.setString(3, datosCliente.getEmail());
            statement.setString(4, datosCliente.getTelefono());
            statement.setString(5, datosCliente.getDocumento());
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                return new DatosRespuestaCliente(true, "Cliente registrado exitosamente.");
            } else {
                return new DatosRespuestaCliente(false, "Error desconocido al registrar el usuario.");
            }
            
        } catch (SQLException e) {
            String mensaje = ErrorHandler.handle(e);
            return new DatosRespuestaCliente(false, mensaje);
        }
    }

    public DatosRespuestaCliente eliminar(DatosEliminarCliente datosCliente) {
        String sql = "DELETE FROM clientes WHERE id = ?";
        
        try (PreparedStatement statement = con.prepareStatement(sql)){
            statement.setInt(1, datosCliente.getId());
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                return new DatosRespuestaCliente(true, "Cliente eliminado.");
            } else {
                return new DatosRespuestaCliente(false, "No se encontró ningún producto con el id proporcionado.");
            }
            
        } catch (SQLException e) {
            String mensaje = ErrorHandler.handle(e);
            return new DatosRespuestaCliente(false, mensaje);
        }
        
    }

    public List<DatosListadoCliente> obtenerCliente() {
        List<DatosListadoCliente> listadoClientes;
        listadoClientes = new ArrayList<>();
        
        String sql = "SELECT * FROM clientes";
        
        try (PreparedStatement statement = con.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()){
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String email = resultSet.getString("email");
                String celular = resultSet.getString("celular");
                String documento = resultSet.getString("documento");
                
                DatosListadoCliente listadoCliente = new DatosListadoCliente(id, nombre, apellido, email, celular, documento);
                listadoClientes.add(listadoCliente);
            }
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listadoClientes;
    }
    
    
    
}
