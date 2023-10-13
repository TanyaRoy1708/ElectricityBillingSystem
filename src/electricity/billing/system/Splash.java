
package electricity.billing.system;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Image;

public class Splash extends JFrame implements Runnable{
    Thread t;
    
    Splash(){

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg"));
        Image i2=i1.getImage().getScaledInstance(730,550,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2) ; //imageicon takes image object
        JLabel image = new JLabel(i3 ); //jlabel takes imageicon object
        add(image); //jframe add method takes jlabel object
        
        
        int x=1;
        for(int i=2;i<600;i+=4, x+=1){
            setSize(i+x,i);
            setLocation(700-((i+x)/2),400-(i/2));
            try{
                Thread.sleep(5);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        t=new Thread(this);
        t.start();        
        
        setVisible(true);
        
    }
    
    public void run(){
        try{
           Thread.sleep(7000); 
           setVisible(false);
           
           new login();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new Splash();
    }
}
