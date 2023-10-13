package com.sm_kitchen.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DBUtil {
   private static ResourceBundle bundle;
   private static String driver;
   private static String url;
   private static String user;
   private static String password;

   private static ThreadLocal<Connection> local;

   static {
      bundle = ResourceBundle.getBundle("jdbc");
      driver = bundle.getString("driver");
      url = bundle.getString("url");
      user = bundle.getString("user");
      password = bundle.getString("password");

      local = new ThreadLocal<>();

      try {
         Class.forName(driver);
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }
   }

   private DBUtil() {}

   public static Connection getConnection() throws SQLException {
      Connection connection = local.get();
      if (connection == null) {
         connection = DriverManager.getConnection(url, user, password);
         local.set(connection);
      }
      return connection;
   }

   public static void close(Connection connection, Statement statement, ResultSet resultSet) {
      if (resultSet != null) {
         try {
            resultSet.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
      if (statement != null) {
         try {
            statement.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
      if (connection != null) {
         try {
            connection.close();
            local.remove();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }
}
