/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab_Kasir;

/**
 *
 * @author LENOVO
 */
import java.util.Locale;

/**
 * Tahap 1 dan 2 (versi console):
 *  - Tahap 1: menguji class Pesanan dengan data soal.
 *  - Tahap 2: dua kasir (Dina dan Eko) sebagai thread, lengkap dengan join().
 *
 * Aplikasi berjendela (Tahap 3 dan 4) dijalankan lewat: java lab.kasir.KasirFrame
 */
public class MainKasir {

    public static void main(String[] args) throws InterruptedException {

        // ===================== TAHAP 1: Uji class Pesanan =====================
        System.out.println("=== TAHAP 1: Uji Pesanan ===");
        Pesanan pesanan = new Pesanan();

        pesanan.tambahItem(15000, 2);    // Nasi Goreng
        pesanan.tambahItem(5000, 3);     // Es Teh
        System.out.println("Setelah 2 menu -> subtotal: " + rupiah(pesanan.getSubtotal())
                + ", total: " + rupiah(pesanan.hitungTotal()));

        pesanan.tambahItem(25000, 1);    // Ayam Bakar
        System.out.println("Setelah 3 menu -> subtotal: " + rupiah(pesanan.getSubtotal())
                + ", total: " + rupiah(pesanan.hitungTotal()));

        pesanan.reset();
        System.out.println("Setelah reset  -> subtotal: " + rupiah(pesanan.getSubtotal()));

        // ===================== TAHAP 2: Dua kasir sebagai thread =====================
        System.out.println("\n=== TAHAP 2: Dua kasir ===");
        Kasir dina = new Kasir("Dina");
        Kasir eko = new Kasir("Eko");

        dina.start();
        eko.start();

        // join(): main menunggu kedua kasir selesai sebelum mencetak kalimat penutup
        dina.join();
        eko.join();

        System.out.println("Semua pelanggan selesai dilayani");
    }

    private static String rupiah(double nilai) {
        return String.format(Locale.forLanguageTag("id-ID"), "Rp %,.0f", nilai);
    }
}
