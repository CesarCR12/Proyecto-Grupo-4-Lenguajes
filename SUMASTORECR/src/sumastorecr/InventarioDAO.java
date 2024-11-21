/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumastorecr;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class InventarioDAO {

    public void registrarInventario(int idInventario, int idPallet, String nombre, int cantidad, double precio) {
        Connection conn = null;
        CallableStatement cstmt = null;

        try {
            conn = ConexionOracle.getInstance().getConnection();

            String sql = "{CALL FIDE_INVENTARIO_REGISTRAR_SP(?, ?, ?, ?, ?)}";
            cstmt = conn.prepareCall(sql);

            cstmt.setInt(1, idInventario);
            cstmt.setInt(2, idPallet);
            cstmt.setString(3, nombre);
            cstmt.setInt(4, cantidad);
            cstmt.setDouble(5, precio);

            cstmt.execute();
            System.out.println("Producto agregado correctamente al inventario.");

        } catch (SQLException e) {
            System.err.println("Error al agregar producto al inventario: " + e.getMessage());
        } finally {
            try {
                if (cstmt != null) cstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }
}
