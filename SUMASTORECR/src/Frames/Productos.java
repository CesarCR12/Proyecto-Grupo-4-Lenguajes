/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sumastorecr.ConexionOracle;
import sumastorecr.InventarioDAO;

public class Productos extends javax.swing.JFrame {

    public Productos() {
        initComponents();
        cargarInventario();
        this.setLocationRelativeTo(null);
    }

    private void cargarInventario() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = ConexionOracle.getInstance().getConnection();
            String sql = "SELECT FIDE_INVENTARIO_TB_ID_INVENTARIO_PK, ID_PALLET, NOMBRE, CANTIDAD, PRECIO FROM FIDE_INVENTARIO_TB";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int idInventario = rs.getInt("FIDE_INVENTARIO_TB_ID_INVENTARIO_PK");
                int idPallet = rs.getInt("ID_PALLET");
                String nombre = rs.getString("NOMBRE");
                int cantidad = rs.getInt("CANTIDAD");
                double precio = rs.getDouble("PRECIO");

                modelo.addRow(new Object[]{idInventario, idPallet, nombre, cantidad, precio});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error a la hora de cargar el inventario " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al cerrar " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void actualizarTablaProductos() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); 

        try (Connection connection = ConexionOracle.getInstance().getConnection(); PreparedStatement pstmt = connection.prepareStatement("SELECT FIDE_INVENTARIO_TB_ID_INVENTARIO_PK, ID_PALLET, NOMBRE, CANTIDAD, PRECIO FROM FIDE_INVENTARIO_TB"); ResultSet resultSet = pstmt.executeQuery()) {

            while (resultSet.next()) {
                model.addRow(new Object[]{
                    resultSet.getInt("FIDE_INVENTARIO_TB_ID_INVENTARIO_PK"),
                    resultSet.getInt("ID_PALLET"),
                    resultSet.getString("NOMBRE"),
                    resultSet.getInt("CANTIDAD"),
                    resultSet.getDouble("PRECIO")
                });
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Se produjo el error " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void agregarProducto() {
    Connection conn = ConexionOracle.getInstance().getConnection();
    if (conn == null) {
        JOptionPane.showMessageDialog(this, "No se pudo conectar a la base de datos", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try (CallableStatement cstmt = conn.prepareCall("{CALL FIDE_INVENTARIO_TB_REGISTRAR_SP(?, ?, ?, ?, ?)}")) {
        int idPallet = Integer.parseInt(jTextField2.getText().trim());
        String nombre = jTextField3.getText().trim();
        int cantidad = Integer.parseInt(jTextField4.getText().trim());
        double precio = Double.parseDouble(jTextField5.getText().trim());
        int idEstados = Integer.parseInt(Estado.getText().trim()); 

        cstmt.setInt(1, idPallet);
        cstmt.setString(2, nombre);
        cstmt.setInt(3, cantidad);
        cstmt.setDouble(4, precio);
        cstmt.setInt(5, idEstados);

        cstmt.execute();
        JOptionPane.showMessageDialog(this, "El producto se ha agregado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        cargarInventario(); 
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al agregar los productos" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Editar = new javax.swing.JButton();
        BotonConfirmar = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        BotonCancelar1 = new javax.swing.JButton();
        Editarid = new javax.swing.JTextField();
        EditaridPallet = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        EditarNombre = new javax.swing.JTextField();
        EditarCantidad = new javax.swing.JTextField();
        EditarPrecio = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Eliminar = new javax.swing.JButton();
        EliminarP = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        EditarEstado = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        Estado = new javax.swing.JTextField();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id_inventario", "id_pallet", "nombre", "cantidad", "precio"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 190, 590, 340));

        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        jPanel1.add(Editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 650, 90, 30));

        BotonConfirmar.setText("Confirmar");
        BotonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonConfirmarActionPerformed(evt);
            }
        });
        jPanel1.add(BotonConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 100, 30));

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 100, -1));
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 100, -1));
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 100, -1));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 100, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Estado:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 610, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("cantidad:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 550, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("nombre:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 520, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("idPallet:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 490, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("idInventario:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, -1, -1));

        BotonCancelar1.setBackground(new java.awt.Color(255, 102, 102));
        BotonCancelar1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BotonCancelar1.setText("SALIR");
        BotonCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCancelar1ActionPerformed(evt);
            }
        });
        jPanel1.add(BotonCancelar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 30, 130, 50));

        Editarid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditaridActionPerformed(evt);
            }
        });
        jPanel1.add(Editarid, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 460, 100, 20));

        EditaridPallet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditaridPalletActionPerformed(evt);
            }
        });
        jPanel1.add(EditaridPallet, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 490, 100, 20));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Agregar Producto");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, -1, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Eliminar producto (Con ID)");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 570, -1, -1));

        EditarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarNombreActionPerformed(evt);
            }
        });
        jPanel1.add(EditarNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 520, 100, 20));

        EditarCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarCantidadActionPerformed(evt);
            }
        });
        jPanel1.add(EditarCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 550, 100, 20));

        EditarPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarPrecioActionPerformed(evt);
            }
        });
        jPanel1.add(EditarPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 580, 100, 20));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("idPallet:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, -1, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("nombre:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("cantidad:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Estado:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, -1, -1));

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        jPanel1.add(Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 650, 90, 30));

        EliminarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarPActionPerformed(evt);
            }
        });
        jPanel1.add(EliminarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 610, 140, 30));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Editar Producto");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("precio:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 580, -1, -1));

        EditarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarEstadoActionPerformed(evt);
            }
        });
        jPanel1.add(EditarEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 610, 100, 20));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("precio:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, -1, -1));

        Estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstadoActionPerformed(evt);
            }
        });
        jPanel1.add(Estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 100, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pxfuel.jpg"))); // NOI18N
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 830));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonConfirmarActionPerformed
        agregarProducto();

    }//GEN-LAST:event_BotonConfirmarActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        int idInventario = Integer.parseInt(Editarid.getText());
    int idPallet = Integer.parseInt(EditaridPallet.getText());
    String nombre = EditarNombre.getText();
    int cantidad = Integer.parseInt(EditarCantidad.getText());
    double precio = Double.parseDouble(EditarPrecio.getText());
    int idEstados = Integer.parseInt(EditarEstado.getText()); 

    if (nombre.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Llene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    InventarioDAO inventarioDAO = new InventarioDAO();
    inventarioDAO.editarProducto(idInventario, idPallet, nombre, cantidad, precio, idEstados);

    actualizarTablaProductos();




    }//GEN-LAST:event_EditarActionPerformed

    private void EditaridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditaridActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditaridActionPerformed

    private void EditaridPalletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditaridPalletActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditaridPalletActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void EditarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditarNombreActionPerformed

    private void EditarCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditarCantidadActionPerformed

    private void EditarPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditarPrecioActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        int idInventario = Integer.parseInt(EliminarP.getText());

        int confirm = JOptionPane.showConfirmDialog(this, "Seguro que quiere eliminar el producto?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            InventarioDAO inventarioDAO = new InventarioDAO();
            inventarioDAO.eliminarProducto(idInventario);

            actualizarTablaProductos();
        }

    }//GEN-LAST:event_EliminarActionPerformed

    private void EliminarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EliminarPActionPerformed

    private void BotonCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCancelar1ActionPerformed
        // TODO add your handling code here:
        Home homeFrame = new Home();

        homeFrame.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_BotonCancelar1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void EditarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditarEstadoActionPerformed

    private void EstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EstadoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCancelar1;
    private javax.swing.JButton BotonConfirmar;
    private javax.swing.JButton Editar;
    private javax.swing.JTextField EditarCantidad;
    private javax.swing.JTextField EditarEstado;
    private javax.swing.JTextField EditarNombre;
    private javax.swing.JTextField EditarPrecio;
    private javax.swing.JTextField Editarid;
    private javax.swing.JTextField EditaridPallet;
    private javax.swing.JButton Eliminar;
    private javax.swing.JTextField EliminarP;
    private javax.swing.JTextField Estado;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
