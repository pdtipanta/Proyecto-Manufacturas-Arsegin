/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Inventario;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 *
 * @author David
 */
public class Dialogo_Nuevo_Producto extends javax.swing.JDialog {
    private DecimalFormat    formato_Numero = new DecimalFormat("#.00", new DecimalFormatSymbols(Locale.US));
    /**
     * Creates new form Dialogo_Nuevo_Producto
     */
    public Dialogo_Nuevo_Producto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.boton_Agregar.setEnabled(false);
        this.campo_Total.setText("0.0");
        this.campo_Cantidad.setText("0");
        this.campo_Unitario.setText("0");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        campo_Codigo = new javax.swing.JTextField();
        campo_Descripcion = new javax.swing.JTextField();
        campo_Cantidad = new javax.swing.JTextField();
        campo_Unitario = new javax.swing.JTextField();
        campo_Total = new javax.swing.JTextField();
        boton_Agregar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo producto");
        setMaximumSize(new java.awt.Dimension(560, 335));
        setMinimumSize(new java.awt.Dimension(560, 335));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Codigo:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 41, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Descripcion:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 85, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Cantidad:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 128, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Valor unitario:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 172, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Valor total:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 216, -1, -1));

        campo_Codigo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campo_Codigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        campo_Codigo.setMaximumSize(new java.awt.Dimension(2, 20));
        campo_Codigo.setMinimumSize(new java.awt.Dimension(2, 20));
        campo_Codigo.setPreferredSize(new java.awt.Dimension(2, 20));
        campo_Codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campo_CodigoKeyTyped(evt);
            }
        });
        getContentPane().add(campo_Codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 230, -1));

        campo_Descripcion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campo_Descripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        campo_Descripcion.setMaximumSize(new java.awt.Dimension(2, 20));
        campo_Descripcion.setMinimumSize(new java.awt.Dimension(2, 20));
        campo_Descripcion.setPreferredSize(new java.awt.Dimension(2, 20));
        campo_Descripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campo_DescripcionKeyTyped(evt);
            }
        });
        getContentPane().add(campo_Descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 320, -1));

        campo_Cantidad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campo_Cantidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        campo_Cantidad.setMaximumSize(new java.awt.Dimension(2, 20));
        campo_Cantidad.setMinimumSize(new java.awt.Dimension(2, 20));
        campo_Cantidad.setPreferredSize(new java.awt.Dimension(2, 20));
        campo_Cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campo_CantidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campo_CantidadKeyTyped(evt);
            }
        });
        getContentPane().add(campo_Cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 150, -1));

        campo_Unitario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campo_Unitario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        campo_Unitario.setMaximumSize(new java.awt.Dimension(2, 20));
        campo_Unitario.setMinimumSize(new java.awt.Dimension(2, 20));
        campo_Unitario.setPreferredSize(new java.awt.Dimension(2, 20));
        campo_Unitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campo_UnitarioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campo_UnitarioKeyTyped(evt);
            }
        });
        getContentPane().add(campo_Unitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 150, -1));

        campo_Total.setEditable(false);
        campo_Total.setBackground(new java.awt.Color(255, 255, 255));
        campo_Total.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campo_Total.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        campo_Total.setMaximumSize(new java.awt.Dimension(2, 20));
        campo_Total.setMinimumSize(new java.awt.Dimension(2, 20));
        campo_Total.setPreferredSize(new java.awt.Dimension(2, 20));
        campo_Total.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campo_TotalKeyReleased(evt);
            }
        });
        getContentPane().add(campo_Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 150, -1));

        boton_Agregar.setBackground(new java.awt.Color(255, 255, 255));
        boton_Agregar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        boton_Agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas (1).png"))); // NOI18N
        boton_Agregar.setText("Agregar");
        getContentPane().add(boton_Agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagen-fondo-aurora-celeste_1.png"))); // NOI18N
        jLabel6.setMaximumSize(new java.awt.Dimension(560, 335));
        jLabel6.setMinimumSize(new java.awt.Dimension(560, 335));
        jLabel6.setPreferredSize(new java.awt.Dimension(560, 335));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 335));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campo_CodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_CodigoKeyTyped
        char c = evt.getKeyChar();
        if ( ( c < 'a' || c > 'z' ) && ( c < 'A' || c >'Z' ) && ( c < '0'  || c > '9' ) && ( c < '#' || c > '&' ) && ( c < '-' || c > '/' ) &&  (  c == evt.VK_SPACE ) ) evt.consume();
    }//GEN-LAST:event_campo_CodigoKeyTyped

    private void campo_DescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_DescripcionKeyTyped
        char c = evt.getKeyChar();
        if( c == evt.VK_SPACE && this.campo_Descripcion.getText().length() == 0  ) evt.consume();
    }//GEN-LAST:event_campo_DescripcionKeyTyped

    private void campo_CantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_CantidadKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != evt.VK_BACK_SPACE )) evt.consume();
    }//GEN-LAST:event_campo_CantidadKeyTyped

    private void campo_UnitarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_UnitarioKeyTyped
        char c = evt.getKeyChar();
        if ( ( ( c < '0' ) || ( c > '9' ) ) && ( c != evt.VK_BACK_SPACE) && ( c != '.' || this.campo_Unitario.getText().contains( "." ) ) ) evt.consume();
    }//GEN-LAST:event_campo_UnitarioKeyTyped

    private void campo_TotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_TotalKeyReleased
        
    }//GEN-LAST:event_campo_TotalKeyReleased

    private void campo_CantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_CantidadKeyReleased
        calcular_Valor();
    }//GEN-LAST:event_campo_CantidadKeyReleased

    private void campo_UnitarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_UnitarioKeyReleased
        calcular_Valor();
    }//GEN-LAST:event_campo_UnitarioKeyReleased

    public void calcular_Valor(){
        try {
            double total = Integer.valueOf(this.campo_Cantidad.getText()) * Double.valueOf(this.campo_Unitario.getText());
            this.campo_Total.setText(this.formato_Numero.format(total));
        } catch (NumberFormatException e) {
        }
    }
    
    public boolean verificar_Campos(){
        boolean bandera = true;
        
        if(this.campo_Codigo.getText().isEmpty()){
            bandera = false;
        }
        
        if(this.campo_Descripcion.getText().isEmpty()){
            bandera = false;
        }
        
        if(this.campo_Cantidad.getText().isEmpty() || this.campo_Cantidad.getText().equals("0")){
            bandera = false;
        }
        
        if(this.campo_Unitario.getText().isEmpty() || this.campo_Unitario.getText().equals("0")){
            bandera = false;
        }
        
        if(this.campo_Total.getText().isEmpty() || this.campo_Total.getText().equals("0")){
            bandera = false;
        }
        
        return bandera;
    }
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
            java.util.logging.Logger.getLogger(Dialogo_Nuevo_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dialogo_Nuevo_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dialogo_Nuevo_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dialogo_Nuevo_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Dialogo_Nuevo_Producto dialog = new Dialogo_Nuevo_Producto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton boton_Agregar;
    public javax.swing.JTextField campo_Cantidad;
    public javax.swing.JTextField campo_Codigo;
    public javax.swing.JTextField campo_Descripcion;
    public javax.swing.JTextField campo_Total;
    public javax.swing.JTextField campo_Unitario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
