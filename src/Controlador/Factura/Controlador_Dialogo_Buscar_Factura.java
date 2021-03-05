/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Factura;

import Datos.Cliente.DAO_Cliente_Implementacion;
import Datos.Factura.DAO_Factura_Implementacion;
import Modelo.Cliente;
import Modelo.Factura;
import Modelo.Usuario;
import Vista.Factura.Dialogo_Buscar_Facturas;
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
public class Controlador_Dialogo_Buscar_Factura implements ActionListener, KeyListener, MouseListener {

    private final Vista_Principal               vista;
    private final Connection                    conexion;
    private final Usuario                       usuario;
    private final String                        rol;
    private final Dialogo_Buscar_Facturas       dialogo_Buscar_Facturas;
    private TableRowSorter                      TRSFiltro;
    private DefaultTableModel                   modelo_Tabla_Facturas;
    private String                              valor = null;
    private ArrayList<Factura>                  factura = new ArrayList<Factura>();

    public Controlador_Dialogo_Buscar_Factura(Vista_Principal vista, Connection conexion, Usuario usuario, String rol) {
        this.vista = vista;
        this.conexion = conexion;
        this.usuario = usuario;
        this.rol = rol;
        this.dialogo_Buscar_Facturas = new Dialogo_Buscar_Facturas(this.vista, true);
        this.dialogo_Buscar_Facturas.campo_Busqueda.addKeyListener(this);
        this.dialogo_Buscar_Facturas.boton_Fecha.addActionListener(this);
        this.dialogo_Buscar_Facturas.combo_Opciones.addActionListener(this);
        this.dialogo_Buscar_Facturas.tabla_Consulta_Factura.addMouseListener(this);
        this.modelo_Tabla_Facturas = (DefaultTableModel) this.dialogo_Buscar_Facturas.tabla_Consulta_Factura.getModel();
    }

    public ArrayList<Factura> iniciar() {
        consultar_Datos_Facturas();
        this.dialogo_Buscar_Facturas.setVisible(true);
        return this.factura;
    }

    public void consultar_Datos_Facturas() {

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
        
        presentar_Facturas(new DAO_Factura_Implementacion(this.conexion).consultar(valor));
    }

    public void presentar_Facturas(ArrayList<Factura> factura) {
        this.modelo_Tabla_Facturas.setRowCount(0);
        
        if (factura.size() > 0) {
            for (int i = 0; i < factura.size(); i++) {
                String valor_Cliente = factura.get(i).getCliente() + ";" + factura.get(i).getVendedor();
                ArrayList<Cliente> cliente = new DAO_Cliente_Implementacion(this.conexion).consultar(valor_Cliente);
                Object[] fila = {factura.get(i).getNo_Factura(), cliente.get(0).getCliente(), cliente.get(0).getRUC(), factura.get(i).getEstado(), factura.get(i).getValor_Total(), factura.get(i).getFecha(), cliente.get(0).getEmpleado()};
                this.modelo_Tabla_Facturas.addRow(fila);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {

        if (this.dialogo_Buscar_Facturas.combo_Opciones.getSelectedItem().equals("Seleccionar.....")) {
            this.dialogo_Buscar_Facturas.campo_Busqueda.setEditable(false);
        } else {
            this.dialogo_Buscar_Facturas.campo_Busqueda.setEditable(true);
            if (ke.getSource() == this.dialogo_Buscar_Facturas.campo_Busqueda) {
                this.dialogo_Buscar_Facturas.campo_Busqueda.addKeyListener(new KeyAdapter() {

                    public void keyReleased(final KeyEvent e) {
                        filtro();
                    }
                });

                TRSFiltro = new TableRowSorter(this.dialogo_Buscar_Facturas.tabla_Consulta_Factura.getModel());
                this.dialogo_Buscar_Facturas.tabla_Consulta_Factura.setRowSorter(TRSFiltro);
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
        if (this.dialogo_Buscar_Facturas.combo_Opciones.getSelectedItem() == "Por numero") {
            filtrar_Tabla(0);
        } else if (this.dialogo_Buscar_Facturas.combo_Opciones.getSelectedItem() == "Por nombre") {
            filtrar_Tabla(1);
        } else if (this.dialogo_Buscar_Facturas.combo_Opciones.getSelectedItem() == "Por RUC") {
            filtrar_Tabla(2);
        }
    }

    public void filtrar_Tabla(int valor) {
        TRSFiltro.setRowFilter(RowFilter.regexFilter("(?i)" + this.dialogo_Buscar_Facturas.campo_Busqueda.getText(), valor));
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == this.dialogo_Buscar_Facturas.tabla_Consulta_Factura) {

            String valor = this.dialogo_Buscar_Facturas.tabla_Consulta_Factura.getValueAt(this.dialogo_Buscar_Facturas.tabla_Consulta_Factura.getSelectedRow(), 0) + ";" + this.dialogo_Buscar_Facturas.tabla_Consulta_Factura.getValueAt(this.dialogo_Buscar_Facturas.tabla_Consulta_Factura.getSelectedRow(), 6);

            this.factura = new DAO_Factura_Implementacion(this.conexion).consultar(valor);
            if (this.factura.size() == 1) {
                this.dialogo_Buscar_Facturas.dispose();
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

        if (ae.getSource() == this.dialogo_Buscar_Facturas.combo_Opciones) {
            if (this.dialogo_Buscar_Facturas.combo_Opciones.getSelectedItem().equals("Por fecha")) {
                this.dialogo_Buscar_Facturas.desactivar_Calendarios(true);
            } else {
                this.dialogo_Buscar_Facturas.desactivar_Calendarios(false);
            }
        }

        if (ae.getSource() == this.dialogo_Buscar_Facturas.boton_Fecha) {
            if (this.dialogo_Buscar_Facturas.verificar_Campos()) {
                this.presentar_Facturas(new DAO_Factura_Implementacion(this.conexion).consultar_Facturas_Fechas(this.valor + ";" + this.dialogo_Buscar_Facturas.calendario_Inicio() + ";" + this.dialogo_Buscar_Facturas.calendario_Final()));
                this.dialogo_Buscar_Facturas.etiqueta_Error_Etiqueta(false);
            } else {
                this.dialogo_Buscar_Facturas.etiqueta_Error_Etiqueta(true);
            }
        }
    }
}
