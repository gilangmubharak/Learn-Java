package Inheritance;

public class Main {
    public static void main(String[] args){

        // membuat objek bangun datar
        BangunDatar bangundatar = new BangunDatar();

        // membuat objek persegi
        Persegi persegi= new Persegi();
        persegi.sisi = 2;

        //membuat objek lingkaran
        Lingkaran lingkaran = new Lingkaran();
        lingkaran.r = 22;

        // membuat objek persegi panjang
        PersegiPanjang persegipanjang = new PersegiPanjang();
        persegipanjang.panjang = 8;
        persegipanjang.lebar = 4;

        //membuat objek segitiga
        Segitiga mSegitiga = new Segitiga();
        mSegitiga.alas = 12;
        mSegitiga.tinggi = 8;

        // memanggil method luas dan keliling
        bangundatar.luas();
        bangundatar.keliling();

        lingkaran.luas();
        lingkaran.keliling();

        mSegitiga.luas();
        mSegitiga.keliling();
    }
}
