package Super_Market;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;

public class Search_Customers extends JFrame implements ActionListener,DocumentListener{
   
     JTextField search ;
     JButton searchb,back,delete,edit,New,cash;
     DefaultTableModel tab;
     JTable table ;
     Object[] rowdata ;
     String variable ;
    public Search_Customers() {
     super("Search About Customers");
     ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("Media/logo.jpg"));
     ImageIcon home = new ImageIcon(ClassLoader.getSystemResource("Media/search.jpg"));
     Image photo = home.getImage().getScaledInstance(920, 940, Image.SCALE_DEFAULT);
     ImageIcon f_home = new ImageIcon(photo);
     JLabel fin = new JLabel(f_home);
     
     search = new JTextField();
     search.setBounds(170, 65, 370, 30);
     search.setFont(new Font("Arial", Font.BOLD, 14));
     search.getDocument().addDocumentListener(this);
     search.getDocument().putProperty("name", "Text Field");
     search.requestFocusInWindow();
     this.add(search);
     
     searchb = new JButton("Search");
     searchb.setFont(new Font("Arial", Font.BOLD, 14));
     searchb.setBackground(Color.black);
     searchb.setForeground(Color.white);
     searchb.setBounds(550, 65, 100, 30);
     searchb.addActionListener(this);
     this.add(searchb);
     
     back = new JButton("Back");
     back.setFont(new Font("Arial", Font.BOLD, 14));
     back.setBackground(Color.black);
     back.setForeground(Color.white);
     back.setBounds(80, 820, 100, 30);
     back.addActionListener(this);
     this.add(back);
     
     delete = new JButton("Delete");
     delete.setFont(new Font("Arial", Font.BOLD, 14));
     delete.setBackground(Color.black);
     delete.setForeground(Color.white);
     delete.setBounds(240, 820, 100, 30);
     delete.addActionListener(this);
     this.add(delete);
     
     edit = new JButton("Edit");
     edit.setFont(new Font("Arial", Font.BOLD, 14));
     edit.setBackground(Color.black);
     edit.setForeground(Color.white);
     edit.setBounds(390, 820, 100, 30);
     edit.addActionListener(this);
     this.add(edit);
     
     
     New = new JButton("New");
     New.setFont(new Font("Arial", Font.BOLD, 14));
     New.setBackground(Color.black);
     New.setForeground(Color.white);
     New.setBounds(560, 820, 100, 30);
     New.addActionListener(this);
     this.add(New);
     
     cash = new JButton("Cash");
     cash.setFont(new Font("Arial", Font.BOLD, 14));
     cash.setBackground(Color.black);
     cash.setForeground(Color.white);
     cash.setBounds(730, 820, 100, 30);
     cash.addActionListener(this);
     this.add(cash);
             
     
     tab = new DefaultTableModel();
     table = new JTable(tab);
     tab.addColumn("ID");
     tab.addColumn("Frist Name");
     tab.addColumn("Last Name");
     tab.addColumn("Address");
     tab.addColumn("Phone");
     tab.addColumn("Debits");
     table.setPreferredScrollableViewportSize(new Dimension(820,640));
     JScrollPane scroll = new JScrollPane(table);
     scroll.setBounds(40, 150, 820, 640);
     this.add(scroll);
     
      try
        {
            Conection con = new Conection();
            String sql = "SELECT * FROM customer ";
            PreparedStatement stmt = con.connection.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData meta = rs.getMetaData();
            int count = meta.getColumnCount();
            while(rs.next()){
                rowdata = new Object[count];
                for(int j = 1;j<= count ; j++){
                    rowdata[j-1]= rs.getObject(j);
                }
                tab.addRow(rowdata);
                
            }    
        }catch(SQLException g)
        {
            g.printStackTrace();
        }
        
     
     
     
     this.add(fin);
     this.setSize(920, 940);
     this.setLocationRelativeTo(null);
     this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     this.setVisible(true);
     this.revalidate();
     this.repaint(6);
     this.setIconImage(logo.getImage());
     
     
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== searchb){
        tab.setRowCount(0);
        try
        {
            Conection con = new Conection();
            String sql = "SELECT * FROM customer WHERE frist_name LIKE ?";
            PreparedStatement stmt = con.connection.prepareStatement(sql);
            String searchitem = search.getText();
            stmt.setString(1, "%"+searchitem+"%");
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            int count = meta.getColumnCount();
            while(rs.next()){
                rowdata = new Object[count];
                for(int j = 1;j<= count ; j++){
                    rowdata[j-1]= rs.getObject(j);
                }
                tab.addRow(rowdata);
            }    
        }catch(SQLException g)
        {
            g.printStackTrace();
        }
        }else if(e.getSource()== back){
            this.setVisible(false);
            new Home();
        }else if (e.getSource()== delete){
            this.setVisible(false);
            new Delete_customer();
        }else if (e.getSource()== edit){
            this.setVisible(false);
            new Edit_customer();
        }else if(e.getSource()==New){
            this.setVisible(false);
            new New_customer();
        }else if (e.getSource()== cash){
            this.setVisible(false);
            
        }
        
        
        
        
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        tab.setRowCount(0);
        try
        {
            Conection con = new Conection();
            String sql = "SELECT * FROM customer WHERE frist_name LIKE ?";
            PreparedStatement stmt = con.connection.prepareStatement(sql);
            String searchitem = search.getText();
            stmt.setString(1, "%"+searchitem+"%");
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            int count = meta.getColumnCount();
            while(rs.next()){
                rowdata = new Object[count];
                for(int j = 1;j<= count ; j++){
                    rowdata[j-1]= rs.getObject(j);
                }
                tab.addRow(rowdata);
            }    
        }catch(SQLException g)
        {
            g.printStackTrace();
        }

    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        tab.setRowCount(0);
        try
        {
            Conection con = new Conection();
            String sql = "SELECT * FROM customer WHERE frist_name LIKE ?";
            PreparedStatement stmt = con.connection.prepareStatement(sql);
            String searchitem = search.getText();
            stmt.setString(1, "%"+searchitem+"%");
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            int count = meta.getColumnCount();
            while(rs.next()){
                rowdata = new Object[count];
                for(int j = 1;j<= count ; j++){
                    rowdata[j-1]= rs.getObject(j);
                }
                tab.addRow(rowdata);
            }    
        }catch(SQLException g)
        {
            g.printStackTrace();
        }
        
        
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


        
        
    }
    
