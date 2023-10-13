package electricity.billing.system;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MeterInfo extends JFrame implements ActionListener {

    JTextField tfname, tfaddress, tfstate, tfcity, tfemail, tfphoneno;
    JButton next, cancel;
    JLabel lblmeter;
    Choice meterLocation, metertype,phasecode,billtype;
    String meternumber;
    MeterInfo(String meternumber) {
        this.meternumber=meternumber;
        
        setSize(700, 500);
        setLocation(400, 200);
        
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        add(p);

        JLabel heading = new JLabel("Meter Information ");
        heading.setBounds(180, 10, 200, 25);
        p.add(heading);

        JLabel lblname = new JLabel("Meter Number");
        lblname.setBounds(100, 80, 100, 20);
        p.add(lblname);
        
        JLabel lblmeternumber = new JLabel(meternumber);
        lblmeternumber.setBounds(240, 80, 100, 20);
        p.add(lblmeternumber);


        JLabel lblmeterloc = new JLabel("Meter Location");
        lblmeterloc.setBounds(100, 120, 100, 20);
        p.add(lblmeterloc);

        meterLocation=new Choice();
        meterLocation.add("Outside");
        meterLocation.add("Inside");
        meterLocation.setBounds(240,120,200,20);
        p.add(meterLocation);

        JLabel lblAddress = new JLabel("Meter Type");
        lblAddress.setBounds(100, 160, 100, 20);
        p.add(lblAddress);
        
        metertype= new Choice();
        metertype.add("Electric Meter");
        metertype.add("Solar Meter");
        metertype.add("Smart Meter");
        metertype.setBounds(240,160,200,20);
        p.add(metertype);
        
        JLabel lblphase = new JLabel("Phase Code");
        lblphase.setBounds(100, 200, 100, 20);
        p.add(lblphase);
        
        phasecode= new Choice();
        phasecode.add("011");
        phasecode.add("022");
        phasecode.add("033");
        phasecode.add("044");
        phasecode.add("055");
        phasecode.add("066");
        phasecode.add("077");
        phasecode.add("088");
        phasecode.add("099");
        phasecode.setBounds(240,200,200,20);
        p.add(phasecode);
        

        JLabel lblBillType = new JLabel("Bill Type");
        lblBillType.setBounds(100, 240, 100, 20);
        p.add(lblBillType);
        
        billtype= new Choice();
        billtype.add("Normal");
        billtype.add("Industrial");
        billtype.setBounds(240,240,100,20);
        p.add(billtype);


        JLabel lblDays = new JLabel("Days");
        lblDays.setBounds(100, 280, 100, 20);
        p.add(lblDays);
        
        JLabel lblmonth = new JLabel("30 Days");
        lblmonth.setBounds(240, 280, 100, 20);
        p.add(lblmonth);

        JLabel lblphone = new JLabel("Note");
        lblphone.setBounds(100, 320, 100, 20);
        p.add(lblphone);
        
        JLabel lblBill = new JLabel("By Default Bill is calculated for 30 days only");
        lblBill.setBounds(240, 320, 500, 20);
        p.add(lblBill);

        
        next = new JButton("Submit");
        next.setBounds(220, 390, 100, 25);
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.addActionListener(this);
        p.add(next);

        cancel = new JButton("Cancel");
        cancel.setBounds(250, 390, 100, 25);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        p.add(cancel);

        setLayout(new BorderLayout());
        add(p, "Center");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image, "West");

        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==next){
            String meter=meternumber;
            String location= meterLocation.getSelectedItem();
            String type= metertype.getSelectedItem();
            String code =phasecode.getSelectedItem();
            String typebill = billtype.getSelectedItem();
            String days = "30";
            
            String query1 = "insert into meter_info values('"+meter+"','"+location+"','"+type+"','"+code+"','"+typebill+"','"+days+"')";
        
            try{
               DBConnection c = new DBConnection();
               c.st.executeUpdate(query1);
               
               JOptionPane.showMessageDialog(null,"Meter Information Added Successfully");
               setVisible(false);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        
        }
        
        else{
           setVisible(false);
        }
    }
    public static void main(String[] args) {
        new MeterInfo("");
    }
}

