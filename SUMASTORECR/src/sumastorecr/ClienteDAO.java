package sumastorecr;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClienteDAO {

    private final ConexionOracle conexionOracle;

    public ClienteDAO() {
        this.conexionOracle = new ConexionOracle();
    }

    public void insertarCliente(RegistroClientes cliente) {
        String sql = "{CALL FIDE_CLIENTES_TB_INSERTAR_CLIENTE_SP(?, ?, ?, ?)}";

        Connection connection = null;
        CallableStatement callableStatement = null;

        try {
            connection = conexionOracle.getConnection();
            callableStatement = connection.prepareCall(sql);

            callableStatement.setString(1, cliente.getNombre());
            callableStatement.setString(2, cliente.getCorreo());
            callableStatement.setString(3, cliente.getContrasena());
            callableStatement.setString(4, cliente.getTelefono());

            callableStatement.execute();
            JOptionPane.showMessageDialog(null, "Cliente insertado exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar cliente: " + e.getMessage());
        } finally {
            try {
                if (callableStatement != null) callableStatement.close();
                if (connection != null) conexionOracle.desconectar();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
