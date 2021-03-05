/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Inventario;

import Controlador.Gestion_Usuarios.Controlador_Panel_Ingreso;
import Controlador.Inventario.Reporte.Controlador_Reporte_Inventario;
import Controlador.Proveedor.Controlador_Dialogo_Buscar_Proveedor;
import Datos.Inventario.DAO_Inventario_Implementacion;
import Modelo.Inventario;
import Modelo.Proveedor;
import Modelo.Usuario;
import Vista.Inventario.Panel_Inventarios;
import Vista.Vista_Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class Controlador_Inventarios implements ActionListener{
    private Vista_Principal     vista;
    private Connection          conexion_Database;
    private Panel_Inventarios   panel_Inventarios = new Panel_Inventarios();
    private String              rol;
    private Usuario             usuario;
    
    public Controlador_Inventarios(Vista_Principal vista, Connection conexion_Database, Usuario usuario, String rol) {
        this.vista = vista;
        this.conexion_Database = conexion_Database;
        this.usuario = usuario;
        this.rol = rol;
        this.panel_Inventarios.boton_Guardar.addActionListener(this);
        this.panel_Inventarios.boton_Modificar.addActionListener(this);
        this.panel_Inventarios.boton_Buscar.addActionListener(this);
        this.panel_Inventarios.boton_Eliminar.addActionListener(this);
        this.panel_Inventarios.boton_Informe.addActionListener(this);
        this.panel_Inventarios.boton_Proveedor.addActionListener(this);
        this.panel_Inventarios.boton_Cerrar_Sesion.addActionListener(this);
        this.panel_Inventarios.boton_Devoluciones.addActionListener(this);
    }

    public void iniciar() {
        this.vista.Panel_Contenedor.add(panel_Inventarios);
        this.panel_Inventarios.setVisible(true);
        this.vista.Panel_Contenedor.validate();
        this.set_Usuario();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == this.panel_Inventarios.boton_Guardar) {
            if (this.panel_Inventarios.etiquetas(true)) {

                try {
                    if (new DAO_Inventario_Implementacion(this.conexion_Database).crear(new Inventario((String) this.panel_Inventarios.campo_Codigo.getText(), this.panel_Inventarios.campo_Descripcion.getText(), Integer.parseInt(this.panel_Inventarios.campo_Cantidad.getText()), Double.parseDouble(this.panel_Inventarios.campo_Precio_Compra.getText()), Double.parseDouble(this.panel_Inventarios.campo_Precio_Venta.getText()), this.panel_Inventarios.combo_Proveedor.getText()))) {
                        this.panel_Inventarios.limpiar_Campos();
                        this.panel_Inventarios.botones(true, true, false, false, true, true);
                        JOptionPane.showMessageDialog(null, "Producto registrado", "Exito en la operacion", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLIntegrityConstraintViolationException e1) {
                    this.panel_Inventarios.correccion_Campos(e1.getCause().toString().split("'")[1]);
                } catch (SQLException ex) {
                }
            }
        }

        if (ae.getSource() == this.panel_Inventarios.boton_Modificar) {
            if (this.panel_Inventarios.etiquetas(true)) {

                try {
                    if (new DAO_Inventario_Implementacion(this.conexion_Database).editar(new Inventario(this.panel_Inventarios.campo_Codigo.getText(), this.panel_Inventarios.campo_Descripcion.getText(), Integer.parseInt(this.panel_Inventarios.campo_Cantidad.getText()), Double.parseDouble(this.panel_Inventarios.campo_Precio_Compra.getText()), Double.parseDouble(this.panel_Inventarios.campo_Precio_Venta.getText()), this.panel_Inventarios.combo_Proveedor.getText())) > 0) {
                        this.panel_Inventarios.limpiar_Campos();
                        this.panel_Inventarios.botones(true, true, false, false, true, true);
                        JOptionPane.showMessageDialog(null, "Inventario actualizado", "Exito en la operacion", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLIntegrityConstraintViolationException e1) {
                    this.panel_Inventarios.correccion_Campos(e1.getCause().toString().split("'")[1]);
                } catch (SQLException ex) {
                }
            }
        }

        if (ae.getSource() == this.panel_Inventarios.boton_Buscar) {
            ArrayList<Inventario> inventario = new Controlador_Dialogo_Buscar_Inventario(this.vista, this.conexion_Database, false).iniciar();

            if (inventario.size() == 1) {
                this.panel_Inventarios.setCampos(inventario.get(0).getCodigo(), inventario.get(0).getDescripcion(), String.valueOf(inventario.get(0).getCantidad_Disponible()), String.valueOf(inventario.get(0).getPrecio_Compra()), String.valueOf(inventario.get(0).getPrecio_Venta()), inventario.get(0).getProveedor());
            }
        }

        if (ae.getSource() == this.panel_Inventarios.boton_Eliminar) {

            try {
                if (new DAO_Inventario_Implementacion(this.conexion_Database).eliminar(this.panel_Inventarios.campo_Codigo.getText()) > 0) {
                    this.panel_Inventarios.limpiar_Campos();
                    this.panel_Inventarios.botones(true, true, false, false, true, true);
                    JOptionPane.showMessageDialog(null, "Inventario eliminado", "Exito en la operacion", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No se puede eliminar el producto, debido a que se encuentra en documentos", "Inventario", JOptionPane.WARNING_MESSAGE);
                    this.panel_Inventarios.limpiar_Campos();
                }
            } catch (SQLException ex) {
            }
        }

        if (ae.getSource() == this.panel_Inventarios.boton_Proveedor) {
            ArrayList<Proveedor> proveedor = new Controlador_Dialogo_Buscar_Proveedor(this.vista, this.conexion_Database).iniciar();

            if (proveedor.size() == 1) {
                this.panel_Inventarios.combo_Proveedor.setText(proveedor.get(0).getProveedor());
            }
        }

        if (ae.getSource() == this.panel_Inventarios.boton_Informe) {
            new Controlador_Reporte_Inventario(this.vista, this.conexion_Database).iniciar();
        }

        if (ae.getSource() == this.panel_Inventarios.boton_Cerrar_Sesion) {
            vista.Panel_Contenedor.removeAll();
            this.vista.borrar_Menu();
            new Controlador_Panel_Ingreso(this.vista).iniciar();
        }

        if (ae.getSource() == this.panel_Inventarios.boton_Devoluciones) {
            new Controlador_Dialogo_Devoluciones(this.vista).iniciar();
        }
    }

    public void habilitar_Rol() {
        this.panel_Inventarios.Roles(rol);
    }
    
    public void set_Usuario(){
        this.panel_Inventarios.set_Usuario(this.usuario, this.rol);
    }
}
