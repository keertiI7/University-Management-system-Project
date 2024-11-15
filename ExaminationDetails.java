package university.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class ExaminationDetails extends JFrame implements ActionListener {
   JTextField search;
   JButton submit, cancel;
   JTable table;

   ExaminationDetails() {
      setSize(1000, 475);
      setLocation(300, 100);
      setLayout(null);
      getContentPane().setBackground(Color.WHITE);

      JLabel heading = new JLabel("Check Result");
      heading.setBounds(80, 15, 400, 50);
      heading.setFont(new Font("Tahoma", Font.BOLD, 24));
      add(heading);

      search = new JTextField();
      search.setBounds(80, 90, 200, 30);
      search.setFont(new Font("Tahoma", Font.PLAIN, 18));
      add(search);

      submit = new JButton("Result");
      submit.setBounds(300, 90, 120, 30);
      submit.setBackground(Color.BLACK);
      submit.setForeground(Color.WHITE);
      submit.addActionListener(this);
      submit.setFont(new Font("Tahoma", Font.BOLD, 15));
      add(submit);

      cancel = new JButton("Back");
      cancel.setBounds(440, 90, 120, 30);
      cancel.setBackground(Color.BLACK);
      cancel.setForeground(Color.WHITE);
      cancel.addActionListener(this);
      cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
      add(cancel);

      table = new JTable();
      table.setFont(new Font("Tahoma", Font.PLAIN, 16));
      JScrollPane jsp = new JScrollPane(table);
      jsp.setBounds(0, 130, 1000, 310);
      add(jsp);

      // Load data from the database to display in the table
      try {
         Conn c = new Conn();
         ResultSet rs = c.s.executeQuery("select * from student");
         table.setModel(DbUtils.resultSetToTableModel(rs));
      } catch (Exception e) {
         e.printStackTrace();
      }

      setVisible(true);
   }

   public void actionPerformed(ActionEvent ae) {
      if (ae.getSource() == submit) {
         setVisible(false);
         new Marks(search.getText());  // Assumes `Marks` class takes a student ID or search term
      } else if (ae.getSource() == cancel) {
         setVisible(false);
      }
   }

   public static void main(String[] args) {
      new ExaminationDetails();
   }
}
