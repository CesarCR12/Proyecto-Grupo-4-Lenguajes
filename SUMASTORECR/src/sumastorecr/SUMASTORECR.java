/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sumastorecr;



/**
 *
 * @author XSF
 */
public class SUMASTORECR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        InventarioDAO dao = new InventarioDAO();

        dao.registrarInventario(4, 101, "Producto X", 50, 25.75);
    }
}
