//
//package airlinemanagementsystem;
//
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import java.sql.*;
//
//public class Login extends JFrame implements ActionListener{
//
//
//      JTextField tfusername;
//      JPasswordField tfpassword;
//      JButton submit,close,reset;
//
//    public Login(){
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);
//
//        JLabel lblusername= new JLabel("USERNAME");
//        lblusername.setBounds(20,20,100,20);
//        add(lblusername);
//
//         tfusername= new JTextField();
//        tfusername.setBounds(130, 20, 200, 20);
//        add(tfusername);
//
//         JLabel lblpassword= new JLabel("PASSWORD");
//        lblpassword.setBounds(20,50,100,20);
//        add(lblpassword);
//
//          tfpassword= new JPasswordField();
//        tfpassword.setBounds(130, 50, 200, 20);
//        add(tfpassword);
//
//       reset = new JButton("RESET");
//        reset.setBounds(40, 120, 120, 20);
//        reset.addActionListener(this);
//        add(reset);
//
//         submit = new JButton("submit");
//        submit.setBounds(190, 120, 120, 20);
//         submit.addActionListener(this);
//        add(submit);
//
//         close = new JButton("close");
//        close.setBounds(120, 160, 120, 20);
//         close.addActionListener(this);
//        add(close);
//
//
//        setSize(400,250);
//        setLocation(600, 300);
//        setVisible(true);
//
//    };
//
//    public  void actionPerformed(ActionEvent ae){
//        if (ae.getSource() == submit) {
//            String username = tfusername.getText();
//            String password = tfpassword.getText();
//
//            try {
//                Conn c = new Conn();
//                String query = "select * from login  where username='" + username + "'and password='" + password + "'";
//
//                ResultSet rs = c.s.executeQuery(query);
//
//                if (rs.next()) {
//                    Home home = new Home();
//                    setVisible(false);
//
//                } else {
//                    JOptionPane.showMessageDialog(null, "username or password is invalid"
//                    );
//                    setVisible(false);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else if (ae.getSource() == close) {
//            setVisible(false);
//        } else if (ae.getSource() == reset) {
//        tfpassword.setText("");
//        tfusername.setText("");
//        }
//
//    }
//
//    public static void main(String[] args) {
//        new Login();
//    }
//
//}
