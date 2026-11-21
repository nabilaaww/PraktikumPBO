/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab_Kasir;

/**
 *
 * @author LENOVO
 */
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.Font;
import java.util.Locale;

/**
 * Tahap 3 dan 4: jendela kasir (Java Swing).
 * Menjalankan aplikasi: java lab.kasir.KasirFrame
 */
public class KasirFrame extends JFrame {

    // ===================== KOMPONEN (private) =====================
    private JTextField txtMenu, txtHarga, txtJumlah;
    private JTextArea areaStruk;
    private JLabel lblTotal;
    private JLabel lblStatus;                       // Tahap 4: status pencetakan
    private JButton btnTambah, btnHitung, btnCetak, btnReset;
    private Pesanan pesanan = new Pesanan();

    public KasirFrame() {
        super("Kasir Kantin UNS");
        setSize(400, 450);
        setLayout(null);

        // ---------- Tahap 3 (1): buat komponen, atur posisi dengan setBounds() ----------
        JLabel lblJudul = new JLabel("Kasir Kantin UNS");
        lblJudul.setFont(lblJudul.getFont().deriveFont(Font.BOLD, 16f));
        lblJudul.setBounds(15, 8, 350, 25);

        JLabel lblMenu = new JLabel("Nama Menu :");
        lblMenu.setBounds(15, 40, 80, 24);
        txtMenu = new JTextField();
        txtMenu.setBounds(100, 40, 265, 24);

        JLabel lblHarga = new JLabel("Harga     :");
        lblHarga.setBounds(15, 70, 80, 24);
        txtHarga = new JTextField();
        txtHarga.setToolTipText("Isi angka tanpa titik/koma, contoh: 15000");
        txtHarga.setBounds(100, 70, 265, 24);

        JLabel lblJumlah = new JLabel("Jumlah    :");
        lblJumlah.setBounds(15, 100, 80, 24);
        txtJumlah = new JTextField();
        txtJumlah.setBounds(100, 100, 265, 24);

        btnTambah = new JButton("Tambah");
        btnTambah.setBounds(15, 132, 105, 30);
        btnHitung = new JButton("Hitung Total");
        btnHitung.setBounds(125, 132, 125, 30);
        btnCetak = new JButton("Cetak Struk");           // Tahap 4
        btnCetak.setBounds(255, 132, 110, 30);

        areaStruk = new JTextArea();
        areaStruk.setEditable(false);
        areaStruk.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        areaStruk.setLineWrap(true);
        areaStruk.setWrapStyleWord(true);
        JScrollPane scrollStruk = new JScrollPane(areaStruk);
        scrollStruk.setBounds(15, 172, 350, 140);

        lblTotal = new JLabel("Total Bayar : " + rupiah(0));
        lblTotal.setFont(lblTotal.getFont().deriveFont(Font.BOLD, 13f));
        lblTotal.setBounds(15, 320, 350, 25);

        lblStatus = new JLabel("Status : siap");        // Tahap 4
        lblStatus.setBounds(15, 350, 230, 25);   // dipersempit agar tidak menimpa tombol Reset
        btnReset = new JButton("Reset");
        btnReset.setBounds(255, 348, 110, 28);

        add(lblJudul);
        add(lblMenu);
        add(txtMenu);
        add(lblHarga);
        add(txtHarga);
        add(lblJumlah);
        add(txtJumlah);
        add(btnTambah);
        add(btnHitung);
        add(btnCetak);
        add(scrollStruk);
        add(lblTotal);
        add(lblStatus);
        add(btnReset);

        // ---------- Pasang aksi tombol ----------
        btnTambah.addActionListener(e -> tambahItem());
        btnHitung.addActionListener(e -> hitungTotal());
        btnCetak.addActionListener(e -> cetakStruk());
        btnReset.addActionListener(e -> resetForm());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);                                // Tahap 3 (1): tampilkan jendela
    }

    // ===================== Tahap 3 (2) + (4): tombol Tambah + validasi =====================
    private void tambahItem() {
        String menu = txtMenu.getText().trim();
        String teksHarga = txtHarga.getText().trim();
        String teksJumlah = txtJumlah.getText().trim();

        // Field kosong
        if (menu.isEmpty() || teksHarga.isEmpty() || teksJumlah.isEmpty()) {
            tampilkanPesan("Semua field (menu, harga, jumlah) harus diisi.");
            return;
        }

        // Harga dan jumlah harus angka: tangani NumberFormatException dengan try-catch
        double harga;
        try {
            harga = Double.parseDouble(teksHarga);
        } catch (NumberFormatException ex) {
            tampilkanPesan("Harga harus berupa angka (tanpa titik/koma, contoh: 15000).");
            return;
        }

        int jumlah;
        try {
            jumlah = Integer.parseInt(teksJumlah);
        } catch (NumberFormatException ex) {
            tampilkanPesan("Jumlah harus berupa bilangan bulat.");
            return;
        }

        // Pengaman tambahan: "!(harga > 0)" juga menolak NaN
        if (!(harga > 0) || Double.isInfinite(harga) || jumlah <= 0) {
            tampilkanPesan("Harga dan jumlah harus lebih dari nol.");
            return;
        }

        // Data valid: masukkan ke Pesanan, tulis satu baris ke struk, kosongkan field
        pesanan.tambahItem(harga, jumlah);
        areaStruk.append(menu + " | " + jumlah + " x " + rupiah(harga)
                + " = " + rupiah(harga * jumlah) + "\n");

        txtMenu.setText("");
        txtHarga.setText("");
        txtJumlah.setText("");
        txtMenu.requestFocusInWindow();
    }

    // ===================== Tahap 3 (3): tombol Hitung Total =====================
    private void hitungTotal() {
        lblTotal.setText("Total Bayar : " + rupiah(pesanan.hitungTotal()));
    }

    // ===================== Tahap 4: tombol Cetak Struk dengan thread =====================
    private void cetakStruk() {
        btnCetak.setEnabled(false);   // cegah klik ganda selama pencetakan (listener ini berjalan di EDT)

        // Penantian 2 detik di THREAD BARU agar jendela (EDT) tidak macet
        new Thread(() -> {
            // Komponen Swing hanya boleh diubah dari EDT, jadi pakai invokeLater
            SwingUtilities.invokeLater(() -> lblStatus.setText("Status : Mencetak struk..."));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                SwingUtilities.invokeLater(() -> {
                    lblStatus.setText("Status : Pencetakan dibatalkan");
                    btnCetak.setEnabled(true);
                });
                return;
            }
            SwingUtilities.invokeLater(() -> {
                lblStatus.setText("Status : Struk selesai");
                btnCetak.setEnabled(true);
            });
        }).start();
    }

    // ===================== Reset: bersihkan halaman =====================
    private void resetForm() {
        pesanan.reset();                  // subtotal kembali 0 (method dari Tahap 1)
        areaStruk.setText("");
        txtMenu.setText("");
        txtHarga.setText("");
        txtJumlah.setText("");
        lblTotal.setText("Total Bayar : " + rupiah(0));
        txtMenu.requestFocusInWindow();
    }

    // ===================== Bantuan =====================
    private void tampilkanPesan(String pesan) {
        JOptionPane.showMessageDialog(this, pesan, "Input Tidak Valid", JOptionPane.ERROR_MESSAGE);
    }

    private String rupiah(double nilai) {
        return String.format(Locale.forLanguageTag("id-ID"), "Rp %,.0f", nilai);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(KasirFrame::new);
    }
}
