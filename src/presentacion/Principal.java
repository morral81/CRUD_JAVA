package presentacion;
import datos.EmpleadoDAO;
import dominio.Empleado;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        /*mostrar empleado */
        /*EmpleadoDAO empleadoDao = new EmpleadoDAO();
        List<Empleado> empleados = empleadoDao.mostrar();

        for (Empleado emp : empleados) {
            System.out.println(emp.toString());
        }*/

        /*insertar empleado */
        /*  EmpleadoDAO empleadoDao   = new EmpleadoDAO();
        Empleado empleadoInsertar = new Empleado("Karla", "Romero", 40, 1500.50);
        int registroAfectodor     = empleadoDao.insertar(empleadoInsertar); 

        List<Empleado> empleados = empleadoDao.mostrar();
        for (Empleado emp : empleados) {
            System.out.println(emp.toString());
        }*/


        /*actualizar empleado */
        /* 
        EmpleadoDAO empleadoDao     = new EmpleadoDAO();
        Empleado empleadoActualizar = new Empleado(7,"Karla", "Romero", 40, 1800.00);
        int registroAfectodor       = empleadoDao.actualizar(empleadoActualizar); 

        List<Empleado> empleados    = empleadoDao.mostrar();
        for (Empleado emp : empleados) {
            System.out.println(emp.toString());
        }*/
    
        /*eliminar empleado */
        EmpleadoDAO empleadoDao     = new EmpleadoDAO();
        Empleado empleadoEliminar   = new Empleado(5);
        int registroAfectodor       = empleadoDao.eliminar(empleadoEliminar); 

        List<Empleado> empleados    = empleadoDao.mostrar();
        for (Empleado emp : empleados) {
            System.out.println(emp.toString());
        }




    }
}
