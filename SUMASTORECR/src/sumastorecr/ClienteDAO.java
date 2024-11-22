package sumastorecr;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClienteDAO {

    public ClienteDAO() {
    }

    public void insertarCliente(RegistroClientes cliente) {
        String sql = "{CALL FIDE_CLIENTES_TB_INSERTAR_CLIENTE_SP(?, ?, ?, ?)}";

        try (Connection connection = ConexionOracle.getInstance().getConnection();
             CallableStatement callableStatement = connection.prepareCall(sql)) {

            callableStatement.setString(1, cliente.getNombre());
            callableStatement.setString(2, cliente.getCorreo());
            callableStatement.setString(3, cliente.getContrasena());
            callableStatement.setString(4, cliente.getTelefono());

            callableStatement.execute();
            JOptionPane.showMessageDialog(null, "El cliente se ha agregado");

        } catch (SQLException e) {
            throw new RuntimeException("Error al agregar el cliente " + e.getMessage(), e);
        }
    }
}
