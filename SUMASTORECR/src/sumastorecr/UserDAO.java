package sumastorecr;

import Conexion.ConexionOracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    // Método para validar las credenciales de login
    public boolean validateLogin(String Usuario, String Contraseña) {
        boolean isValid = false;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Conexión a la base de datos utilizando ConexionOracle
            ConexionOracle conexionOracle = new ConexionOracle();
            conn = conexionOracle.conectar();

            // Consulta preparada para evitar inyección SQL
            // Se cambia 'password' por 'CONTRASEÑA' para que coincida con el nombre de la columna en la base de datos
            String sql = "SELECT COUNT(*) AS total FROM FIDE_USUARIOS_TB WHERE Usuario = ? AND CONTRASEÑA = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, Usuario);
            ps.setString(2, Contraseña);

            // Ejecutar la consulta
            rs = ps.executeQuery();

            if (rs.next()) {
                // Validar si existe un registro que coincida
                isValid = rs.getInt("total") > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return isValid;
    }
}




