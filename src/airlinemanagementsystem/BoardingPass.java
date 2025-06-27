package airlinemanagementsystem;

import com.toedter.calendar.JDateChooser;
import java.awt.Choice;
import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;
import javax.swing.JOptionPane;

public class BoardingPass extends JFrame implements ActionListener {

    JTextField tfpnr;
    JButton enter;
    JLabel tfname, tfnatinonality, tfcode, tfflightname, tfsrc, tfdest, dcdate;

    public BoardingPass() {
        getContentPane().setBackground(Color.white);

        setLayout(null);
        JLabel lblheading = new JLabel("Sam's Airline");
        lblheading.setForeground(Color.orange);
        lblheading.setBounds(420, 20, 500, 35);
        lblheading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        add(lblheading);

        JLabel lblsubheading = new JLabel("BOARDING PASS");
        lblsubheading.setBounds(60, 50, 400, 25);
        lblsubheading.setFont(new Font("Tahoma", Font.PLAIN, 30));
        add(lblsubheading);

        JLabel lblpnr = new JLabel("PNR NO.");
        lblpnr.setBounds(60, 90, 150, 25);
        lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpnr);

        tfpnr = new JTextField();
        tfpnr.setBounds(220, 90, 150, 25);
        add(tfpnr);

        enter = new JButton("ENTER");
        enter.setBackground(Color.black);
        enter.setForeground(Color.white);
        enter.setBounds(390, 90, 140, 25);
        enter.addActionListener(this);
        add(enter);

        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 130, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);

        tfname = new JLabel();
        tfname.setBounds(220, 130, 150, 25);
        add(tfname);

        JLabel lblnationality = new JLabel("NATIONALITY");
        //////////////////////////
        lblnationality.setBounds(60, 180, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);

        tfnatinonality = new JLabel();
        tfnatinonality.setBounds(220, 180, 150, 25);
        add(tfnatinonality);

        JLabel lblsrc = new JLabel("SOURCE:");
        /////////////////////////////////
        lblsrc.setBounds(60, 230, 150, 25);
        lblsrc.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblsrc);

        tfsrc = new JLabel();
        tfsrc.setBounds(220, 230, 150, 25);
        add(tfsrc);

        JLabel lbldest = new JLabel("DESTINATION:");
        lbldest.setBounds(400, 230, 150, 25);
        lbldest.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldest);

        tfdest = new JLabel();
        tfdest.setBounds(560, 230, 150, 25);
        add(tfdest);



        JLabel lblfname = new JLabel("FLIGHT NAME");
        lblfname.setBounds(60, 280, 150, 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfname);

        tfflightname = new JLabel();
        tfflightname.setBounds(220, 280, 150, 25);
        add(tfflightname);

        JLabel lblfcode = new JLabel("FLIGHT CODE");
        lblfcode.setBounds(400, 280, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);

        tfcode = new JLabel();
        tfcode.setBounds(560, 280, 150, 25);
        add(tfcode);

        JLabel lbldate = new JLabel("FLIGHT DATE");
        lbldate.setBounds(60, 330, 150, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);

        dcdate = new JLabel();
        dcdate.setBounds(220, 330, 150, 25);
        add(dcdate);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/samairline3.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(600, 10, 500, 410);
        add(lblimage);

        setSize(1100, 410);
        setLocation(200, 100);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == enter) {
            String pnr = tfpnr.getText();

            if (pnr.isEmpty()) {

                JOptionPane.showMessageDialog(null, "please check the field again");

            }

            try {
                Conn c = new Conn();
                String query = "select * from reservation where PNR = '" + pnr + "'";
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    tfname.setText(rs.getString("NAME"));
                    tfcode.setText(rs.getString("FLIGHT_CODE"));
                    tfflightname.setText(rs.getString("FLIGHT_NAME"));
                    dcdate.setText(rs.getString("FLIGHT_DATE"));
                    tfsrc.setText(rs.getString("SOURCE"));
                    tfdest.setText(rs.getString("DESTINATION"));

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new BoardingPass();
    }

}
