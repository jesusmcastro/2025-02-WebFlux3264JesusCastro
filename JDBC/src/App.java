import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class App {
    static String url = "jdbc:mysql://localhost:3306/TestDB";
    static String userName = "root";
    static String password = "12345";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            EstudianteServicios servicios = new EstudianteServicios();
            Scanner sc = new Scanner(System.in);

            int opcion;
            do {
                System.out.println("\n===== MENÚ ESTUDIANTES =====");
                System.out.println("1. Insertar Estudiante");
                System.out.println("2. Actualizar Estudiante");
                System.out.println("3. Eliminar Estudiante");
                System.out.println("4. Consultar todos los estudiantes");
                System.out.println("5. Consultar estudiante por correo");
                System.out.println("6. Salir");
                System.out.print("Elige una opcion: ");
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        servicios.insertarEstudiante(conn, sc);
                        break;
                    case 2:
                        servicios.actualizarEstudiante(conn, sc);
                        break;
                    case 3:
                        servicios.eliminarEstudiante(conn, sc);
                        break;
                    case 4:
                        servicios.consultarTodos(conn);
                        break;
                    case 5:
                        servicios.consultarPorCorreo(conn, sc);
                        break;
                    case 6:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opcion no válida.");
                }
            } while (opcion != 6);

            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
    }
}
