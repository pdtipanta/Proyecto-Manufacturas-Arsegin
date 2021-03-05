/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Inventario.Reporte;

import Datos.Inventario.DAO_Inventario_Implementacion;
import Modelo.Inventario;
import Vista.Inventario.Reportes.Dialogo_Reporte_Inventario;
import Vista.Vista_Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author David
 */
public class Controlador_Reporte_Inventario implements ActionListener{
    private Vista_Principal    vista;
    private final Connection   conexion;
    private Dialogo_Reporte_Inventario dialogo_Reporte_Inventario;
    

    public Controlador_Reporte_Inventario(Vista_Principal vista, Connection conexion) {
        this.vista = vista;
        this.conexion = conexion;
        this.dialogo_Reporte_Inventario = new Dialogo_Reporte_Inventario(this.vista, true);
        this.dialogo_Reporte_Inventario.boton_Generar_Reporte.addActionListener(this);
    }
    
    public void iniciar(){
        this.dialogo_Reporte_Inventario.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==this.dialogo_Reporte_Inventario.boton_Generar_Reporte){
            ArrayList<Inventario> inventario = new ArrayList<Inventario>();
            
            if (this.dialogo_Reporte_Inventario.combo_Opcion.getSelectedItem() == "Por codigo") {
                this.buscar_Reporte(this.dialogo_Reporte_Inventario.campo_Busqueda_Reporte.getText());
            } else if (this.dialogo_Reporte_Inventario.combo_Opcion.getSelectedItem() == "Por descripcion") {
                inventario = new DAO_Inventario_Implementacion(this.conexion).consultar_Inventario_Descripcion(this.dialogo_Reporte_Inventario.campo_Busqueda_Reporte.getText());
                if (inventario.size() > 0) {
                    generar_Reporte(inventario);
                }
            } else if (this.dialogo_Reporte_Inventario.combo_Opcion.getSelectedItem() == "Todos") {
                this.buscar_Reporte("");
            }
        }
    }
    
    public void buscar_Reporte(String valor){
        ArrayList<Inventario> inventario = new ArrayList<Inventario>();
        inventario = new DAO_Inventario_Implementacion(this.conexion).consultar((this.dialogo_Reporte_Inventario.campo_Busqueda_Reporte.getText()));
        if (inventario.size() > 0) {
            generar_Reporte(inventario);
        }
    }
    
    public void generar_Reporte( ArrayList lista_Inventario ){
        try {
            new JasperViewer(JasperFillManager.fillReport((JasperReport) JRLoader.loadObjectFromFile(System.getProperty("user.dir") + "/src/Reportes/Reporte_Inventario.jasper"), new HashMap(), new JRBeanCollectionDataSource(lista_Inventario)), false).setVisible(true);
            this.dialogo_Reporte_Inventario.dispose();
        } catch (Exception e) {
        }
    }
}
