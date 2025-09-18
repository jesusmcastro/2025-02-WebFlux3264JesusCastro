import java.sql.Connection;
import java.util.Scanner;

public class EstudianteServicios {
    private EstudianteDAO dao = new EstudianteDAO();

    public void insertarEstudiante(Connection conn, Scanner sc) {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Apellido: ");
        String apellido = sc.nextLine();

        System.out.print("Correo: ");
        String correo = sc.nextLine();

        System.out.print("Edad: ");
        int edad = sc.nextInt();
        sc.nextLine();

        System.out.println("Estado civil (SOLTERO, CASADO, VIUDO, UNION_LIBRE, DIVORCIADO): ");
        String estadoCivil = sc.nextLine();

        Estudiante e = new Estudiante(0, nombre, apellido, correo, edad, estadoCivil);
        dao.insertar(conn, e);
    }

    public void actualizarEstudiante(Connection conn, Scanner sc) {
        System.out.print("Correo del estudiante a actualizar: ");
        String correo = sc.nextLine();

        System.out.print("Nuevo nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Nuevo apellido: ");
        String apellido = sc.nextLine();

        System.out.print("Nueva edad: ");
        int edad = sc.nextInt();
        sc.nextLine();

        System.out.println("Nuevo estado civil: ");
        String estadoCivil = sc.nextLine();

        dao.actualizar(conn, correo, nombre, apellido, edad, estadoCivil);
    }

    public void eliminarEstudiante(Connection conn, Scanner sc) {
        System.out.print("Correo del estudiante a eliminar: ");
        String correo = sc.nextLine();
        dao.eliminar(conn, correo);
    }

    public void consultarTodos(Connection conn) {
        dao.consultarTodos(conn);
    }

    public void consultarPorCorreo(Connection conn, Scanner sc) {
        System.out.print("Correo del estudiante a consultar: ");
        String correo = sc.nextLine();
        dao.consultarPorCorreo(conn, correo);
    }
}
