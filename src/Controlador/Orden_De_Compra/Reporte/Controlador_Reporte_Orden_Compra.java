/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Orden_De_Compra.Reporte;

import Modelo.Orden_Compra;
import Vista.Orden_De_Compra.Panel_Orden_Compra;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author David
 */
public class Controlador_Reporte_Orden_Compra {
    Panel_Orden_Compra panel_Orden_Compra;

    public Controlador_Reporte_Orden_Compra(Panel_Orden_Compra panel_Orden_Compra) {
        this.panel_Orden_Compra = panel_Orden_Compra;
    }
    
    public void iniciar() {
        ArrayList<Orden_Compra> lista_Productos = new ArrayList<Orden_Compra>();

        for (int i = 0; i < this.panel_Orden_Compra.tabla_Productos_Orden_Compra.getRowCount(); i++) {
            Orden_Compra modelo_Orden_Compra = new Orden_Compra(this.panel_Orden_Compra.etiqueta_No_Orden_Compra.getText(), this.panel_Orden_Compra.calendario_Fecha(), Double.valueOf(this.panel_Orden_Compra.campo_Subtotal_Orden_Compra.getText()), Double.valueOf(this.panel_Orden_Compra.campo_IVA_Orden_Compra.getText()), Double.valueOf(this.panel_Orden_Compra.campo_Total_Orden_Compra.getText()), this.panel_Orden_Compra.etiqueta_Estado_Orden.getText(), (String) this.panel_Orden_Compra.combo_Modalidad_Pago_Orden_Compra.getSelectedItem(), this.panel_Orden_Compra.campo_Solicitante_Orden_Compra.getText(), this.panel_Orden_Compra.combo_Proveedor_Orden_Compra.getText(),
                    String.valueOf(this.panel_Orden_Compra.tabla_Productos_Orden_Compra.getValueAt(i, 0)), String.valueOf(this.panel_Orden_Compra.tabla_Productos_Orden_Compra.getValueAt(i, 1)), String.valueOf(this.panel_Orden_Compra.tabla_Productos_Orden_Compra.getValueAt(i, 2)), String.valueOf(this.panel_Orden_Compra.tabla_Productos_Orden_Compra.getValueAt(i, 3)), String.valueOf(this.panel_Orden_Compra.tabla_Productos_Orden_Compra.getValueAt(i, 4)));
            lista_Productos.add(modelo_Orden_Compra);
        }

            try {
                Map parametro = new HashMap();
                parametro.put("Numero_Orden", this.panel_Orden_Compra.etiqueta_No_Orden_Compra.getText());
                parametro.put("RUC", this.panel_Orden_Compra.campo_RUC_Orden_Compra.getText());
                parametro.put("telefono", this.panel_Orden_Compra.campo_Telefono_Orden_Compra.getText());
                parametro.put("direccion", this.panel_Orden_Compra.campo_Direccion_Orden_Compra.getText());
                parametro.put("correo", this.panel_Orden_Compra.campo_Correo_Orden_Compra.getText());
                parametro.put("observaciones", this.panel_Orden_Compra.caja_Observaciones.getText());
                new JasperViewer(JasperFillManager.fillReport((JasperReport) JRLoader.loadObjectFromFile(System.getProperty("user.dir") + "/src/Reportes/Reporte_Orden_Compra.jasper"), parametro, new JRBeanCollectionDataSource(lista_Productos)), false).setVisible(true);
            } catch (Exception e) {
            }
    }
}
