import Kendaraan.Kereta;
import Kendaraan.Mobil;
import Kendaraan.Motor;
import Music.Gitar;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Gitar.bunyi();
        Kereta.jumlahBan();
        Motor.jumlahBan();
        Mobil.jumlahBan();
    }
}
