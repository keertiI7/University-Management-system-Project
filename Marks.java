// Source code is decompiled from a .class file using FernFlower decompiler.
package university.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Marks extends JFrame implements ActionListener {
   String rollno;
   JButton cancel;

   Marks(String rollno) {
      this.rollno = rollno;
      this.setSize(500, 600);
      this.setLocation(500, 100);
      this.setLayout((LayoutManager)null);
      this.getContentPane().setBackground(Color.WHITE);
      JLabel heading = new JLabel("BVRIT HYDERABAD COLLEGE OF ENGINEERING FOR WOMEN");
      heading.setBounds(100, 10, 500, 25);
      heading.setFont(new Font("Tahoma", 1, 20));
      this.add(heading);
      JLabel subheading = new JLabel("Result of Examination 2024");
      subheading.setBounds(100, 50, 500, 20);
      subheading.setFont(new Font("Tahoma", 1, 18));
      this.add(subheading);
      JLabel lblrollno = new JLabel("Roll Number " + rollno);
      lblrollno.setBounds(60, 100, 500, 20);
      lblrollno.setFont(new Font("Tahoma", 0, 18));
      this.add(lblrollno);
      JLabel lblsemester = new JLabel();
      lblsemester.setBounds(60, 130, 500, 20);
      lblsemester.setFont(new Font("Tahoma", 0, 18));
      this.add(lblsemester);
      JLabel sub1 = new JLabel();
      sub1.setBounds(100, 200, 500, 20);
      sub1.setFont(new Font("Tahoma", 0, 18));
      this.add(sub1);
      JLabel sub2 = new JLabel();
      sub2.setBounds(100, 230, 500, 20);
      sub2.setFont(new Font("Tahoma", 0, 18));
      this.add(sub2);
      JLabel sub3 = new JLabel();
      sub3.setBounds(100, 260, 500, 20);
      sub3.setFont(new Font("Tahoma", 0, 18));
      this.add(sub3);
      JLabel sub4 = new JLabel();
      sub4.setBounds(100, 290, 500, 20);
      sub4.setFont(new Font("Tahoma", 0, 18));
      this.add(sub4);
      JLabel sub5 = new JLabel();
      sub5.setBounds(100, 320, 500, 20);
      sub5.setFont(new Font("Tahoma", 0, 18));
      this.add(sub5);

      try {
         Conn c = new Conn();
         ResultSet rs1 = c.s.executeQuery("select * from subject where rollno = '" + rollno + "'");

         while(rs1.next()) {
            sub1.setText(rs1.getString("subject1"));
            sub2.setText(rs1.getString("subject2"));
            sub3.setText(rs1.getString("subject3"));
            sub4.setText(rs1.getString("subject4"));
            sub5.setText(rs1.getString("subject5"));
         }

         ResultSet rs2 = c.s.executeQuery("select * from marks where rollno = '" + rollno + "'");

         while(rs2.next()) {
            String var10001 = sub1.getText();
            sub1.setText(var10001 + "------------" + rs2.getString("marks1"));
            var10001 = sub2.getText();
            sub2.setText(var10001 + "------------" + rs2.getString("marks2"));
            var10001 = sub3.getText();
            sub3.setText(var10001 + "------------" + rs2.getString("marks3"));
            var10001 = sub4.getText();
            sub4.setText(var10001 + "------------" + rs2.getString("marks4"));
            var10001 = sub5.getText();
            sub5.setText(var10001 + "------------" + rs2.getString("marks5"));
            lblsemester.setText("Semester " + rs2.getString("semester"));
         }
      } catch (Exception var14) {
         var14.printStackTrace();
      }

      this.cancel = new JButton("Back");
      this.cancel.setBounds(250, 500, 120, 25);
      this.cancel.setBackground(Color.BLACK);
      this.cancel.setForeground(Color.WHITE);
      this.cancel.addActionListener(this);
      this.cancel.setFont(new Font("Tahoma", 1, 15));
      this.add(this.cancel);
      this.setVisible(true);
   }

   public void actionPerformed(ActionEvent ae) {
      this.setVisible(false);
   }

   public static void main(String[] args) {
      new Marks("");
   }
}
