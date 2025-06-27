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

        JLabel heading = new JLabel("WELCOME TO SAM'S AIRLINE");
        heading.setBounds(550, 40, 1400, 40);
        heading.setForeground(Color.black);
        heading.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 36));
        heading.setForeground(Color.DARK_GRAY);

        image.add(heading);

        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        JMenu details = new JMenu("DETAILS");
        menubar.add(details);
        JMenuItem flightdetails = new JMenuItem("Flight Details");
        flightdetails.addActionListener(this);
        details.add(flightdetails);

        JMenuItem customerdetail = new JMenuItem("Add Customer Detail");
        customerdetail.addActionListener(this);
        details.add(customerdetail);

        JMenuItem bookflight = new JMenuItem("Book Flight");
        bookflight.addActionListener(this);

        details.add(bookflight);

        JMenuItem journeydetail = new JMenuItem("Journey Detail");
        journeydetail.addActionListener(this);

        details.add(journeydetail);

        JMenuItem ticketcancellation = new JMenuItem("Cancel Ticket");
        ticketcancellation.addActionListener(this);

        details.add(ticketcancellation);

        JMenu ticket = new JMenu("TICKET");
        menubar.add(ticket);
        JMenuItem Boardingpass = new JMenuItem("Boarding Pass");
        Boardingpass.addActionListener(this);

        ticket.add(Boardingpass);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(0, 0);
        setVisible(true);

    }

    ;

    public void actionPerformed(ActionEvent ae) {
        String text = ae.getActionCommand();
        if (text.equals("Add Customer Detail")) {
            new AddcustomerDetail();
        }
        else if (text.equals("Flight Details")) {
            new FlightInfo();

        } else if (text.equals("Book Flight")) {
            new BookFlight();

        } else if (text.equals("Journey Detail")) {
            new JourneyDetails();
        } else if (text.equals("Cancel Ticket")) {
            new Cancel();
        } else if (text.equals("Boarding Pass")) {
            new BoardingPass();
        }


    }

    public static void main(String[] args) {
        new Home();
    }

}
