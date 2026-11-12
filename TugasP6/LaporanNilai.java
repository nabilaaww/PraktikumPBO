/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasP6;

/**
 *
 * @author LENOVO
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;
 
/*
 * PROGRAM : LAPORAN NILAI SISWA (Procedural + File I/O)
 * Alur program:
 *   Langkah 1: input data siswa dari konsol, tulis ke laporan_nilai.txt
 *   Langkah 2: baca kembali isi file, tampilkan ke konsol
 *   Langkah 3: seluruh proses file dibungkus try-with-resources + catch IOException
 */
public class LaporanNilai {
 
    static final String NAMA_FILE = "laporan_nilai.txt";
    static final double NILAI_LULUS = 70.0;   // batas kelulusan
 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
 
        System.out.println("=== PROGRAM LAPORAN NILAI SISWA ===");
 
        try {
            int jumlahSiswa = bacaJumlahSiswa(input);
 
            // Langkah 1: input console + tulis ke file
            boolean berhasilTulis = tulisLaporan(input, jumlahSiswa);
 
            // Langkah 2: baca kembali file (hanya jika penulisan sukses)
            if (berhasilTulis) {
                bacaLaporan();
            }
        } catch (NoSuchElementException e) {
            System.out.println("\nInput berhenti sebelum data lengkap. Program dihentikan.");
        } finally {
            input.close();
        }
    }
 
    // LANGKAH 1: INPUT + TULIS FILE
    static boolean tulisLaporan(Scanner input, int jumlahSiswa) {
        double totalNilai = 0;
        int jumlahLulus = 0;
        int jumlahTidakLulus = 0;
 
        // Langkah 3: try-with-resources: writer otomatis ditutup (close) setelah blok selesai
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NAMA_FILE))) {
 
            // Header laporan
            writer.write("LAPORAN NILAI SISWA");
            writer.newLine();
            writer.write("==================================================");
            writer.newLine();
            writer.write(String.format("%-4s%-25s%-10s%s", "No", "Nama", "Nilai", "Status"));
            writer.newLine();
            writer.write("--------------------------------------------------");
            writer.newLine();
 
            // Looping: baca data tiap siswa, tentukan status, tulis ke file
            for (int i = 1; i <= jumlahSiswa; i++) {
                System.out.println("\nData siswa ke-" + i);
                String nama = bacaNama(input);
                double nilai = bacaNilai(input);
 
                // Tentukan status kelulusan langsung di dalam loop
                String status;
                if (nilai >= NILAI_LULUS) {
                    status = "Lulus";
                    jumlahLulus++;
                } else {
                    status = "Tidak Lulus";
                    jumlahTidakLulus++;
                }
                totalNilai += nilai;
 
                writer.write(String.format(Locale.US, "%-4d%-25s%-10.2f%s", i, nama, nilai, status));
                writer.newLine();
            }
 
            // Ringkasan di akhir file
            double rataRata = totalNilai / jumlahSiswa;   // jumlahSiswa dijamin >= 1
            writer.write("==================================================");
            writer.newLine();
            writer.write(String.format(Locale.US, "Rata-rata nilai kelas : %.2f", rataRata));
            writer.newLine();
            writer.write("Jumlah siswa lulus    : " + jumlahLulus);
            writer.newLine();
            writer.write("Jumlah tidak lulus    : " + jumlahTidakLulus);
            writer.newLine();
 
            System.out.println("\nData berhasil ditulis ke file " + NAMA_FILE);
            return true;
 
        } catch (IOException e) {
            System.out.println("Gagal menulis file: " + e.getMessage());
            return false;
        }
    }
 
    // LANGKAH 2: BACA FILE
    static void bacaLaporan() {
        System.out.println("\n========== ISI FILE " + NAMA_FILE + " ==========");
 
        // try-with-resources -> reader otomatis ditutup
        try (BufferedReader reader = new BufferedReader(new FileReader(NAMA_FILE))) {
            String baris;
            // readLine() mengembalikan null jika sudah mencapai akhir file
            while ((baris = reader.readLine()) != null) {
                System.out.println(baris);
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca file: " + e.getMessage());
        }
    }
 
    // METHOD BANTU INPUT (dengan validasi)
    static int bacaJumlahSiswa(Scanner input) {
        while (true) {
            System.out.print("Masukkan jumlah siswa: ");
            String teks = input.nextLine().trim();
            try {
                int jumlah = Integer.parseInt(teks);
                if (jumlah >= 1) {
                    return jumlah;
                }
                System.out.println("Jumlah siswa minimal 1.");
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid, masukkan bilangan bulat.");
            }
        }
    }
 
    static String bacaNama(Scanner input) {
        while (true) {
            System.out.print("Nama siswa  : ");
            String nama = input.nextLine().trim();
            if (!nama.isEmpty()) {
                return nama;
            }
            System.out.println("Nama tidak boleh kosong.");
        }
    }
 
    static double bacaNilai(Scanner input) {
        while (true) {
            System.out.print("Nilai siswa : ");
            String teks = input.nextLine().trim().replace(',', '.');   // terima koma desimal
            try {
                double nilai = Double.parseDouble(teks);
                if (nilai >= 0 && nilai <= 100) {
                    return nilai;
                }
                System.out.println("Nilai harus antara 0 sampai 100.");
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid, masukkan angka.");
            }
        }
    }
}