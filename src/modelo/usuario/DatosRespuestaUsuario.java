
package modelo.usuario;


public class DatosRespuestaUsuario {
    
    private final boolean status;
    private final String mensaje;

    public DatosRespuestaUsuario(boolean status, String mensaje) {
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
