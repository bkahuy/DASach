/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GSach;
import java.sql.*;
import java.sql.ResultSet;

/**
 *
 * @author buikh
 */
public class XLSach implements ISach{

    private static Connection cn;
    @Override
    public void getcon() {
        if(cn == null){
            try {
                cn = DriverManager.getConnection("jdbc:sqlserver://BKAHUYYYYY;database=DLSach;user=sa;password=1;trustServerCertificate=true;");
                System.out.println("pass connect");
                
            } catch (SQLException e) {
                System.out.println("failed connect " + e.getMessage());
            }
        }
    }

    @Override
    public ResultSet getSA() {
        getcon();
        try {
            Statement st = cn.createStatement();
            return st.executeQuery("select * from tbSach");
        } catch (SQLException e) {
            System.out.println("failed getSA "+ e.getMessage());
            return null;
        }
    }

    @Override
    public boolean getSAbyNXBGB(String nhaxb, int giab) {
        getcon();
        try {
            PreparedStatement pst = cn.prepareStatement("select * from tbSach where nhaxb = '" + nhaxb + "' and giab = '" + giab +"'");
            int res = pst.executeUpdate();
            return res>0;
        } catch (SQLException e) {
            System.out.println("getSAbyNXHGB failed " + e.getMessage());
            return false;
        }    
    }
    
}
