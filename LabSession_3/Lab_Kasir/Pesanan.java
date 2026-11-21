/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab_Kasir;

/**
 *
 * @author LENOVO
 */
/**
 * Tahap 1: class logika pesanan (tanpa kode GUI).
 * Aturan harga: jika subtotal lebih dari 50.000, diskon 10 persen.
 */
public class Pesanan {

    private static final double BATAS_DISKON = 50000;
    private static final double PERSEN_DISKON = 10;

    private double subtotal;     // atribut private (enkapsulasi)

    // Menambahkan harga x jumlah ke subtotal
    public void tambahItem(double harga, int jumlah) {
        subtotal += harga * jumlah;
    }

    public double getSubtotal() {
        return subtotal;
    }

    // Jika subtotal > 50.000: kurangi diskon 10%; jika tidak: subtotal apa adanya
    public double hitungTotal() {
        if (subtotal > BATAS_DISKON) {
            return subtotal - (subtotal * PERSEN_DISKON / 100);
        }
        return subtotal;
    }

    // Mengembalikan subtotal ke 0
    public void reset() {
        subtotal = 0;
    }
}
