
package modelo.producto;


public class DatosRespuestaProducto {
    
    private final boolean status;
    private final String mensaje;

    public DatosRespuestaProducto(boolean status, String mensaje) {
        this.status = status;
        this.mensaje = mensaje;
    }

    public boolean isStatus() {
        return status;
    }

    public String getMensaje() {
        return mensaje;
    }
    
    
}
