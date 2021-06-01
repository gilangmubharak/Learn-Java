package Gradle;

    public class Oke {
        int x = 5;

        public static void main(String[] args) {
            Oke myObj1 = new Oke();  // Object 1
            Oke myObj2 = new Oke();  // Object 2
            myObj2.x = 25;
            System.out.println(myObj1.x);  // Outputs 5
            System.out.println(myObj2.x);  // Outputs 25
        }
    }


