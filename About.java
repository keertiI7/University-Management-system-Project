package university.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class About extends JFrame {
   About() {
      this.setSize(700, 500);
      this.setLocation(400, 150);
      this.getContentPane().setBackground(Color.WHITE);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Image setup
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/aboutus image.png"));
      Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel image = new JLabel(i3);
      image.setBounds(350, 0, 300, 200);
      this.add(image);

      // Title heading with HTML for multi-line text
      JLabel heading = new JLabel("<html>University<br/>Management System</html>");
      heading.setBounds(70, 20, 300, 130);
      heading.setFont(new Font("Tahoma", Font.BOLD, 30));
      heading.setHorizontalAlignment(SwingConstants.LEFT);
      this.add(heading);

      // Detailed text for names and college
      JLabel name = new JLabel("<html>Done by:<br/>P. Praneetha, Sania, K. Tejasree, G. Keerti</html>");
      name.setBounds(70, 180, 550, 60);
      name.setFont(new Font("Tahoma", Font.BOLD, 24));
      name.setHorizontalAlignment(SwingConstants.LEFT);
      this.add(name);

      // Roll numbers displayed
      JLabel rollno = new JLabel("<html>Roll Numbers:<br/>5F2, 5G0, 5I1, 5I7</html>");
      rollno.setBounds(70, 260, 550, 60);
      rollno.setFont(new Font("Tahoma", Font.PLAIN, 24));
      rollno.setHorizontalAlignment(SwingConstants.LEFT);
      this.add(rollno);

      // Contact information
      JLabel contact = new JLabel("Contact: bvrithyderabad@gmail.com");
      contact.setBounds(70, 340, 550, 40);
      contact.setFont(new Font("Tahoma", Font.PLAIN, 20));
      this.add(contact);

      // Set layout and make frame visible
      this.setLayout(null);
      this.setVisible(true);
   }

   public static void main(String[] args) {
      new About();
   }
}
