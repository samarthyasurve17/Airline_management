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

public class BookFlight extends JFrame implements ActionListener {

    JTextField tfaadharnumber;
    JButton fetch, flight, bookflight;
    JLabel tfname, tfnationality, tfaddress, tfgender, tfcode, tfflightname;
    Choice source, destination;
    JDateChooser dcdate;

    public BookFlight() {
        getContentPane().setBackground(Color.white);

        setLayout(null);

        JLabel lblheading = new JLabel("BOOK FLIGHT");

        lblheading.setBounds(420, 20, 500, 35);
        lblheading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        add(lblheading);

        JLabel lblaadharnumber = new JLabel("AADHAR NUMBER");
        lblaadharnumber.setBounds(60, 80, 150, 25);
        lblaadharnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblaadharnumber);

        tfaadharnumber = new JTextField();
        tfaadharnumber.setBounds(220, 80, 150, 25);
        add(tfaadharnumber);

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

        JLabel lblnationality = new JLabel("NATIONALITY");
        lblnationality.setBounds(60, 180, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);

        tfnationality = new JLabel();
        tfnationality.setBounds(220, 180, 150, 25);
        add(tfnationality);


        JLabel lbladdress = new JLabel("ADDRESS");
        lbladdress.setBounds(60, 230, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdress);

        tfaddress = new JLabel();
        tfaddress.setBounds(220, 230, 150, 25);
        add(tfaddress);

        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(60, 280, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);

        tfgender = new JLabel();
        tfgender.setBounds(220, 280, 150, 25);
        add(tfgender);

        JLabel lblsource = new JLabel("SOURCE");
        lblsource.setBounds(60, 330, 150, 25);
        lblsource.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblsource);

        source = new Choice();
        source.setBounds(220, 330, 150, 25);
        source.add("");
        add(source);

        JLabel lbldest = new JLabel("DESTINATION");
        lbldest.setBounds(60, 380, 150, 25);
        lbldest.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldest);

        destination = new Choice();
        destination.setBounds(220, 380, 150, 25);
        destination.add("");
        add(destination);

        try {
            Conn c = new Conn();
            String query = "select * from FlightDetails";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                source.add(rs.getString("SOURCE"));
                destination.add(rs.getString("DESTINATION"));

            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        flight = new JButton("FETCH FLIGHTS");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(390, 350, 140, 25);
        flight.addActionListener(this);
        add(flight);

        JLabel lblfname = new JLabel("FLIGHT NAME");
        lblfname.setBounds(60, 430, 150, 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfname);

        tfflightname = new JLabel();
        tfflightname.setBounds(220, 430, 150, 25);
        add(tfflightname);

        JLabel lblfcode = new JLabel("FLIGHT CODE");
        lblfcode.setBounds(60, 480, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);

        tfcode = new JLabel();
        tfcode.setBounds(220, 480, 150, 25);
        add(tfcode);

        JLabel lbldate = new JLabel("FLIGHT DATE");
        lbldate.setBounds(60, 530, 150, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);

        dcdate = new JDateChooser();
        dcdate.setBounds(220, 530, 150, 25);
        add(dcdate);

        bookflight = new JButton("BOOK FLIGHT");
        bookflight.setBackground(Color.BLACK);
        bookflight.setForeground(Color.WHITE);
        bookflight.setBounds(220, 580, 150, 25);
        bookflight.addActionListener(this);
        add(bookflight);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/details.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(550, 80, 500, 410);
        add(lblimage);

        setSize(1100, 700);
        setLocation(200, 50);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == fetch) {
            String aadhar = tfaadharnumber.getText();
            try {
                Conn c = new Conn();
                String query = "select * from passenger where aadharnumber = '" + aadhar + "'";
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    tfname.setText(rs.getString("name"));
                    tfnationality.setText(rs.getString("nationality"));
                    tfaddress.setText(rs.getString("address"));
                    tfgender.setText(rs.getString("gender"));


                } else {
                    JOptionPane.showMessageDialog(null, "aadhar number is not valid");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (ae.getSource() == flight) {

            String src = source.getSelectedItem();
            String dest = destination.getSelectedItem();

            try {
                Conn c = new Conn();
                String query = "select * from flightdetails where source='" + src + "' and destination = '" + dest + "'";
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    tfcode.setText(rs.getString("FLIGHT_CODE"));
                    tfflightname.setText(rs.getString("FLIGHT_NAME"));

                } else {
                    JOptionPane.showMessageDialog(null, "NO FLIGHTS FOUND");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Random random = new Random();
            String aadhar = tfaadharnumber.getText();
            String name = tfname.getText();
            String nationality = tfnationality.getText();
            String fcode = tfcode.getText();
            String fname = tfflightname.getText();
            String src = source.getSelectedItem();
            String dest = destination.getSelectedItem();
            String ddate = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();

            try {
                Conn c = new Conn();
                String query = "insert into reservation values('PNR-" + random.nextInt(10000000) + "','TIC-" + random.nextInt() + "','" + aadhar + "','" + name + "','" + nationality + "','" + fcode + "','" + fname + "','" + src + "','" + dest + "','" + ddate + "')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "TICKET BOOKED SUCCESSFULLY");


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    public static void main(String[] args) {
        new BookFlight();
    }

}
