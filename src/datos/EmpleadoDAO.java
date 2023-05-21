package datos;
import dominio.Empleado;
import java.sql.*;
import java.util.*;

public class EmpleadoDAO {
    //declaracion de variables
    public static final String sql_select = "select * from videocrud.empleados";
    public static final String sql_insert = "insert into  videocrud.empleados (nombre, apellido, edad, sueldo) values(?,?,?,?)";
    public static final String sql_update = "update videocrud.empleados set nombre = ?, apellido = ?, edad = ?, sueldo = ? where codigoempleado = ?";
    public static final String sql_delete = "delete from videocrud.empleados where codigoempleado = ?";
    
    //metodo mostrar para obtener todos los registros de la tabla
    public List<Empleado> mostrar(){
        Connection        conexion  = null;
        PreparedStatement sentencia = null;
        ResultSet         resultado = null;
        Empleado          empleado  = null;
        List<Empleado>    empleados = new ArrayList<>();

        try {
            conexion  = ConexionDB.getConexion();
            sentencia = conexion.prepareStatement(sql_select); 
            resultado = sentencia.executeQuery(); 

            while (resultado.next()){
                empleado = new Empleado();
                empleado.setCodigoEmpleado(resultado.getInt("codigoempleado"));
                empleado.setNombre(resultado.getString("nombre"));
                empleado.setApellido(resultado.getString("apellido"));
                empleado.setEdad(resultado.getInt("edad"));
                empleado.setSueldo(resultado.getDouble("sueldo"));
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally{
            try {
                ConexionDB.cerrar(resultado);
                ConexionDB.cerrar(sentencia);
                ConexionDB.cerrar(conexion);
            } catch (SQLException er) {
                er.printStackTrace(System.out);
            }
        }
        return empleados;
    }

    public int insertar(Empleado empleado){
        Connection        conexion  = null;
        PreparedStatement sentencia = null;
        int registro = 0;

        try {
            conexion  = ConexionDB.getConexion();
            sentencia = conexion.prepareStatement(sql_insert); 
            sentencia.setString(1, empleado.getNombre());
            sentencia.setString(2, empleado.getApellido());
            sentencia.setInt(3,empleado.getEdad());
            sentencia.setDouble(4, empleado.getSueldo());
            registro  = sentencia.executeUpdate(); 
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally{
            try {
                ConexionDB.cerrar(sentencia);
                ConexionDB.cerrar(conexion);
            } catch (SQLException er) {
                er.printStackTrace(System.out);
            }
        }
        return registro;
    }

    public int actualizar(Empleado empleado){
        Connection        conexion  = null;
        PreparedStatement sentencia = null;
        int registro = 0;

        try {
            conexion  = ConexionDB.getConexion();
            sentencia = conexion.prepareStatement(sql_update); 
            sentencia.setString(1, empleado.getNombre());
            sentencia.setString(2, empleado.getApellido());
            sentencia.setInt(3,empleado.getEdad());
            sentencia.setDouble(4, empleado.getSueldo());
            sentencia.setInt(5, empleado.getCodigoEmpleado());
            registro  = sentencia.executeUpdate(); 
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally{
            try {
                ConexionDB.cerrar(sentencia);
                ConexionDB.cerrar(conexion);
            } catch (SQLException er) {
                er.printStackTrace(System.out);
            }
        }
        return registro;
    }

    public int eliminar(Empleado empleado){
        Connection        conexion  = null;
        PreparedStatement sentencia = null;
        int registro = 0;

        try {
            conexion  = ConexionDB.getConexion();
            sentencia = conexion.prepareStatement(sql_delete); 
            sentencia.setInt(1, empleado.getCodigoEmpleado());
            registro  = sentencia.executeUpdate(); 
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally{
            try {
                ConexionDB.cerrar(sentencia);
                ConexionDB.cerrar(conexion);
            } catch (SQLException er) {
                er.printStackTrace(System.out);
            }
        }
        return registro;
    }
}