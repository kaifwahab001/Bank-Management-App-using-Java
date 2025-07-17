package bank.management.system.singUp;

import bank.management.system.service.Conn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.SimpleTimeZone;

public class SignUpThree extends JFrame implements ActionListener {

    long random;
    JTextField panField, aadharField, incomeField;
    JButton submit, cancel;
    JRadioButton savingAccount, fixedAccount, currentAccount, recurringAccount;
    JComboBox educationBox, relegionBox, categoryBox, seniorCitizonBox, existingAccoutnBox;
    JCheckBox c1, c2, c3, c4, c5, c6, agreement;

    String formno;


    public SignUpThree(String formno) {
        this.formno = formno;
        setLayout(null); // this is for alignment of component
        setTitle("NEW ACCOUNT APPLICATION FORM PAGE 3");
        getContentPane().setBackground(Color.white);  // frame color


        // components of sing up page one

        Random rn = new Random();  // use to get random values
        random = Math.abs(rn.nextLong() % 9000l) + 1000L;


        // page no
        JLabel pageno = new JLabel("Page 3 : Account Details");
        pageno.setFont(new Font("Raleway", Font.PLAIN, 20));
        pageno.setBounds(300, 40, 300, 40);
        add(pageno);


        // text field components


        // Religion
        JLabel accountType = new JLabel("Account Type");
        accountType.setFont(new Font("Raleway", Font.BOLD, 18));
        accountType.setBounds(80, 100, 150, 40);
        add(accountType);


        savingAccount = new JRadioButton("Saving Account");
        savingAccount.setBounds(80, 140, 150, 30);
        savingAccount.setBackground(Color.white);
        add(savingAccount);

        fixedAccount = new JRadioButton("Fixed Deposit Account");
        fixedAccount.setBounds(300, 140, 170, 30);
        fixedAccount.setBackground(Color.white);
        add(fixedAccount);

        currentAccount = new JRadioButton("Current Account");
        currentAccount.setBackground(Color.white);
        currentAccount.setBounds(80, 180, 170, 30);
        add(currentAccount);

        recurringAccount = new JRadioButton("Recurring Deposit Account");
        recurringAccount.setBackground(Color.white);
        recurringAccount.setBounds(300, 180, 180, 30);
        add(recurringAccount);

        ///  account button group

        ButtonGroup accountgroup = new ButtonGroup();
        accountgroup.add(savingAccount);
        accountgroup.add(fixedAccount);
        accountgroup.add(currentAccount);
        accountgroup.add(recurringAccount);


        // card number
        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD, 18));
        card.setBounds(80, 250, 150, 40);
        add(card);

        JLabel cardlabel = new JLabel("Your 16 Digit Card Number");
        cardlabel.setFont(new Font("Raleway", Font.PLAIN, 11));
        cardlabel.setBounds(80, 275, 220, 40);
        add(cardlabel);


        JLabel carNumber = new JLabel("XXXX-XXXX-XXXX-4184");
        carNumber.setFont(new Font("Raleway", Font.BOLD, 18));
        carNumber.setBounds(300, 250, 220, 40);
        add(carNumber);


        // pin
        JLabel Pin = new JLabel("PIN ");
        Pin.setFont(new Font("Raleway", Font.BOLD, 18));
        Pin.setBounds(80, 320, 150, 40);
        add(Pin);

        JLabel pinlabel = new JLabel("Your 4 Digit Password");
        pinlabel.setFont(new Font("Raleway", Font.PLAIN, 11));
        pinlabel.setBounds(80, 340, 220, 40);
        add(pinlabel);

        JLabel pinexample = new JLabel("XXXX");
        pinexample.setFont(new Font("Raleway", Font.BOLD, 18));
        pinexample.setBounds(300, 320, 100, 40);
        add(pinexample);


        // service required
        JLabel service = new JLabel("Service Required");
        service.setFont(new Font("Raleway", Font.BOLD, 18));
        service.setBounds(80, 400, 170, 40);
        add(service);


        c1 = new JCheckBox("ATM Card");
        c1.setBounds(80, 440, 170, 40);
        c1.setBackground(Color.white);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBounds(300, 440, 170, 40);
        c2.setBackground(Color.white);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBounds(80, 480, 170, 40);
        c3.setBackground(Color.white);
        add(c3);

        c4 = new JCheckBox("Email & Sms Alerts");
        c4.setBounds(300, 480, 170, 40);
        c4.setBackground(Color.white);
        add(c4);

        c5 = new JCheckBox("Cheque book");
        c5.setBounds(80, 520, 170, 40);
        c5.setBackground(Color.white);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBounds(300, 520, 170, 40);
        c6.setBackground(Color.white);
        add(c6);


        // agreement
        agreement = new JCheckBox("I hereby declare that the above details are correct to the best  of my knowledge");
        agreement.setBackground(Color.white);
        agreement.setBounds(80, 580, 500, 40);
        add(agreement);


        // next button
        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setBounds(580, 660, 100, 40);
        submit.addActionListener(this);
        add(submit);


        cancel = new JButton("Cancel");
        cancel.setBackground(Color.gray);
        cancel.setForeground(Color.white);
        cancel.setBounds(460, 660, 100, 40);
        cancel.addActionListener(this);
        add(cancel);


        setSize(800, 800);
        setLocation(450, 30);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == cancel) {
            int result = JOptionPane.showConfirmDialog(
                    this,
                    "Do you want to cancel the form?",
                    "Cancel Confirmation",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

            if (result == JOptionPane.YES_OPTION) {
                dispose(); // Close the current form window
            }
        } else {
            String accoutType = "";

            if (savingAccount.isSelected()) {
                accoutType = "Saving Accout";
            } else if (fixedAccount.isSelected()) {
                accoutType = "Fixed Deposit Account";
            } else if (currentAccount.isSelected()) {
                accoutType = "Current Account";
            } else if (recurringAccount.isSelected()) {
                accoutType = "Recurring Deposit Account";
            }

            // card and pin
            Random radom = new Random();
            String cardNumber = "";

            for (int i = 0; i < 16; i++) {
                int digit = radom.nextInt(10); // gives a digit from 0–9
                cardNumber += digit;
                // Add dash after every 4 digits except the last group
                if ((i + 1) % 4 == 0 && i != 15) {
                    cardNumber += "-";
                }
            }
            String pin = "";
            for (int i = 0; i < 4; i++) {
                int digit = radom.nextInt(10);
                pin += digit;
            }

            // facility
            String facility = "";
            if (c1.isSelected()) facility += " ATM Card, ";
            if (c2.isSelected()) facility += " Internet Banking, ";
            if (c3.isSelected()) facility += " Mobile Banking, ";
            if (c4.isSelected()) facility += " Email & SMS Alerts, ";
            if (c5.isSelected()) facility += " Cheque Book, ";
            if (c6.isSelected()) facility += " E-Statement, ";


            try {
                if (accoutType.equals("")) {
                    if (!agreement.isSelected()) {
                        JOptionPane.showMessageDialog(null, "Please Fill the above details");
                        return;
                    }
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                } else {
                    if (!agreement.isSelected()) {
                        JOptionPane.showMessageDialog(null, "Please Check the agreed button");
                    }else{
                        Conn c = new Conn();
                        String query = "Insert into signupthree values('" + formno + "' , '" + accoutType + "', '" + cardNumber + "' , '" + pin + "', '" + facility + "')";
                        c.s.executeUpdate(query);

                        JOptionPane.showMessageDialog(
                                null,
                                "Account Created Successfully!\nYour Card Number: '" + cardNumber + "'\nYour PIN: '" + pin + "'",
                                "Confirmation",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    }


                }


            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

    }

    public static void main(String[] args) {
        new SignUpThree("");
    }


}
