/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Clientes;

import Datos.Cliente.DAO_Cliente_Implementacion;
import Modelo.Cliente;
import Modelo.Usuario;
import Vista.Vista_Principal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
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
public class Controlador_Reporte_Cliente {
    private Vista_Principal vista;
    private Connection conexion;
    private final Usuario usuario;
    private final String rol;

    public Controlador_Reporte_Cliente(Vista_Principal vista, Connection conexion, Usuario usuario, String rol) {
        this.vista = vista;
        this.conexion = conexion;
        this.usuario = usuario;
        this.rol = rol;
    }
    
    public void iniciar(){
        String opcion = (String) JOptionPane.showInputDialog(null, "Seleccione ciudad", "Reporte de clientes", JOptionPane.QUESTION_MESSAGE, null, lista_Ciudades(), lista_Ciudades()[0]);
        
        if (opcion != "Seleccione......" && opcion != null) {
            generar_Reporte(lista_Clientes(opcion));
        }
    }
    
    public ArrayList<Cliente> lista_Clientes( String opcion){
        return new DAO_Cliente_Implementacion(this.conexion).consultar_Reporte_Cliente(opcion, this.roles_Reportes());
    }
    
    public String[] lista_Ciudades() {
        return new DAO_Cliente_Implementacion(this.conexion).consultar_Lista_Ciudades(this.roles_Reportes());
    }
    
    public String roles_Reportes() {
        String valor = null;

        switch (this.rol) {
            case "Vendedor":
                valor = this.usuario.getCedula();
                break;

            case "Contador":
                valor = "Todos";
                break;

            case "Administrador":
                valor = "Todos";
                break;
        }

        return valor;
    }
    
    public void generar_Reporte(ArrayList lista_Clientes) {
        try {
            new JasperViewer(JasperFillManager.fillReport((JasperReport) JRLoader.loadObjectFromFile(System.getProperty("user.dir") + "/src/Reportes/Reporte_Cliente.jasper"), new HashMap(), new JRBeanCollectionDataSource(lista_Clientes)), false).setVisible(true);
        } catch (Exception e1) {
        }
    }
}
