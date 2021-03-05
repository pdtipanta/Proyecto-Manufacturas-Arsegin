/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Inventario;

import Controlador.PlaceHolder_Textos;
import Modelo.Rol;
import Modelo.Usuario;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author David
 */
public class Panel_Inventarios extends javax.swing.JPanel {
    PlaceHolder_Textos textos_Place;
    
    /**
     * Creates new form Panel_Inventario
     */
    public Panel_Inventarios() {
        initComponents(); 
        this.textos_Place = new PlaceHolder_Textos("Codigo del producto", this.campo_Codigo);
        this.textos_Place = new PlaceHolder_Textos("Descripcion del producto", this.campo_Descripcion);
        this.textos_Place = new PlaceHolder_Textos("Unidades producto", this.campo_Cantidad);
        this.textos_Place = new PlaceHolder_Textos("Precio de compra", this.campo_Precio_Compra);
        this.textos_Place = new PlaceHolder_Textos("Precio de venta al publico", this.campo_Precio_Venta);;
        this.textos_Place = new PlaceHolder_Textos("Nombre proveedor", this.combo_Proveedor);
        this.etiqueta_Indicador_Codigo.setVisible( false );
        this.etiqueta_Indicador_Descripcion.setVisible( false ); 
        this.etiqueta_Indicador_Cantidad.setVisible( false );
        this.etiqueta_Indicador_Precio_Compra.setVisible( false );
        this.etiqueta_Indicador_Precio_Venta.setVisible( false );
        this.etiqueta_Indicador_Proveedor.setVisible( false );
        this.boton_Modificar.setEnabled( false );
        this.boton_Eliminar.setEnabled( false );
        this.etiqueta_Correccion_Producto.setVisible(false);
    }
    
    public void Roles(String rol) {
        if (rol.equals("Vendedor")) {
            boolean[] bandera = {false, false, false, false, true, false, true, false};
            this.habilitar_Rol(bandera);
        }
        
        if (rol.equals("Bodeguero")) {
            boolean[] bandera = {true, true, true, true, true, true, true, true};
            this.habilitar_Rol(bandera);
        }
        
        if (rol.equals("Contador")) {
            boolean[] bandera = {true, true, true, true, true, true, true, true};
            this.habilitar_Rol(bandera);
        }
        
        if (rol.equals("Administrador")) {
            boolean[] bandera = {true, true, true, true, true, true, true, true};
            this.habilitar_Rol(bandera);
        }
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
        boton_Nuevo_Producto = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        boton_Guardar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        boton_Modificar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        boton_Eliminar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        boton_Informe = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        boton_Devoluciones = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        campo_Descripcion = new javax.swing.JTextField();
        boton_Buscar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        campo_Cantidad = new javax.swing.JFormattedTextField();
        campo_Precio_Compra = new javax.swing.JTextField();
        campo_Precio_Venta = new javax.swing.JTextField();
        campo_Codigo = new javax.swing.JTextField();
        etiqueta_Indicador_Proveedor = new javax.swing.JLabel();
        etiqueta_Indicador_Codigo = new javax.swing.JLabel();
        etiqueta_Indicador_Cantidad = new javax.swing.JLabel();
        etiqueta_Indicador_Precio_Compra = new javax.swing.JLabel();
        etiqueta_Indicador_Precio_Venta = new javax.swing.JLabel();
        etiqueta_Indicador_Descripcion = new javax.swing.JLabel();
        combo_Proveedor = new javax.swing.JTextField();
        boton_Proveedor = new javax.swing.JButton();
        boton_Cerrar_Sesion = new javax.swing.JButton();
        etiqueta_Correccion_Producto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        etiqueta_Rol = new javax.swing.JLabel();
        etiqueta_Nombre_Usuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(java.awt.SystemColor.activeCaption);
        setMaximumSize(new java.awt.Dimension(1400, 800));
        setMinimumSize(new java.awt.Dimension(1400, 800));
        setPreferredSize(new java.awt.Dimension(1400, 800));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        boton_Nuevo_Producto.setBackground(new java.awt.Color(255, 255, 255));
        boton_Nuevo_Producto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        boton_Nuevo_Producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar-archivo.png"))); // NOI18N
        boton_Nuevo_Producto.setText("Nuevo");
        boton_Nuevo_Producto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        boton_Nuevo_Producto.setFocusable(false);
        boton_Nuevo_Producto.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        boton_Nuevo_Producto.setMaximumSize(new java.awt.Dimension(100, 37));
        boton_Nuevo_Producto.setMinimumSize(new java.awt.Dimension(100, 37));
        boton_Nuevo_Producto.setPreferredSize(new java.awt.Dimension(100, 37));
        boton_Nuevo_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_Nuevo_ProductoActionPerformed(evt);
            }
        });
        jToolBar1.add(boton_Nuevo_Producto);
        jToolBar1.add(jSeparator4);

        boton_Guardar.setBackground(java.awt.Color.white);
        boton_Guardar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        boton_Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/disquete.png"))); // NOI18N
        boton_Guardar.setText("Guardar");
        boton_Guardar.setToolTipText(" Agregar");
        boton_Guardar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        boton_Guardar.setMaximumSize(new java.awt.Dimension(103, 37));
        boton_Guardar.setMinimumSize(new java.awt.Dimension(60, 37));
        boton_Guardar.setPreferredSize(new java.awt.Dimension(60, 37));
        boton_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_GuardarActionPerformed(evt);
            }
        });
        jToolBar1.add(boton_Guardar);
        jToolBar1.add(jSeparator1);

        boton_Modificar.setBackground(java.awt.Color.white);
        boton_Modificar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        boton_Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar-documento.png"))); // NOI18N
        boton_Modificar.setText("Modificar");
        boton_Modificar.setToolTipText(" Editar");
        boton_Modificar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        boton_Modificar.setMaximumSize(new java.awt.Dimension(113, 37));
        boton_Modificar.setMinimumSize(new java.awt.Dimension(60, 37));
        jToolBar1.add(boton_Modificar);
        jToolBar1.add(jSeparator2);

        boton_Eliminar.setBackground(java.awt.Color.white);
        boton_Eliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        boton_Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton-eliminar.png"))); // NOI18N
        boton_Eliminar.setText("Eliminar");
        boton_Eliminar.setToolTipText("Eliminar");
        boton_Eliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        boton_Eliminar.setMaximumSize(new java.awt.Dimension(100, 37));
        boton_Eliminar.setMinimumSize(new java.awt.Dimension(60, 37));
        jToolBar1.add(boton_Eliminar);
        jToolBar1.add(jSeparator3);

        boton_Informe.setBackground(new java.awt.Color(255, 255, 255));
        boton_Informe.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        boton_Informe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reanudar.png"))); // NOI18N
        boton_Informe.setText("Reporte");
        boton_Informe.setToolTipText("Reporte inventario");
        boton_Informe.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        boton_Informe.setMaximumSize(new java.awt.Dimension(100, 37));
        boton_Informe.setMinimumSize(new java.awt.Dimension(100, 37));
        boton_Informe.setPreferredSize(new java.awt.Dimension(100, 37));
        jToolBar1.add(boton_Informe);
        jToolBar1.add(jSeparator5);

        boton_Devoluciones.setBackground(new java.awt.Color(255, 255, 255));
        boton_Devoluciones.setText("Devoluciones");
        boton_Devoluciones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        boton_Devoluciones.setFocusable(false);
        boton_Devoluciones.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_Devoluciones.setMaximumSize(new java.awt.Dimension(100, 37));
        boton_Devoluciones.setMinimumSize(new java.awt.Dimension(100, 37));
        boton_Devoluciones.setPreferredSize(new java.awt.Dimension(100, 37));
        boton_Devoluciones.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(boton_Devoluciones);

        add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 40));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Codigo:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Descripcion:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Precio compra:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Precio venta:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, -1, -1));

        campo_Descripcion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campo_Descripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        campo_Descripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campo_DescripcionKeyTyped(evt);
            }
        });
        add(campo_Descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 346, 22));

        boton_Buscar.setBackground(java.awt.Color.white);
        boton_Buscar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        boton_Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar-en-carpeta.png"))); // NOI18N
        add(boton_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, 40, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Proveedor:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 530, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Cantidad:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, -1, -1));

        campo_Cantidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        campo_Cantidad.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        campo_Cantidad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campo_Cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campo_CantidadKeyTyped(evt);
            }
        });
        add(campo_Cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 160, 22));

        campo_Precio_Compra.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campo_Precio_Compra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        campo_Precio_Compra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campo_Precio_CompraKeyTyped(evt);
            }
        });
        add(campo_Precio_Compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, 140, 22));

        campo_Precio_Venta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campo_Precio_Venta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        campo_Precio_Venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_Precio_VentaActionPerformed(evt);
            }
        });
        campo_Precio_Venta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campo_Precio_VentaKeyTyped(evt);
            }
        });
        add(campo_Precio_Venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 460, 200, 22));

        campo_Codigo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campo_Codigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        campo_Codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campo_CodigoKeyTyped(evt);
            }
        });
        add(campo_Codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 270, 22));

        etiqueta_Indicador_Proveedor.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        etiqueta_Indicador_Proveedor.setForeground(new java.awt.Color(198, 0, 0));
        etiqueta_Indicador_Proveedor.setText("*");
        add(etiqueta_Indicador_Proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 530, -1, -1));

        etiqueta_Indicador_Codigo.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        etiqueta_Indicador_Codigo.setForeground(new java.awt.Color(198, 0, 0));
        etiqueta_Indicador_Codigo.setText("*");
        add(etiqueta_Indicador_Codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, -1, -1));

        etiqueta_Indicador_Cantidad.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        etiqueta_Indicador_Cantidad.setForeground(new java.awt.Color(198, 0, 0));
        etiqueta_Indicador_Cantidad.setText("*");
        add(etiqueta_Indicador_Cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, -1, -1));

        etiqueta_Indicador_Precio_Compra.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        etiqueta_Indicador_Precio_Compra.setForeground(new java.awt.Color(198, 0, 0));
        etiqueta_Indicador_Precio_Compra.setText("*");
        add(etiqueta_Indicador_Precio_Compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, -1, -1));

        etiqueta_Indicador_Precio_Venta.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        etiqueta_Indicador_Precio_Venta.setForeground(new java.awt.Color(198, 0, 0));
        etiqueta_Indicador_Precio_Venta.setText("*");
        add(etiqueta_Indicador_Precio_Venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 460, -1, -1));

        etiqueta_Indicador_Descripcion.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        etiqueta_Indicador_Descripcion.setForeground(new java.awt.Color(198, 0, 0));
        etiqueta_Indicador_Descripcion.setText("*");
        add(etiqueta_Indicador_Descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, -1, -1));

        combo_Proveedor.setEditable(false);
        combo_Proveedor.setBackground(new java.awt.Color(255, 255, 255));
        combo_Proveedor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        combo_Proveedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        combo_Proveedor.setMaximumSize(new java.awt.Dimension(2, 20));
        combo_Proveedor.setMinimumSize(new java.awt.Dimension(2, 20));
        combo_Proveedor.setPreferredSize(new java.awt.Dimension(2, 20));
        add(combo_Proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 530, 320, 22));

        boton_Proveedor.setBackground(new java.awt.Color(255, 255, 255));
        boton_Proveedor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        boton_Proveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton-anadir-usuario (1).png"))); // NOI18N
        boton_Proveedor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(boton_Proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 520, 60, -1));

        boton_Cerrar_Sesion.setBackground(new java.awt.Color(255, 255, 255));
        boton_Cerrar_Sesion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        boton_Cerrar_Sesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Exit-32.png"))); // NOI18N
        boton_Cerrar_Sesion.setText("Cerrar");
        boton_Cerrar_Sesion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(boton_Cerrar_Sesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 0, 120, 40));

        etiqueta_Correccion_Producto.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        etiqueta_Correccion_Producto.setForeground(new java.awt.Color(220, 0, 0));
        etiqueta_Correccion_Producto.setText("El codigo de producto ya se encuentra registrado para otro producto");
        add(etiqueta_Correccion_Producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 390, -1));

        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "DATOS INVENTARIO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 80, 1290, 640));

        etiqueta_Rol.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        etiqueta_Rol.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(etiqueta_Rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(1134, 20, 147, 20));

        etiqueta_Nombre_Usuario.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        etiqueta_Nombre_Usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario.png"))); // NOI18N
        etiqueta_Nombre_Usuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        etiqueta_Nombre_Usuario.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        add(etiqueta_Nombre_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 0, 180, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo blanco.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 0, 180, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void boton_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_GuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton_GuardarActionPerformed

    private void campo_Precio_VentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_Precio_VentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_Precio_VentaActionPerformed

    private void campo_CantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_CantidadKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != evt.VK_BACK_SPACE )) evt.consume();
    }//GEN-LAST:event_campo_CantidadKeyTyped

    private void campo_Precio_CompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_Precio_CompraKeyTyped
        validar_Campos( evt, this.campo_Precio_Compra );
    }//GEN-LAST:event_campo_Precio_CompraKeyTyped

    private void campo_Precio_VentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_Precio_VentaKeyTyped
        validar_Campos( evt, this.campo_Precio_Venta );
    }//GEN-LAST:event_campo_Precio_VentaKeyTyped

    private void campo_DescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_DescripcionKeyTyped
        char c = evt.getKeyChar();
        if( c == evt.VK_SPACE && this.campo_Descripcion.getText().length() == 0  ) evt.consume();
    }//GEN-LAST:event_campo_DescripcionKeyTyped

    private void boton_Nuevo_ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Nuevo_ProductoActionPerformed
        limpiar_Campos();
        this.botones(true, true, false, false, true, true);
    }//GEN-LAST:event_boton_Nuevo_ProductoActionPerformed

    private void campo_CodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_CodigoKeyTyped
        char c = evt.getKeyChar();
        if ( ( c < 'a' || c > 'z' ) && ( c < 'A' || c >'Z' ) && ( c < '0'  || c > '9' ) && ( c < '#' || c > '&' ) && ( c < '-' || c > '/' ) &&  (  c == evt.VK_SPACE ) ) evt.consume();
    }//GEN-LAST:event_campo_CodigoKeyTyped

    public void validar_Campos( KeyEvent evt, JTextField campo ){
        char c = evt.getKeyChar();
        if ( ( ( c < '0' ) || ( c > '9' ) ) && ( c != evt.VK_BACK_SPACE) && ( c != '.' || campo.getText().contains( "." ) ) ) evt.consume();
    }
    
    public boolean etiquetas( boolean bandera ){
        
        if( this.campo_Codigo.getText().isEmpty() ){ 
            this.etiqueta_Indicador_Codigo.setVisible( true );
            bandera = false;
        }else{ 
            this.etiqueta_Indicador_Codigo.setVisible( false );
        }
        
        if( this.campo_Descripcion.getText().isEmpty() ){ 
            this.etiqueta_Indicador_Descripcion.setVisible( true );
            bandera = false;
        }else{ 
            this.etiqueta_Indicador_Descripcion.setVisible( false );
        }
            
        if( this.campo_Cantidad.getText().isEmpty() ){
            this.etiqueta_Indicador_Cantidad.setVisible( true );
            bandera = false;
        }else{ 
            this.etiqueta_Indicador_Cantidad.setVisible( false );
        }
        
        if( this.campo_Precio_Compra.getText().isEmpty() ){
            this.etiqueta_Indicador_Precio_Compra.setVisible( true );
            bandera = false;
        }else{ 
            this.etiqueta_Indicador_Precio_Compra.setVisible( false );
        }
        
        if( this.campo_Precio_Venta.getText().isEmpty() ){
            this.etiqueta_Indicador_Precio_Venta.setVisible( true );
            bandera = false;
        }else{ 
            this.etiqueta_Indicador_Precio_Venta.setVisible( false );
        }
        
        if( this.combo_Proveedor.getText().isEmpty()){
            this.etiqueta_Indicador_Proveedor.setVisible( true );
            bandera = false;
        }else{ 
            this.etiqueta_Indicador_Proveedor.setVisible( false );
        }
        return bandera;
    }
    
    public void limpiar_Campos(){
        this.campo_Codigo.setText( "" );
        this.campo_Descripcion.setText( "" );
        this.campo_Cantidad.setText( "" );
        this.campo_Precio_Compra.setText( "" );
        this.campo_Precio_Venta.setText( "" );
        this.combo_Proveedor.setText("");
        this.etiqueta_Correccion_Producto.setVisible(false);
    }
    
    public void botones( boolean bandera1, boolean bandera2, boolean bandera3, boolean bandera4, boolean bandera5, boolean bandera6  ){
        this.boton_Guardar.setEnabled(bandera1);
        this.boton_Nuevo_Producto.setEnabled(bandera2);
        this.boton_Modificar.setEnabled(bandera3);
        this.boton_Eliminar.setEnabled(bandera4);
        this.campo_Codigo.setEditable(bandera5);
        this.boton_Informe.setEnabled(bandera6);
    }
    
    public void setCampos( String codigo, String descripcion, String cantidad_Disponible, String precio_Compra, String precio_Venta, String proveedor){
        this.botones(false, false, true, true, false, true);
        this.campo_Codigo.setText(codigo);
        this.campo_Descripcion.setText(descripcion);
        this.campo_Cantidad.setText(cantidad_Disponible);
        this.campo_Precio_Compra.setText(precio_Compra);
        this.campo_Precio_Venta.setText(precio_Venta);
        this.combo_Proveedor.setText(proveedor);
    }
    
    public void habilitar_Rol(boolean[] bandera) {
        this.boton_Nuevo_Producto.setVisible(bandera[0]);
        this.boton_Guardar.setVisible(bandera[1]);
        this.boton_Modificar.setVisible(bandera[2]);
        this.boton_Eliminar.setVisible(bandera[3]);
        this.boton_Informe.setVisible(bandera[4]);
        this.boton_Devoluciones.setVisible(bandera[5]);
        this.boton_Buscar.setVisible(bandera[6]);
        this.boton_Proveedor.setVisible(bandera[7]);
    }
    
    public void set_Usuario(Usuario usuario, String rol){
        this.etiqueta_Nombre_Usuario.setText(usuario.getNombre() + " " + usuario.getApellido());
        this.etiqueta_Rol.setText(rol);
    }
    
    public void correccion_Campos(String valor){
        if(valor.equals(this.campo_Codigo.getText())){
            this.etiqueta_Correccion_Producto.setVisible(true);
        }else{
            this.etiqueta_Correccion_Producto.setVisible(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton boton_Buscar;
    public javax.swing.JButton boton_Cerrar_Sesion;
    public javax.swing.JButton boton_Devoluciones;
    public javax.swing.JButton boton_Eliminar;
    public javax.swing.JButton boton_Guardar;
    public javax.swing.JButton boton_Informe;
    public javax.swing.JButton boton_Modificar;
    public javax.swing.JButton boton_Nuevo_Producto;
    public javax.swing.JButton boton_Proveedor;
    public javax.swing.JFormattedTextField campo_Cantidad;
    public javax.swing.JTextField campo_Codigo;
    public javax.swing.JTextField campo_Descripcion;
    public javax.swing.JTextField campo_Precio_Compra;
    public javax.swing.JTextField campo_Precio_Venta;
    public javax.swing.JTextField combo_Proveedor;
    private javax.swing.JLabel etiqueta_Correccion_Producto;
    private javax.swing.JLabel etiqueta_Indicador_Cantidad;
    private javax.swing.JLabel etiqueta_Indicador_Codigo;
    private javax.swing.JLabel etiqueta_Indicador_Descripcion;
    private javax.swing.JLabel etiqueta_Indicador_Precio_Compra;
    private javax.swing.JLabel etiqueta_Indicador_Precio_Venta;
    private javax.swing.JLabel etiqueta_Indicador_Proveedor;
    public javax.swing.JLabel etiqueta_Nombre_Usuario;
    public javax.swing.JLabel etiqueta_Rol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}