package airlinemanagementsystem;

import java.sql.*; // 1st step for jdbc

public class Conn {

    Connection c;
    Statement s;

    public Conn() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");// 2nd step for jdbc "hyat appun jar file import kele ane  com.mysql.cj.jdbc.Driver he lehela "
            c = DriverManager.getConnection("jdbc:mysql:///airlinemanagementsystem", "root", "SAMu@170804");// connection create keal by specifying our database and pass
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    PreparedStatement prepareStatement(String query) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

}
