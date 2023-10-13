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
public class depositDetails extends JFrame implements ActionListener {
     Choice meternumber,cmonth;
     JTable table;
     JButton search,print;
    depositDetails(){
        
        super("Deposit Details");
        
        setSize(700,700);
        setLocation(400,100);
        
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel lblmeternumber= new JLabel("Search By Meter Number");
        lblmeternumber.setBounds(20,20,150,20);
        add(lblmeternumber);
        
        meternumber = new Choice();
        meternumber.setBounds(180,20,150,20);
        add(meternumber);
        
        try{
            DBConnection c = new DBConnection();
            ResultSet rs=c.st.executeQuery("Select * from customer");
            while(rs.next()){
                meternumber.add(rs.getString("meter_no"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lblmonth = new JLabel("Search by month");
        lblmonth.setBounds(400,20,100,20);
        add(lblmonth);
        
        cmonth = new Choice();
        cmonth.setBounds(520, 20, 150, 20);
        cmonth.add("January");
        cmonth.add("February");
        cmonth.add("March");
        cmonth.add("April");
        cmonth.add("May");
        cmonth.add("June");
        cmonth.add("July");
        cmonth.add("August");
        cmonth.add("September");
        cmonth.add("October");
        cmonth.add("November");
        cmonth.add("December");
        add(cmonth);

        table=new JTable();
        try{
            DBConnection c = new DBConnection();
            ResultSet rs = c.st.executeQuery("select * from bill");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0,100,700,600);
        add(sp);
        
        search= new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        
        print= new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String query="select * from bill where meter_no='"+meternumber.getSelectedItem()+"' and month='"+cmonth.getSelectedItem()+"'";
            try{
                DBConnection c = new DBConnection();
                ResultSet rs = c.st.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                
            }
        }
        else{
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    
    public static void main(String[] args) {
        new depositDetails();
    }
}
