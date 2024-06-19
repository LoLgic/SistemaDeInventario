
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conexion {
                                                            
    public Connection recuperaConexion() {
        try {
            return DriverManager.getConnection(                
                    "jdbc:mysql://localhost/sistema_inventario?createDatabaseIfNotExist=true&serverTimezone=UTC",
                    "root",
                    ""
            );
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
}
