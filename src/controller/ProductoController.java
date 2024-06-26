
package controller;

import conexion.Conexion;
import dao.ProductoDAO;
import java.util.List;
import modelo.DatosProducto;
import modelo.StatusProducto;


public class ProductoController {

    private final ProductoDAO productoDAO;
    
    public ProductoController() {
        Conexion conexion = new Conexion();
        this.productoDAO = new ProductoDAO(conexion.recuperaConexion());
    }
    
    public List<DatosProducto> obtenerProductos() {
        return productoDAO.obtenerProductos();
    }
   
    public StatusProducto agregar(DatosProducto datosProducto) {
        return productoDAO.agregar(datosProducto);
    }
    
    public StatusProducto eliminar(DatosProducto datosProducto) {
        return productoDAO.eliminar(datosProducto);
    } 
}
