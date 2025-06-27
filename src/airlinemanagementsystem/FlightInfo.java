package airlinemanagementsystem;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.JScrollPane;
import net.proteanit.sql.DbUtils;

public class FlightInfo extends JFrame {

    public FlightInfo() {
        setLayout(null);
        getContentPane().setBackground(Color.white);
        JTable table = new JTable();

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select* from FlightDetails");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 10, 800, 500);
        add(jsp);

        setSize(800, 350);
        setLocation(400, 200);
        setVisible(true);

    }

    public static void main(String[] args) {
        new FlightInfo();
    }
}
