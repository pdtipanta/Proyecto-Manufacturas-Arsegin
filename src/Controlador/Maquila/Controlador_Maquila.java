/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Maquila;

import Controlador.Gestion_Usuarios.Controlador_Panel_Ingreso;
import Datos.Maquila.DAO_Maquila_Implementacion;
import Modelo.Maquila;
import Modelo.Usuario;
import Vista.Maquilas.Panel_Maquilas;
import Vista.Vista_Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class Controlador_Maquila implements ActionListener{
    private Vista_Principal    vista;
    private Connection  conexion_Database;
    private Usuario            usuario;
    private String                rol;
    private Panel_Maquilas     panel_Maquilas = new Panel_Maquilas();
    private String             id_Maquila;
    
    public Controlador_Maquila(Vista_Principal vista, Connection conexion_Database, Usuario usuario, String rol) {
        this.vista = vista;
        this.conexion_Database = conexion_Database;
        this.usuario = usuario;
        this.rol = rol;
        this.panel_Maquilas.boton_Guardar.addActionListener(this);
        this.panel_Maquilas.boton_Modificar.addActionListener(this);
        this.panel_Maquilas.boton_Buscar.addActionListener(this);
        this.panel_Maquilas.boton_Eliminar.addActionListener(this);
        this.panel_Maquilas.boton_Cerrar_Sesion.addActionListener(this);
        this.panel_Maquilas.boton_Nuevo_Maquila.addActionListener(this);
    }

    public void iniciar() {
        this.vista.Panel_Contenedor.add(this.panel_Maquilas);
        this.panel_Maquilas.setVisible(true);
        this.vista.Panel_Contenedor.validate();
        this.set_Usuario();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == this.panel_Maquilas.boton_Guardar) {
            if (this.panel_Maquilas.etiquetas(true)) {
                numero_Maquila();
                try {
                    if (new DAO_Maquila_Implementacion(this.conexion_Database).crear(new Maquila(this.numero_Maquila(), this.panel_Maquilas.combo_Maquila.getText(), this.panel_Maquilas.campo_RUC.getText(), this.panel_Maquilas.campo_Direccion.getText(), this.panel_Maquilas.campo_Telefono.getText(), this.panel_Maquilas.caja_Servicios.getText()))) {
                        this.panel_Maquilas.limpiar_Campos();
                        this.panel_Maquilas.botones(true, true, false, false, true);
                        JOptionPane.showMessageDialog(null, "Maquila registrada", "Exito en la operacion", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLIntegrityConstraintViolationException e1) {
                    this.panel_Maquilas.correccion_Campos(e1.getCause().toString().split("'")[1]);
                } catch (SQLException ex) {
                }
            }
        }

        if (ae.getSource() == this.panel_Maquilas.boton_Buscar) {
            ArrayList<Maquila> maquila = new Controlador_Dialogo_Buscar_Maquila(this.vista, this.conexion_Database).iniciar();

            if (maquila.size() == 1) {
                this.panel_Maquilas.setCampos(maquila.get(0).getMaquila(), maquila.get(0).getRUC(), maquila.get(0).getDireccion(), maquila.get(0).getTelefono(), maquila.get(0).getServicio());
                this.panel_Maquilas.campos_Busqueda();
                this.panel_Maquilas.etiquetas(true);
                this.id_Maquila = maquila.get(0).getId_Maquila();
            }
        }

        if (ae.getSource() == this.panel_Maquilas.boton_Modificar) {
            if (this.panel_Maquilas.etiquetas(true)) {

                try {
                    if (new DAO_Maquila_Implementacion(this.conexion_Database).editar(new Maquila(this.id_Maquila, this.panel_Maquilas.combo_Maquila.getText(), this.panel_Maquilas.campo_RUC.getText(), this.panel_Maquilas.campo_Direccion.getText(), this.panel_Maquilas.campo_Telefono.getText(), this.panel_Maquilas.caja_Servicios.getText())) > 0) {
                        this.panel_Maquilas.limpiar_Campos();
                        this.panel_Maquilas.limpiar_Etiquetas_Campos();
                        this.panel_Maquilas.botones(true, true, false, false, true);
                        this.id_Maquila = null;
                        JOptionPane.showMessageDialog(null, "Maquila actualizada", "Exito en la operacion", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLIntegrityConstraintViolationException e1) {
                    this.panel_Maquilas.correccion_Campos(e1.getCause().toString().split("'")[1]);
                } catch (SQLException ex) {
                }
            }
        }

        if (ae.getSource() == this.panel_Maquilas.boton_Eliminar) {
            try {
                if (new DAO_Maquila_Implementacion(this.conexion_Database).eliminar(this.id_Maquila) > 0) {
                    this.panel_Maquilas.limpiar_Campos();
                    this.panel_Maquilas.limpiar_Etiquetas_Campos();
                    this.panel_Maquilas.botones(true, true, false, false, true);
                    this.id_Maquila = null;
                    JOptionPane.showMessageDialog(null, "Maquila eliminada", "Exito en la operacion", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLIntegrityConstraintViolationException e1) {
                JOptionPane.showMessageDialog(null, "No se puede eliminar la maquila, debido a que mantiene documentos pendientes", "Maquilas", JOptionPane.WARNING_MESSAGE);
                this.panel_Maquilas.limpiar_Campos();
            } catch (SQLException ex) {
            }
        }

        if (ae.getSource() == this.panel_Maquilas.boton_Cerrar_Sesion) {
            vista.Panel_Contenedor.removeAll();
            this.vista.borrar_Menu();
            new Controlador_Panel_Ingreso(this.vista).iniciar();
        }

        if (ae.getSource() == this.panel_Maquilas.boton_Nuevo_Maquila) {
            this.panel_Maquilas.limpiar_Campos();
            this.panel_Maquilas.botones(true, true, false, false, true);
            this.id_Maquila = null;
            this.panel_Maquilas.limpiar_Etiquetas_Campos();
        }
    }

    public String numero_Maquila() {
        String numero = new DAO_Maquila_Implementacion(this.conexion_Database).consultar_Numero_Maquila();
        String valor = "";

        if (numero == null) {
            valor = convertirNumero(0);
        } else {
            valor = convertirNumero(Integer.parseInt(numero));
        }
        return valor;
    }

    public String convertirNumero(int numero) {
        DecimalFormat format = new DecimalFormat("00000000");
        return format.format(Integer.valueOf(numero) + 1);
    }
    
    public void set_Usuario(){
        this.panel_Maquilas.set_Usuario(this.usuario, this.rol);
    }
    
    public void habilitar_Rol() {
        this.panel_Maquilas.Roles(rol);
    }
}
