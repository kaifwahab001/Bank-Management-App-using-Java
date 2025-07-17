
package bank.management.system;

import bank.management.system.singUp.SingUpOne;
import bank.management.system.singUp.SingUpTwo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Login extends JFrame implements ActionListener {

    JButton login , signIn , clear;
    JTextField cardTextField ;
    JPasswordField pinTextField;

    Login(){

        setLayout(null);  // this is for border null user data in column or rows

        // frame title 
        setTitle("Automatic Teller Machine LOGIN");
        // fram size
        setSize(600,480);
       
        
        // add image 
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));  // not directly add to j-frame
        Image imageIcon = icon.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);  // convert the image into a size

        ImageIcon icon1  = new ImageIcon(imageIcon); // convert image into image icon for j label

        // image can be used as label in swing
        JLabel label = new JLabel(icon1);
        label.setBounds(70,10,100,100);
        add(label);

        // add label text
        JLabel text = new JLabel("Welcome to ATM");
        text.setBounds(200, 40, 400, 50);
        text.setFont(new Font("osward",Font.BOLD,28));
        add(text);
       
        getContentPane().setBackground(Color.white);


        // now adding main components

        // card number label
        JLabel cardNumber = new JLabel("Card no : ");
        cardNumber.setBounds(110, 120, 150, 30);
        cardNumber.setFont(new Font("osward",Font.BOLD,28));
        add(cardNumber);

        //      text field
        cardTextField = new JTextField();
        cardTextField.setBounds(270, 120, 200, 30);
        cardTextField.setFont(new Font("Arial",Font.BOLD, 14));
        add(cardTextField);



        // pin number
        JLabel pin = new JLabel("Pin : ");
        pin.setBounds(110, 170, 150, 30);
        pin.setFont(new Font("osward",Font.BOLD,28));
        add(pin);


        //   text field
        pinTextField = new JPasswordField();
        pinTextField.setBounds(270, 170, 200, 30);
        pinTextField.setFont(new Font("Arial",Font.BOLD, 14));
        add(pinTextField);


        // sing in button
        signIn = new JButton("Sign In");
        signIn.setBackground(Color.black);
        signIn.setForeground(Color.white);
        signIn.setBounds(270,220,90, 30);
        signIn.addActionListener(this);
        add(signIn);


        // clear button
        clear = new JButton("Clear");
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.setBounds(380,220,90, 30);
        clear.addActionListener(this);
        add(clear);


        // login button
        login = new JButton("Log In");
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.setBounds(270, 270, 200, 30);
        login.addActionListener(this);
        add(login);

        
        
        //location where frame start showing in window
        setLocation(350, 200);
        setVisible(true);
        
        
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== clear){
            System.out.println("clear");
            cardTextField.setText("");
            pinTextField.setText("");
        }else if(e.getSource() == signIn){
//            System.out.println("sing in");


            // for navigation
            setVisible(false);
            new SingUpOne().setVisible(true);


        }else if(e.getSource() == login){
            System.out.println("login");
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }


}
