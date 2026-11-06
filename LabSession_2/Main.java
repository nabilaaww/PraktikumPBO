/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labsession2;

/**
 *
 * @author LENOVO
 */
import java.util.ArrayList;
import java.util.Locale;

/*
 * STUDI KASUS : SISTEM PENGGAJIAN KARYAWAN PERUSAHAAN
 * Perusahaan memiliki beberapa jenis karyawan (Manajer, Programmer, Magang).
 * Setiap jenis karyawan punya cara berbeda dalam menghitung gaji dan
 * dapat dinilai kinerjanya.
 *
 * Hubungan logis:
 *  - Superclass (abstract) : Karyawan  -> "karyawan" adalah konsep umum
 *  - Subclass              : Manajer, Programmer, Magang -> jenis khusus karyawan
 *  - Interface             : PenilaianKinerja -> kemampuan untuk dinilai kinerjanya
 *
 * File ini berisi 6 tipe: PenilaianKinerja (interface), Karyawan (abstract),
 * Manajer, Programmer, Magang, dan Main.
 */

// POIN 5: INTERFACE
// Kontrak yang harus dipenuhi oleh setiap class yang mengimplementasikannya
interface PenilaianKinerja {
    int SKOR_MINIMAL = 70;        // konstanta interface: batas skor "layak"

    int hitungSkor();             // method kontrak 1
    String getPredikat();         // method kontrak 2
}

// POIN 4: ABSTRACT CLASS (SUPERCLASS)
abstract class Karyawan {

    // POIN 1: ENCAPSULATION
    // Atribut dibuat private, hanya bisa diakses lewat getter/setter
    private String id;
    private String nama;
    private double gajiPokok;

    // Constructor superclass (akan dipanggil oleh subclass lewat super())
    public Karyawan(String id, String nama, double gajiPokok) {
        this.id = id;
        setNama(nama);            // validasi tetap lewat setter
        setGajiPokok(gajiPokok);
    }

    // Getter
    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public double getGajiPokok() {
        return gajiPokok;
    }

    // Setter (dengan validasi)
    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong");
        }
        this.nama = nama;
    }

    public void setGajiPokok(double gajiPokok) {
        if (gajiPokok < 0) {
            throw new IllegalArgumentException("Gaji pokok tidak boleh negatif");
        }
        this.gajiPokok = gajiPokok;
    }

    //  POIN 4: ABSTRACT METHOD
    // Tidak punya isi, WAJIB diimplementasikan oleh subclass
    public abstract double hitungGaji();

    public abstract String getJabatan();

    // POIN 3: METHOD OVERLOADING
    // Nama method sama (hitungGaji) tetapi parameter berbeda
    public double hitungGaji(double bonus) {
        return hitungGaji() + bonus;
    }

    public double hitungGaji(double bonus, double potongan) {
        return hitungGaji() + bonus - potongan;
    }

    // Method biasa (non-abstract) yang nanti di-override oleh subclass
    public void tampilkanInfo() {
        System.out.println("ID         : " + id);
        System.out.println("Nama       : " + nama);
        System.out.println("Jabatan    : " + getJabatan());
        System.out.println("Gaji       : " + rupiah(hitungGaji()));
    }

    // Method bantu untuk format rupiah
    public static String rupiah(double nilai) {
        return String.format(Locale.forLanguageTag("id-ID"), "Rp %,.0f", nilai);
    }

    // Method bantu untuk mengubah skor menjadi predikat
    protected static String konversiPredikat(int skor) {
        if (skor >= 90) {
            return "Sangat Baik";
        } else if (skor >= PenilaianKinerja.SKOR_MINIMAL) {
            return "Baik";
        } else {
            return "Perlu Ditingkatkan";
        }
    }
}

// POIN 2: INHERITANCE (SUBCLASS 1)
// extends = pewarisan dari Karyawan, implements = memenuhi kontrak PenilaianKinerja
class Manajer extends Karyawan implements PenilaianKinerja {

    private double tunjanganJabatan;
    private int jumlahBawahan;
    private static final double INSENTIF_PER_BAWAHAN = 250000;

    public Manajer(String id, String nama, double gajiPokok,
                   double tunjanganJabatan, int jumlahBawahan) {
        super(id, nama, gajiPokok);   // POIN 2: pemanggilan constructor superclass
        setTunjanganJabatan(tunjanganJabatan);
        setJumlahBawahan(jumlahBawahan);
    }

    // Getter & setter
    public double getTunjanganJabatan() {
        return tunjanganJabatan;
    }

    public void setTunjanganJabatan(double tunjanganJabatan) {
        if (tunjanganJabatan < 0) {
            throw new IllegalArgumentException("Tunjangan tidak boleh negatif");
        }
        this.tunjanganJabatan = tunjanganJabatan;
    }

    public int getJumlahBawahan() {
        return jumlahBawahan;
    }

    public void setJumlahBawahan(int jumlahBawahan) {
        if (jumlahBawahan < 0) {
            throw new IllegalArgumentException("Jumlah bawahan tidak boleh negatif");
        }
        this.jumlahBawahan = jumlahBawahan;
    }

    // POIN 3 & 4: overriding sekaligus implementasi abstract method
    @Override
    public double hitungGaji() {
        return getGajiPokok() + tunjanganJabatan + (jumlahBawahan * INSENTIF_PER_BAWAHAN);
    }

    @Override
    public String getJabatan() {
        return "Manajer";
    }

    // POIN 3: overriding method milik superclass
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Bawahan    : " + jumlahBawahan + " orang");
    }

    // POIN 5: memenuhi kontrak interface
    @Override
    public int hitungSkor() {
        return Math.min(100, 70 + jumlahBawahan * 3);
    }

    @Override
    public String getPredikat() {
        return konversiPredikat(hitungSkor());
    }
}

// POIN 2: INHERITANCE (SUBCLASS 2)
class Programmer extends Karyawan implements PenilaianKinerja {

    private int jumlahProyek;
    private int jamLembur;
    private static final double BONUS_PER_PROYEK = 1000000;
    private static final double TARIF_LEMBUR = 50000;

    public Programmer(String id, String nama, double gajiPokok,
                      int jumlahProyek, int jamLembur) {
        super(id, nama, gajiPokok);
        setJumlahProyek(jumlahProyek);
        setJamLembur(jamLembur);
    }

    public int getJumlahProyek() {
        return jumlahProyek;
    }

    public void setJumlahProyek(int jumlahProyek) {
        if (jumlahProyek < 0) {
            throw new IllegalArgumentException("Jumlah proyek tidak boleh negatif");
        }
        this.jumlahProyek = jumlahProyek;
    }

    public int getJamLembur() {
        return jamLembur;
    }

    public void setJamLembur(int jamLembur) {
        if (jamLembur < 0) {
            throw new IllegalArgumentException("Jam lembur tidak boleh negatif");
        }
        this.jamLembur = jamLembur;
    }

    @Override
    public double hitungGaji() {
        return getGajiPokok() + (jumlahProyek * BONUS_PER_PROYEK) + (jamLembur * TARIF_LEMBUR);
    }

    @Override
    public String getJabatan() {
        return "Programmer";
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Proyek     : " + jumlahProyek + " proyek, lembur " + jamLembur + " jam");
    }

    @Override
    public int hitungSkor() {
        return Math.min(100, 50 + jumlahProyek * 10);
    }

    @Override
    public String getPredikat() {
        return konversiPredikat(hitungSkor());
    }
}

// POIN 2: INHERITANCE (SUBCLASS 3)
class Magang extends Karyawan implements PenilaianKinerja {

    private int lamaMagangBulan;
    private int hariHadir;
    private static final double TRANSPORT_PER_HARI = 20000;

    public Magang(String id, String nama, double uangSaku,
                  int lamaMagangBulan, int hariHadir) {
        super(id, nama, uangSaku);    // gajiPokok di sini berarti uang saku
        setLamaMagangBulan(lamaMagangBulan);
        setHariHadir(hariHadir);
    }

    public int getLamaMagangBulan() {
        return lamaMagangBulan;
    }

    public void setLamaMagangBulan(int lamaMagangBulan) {
        if (lamaMagangBulan < 0) {
            throw new IllegalArgumentException("Lama magang tidak boleh negatif");
        }
        this.lamaMagangBulan = lamaMagangBulan;
    }

    public int getHariHadir() {
        return hariHadir;
    }

    public void setHariHadir(int hariHadir) {
        if (hariHadir < 0) {
            throw new IllegalArgumentException("Hari hadir tidak boleh negatif");
        }
        this.hariHadir = hariHadir;
    }

    @Override
    public double hitungGaji() {
        return getGajiPokok() + (hariHadir * TRANSPORT_PER_HARI);
    }

    @Override
    public String getJabatan() {
        return "Karyawan Magang";
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Magang     : " + lamaMagangBulan + " bulan, hadir " + hariHadir + " hari");
    }

    @Override
    public int hitungSkor() {
        return Math.min(100, 40 + hariHadir * 2);
    }

    @Override
    public String getPredikat() {
        return konversiPredikat(hitungSkor());
    }
}

// CLASS MAIN
public class Main {
    public static void main(String[] args) {

        // POIN 3: RUNTIME POLYMORPHISM
        // Object subclass disimpan dalam referensi superclass (Karyawan)
        ArrayList<Karyawan> daftar = new ArrayList<>();
        daftar.add(new Manajer("K001", "Andi Wijaya", 12000000, 3000000, 5));
        daftar.add(new Programmer("K002", "Siti Rahma", 8000000, 3, 10));
        daftar.add(new Programmer("K003", "Budi Hartono", 7500000, 1, 4));
        daftar.add(new Magang("K004", "Dewi Lestari", 2000000, 3, 25));
        daftar.add(new Magang("K005", "Rizky Fadhil", 1500000, 2, 15));

        System.out.println("========== DAFTAR KARYAWAN (Runtime Polymorphism) ==========");
        for (Karyawan k : daftar) {
            // Method yang dipanggil mengikuti jenis object aslinya, bukan tipe referensinya
            k.tampilkanInfo();
            System.out.println("------------------------------------------------------------");
        }

        // POIN 3: METHOD OVERLOADING
        System.out.println("\n========== DEMO METHOD OVERLOADING ==========");
        Karyawan contoh = daftar.get(0);
        System.out.println("Karyawan                         : " + contoh.getNama());
        System.out.println("hitungGaji()                     : " + Karyawan.rupiah(contoh.hitungGaji()));
        System.out.println("hitungGaji(bonus 2 jt)           : " + Karyawan.rupiah(contoh.hitungGaji(2000000)));
        System.out.println("hitungGaji(bonus 2 jt, pot 500rb): " + Karyawan.rupiah(contoh.hitungGaji(2000000, 500000)));

        // POIN 5: PENGGUNAAN INTERFACE
        System.out.println("\n========== PENILAIAN KINERJA (Interface) ==========");
        for (Karyawan k : daftar) {
            if (k instanceof PenilaianKinerja) {
                PenilaianKinerja penilaian = (PenilaianKinerja) k;
                String keterangan = (penilaian.hitungSkor() >= PenilaianKinerja.SKOR_MINIMAL)
                        ? "LAYAK" : "BELUM LAYAK";
                System.out.println(k.getNama() + " -> skor " + penilaian.hitungSkor()
                        + " (" + penilaian.getPredikat() + ") : " + keterangan + " dapat apresiasi");
            }
        }

        // POIN 1: DEMO ENCAPSULATION
        System.out.println("\n========== DEMO ENCAPSULATION ==========");
        Karyawan budi = daftar.get(2);
        System.out.println("Gaji pokok Budi sebelum : " + Karyawan.rupiah(budi.getGajiPokok()));

        try {
            budi.setGajiPokok(-5000000);   // data tidak valid, ditolak oleh setter
        } catch (IllegalArgumentException e) {
            System.out.println("Perubahan ditolak       : " + e.getMessage());
        }

        budi.setGajiPokok(8000000);        // data valid, diterima lewat setter
        System.out.println("Gaji pokok Budi sesudah : " + Karyawan.rupiah(budi.getGajiPokok()));
        System.out.println("Total gaji Budi sekarang: " + Karyawan.rupiah(budi.hitungGaji()));

        // TOTAL PENGELUARAN GAJI
        double totalGaji = 0;
        for (Karyawan k : daftar) {
            totalGaji += k.hitungGaji();
        }
        System.out.println("\nTotal pengeluaran gaji " + daftar.size() + " karyawan: " + Karyawan.rupiah(totalGaji));
    }
}