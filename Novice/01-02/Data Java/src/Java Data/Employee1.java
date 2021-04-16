import java.io.*;

public class Employee1 {

    // salary variable is a private static variable
    private static double salary;

    // Department is a constant
    public static final String DEPARTMENT = "Development ";

    public static void main(String args[]) {
        salary = (4000);
        System.out.println(DEPARTMENT + "average salary:" + salary);

    }
}
