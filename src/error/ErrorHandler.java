
package error;


import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;


public class ErrorHandler {
    
    public static String handle(SQLException e) {
        if (e instanceof SQLIntegrityConstraintViolationException) {
            return "Este número de Documento ya está en uso";
        } else {
            return "Error de SQL: " + e.getMessage();
        }
    }
    
}
