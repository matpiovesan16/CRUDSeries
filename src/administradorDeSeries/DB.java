
package administradorDeSeries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;


public class DB {
    
    public DefaultTableModel getAsistencia(){
        DefaultTableModel resultado = new DefaultTableModel();
        resultado.addColumn("Legajo");
        resultado.addColumn("Nombre");
        resultado.addColumn("Fecha de ingreso");
        resultado.addColumn("Hora de ingreso");
        resultado.addColumn("Oficina");
        try {
            Connection c =
                DriverManager.getConnection(
                    "jdbc:mysql://localhost/asistencia", "root","1234");
            
            
            PreparedStatement ps = c.prepareStatement(
                    "select * from registro order by legajo");
           
            
            ResultSet res = ps.executeQuery();
            while (res.next()){
                Object[] fila = new Object [5];
                fila[0] = res.getString("legajo");
                fila[1] = res.getString("nombre");
                fila[2] = res.getString("fecha");
                fila[3] = res.getString("hora");
                fila[4] = res.getString("oficina");
                resultado.addRow(fila);

            }
                }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    
    
    return resultado;
    }
    
    
    
    
    
    
    
    
    
    
    
    
     public DefaultTableModel setCarga(String leg,String nom,String ofi){
        
    /*    DefaultTableModel resultado = new DefaultTableModel();
        resultado.addColumn("Legajo");
        resultado.addColumn("Nombre");
        resultado.addColumn("Fecha de ingreso");
        resultado.addColumn("Hora de ingreso");
        resultado.addColumn("Oficina");
        
        try {
            Connection c =
                DriverManager.getConnection(
                    "jdbc:mysql://localhost/asistencia", "root","1234");
            PreparedStatement ps = c.prepareStatement(
                    "INSERT INTO registro (legajo,nombre,fecha,hora,oficina) VALUES (?,?,NOW(),NOW(),?);");
            ps.setString(1,leg);
            ps.setString(2,nom);
            ps.setString(3,ofi);
            
            
            ResultSet res = ps.executeQuery();
            while (res.next()){
                Object[] fila = new Object [5];
                fila[0] = res.getString("legajo");
                fila[1] = res.getString("nombre");
                fila[2] = res.getString("fecha");
                fila[3] = res.getString("hora");
                fila[4] = res.getString("oficina");
                resultado.addRow(fila);

            }
                }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    
    
    return resultado;*/
    
    
    
     DefaultTableModel resultado = new DefaultTableModel();
    resultado.addColumn("Legajo");
    resultado.addColumn("Nombre");
    resultado.addColumn("Fecha de ingreso");
    resultado.addColumn("Hora de ingreso");
    resultado.addColumn("Oficina");

    try {
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/asistencia", "root", "1234");

        // Utiliza executeUpdate() para realizar la inserción
        PreparedStatement ps = c.prepareStatement("INSERT INTO registro (legajo, nombre, fecha, hora, oficina) VALUES (?, ?, NOW(), NOW(), ?)");
        ps.setString(1, leg);
        ps.setString(2, nom);
        ps.setString(3, ofi);

        ps.executeUpdate();
        ResultSet res =  ps.executeQuery();


            while (res.next()) {
                Object[] fila = new Object[5];
                fila[0] = res.getString("legajo");
                fila[1] = res.getString("nombre");
                fila[2] = res.getString("fecha");
                fila[3] = res.getString("hora");
                fila[4] = res.getString("oficina");
                resultado.addRow(fila);
            }
        
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }

    return resultado;
    
    
    
}
     
     
     
     public DefaultTableModel getConsulta(String leg,String nom, String ofi){
        
        DefaultTableModel resultado = new DefaultTableModel();
        resultado.addColumn("Legajo");
        resultado.addColumn("Nombre");
        resultado.addColumn("Fecha de ingreso");
        resultado.addColumn("Hora de ingreso");
        resultado.addColumn("Oficina");
        try {
            Connection c =
                DriverManager.getConnection(
                    "jdbc:mysql://localhost/asistencia", "root","1234");
            PreparedStatement ps = c.prepareStatement(
                    "select * from registro where legajo = ? or nombre = ? or oficina = ?");
            ps.setString(1,leg);
            ps.setString(2,nom);
            ps.setString(3,ofi);
            
            
            ResultSet res = ps.executeQuery();
            while (res.next()){
                Object[] fila = new Object [5];
                fila[0] = res.getString("legajo");
                fila[1] = res.getString("nombre");
                fila[2] = res.getString("fecha");
                fila[3] = res.getString("hora");
                fila[4] = res.getString("oficina");
                resultado.addRow(fila);

            }
                }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    
    
    return resultado;
}
     
     
     
     
     
     
     
     
     
     
     
     
}