/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Cotizacion;

import Datos.Cliente.DAO_Cliente_Implementacion;
import Datos.Cotizacion.DAO_Cotizacion_Implementacion;
import Modelo.Cliente;
import Modelo.Cotizacion;
import Modelo.Usuario;
import Vista.Cotizacion.Dialogo_Buscar_Cotizacion;
import Vista.Vista_Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author David
 */
public class Controlador_Dialogo_Buscar_Cotizacion implements ActionListener, KeyListener, MouseListener {

    private final Vista_Principal               vista;
    private final Connection                    conexion;
    private final Usuario                       usuario;
    private final String                        rol;
    private String                              valor = null;
    private final Dialogo_Buscar_Cotizacion     dialogo_Buscar_Cotizacion;
    private TableRowSorter                      TRSFiltro;
    private DefaultTableModel                   modelo_Tabla_Cotizacion;
    private ArrayList<Cotizacion>               cotizacion = new ArrayList<Cotizacion>();

    public Controlador_Dialogo_Buscar_Cotizacion(Vista_Principal vista, Connection conexion, Usuario usuario, String rol) {
        this.vista = vista;
        this.conexion = conexion;
        this.usuario = usuario;
        this.rol = rol;
        this.dialogo_Buscar_Cotizacion = new Dialogo_Buscar_Cotizacion(this.vista, true);
        this.dialogo_Buscar_Cotizacion.campo_Busqueda.addKeyListener(this);
        this.dialogo_Buscar_Cotizacion.tabla_Consulta_Cotizacion.addMouseListener(this);
        this.dialogo_Buscar_Cotizacion.combo_Opciones.addActionListener(this);
        this.dialogo_Buscar_Cotizacion.boton_Fecha.addActionListener(this);
        this.modelo_Tabla_Cotizacion = (DefaultTableModel) this.dialogo_Buscar_Cotizacion.tabla_Consulta_Cotizacion.getModel();
    }

    public ArrayList<Cotizacion> iniciar() {
        this.consultar_Datos_Cotizacion();
        this.dialogo_Buscar_Cotizacion.setVisible(true);
        return this.cotizacion;
    }

    public void consultar_Datos_Cotizacion() {

        switch (this.rol) {
            case "Vendedor":
                valor = "Todos" + ";" + this.usuario.getCedula();
                break;

            case "Contador":
                valor = "Todos" + ";" + "Todos";
                break;

            case "Administrador":
                valor = "Todos" + ";" + "Todos";
                break;
        }

        presentar_Cotizacion(new DAO_Cotizacion_Implementacion(this.conexion).consultar(valor));
    }

    public void presentar_Cotizacion(ArrayList<Cotizacion> cotizacion) {
        this.modelo_Tabla_Cotizacion.setRowCount(0);

        if (cotizacion.size() > 0) {
            for (int i = 0; i < cotizacion.size(); i++) {
                String valor_Cliente = cotizacion.get(i).getCliente() + ";" + cotizacion.get(i).getEmisor();
                ArrayList<Cliente> cliente = new DAO_Cliente_Implementacion(this.conexion).consultar(valor_Cliente);
                Object[] fila = {cotizacion.get(i).getNo_Cotizacion(), cliente.get(0).getCliente(), cliente.get(0).getRUC(), cliente.get(0).getEmpleado(), cotizacion.get(i).getFecha(), cotizacion.get(i).getValor_Total()};
                this.modelo_Tabla_Cotizacion.addRow(fila);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {

        if (this.dialogo_Buscar_Cotizacion.combo_Opciones.getSelectedItem().equals("Seleccionar.....")) {
            this.dialogo_Buscar_Cotizacion.campo_Busqueda.setEditable(false);
        } else {
            this.dialogo_Buscar_Cotizacion.campo_Busqueda.setEditable(true);
            if (ke.getSource() == this.dialogo_Buscar_Cotizacion.campo_Busqueda) {
                this.dialogo_Buscar_Cotizacion.campo_Busqueda.addKeyListener(new KeyAdapter() {

                    public void keyReleased(final KeyEvent e) {
                        filtro();
                    }
                });

                TRSFiltro = new TableRowSorter(this.dialogo_Buscar_Cotizacion.tabla_Consulta_Cotizacion.getModel());
                this.dialogo_Buscar_Cotizacion.tabla_Consulta_Cotizacion.setRowSorter(TRSFiltro);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    public void filtro() {
        if (this.dialogo_Buscar_Cotizacion.combo_Opciones.getSelectedItem() == "Por numero") {
            filtrar_Tabla(0);
        } else if (this.dialogo_Buscar_Cotizacion.combo_Opciones.getSelectedItem() == "Por nombre") {
            filtrar_Tabla(1);
        } else if (this.dialogo_Buscar_Cotizacion.combo_Opciones.getSelectedItem() == "Por RUC") {
            filtrar_Tabla(2);
        }
    }

    public void filtrar_Tabla(int valor) {
        TRSFiltro.setRowFilter(RowFilter.regexFilter("(?i)" + this.dialogo_Buscar_Cotizacion.campo_Busqueda.getText(), valor));
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == this.dialogo_Buscar_Cotizacion.tabla_Consulta_Cotizacion) {

            String valor = this.dialogo_Buscar_Cotizacion.tabla_Consulta_Cotizacion.getValueAt(this.dialogo_Buscar_Cotizacion.tabla_Consulta_Cotizacion.getSelectedRow(), 0) + ";" + this.dialogo_Buscar_Cotizacion.tabla_Consulta_Cotizacion.getValueAt(this.dialogo_Buscar_Cotizacion.tabla_Consulta_Cotizacion.getSelectedRow(), 3);

            this.cotizacion = new DAO_Cotizacion_Implementacion(this.conexion).consultar(valor);
            if (this.cotizacion.size() == 1) {
                this.dialogo_Buscar_Cotizacion.dispose();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.dialogo_Buscar_Cotizacion.combo_Opciones) {
            if (this.dialogo_Buscar_Cotizacion.combo_Opciones.getSelectedItem().equals("Por fecha")) {
                this.dialogo_Buscar_Cotizacion.desactivar_Calendarios(true);
            } else {
                this.dialogo_Buscar_Cotizacion.desactivar_Calendarios(false);
            }
        }

        if (ae.getSource() == this.dialogo_Buscar_Cotizacion.boton_Fecha) {
            if (this.dialogo_Buscar_Cotizacion.verificar_Campos()) {
                this.presentar_Cotizacion(new DAO_Cotizacion_Implementacion(this.conexion).consultar_Cotizacion_Fechas(this.valor + ";" + this.dialogo_Buscar_Cotizacion.calendario_Inicio() + ";" + this.dialogo_Buscar_Cotizacion.calendario_Final()));
                this.dialogo_Buscar_Cotizacion.etiqueta_Error_Etiqueta(false);
            } else {
                this.dialogo_Buscar_Cotizacion.etiqueta_Error_Etiqueta(true);
            }
        }
    }
}
