
package controller;

import conexion.Conexion;
import dao.ClienteDAO;
import java.util.List;
import modelo.cliente.DatosEliminarCliente;
import modelo.cliente.DatosListadoCliente;
import modelo.cliente.DatosRegistrarCliente;
import modelo.cliente.DatosRespuestaCliente;


public class ClienteController {

    private final ClienteDAO clienteDAO;
    
    public ClienteController() {
        Conexion conexion = new Conexion();
        this.clienteDAO = new ClienteDAO(conexion.recuperaConexion());
    }

    public DatosRespuestaCliente registrar(DatosRegistrarCliente datosCliente) {
        return clienteDAO.registrar(datosCliente); 
    }

    public DatosRespuestaCliente eliminar(DatosEliminarCliente datosCliente) {
        return clienteDAO.eliminar(datosCliente);
    }

    public List<DatosListadoCliente> obtenerCliente() {
        return clienteDAO.obtenerCliente();
    }
    
    
}
