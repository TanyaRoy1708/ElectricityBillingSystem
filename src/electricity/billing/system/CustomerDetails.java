/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricity.billing.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author dell
 */
public class CustomerDetails extends JFrame implements ActionListener {
     Choice meternumber,cmonth;
     JTable table;
     JButton search,print;
    CustomerDetails(){
        
        super("Customer Details");
        
        setSize(1200,650);
        setLocation(200,150);
        
  
        table=new JTable();
        try{
            DBConnection c = new DBConnection();
            ResultSet rs = c.st.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        JScrollPane sp = new JScrollPane(table);
        add(sp);
       
        
        print= new JButton("Print");
        print.addActionListener(this);
        add(print,"South");

        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
    }
    
    
    public static void main(String[] args) {
        new CustomerDetails();
    }
}
