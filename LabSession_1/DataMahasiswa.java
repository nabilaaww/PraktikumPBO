/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labsession1;

/**
 *
 * @author LENOVO
 */

import java.util.ArrayList;

/*
 * STUDI KASUS : DATA MAHASISWA
 * Program ini mengelola data mahasiswa beserta nilai ujiannya,
 * menghitung rata-rata, dan menentukan grade kelulusan.
 */

// POIN 1: CLASS & OBJECT
// Class Mahasiswa memiliki atribut dan lebih dari 2 method
class Mahasiswa {

    // Atribut (variabel) dari class
    private String nim;
    private String nama;
    private int[] nilaiUjian; // POIN 8: Array untuk menyimpan beberapa data nilai

    // POIN 3: KONSTANTA
    // Konstanta nilai minimal kelulusan (KKM), relevan dengan kasus mahasiswa
    static final int KKM = 60;

    // POIN 2: CONSTRUCTOR
    // Constructor untuk inisialisasi nilai awal atribut
    public Mahasiswa(String nim, String nama, int[] nilaiUjian) {
        this.nim = nim;
        this.nama = nama;
        this.nilaiUjian = nilaiUjian;
    }

    // METHOD 1: hitungRataRata
    // POIN 5 (Looping) & POIN 6 (Exception Handling) ada di dalam method ini
    public double hitungRataRata() {
        int total = 0;
        double rataRata = 0;

        // POIN 5: LOOPING - menjumlahkan nilai ujian menggunakan for
        for (int i = 0; i < nilaiUjian.length; i++) {
            total += nilaiUjian[i];
        }

        // POIN 6: EXCEPTION HANDLING
        // Menangani potensi error pembagian oleh nol jika array nilai kosong
        try {
            rataRata = total / nilaiUjian.length; // bisa memicu ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Terjadi error: " + e.getMessage() + " (data nilai kosong)");
            rataRata = 0;
        }

        return rataRata;
    }

    // METHOD 2: tentukanGrade
    // POIN 4: KONDISIONAL - menggunakan if-else untuk menentukan grade
    public char tentukanGrade(double rataRata) {
        char grade; // POIN 7: penggunaan tipe data char

        if (rataRata >= 85) {
            grade = 'A';
        } else if (rataRata >= 70) {
            grade = 'B';
        } else if (rataRata >= KKM) {
            grade = 'C';
        } else {
            grade = 'E'; // tidak lulus
        }

        return grade;
    }

    // METHOD 3: tampilkanInfo
    // POIN 7: STRING - menggunakan minimal 2 method dari class String
    public void tampilkanInfo() {
        double rataRata = hitungRataRata();
        char grade = tentukanGrade(rataRata);

        // toUpperCase() dan length() adalah method dari class String
        String namaKapital = nama.toUpperCase();
        int panjangNama = nama.length();

        // POIN 4 (lanjutan): switch-case untuk menentukan status kelulusan
        String status;
        switch (grade) {
            case 'A':
            case 'B':
            case 'C':
                status = "LULUS";
                break;
            default:
                status = "TIDAK LULUS";
                break;
        }

        System.out.println("----------------------------------------");
        System.out.println("NIM         : " + nim);
        System.out.println("Nama        : " + namaKapital + " (panjang nama: " + panjangNama + " huruf)");
        System.out.println("Inisial     : " + nama.substring(0, 1)); // substring() -> method String kedua
        System.out.println("Rata-rata   : " + rataRata);
        System.out.println("Grade       : " + grade);
        System.out.println("KKM         : " + KKM);
        System.out.println("Status      : " + status);
    }
}

// CLASS UTAMA (main)
public class DataMahasiswa {
    public static void main(String[] args) {

        // POIN 8: COLLECTION - menyimpan beberapa object Mahasiswa dalam ArrayList
        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();

        // POIN 9: Membuat object dari class Mahasiswa
        Mahasiswa m1 = new Mahasiswa("A11.2023.001", "Budi Santoso", new int[]{80, 75, 90});
        Mahasiswa m2 = new Mahasiswa("A11.2023.002", "citra dewi", new int[]{55, 60, 58});
        Mahasiswa m3 = new Mahasiswa("A11.2023.003", "Rian Pratama", new int[]{}); // sengaja kosong untuk uji exception

        daftarMahasiswa.add(m1);
        daftarMahasiswa.add(m2);
        daftarMahasiswa.add(m3);

        System.out.println("========== LAPORAN DATA MAHASISWA ==========");

        // POIN 5 (lanjutan): LOOPING menggunakan for-each untuk memproses Collection
        for (Mahasiswa mhs : daftarMahasiswa) {
            mhs.tampilkanInfo(); // POIN 9: menampilkan hasil ke layar
        }

        System.out.println("----------------------------------------");
        System.out.println("Total mahasiswa terdata: " + daftarMahasiswa.size());
    }
}