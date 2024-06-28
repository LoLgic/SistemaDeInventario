
package modelo.producto;


public class DatosRegistroProducto {
    private final String nombre;
    private final String precio;
    private final String cantidad;
    private final String iva;
    private final String descripcion;
    private final String categoria;

    public DatosRegistroProducto(String nombre, String precio, String cantidad, String iva, String descripcion, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.iva = iva;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public String getCantidad() {
        return cantidad;
    }

    public String getIva() {
        return iva;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCategoria() {
        return categoria;
    }
    
    
    
}
