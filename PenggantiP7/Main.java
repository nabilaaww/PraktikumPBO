/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasPenggantiP7;

/**
 *
 * @author LENOVO
 */

import TugasPenggantiP7.Mahasiswa;
import TugasPenggantiP7.NilaiInvalidException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Kelas utama: membaca input, mengelola ArrayList<Mahasiswa>,
 * menghitung statistik, dan menyimpan laporan ke file teks.
 */
public class Main {

    private static final String NAMA_FILE = "laporan_nilai.txt";

    public static void main(String[] args) {
        System.out.println("=== PENGELOLAAN NILAI MAHASISWA ===");

        // Deteksi apakah assertion aktif (assignment di dalam assert hanya jalan jika -ea)
        boolean assertionAktif = false;
        assert assertionAktif = true;
        System.out.println("Status assertion: "
                + (assertionAktif ? "AKTIF" : "NONAKTIF (jalankan dengan: java -ea ...)"));

        // Try-with-resources: Scanner otomatis ditutup
        try (Scanner input = new Scanner(System.in)) {

            int jumlah = bacaJumlah(input);

            // Collection dinamis untuk menyimpan objek Mahasiswa
            ArrayList<Mahasiswa> daftar = new ArrayList<>();

            for (int i = 1; i <= jumlah; i++) {
                System.out.println("\nData mahasiswa ke-" + i);
                daftar.add(bacaMahasiswa(input, daftar));    // add()
            }

            System.out.println("\nTotal data dimasukkan: " + daftar.size());   // size()

            // Susun laporan, tampilkan ke layar, lalu simpan ke file
            String laporan = susunLaporan(daftar);
            System.out.println("\n" + laporan);
            simpanLaporan(laporan);

        } catch (NoSuchElementException e) {
            System.out.println("\nInput berhenti sebelum data lengkap. Program dihentikan.");
        }
    }

    // INPUT (Console I/O)
    private static int bacaJumlah(Scanner input) {
        while (true) {
            System.out.print("Masukkan jumlah mahasiswa: ");
            String teks = input.nextLine().trim();
            try {
                int jumlah = Integer.parseInt(teks);
                if (jumlah >= 1) {
                    return jumlah;
                }
                System.out.println("  [!] Jumlah minimal 1.");
            } catch (NumberFormatException e) {
                System.out.println("  [!] Masukkan bilangan bulat.");
            }
        }
    }

    private static Mahasiswa bacaMahasiswa(Scanner input, List<Mahasiswa> daftar) {
        String nama = bacaNama(input);
        String nim = bacaNim(input, daftar);

        // Ulangi sampai nilai valid dan objek berhasil dibuat
        while (true) {
            System.out.print("Nilai (0-100) : ");
            String teks = input.nextLine().trim().replace(',', '.');
            try {
                double nilai = Double.parseDouble(teks);        // primitive double
                return new Mahasiswa(nama, nim, nilai);         // bisa melempar NilaiInvalidException
            } catch (NumberFormatException e) {
                System.out.println("  [!] Nilai harus berupa angka.");
            } catch (NilaiInvalidException e) {
                System.out.println("  [!] " + e.getMessage());
            }
        }
    }

    private static String bacaNama(Scanner input) {
        while (true) {
            System.out.print("Nama          : ");
            String nama = input.nextLine().trim();
            if (!nama.isEmpty()) {
                return nama;
            }
            System.out.println("  [!] Nama tidak boleh kosong.");
        }
    }

    private static String bacaNim(Scanner input, List<Mahasiswa> daftar) {
        while (true) {
            System.out.print("NIM           : ");
            String nim = input.nextLine().trim();

            if (nim.isEmpty()) {
                System.out.println("  [!] NIM tidak boleh kosong.");
            } else if (!Mahasiswa.nimHanyaAngka(nim)) {
                System.out.println("  [!] NIM hanya boleh berisi angka.");
            } else if (nimSudahAda(daftar, nim)) {
                System.out.println("  [!] NIM sudah terdaftar.");
            } else {
                return nim;
            }
        }
    }

    // Penelusuran ArrayList dengan for-each
    private static boolean nimSudahAda(List<Mahasiswa> daftar, String nim) {
        for (Mahasiswa m : daftar) {
            if (m.getNim().equals(nim)) {
                return true;
            }
        }
        return false;
    }

    // STATISTIK (Looping)
    private static double hitungRataRata(List<Mahasiswa> daftar) {
        double total = 0;                       // primitive
        for (Mahasiswa m : daftar) {            // m adalah reference ke objek Mahasiswa
            total += m.getNilai();
        }
        return total / daftar.size();           // daftar dijamin tidak kosong
    }

    private static int hitungLulus(List<Mahasiswa> daftar) {
        int lulus = 0;
        for (Mahasiswa m : daftar) {
            if (m.isLulus()) {
                lulus++;
            }
        }
        return lulus;
    }

    // LAPORAN
    private static String susunLaporan(List<Mahasiswa> daftar) {
        int jumlahLulus = hitungLulus(daftar);
        int jumlahTidakLulus = daftar.size() - jumlahLulus;
        String garis = "=".repeat(70);

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("LAPORAN NILAI MAHASISWA%n"));
        sb.append(garis).append(String.format("%n"));
        sb.append(String.format("%-4s%-12s%-25s%-8s%-7s%s%n", "No", "NIM", "Nama", "Nilai", "Grade", "Status"));
        sb.append("-".repeat(70)).append(String.format("%n"));

        int no = 1;
        for (Mahasiswa m : daftar) {
            sb.append(String.format(Locale.US, "%-4d%-12s%-25s%-8.2f%-7c%s%n",
                    no++, m.getNim(), m.getNama(), m.getNilai(), m.getGrade(),
                    m.isLulus() ? "Lulus" : "Tidak Lulus"));
        }

        sb.append(garis).append(String.format("%n"));
        sb.append(String.format("Jumlah mahasiswa      : %d%n", daftar.size()));
        sb.append(String.format(Locale.US, "Standar kelulusan     : %.1f%n", Mahasiswa.FINAL_PASSING_GRADE));
        sb.append(String.format(Locale.US, "Rata-rata nilai kelas : %.2f%n", hitungRataRata(daftar)));
        sb.append(String.format("Jumlah lulus          : %d%n", jumlahLulus));
        sb.append(String.format("Jumlah tidak lulus    : %d%n", jumlahTidakLulus));
        return sb.toString();
    }

    // FILE I/O
    private static void simpanLaporan(String laporan) {
        // Try-with-resources: writer otomatis ditutup walau terjadi error
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NAMA_FILE))) {
            writer.write(laporan);
            System.out.println("Laporan berhasil disimpan ke: " + new File(NAMA_FILE).getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Gagal menyimpan laporan: " + e.getMessage());
        }
    }
}