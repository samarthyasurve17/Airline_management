package airlinemanagementsystem;

import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

public class JourneyDetails extends JFrame implements ActionListener {

    JLabel lblpnr;
    JTextField tfpnr;
    JButton show;
    JTable table;



    public JourneyDetails() {
        setLayout(null);
        getContentPane().setBackground(Color.white);


        lblpnr = new JLabel("PNR");
        lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblpnr.setBounds(50, 50, 100, 25);
        add(lblpnr);

        tfpnr = new JTextField();
        tfpnr.setBounds(160, 50, 120, 25);
        add(tfpnr);

        table = new JTable();

        show = new JButton("show");
        show.setBackground(Color.white);
        show.setForeground(Color.black);
        show.setBounds(290, 50, 120, 25);
        show.addActionListener(this);
        add(show);


        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 1100, 150);
        jsp.setBackground(Color.white);
        add(jsp);

        setSize(1100, 500);
        setLocation(200, 150);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select* from reservation where PNR='" + tfpnr.getText() + "'");
            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "NO INFORMATION FOUND");
                return;

            }

            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        new JourneyDetails();
    }
}
