/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasP2;

/**
 *
 * @author LENOVO
 */

import java.util.Scanner;

class Student {
    // Ini Variabel
    String name;
    double score;
    boolean passed;

    // Ini Constructor
    Student(String name, double score) {
        this.name = name;
        this.score = score;
        this.passed = false;
    }

    // Ini Method untuk ngecek kelulusan
    void checkPassed() {
        if (score >= 70) {
            passed = true;
        } else {
            passed = false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Nginput jumlah siswa
        System.out.print("Masukkan jumlah siswa: ");
        int jumlahSiswa = input.nextInt();
        input.nextLine();

        // Mbuat array objek Student
        Student[] students = new Student[jumlahSiswa];

        // Nginput data tiap siswa
        for (int i = 0; i < jumlahSiswa; i++) {
            System.out.println("\nData siswa ke-" + (i + 1) + ":");

            System.out.print("Masukkan nama: ");
            String name = input.nextLine();

            System.out.print("Masukkan nilai: ");
            double score = input.nextDouble();
            input.nextLine();

            // Mbuat objek Student
            students[i] = new Student(name, score);
        }

        // Ngecek kelulusan semua siswa
        for (int i = 0; i < jumlahSiswa; i++) {
            students[i].checkPassed();
        }

        // Ngehitung total nilai sama jumlah siswa
        double totalNilai = 0;
        int jumlahLulus = 0;
        int jumlahTidakLulus = 0;

        // Nampilin data semua siswa
        System.out.println("\n===== HASIL NILAI SISWA =====");

        for (int i = 0; i < jumlahSiswa; i++) {
            // Jumlahin nilai
            totalNilai += students[i].score;

            // Nentuin status
            String status;

            if (students[i].passed) {
                status = "Lulus";
                jumlahLulus++;
            } else {
                status = "Tidak Lulus";
                jumlahTidakLulus++;
            }

            // Nampilin data siswa
            System.out.println(
                "Siswa: " + students[i].name +
                " - Nilai: " + students[i].score +
                " - " + status
            );
        }

        // Ngehitung rata-rata
        double rataRata = totalNilai / jumlahSiswa;

        // Nampilin hasil akhir
        System.out.printf("\nRata-rata nilai kelas: %.2f%n", rataRata);
        System.out.println("Jumlah siswa lulus: " + jumlahLulus);
        System.out.println("Jumlah siswa tidak lulus: " + jumlahTidakLulus);

        // Nutup Scanner
        input.close();
    }
}