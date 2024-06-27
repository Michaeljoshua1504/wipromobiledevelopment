package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    // Method to add two integers
    public static int add(int a, int b) {
        return a + b;
    }

    // Method to check if a number is even
    public static boolean even(int a) {
        return a % 2 == 0;
    }

    public static void main(String[] args) {
        // Test add and even methods
        System.out.println("4 + 5 = " + add(4, 5));
        System.out.println("3 is even: " + even(3));

        // Database connection logic
        try {
    
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "root");

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from jdbc;");

            while (rs.next()) {
                System.out.println(rs.getInt("id") + ", " 
                    + rs.getString(2) + ", " + rs.getString(3));
            }

            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
