package airlinemanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Home extends JFrame implements ActionListener {


    public Home() {
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/new2.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1610, 800);
        add(image);

        JLabel heading = new JLabel("WElCOME TO SAM'S AIRLINE");
        heading.setBounds(550, 40, 1400, 40);
        heading.setForeground(Color.black);
        heading.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 36));
        image.add(heading);

        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        JMenu details = new JMenu("DETAILS");
        menubar.add(details);
        JMenuItem flightdetails = new JMenuItem("Flight Details");
        details.add(flightdetails);
        JMenuItem customerdetail = new JMenuItem("Customer Detail");
        details.add(customerdetail);
        JMenuItem bookflight = new JMenuItem("Book Flight");
        details.add(bookflight);
        JMenuItem journeydetail = new JMenuItem("Journey Detail");
        details.add(journeydetail);
        JMenuItem ticketcancellation = new JMenuItem();
        details.add(ticketcancellation);

        JMenu ticket = new JMenu("TICKET");
        menubar.add(ticket);
        JMenuItem Boardingpass = new JMenuItem("Boarding Pass");
        ticket.add(Boardingpass);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(0, 0);
        setVisible(true);


    }

    ;

    public void actionPerformed(ActionEvent ae) {
    }

    public static void main(String[] args) {
        new Home();
    }

}
