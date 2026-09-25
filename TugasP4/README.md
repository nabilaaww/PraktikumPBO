# Praktikum Pemrograman Berorientasi Objek

## Modul 04 – Class, Object, Method, Package, Constructor, Variabel, Tipe Data, Struktur Kontrol, dan Fitur Java

**Nama:** Nabila Salma Az Zahra<br>
**NIM:** L0325031<br>
**Program Studi:** Informatika PSDKU Kebumen<br>
**Fakultas:** Teknologi Informasi dan Sains Data<br>
**Universitas Sebelas Maret**<br>
**Tahun: 2026**

---

## 1. Deskripsi Praktikum

Praktikum ini merupakan implementasi **Pemrograman Berorientasi Objek (Object-Oriented Programming/OOP)** menggunakan bahasa pemrograman Java. Materi yang dipelajari meliputi konsep dasar OOP **(Class, Object, Method, Package, Constructor, Variabel), Tipe Data (Primitive & Reference), Struktur Kontrol (Kondisional & Looping), serta Fitur Java (Exception Handling, Assertion, Manipulasi Character, dan String)**.
Sebagai penerapan dari materi tersebut, dibuat sebuah program aplikasi Sistem Manajemen Perpustakaan Mini. Program tidak hanya menangani proses CRUD dasar dan transaksi peminjaman/pengembalian buku, tetapi juga melakukan analisis sederhana terhadap koleksi buku dan aktivitas peminjaman anggota.
Praktikum ini bertujuan agar seluruh konsep OOP dan fitur-fitur Java dapat dipahami secara komprehensif serta diterapkan dalam pembuatan sistem aplikasi berarsitektur rapi berbasis package.

---

## 2. Tujuan Praktikum

Tujuan dari praktikum ini adalah:
1. Memahami konsep dasar **Object-Oriented Programming (OOP)**, khususnya class, object, method, package, constructor, dan variabel.
2. Memahami penerapan package untuk mengelompokkan class secara modular dan rapi (model, service, exception, main).
3. Memahami perbedaan serta penggunaan primitive data type dan reference data type (seperti ArrayList dan HashMap).
4. Menerapkan struktur kontrol berupa looping dan kondisional secara efektif dalam pemrosesan data.
5. Memahami dan mengimplementasikan Exception Handling melalui penggunaan custom exception untuk menangani alur error runtime.
6. Memahami dan mengimplementasikan Assertion untuk melakukan validasi state/data anggota sebelum transaksi dilakukan.
7. Menerapkan manipulasi String dan Character dalam proses pencarian data serta formatting.
7. Membangun interaksi pengguna berbasis CLI menggunakan Scanner dengan menu yang terstruktur.

---

## 3. Landasan Teori

### 3.1 Class & Object
Class merupakan template atau rancangan dasar yang mendefinisikan atribut (state) dan method (behavior) dari suatu entitas. Object merupakan instance atau wujud nyata yang dibuat berdasarkan rancangan class tersebut. Dalam aplikasi ini, class `Book` dan `Member` berfungsi sebagai rancangan untuk mencetak object buku dan anggota perpustakaan.

### 3.2 Atribut, Method, & Constructor
Atribut digunakan untuk menyimpan informasi atau state dari suatu object. Method merupakan fungsi di dalam class yang mendefinisikan aksi atau behavior yang dapat dilakukan oleh object. Constructor adalah method khusus yang dipanggil pertama kali saat pembuatannya untuk melakukan inisialisasi nilai awal variabel object.

### 3.3 Package
Package merupakan tempat untuk mengelompokkan class-class yang relevan agar kode program menjadi lebih rapi, modular, terorganisasi, dan terhindar dari konflik nama (*naming collision*).

### 3.4 Tipe Data: Primitive & Reference
* Tipe data primitive (seperti `int`, `boolean`, `char`) menyimpan nilai secara langsung pada memori stack.
* Tipe data reference (seperti `String`, `ArrayList`, `HashMap`) menyimpan alamat memori (referensi) yang menunjuk ke lokasi object sebenarnya pada memori heap.

### 3.5 Exception Handling
Exception handling adalah mekanisme untuk menangani kondisi error yang terjadi saat program berjalan (*runtime error*). Menggunakan blok `try-catch` beserta custom exception yang diturunkan dari class `Exception`, program dapat menangani error secara elegan tanpa mengalami crash mendadak.

### 3.6 Assertion
Assertion merupakan fitur Java (menggunakan keyword `assert`) yang digunakan untuk menguji asumsi/kondisi logika program saat fase pengembangan. Jika kondisi boolean pada assertion bernilai `false`, program akan melempar `AssertionError`.

### 3.7 Manipulasi Character & String
Java menyediakan method-method bawaan untuk mengolah teks pada tipe data `String` (seperti `toLowerCase()`, `contains()`, `equalsIgnoreCase()`) dan manipulasi karakter pada class `Character` (seperti `Character.isLetterOrDigit()`, `Character.toUpperCase()`).

---

## 4. Studi Kasus Praktikum

Pada praktikum ini dibuat aplikasi Java Sistem Manajemen Perpustakaan Mini. 
Sistem mengelola koleksi buku dan data anggota perpustakaan. Anggota dapat melakukan peminjaman dan pengembalian buku dengan batasan maksimal 3 buku dipinjam per anggota. Sistem menerapkan penanganan error jika buku tidak ditemukan (`BookNotFoundException`), jika peminjaman melebihi batas (`BorrowLimitExceededException`), atau jika status buku sedang dipinjam. Selain itu, sistem menyediakan fitur pencarian fleksibel, analisis aktivitas peminjaman, serta penyajian laporan otomatis mengenai total transaksi, kategori terbanyak, anggota paling aktif, dan buku terfavorit.

---

## 5. Struktur Program

Program disusun terpisah ke dalam struktur package yang rapi:
* **`library.model`**
  * `Book.java`: Menyiapkan atribut buku (judul, penulis, tahunTerbit, kategori, isAvailable, totalBorrowedCount).
  * `Member.java`: Menyiapkan atribut anggota (id, nama, daftarPinjaman).
* **`library.exception`**
  * `BookNotFoundException.java`: Custom exception saat buku tidak ditemukan.
  * `BorrowLimitExceededException.java`: Custom exception saat limit peminjaman dilampaui.
* **`library.service`**
  * `LibraryService.java`: Mengelola logika bisnis utama (pencarian, peminjaman, pengembalian, analisis laporan, dan manipulasi teks).
* **`library.main`**
  * `MainApp.java`: Class utama dengan method `main()` untuk menangani antarmuka CLI, perulangan menu, dan penerimaan input pengguna via `Scanner`.

---

## 6. Implementasi Konsep OOP dan Fitur Java

### 6.1 Class, Object, & Package
Diterapkan melalui pengelompokan class ke dalam package `library.model`, `library.service`, `library.exception`, dan `library.main`. Object dibuat dinamis untuk menampung setiap data buku dan anggota.

### 6.2 Constructor & Variabel
Class `Book` dan `Member` memiliki constructor untuk menginisialisasi atribut dasar. Program memanfaatkan variabel primitive (`int`, `boolean`) dan reference (`String`, `ArrayList<Book>`, `HashMap<String, Member>`).

### 6.3 Exception Handling & Assertion
Custom exception `BookNotFoundException` dan `BorrowLimitExceededException` dilempar saat terjadi pelanggaran aturan bisnis dan ditangkap oleh blok `try-catch` pada `MainApp`. Keyword `assert` digunakan di `LibraryService` untuk memastikan object `Member` bernilai valid (tidak null) sebelum transaksi diproses.

### 6.4 Manipulasi Character & String
Penggunaan method `toLowerCase()` dan `contains()` diterapkan pada fitur pencarian buku. Method `equalsIgnoreCase()` digunakan untuk verifikasi judul buku. Pengolahan karakter dilakukan menggunakan method `Character.isLetterOrDigit()` dan `Character.toUpperCase()`.

### 6.5 Struktur Kontrol (Looping & Kondisional)
Perulangan `while` digunakan untuk menjaga jalannya menu utama CLI, sedangkan `for-each` digunakan dalam penelusuran koleksi data `ArrayList` dan `HashMap`. Kondisional `if-else` dan `switch-case` diterapkan untuk percabangan alur logika bisnis dan pilihan menu.

---

## 7. Alur Kerja Program

Secara keseluruhan, program bekerja dengan urutan sebagai berikut:
1. Program dimulai dan melakukan pemuatan (*seeding*) data awal buku dan anggota.
2. Program menampilkan daftar pilihan menu interaktif CLI (1-7).
3. Pengguna memilih menu menggunakan input `Scanner`.
4. Jika memilih Tambah Buku/Daftar Buku, program akan memperbarui atau menampilkan isi `ArrayList<Book>`.
5. Jika memilih Cari Buku, program melakukan pemrosesan teks String (`toLowerCase()` & `contains()`) untuk mencocokkan kata kunci.
6. Jika memilih Pinjam/Kembalikan Buku, program memvalidasi kondisi anggota dengan `assert` dan memeriksa batasan melalui custom exception.
7. Jika memilih Laporan Perpustakaan, program melakukan kalkulasi looping & agregasi data dari `HashMap`.
8. Program terus berulang hingga pengguna memilih menu Keluar (7).
9. Program selesai.

---

## 8. Pengolahan Data dan Analisis

* **Pencarian Buku**: Pencarian tidak bersifat *exact match*, melainkan mencocokkan potongan kata kunci pada judul atau kategori dengan mengabaikan kapitalisasi huruf.
* **Validasi Transaksi**: Peminjaman diputus jika peminjaman anggota telah mencapai 3 buku, buku sedang dipinjam orang lain, atau ID anggota bernilai tidak valid.
* **Agregasi Laporan**: Program menghitung total frekuensi peminjaman koleksi, menentukan kategori buku terbanyak, mencari anggota paling aktif berdasarkan jumlah peminjaman, serta mengidentifikasi buku paling populer.

---

## 9. Contoh Hasil Program

Sebagai contoh pengujian sistem:
* Didaftarkan anggota `M01` (Budi Santoso).
* Disediakan buku "Pemrograman Java", "Struktur Data", dan "Laskar Pelangi".
* Ketika `M01` meminjam buku "Pemrograman Java", status buku berubah menjadi *Dipinjam* dan jumlah peminjaman buku tersebut bertambah.
* Jika pengguna mencari dengan kata kunci `"java"`, sistem berhasil menampilkan buku "Pemrograman Java".
* Apabila dilakukan peminjaman ke-4 oleh anggota yang sama, sistem secara otomatis menangkap error: `Gagal Pinjam: Anggota telah mencapai batas maksimal 3 peminjaman.`

---

## 10. Analisis Hasil Praktikum

Program berhasil menerapkan seluruh konsep OOP beserta fitur-fitur pendukung Java secara padu. Pemisahan class berdasarkan struktur package membuat kode menjadi sangat rapi dan mudah dirawat. Penerapan custom exception terbukti mampu mencegah penghentian program secara mendadak saat terjadi *runtime error*. Penggunaan assertion membantu memvalidasi integritas data sebelum transaksi dieksekusi. Pengolahan koleksi menggunakan `ArrayList` dan `HashMap` memudahkan manipulasi data secara dinamis dibandingkan array konvensional.

---

## 11. Teknologi yang Digunakan

Teknologi dan konsep yang digunakan dalam praktikum ini meliputi:
* **Bahasa Pemrograman:** Java
* **Java Development Kit (JDK) & IDE:** NetBeans
* **Konsep Pemrograman:** Object-Oriented Programming (OOP)
* **Data Types:** Primitive (`int`, `boolean`) & Reference (`String`, `ArrayList`, `HashMap`)
* **Advanced Features:** Custom Exception, Assertion (`-ea`), Character & String Manipulation
* **Control Flow:** `switch-case`, `if-else`, `while-loop`, `for-each`
* **Input Handling:** `java.util.Scanner`

---

## 12. Kesimpulan

Berdasarkan praktikum yang telah dilakukan, aplikasi Sistem Manajemen Perpustakaan Mini berbasis Java berhasil dibangun dengan menerapkan seluruh konsep Pemrograman Berorientasi Objek dan fitur-fitur standar bahasa Java.
Penerapan struktur package terbukti memberikan arsitektur program yang terorganisasi. Penggunaan custom exception dan assertion meningkatkan ketahanan (*robustness*) serta keamanan logika program. Penggabungan berbagai tipe data reference, perulangan, kondisional, manipulasi string, dan antarmuka input `Scanner` menghasilkan aplikasi perpustakaan interaktif yang mampu mengolah data serta menyajikan analisis secara terstruktur.

---

## 13. Identitas Praktikum

**Mata Kuliah:** Pemrograman Berorientasi Objek<br>
**Modul:** 04<br>
**Materi:** Class, Object, Method, Package, Constructor, Variabel, Tipe Data, Struktur Kontrol, dan Fitur Java<br>
**Nama:** Nabila Salma Az Zahra<br>
**NIM:** L0325031<br>
**Asisten Praktikum :** Hammam Ibnu Adi Abdillah<br>
**NIM Asisten :** L0324015<br>
**Asisten Praktikum :** Muhammad Ihsaan Al Fikri<br>
**NIM Asisten :** L0324024<br>
**Program Studi:** Informatika PSDKU Kebumen<br>
**Universitas:** Universitas Sebelas Maret<br>
**Tahun:** 2026