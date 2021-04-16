
// Java code for serialization and deserialization 
// of a Java object
import java.io.*;

class Test implements java.io.Serializable {
    public int a;
    public String b;

    // Default constructor
    public Test(String string) {
    }

    public Test(int a, String b) {
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) {
        Test object = new Test("1");
        String filename = "file.ser";

        // Serialization
        try {
            // Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(object);

            out.close();
            file.close();

            System.out.println("Object has been serialized");
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }

    }
}
