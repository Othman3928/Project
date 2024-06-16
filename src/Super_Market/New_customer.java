/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Super_Market;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class New_customer extends JFrame  implements ActionListener{
//    ####################################
    JLabel frist_name_label,last_name_label,user_id_label,phone_label,address_label,previous_label,home_page_label;
    JButton save;
    JTextField frist_name,last_name,address,user_id,phone,previous_debts;
    int user__id ;
    
//    ####################################
    public static void main(String[] args) {
    }

    public New_customer(){
        
        super("Add A New Customer");
        
        ImageIcon super_market = new ImageIcon(ClassLoader.getSystemResource("Media/super_market.png"));
        Image logo = super_market.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon f_logo = new ImageIcon(logo);
        JLabel photo = new JLabel(f_logo);
//        #############################################

        home_page_label = new JLabel("Add A New Customer");
        home_page_label.setForeground(Color.BLACK);
        home_page_label.setFont(new Font("AvantGarde", Font.BOLD, 22));
        home_page_label.setBounds(190, 15, 300, 75);
        this.add(home_page_label);
        
         try {
            
                Conection cont = new Conection();
                Statement stmt = cont.statement;

                String selectQuery = "SELECT customer_id FROM customer  ORDER BY customer_id DESC LIMIT 1 "; // استبدل بالاستعلام المناسب
                ResultSet rs = stmt.executeQuery(selectQuery);

                String user_id = ""; // قيمة افتراضية

                if (rs.next()) {
                    user_id = rs.getString("customer_id");
                }else{
                    user_id = "1000" ;
                }
                {
                user__id = (Integer.parseInt(user_id));
                user__id ++;
                }
                cont.connection.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }



        user_id_label = new JLabel("User ID");
        user_id_label.setForeground(Color.BLACK);
        user_id_label.setFont(new Font("AvantGarde", Font.BOLD, 18));
        user_id_label.setBounds(30, 45, 120, 75);
        this.add(user_id_label);
        
        user_id = new JTextField();
        user_id.setBounds(170, 75, 270, 30);
        user_id.setFont(new Font("Arial", Font.BOLD, 14));
        
        String t = (String.valueOf(user__id)) ;
        
        user_id.setText(t);
        this.add(user_id);
        
        frist_name_label = new JLabel("Frist Name");
        frist_name_label.setForeground(Color.BLACK);
        frist_name_label.setFont(new Font("AvantGarde", Font.BOLD, 18));
        frist_name_label.setBounds(30, 120, 120, 75);
        this.add(frist_name_label);
        
        frist_name = new JTextField();
        frist_name.setBounds(170, 150, 270, 30);
        frist_name.setFont(new Font("Arial", Font.BOLD, 14));
        this.add(frist_name);
        
        last_name_label = new JLabel("Last Name");
        last_name_label.setForeground(Color.BLACK);
        last_name_label.setFont(new Font("AvantGarde", Font.BOLD, 18));
        last_name_label.setBounds(30, 195, 120, 75);
        this.add(last_name_label);
        
        last_name = new JTextField();
        last_name.setBounds(170, 225, 270, 30);
        last_name.setFont(new Font("Arial", Font.BOLD, 14));
        this.add(last_name);
        
        address_label = new JLabel("Address");
        address_label.setForeground(Color.BLACK);
        address_label.setFont(new Font("AvantGarde", Font.BOLD, 18));
        address_label.setBounds(30, 270, 120, 75);
        this.add(address_label);
        
        address = new JTextField();
        address.setBounds(170, 300, 270, 30);
        address.setFont(new Font("Arial", Font.BOLD, 14));
        this.add(address);
        
        phone_label = new JLabel("Phone");
        phone_label.setForeground(Color.BLACK);
        phone_label.setFont(new Font("AvantGarde", Font.BOLD, 18));
        phone_label.setBounds(30, 345, 120, 75);
        this.add(phone_label);
        
        phone = new JTextField();
        phone.setBounds(170, 375, 270, 30);
        phone.setFont(new Font("Arial", Font.BOLD, 14));
        this.add(phone);
        
        previous_label = new JLabel("Previous Debits");
        previous_label.setForeground(Color.BLACK);
        previous_label.setFont(new Font("AvantGarde", Font.BOLD, 18));
        previous_label.setBounds(30, 415, 170, 75);
        this.add(previous_label);
        
        
        previous_debts = new JTextField();
        previous_debts.setBounds(190, 440, 250, 30);
        previous_debts.setFont(new Font("Arial", Font.BOLD, 14));
        this.add(previous_debts);
        
        save = new JButton("Save");
        save.setFont(new Font("Arial", Font.BOLD, 14));
        save.setBackground(Color.black);
        save.setForeground(Color.white);
        save.setBounds(250, 550, 100, 30);
        save.addActionListener(this);
        this.add(save);
        
//        ############################
        
        previous_debts.setText("0");
        
        
//        ################################################
        this.add(photo);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setIconImage(super_market.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
        this.setSize(600, 600);
        this.pack();
        this.setLocation(250,67);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== save) {
            if(frist_name.getText().isEmpty()  ||  last_name.getText().isEmpty() ||  user_id.getText().isEmpty())
            {
             JOptionPane.showMessageDialog(null, "Please , There A Filed Is Empty");
            }else{
            String id = user_id.getText();
            String F_String = frist_name.getText();
            String L_String = last_name.getText();
            String P_String = phone.getText();
            String A_String = address.getText();
            String D_String = previous_debts.getText();
            double IntDebit = (Double.valueOf(D_String));
            try {
            Conection data = new Conection();
            Statement stmt = data.statement;
            String q1 = "insert into customer values('"+id+"','"+F_String+"','"+L_String+"','"+P_String+"','"+A_String+"','"+IntDebit+"')";
            data.statement.executeUpdate(q1);
            
           try {
            
                Conection cont = new Conection();
                Statement m = cont.statement;
                Properties mmm = new Properties();
//                mmm.setProperty(q1, q1);

                String selectQuery = "SELECT customer_id FROM customer  ORDER BY customer_id DESC LIMIT 1 "; // استبدل بالاستعلام المناسب
                ResultSet rs = m.executeQuery(selectQuery);

                String number = ""; // قيمة افتراضية

                if (rs.next()) {
                    number = rs.getString("customer_id");
                }
                else
                {
                    number = "1000" ;
                }
                
                 int  number_d = (Integer.parseInt(number));
                number_d ++;
                
                String t = (String.valueOf(number_d)) ;
        
               user_id.setText(t);
               
               
               cont.connection.close();
               rs.close();
            } catch (SQLException f) {
                f.printStackTrace();
            }
            frist_name.setText("");
            last_name.setText("");
            phone.setText("");
            address.setText("");
            previous_debts.setText("");
            
            data.connection.close();
            
            } catch (SQLException E) {
                
                E.printStackTrace();
            }
            }
            
        }
    }
   
    
}
