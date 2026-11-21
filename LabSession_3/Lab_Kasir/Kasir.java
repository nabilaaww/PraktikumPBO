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
 * Tahap 2: kasir sebagai Thread (melengkapi kerangka dari soal).
 */
public class Kasir extends Thread {

    private String nama;

    public Kasir(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            // TODO selesai: cetak nama kasir dan nomor pelanggan (i)
            System.out.println("Kasir " + nama + " melayani pelanggan ke-" + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Kasir " + nama + " dihentikan sebelum selesai.");
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
