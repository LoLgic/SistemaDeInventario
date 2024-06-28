
package modelo.usuario;


public class DatosRegistroUsuario {
    private final String nombre;
    private final String documento;
    private final String celular;
    private final String usuario;
    private final String clave;

    public DatosRegistroUsuario(String nombre, String documento, String celular, String usuario, String clave) {
        this.nombre = nombre;
        this.documento = documento;
        this.celular = celular;
        this.usuario = usuario;
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public String getCelular() {
        return celular;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }
    
    
    
}
