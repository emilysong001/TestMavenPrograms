package section29;

import java.sql.*;

public class JDBCConnection {
    public static void main(String[] args) throws SQLException {
        String host = "localhost";
        String port = "3306";
        //Connection con= DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/qadbt","esong","root");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qadbt", "root", "root");
        //jdbc:mysql://+host+":"+port+"/databasename"

        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("select * from Employeeinfo where age = 21");
        //return all matched result
        while (rs.next()) {
            System.out.println(rs.getString("name"));
            System.out.println(rs.getString("location"));
        }

        /*rs.next();
        rs.next();
        System.out.println(rs.getString("name"));
        System.out.println(rs.getString("location"));*/


    }
}
