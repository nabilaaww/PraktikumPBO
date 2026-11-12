/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasPenggantiP7;

/**
 *
 * @author LENOVO
 */
import java.util.Locale;
 
/**
 * Kelas data Mahasiswa.
 *
 * Tipe data pada atribut:
 *  - nama, nim : reference type (String adalah objek, nilainya berupa referensi)
 *  - nilai     : primitive type (double, nilainya disimpan langsung)
 */
public class Mahasiswa {
 
    // KONSTANTA (final)
    public static final double FINAL_PASSING_GRADE = 70.0;  // standar kelulusan
    public static final double NILAI_MIN = 0.0;
    public static final double NILAI_MAX = 100.0;
    private static final double BATAS_A = 85.0;
    private static final double BATAS_B = 75.0;
 
    // ATRIBUT
    private String nama;    // reference type
    private String nim;     // reference type
    private double nilai;   // primitive type
 
    // CONSTRUCTOR
    public Mahasiswa(String nama, String nim, double nilai) throws NilaiInvalidException {
        // Perapian String: trim() buang spasi di tepi, replaceAll rapatkan spasi ganda,
        // toUpperCase() jadikan huruf kapital
        this.nama = (nama == null) ? "" : nama.trim().replaceAll("\\s+", " ").toUpperCase();
        this.nim = (nim == null) ? "" : nim.trim();
 
        // ASSERTION: NIM tidak boleh kosong (aktif jika dijalankan dengan java -ea)
        assert !this.nim.isEmpty() : "NIM tidak boleh kosong!";
 
        // Pengaman tambahan karena assertion bisa saja dinonaktifkan saat runtime
        if (this.nama.isEmpty()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong");
        }
        if (!nimHanyaAngka(this.nim)) {
            throw new IllegalArgumentException("NIM harus berisi angka saja");
        }
 
        // CUSTOM EXCEPTION: nilai di luar 0..100 ditolak.
        // Ditulis dengan tanda "!" agar NaN (bukan angka) juga ikut ditolak.
        if (!(nilai >= NILAI_MIN && nilai <= NILAI_MAX)) {
            throw new NilaiInvalidException(nilai);
        }
        this.nilai = nilai;
    }
 
    // VALIDASI NIM (Character)
    public static boolean nimHanyaAngka(String nim) {
        if (nim == null || nim.isEmpty()) {
            return false;
        }
        for (int i = 0; i < nim.length(); i++) {
            if (!Character.isDigit(nim.charAt(i))) {   // cek tiap karakter
                return false;
            }
        }
        return true;
    }
 
    // GETTER
    public String getNama() {
        return nama;
    }
 
    public String getNim() {
        return nim;
    }
 
    public double getNilai() {
        return nilai;
    }
 
    // LOGIKA NILAI
    // If-else: petakan nilai ke grade huruf
    public char getGrade() {
        char grade;
        if (nilai >= BATAS_A) {
            grade = 'A';
        } else if (nilai >= BATAS_B) {
            grade = 'B';
        } else if (nilai >= FINAL_PASSING_GRADE) {
            grade = 'C';
        } else {
            grade = 'D';
        }
        return grade;
    }
 
    // boolean (primitive): status kelulusan
    public boolean isLulus() {
        return nilai >= FINAL_PASSING_GRADE;
    }
 
    // Switch-case: keterangan berdasarkan grade
    public String getKeterangan() {
        String keterangan;
        switch (getGrade()) {
            case 'A':
                keterangan = "Sangat Baik";
                break;
            case 'B':
                keterangan = "Baik";
                break;
            case 'C':
                keterangan = "Cukup";
                break;
            default:
                keterangan = "Kurang";
                break;
        }
        return keterangan;
    }
 
    @Override
    public String toString() {
        return String.format(Locale.US, "%s (%s) - %.2f [%c, %s]",
                nama, nim, nilai, getGrade(), isLulus() ? "Lulus" : "Tidak Lulus");
    }
}