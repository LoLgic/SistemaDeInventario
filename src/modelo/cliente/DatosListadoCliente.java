
package modelo.cliente;

public class DatosListadoCliente {
    private final int id;
    private final String nombre;
    private final String apellido;
    private final String email;
    private final String celular;
    private final String documento;

    public DatosListadoCliente(int id, String nombre, String apellido, String email, String celular, String documento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.celular = celular;
        this.documento = documento;
    }

    public int getId() {
        return id;
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

    public String getCelular() {
        return celular;
    }

    public String getDocumento() {
        return documento;
    }
    
    
    
}
