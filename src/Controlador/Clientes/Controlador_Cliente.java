/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Clientes;

import Controlador.Gestion_Usuarios.Controlador_Panel_Ingreso;
import Datos.Cliente.DAO_Cliente_Implementacion;
import Modelo.Cliente;
import Modelo.Usuario;
import Vista.Cliente.Panel_Clientes;
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
public class Controlador_Cliente implements ActionListener {
    private Vista_Principal         vista;
    private Connection              conexion_Database;
    private Panel_Clientes          panel_Cliente = new Panel_Clientes();
    private final Usuario           usuario;
    private final String             rol;
    private String                  cedula;

    public Controlador_Cliente(Vista_Principal vista, Connection conexion_Database, Usuario usuario, String rol) {
        this.vista = vista;
        this.conexion_Database = conexion_Database;
        this.usuario = usuario;
        this.rol = rol;
        this.panel_Cliente.boton_Agregar.addActionListener(this);
        this.panel_Cliente.boton_Modificar.addActionListener(this);
        this.panel_Cliente.boton_Buscar.addActionListener(this);
        this.panel_Cliente.boton_Eliminar.addActionListener(this);
        this.panel_Cliente.boton_Reportes_Clientes.addActionListener(this);
        this.panel_Cliente.boton_Nuevo_Cliente.addActionListener(this);
        this.panel_Cliente.boton_Cerrar_Sesion.addActionListener(this);
    }

    public void iniciar() {
        this.vista.Panel_Contenedor.removeAll();
        this.vista.Panel_Contenedor.add(this.panel_Cliente);
        this.panel_Cliente.setVisible(true);
        this.vista.Panel_Contenedor.validate();
        this.set_Usuario();
        this.numero_Cliente();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == this.panel_Cliente.boton_Agregar) {
            if (this.panel_Cliente.etiquetas()) {
                this.numero_Cliente();

                try {
                    if (new DAO_Cliente_Implementacion(this.conexion_Database).crear(new Cliente(this.panel_Cliente.campo_Cod_Cliente.getText(), this.panel_Cliente.combo_Cliente.getText(), this.panel_Cliente.campo_Direccion.getText(), String.valueOf(this.panel_Cliente.campo_Ciudad.getSelectedItem()), this.panel_Cliente.campo_Telefono.getText(), this.panel_Cliente.campo_Celular.getText(), this.panel_Cliente.campo_RUC.getText(), this.panel_Cliente.campo_Correo.getText(), this.panel_Cliente.campo_Contacto.getText(), this.usuario.getCedula()))) {
                        this.panel_Cliente.limpiar_Campos();
                        this.panel_Cliente.botones(true, true, false, false, true, true);
                        this.panel_Cliente.limpiar_Etiquetas_Campos();
                        JOptionPane.showMessageDialog(null, "Cliente registrado", "Exito en la operacion", JOptionPane.INFORMATION_MESSAGE);
                        this.numero_Cliente();
                    }
                } catch (SQLIntegrityConstraintViolationException e1) {
                    this.panel_Cliente.correccion_Campos(e1.getCause().toString().split("'")[1]);
                } catch (SQLException ex) {
                }
            }
        }

        if (ae.getSource() == this.panel_Cliente.boton_Buscar) {
            ArrayList<Cliente> cliente = new Controlador_Dialogo_Buscar_Cliente(this.vista, this.conexion_Database, this.usuario, this.rol).iniciar();

            if (cliente.size() == 1) {
                this.panel_Cliente.setCampos(cliente.get(0).getCodigo_Cliente(), cliente.get(0).getCliente(), cliente.get(0).getDireccion(), cliente.get(0).getRUC(), cliente.get(0).getTelefono(), cliente.get(0).getCiudad(), cliente.get(0).getPersona_Contacto(), cliente.get(0).getCelular(), cliente.get(0).getCorreo());
                this.cedula = cliente.get(0).getEmpleado();
                this.panel_Cliente.campos_Busqueda();
                this.panel_Cliente.etiquetas();
            }
        }

        if (ae.getSource() == this.panel_Cliente.boton_Modificar) {
            if (this.panel_Cliente.etiquetas()) {

                try {
                    if (new DAO_Cliente_Implementacion(this.conexion_Database).editar(new Cliente(this.panel_Cliente.campo_Cod_Cliente.getText(), this.panel_Cliente.combo_Cliente.getText(), this.panel_Cliente.campo_Direccion.getText(), String.valueOf(this.panel_Cliente.campo_Ciudad.getSelectedItem()), this.panel_Cliente.campo_Telefono.getText(), this.panel_Cliente.campo_Celular.getText(), this.panel_Cliente.campo_RUC.getText(), this.panel_Cliente.campo_Correo.getText(), this.panel_Cliente.campo_Contacto.getText(), this.cedula)) > 0) {
                        this.panel_Cliente.limpiar_Campos();
                        this.panel_Cliente.botones(true, true, false, false, true, true);
                        this.cedula = null;
                        this.numero_Cliente();
                        this.panel_Cliente.limpiar_Etiquetas_Campos();
                        JOptionPane.showMessageDialog(null, "Cliente actualizado", "Exito en la operacion", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLIntegrityConstraintViolationException e1) {
                    this.panel_Cliente.correccion_Campos(e1.getCause().toString().split("'")[1]);
                } catch (SQLException ex) {
                }
            }
        }

        if (ae.getSource() == this.panel_Cliente.boton_Eliminar) {

            try {
                if (new DAO_Cliente_Implementacion(this.conexion_Database).eliminar(this.panel_Cliente.campo_Cod_Cliente.getText()) > 0) {
                    this.panel_Cliente.limpiar_Campos();
                    this.panel_Cliente.botones(true, true, false, false, true, true);
                    JOptionPane.showMessageDialog(null, "Cliente eliminado", "Exito en la operacion", JOptionPane.INFORMATION_MESSAGE);
                    this.numero_Cliente();
                }
            } catch (SQLIntegrityConstraintViolationException e1) {
                JOptionPane.showMessageDialog(null, "No se puede eliminar el cliente, debido a que mantiene documentos pendientes", "Clientes", JOptionPane.WARNING_MESSAGE);
                this.panel_Cliente.limpiar_Campos();
                this.panel_Cliente.botones(true, true, false, false, true, true);
                this.numero_Cliente();
            } catch (SQLException ex) {
            }
        }

        if (ae.getSource() == this.panel_Cliente.boton_Reportes_Clientes) {
            new Controlador_Reporte_Cliente(this.vista, this.conexion_Database, this.usuario, this.rol).iniciar();
        }

        if (ae.getSource() == this.panel_Cliente.boton_Cerrar_Sesion) {
            this.vista.Panel_Contenedor.removeAll();
            this.vista.borrar_Menu();
            new Controlador_Panel_Ingreso(this.vista).iniciar();
        }

        if (ae.getSource() == this.panel_Cliente.boton_Nuevo_Cliente) {
            this.panel_Cliente.limpiar_Campos();
            this.panel_Cliente.limpiar_Etiquetas_Campos();
            this.panel_Cliente.botones(true, true, false, false, true, true);
            this.numero_Cliente();
        }
    }

    public void numero_Cliente() {
        String numero = new DAO_Cliente_Implementacion(this.conexion_Database).consultar_Numero_Cliente();
        this.panel_Cliente.numero_Cliente(numero);
    }

    public void set_Usuario(){
        this.panel_Cliente.set_Usuario(this.usuario, this.rol);
    }
}
