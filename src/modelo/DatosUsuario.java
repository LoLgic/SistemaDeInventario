
package modelo;


public class DatosUsuario {
   
    private int id;
    private String nombre;
    private String documento;
    private String celular;
    private String usuario;
    private String clave;
    private boolean success;
    private String mensage;

    public DatosUsuario(boolean success, String mensage) {
        this.success = success;
        this.mensage = mensage;
    }

    public DatosUsuario(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    } 

    public DatosUsuario(String nombre, String documento, String celular, String usuario, String clave) {
        this.nombre = nombre;
        this.documento = documento;
        this.celular = celular;
        this.usuario = usuario;
        this.clave = clave;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public boolean isSuccess() {
        return success;
    }

    public String getMensage() {
        return mensage;
    }
   
    
}
