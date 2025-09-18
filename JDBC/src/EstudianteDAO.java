import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EstudianteDAO {

    public void insertar(Connection conn, Estudiante e) {
        String sql = "INSERT INTO estudiantes (nombre, apellido, correo, edad, estado_civil) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, e.getNombre());
            stmt.setString(2, e.getApellido());
            stmt.setString(3, e.getCorreo());
            stmt.setInt(4, e.getEdad());
            stmt.setString(5, e.getEstadoCivil());
            stmt.executeUpdate();
            System.out.println(" Estudiante insertado correctamente.");
        } catch (Exception ex) {
            System.out.println(" Error al insertar: " + ex.getMessage());
        }
    }

    public void actualizar(Connection conn, String correo, String nombre, String apellido, int edad,
            String estadoCivil) {
        String sql = "UPDATE estudiantes SET nombre=?, apellido=?, edad=?, estado_civil=? WHERE correo=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, apellido);
            stmt.setInt(3, edad);
            stmt.setString(4, estadoCivil);
            stmt.setString(5, correo);
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println(" Estudiante actualizado correctamente.");
            } else {
                System.out.println(" No se encontró estudiante con ese correo.");
            }
        } catch (Exception ex) {
            System.out.println(" Error al actualizar: " + ex.getMessage());
        }
    }

    public void eliminar(Connection conn, String correo) {
        String sql = "DELETE FROM estudiantes WHERE correo=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, correo);
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println(" Estudiante eliminado correctamente.");
            } else {
                System.out.println(" No se encontró estudiante con ese correo.");
            }
        } catch (Exception ex) {
            System.out.println(" Error al eliminar: " + ex.getMessage());
        }
    }

    public void consultarTodos(Connection conn) {
        String sql = "SELECT * FROM estudiantes";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("nombre") + " " +
                                rs.getString("apellido") + " | " +
                                rs.getString("correo") + " | " +
                                rs.getInt("edad") + " | " +
                                rs.getString("estado_civil"));
            }
        } catch (Exception ex) {
            System.out.println(" Error al consultar: " + ex.getMessage());
        }
    }

    public void consultarPorCorreo(Connection conn, String correo) {
        String sql = "SELECT * FROM estudiantes WHERE correo=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, correo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println(
                            rs.getInt("id") + " | " +
                                    rs.getString("nombre") + " " +
                                    rs.getString("apellido") + " | " +
                                    rs.getString("correo") + " | " +
                                    rs.getInt("edad") + " | " +
                                    rs.getString("estado_civil"));
                } else {
                    System.out.println(" No se encontró estudiante con ese correo.");
                }
            }
        } catch (Exception ex) {
            System.out.println(" Error al consultar por correo: " + ex.getMessage());
        }
    }
}
