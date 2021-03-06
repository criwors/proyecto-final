
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author FabricioNicolas
 */
public class agragarProducto extends javax.swing.JFrame {

    ArrayList<TiempoEnAños> TiempoEnAños = new ArrayList();

    private final String dataBase = "bodega";
    private final String user = "root";
    private final String password = "1234";
    private final String URL = "jdbc:mysql://localhost:3306/" + dataBase + "?autoReconnect=true&useSSL=false";

    private Connection con = null;

    String id;

    public Connection getConexion() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, user, password);

            //JOptionPane.showMessageDialog(null, "conexion exitosa");
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Error " + ex);

        }

        return con;
    }

    public void limpiar() {
        Tid.setText("");
        Tproducto.setText("");
        Tdescripcion.setText("");
        Fentrada.setDate(null);

    }

    public void cargarTabla() {

        DefaultTableModel modeloTabla = new DefaultTableModel();
        Tactivos.setModel(modeloTabla);

        modeloTabla.addColumn("Id");
        modeloTabla.addColumn("Producto");
        modeloTabla.addColumn("Descripcion");
        modeloTabla.addColumn("Entrada");
        modeloTabla.addColumn("T.S(años)");

        PreparedStatement ps;
        ResultSet rs;

        try {
            Connection con = getConexion();

            ps = (PreparedStatement) con.prepareStatement("SELECT* FROM activos");
            rs = ps.executeQuery();

            while (rs.next()) {

                Object fila[] = new Object[6];
                for (int i = 0; i < 6; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modeloTabla.addRow(fila);
            }

        } catch (SQLException e) {
            System.err.println("Error " + e);
        }

    }

    public agragarProducto() {
        initComponents();
        cargarTabla();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton6 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Tproducto = new javax.swing.JTextField();
        Bagregar = new javax.swing.JButton();
        Fentrada = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        Tdescripcion = new javax.swing.JTextField();
        Tid = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        BmodificarProducto = new javax.swing.JButton();
        BeliminarProducto = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tactivos = new javax.swing.JTable();
        Bcerrar = new javax.swing.JButton();

        jButton6.setText("jButton6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Producto");

        jLabel2.setText("Fecha De Entada");

        Bagregar.setText("Agregar Producto");
        Bagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BagregarActionPerformed(evt);
            }
        });

        Fentrada.setDateFormatString("dd-MM-yyyy");

        jLabel4.setText("Descripcion");

        jLabel5.setText("Id");

        BmodificarProducto.setText("Modificar Producto");
        BmodificarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BmodificarProductoActionPerformed(evt);
            }
        });

        BeliminarProducto.setText("Eliminar Producto");
        BeliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeliminarProductoActionPerformed(evt);
            }
        });

        Tactivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "    Producto", "Descripcion", "     Entrada", "T.S(años)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tactivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TactivosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tactivos);

        Bcerrar.setText("Cerrar");
        Bcerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BcerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(BeliminarProducto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Bagregar)
                                .addGap(2, 2, 2)
                                .addComponent(BmodificarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(Tdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tid, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(Fentrada, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(Bcerrar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(Fentrada, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Bagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BmodificarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(BeliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(Bcerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BagregarActionPerformed
        int id = Integer.parseInt(Tid.getText());
        String producto = Tproducto.getText();
        String descripcion = Tdescripcion.getText();
        Date entrada = Fentrada.getDate();

        Date date = Fentrada.getDate();
        long d = date.getTime();
        java.sql.Date fecha = new java.sql.Date(d);
        TiempoEnAños calculo = new TiempoEnAños(id, producto, descripcion, entrada);
        Connection conexion;
        PreparedStatement ps;

        try {

            conexion = getConexion();
            ps = (PreparedStatement) conexion.prepareStatement("INSERT INTO activos VALUES (?,?,?,?,?,?)");
            ps.setString(1, Tid.getText());
            ps.setString(2, Tproducto.getText());
            ps.setString(3, Tdescripcion.getText());
            ps.setDate(4, fecha);
            ps.setInt(5, calculo.CalcularAño());
            ps.setString(6, "si");

            int result = ps.executeUpdate();

            if (result > 0) {

                JOptionPane.showMessageDialog(null, "Producto insertado correctamente");

                limpiar();
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "Producto no insertado");
            }

            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex);
        }
    }//GEN-LAST:event_BagregarActionPerformed

    private void BmodificarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BmodificarProductoActionPerformed
        Date date = Fentrada.getDate();
        long d = date.getTime();
        java.sql.Date fecha = new java.sql.Date(d);

        ResultSet rs = null;
        Connection conexion = getConexion();
        int ts = 0;

        try {
            PreparedStatement ps1 = (PreparedStatement) conexion.prepareStatement("SELECT* from activos Where id=" + Tid.getText());
            rs = ps1.executeQuery();
            if (rs.next()) {
                ts = rs.getInt("tiempostock");

            }
            PreparedStatement ps = (PreparedStatement) conexion.prepareStatement("UPDATE activos set id=?, producto=?,descripcion=?, entrada =?,tiempostock=?,estatus=? WHERE id =" + Tid.getText());
            ps.setString(1, Tid.getText());
            ps.setString(2, Tproducto.getText());
            ps.setString(3, Tdescripcion.getText());
            ps.setDate(4, fecha);
            ps.setInt(5, ts);
            ps.setString(6, "si");

            int result = ps.executeUpdate();

            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Producto modificado de manera exitosa");
                cargarTabla();
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Producto no modificado");
            }

            conexion.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error " + ex);
        }


    }//GEN-LAST:event_BmodificarProductoActionPerformed

    private void BeliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeliminarProductoActionPerformed
        Connection conexion;
        PreparedStatement ps;
        ResultSet rs;
        String producto = "";
        String descripcion = "";
        try {

            conexion = getConexion();
            String id = JOptionPane.showInputDialog("Ingrese el numero de id a eliminar");
            PreparedStatement ps1 = (PreparedStatement) conexion.prepareStatement("SELECT* from activos Where id=" + id);
            rs = ps1.executeQuery();
            if (rs.next()) {
                producto = rs.getString("producto");
                descripcion = rs.getString("descripcion");
            }
            int n = JOptionPane.showConfirmDialog(null, "Estas seguro de que quieres eliminar el producto : " + producto + " : " + descripcion, null, JOptionPane.YES_NO_OPTION);

            if (n == JOptionPane.YES_OPTION) {
                ps = (PreparedStatement) conexion.prepareStatement("DELETE FROM activos WHERE id=?");
                ps.setString(1, id);
                JOptionPane.showMessageDialog(null, "eliminado con exito");
                ps.executeUpdate();
                cargarTabla();
            } else {

                JOptionPane.showMessageDialog(null, "Producto no eliminado");
            }

            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex);
        }

    }//GEN-LAST:event_BeliminarProductoActionPerformed

    private void BcerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BcerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_BcerrarActionPerformed

    private void TactivosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TactivosMouseClicked
        ResultSet rs;

        if (Tactivos.getSelectedRow() >= 0) {

            id = String.valueOf(Tactivos.getModel().getValueAt(Tactivos.getSelectedRow(), 0));
            Connection conexion = getConexion();
            try {
                PreparedStatement ps = (PreparedStatement) conexion.prepareStatement("SELECT* from activos Where id=" + id);
                rs = ps.executeQuery();

                if (rs.next()) {
                    Tid.setText(rs.getString("id"));
                    Tproducto.setText(rs.getString("producto"));
                    Tdescripcion.setText(rs.getString("descripcion"));
                    Fentrada.setDate(rs.getDate("entrada"));

                }
                conexion.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error " + ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un id de la tabla");

        }
    }//GEN-LAST:event_TactivosMouseClicked

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
            java.util.logging.Logger.getLogger(agragarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(agragarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(agragarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(agragarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new agragarProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bagregar;
    private javax.swing.JButton Bcerrar;
    private javax.swing.JButton BeliminarProducto;
    public javax.swing.JButton BmodificarProducto;
    public com.toedter.calendar.JDateChooser Fentrada;
    private javax.swing.JTable Tactivos;
    private javax.swing.JTextField Tdescripcion;
    private javax.swing.JTextField Tid;
    private javax.swing.JTextField Tproducto;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
