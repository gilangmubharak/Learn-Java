import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostgreSQLJDBC {
    public static void main(String args[]) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/testdb",
                            "postgres", "123");
            c.setAutoCommit(false);
            System.out.println("Opened database Successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM COMPANY;");
            while (rs.next()){
                int id = rs.getInt("id");
                String name =  rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                Float salary = rs.getFloat("salary");

                System.out.println("ID=" + id);
                System.out.println("Name=" + name);
                System.out.println("Age="+ age );
                System.out.println("Salary" + salary);
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
}