// Source code is decompiled from a .class file using FernFlower decompiler.
package university.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class TeacherLeaveDetails extends JFrame implements ActionListener {
   Choice cEmpId;
   JTable table;
   JButton search;
   JButton print;
   JButton update;
   JButton add;
   JButton cancel;

   TeacherLeaveDetails() {
      this.getContentPane().setBackground(Color.WHITE);
      this.setLayout((LayoutManager)null);
      JLabel heading = new JLabel("Search by Employee Id");
      heading.setBounds(20, 20, 150, 20);
      this.add(heading);
      this.cEmpId = new Choice();
      this.cEmpId.setBounds(180, 20, 150, 20);
      this.add(this.cEmpId);

      Conn c;
      ResultSet rs;
      try {
         c = new Conn();
         rs = c.s.executeQuery("select * from teacher");

         while(rs.next()) {
            this.cEmpId.add(rs.getString("empId"));
         }
      } catch (Exception var5) {
         var5.printStackTrace();
      }

      this.table = new JTable();

      try {
         c = new Conn();
         rs = c.s.executeQuery("select * from teacherleave");
         this.table.setModel(DbUtils.resultSetToTableModel(rs));
      } catch (Exception var4) {
         var4.printStackTrace();
      }

      JScrollPane jsp = new JScrollPane(this.table);
      jsp.setBounds(0, 100, 900, 600);
      this.add(jsp);
      this.search = new JButton("Search");
      this.search.setBounds(20, 70, 80, 20);
      this.search.addActionListener(this);
      this.add(this.search);
      this.print = new JButton("Print");
      this.print.setBounds(120, 70, 80, 20);
      this.print.addActionListener(this);
      this.add(this.print);
      this.add = new JButton("Add");
      this.add.setBounds(220, 70, 80, 20);
      this.add.addActionListener(this);
      this.add(this.add);
      this.update = new JButton("Update");
      this.update.setBounds(320, 70, 80, 20);
      this.update.addActionListener(this);
      this.add(this.update);
      this.cancel = new JButton("Cancel");
      this.cancel.setBounds(420, 70, 80, 20);
      this.cancel.addActionListener(this);
      this.add(this.cancel);
      this.setSize(900, 700);
      this.setLocation(300, 100);
      this.setVisible(true);
   }

   public void actionPerformed(ActionEvent ae) {
      if (ae.getSource() == this.search) {
         String query = "select * from teacherleave where rollno = '" + this.cEmpId.getSelectedItem() + "'";

         try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            this.table.setModel(DbUtils.resultSetToTableModel(rs));
         } catch (Exception var6) {
            var6.printStackTrace();
         }
      } else if (ae.getSource() == this.print) {
         try {
            this.table.print();
         } catch (Exception var5) {
            var5.printStackTrace();
         }
      } else if (ae.getSource() == this.add) {
         this.setVisible(false);
         new AddStudent();
      } else if (ae.getSource() == this.update) {
         this.setVisible(false);
         new UpdateStudent();
      } else {
         this.setVisible(false);
      }

   }

   public static void main(String[] args) {
      new StudentLeaveDetails();
   }

    private static class UpdateStudent {

        public UpdateStudent() {
        }
    }
}

