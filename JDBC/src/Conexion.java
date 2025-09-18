import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/TestDB";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "12345";

    private static Connection conexion = null;

    public static Connection getConexion() {
        try {
            if (conexion == null || conexion.isClosed()) {
                conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
                System.out.println(" Conexión establecida con la base de datos");
            }
        } catch (SQLException e) {
            System.out.println(" Error al conectar: " + e.getMessage());
        }
        return conexion;
    }
}
