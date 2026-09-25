/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.model;

/**
 *
 * @author LENOVO
 */
public class Book {
    private String judul;
    private String penulis;
    private int tahunTerbit;
    private String kategori;
    private boolean isAvailable;
    private int totalBorrowedCount;

    public Book(String judul, String penulis, int tahunTerbit, String kategori) {
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
        this.kategori = kategori;
        this.isAvailable = true;
        this.totalBorrowedCount = 0;
    }

    public String getJudul() { return judul; }
    public String getPenulis() { return penulis; }
    public int getTahunTerbit() { return tahunTerbit; }
    public String getKategori() { return kategori; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
    public int getTotalBorrowedCount() { return totalBorrowedCount; }
    public void incrementBorrowedCount() { this.totalBorrowedCount++; }

    @Override
    public String toString() {
        return String.format("[%s] %s oleh %s (%d) - Status: %s", 
                kategori, judul, penulis, tahunTerbit, (isAvailable ? "Tersedia" : "Dipinjam"));
    }
}