
package datos;
import java.sql.*;

public class ConexionDB{
    //declaracion variables
    private static final String url  = "jdbc:mysql://localhost:3306/videocrud?serverTimezone=UTC"; 
    private static final String user = "root";
    private static final String pass = "123456";

    //metodo para obtener la conexion
    public static Connection getConexion() throws SQLException{
        return DriverManager.getConnection(url, user, pass);
    }

    //metodo para cerrar la conexion
    public static void cerrar(Connection conn) throws SQLException{
        conn.close();
    }

    //metodo para cerrar la Sentencia
    public static void cerrar(Statement sentencia) throws SQLException{
        sentencia.close();
    }

    //metodo para cerrar PreparedStatement
    public static void cerrar(PreparedStatement sentencia) throws SQLException{
        sentencia.close();
    }

    //metodo para cerrar Resulset
    public static void cerrar(ResultSet resultado) throws SQLException{
        resultado.close();
    }
}