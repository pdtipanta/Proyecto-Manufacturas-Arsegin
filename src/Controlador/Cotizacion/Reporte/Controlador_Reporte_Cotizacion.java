/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Cotizacion.Reporte;

import Modelo.Cotizacion;
import Modelo.Usuario;
import Vista.Cotizacion.Panel_Cotizacion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author David
 */
public class Controlador_Reporte_Cotizacion {
    private Panel_Cotizacion     panel_Cotizacion;
    private Usuario              usuario;

    public Controlador_Reporte_Cotizacion(Panel_Cotizacion panel_Cotizacion, Usuario usuario) {
        this.panel_Cotizacion = panel_Cotizacion;
        this.usuario = usuario;
    }

    public void iniciar() {
        ArrayList<Cotizacion> lista_Productos = new ArrayList<Cotizacion>();

        for (int i = 0; i < this.panel_Cotizacion.tabla_Productos_Cotizacion.getRowCount(); i++) {
            Cotizacion modelo_Cotizacion = new Cotizacion(this.panel_Cotizacion.etiqueta_No_Cotizacion.getText(), this.panel_Cotizacion.calendario_Fecha(), this.panel_Cotizacion.campo_Modalidad_Cotizacion.getText(), Double.valueOf(this.panel_Cotizacion.campo_Subtotal_Cotizacion.getText()), Double.valueOf(this.panel_Cotizacion.campo_IVA_Cotizacion.getText()), Double.valueOf(this.panel_Cotizacion.campo_Total_Cotizacion.getText()), this.panel_Cotizacion.campo_Emisor_Cotizacion.getText(), this.panel_Cotizacion.combo_Cliente_Cotizacion.getText(), String.valueOf(this.panel_Cotizacion.tabla_Productos_Cotizacion.getValueAt(i, 0)), String.valueOf(this.panel_Cotizacion.tabla_Productos_Cotizacion.getValueAt(i, 1)), String.valueOf(this.panel_Cotizacion.tabla_Productos_Cotizacion.getValueAt(i, 2)), String.valueOf(this.panel_Cotizacion.tabla_Productos_Cotizacion.getValueAt(i, 3)), String.valueOf(this.panel_Cotizacion.tabla_Productos_Cotizacion.getValueAt(i, 4)));
            lista_Productos.add(modelo_Cotizacion);
        }

        try {
            Map parametro = new HashMap();
            parametro.put("RUC", this.panel_Cotizacion.campo_RUC_Cotizacion.getText());
            parametro.put("telefono", this.panel_Cotizacion.campo_Telefono_Cotizacion.getText());
            parametro.put("direccion", this.panel_Cotizacion.campo_Direccion_Cotizacion.getText());
            parametro.put("correo", this.panel_Cotizacion.campo_Correo_Cotizacion.getText());
            parametro.put("emisor", this.usuario.getNombre() + " " + this.usuario.getApellido());
            parametro.put("solicitante", this.panel_Cotizacion.campo_Contacto_Cotizacion.getText());
            parametro.put("observaciones", this.panel_Cotizacion.campo_Modalidad_Cotizacion.getText());
            new JasperViewer(JasperFillManager.fillReport((JasperReport) JRLoader.loadObjectFromFile(System.getProperty("user.dir") + "/src/Reportes/Reporte_Cotizacion.jasper"), parametro, new JRBeanCollectionDataSource(lista_Productos)), false).setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
