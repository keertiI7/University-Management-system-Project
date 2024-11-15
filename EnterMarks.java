// Source code is decompiled from a .class file using FernFlower decompiler.
package university.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EnterMarks extends JFrame implements ActionListener {
   Choice crollno;
   JComboBox cbsemester;
   JTextField tfsub1;
   JTextField tfsub2;
   JTextField tfsub3;
   JTextField tfsub4;
   JTextField tfsub5;
   JTextField tfmarks1;
   JTextField tfmarks2;
   JTextField tfmarks3;
   JTextField tfmarks4;
   JTextField tfmarks5;
   JButton cancel;
   JButton submit;

   EnterMarks() {
      this.setSize(1000, 500);
      this.setLocation(300, 150);
      this.setLayout((LayoutManager)null);
      this.getContentPane().setBackground(Color.WHITE);
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
      Image i2 = i1.getImage().getScaledInstance(400, 300, 1);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel image = new JLabel(i3);
      image.setBounds(500, 40, 400, 300);
      this.add(image);
      JLabel heading = new JLabel("Enter Marks of Student");
      heading.setBounds(50, 0, 500, 50);
      heading.setFont(new Font("Tahoma", 1, 20));
      this.add(heading);
      JLabel lblrollnumber = new JLabel("Select Roll Number");
      lblrollnumber.setBounds(50, 70, 150, 20);
      this.add(lblrollnumber);
      this.crollno = new Choice();
      this.crollno.setBounds(200, 70, 150, 20);
      this.add(this.crollno);

      try {
         Conn c = new Conn();
         ResultSet rs = c.s.executeQuery("select * from student");

         while(rs.next()) {
            this.crollno.add(rs.getString("rollno"));
         }
      } catch (Exception var11) {
         var11.printStackTrace();
      }

      JLabel lblsemester = new JLabel("Select Semester");
      lblsemester.setBounds(50, 110, 150, 20);
      this.add(lblsemester);
      String[] semester = new String[]{"1st Semester", "2nd Semester", "3rd Semester", "4th Semester", "5th Semester", "6th Semester", "7th Semester", "8th Semester"};
      this.cbsemester = new JComboBox(semester);
      this.cbsemester.setBounds(200, 110, 150, 20);
      this.cbsemester.setBackground(Color.WHITE);
      this.add(this.cbsemester);
      JLabel lblentersubject = new JLabel("Enter Subject");
      lblentersubject.setBounds(100, 150, 200, 40);
      this.add(lblentersubject);
      JLabel lblentermarks = new JLabel("Enter Marks");
      lblentermarks.setBounds(320, 150, 200, 40);
      this.add(lblentermarks);
      this.tfsub1 = new JTextField();
      this.tfsub1.setBounds(50, 200, 200, 20);
      this.add(this.tfsub1);
      this.tfsub2 = new JTextField();
      this.tfsub2.setBounds(50, 230, 200, 20);
      this.add(this.tfsub2);
      this.tfsub3 = new JTextField();
      this.tfsub3.setBounds(50, 260, 200, 20);
      this.add(this.tfsub3);
      this.tfsub4 = new JTextField();
      this.tfsub4.setBounds(50, 290, 200, 20);
      this.add(this.tfsub4);
      this.tfsub5 = new JTextField();
      this.tfsub5.setBounds(50, 320, 200, 20);
      this.add(this.tfsub5);
      this.tfmarks1 = new JTextField();
      this.tfmarks1.setBounds(250, 200, 200, 20);
      this.add(this.tfmarks1);
      this.tfmarks2 = new JTextField();
      this.tfmarks2.setBounds(250, 230, 200, 20);
      this.add(this.tfmarks2);
      this.tfmarks3 = new JTextField();
      this.tfmarks3.setBounds(250, 260, 200, 20);
      this.add(this.tfmarks3);
      this.tfmarks4 = new JTextField();
      this.tfmarks4.setBounds(250, 290, 200, 20);
      this.add(this.tfmarks4);
      this.tfmarks5 = new JTextField();
      this.tfmarks5.setBounds(250, 320, 200, 20);
      this.add(this.tfmarks5);
      this.submit = new JButton("Submit");
      this.submit.setBounds(70, 360, 150, 25);
      this.submit.setBackground(Color.BLACK);
      this.submit.setForeground(Color.WHITE);
      this.submit.addActionListener(this);
      this.submit.setFont(new Font("Tahoma", 1, 15));
      this.add(this.submit);
      this.cancel = new JButton("Back");
      this.cancel.setBounds(280, 360, 150, 25);
      this.cancel.setBackground(Color.BLACK);
      this.cancel.setForeground(Color.WHITE);
      this.cancel.addActionListener(this);
      this.cancel.setFont(new Font("Tahoma", 1, 15));
      this.add(this.cancel);
      this.setVisible(true);
   }

   public void actionPerformed(ActionEvent ae) {
      if (ae.getSource() == this.submit) {
         try {
            Conn c = new Conn();
            String var10000 = this.crollno.getSelectedItem();
            String query1 = "insert into subject values('" + var10000 + "', '" + this.cbsemester.getSelectedItem() + "', '" + this.tfsub1.getText() + "', '" + this.tfsub2.getText() + "', '" + this.tfsub3.getText() + "', '" + this.tfsub4.getText() + "', '" + this.tfsub5.getText() + "')";
            var10000 = this.crollno.getSelectedItem();
            String query2 = "insert into marks values('" + var10000 + "', '" + this.cbsemester.getSelectedItem() + "', '" + this.tfmarks1.getText() + "', '" + this.tfmarks2.getText() + "', '" + this.tfmarks3.getText() + "', '" + this.tfmarks4.getText() + "', '" + this.tfmarks5.getText() + "')";
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            JOptionPane.showMessageDialog((Component)null, "Marks Inserted Sucessfully");
            this.setVisible(false);
         } catch (Exception var5) {
            var5.printStackTrace();
         }
      } else {
         this.setVisible(false);
      }

   }

   public static void main(String[] args) {
      new EnterMarks();
   }
}
