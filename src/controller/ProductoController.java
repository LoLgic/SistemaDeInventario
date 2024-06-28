
package controller;

import conexion.Conexion;
import dao.ProductoDAO;
import java.util.List;
import modelo.producto.DatosEliminarProducto;
import modelo.producto.DatosListadoProducto;
import modelo.producto.DatosRegistroProducto;
import modelo.producto.DatosRespuestaProducto;


public class ProductoController {

    private final ProductoDAO productoDAO;
    
    public ProductoController() {
        Conexion conexion = new Conexion();
        this.productoDAO = new ProductoDAO(conexion.recuperaConexion());
    }
    
    public List<DatosListadoProducto> obtenerProductos() {
        return productoDAO.obtenerProductos();
    }
   
    public DatosRespuestaProducto agregar(DatosRegistroProducto datosProducto) {
        return productoDAO.agregar(datosProducto);
    }
    
    public DatosRespuestaProducto eliminar(DatosEliminarProducto datosProducto) {
        return productoDAO.eliminar(datosProducto);
    } 
}
