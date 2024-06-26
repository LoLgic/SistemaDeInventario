
package modelo;


public class StatusRegistro {
    
    private final boolean success;
    private final String mensaje;

    

    public StatusRegistro(boolean success, String mensaje) {
        this.success = success;
        this.mensaje = mensaje;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMensaje() {
        return mensaje;
    }

}
