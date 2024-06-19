
package error;


import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;


public class ErrorHandler {
    
    public static String handle(SQLException e) {
        if (e instanceof SQLIntegrityConstraintViolationException) {
            return "Documento duplicado";
        } else {
            return "Error de SQL: " + e.getMessage();
        }
    }
    
}
