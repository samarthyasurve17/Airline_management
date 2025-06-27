package airlinemanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JOptionPane;



public class AddcustomerDetail extends JFrame implements ActionListener {

    JTextField tfname, tfnationality, tfaddress, tfaadharnumber, tfphone;
    JButton save;
    JRadioButton rbmale, rbfemale;

    public AddcustomerDetail() {
        getContentPane().setBackground(Color.white);

        setLayout(null);

        JLabel lblheading = new JLabel("Add Customer Details");

        lblheading.setBounds(300, 20, 500, 35);
        lblheading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        add(lblheading);

        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 80, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(220, 80, 150, 25);
        add(tfname);

        JLabel lblnationality = new JLabel("NATIONALITY");
        lblnationality.setBounds(60, 120, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);

        tfnationality = new JTextField();
        tfnationality.setBounds(220, 120, 150, 25);
        add(tfnationality);

        JLabel lblaadharnumber = new JLabel("AADHAR NUMBER");
        lblaadharnumber.setBounds(60, 160, 150, 25);
        lblaadharnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblaadharnumber);

        tfaadharnumber = new JTextField();
        tfaadharnumber.setBounds(220, 160, 150, 25);
        add(tfaadharnumber);

        JLabel lbladdress = new JLabel("ADDRESS");
        lbladdress.setBounds(60, 200, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(220, 200, 150, 25);
        add(tfaddress);

        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(60, 240, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);

        ButtonGroup group = new ButtonGroup();

        rbmale = new JRadioButton("MALE");
        rbmale.setBounds(220, 240, 75, 25);
        rbmale.setBackground(Color.white);
        add(rbmale);
        rbfemale = new JRadioButton("FEMALE");
        rbfemale.setBounds(290, 240, 75, 25);
        rbfemale.setBackground(Color.white);

        add(rbfemale);

        group.add(rbmale);
        group.add(rbfemale);

        JLabel lblphoneno = new JLabel("PHONE NO.");
        lblphoneno.setBounds(60, 280, 150, 25);
        lblphoneno.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblphoneno);

        tfphone = new JTextField();
        tfphone.setBounds(220, 280, 150, 25);
        add(tfphone);

        save = new JButton("SAVE");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(220, 320, 150, 35);
        save.addActionListener(this);
        add(save);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/emp.png"));
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(450, 80, 280, 400);
        add(lblimage);

        setSize(900, 600);
        setLocation(300, 150);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        String name = tfname.getText();
        String aadharnumber = tfaadharnumber.getText();
        String phone = tfphone.getText();
        String address = tfaddress.getText();
        String nationality = tfnationality.getText();
        String gender = null;
        if (rbmale.isSelected()) {
            gender = "male";

        } else {
            gender = "female";

        }
        try {
            Conn conn = new Conn();
            String query = "insert into passenger values('" + name + "','" + aadharnumber + "','" + phone + "','" + address + "','" + nationality + "','" + gender + "')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "customer details added successfully");
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    ;
    public static void main(String[] args) {
        new AddcustomerDetail();
    }

}
