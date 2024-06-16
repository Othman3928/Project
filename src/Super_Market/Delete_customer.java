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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Delete_customer extends JFrame  implements ActionListener{
//    ####################################
    JLabel frist_name_label,last_name_label,user_id_label,phone_label,address_label,previous_label,home_page_label;
    JButton delete , search;
    JTextField frist_name,last_name,address,user_id,phone,previous_debts;
    static String ffff ;
    String frist,last,ph,addr,de;
    
    
//    ####################################
    public static void main(String[] args) {
       Delete_customer m = new Delete_customer();
    }

    public Delete_customer(){
        
        super("Delete Customer");
        
        ImageIcon super_market = new ImageIcon(ClassLoader.getSystemResource("Media/super_market.png"));
        Image logo = super_market.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon f_logo = new ImageIcon(logo);
        JLabel photo = new JLabel(f_logo);
//        #############################################

        home_page_label = new JLabel("Delete A Customer");
        home_page_label.setForeground(Color.BLACK);
        home_page_label.setFont(new Font("AvantGarde", Font.BOLD, 22));
        home_page_label.setBounds(190, 15, 300, 75);
        this.add(home_page_label);


        user_id_label = new JLabel("User ID");
        user_id_label.setForeground(Color.BLACK);
        user_id_label.setFont(new Font("AvantGarde", Font.BOLD, 18));
        user_id_label.setBounds(30, 45, 120, 75);
        this.add(user_id_label);
        
        user_id = new JTextField();
        user_id.setBounds(170, 75, 270, 30);
        user_id.setFont(new Font("Arial", Font.BOLD, 14));
        this.add(user_id);
        
        search = new JButton("Search");
        search.setFont(new Font("Arial", Font.BOLD, 14));
        search.setBackground(Color.black);
        search.setForeground(Color.white);
        search.setBounds(250, 350, 100, 30);
        search.addActionListener(this);
        this.add(search);
        
//        ############################
        
        
        
        
//        ################################################
        this.add(photo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setIconImage(super_market.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
        this.setSize(600, 600);
        this.pack();
        this.setLocation(250,67);
    }

    public Delete_customer(int a){
        
        super("Delete Customer");
        
        try {
            String m = String.valueOf(ffff);
            Conection con = new Conection();
            Statement stmt = con.statement;
            String sql = "SELECT * FROM customer WHERE customer_id = '"+m+"'";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
            frist = rs.getString("frist_name");
            last = rs.getString("last_name");
            ph = rs.getString("phone");
            addr=rs.getString("address");
            de = rs.getString("debts");
            }else
            {
                System.out.println("Error data");
            }
            
        } catch (Exception e) {
        }
    
        
        
        ImageIcon super_market = new ImageIcon(ClassLoader.getSystemResource("Media/super_market.png"));
        Image logo = super_market.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon f_logo = new ImageIcon(logo);
        JLabel photo = new JLabel(f_logo);
//        #############################################

        home_page_label = new JLabel("Delete A Customer");
        home_page_label.setForeground(Color.BLACK);
        home_page_label.setFont(new Font("AvantGarde", Font.BOLD, 22));
        home_page_label.setBounds(190, 15, 300, 75);
        this.add(home_page_label);


        user_id_label = new JLabel("User ID");
        user_id_label.setForeground(Color.BLACK);
        user_id_label.setFont(new Font("AvantGarde", Font.BOLD, 18));
        user_id_label.setBounds(30, 45, 120, 75);
        this.add(user_id_label);
        
        user_id = new JTextField();
        user_id.setBounds(170, 75, 270, 30);
        user_id.setFont(new Font("Arial", Font.BOLD, 14));
        user_id.setText(String.valueOf(ffff));
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
        frist_name.setText(frist);
       
        
        last_name_label = new JLabel("Last Name");
        last_name_label.setForeground(Color.BLACK);
        last_name_label.setFont(new Font("AvantGarde", Font.BOLD, 18));
        last_name_label.setBounds(30, 195, 120, 75);
        this.add(last_name_label);
        
        last_name = new JTextField();
        last_name.setBounds(170, 225, 270, 30);
        last_name.setFont(new Font("Arial", Font.BOLD, 14));
        last_name.setText(last);
        this.add(last_name);
        
        address_label = new JLabel("Address");
        address_label.setForeground(Color.BLACK);
        address_label.setFont(new Font("AvantGarde", Font.BOLD, 18));
        address_label.setBounds(30, 270, 120, 75);
        this.add(address_label);
        
        address = new JTextField();
        address.setBounds(170, 300, 270, 30);
        address.setFont(new Font("Arial", Font.BOLD, 14));
        address.setText(addr);
        this.add(address);
        
        phone_label = new JLabel("Phone");
        phone_label.setForeground(Color.BLACK);
        phone_label.setFont(new Font("AvantGarde", Font.BOLD, 18));
        phone_label.setBounds(30, 345, 120, 75);
        this.add(phone_label);
        
        phone = new JTextField();
        phone.setBounds(170, 375, 270, 30);
        phone.setFont(new Font("Arial", Font.BOLD, 14));
        phone.setText(ph);
        this.add(phone);
        
//        previous_label = new JLabel("Previous Debits");
//        previous_label.setForeground(Color.BLACK);
//        previous_label.setFont(new Font("AvantGarde", Font.BOLD, 18));
//        previous_label.setBounds(30, 415, 170, 75);
//        this.add(previous_label);
//        
//        
//        previous_debts = new JTextField();
//        previous_debts.setBounds(190, 440, 250, 30);
//        previous_debts.setFont(new Font("Arial", Font.BOLD, 14));
//        this.add(previous_debts);
        
        delete = new JButton("Delete");
        delete.setFont(new Font("Arial", Font.BOLD, 14));
        delete.setBackground(Color.black);
        delete.setForeground(Color.white);
        delete.setBounds(250, 550, 100, 30);
        delete.addActionListener(this);
        this.add(delete);
        
        
//        ############################
//        ################################################
        this.add(photo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setIconImage(super_market.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
        this.setSize(600, 600);
        this.pack();
        this.setLocation(250,67);
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== search){
            try {
            
            Conection con = new Conection();
            Statement stmt = con.statement;
            String sql = "SELECT * FROM customer WHERE customer_id = '"+user_id.getText()+"'";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                ffff = user_id.getText();
            setVisible(false);
            Delete_customer x = new Delete_customer(7);
            }else
            {
                System.out.println("Error data");
                Delete_customer x = new Delete_customer();
            }
            
        } catch (Exception f) {
            f.printStackTrace();
        }
            
        }else if(e.getSource()== delete){
            if(frist_name.getText().isEmpty()  ||  last_name.getText().isEmpty() ||  user_id.getText().isEmpty())
            {
             JOptionPane.showMessageDialog(null, "Please , There A Filed Is Empty");
            }else{
            String id = user_id.getText();
            String F_String = frist_name.getText();
            String L_String = last_name.getText();
            String P_String = phone.getText();
            String A_String = address.getText();
            
            try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/super_market","root","mhmd123@456ZXC");
            String sql = "DELETE FROM  customer WHERE customer_id = '"+id+"'" ;
            PreparedStatement PreparedStatement = connection.prepareStatement(sql);
            int row = PreparedStatement.executeUpdate();
            if(row>0){
                {
                    setVisible(false);
                    Delete_customer m = new Delete_customer();
                }
            }
            
            } catch (SQLException E) {
                
                E.printStackTrace();
                
            }
        }
            
        }
    }
}
    

