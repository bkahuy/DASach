/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GSach;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author buikh
 */
public class Gui_findSA extends JFrame implements MouseListener, ActionListener{
    private JTextField tfgiab;
    private JComboBox<String> cbnhaxb;
    private JButton btntim;
    private JTable tb;
    private DefaultTableModel dfmodel;
    
    public Gui_findSA(){
        setTitle("tim kiem sach");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1000,600);
        
        BuildGui();
        loadData(dfmodel);
    }
    
    private void BuildGui(){
        JPanel pntrai = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        
        //gia ban sach
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel lbmas = new JLabel("gia ban sach");
        pntrai.add(lbmas,gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        tfgiab = new JTextField();
        tfgiab.setSize(new Dimension(400, 40));
        pntrai.add(tfgiab, gbc);
        
        //nha xuat ban
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel lbnhaxb = new JLabel("nha xuat ban");
        pntrai.add(lbnhaxb,gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        cbnhaxb = new JComboBox<>(new String[]{"kim dong", "giao duc", "thanh nien"});
        pntrai.add(cbnhaxb,gbc);
        
        // button
        gbc.gridx = 0;
        gbc.gridy = 4;
        btntim = new JButton("tim kiem");
        btntim.addActionListener((e) -> {
            String nhaxb = cbnhaxb.getSelectedItem().toString();
            int giab = Integer.parseInt(tfgiab.getText().trim());
            XLSach xl = new XLSach();
            boolean res = xl.getSAbyNXBGB(nhaxb, giab);
            if (res) {
                loadData(dfmodel);
                JOptionPane.showMessageDialog(null, "tim kiem thanh cong");
            }else{
                JOptionPane.showMessageDialog(null, "khong tim thay");
            }
        });
        pntrai.add(btntim,gbc);
        
        //table
        JPanel pnphai = new JPanel(new GridLayout(1, 1));
        String[] header = {"ma sach", "ten sach", "nha xuat ban", "nam xuat ban", "gia ban", "gia khuyen mai"};
        dfmodel = new DefaultTableModel(header, 0);
        tb = new JTable(dfmodel);
        pnphai.add(new JScrollPane(tb));
        
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(pntrai, BorderLayout.WEST);
        getContentPane().add(pnphai, BorderLayout.CENTER);
        
    }
    private void loadData(DefaultTableModel dfmodel){
        try {
            
            XLSach xl = new XLSach();
            ResultSet res = xl.getSA();
            dfmodel.setRowCount(0);
            if (res != null) {
                while(res.next()){
                    Sach s = new Sach(res.getString("mas"), res.getString("tens"), res.getString("nhaxb"), res.getInt("namxb"), res.getInt("giab"));
                    int giakm = s.Khuyetmai(s.getNamxb(), s.getGiab()); 
                    dfmodel.addRow(new Object[]{
                        s.getMas(),
                        s.getTens(),
                        s.getNhaxb(),
                        s.getNamxb(),
                        s.getGiab(),
                        giakm
                    });
                }
            }
            dfmodel.fireTableDataChanged();
        } catch (SQLException e) {
            System.out.println("loadData failed "+ e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        new Gui_findSA().setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
