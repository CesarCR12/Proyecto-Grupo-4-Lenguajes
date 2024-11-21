/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumastorecr;

/**
 *
 * @author XSF
 */
public class registro_producto {
    int ID_INVENTARIO;
    int ID_PALLET;
    String NOMBRE;
    int CANTIDAD;
    int PRECIO;

    public registro_producto() {
    }

    public registro_producto(int ID_INVENTARIO, int ID_PALLET, String NOMBRE, int CANTIDAD, int PRECIO) {
        this.ID_INVENTARIO = ID_INVENTARIO;
        this.ID_PALLET = ID_PALLET;
        this.NOMBRE = NOMBRE;
        this.CANTIDAD = CANTIDAD;
        this.PRECIO = PRECIO;
    }

    public int getID_INVENTARIO() {
        return ID_INVENTARIO;
    }

    public void setID_INVENTARIO(int ID_INVENTARIO) {
        this.ID_INVENTARIO = ID_INVENTARIO;
    }

    public int getID_PALLET() {
        return ID_PALLET;
    }

    public void setID_PALLET(int ID_PALLET) {
        this.ID_PALLET = ID_PALLET;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public int getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(int CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }

    public int getPRECIO() {
        return PRECIO;
    }

    public void setPRECIO(int PRECIO) {
        this.PRECIO = PRECIO;
    }
}

