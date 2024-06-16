/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Super_Market;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;

/**
 *
 * @author Mohamed
 */
public class New_product extends JFrame{
    public static void main(String[] args) {
        new New_product();
    }
    JLabel product_id_label,home_page_label,name_product_label,x,y,z,m,h,j,k,l,o;
    JTextField q,w,e,r,t,v,u,i,p,f,g;

    public New_product() {
        super("NEW Product");
     ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("Media/logo.jpg"));
     ImageIcon home = new ImageIcon(ClassLoader.getSystemResource("Media/search.jpg"));
     Image photo = home.getImage().getScaledInstance(920, 940, Image.SCALE_DEFAULT);
     ImageIcon f_home = new ImageIcon(photo);
     JLabel fin = new JLabel(f_home);
     
     home_page_label = new JLabel("Add A New Product");
     home_page_label.setForeground(Color.BLACK);
     home_page_label.setFont(new Font("AvantGarde", Font.BOLD, 22));
     home_page_label.setBounds(190, 15, 300, 75);
     this.add(home_page_label);
     
     this.add(fin);
     this.setSize(920, 940);
     this.setLocationRelativeTo(null);
     this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     this.setVisible(true);
     this.revalidate();
     this.repaint(6);
     this.setIconImage(logo.getImage());
        
    }
    
    
    
}
