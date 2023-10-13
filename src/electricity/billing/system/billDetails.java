/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricity.billing.system;

import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author dell
 */
public class billDetails extends JFrame{
    
    billDetails(String meter){
        setSize(700,650);
        setLocation(400,150);
        setVisible(true);
        
        getContentPane().setBackground(Color.PINK);
        
        JTable table= new JTable();
        
        try{
            DBConnection conn = new DBConnection();
            String query = "select * from bill where meter_no='"+meter+"'";
            ResultSet rs = conn.st.executeQuery(query);
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        JScrollPane sp= new JScrollPane(table);
        sp.setBounds(0,0,700,650);
        add(sp);
        setVisible(true);
    }
    
    
    public static void main(String[] args) {
        new billDetails("");
    }
    
}
