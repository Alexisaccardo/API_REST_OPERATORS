package com.example.demo;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BD {
    public BD() {
    }

    public static Users Select_user(String code) throws ClassNotFoundException, SQLException {

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/peoples";
        String username = "root";
        String password = "";

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, username, password);

        String consult_SQL = "SELECT * FROM employees WHERE code = ?";

        PreparedStatement statement = connection.prepareStatement(consult_SQL);
        statement.setString(1, code); // Establecer el valor del parámetro

        // Ejecutar la consulta
        ResultSet resultSet2 = statement.executeQuery();

        // Procesar el resultado si existe
        if (resultSet2.next()) {

            code = resultSet2.getString("code");
            String name = resultSet2.getString("name");
            String operator = resultSet2.getString("operator");
            String city = resultSet2.getString("city");
            String address = resultSet2.getString("address");
            String cellphone = resultSet2.getString("cellphone");

            Users users = new Users(code, name, operator, city, address, cellphone);

                return users;
            }
        // Cerrar recursos
        resultSet2.close();
        statement.close();
        connection.close();

        return null;
    }


    public Users Register(String code, String name, String operator, String city, String address, String cellphone) {

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/peoples";
        String username = "root";
        String password = "";

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");

            // Sentencia INSERT
            String sql = "INSERT INTO employees (code, name, operator, city, address, cellphone) VALUES (?, ?, ?, ?, ?, ?)";

            // Preparar la sentencia
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, code);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, operator);
            preparedStatement.setString(4, city);
            preparedStatement.setString(5, address);
            preparedStatement.setString(6, cellphone);

            // Ejecutar la sentencia
            int files = preparedStatement.executeUpdate();

            if (files > 0) {
                System.out.println("Empleado registrado de manera exitosa.");
                return new Users(code, name, operator, city, address, cellphone);
            } else {
                System.out.println("No se pudo registrar el empleado");
            }

            preparedStatement.close();
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new Users(null, null, null, null, null, null);

    }

    public Users Edit(String code, String operator) throws ClassNotFoundException, SQLException {

        String driver2 = "com.mysql.cj.jdbc.Driver";
        String url2 = "jdbc:mysql://localhost:3306/peoples";
        String username2 = "root";
        String pass2 = "";

        Class.forName(driver2);
        Connection connection2 = DriverManager.getConnection(url2, username2, pass2);

        Statement statement2 = connection2.createStatement();

        String consult = "UPDATE employees SET operator = ? WHERE code = ?";

        PreparedStatement preparedStatement = connection2.prepareStatement(consult);
        preparedStatement.setString(1, operator);
        preparedStatement.setString(2, code);

        int files = preparedStatement.executeUpdate();
        if (files > 0) {
            System.out.println("Operador actualizado de manera exitosa");
            return new Users (code, null,operator,null, null, null);
        } else {
            System.out.println("No se encontro el empleado para actualizar");
        }
        preparedStatement.close();
        connection2.close();
        return new Users(null, null, null, null, null, null);
    }

    public List<Users> Search_all() throws ClassNotFoundException, SQLException {

        String driver2 = "com.mysql.cj.jdbc.Driver";
        String url2 = "jdbc:mysql://localhost:3306/peoples";
        String username2 = "root";
        String pass2 = "";

        Class.forName(driver2);
        Connection connection2 = DriverManager.getConnection(url2, username2, pass2);

        Statement statement2 = connection2.createStatement();

        ResultSet resultSet2 = statement2.executeQuery("SELECT * FROM employees");

        List<Users> list = new ArrayList<>();

        while (resultSet2.next()) {
            String code = resultSet2.getString("code");
            String name = resultSet2.getString("name");
            String operator = resultSet2.getString("operator");
            String city = resultSet2.getString("city");
            String address = resultSet2.getString("address");
            String cellphone = resultSet2.getString("cellphone");

            Users users = new Users(code, name, operator, city, address, cellphone);

            list.add(users);

        }
        return list;
    }

    public static String Select_operators(String code) throws ClassNotFoundException, SQLException {

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/peoples";
        String username = "root";
        String password = "";

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, username, password);

        String consult_SQL = "SELECT * FROM operators WHERE name = ?";

        PreparedStatement statement = connection.prepareStatement(consult_SQL);
        statement.setString(1, code); // Establecer el valor del parámetro

        // Ejecutar la consulta
        ResultSet resultSet2 = statement.executeQuery();

        // Procesar el resultado si existe
        if (resultSet2.next()) {

            code = resultSet2.getString("code");
            String name = resultSet2.getString("name");
            String operator = resultSet2.getString("city");

            return code;
        }
        // Cerrar recursos
        resultSet2.close();
        statement.close();
        connection.close();

        return "";
    }

    }


