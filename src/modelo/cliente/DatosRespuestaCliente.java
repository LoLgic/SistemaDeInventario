
package modelo.cliente;

public class DatosRespuestaCliente {
    
    private final boolean status;
    private final String mensaje;

    public DatosRespuestaCliente(boolean status, String mensaje) {
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
