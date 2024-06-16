/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Super_Market;

import java.awt.*;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Mohamed
 */

public class Home extends JFrame implements ActionListener{

    public static void main(String[] args) {
        new Home();
    }
//    ##############################
    JButton add_button ;
    JMenuItem add,edit,delete,search;
//    ##############################
    public Home(){
         super("Super Market");
//##############################################################################
        JMenuBar menubar = new JMenuBar();
        JMenu customer = new JMenu("Customers");
        add = new JMenuItem("New Customer");
        add.addActionListener(this);
        edit = new JMenuItem("Edit A Customer");
        edit.addActionListener(this);
        delete = new JMenuItem("Delete A Customer");
        delete.addActionListener(this);
        search = new JMenuItem("Search About Customer");
        search.addActionListener(this);
        customer.add(add);
        customer.add(edit);
        customer.add(delete);
        customer.add(search);
        menubar.add(customer);
        
        this.setJMenuBar(menubar);
//##############################################################################
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        ImageIcon super_market = new ImageIcon(ClassLoader.getSystemResource("Media/super_market.png"));
        Image logo = super_market.getImage().getScaledInstance(screen.width, screen.height , Image.SCALE_DEFAULT);
        ImageIcon f_logo = new ImageIcon(logo);
        JLabel photo = new JLabel(f_logo);
        
        this.add(photo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setIconImage(super_market.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == add) {
//          this.setVisible(false);
            new New_customer();
        }else if (e.getSource()== edit) {
//            this.setVisible(false);
            new Edit_customer();
        }else if(e.getSource()== delete){
//            this.setVisible(false);
            new Delete_customer();
        }else if(e.getSource()== search){
//            this.setVisible(false);
            new Search_Customers();
        }
       
    }
    
    
    
}
