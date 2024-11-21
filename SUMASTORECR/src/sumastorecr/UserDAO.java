package sumastorecr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public boolean validateLogin(String nombre, String contraseña) {
        boolean isValid = false;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Connection conn = ConexionOracle.getInstance().getConnection();

            String sql = "SELECT COUNT(*) AS total FROM FIDE_CLIENTES_TB WHERE NOMBRE = ? AND CONTRASEÑA = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, contraseña);

            rs = ps.executeQuery();

            if (rs.next()) {
                isValid = rs.getInt("total") > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return isValid;
    }
}