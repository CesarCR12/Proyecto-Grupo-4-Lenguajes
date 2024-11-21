package sumastorecr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionOracle {

    private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    private final String USER = "SUMASTORECR";
    private final String PASSWORD = "12345";

    private static ConexionOracle instancia;
    private Connection cadena;

    ConexionOracle() {
        this.cadena = null;
        conectar();
    }

    public static ConexionOracle getInstance() {
        if (instancia == null) {
            instancia = new ConexionOracle();
        }
        return instancia;
    }

    private void conectar() {
        try {
            Class.forName(DRIVER);
            this.cadena = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos: " + e.getMessage());
            System.exit(0);
        }
    }

    public Connection getConnection() {
        return this.cadena;
    }

    public void desconectar() {
        if (this.cadena != null) {
            try {
                this.cadena.close();
                System.out.println("Conexión cerrada.");
                this.cadena = null;
                instancia = null;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
