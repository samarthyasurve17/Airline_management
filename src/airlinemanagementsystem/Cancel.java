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

public class Cancel extends JFrame implements ActionListener {

    JTextField tfpnr;
    JButton fetch, cancelTicket;
    JLabel tfname, cancel, tfcode, tfflightname, dcdate;



    public Cancel() {
        getContentPane().setBackground(Color.white);

        setLayout(null);
        Random random = new Random();
        JLabel lblheading = new JLabel("CANCEL TICKETS");

        lblheading.setBounds(420, 20, 500, 35);
        lblheading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        add(lblheading);

        JLabel lblpnr = new JLabel("PNR NO.");
        lblpnr.setBounds(60, 80, 150, 25);
        lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpnr);

        tfpnr = new JTextField();
        tfpnr.setBounds(220, 80, 150, 25);
        add(tfpnr);

        fetch = new JButton("FETCH");
        fetch.setBackground(Color.black);
        fetch.setForeground(Color.white);
        fetch.setBounds(390, 80, 140, 25);
        fetch.addActionListener(this);
        add(fetch);

        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 130, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);

        tfname = new JLabel();
        tfname.setBounds(220, 130, 150, 25);
        add(tfname);

        JLabel lblcancel = new JLabel("CANCELATION NO.");
        lblcancel.setBounds(60, 180, 150, 25);
        lblcancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblcancel);

        cancel = new JLabel("" + random.nextInt(100000));
        cancel.setBounds(220, 180, 150, 25);
        add(cancel);


        JLabel lblfname = new JLabel("FLIGHT NAME");
        lblfname.setBounds(60, 230, 150, 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfname);

        tfflightname = new JLabel();
        tfflightname.setBounds(220, 230, 150, 25);
        add(tfflightname);

        JLabel lblfcode = new JLabel("FLIGHT CODE");
        lblfcode.setBounds(60, 280, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);

        tfcode = new JLabel();
        tfcode.setBounds(220, 280, 150, 25);
        add(tfcode);

        JLabel lbldate = new JLabel("FLIGHT DATE");
        lbldate.setBounds(60, 330, 150, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);

        dcdate = new JLabel();
        dcdate.setBounds(220, 330, 150, 25);
        add(dcdate);

        cancelTicket = new JButton("CANCEL TICKET");
        cancelTicket.setBackground(Color.BLACK);
        cancelTicket.setForeground(Color.WHITE);
        cancelTicket.setBounds(220, 380, 150, 25);
        cancelTicket.addActionListener(this);
        add(cancelTicket);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/cancel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(550, 80, 500, 410);
        add(lblimage);

        setSize(1100, 500);
        setLocation(200, 100);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == fetch) {
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
                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancelTicket) {

            String name = tfname.getText();
            String pnr = tfpnr.getText();
            String cancel = this.cancel.getText();
            String flightcode = tfcode.getText();
            String flightname = tfflightname.getText();
            String date = dcdate.getText();


            try {
                Conn c = new Conn();
                String query = "insert into cancel value('" + pnr + "','" + cancel + "','" + name + "','" + flightcode + "','" + flightname + "','" + date + "')";
                c.s.executeUpdate(query);
                c.s.executeUpdate("delete from reservation where PNR='" + pnr + "'");

                JOptionPane.showMessageDialog(null, "ticket canceled");
                setVisible(false);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Cancel();
    }

}
