package sumastorecr;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class InventarioDAO {


    public void registrarProducto(int idPallet, String nombre, int cantidad, double precio, int idEstados) {
        String sql = "{CALL FIDE_INVENTARIO_TB_REGISTRAR_SP(?, ?, ?, ?, ?)}";

        try (Connection connection = ConexionOracle.getInstance().getConnection();
             CallableStatement callableStatement = connection.prepareCall(sql)) {

            callableStatement.setInt(1, idPallet);
            callableStatement.setString(2, nombre);
            callableStatement.setInt(3, cantidad);
            callableStatement.setDouble(4, precio);
            callableStatement.setInt(5, idEstados);

            callableStatement.execute();
            JOptionPane.showMessageDialog(null, "El producto se ha registrado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar  " + e.getMessage());
        }
    }

    public void editarProducto(int idInventario, int idPallet, String nombre, int cantidad, double precio, int idEstados) {
        String sql = "{CALL FIDE_INVENTARIO_TB_ACTUALIZAR_SP(?, ?, ?, ?, ?, ?)}";

        try (Connection connection = ConexionOracle.getInstance().getConnection();
             CallableStatement callableStatement = connection.prepareCall(sql)) {

            callableStatement.setInt(1, idInventario);
            callableStatement.setInt(2, idPallet);
            callableStatement.setString(3, nombre);
            callableStatement.setInt(4, cantidad);
            callableStatement.setDouble(5, precio);
            callableStatement.setInt(6, idEstados);

            callableStatement.execute();
            JOptionPane.showMessageDialog(null, "El producto se ha actualizado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar producto: " + e.getMessage());
        }
    }

    public void eliminarProducto(int idInventario) {
        String sql = "{CALL FIDE_INVENTARIO_TB_ELIMINAR_SP(?)}";

        try (Connection connection = ConexionOracle.getInstance().getConnection();
             CallableStatement callableStatement = connection.prepareCall(sql)) {

            callableStatement.setInt(1, idInventario);

            callableStatement.execute();
            JOptionPane.showMessageDialog(null, "El producto se ha eliminado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el producto " + e.getMessage());
        }
    }

    public String obtenerEstadoProducto(int idInventario) {
        String sql = "SELECT ID_ESTADOS FROM FIDE_INVENTARIO_TB WHERE FIDE_INVENTARIO_TB_ID_INVENTARIO_PK = ?";
        try (Connection connection = ConexionOracle.getInstance().getConnection();
             CallableStatement callableStatement = connection.prepareCall(sql)) {

            callableStatement.setInt(1, idInventario);

            return callableStatement.executeQuery().getString("ID_ESTADOS");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el estado del producto: " + e.getMessage());
            return null;
        }
    }
}