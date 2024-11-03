/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package GSach;
import java.sql.*;
/**
 *
 * @author buikh
 */
public interface ISach {
    public void getcon();
    public ResultSet getSA();
    public ResultSet getSAbyNXBGB(String nhaxb, int giab);
}
