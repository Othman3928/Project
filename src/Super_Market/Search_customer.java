/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Super_Market;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mohamed
 */
public class Search_customer extends JFrame implements ActionListener{
    String pin ;
    JButton button;
    JTable table ;
    
    
    Search_customer()
    {
        
//        getContentPane().setBackground(new Color(200, 204, 204));
//        setSize(400,600);
//        setLocation(20, 20);
//        setLayout(null);
        
        
      
        
        
        try
        {
            Conection con = new Conection();
            Statement stmt = con.statement;
            String sql = "SELECT * FROM customer ";
            ResultSet rs = stmt.executeQuery(sql);
            DefaultTableModel tab = new DefaultTableModel();
            ResultSetMetaData meta = rs.getMetaData();
            int count = meta.getColumnCount();
//            for(int i = 1 ; i <= count ; i++){
//                tab.addColumn(meta.getColumnName(count));
//                
//            }
            while(rs.next()){
                Object[] rowdata = new Object[count];
                for(int j = 1;j<= count ; j++){
                    rowdata[j-1]= rs.getObject(j);
                }
                tab.addRow(rowdata);
            }
        table = new JTable(tab);
        JScrollPane scroll = new JScrollPane(table);
        this.add(scroll);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
            
          
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }        
        setVisible(true);
        
        
        
        
    }
    public static void main(String[] args) {
        new Search_customer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()== button){
          new Home();
          
      }
    }
    
}

