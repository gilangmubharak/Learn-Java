package Gradle;

    // abstract class
    abstract class main {
        public String fname = "John";
        public int age = 24;
        public abstract void study(); // abstract method
    }

    // Subclass (inherit from Main)
    class Student extends main {
        public int graduationYear = 2018;
        public String fname;
        public String age;

        public void study() { // the body of the abstract method is provided here
            System.out.println("Studying all day long");
        }
    }
