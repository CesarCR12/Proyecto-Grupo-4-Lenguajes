package sumastorecr;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class InventarioDAO {

    public void registrarProducto(int idInventario, int idPallet, String nombre, int cantidad, double precio) {
        String sql = "{CALL FIDE_INVENTARIO_REGISTRAR_SP(?, ?, ?, ?, ?)}";

        try (Connection connection = ConexionOracle.getInstance().getConnection();
             CallableStatement callableStatement = connection.prepareCall(sql)) {

            callableStatement.setInt(1, idInventario);
            callableStatement.setInt(2, idPallet);
            callableStatement.setString(3, nombre);
            callableStatement.setInt(4, cantidad);
            callableStatement.setDouble(5, precio);

            callableStatement.execute();
            JOptionPane.showMessageDialog(null, "El producto se agrego");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar el producto " + e.getMessage());
        }
    }

    public void editarProducto(int idInventario, int idPallet, String nombre, int cantidad, double precio) {
        String sql = "{CALL FIDE_INVENTARIO_TB_ACTUALIZAR_SP(?, ?, ?, ?, ?)}";

        try (Connection connection = ConexionOracle.getInstance().getConnection();
             CallableStatement callableStatement = connection.prepareCall(sql)) {

            callableStatement.setInt(1, idInventario);
            callableStatement.setInt(2, idPallet);
            callableStatement.setString(3, nombre);
            callableStatement.setInt(4, cantidad);
            callableStatement.setDouble(5, precio);

            callableStatement.execute();
            JOptionPane.showMessageDialog(null, "El producto se edito");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al editar el producto " + e.getMessage());
        }
    }

    public void eliminarProducto(int idInventario) {
        String sql = "{CALL FIDE_INVENTARIO_TB_ELIMINAR_SP(?)}";

        try (Connection connection = ConexionOracle.getInstance().getConnection();
             CallableStatement callableStatement = connection.prepareCall(sql)) {

            callableStatement.setInt(1, idInventario);

            callableStatement.execute();
            JOptionPane.showMessageDialog(null, "El producto se elimino");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el producto " + e.getMessage());
        }
    }
}