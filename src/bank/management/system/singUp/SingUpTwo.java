package bank.management.system.singUp;

import bank.management.system.service.Conn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SingUpTwo extends JFrame implements ActionListener {

    long random;
    JTextField panField, aadharField, incomeField;
    JButton next;
    JComboBox educationBox, relegionBox, categoryBox, seniorCitizonBox, existingAccoutnBox;
    String formno;

    public SingUpTwo(String formno) {
        this.formno = formno;
        setLayout(null); // this is for alignment of component
        setTitle("NEW ACCOUNT APPLICATION FORM PAGE 2");
        getContentPane().setBackground(Color.white);  // frame color


        // components of sing up page one

        Random rn = new Random();  // use to get random values
        random = Math.abs(rn.nextLong() % 9000l) + 1000L;

        // page no
        JLabel pageno = new JLabel("Page 2 : Additional Details");
        pageno.setFont(new Font("Raleway", Font.PLAIN, 20));
        pageno.setBounds(300, 40, 300, 40);
        add(pageno);


        // text field components


        // Religion
        JLabel relegion = new JLabel("Religion :");
        relegion.setFont(new Font("Raleway", Font.BOLD, 20));
        relegion.setBounds(80, 140, 100, 40);
        add(relegion);

        String[] relegionList = {"Hindu", "Muslim", "Christian", "Sikh", "Other"};
        relegionBox = new JComboBox(relegionList);
        relegionBox.setBounds(300, 140, 300, 30);
        add(relegionBox);


        // Category
        JLabel category = new JLabel("Category :");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(80, 190, 150, 40);
        add(category);

        String[] categoryList = {"GENERAL", "OBC", "SC/ST", "Other"};
        categoryBox = new JComboBox(categoryList);
        categoryBox.setBounds(300, 192, 300, 30);
        add(categoryBox);


        // Income
        JLabel income = new JLabel("Income :");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(80, 240, 150, 40);
        add(income);

        incomeField = new JTextField();
        incomeField.setBounds(300, 242, 150, 30);
        add(incomeField);


        // Education
        JLabel education = new JLabel("Education :");
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        education.setBounds(80, 290, 150, 40);
        add(education);

        String[] educationList = {"10 Passed", "12 Passed", "Graduate", "Post Graduate", "UnEducated"};
        educationBox = new JComboBox(educationList);
        educationBox.setBounds(300, 292, 150, 30);
        add(educationBox);


        // Pan Number
        JLabel pan = new JLabel("Pan Number :");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(80, 340, 150, 40);
        add(pan);

        panField = new JTextField();
        panField.setBounds(300, 342, 300, 30);
        add(panField);


        // Aadhar Number
        JLabel aadhar = new JLabel("Aadhaar Number :");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(80, 390, 170, 40);
        add(aadhar);

        aadharField = new JTextField();
        aadharField.setBounds(300, 392, 300, 30);
        add(aadharField);


        // Senior Citizen
        JLabel seniorCitiozon = new JLabel("Senior Citizen :");
        seniorCitiozon.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorCitiozon.setBounds(80, 440, 150, 40);
        add(seniorCitiozon);

        String[] senior = {"NO", "Yes"};
        seniorCitizonBox = new JComboBox(senior);
        seniorCitizonBox.setBounds(300, 442, 300, 30);
        add(seniorCitizonBox);


        // Existing account
        JLabel existingAccount = new JLabel("Existing Account :");
        existingAccount.setFont(new Font("Raleway", Font.BOLD, 20));
        existingAccount.setBounds(80, 490, 180, 40);
        add(existingAccount);

        String[] existing = {"No", "Yes"};
        existingAccoutnBox = new JComboBox(existing);
        existingAccoutnBox.setBounds(300, 492, 300, 30);
        add(existingAccoutnBox);


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

        String religion = (String) relegionBox.getSelectedItem();
        String category = (String) categoryBox.getSelectedItem();
        String income = incomeField.getText();
        String education = (String) educationBox.getSelectedItem();
        String pan = panField.getText();
        String aadhar = aadharField.getText();
        String seniorCitizen = (String) seniorCitizonBox.getSelectedItem();
        String existingAccount = (String) existingAccoutnBox.getSelectedItem();


        try {
                Conn c = new Conn();
                String query = "Insert into signuptwo values('" + formno + "' , '" + religion + "', '" + category + "' , '" + income + "', '" + education + "','" + pan + "','" + aadhar + "','" + seniorCitizen + "','" + existingAccount + "')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Data Saved Successfully");

                setVisible(false);
                new SignUpThree(formno).setVisible(true);
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public static void main(String[] args) {
        new SingUpTwo("");
    }


}
