package database;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class DataBase {

    public static void main(String[] args) {
        
        
        
        String user = "root";
        String pwd = "abc.1234";
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/eurekabank";
        
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, user, pwd);
            /*String sql = "select vch_emplpaterno, vch_emplmaterno, vch_emplnombre from empleado;";  // Consulta
            pstm = (PreparedStatement) con.prepareStatement(sql); // Carga la consulta
            rs = pstm.executeQuery(sql);  // Ejecuta la consulta y devuelve algun valor
            
            while(rs.next()){
                System.out.print(rs.getString(1) + ", ");
                System.out.print(rs.getString(2) + ", ");
                System.out.println(rs.getString(3) + ".");
             */
            
            String sql = "select e.vch_emplpaterno, e.vch_emplmaterno, e.vch_emplnombre "
                   + "from empleado as e, asignado as a where e.chr_emplcodigo = a.chr_emplcodigo "
                   + "and a.dtt_asigfechabaja is not null;";
            
            pstm = (PreparedStatement) con.prepareStatement(sql); //
            rs = pstm.executeQuery(sql); 
            
            System.out.println("Los siguientes empleados han sido despedidos:");
            
            while(rs.next()){
                System.out.print(rs.getString(1) + ", ");
                System.out.print(rs.getString(2) + ", ");
                System.out.println(rs.getString(3) + ".");
           
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    
}