package medicalstore;

import javax.swing.*;
  
import java.awt.*;  
import java.awt.event.*;  
import java.sql.*;  
public class signup extends JFrame implements ActionListener   
{  
	Connection c1;
	PreparedStatement pst;
	ResultSet rs;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8 ,l9;  
    JTextField tf1, tf2, tf5, tf6, tf7;  
    JButton btn1, btn2;  
    JPasswordField p1, p2;  
    signup()  
    {  
         
          
        l1 = new JLabel("Registration");
        l1.setBounds(200, 30, 450, 30);
        l1.setForeground(Color.blue);  
        l1.setFont(new Font("Serif", Font.BOLD, 20)); 
        
        l2 = new JLabel("Name:"); 
        l2.setBounds(80, 80, 200, 30); 
        l3 = new JLabel("Email-ID: *"); 
        l3.setBounds(80, 120, 200, 30);  
        l4 = new JLabel("Create Passowrd:"); 
        l4.setBounds(80, 160, 200, 30); 
        l5 = new JLabel("Confirm Password:"); 
        l5.setBounds(80, 200, 200, 30); 
        l6 = new JLabel("Country:");  
        l6.setBounds(80, 240, 200, 30); 
        l7 = new JLabel("State:");  
        l7.setBounds(80, 280, 200, 30); 
        l8 = new JLabel("Phone No: *"); 
        l8.setBounds(80, 320, 200, 30); 
        tf1 = new JTextField(); 
        tf1.setBounds(300, 80, 200, 30); 
        tf2 = new JTextField(); 
        tf2.setBounds(300, 120, 200, 30); 
        p1 = new JPasswordField(); 
        p1.setBounds(300, 160, 200, 30); 
        p2 = new JPasswordField(); 
        p2.setBounds(300, 200, 200, 30); 
        tf5 = new JTextField();  
        tf5.setBounds(300, 240, 200, 30); 
        tf6 = new JTextField(); 
        tf6.setBounds(300, 280, 200, 30); 
        tf7 = new JTextField();  
        tf7.setBounds(300, 320, 200, 30);
        btn1 = new JButton("Submit");  
        btn1.setBounds(200, 430, 100, 30); 
        btn2 = new JButton("Clear"); 
        btn2.setBounds(380, 430, 100, 30); 
        btn1.addActionListener(this);  
        btn2.addActionListener(this);  
      
         
       
        add(l1);  
        add(l2);  
        add(tf1);  
        add(l3);  
        add(tf2);  
        add(l4);  
        add(p1);  
        add(l5);  
        add(p2);  
        add(l6);  
        add(tf5);  
        add(l7);  
        add(tf6);  
        add(l8);  
        add(tf7);  
        add(btn1);  
        add(btn2);  
        
        l9 = new JLabel("select your gender "); 
        l9.setBounds(50, 370, 150, 30); 
        add(l9);
        Choice c = new Choice();    
        c.setBounds(150, 400, 75, 75); 
        c.add("Item 1");    
        c.add("Item 2");    
        c.add("Item 3");  
        add(c);  
        
        setVisible(true);  
        setSize(600, 600);  
        setLocation(300,100);
        setLayout(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setTitle("Registration ");
    }  
//    public void actionPerformed(ActionEvent e)   
//    {  
//        if (e.getSource() == btn1)  
//         {  
//            int x = 0;  
//            String s1 = tf1.getText();  
//            String s2 = tf2.getText();  
//            char[] s3 = p1.getPassword();  
//            char[] s4 = p2.getPassword();   
//            String s8 = new String(s3);  
//            String s9 = new String(s4);  
//            String s5 = tf5.getText();  
//            String s6 = tf6.getText();  
//            String s7 = tf7.getText();  
//            if (s8.equals(s9))  
//            {  
//                try  
//                {  
//                    Class.forName("com.mysql.jdbc.Driver"); 
//                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/medical","root",""); 
//                    pst=con.prepareStatement("select*from sinup");
//                    rs=pst.executeQuery();
//                    PreparedStatement ps = con.prepareStatement("insert into sinup values(?,?,?,?,?,?)");  
//                    ps.setString(1, s1);  
//                    ps.setString(2, s2);  
//                    ps.setString(3, s8);  
//                    ps.setString(4, s5);  
//                    ps.setString(5, s6);  
//                    ps.setString(6, s7);  
//                    ResultSet rs = ps.executeQuery();  
//                    x++;  
//                    if (x > 0)   
//                    {  
//                        JOptionPane.showMessageDialog(btn1, "Data Saved Successfully");  
//                    }  
//                }  
//                catch (Exception ex)   
//                {  
//                    System.out.println(ex);  
//                }  
//            }  
//            else  
//            {  
//                JOptionPane.showMessageDialog(btn1, "Password Does Not Match");  
//            }   
//          }   
//          else  
//          {  
//            tf1.setText("");  
//            tf2.setText("");  
//            p1.setText("");  
//            p2.setText("");  
//            tf5.setText("");  
//            tf6.setText("");  
//            tf7.setText("");  
//          }  
//    }   
    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource()==btn1)
    {
try
{
   String un=tf1.getText();
   String pwd=p1.getText();
   Class.forName("com.mysql.jdbc.Driver").newInstance();
   c1=DriverManager.getConnection("jdbc:mysql://localhost/medical","root","");
   pst = c1.prepareStatement("select*from login");
   
if(un.equals(""))
{   
  JOptionPane.showMessageDialog(this,"Username Required");
}
else if(pwd.equals(""))
{
   JOptionPane.showMessageDialog(this,"Password Required");
 }
else
{
       pst=c1.prepareStatement("Select * from login where Username=? and Password=?");

pst.setString(1,un);
pst.setString(2,pwd);
rs=pst.executeQuery();

if(rs.next())
 {  
             JOptionPane.showMessageDialog(this,"Username/Password Accepted");
             MedicalStore2 aa=new MedicalStore2();
             setVisible(false);
}

else 
   
  JOptionPane.showMessageDialog(this,"Username/Password Not Accepted");
  }
}
catch(Exception e)
  {
     System.out.println("error is "+e );
  }
}
if(ae.getSource()==btn2)
       {
         tf1.setText("");
         p1.setText("");
         tf1.requestFocus();
       }
}
    public static void main(String args[])  
    {  
        new signup();
        
    }  
}  
