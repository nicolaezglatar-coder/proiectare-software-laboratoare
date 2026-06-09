package org.example;

import java.sql.*;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        try {
            Connection conn = getConnection();

            System.out.println("=== DEPARTMENTS INITIAL ===");
            showAllDepartments(conn);

            createUpdateDeleteDepartment(conn);

            System.out.println("\n=== DEPARTMENTS AFTER CRUD ===");
            showAllDepartments(conn);

            System.out.println("\n=== EMPLOYEES INITIAL ===");
            showAllEmployees(conn);

            createUpdateDeleteEmployee(conn);

            System.out.println("\n=== EMPLOYEES AFTER CRUD ===");
            showAllEmployees(conn);

            System.out.println("\n=== COMPANIES INITIAL ===");
            showAllCompanies(conn);

            createUpdateDeleteCompany(conn);

            System.out.println("\n=== COMPANIES AFTER CRUD ===");
            showAllCompanies(conn);

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String dbUrl = "jdbc:mysql://localhost:3306/lab13Db";

        Properties props = new Properties();
        props.put("user", "root");
        props.put("password", "");

        return DriverManager.getConnection(dbUrl, props);
    }

    private static void createUpdateDeleteDepartment(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();

        stmt.executeUpdate("INSERT INTO department (name, idcompany) VALUES ('Marketing', 1)");
        stmt.executeUpdate("UPDATE department SET name = 'Marketing Updated' WHERE name = 'Marketing'");
        stmt.executeUpdate("DELETE FROM department WHERE name = 'Marketing Updated'");

        stmt.close();
    }

    private static void showAllDepartments(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();

        ResultSet results = stmt.executeQuery(
                "SELECT d.id, d.name, c.name AS company_name " +
                        "FROM department d " +
                        "LEFT JOIN company c ON d.idcompany = c.id"
        );

        System.out.println("ID | Department | Company");
        System.out.println("--------------------------");

        while (results.next()) {
            int id = results.getInt("id");
            String name = results.getString("name");
            String companyName = results.getString("company_name");

            System.out.println(id + " | " + name + " | " + companyName);
        }

        results.close();
        stmt.close();
    }

    private static void createUpdateDeleteEmployee(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();

        stmt.executeUpdate(
                "INSERT INTO employee (firstname, lastname, iddepartment) " +
                        "VALUES ('UserJava', 'Test', 1)"
        );

        stmt.executeUpdate(
                "UPDATE employee SET firstname = 'UserJavaUpdated' " +
                        "WHERE lastname = 'Test'"
        );

        stmt.executeUpdate(
                "DELETE FROM employee WHERE lastname = 'Test'"
        );

        stmt.close();
    }

    private static void showAllEmployees(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();

        ResultSet results = stmt.executeQuery(
                "SELECT e.id, e.firstname, e.lastname, d.name AS department_name " +
                        "FROM employee e " +
                        "LEFT JOIN department d ON e.iddepartment = d.id"
        );

        System.out.println("ID | Firstname | Lastname | Department");
        System.out.println("--------------------------------------");

        while (results.next()) {
            int id = results.getInt("id");
            String firstname = results.getString("firstname");
            String lastname = results.getString("lastname");
            String departmentName = results.getString("department_name");

            System.out.println(id + " | " + firstname + " | " + lastname + " | " + departmentName);
        }

        results.close();
        stmt.close();
    }

    private static void createUpdateDeleteCompany(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();

        stmt.executeUpdate(
                "INSERT INTO company (name, address) VALUES ('Company Java', 'Brasov')"
        );

        stmt.executeUpdate(
                "UPDATE company SET address = 'Bucuresti' WHERE name = 'Company Java'"
        );

        stmt.executeUpdate(
                "DELETE FROM company WHERE name = 'Company Java'"
        );

        stmt.close();
    }

    private static void showAllCompanies(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();

        ResultSet results = stmt.executeQuery("SELECT * FROM company");

        System.out.println("ID | Company | Address");
        System.out.println("----------------------");

        while (results.next()) {
            int id = results.getInt("id");
            String name = results.getString("name");
            String address = results.getString("address");

            System.out.println(id + " | " + name + " | " + address);
        }

        results.close();
        stmt.close();
    }
}