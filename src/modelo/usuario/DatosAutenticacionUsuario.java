
package modelo.usuario;


public class DatosAutenticacionUsuario {
    
    private final String usuario;
    private final String clave;

    public DatosAutenticacionUsuario(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }

    
    
}
