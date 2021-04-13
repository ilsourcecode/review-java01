package com.lyw;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bjpowernode?useSSL=false&allowPublicKeyRetrieval=true", "root", "1870168452");

        connection.setAutoCommit(false);
        PreparedStatement ps = connection.prepareStatement("select id, name, email, age from student where id = ?");
        ps.setInt(1, 3);

//        Statement statement = connection  .createStatement();
//        String sql = "select id, name, email, age from student";
//        ResultSet resultSet = statement.executeQuery(sql);
        ResultSet resultSet = ps.executeQuery();
        while(resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String age = resultSet.getString("age");
            System.out.println("student ->  " + "id -> " + id + " name -> " + name + " email -> " + email + " age -> " + age);
        }

        connection.commit();
        if (resultSet != null) {
            resultSet.close();
        }
//        if (statement != null)
//            statement.close();

        if (ps != null) {
            ps.close();
        }

        if (connection != null)
            connection.close();

    }
}
