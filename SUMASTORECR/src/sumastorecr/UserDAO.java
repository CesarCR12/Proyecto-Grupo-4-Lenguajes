package sumastorecr;

import sumastorecr.ConexionOracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public boolean validateLogin(String nombre, String contraseña) {
        boolean isValid = false;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Conexión a la base de datos
            ConexionOracle conexionOracle = new ConexionOracle();
            conn = conexionOracle.conectar();

            // Consulta preparada con el campo NOMBRE
            String sql = "SELECT COUNT(*) AS total FROM FIDE_CLIENTES_TB WHERE NOMBRE = ? AND CONTRASEÑA = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, contraseña);

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
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return isValid;
    }
}