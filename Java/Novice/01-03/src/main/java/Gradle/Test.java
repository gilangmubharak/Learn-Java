package Gradle;

public class Test {
    int modelYear;
    String modelName;

    public Test(int year, String name) {
        modelYear = year;
        modelName = name;
    }

    public static void main(String[] args) {
        Test myCar = new Test(1969, "Mustang");
        System.out.println(myCar.modelYear + " " + myCar.modelName);
    }
}
