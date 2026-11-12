/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasPenggantiP7;

/**
 *
 * @author LENOVO
 */
/**
 * Custom Exception (checked) yang dilempar ketika nilai mahasiswa
 * kurang dari 0 atau lebih dari 100.
 *
 * Turunan dari Exception, sehingga pemanggil WAJIB menangani
 * (try-catch) atau meneruskannya (throws).
 */
public class NilaiInvalidException extends Exception {
 
    private final double nilai;   // menyimpan nilai yang ditolak
 
    public NilaiInvalidException(double nilai) {
        super("Nilai " + nilai + " tidak valid, harus antara "
                + Mahasiswa.NILAI_MIN + " sampai " + Mahasiswa.NILAI_MAX);
        this.nilai = nilai;
    }
 
    public double getNilai() {
        return nilai;
    }
}