import java.sql.*;

public class Methodd {
    public Connection getConnection() throws SQLException {
        String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=Bai Tap 3";
        String username = "Rinowo";
        String password = "Rinochan205.";
        return DriverManager.getConnection(dbURL, username, password);
    }

    public void m1() throws SQLException {
        String query = "SELECT COUNT(idCard) AS [So Nguoi Nhap Canh] \n" +
                "FROM [Entry Procedures]";
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int so = resultSet.getInt("So Nguoi Nhap Canh");
            System.out.println("Số người nhập cảnh: " + so);
        }
    }

    public void m2() throws SQLException {
        String query = "SELECT COUNT(idCard) AS [So Nguoi Xuat Canh]\n" +
                "FROM [Exit Procedures]\n" +
                "GO";
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int so = resultSet.getInt("So Nguoi Xuat Canh");
            System.out.println("Số người xuất cảnh: " + so);
        }
    }

    public void m3() throws SQLException {
        String query = "SELECT E.name, E.gender, E.idCard, E.nationality, E.address\n" +
                "FROM [Exit Procedures] EP INNER JOIN [Person] E\n" +
                "ON EP.idCard = E.idCard\n" +
                "WHERE EP.passport IS NOT NULL";
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String gender = resultSet.getString("gender");
            int id = resultSet.getInt("id");
            String nationality = resultSet.getString("nationlily");
            String address = resultSet.getString("address");
            System.out.println("Name: " + name + " Gender: " + gender + " Id Card: " + id +
                    " Nationality: " + nationality + " Address: " + address);
        }
    }

    public void m4() throws SQLException {
        String query = "SELECT E.name, E.gender, E.idCard, E.nationality, E.address\n" +
                "FROM [Entry Procedures] EP INNER JOIN [Person] E\n" +
                "ON EP.idCard = E.idCard\n" +
                "WHERE EP.visa IS NOT NULL\n" +
                "GO";
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String gender = resultSet.getString("gender");
            int id = resultSet.getInt("id");
            String nationality = resultSet.getString("nationlily");
            String address = resultSet.getString("address");
            System.out.println("Name: " + name + " Gender: " + gender + " Id Card: " + id +
                    " Nationality: " + nationality + " Address: " + address);
        }
    }

    public void m5a() throws SQLException {
        String query = "SELECT COUNT(EP.visa) AS [Using Visa]\n" +
                "FROM [Exit Procedures] EP INNER JOIN [Person] P\n" +
                "ON EP.idCard = P.idCard\n" +
                "WHERE EP.visa IS NOT NULL";
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int so = resultSet.getInt("Using Visa");
            System.out.println("Using Visa: " + so);
        }
    }

    public void m5b() throws SQLException {
        String query = "SELECT COUNT(EP.visa) AS [Using Passport]\n" +
                "FROM [Exit Procedures] EP INNER JOIN [Person] P\n" +
                "ON EP.idCard = P.idCard\n" +
                "WHERE EP.passport IS NOT NULL";
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int so = resultSet.getInt("Using Passport");
            System.out.println("Using Passport: " + so);
        }
    }

    public void m6() throws SQLException {
        String query = "SELECT COUNT(EP.approval) AS [Using approval]\n" +
                "FROM [Exit Procedures] EP INNER JOIN [Person] P\n" +
                "ON EP.idCard = P.idCard\n" +
                "WHERE EP.approval IS NOT NULL";
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int so = resultSet.getInt("Using approval");
            System.out.println("Using approval: " + so);
        }
    }

    public void m7() throws SQLException {
        String query = "SELECT E.name, E.gender, E.idCard, E.nationality \n" +
                "FROM [Entry Procedures] EP INNER JOIN [Person] E \n" +
                "ON EP.idCard = E.idCard\n" +
                "WHERE E.nationality = 'VN'";
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String gender = resultSet.getString("gender");
            int id = resultSet.getInt("id");
            String nationality = resultSet.getString("nationlily");
            System.out.println("Name: " + name + " Gender: " + gender + " Id Card: " + id +
                    " Nationality: " + nationality);
        }
    }

    public void m8() throws SQLException {
        String query = "SELECT E.name, E.gender, E.idCard, E.nationality \n" +
                "FROM [Entry Procedures] EP INNER JOIN [Person] E \n" +
                "ON EP.idCard = E.idCard\n" +
                "WHERE E.gender = 'Nam' AND EP.immigrationReason = 'Du lich'";
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String gender = resultSet.getString("gender");
            int id = resultSet.getInt("id");
            String nationality = resultSet.getString("nationlily");
            System.out.println("Name: " + name + " Gender: " + gender + " Id Card: " + id +
                    " Nationality: " + nationality);
        }
    }
}
