/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Maquilas.Orden_De_Produccion;

import Modelo.Maquila;
import Modelo.Orden_Produccion;
import Modelo.Usuario;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author David
 */
public class Panel_Orden_De_Produccion extends javax.swing.JPanel {

    /**
     * Creates new form Panel_Cotizacion
     */
    public Panel_Orden_De_Produccion() {
        initComponents();
        calendario_Orden.setDate( new Date() );
        tabla_Productos_Maquila.getTableHeader().setFont( new Font( "Segoe UI", Font.BOLD, 14 ) );
        tabla_Productos_Maquila.getTableHeader().setBackground( new Color( 32, 136, 203 ) );
        tabla_Productos_Maquila.getTableHeader().setForeground( new Color( 255, 255, 255) );
 
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);

        this.tabla_Productos_Maquila.getColumnModel().getColumn(0).setCellRenderer(tcr);
        this.etiqueta_Indicador_Maquila.setVisible( false );
        this.etiqueta_Indicador_RUC.setVisible( false );
        this.etiqueta_Indicador_Direccion.setVisible( false );
        this.etiqueta_Indicador_Telefono.setVisible( false );
        this.etiqueta_Estado.setVisible( false );
        this.boton_Modificar_Orden.setEnabled( false );
        this.boton_Agregar_Fila.setEnabled( false );
        this.boton_Quitar_Fila.setEnabled( false );
        this.boton_Generar_Orden.setEnabled(false);
        this.etiqueta_Indicador_Calendario.setVisible(false);
        this.tabla_Productos_Maquila.getTableHeader().setReorderingAllowed(false) ;
    }
    
    public void Roles(String rol) {
        if (rol.equals("Vendedor")) {
            boolean[] bandera = {false, false, false, false, false, false, false};
            this.habilitar_Rol(bandera);
        }

        if (rol.equals("Bodeguero")) {
            boolean[] bandera = {false, false, false, false, false, false, false};
            this.habilitar_Rol(bandera);
        }

        if (rol.equals("Contador")) {
            boolean[] bandera = {true, false, false, true, false, false, false};
            this.habilitar_Rol(bandera);
        }

        if (rol.equals("Administrador")) {
            System.out.println("administrador");
            boolean[] bandera = {true, false, false, true, false, false, false};
            this.habilitar_Rol(bandera);
        }
        
        if (rol.equals("Maquila")) {
            boolean[] bandera = {true, true, true, true, true, true, true};
            this.habilitar_Rol(bandera);
        }
    }
    
     public void habilitar_Rol(boolean[] bandera) {
        this.boton_Nueva_Orden.setVisible(bandera[0]);
        this.boton_Guardar_Orden.setVisible(bandera[1]);
        this.boton_Modificar_Orden.setVisible(bandera[2]);
        this.boton_Generar_Orden.setVisible(bandera[3]);
        this.boton_Agregar_Maquila.setVisible(bandera[4]);
        this.boton_Agregar_Fila.setVisible(bandera[5]);
        this.boton_Quitar_Fila.setVisible(bandera[6]);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        boton_Nueva_Orden = new javax.swing.JButton();
        boton_Guardar_Orden = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        boton_Modificar_Orden = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        boton_Generar_Orden = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        boton_Buscar_Orden = new javax.swing.JButton();
        calendario_Orden = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        campo_Direccion_Orden = new javax.swing.JTextField();
        campo_Telefono_Orden = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_Productos_Maquila = new javax.swing.JTable();
        campo_Total_Orden = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        etiqueta_No_Orden = new javax.swing.JLabel();
        boton_Agregar_Fila = new javax.swing.JButton();
        boton_Quitar_Fila = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        campo_RUC_Orden = new javax.swing.JTextField();
        etiqueta_Indicador_Maquila = new javax.swing.JLabel();
        etiqueta_Indicador_Direccion = new javax.swing.JLabel();
        etiqueta_Indicador_Telefono = new javax.swing.JLabel();
        etiqueta_Indicador_RUC = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        caja_Observaciones_Maquila = new javax.swing.JTextArea();
        combo_Estado_Orden = new javax.swing.JComboBox<>();
        etiqueta_Estado = new javax.swing.JLabel();
        combo_Maquila_Orden = new javax.swing.JTextField();
        boton_Agregar_Maquila = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        boton_Cerrar_Sesion = new javax.swing.JButton();
        etiqueta_Rol = new javax.swing.JLabel();
        etiqueta_Indicador_Calendario = new javax.swing.JLabel();
        etiqueta_Nombre_Usuario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setBackground(java.awt.SystemColor.activeCaption);
        setMaximumSize(new java.awt.Dimension(1400, 800));
        setMinimumSize(new java.awt.Dimension(1400, 800));
        setPreferredSize(new java.awt.Dimension(1400, 800));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.add(jSeparator1);

        boton_Nueva_Orden.setBackground(new java.awt.Color(255, 255, 255));
        boton_Nueva_Orden.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        boton_Nueva_Orden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar-archivo.png"))); // NOI18N
        boton_Nueva_Orden.setText("Nuevo");
        boton_Nueva_Orden.setToolTipText("Nueva cotizacion");
        boton_Nueva_Orden.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        boton_Nueva_Orden.setFocusable(false);
        boton_Nueva_Orden.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        boton_Nueva_Orden.setMaximumSize(new java.awt.Dimension(100, 37));
        boton_Nueva_Orden.setMinimumSize(new java.awt.Dimension(100, 37));
        boton_Nueva_Orden.setPreferredSize(new java.awt.Dimension(100, 37));
        boton_Nueva_Orden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_Nueva_OrdenActionPerformed(evt);
            }
        });
        jToolBar1.add(boton_Nueva_Orden);

        boton_Guardar_Orden.setBackground(new java.awt.Color(255, 255, 255));
        boton_Guardar_Orden.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        boton_Guardar_Orden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/disquete.png"))); // NOI18N
        boton_Guardar_Orden.setText("Guardar");
        boton_Guardar_Orden.setToolTipText("Guardar orden");
        boton_Guardar_Orden.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        boton_Guardar_Orden.setFocusable(false);
        boton_Guardar_Orden.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        boton_Guardar_Orden.setMaximumSize(new java.awt.Dimension(100, 37));
        boton_Guardar_Orden.setMinimumSize(new java.awt.Dimension(100, 37));
        boton_Guardar_Orden.setPreferredSize(new java.awt.Dimension(60, 37));
        jToolBar1.add(boton_Guardar_Orden);
        jToolBar1.add(jSeparator2);

        boton_Modificar_Orden.setBackground(new java.awt.Color(255, 255, 255));
        boton_Modificar_Orden.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        boton_Modificar_Orden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar-documento.png"))); // NOI18N
        boton_Modificar_Orden.setText("Modificar");
        boton_Modificar_Orden.setToolTipText("Modificar orden");
        boton_Modificar_Orden.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        boton_Modificar_Orden.setFocusable(false);
        boton_Modificar_Orden.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        boton_Modificar_Orden.setMaximumSize(new java.awt.Dimension(100, 37));
        boton_Modificar_Orden.setMinimumSize(new java.awt.Dimension(60, 37));
        boton_Modificar_Orden.setPreferredSize(new java.awt.Dimension(100, 37));
        jToolBar1.add(boton_Modificar_Orden);
        jToolBar1.add(jSeparator3);

        boton_Generar_Orden.setBackground(new java.awt.Color(255, 255, 255));
        boton_Generar_Orden.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        boton_Generar_Orden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reportar 1.png"))); // NOI18N
        boton_Generar_Orden.setText("Generar");
        boton_Generar_Orden.setToolTipText("Generar orden");
        boton_Generar_Orden.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        boton_Generar_Orden.setFocusable(false);
        boton_Generar_Orden.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        boton_Generar_Orden.setMaximumSize(new java.awt.Dimension(100, 37));
        boton_Generar_Orden.setMinimumSize(new java.awt.Dimension(100, 37));
        boton_Generar_Orden.setPreferredSize(new java.awt.Dimension(100, 37));
        jToolBar1.add(boton_Generar_Orden);
        jToolBar1.add(jSeparator5);

        boton_Buscar_Orden.setBackground(new java.awt.Color(255, 255, 255));
        boton_Buscar_Orden.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        boton_Buscar_Orden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar-en-carpeta.png"))); // NOI18N
        boton_Buscar_Orden.setText("Buscar");
        boton_Buscar_Orden.setToolTipText("Buscar orden");
        boton_Buscar_Orden.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        boton_Buscar_Orden.setFocusable(false);
        boton_Buscar_Orden.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        boton_Buscar_Orden.setMaximumSize(new java.awt.Dimension(100, 37));
        boton_Buscar_Orden.setMinimumSize(new java.awt.Dimension(100, 37));
        boton_Buscar_Orden.setPreferredSize(new java.awt.Dimension(100, 37));
        jToolBar1.add(boton_Buscar_Orden);

        add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 40));

        calendario_Orden.setBackground(new java.awt.Color(255, 255, 255));
        calendario_Orden.setDateFormatString("yyyy-MM-dd");
        calendario_Orden.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        add(calendario_Orden, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 69, 150, 22));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Fecha:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Maquila:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Direccion:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Telefono:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, -1, -1));

        campo_Direccion_Orden.setEditable(false);
        campo_Direccion_Orden.setBackground(new java.awt.Color(255, 255, 255));
        campo_Direccion_Orden.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campo_Direccion_Orden.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        campo_Direccion_Orden.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campo_Direccion_OrdenKeyTyped(evt);
            }
        });
        add(campo_Direccion_Orden, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 340, 22));

        campo_Telefono_Orden.setEditable(false);
        campo_Telefono_Orden.setBackground(new java.awt.Color(255, 255, 255));
        campo_Telefono_Orden.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campo_Telefono_Orden.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        campo_Telefono_Orden.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campo_Telefono_OrdenKeyTyped(evt);
            }
        });
        add(campo_Telefono_Orden, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 210, 150, 22));

        tabla_Productos_Maquila.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tabla_Productos_Maquila.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cant", "Descripcion", "V. Unitario", "V. Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_Productos_Maquila.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tabla_Productos_MaquilaKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_Productos_Maquila);
        if (tabla_Productos_Maquila.getColumnModel().getColumnCount() > 0) {
            tabla_Productos_Maquila.getColumnModel().getColumn(0).setResizable(false);
            tabla_Productos_Maquila.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabla_Productos_Maquila.getColumnModel().getColumn(1).setResizable(false);
            tabla_Productos_Maquila.getColumnModel().getColumn(1).setPreferredWidth(310);
            tabla_Productos_Maquila.getColumnModel().getColumn(2).setResizable(false);
            tabla_Productos_Maquila.getColumnModel().getColumn(2).setPreferredWidth(50);
            tabla_Productos_Maquila.getColumnModel().getColumn(3).setResizable(false);
            tabla_Productos_Maquila.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 860, 240));

        campo_Total_Orden.setEditable(false);
        campo_Total_Orden.setBackground(new java.awt.Color(255, 255, 255));
        campo_Total_Orden.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        campo_Total_Orden.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(campo_Total_Orden, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 650, 80, 22));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Total:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 652, -1, -1));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        jLabel15.setText("No. Orden:");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        etiqueta_No_Orden.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        add(etiqueta_No_Orden, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 210, 20));

        boton_Agregar_Fila.setBackground(new java.awt.Color(255, 255, 255));
        boton_Agregar_Fila.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        boton_Agregar_Fila.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas (1).png"))); // NOI18N
        boton_Agregar_Fila.setText("Agregar servicio");
        boton_Agregar_Fila.setToolTipText("Agregar");
        boton_Agregar_Fila.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(boton_Agregar_Fila, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 410, 140, 35));

        boton_Quitar_Fila.setBackground(new java.awt.Color(255, 255, 255));
        boton_Quitar_Fila.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        boton_Quitar_Fila.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/menos.png"))); // NOI18N
        boton_Quitar_Fila.setText("Quitar servicio");
        boton_Quitar_Fila.setToolTipText("Quitar");
        boton_Quitar_Fila.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        boton_Quitar_Fila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_Quitar_FilaActionPerformed(evt);
            }
        });
        add(boton_Quitar_Fila, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 470, 140, 35));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setText("RUC:");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, -1, -1));

        campo_RUC_Orden.setEditable(false);
        campo_RUC_Orden.setBackground(new java.awt.Color(255, 255, 255));
        campo_RUC_Orden.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campo_RUC_Orden.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        campo_RUC_Orden.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campo_RUC_OrdenKeyTyped(evt);
            }
        });
        add(campo_RUC_Orden, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, 150, 22));

        etiqueta_Indicador_Maquila.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        etiqueta_Indicador_Maquila.setForeground(new java.awt.Color(220, 0, 0));
        etiqueta_Indicador_Maquila.setText("*");
        add(etiqueta_Indicador_Maquila, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, -1, -1));

        etiqueta_Indicador_Direccion.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        etiqueta_Indicador_Direccion.setForeground(new java.awt.Color(220, 0, 0));
        etiqueta_Indicador_Direccion.setText("*");
        add(etiqueta_Indicador_Direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, -1, -1));

        etiqueta_Indicador_Telefono.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        etiqueta_Indicador_Telefono.setForeground(new java.awt.Color(220, 0, 0));
        etiqueta_Indicador_Telefono.setText("*");
        add(etiqueta_Indicador_Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 210, -1, -1));

        etiqueta_Indicador_RUC.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        etiqueta_Indicador_RUC.setForeground(new java.awt.Color(220, 0, 0));
        etiqueta_Indicador_RUC.setText("*");
        add(etiqueta_Indicador_RUC, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 170, -1, -1));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        caja_Observaciones_Maquila.setColumns(20);
        caja_Observaciones_Maquila.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        caja_Observaciones_Maquila.setRows(5);
        jScrollPane3.setViewportView(caja_Observaciones_Maquila);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 640, 350, -1));

        combo_Estado_Orden.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        combo_Estado_Orden.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar..........", "Pagado", "Por pagar", "Anulada" }));
        add(combo_Estado_Orden, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 220, 22));

        etiqueta_Estado.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        etiqueta_Estado.setForeground(new java.awt.Color(195, 0, 0));
        etiqueta_Estado.setText("*");
        add(etiqueta_Estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, -1, -1));

        combo_Maquila_Orden.setEditable(false);
        combo_Maquila_Orden.setBackground(new java.awt.Color(255, 255, 255));
        combo_Maquila_Orden.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        combo_Maquila_Orden.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(combo_Maquila_Orden, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 310, 22));

        boton_Agregar_Maquila.setBackground(new java.awt.Color(255, 255, 255));
        boton_Agregar_Maquila.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        boton_Agregar_Maquila.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(boton_Agregar_Maquila, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 166, 40, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Estado del trabajo:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Datos de la orden", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 1120, 170));

        boton_Cerrar_Sesion.setBackground(new java.awt.Color(255, 255, 255));
        boton_Cerrar_Sesion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        boton_Cerrar_Sesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Exit-32.png"))); // NOI18N
        boton_Cerrar_Sesion.setText("Cerrar");
        boton_Cerrar_Sesion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(boton_Cerrar_Sesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 0, 120, 40));

        etiqueta_Rol.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        etiqueta_Rol.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(etiqueta_Rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(1134, 20, 147, 20));

        etiqueta_Indicador_Calendario.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        etiqueta_Indicador_Calendario.setForeground(new java.awt.Color(220, 0, 0));
        etiqueta_Indicador_Calendario.setText("*");
        add(etiqueta_Indicador_Calendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, 20, -1));

        etiqueta_Nombre_Usuario.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        etiqueta_Nombre_Usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario.png"))); // NOI18N
        etiqueta_Nombre_Usuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        etiqueta_Nombre_Usuario.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        add(etiqueta_Nombre_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 0, 180, 40));

        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Total", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 620, 1120, 150));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo blanco.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 0, 180, 40));

        jLabel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 1120, 70));

        jLabel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Servicio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 1120, 290));
    }// </editor-fold>//GEN-END:initComponents

    private void boton_Quitar_FilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Quitar_FilaActionPerformed
        DefaultTableModel modelo_Tabla_Maquila = (DefaultTableModel) this.tabla_Productos_Maquila.getModel();

        try {
            modelo_Tabla_Maquila.removeRow(this.tabla_Productos_Maquila.getSelectedRow());
            this.calculo_Valores();
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_boton_Quitar_FilaActionPerformed

    private void campo_Direccion_OrdenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_Direccion_OrdenKeyTyped
        char c = evt.getKeyChar();
        if( c == evt.VK_SPACE && this.campo_Direccion_Orden.getText().length() == 0 ) evt.consume();
        else if(  ( c < 'a' || c > 'z' ) && ( c < 'A' || c>'Z' ) && ( c < '0' || c > '9' ) && ( c < '-' || c > '.' ) && c != evt.VK_SPACE ){
            evt.consume();
        }
    }//GEN-LAST:event_campo_Direccion_OrdenKeyTyped

    private void campo_RUC_OrdenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_RUC_OrdenKeyTyped
        char c = evt.getKeyChar();
        if( c < '0'  || c > '9' || this.campo_RUC_Orden.getText().length() >= 13 ) evt.consume();
    }//GEN-LAST:event_campo_RUC_OrdenKeyTyped

    private void campo_Telefono_OrdenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_Telefono_OrdenKeyTyped
        char c = evt.getKeyChar();
        if( c < '0'  || c > '9' || this.campo_Telefono_Orden.getText().length() >= 9 ) evt.consume();
    }//GEN-LAST:event_campo_Telefono_OrdenKeyTyped

    private void tabla_Productos_MaquilaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabla_Productos_MaquilaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tabla_Productos_MaquilaKeyTyped

    private void boton_Nueva_OrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Nueva_OrdenActionPerformed

    }//GEN-LAST:event_boton_Nueva_OrdenActionPerformed

    public void valores_Maquila( String maquila, String direccion, String telefono, String RUC ){
        this.combo_Maquila_Orden.setText(maquila);
        this.campo_Direccion_Orden.setText( direccion );
        this.campo_Telefono_Orden.setText( telefono );
        this.campo_RUC_Orden.setText( RUC );
    }
    
    public void valores_Orden( String estado, double valor_Total, String no_Factura, String observaciones ){
        this.combo_Estado_Orden.setSelectedItem( estado );
        this.campo_Total_Orden.setText( String.valueOf( valor_Total ) );
        this.etiqueta_No_Orden.setText( no_Factura );
        this.caja_Observaciones_Maquila.setText( observaciones );
    }
    
    public void valores_Tabla_Orden(Orden_Produccion lista_Orden, Maquila maquila){
        DefaultTableModel modelo_Tabla_Orden = ( DefaultTableModel )  this.tabla_Productos_Maquila.getModel();
        modelo_Tabla_Orden.setRowCount(0);
        
        String[] cantidad = lista_Orden.getCantidad().split(";");
        String[] descripcion = lista_Orden.getDescripcion().split(";");
        String[] v_Unitario = lista_Orden.getV_Unitario().split(";");
        String[] v_Total = lista_Orden.getV_Total().split(";");

        for (int i = 0; i < cantidad.length - 1; i++) {
            Object[] valores_Tabla = {cantidad[i], descripcion[i], Double.parseDouble(v_Unitario[i]), Double.parseDouble(v_Total[i])};
            modelo_Tabla_Orden.addRow(valores_Tabla);
        }
        this.valores_Maquila(maquila.getMaquila(), maquila.getDireccion(), maquila.getTelefono(), maquila.getRUC());
        this.valores_Orden(lista_Orden.getEstado(), lista_Orden.getV_Pagar(), lista_Orden.getNumero_Orden(), lista_Orden.getObservaciones());  
    }
    
    public boolean etiquetas( ){
        boolean bandera = true;
        if( this.combo_Maquila_Orden.getText().isEmpty() ){
            this.etiqueta_Indicador_Maquila.setVisible( true );
            bandera = false;
        }else{ 
            this.etiqueta_Indicador_Maquila.setVisible( false );
        }
        
        if (this.calendario_Orden.getDate() == null) {
            this.etiqueta_Indicador_Calendario.setVisible(bandera);
            bandera = false;
        }else{
            this.etiqueta_Indicador_Calendario.setVisible(false);
        }
            
        if( this.campo_RUC_Orden.getText().matches( "[0-9][0-9]{12}" ) ){
            this.etiqueta_Indicador_RUC.setVisible( false );
        }else if(this.campo_RUC_Orden.getText().matches( "[0-9][0-9]{9}" )){
            this.etiqueta_Indicador_RUC.setVisible( false );
        }
        else{
            this.etiqueta_Indicador_RUC.setVisible( true );
            bandera = false;
        }
            
        if( this.campo_Direccion_Orden.getText().isEmpty() ){ 
            this.etiqueta_Indicador_Direccion.setVisible( true );
            bandera = false;
        }else{ 
            this.etiqueta_Indicador_Direccion.setVisible( false );
        }
            
        if( this.campo_Telefono_Orden.getText().matches( "[0][1-9][0-9]{7}" ) ){
            this.etiqueta_Indicador_Telefono.setVisible( false );
        }else{
            this.etiqueta_Indicador_Telefono.setVisible( true );
            bandera = false;
        } 
        
        if( this.combo_Estado_Orden.getSelectedItem().equals( "Seleccionar.........." ) ){ 
            this.etiqueta_Estado.setVisible( true );
            bandera = false;
        }else{ 
            this.etiqueta_Estado.setVisible( false );
        }
        
        return bandera;
    }
    
    public String[] evaluar_Tabla(){
        DefaultTableModel modelo_Tabla_Maquila = ( DefaultTableModel ) this.tabla_Productos_Maquila.getModel();
        int verificar = 0;
        String[] valores = new String[5];
            
            for( int i = 0; i< modelo_Tabla_Maquila.getRowCount(); i++ ){
                if( modelo_Tabla_Maquila.getValueAt( i, 3 ) != null && ( double ) modelo_Tabla_Maquila.getValueAt( i, 3 ) > 0  ){
                    valores[0] = modelo_Tabla_Maquila.getValueAt( i, 0 ) + ";" + valores[0];
                    valores[1] = modelo_Tabla_Maquila.getValueAt( i, 1 ) + ";" + valores[1];
                    valores[2] = modelo_Tabla_Maquila.getValueAt( i, 2 ) + ";" + valores[2];
                    valores[3] = modelo_Tabla_Maquila.getValueAt( i, 3 ) + ";" + valores[3];
                    verificar++;
                }else{    
                }
            }
            valores[4] = String.valueOf( verificar );
            return valores;
    }
    
    public void limpiar_Valores(){
        this.campo_Total_Orden.setText( "" );
        this.caja_Observaciones_Maquila.setText("");
        this.combo_Estado_Orden.setSelectedItem( "Seleccionar.........." );
    }
    
    public void limpiar_Tabla(){
        DefaultTableModel modelo_Tabla_Cotizacion = ( DefaultTableModel ) this.tabla_Productos_Maquila.getModel();
        modelo_Tabla_Cotizacion.setRowCount( 0 );
    }
    
    public void botones( boolean bandera1, boolean bandera2, boolean bandera3, boolean bandera4, boolean bandera5, boolean bandera6  ){
        this.boton_Guardar_Orden.setEnabled(bandera1);
        this.boton_Agregar_Maquila.setEnabled(bandera1);
        this.boton_Nueva_Orden.setEnabled(bandera2);
        this.boton_Modificar_Orden.setEnabled(bandera3);
        this.boton_Generar_Orden.setEnabled(bandera4);
        this.combo_Estado_Orden.setEnabled(bandera5);
        this.boton_Agregar_Fila.setEnabled(bandera6);
        this.boton_Quitar_Fila.setEnabled(bandera6);
    }
    
    public void calculo_Valores() {
        try {
            double valor_Subtotal = 0;
            for (int i = 0; i < this.tabla_Productos_Maquila.getRowCount(); i++) {
                valor_Subtotal = valor_Subtotal + (double) this.tabla_Productos_Maquila.getValueAt(i, 3);
            }
            this.campo_Total_Orden.setText(String.valueOf(valor_Subtotal));
        } catch (Exception e) {
        }
    }
    
    public String calendario() {
        Date fecha;
        fecha = (Date) this.calendario_Orden.getDate();
        return new SimpleDateFormat("yyyy-MM-dd").format(fecha); 
    }
    
    public void limpiar_Etiquetas() {
        this.etiqueta_Indicador_Maquila.setVisible(false);
        this.etiqueta_Indicador_RUC.setVisible(false);
        this.etiqueta_Indicador_RUC.setVisible(false);
        this.etiqueta_Indicador_Direccion.setVisible(false);
        this.etiqueta_Indicador_Telefono.setVisible(false);
        this.etiqueta_Estado.setVisible(false);
    }
    
    public void set_Usuario(Usuario usuario, String rol){
        this.etiqueta_Nombre_Usuario.setText(usuario.getNombre() + " " + usuario.getApellido());
        this.etiqueta_Rol.setText(rol);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton boton_Agregar_Fila;
    public javax.swing.JButton boton_Agregar_Maquila;
    public javax.swing.JButton boton_Buscar_Orden;
    public javax.swing.JButton boton_Cerrar_Sesion;
    public javax.swing.JButton boton_Generar_Orden;
    public javax.swing.JButton boton_Guardar_Orden;
    public javax.swing.JButton boton_Modificar_Orden;
    public javax.swing.JButton boton_Nueva_Orden;
    public javax.swing.JButton boton_Quitar_Fila;
    public javax.swing.JTextArea caja_Observaciones_Maquila;
    public com.toedter.calendar.JDateChooser calendario_Orden;
    public javax.swing.JTextField campo_Direccion_Orden;
    public javax.swing.JTextField campo_RUC_Orden;
    public javax.swing.JTextField campo_Telefono_Orden;
    public javax.swing.JTextField campo_Total_Orden;
    public javax.swing.JComboBox<String> combo_Estado_Orden;
    public javax.swing.JTextField combo_Maquila_Orden;
    private javax.swing.JLabel etiqueta_Estado;
    private javax.swing.JLabel etiqueta_Indicador_Calendario;
    private javax.swing.JLabel etiqueta_Indicador_Direccion;
    private javax.swing.JLabel etiqueta_Indicador_Maquila;
    private javax.swing.JLabel etiqueta_Indicador_RUC;
    private javax.swing.JLabel etiqueta_Indicador_Telefono;
    public javax.swing.JLabel etiqueta_No_Orden;
    public javax.swing.JLabel etiqueta_Nombre_Usuario;
    public javax.swing.JLabel etiqueta_Rol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar jToolBar1;
    public javax.swing.JTable tabla_Productos_Maquila;
    // End of variables declaration//GEN-END:variables
}
