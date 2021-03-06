/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Cotizacion;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author David
 */
public class Dialogo_Buscar_Cotizacion extends javax.swing.JDialog {

    /**
     * Creates new form Dialogo_Buscar_Facturas
     */
    public Dialogo_Buscar_Cotizacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
        this.setResizable(false);
        this.tabla_Consulta_Cotizacion.getTableHeader().setFont( new Font( "Arial", Font.BOLD, 13 ) );
        this.tabla_Consulta_Cotizacion.getTableHeader().setBackground( new Color( 32, 136, 203 ));
        this.tabla_Consulta_Cotizacion.getTableHeader().setForeground( new Color( 255, 255, 255)); 
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        this.tabla_Consulta_Cotizacion.getColumnModel().getColumn(0).setCellRenderer(tcr);
        this.campo_Busqueda.setEditable(false);
        this.tabla_Consulta_Cotizacion.getTableHeader().setReorderingAllowed(false) ;
        this.fecha_1.setVisible(false);
        this.fecha_2.setVisible(false);
        this.boton_Fecha.setVisible(false);
        this.fecha_1.setDate( new Date() );
        this.fecha_2.setDate( new Date() );
        this.etiqueta_Error_Fecha.setVisible(false);
    }
    
    public String calendario_Inicio() {
        Date fecha = this.fecha_1.getDate();
        return new SimpleDateFormat("yyyy-MM-dd").format(fecha);
    }
    
    public String calendario_Final() {   
        Date fecha = this.fecha_2.getDate();
        return new SimpleDateFormat("yyyy-MM-dd").format(fecha);
    }
    
    public boolean verificar_Campos() {
        boolean bandera = true;
        
        if (this.fecha_1.getDate() == null) {
            bandera = false;
        }

        if (this.fecha_2.getDate() == null) {
            bandera = false;
        }

        return bandera;
    }
    
    public void etiqueta_Error_Etiqueta(boolean bandera){
        this.etiqueta_Error_Fecha.setVisible(bandera);
    }
    
    public void desactivar_Calendarios(boolean bandera) {
        this.fecha_1.setVisible(bandera);
        this.fecha_2.setVisible(bandera);
        this.boton_Fecha.setVisible(bandera);
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
        campo_Busqueda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_Consulta_Cotizacion = new javax.swing.JTable();
        combo_Opciones = new javax.swing.JComboBox<>();
        fecha_1 = new com.toedter.calendar.JDateChooser();
        fecha_2 = new com.toedter.calendar.JDateChooser();
        etiqueta_Error_Fecha = new javax.swing.JLabel();
        boton_Fecha = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cotizaciones");
        setMaximumSize(new java.awt.Dimension(967, 533));
        setMinimumSize(new java.awt.Dimension(967, 533));
        setPreferredSize(new java.awt.Dimension(967, 533));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Buscar:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 32, -1, -1));

        campo_Busqueda.setEditable(false);
        campo_Busqueda.setBackground(new java.awt.Color(255, 255, 255));
        campo_Busqueda.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campo_Busqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        campo_Busqueda.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        campo_Busqueda.setMaximumSize(new java.awt.Dimension(2, 20));
        campo_Busqueda.setMinimumSize(new java.awt.Dimension(2, 20));
        campo_Busqueda.setPreferredSize(new java.awt.Dimension(2, 20));
        getContentPane().add(campo_Busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 470, 24));

        tabla_Consulta_Cotizacion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabla_Consulta_Cotizacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No_Cotizacion", "Cliente", "RUC/ CI", "ID Emisor", "Fecha", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla_Consulta_Cotizacion);
        if (tabla_Consulta_Cotizacion.getColumnModel().getColumnCount() > 0) {
            tabla_Consulta_Cotizacion.getColumnModel().getColumn(0).setPreferredWidth(100);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 900, 240));

        combo_Opciones.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        combo_Opciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar.....", "Por numero", "Por nombre", "Por RUC", "Por fecha" }));
        combo_Opciones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(combo_Opciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 170, 24));

        fecha_1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Desde", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        fecha_1.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(fecha_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 130, 45));

        fecha_2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hasta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        fecha_2.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(fecha_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 130, 45));

        etiqueta_Error_Fecha.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        etiqueta_Error_Fecha.setForeground(new java.awt.Color(204, 0, 51));
        etiqueta_Error_Fecha.setText("Corregir valor de fecha");
        getContentPane().add(etiqueta_Error_Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 132, -1, -1));

        boton_Fecha.setBackground(new java.awt.Color(255, 255, 255));
        boton_Fecha.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        boton_Fecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar-en-carpeta.png"))); // NOI18N
        boton_Fecha.setText("Buscar");
        boton_Fecha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(boton_Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 100, 42));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 970, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagen-fondo-aurora-celeste_1.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setMaximumSize(new java.awt.Dimension(967, 510));
        jLabel2.setMinimumSize(new java.awt.Dimension(967, 510));
        jLabel2.setPreferredSize(new java.awt.Dimension(967, 510));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 967, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Dialogo_Buscar_Cotizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dialogo_Buscar_Cotizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dialogo_Buscar_Cotizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dialogo_Buscar_Cotizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Dialogo_Buscar_Cotizacion dialog = new Dialogo_Buscar_Cotizacion(new javax.swing.JFrame(), true);
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
    public javax.swing.JButton boton_Fecha;
    public javax.swing.JTextField campo_Busqueda;
    public javax.swing.JComboBox<String> combo_Opciones;
    public javax.swing.JLabel etiqueta_Error_Fecha;
    public com.toedter.calendar.JDateChooser fecha_1;
    public com.toedter.calendar.JDateChooser fecha_2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTable tabla_Consulta_Cotizacion;
    // End of variables declaration//GEN-END:variables
}
