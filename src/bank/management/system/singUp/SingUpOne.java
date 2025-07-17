package bank.management.system.singUp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import bank.management.system.service.Conn;
import com.toedter.calendar.JDateChooser;

public class SingUpOne extends JFrame implements ActionListener {

    long random;
    JTextField nameField, fnameField, emailField, addressField, cityField;
    JButton next;
    JDateChooser dateChooser;
    JRadioButton male, female, married, unmarried, other;

    public SingUpOne() {
        setLayout(null); // this is for alignment of component
        setTitle("NEW ACCOUNT APPLICATION FORM PAGE 1");
        getContentPane().setBackground(Color.white);  // frame color


        // components of sing up page one

        Random rn = new Random();  // use to get random values
        random = Math.abs(rn.nextLong() % 9000l) + 1000L;

        // application number
        JLabel formno = new JLabel("APPLICATION FORM NO : " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(100, 20, 600, 40);
        add(formno);

        // page no
        JLabel pageno = new JLabel("Page 1 : Personal Details");
        pageno.setFont(new Font("Raleway", Font.PLAIN, 20));
        pageno.setBounds(300, 80, 300, 40);
        add(pageno);


        // text field components
        // name
        JLabel name = new JLabel("Name :");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(80, 140, 100, 40);
        add(name);

        nameField = new JTextField();
        nameField.setBounds(300, 142, 300, 30);
        add(nameField);


        // father name
        JLabel fname = new JLabel("Father Name :");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(80, 190, 150, 40);
        add(fname);

        fnameField = new JTextField();
        fnameField.setBounds(300, 192, 300, 30);
        add(fnameField);

        // dob
        JLabel dob = new JLabel("Date of Birth :");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(80, 240, 150, 40);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 242, 150, 30);
        add(dateChooser);


        // gender
        JLabel gender = new JLabel("Gender :");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(80, 290, 100, 40);
        add(gender);

        male = new JRadioButton("Male");
        male.setBackground(Color.white);
        male.setBounds(300, 292, 100, 30);
        add(male);

        female = new JRadioButton("Female");
        female.setBackground(Color.white);
        female.setBounds(400, 292, 100, 30);
        add(female);

        // both male and female connect to each other
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);


        // mail
        JLabel mail = new JLabel("Email Address :");
        mail.setFont(new Font("Raleway", Font.BOLD, 20));
        mail.setBounds(80, 340, 150, 40);
        add(mail);

        emailField = new JTextField();
        emailField.setBounds(300, 342, 300, 30);
        add(emailField);

        // marital status
        JLabel marital = new JLabel("Marital Status :");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(80, 390, 150, 40);
        add(marital);

        // marital button radio
        married = new JRadioButton("Married");
        married.setBackground(Color.white);
        married.setBounds(300, 392, 100, 30);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBackground(Color.white);
        unmarried.setBounds(400, 392, 100, 30);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBackground(Color.white);
        other.setBounds(500, 392, 100, 30);
        add(other);


        // both marries and unmarried connect to each other
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);


        // address
        JLabel address = new JLabel("Address :");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(80, 440, 150, 40);
        add(address);

        addressField = new JTextField();
        addressField.setBounds(300, 442, 300, 30);
        add(addressField);

        // city
        JLabel city = new JLabel("City :");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(80, 490, 150, 40);
        add(city);

        cityField = new JTextField();
        cityField.setBounds(300, 492, 300, 30);
        add(cityField);


        // next button

        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(500, 570, 100, 40);
        next.addActionListener(this);
        add(next);


        setSize(800, 800);
        setLocation(450, 30);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = "" + random;
        String name = nameField.getText();
        String fname = fnameField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = "";
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }
        String email = emailField.getText();
        String marital = "";
        if (married.isSelected()) {
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (other.isSelected()) {
            marital = "Other";
        }

        String address = addressField.getText();
        String city = cityField.getText();


        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            } else {
                Conn c = new Conn();
                String query = "Insert into signup values('" + formno + "' , '" + name + "', '" + fname + "' , '" + dob + "', '" + email + "','" + gender + "','" + marital + "','" + address + "','" + city + "')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Data Saved Successfully");

                setVisible(false);
                new SingUpTwo(formno).setVisible(true);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public static void main(String[] args) {
        new SingUpOne();
    }


}
