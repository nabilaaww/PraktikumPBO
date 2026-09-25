/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.service;

/**
 *
 * @author LENOVO
 */
import library.exception.BookNotFoundException;
import library.exception.BorrowLimitExceededException;
import library.model.Book;
import library.model.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LibraryService {
    private ArrayList<Book> koleksiBuku;
    private HashMap<String, Member> dataAnggota;

    public LibraryService() {
        this.koleksiBuku = new ArrayList<>();
        this.dataAnggota = new HashMap<>();
    }

    public void tambahBuku(Book book) {
        koleksiBuku.add(book);
    }

    public void mendaftarAnggota(Member member) {
        assert member.getId() != null && !member.getId().isEmpty() : "ID Anggota tidak boleh kosong";
        dataAnggota.put(member.getId(), member);
    }

    public ArrayList<Book> getKoleksiBuku() {
        return koleksiBuku;
    }

    public Member getAnggota(String id) {
        return dataAnggota.get(id);
    }

    public ArrayList<Book> cariBuku(String keyword) {
        ArrayList<Book> hasil = new ArrayList<>();
        String lowerKeyword = keyword.toLowerCase();

        for (Book b : koleksiBuku) {
            if (b.getJudul().toLowerCase().contains(lowerKeyword) || 
                b.getKategori().toLowerCase().contains(lowerKeyword)) {
                hasil.add(b);
            }
        }
        return hasil;
    }

    public void pinjamBuku(String memberId, String judulBuku) 
            throws BookNotFoundException, BorrowLimitExceededException {

        Member member = dataAnggota.get(memberId);
        assert member != null : "Data anggota harus valid sebelum peminjaman!";

        if (member.getDaftarPinjaman().size() >= 3) {
            throw new BorrowLimitExceededException("Anggota telah mencapai batas maksimal 3 peminjaman.");
        }

        Book targetBook = null;
        for (Book b : koleksiBuku) {
            if (b.getJudul().equalsIgnoreCase(judulBuku)) {
                targetBook = b;
                break;
            }
        }

        if (targetBook == null) {
            throw new BookNotFoundException("Buku dengan judul '" + judulBuku + "' tidak ditemukan.");
        }

        if (!targetBook.isAvailable()) {
            throw new IllegalStateException("Buku '" + judulBuku + "' sedang dipinjam oleh orang lain.");
        }

        targetBook.setAvailable(false);
        targetBook.incrementBorrowedCount();
        member.tambahPinjaman(targetBook);
    }

    public void kembalikanBuku(String memberId, String judulBuku) 
            throws BookNotFoundException {

        Member member = dataAnggota.get(memberId);
        assert member != null : "Data anggota harus valid!";

        Book targetBook = null;
        for (Book b : member.getDaftarPinjaman()) {
            if (b.getJudul().equalsIgnoreCase(judulBuku)) {
                targetBook = b;
                break;
            }
        }

        if (targetBook == null) {
            throw new BookNotFoundException("Buku tidak ada di dalam daftar pinjaman anggota.");
        }

        targetBook.setAvailable(true);
        member.kembalikanPinjaman(targetBook);
    }

    public void tampilkanLaporan() {
        System.out.println("\n=== LAPORAN PERPUSTAKAAN ===");

        int totalPinjaman = 0;
        HashMap<String, Integer> hitungKategori = new HashMap<>();

        for (Book b : koleksiBuku) {
            totalPinjaman += b.getTotalBorrowedCount();
            String kat = b.getKategori();
            hitungKategori.put(kat, hitungKategori.getOrDefault(kat, 0) + 1);
        }

        System.out.println("Total Transaksi Peminjaman: " + totalPinjaman);

        String kategoriPopuler = "-";
        int maxKategoriCount = 0;
        for (Map.Entry<String, Integer> entry : hitungKategori.entrySet()) {
            if (entry.getValue() > maxKategoriCount) {
                maxKategoriCount = entry.getValue();
                kategoriPopuler = entry.getKey();
            }
        }
        System.out.println("Kategori Koleksi Terbanyak: " + kategoriPopuler);

        Member anggotaAktif = null;
        int maxPinjaman = -1;
        for (Member m : dataAnggota.values()) {
            if (m.getDaftarPinjaman().size() > maxPinjaman) {
                maxPinjaman = m.getDaftarPinjaman().size();
                anggotaAktif = m;
            }
        }

        if (anggotaAktif != null && maxPinjaman > 0) {
            System.out.println("Anggota Paling Aktif Saat Ini: " + anggotaAktif.getNama() + " (" + maxPinjaman + " dipinjam)");
        } else {
            System.out.println("Anggota Paling Aktif Saat Ini: Tidak ada pinjaman aktif");
        }

        Book bukuTerpopuler = null;
        int maxFreq = 0;
        for (Book b : koleksiBuku) {
            if (b.getTotalBorrowedCount() > maxFreq) {
                maxFreq = b.getTotalBorrowedCount();
                bukuTerpopuler = b;
            }
        }

        if (bukuTerpopuler != null && maxFreq > 0) {
            System.out.println("Buku Terfavorit: " + bukuTerpopuler.getJudul() + " (Dipinjam " + maxFreq + " kali)");
        } else {
            System.out.println("Buku Terfavorit: Belum ada transaksi");
        }
    }
}