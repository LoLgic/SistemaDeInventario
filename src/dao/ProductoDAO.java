
package dao;

import error.ErrorHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.DatosProducto;
import modelo.StatusProducto;


public class ProductoDAO {
    
    final private Connection con;

    public ProductoDAO(Connection con) {
        this.con = con;
    }
    
    
    public List<DatosProducto> obtenerProductos() {
        List<DatosProducto> datosProductos;
        datosProductos = new ArrayList<>();
        
        String sql = "SELECT * FROM productos";
        
        try (PreparedStatement statement = con.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()) {
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String precio = resultSet.getString("precio");
                String cantidad = resultSet.getString("cantidad");
                String iva = resultSet.getString("iva");
                String descripcion = resultSet.getString("descripcion");
                String categoria = resultSet.getString("categoria");
                
                DatosProducto datosProducto = new DatosProducto(id, nombre, precio, cantidad, iva, descripcion, categoria);
                datosProductos.add(datosProducto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return datosProductos;   
    } 

    public StatusProducto agregar(DatosProducto datosProducto) {
        String sql = "INSERT INTO productos"
                + "(nombre, precio, cantidad, iva, descripcion, categoria)"
                + "VALUES (?,?,?,?,?,?)";
        try (PreparedStatement statement = con.prepareStatement(sql)){
            statement.setString(1, datosProducto.getNombre());
            statement.setString(2, datosProducto.getPrecio());
            statement.setString(3, datosProducto.getCantidad());
            statement.setString(4, datosProducto.getIva());
            statement.setString(5, datosProducto.getDescripcion());
            statement.setString(6, datosProducto.getCantidad());
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                return new StatusProducto(true,"Producto agregado exitosamente.");
            }
        } catch (SQLException e) {
            String mensaje = ErrorHandler.handle(e);
            return new StatusProducto(false, mensaje);
        }
        return new StatusProducto(false, "Error desconocido al registrar el usuario.");
    }

   
    
    public StatusProducto eliminar(DatosProducto datosProducto) {
        String sql = "DELETE FROM productos WHERE id = ?";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, datosProducto.getId());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                return new StatusProducto(true, "Producto eliminado.");
            } else {
                return new StatusProducto(false, "No se encontró ningún producto con el id proporcionado.");
            }
            
        } catch (SQLException e) {
            String mensaje = ErrorHandler.handle(e);
            return new StatusProducto(false, mensaje);
        }
    }
}
