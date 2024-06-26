
package modelo;


public class StatusProducto {
    
    private final boolean success;
    private final String mensaje;
    
    public StatusProducto(boolean success, String mensaje) {
        this.success = success;
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public boolean isSuccess() {
        return success;
    }

    
}
