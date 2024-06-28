
package modelo.cliente;

public class DatosRegistrarCliente {
    
    private final String nombre;
    private final String apellido;
    private final String email;
    private final String telefono;
    private final String documento;

    public DatosRegistrarCliente(String nombre, String apellido, String email, String telefono, String documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDocumento() {
        return documento;
    }
}
