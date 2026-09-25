/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.main;

/**
 *
 * @author LENOVO
 */
import library.exception.BookNotFoundException;
import library.exception.BorrowLimitExceededException;
import library.model.Book;
import library.model.Member;
import library.service.LibraryService;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        LibraryService service = new LibraryService();
        Scanner scanner = new Scanner(System.in);

        // Data awal
        service.tambahBuku(new Book("Pemrograman Java", "Andi", 2020, "Teknologi"));
        service.tambahBuku(new Book("Struktur Data", "Budi", 2021, "Teknologi"));
        service.tambahBuku(new Book("Laskar Pelangi", "Andrea Hirata", 2005, "Novel"));

        Member m1 = new Member("M01", "Budi Santoso");
        Member m2 = new Member("M02", "Siti Aminah");
        service.mendaftarAnggota(m1);
        service.mendaftarAnggota(m2);

        boolean running = true;
        while (running) {
            System.out.println("\n=== SISTEM MANAJEMEN PERPUSTAKAAN ===");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Daftar Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Pinjam Buku");
            System.out.println("5. Kembalikan Buku");
            System.out.println("6. Laporan Perpustakaan");
            System.out.println("7. Keluar");
            System.out.print("Pilih menu (1-7): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Judul: ");
                    String judul = scanner.nextLine();
                    System.out.print("Masukkan Penulis: ");
                    String penulis = scanner.nextLine();
                    System.out.print("Masukkan Tahun Terbit: ");
                    int tahun = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan Kategori: ");
                    String kategori = scanner.nextLine();

                    service.tambahBuku(new Book(judul, penulis, tahun, kategori));
                    System.out.println("Buku berhasil ditambahkan!");
                    break;

                case 2:
                    System.out.println("\n--- DAFTAR KOLEKSI BUKU ---");
                    for (Book b : service.getKoleksiBuku()) {
                        System.out.println(b);
                    }
                    break;

                case 3:
                    System.out.print("Masukkan kata kunci judul/kategori: ");
                    String keyword = scanner.nextLine();
                    ArrayList<Book> hasil = service.cariBuku(keyword);
                    System.out.println("\n--- HASIL PENCARIAN ---");
                    if (hasil.isEmpty()) {
                        System.out.println("Buku tidak ditemukan.");
                    } else {
                        for (Book b : hasil) {
                            System.out.println(b);
                        }
                    }
                    break;

                case 4:
                    System.out.print("Masukkan ID Anggota (M01/M02): ");
                    String idPinjam = scanner.nextLine();
                    System.out.print("Masukkan Judul Buku: ");
                    String judulPinjam = scanner.nextLine();

                    try {
                        service.pinjamBuku(idPinjam, judulPinjam);
                        System.out.println("Peminjaman berhasil!");
                    } catch (BookNotFoundException | BorrowLimitExceededException e) {
                        System.out.println("Gagal Pinjam: " + e.getMessage());
                    } catch (IllegalStateException e) {
                        System.out.println("Gagal Pinjam: " + e.getMessage());
                    } catch (AssertionError e) {
                        System.out.println("Assertion Error: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.print("Masukkan ID Anggota: ");
                    String idKembali = scanner.nextLine();
                    System.out.print("Masukkan Judul Buku: ");
                    String judulKembali = scanner.nextLine();

                    try {
                        service.kembalikanBuku(idKembali, judulKembali);
                        System.out.println("Pengembalian berhasil!");
                    } catch (BookNotFoundException e) {
                        System.out.println("Gagal Pengembalian: " + e.getMessage());
                    } catch (AssertionError e) {
                        System.out.println("Assertion Error: " + e.getMessage());
                    }
                    break;

                case 6:
                    service.tampilkanLaporan();
                    break;

                case 7:
                    running = false;
                    System.out.println("Terima kasih telah menggunakan sistem perpustakaan.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
        scanner.close();
    }
}