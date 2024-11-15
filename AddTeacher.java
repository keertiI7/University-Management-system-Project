
package university.management.system;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddTeacher extends JFrame implements ActionListener {
   JTextField tfname;
   JTextField tffname;
   JTextField tfaddress;
   JTextField tfphone;
   JTextField tfemail;
   JTextField tfx;
   JTextField tfxii;
   JTextField tfaadhar;
   JLabel labelempId;
   JDateChooser dcdob;
   JComboBox cbcourse;
   JComboBox cbbranch;
   JButton submit;
   JButton cancel;
   Random ran = new Random();
   long first4;

   AddTeacher() {
      this.first4 = Math.abs(this.ran.nextLong() % 9000L + 1000L);
      this.setSize(900, 700);
      this.setLocation(350, 50);
      this.setLayout((LayoutManager)null);
      JLabel heading = new JLabel("New Teacher Details");
      heading.setBounds(310, 30, 500, 50);
      heading.setFont(new Font("serif", 1, 30));
      this.add(heading);
      JLabel lblname = new JLabel("Name");
      lblname.setBounds(50, 150, 100, 30);
      lblname.setFont(new Font("serif", 1, 20));
      this.add(lblname);
      this.tfname = new JTextField();
      this.tfname.setBounds(200, 150, 150, 30);
      this.add(this.tfname);
      JLabel lblfname = new JLabel("Father's Name");
      lblfname.setBounds(400, 150, 200, 30);
      lblfname.setFont(new Font("serif", 1, 20));
      this.add(lblfname);
      this.tffname = new JTextField();
      this.tffname.setBounds(600, 150, 150, 30);
      this.add(this.tffname);
      JLabel lblempId = new JLabel("Employee Id");
      lblempId.setBounds(50, 200, 200, 30);
      lblempId.setFont(new Font("serif", 1, 20));
      this.add(lblempId);
      this.labelempId= new JLabel("101" + this.first4);
      this.labelempId.setBounds(200, 200, 200, 30);
      this.labelempId.setFont(new Font("serif", 1, 20));
      this.add(this.labelempId);
      JLabel lbldob = new JLabel("Date of Birth");
      lbldob.setBounds(400, 200, 200, 30);
      lbldob.setFont(new Font("serif", 1, 20));
      this.add(lbldob);
      this.dcdob = new JDateChooser();
      this.dcdob.setBounds(600, 200, 150, 30);
      this.add(this.dcdob);
      JLabel lbladdress = new JLabel("Address");
      lbladdress.setBounds(50, 250, 200, 30);
      lbladdress.setFont(new Font("serif", 1, 20));
      this.add(lbladdress);
      this.tfaddress = new JTextField();
      this.tfaddress.setBounds(200, 250, 150, 30);
      this.add(this.tfaddress);
      JLabel lblphone = new JLabel("Phone");
      lblphone.setBounds(400, 250, 200, 30);
      lblphone.setFont(new Font("serif", 1, 20));
      this.add(lblphone);
      this.tfphone = new JTextField();
      this.tfphone.setBounds(600, 250, 150, 30);
      this.add(this.tfphone);
      JLabel lblemail = new JLabel("Email Id");
      lblemail.setBounds(50, 300, 200, 30);
      lblemail.setFont(new Font("serif", 1, 20));
      this.add(lblemail);
      this.tfemail = new JTextField();
      this.tfemail.setBounds(200, 300, 150, 30);
      this.add(this.tfemail);
      JLabel lblx = new JLabel("Class X (%)");
      lblx.setBounds(400, 300, 200, 30);
      lblx.setFont(new Font("serif", 1, 20));
      this.add(lblx);
      this.tfx = new JTextField();
      this.tfx.setBounds(600, 300, 150, 30);
      this.add(this.tfx);
      JLabel lblxii = new JLabel("Class XII (%)");
      lblxii.setBounds(50, 350, 200, 30);
      lblxii.setFont(new Font("serif", 1, 20));
      this.add(lblxii);
      this.tfxii = new JTextField();
      this.tfxii.setBounds(200, 350, 150, 30);
      this.add(this.tfxii);
      JLabel lblaadhar = new JLabel("Aadhar Number");
      lblaadhar.setBounds(400, 350, 200, 30);
      lblaadhar.setFont(new Font("serif", 1, 20));
      this.add(lblaadhar);
      this.tfaadhar = new JTextField();
      this.tfaadhar.setBounds(600, 350, 150, 30);
      this.add(this.tfaadhar);
      JLabel lblcourse = new JLabel("Qualification");
      lblcourse.setBounds(50, 400, 200, 30);
      lblcourse.setFont(new Font("serif", 1, 20));
      this.add(lblcourse);
      String[] course = new String[]{"B.Tech", "BBA", "BCA", "Bsc", "Msc", "MBA", "MCA", "MCom", "MA", "BA"};
      this.cbcourse = new JComboBox(course);
      this.cbcourse.setBounds(200, 400, 150, 30);
      this.cbcourse.setBackground(Color.WHITE);
      this.add(this.cbcourse);
      JLabel lblbranch = new JLabel("Department");
      lblbranch.setBounds(400, 400, 200, 30);
      lblbranch.setFont(new Font("serif", 1, 20));
      this.add(lblbranch);
      String[] branch = new String[]{"Computer Science", "Electronics", "Mechanical", "Civil", "IT"};
      this.cbbranch = new JComboBox(branch);
      this.cbbranch.setBounds(600, 400, 150, 30);
      this.cbbranch.setBackground(Color.WHITE);
      this.add(this.cbbranch);
      this.submit = new JButton("Submit");
      this.submit.setBounds(250, 550, 120, 30);
      this.submit.setBackground(Color.BLACK);
      this.submit.setForeground(Color.WHITE);
      this.submit.addActionListener(this);
      this.submit.setFont(new Font("Tahoma", 1, 15));
      this.add(this.submit);
      this.cancel = new JButton("Cancel");
      this.cancel.setBounds(450, 550, 120, 30);
      this.cancel.setBackground(Color.BLACK);
      this.cancel.setForeground(Color.WHITE);
      this.cancel.addActionListener(this);
      this.cancel.setFont(new Font("Tahoma", 1, 15));
      this.add(this.cancel);
      this.setVisible(true);
   }

   public void actionPerformed(ActionEvent ae) {
      if (ae.getSource() == this.submit) {
         String name = this.tfname.getText();
         String fname = this.tffname.getText();
         String rollno = this.labelempId.getText();
         String dob = ((JTextField)this.dcdob.getDateEditor().getUiComponent()).getText();
         String address = this.tfaddress.getText();
         String phone = this.tfphone.getText();
         String email = this.tfemail.getText();
         String x = this.tfx.getText();
         String xii = this.tfxii.getText();
         String aadhar = this.tfaadhar.getText();
         String course = (String)this.cbcourse.getSelectedItem();
         String branch = (String)this.cbbranch.getSelectedItem();

         try {
            String query = "insert into teacher values('" + name + "', '" + fname + "', '" + rollno + "', '" + dob + "', '" + address + "', '" + phone + "', '" + email + "', '" + x + "', '" + xii + "', '" + aadhar + "', '" + course + "', '" + branch + "')";
            Conn con = new Conn();
            con.s.executeUpdate(query);
            JOptionPane.showMessageDialog((Component)null, "Teacher Details Inserted Successfully");
            this.setVisible(false);
         } catch (Exception var16) {
            var16.printStackTrace();
         }
      } else {
         this.setVisible(false);
      }

   }

   public static void main(String[] args) {
      new AddTeacher();
   }
}

