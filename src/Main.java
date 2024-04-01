import java.sql.*;

public class Main {

    public static final String DB_URL = "jdbc:mysql://localhost/universite";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "mysql";

    public static void main(String[] args) {

        Connection connect = null;

        try {
            connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement statement = connect.createStatement();

            // 1. çalışanın eklenmesi
            String insertEmployeeQuery = "INSERT INTO employees (name, position, salary) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connect.prepareStatement(insertEmployeeQuery);
            preparedStatement.setString(1, "Yeşim Taze");
            preparedStatement.setString(2, "Yazar");
            preparedStatement.setDouble(3, 70000);
            preparedStatement.executeUpdate();
            preparedStatement.clearParameters();

            // 2. çalışanın eklenmesi
            preparedStatement.setString(1, "Yusuf Yargı");
            preparedStatement.setString(2, "Mühendis");
            preparedStatement.setDouble(3, 45000);
            preparedStatement.executeUpdate();
            preparedStatement.clearParameters();

            // 3. çalışanın eklenmesi
            preparedStatement.setString(1, "Hilal Gümüş");
            preparedStatement.setString(2, "Satıcı");
            preparedStatement.setDouble(3, 30000);
            preparedStatement.executeUpdate();
            preparedStatement.clearParameters();

            // 4. çalışanın eklenmesi
            preparedStatement.setString(1, "Metin Uçar");
            preparedStatement.setString(2, "Müzisyen");
            preparedStatement.setDouble(3, 500);
            preparedStatement.executeUpdate();
            preparedStatement.clearParameters();

            // Çalışanları seçmek için sorgu
            String selectEmployeesQuery = "SELECT * FROM employees";
            ResultSet resultSet = statement.executeQuery(selectEmployeesQuery);
            System.out.println("Çalışan Listesi");
            while (resultSet.next()) {
                System.out.println("------------------");
                System.out.println("Çalışan ID: " + resultSet.getInt("id"));
                System.out.println("Çalışan İsim: " + resultSet.getString("name"));
                System.out.println("Çalışan Pozisyon: " + resultSet.getString("position"));
                System.out.println("Çalışan Maaşı: " + resultSet.getDouble("salary"));
            }

            preparedStatement.close();
            statement.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
