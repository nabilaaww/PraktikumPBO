# Praktikum Pemrograman Berorientasi Objek

## Modul 01 – Class, Object, Method, Package, Constructor, dan Variable

**Nama:** Nabila Salma Az Zahra
**NIM:** L0325031
**Program Studi:** Informatika PSDKU Kebumen
**Fakultas:** Teknologi Informasi dan Sains Data
**Universitas Sebelas Maret**
**Tahun:** 2026

---

## 1. Deskripsi Praktikum

Praktikum ini merupakan implementasi dasar **Pemrograman Berorientasi Objek (Object-Oriented Programming/OOP)** menggunakan bahasa pemrograman Java. Materi yang dipelajari meliputi konsep **class, object, method, package, constructor, dan variable**.

Sebagai penerapan dari materi tersebut, dibuat sebuah program sederhana untuk mengelola data nilai siswa dalam sebuah kelas. Program dapat menerima data beberapa siswa, menyimpan data tersebut dalam objek, menentukan status kelulusan berdasarkan nilai, menghitung rata-rata nilai kelas, serta menampilkan jumlah siswa yang lulus dan tidak lulus.

Praktikum ini bertujuan agar konsep OOP tidak hanya dipahami secara teori, tetapi juga dapat diterapkan dalam pembuatan program Java sederhana.

---

## 2. Tujuan Praktikum

Tujuan dari praktikum ini adalah:

1. Memahami konsep dasar **Object-Oriented Programming (OOP)**, khususnya class dan object.
2. Memahami class sebagai template atau rancangan dasar yang digunakan untuk membuat object.
3. Memahami object sebagai instance dari sebuah class serta hubungan antara atribut dan method.
4. Memahami penggunaan package untuk mengelompokkan class agar program lebih rapi dan mudah dikelola.
5. Memahami penggunaan constructor untuk memberikan nilai awal pada atribut object.
6. Memahami variable sebagai tempat untuk menyimpan data yang menjadi ciri atau keadaan sebuah object.
7. Mengenal jenis variable, seperti instance variable, class variable, local variable, dan parameter variable.
8. Menerapkan konsep class, object, package, constructor, dan variable dalam program Java.

---

## 3. Landasan Teori

### 3.1 Class

Class merupakan template atau rancangan dasar yang digunakan untuk membuat object. Class mendefinisikan sifat umum atau **atribut** dan kemampuan atau **method** yang dimiliki oleh object.

Sebagai contoh, class `Smartphone` dapat digunakan sebagai rancangan untuk berbagai object smartphone, seperti iPhone 15, Samsung Galaxy S24, Google Pixel 9, dan Xiaomi 14. Atribut yang dapat dimiliki antara lain merk, model, ukuran layar, kapasitas baterai, warna, dan harga.

Dengan demikian, class dapat diibaratkan sebagai rancangan yang menentukan karakteristik dan kemampuan object yang dibuat berdasarkan class tersebut.

### 3.2 Object

Object merupakan instance atau hasil pembuatan dari sebuah class. Setiap object memiliki atribut dan method yang telah ditentukan oleh class.

Atribut menggambarkan keadaan atau **state** dari object, sedangkan method menggambarkan perilaku atau **behavior** object. Dalam Java, object dibuat berdasarkan suatu class dan dapat memiliki nilai atribut yang berbeda dengan object lainnya meskipun berasal dari class yang sama.

### 3.3 Atribut dan Method

Atribut digunakan untuk menyimpan data atau keadaan yang dimiliki oleh object. Pada contoh Smartphone, atribut dapat berupa merk, model, ukuran layar, kapasitas baterai, warna, dan harga.

Sementara itu, method digunakan untuk menunjukkan kemampuan atau perilaku object. Contohnya adalah mengambil foto, merekam video, melakukan panggilan, dan mengisi daya.

Jadi, atribut berfungsi menyimpan **state**, sedangkan method digunakan untuk menunjukkan **behavior** dari sebuah object.

### 3.4 Package

Package merupakan tempat untuk mengelompokkan class, interface, dan sub-package agar kode program menjadi lebih terorganisasi.

Penggunaan package membantu program menjadi lebih rapi, menghindari konflik nama class, dan mendukung modularitas. Dengan adanya package, class dapat dikelompokkan berdasarkan fungsi atau bagian tertentu dari program.

### 3.5 Constructor

Constructor merupakan method khusus yang otomatis dijalankan ketika sebuah object dibuat. Constructor digunakan untuk memberikan nilai awal atau melakukan inisialisasi terhadap atribut object.

Pada class Smartphone, misalnya, constructor dapat digunakan untuk memberikan nilai awal pada merk, model, dan harga. Dengan demikian, object dapat langsung memiliki data ketika pertama kali dibuat.

### 3.6 Variable

Variable merupakan wadah yang digunakan untuk menyimpan data dalam program. Dalam OOP, variable dapat digunakan untuk menyimpan informasi yang menjadi ciri atau keadaan dari suatu object.

Beberapa jenis variable yang dipelajari dalam praktikum ini adalah:

* **Instance variable**, yaitu variable yang dimiliki oleh setiap object dan nilainya dapat berbeda.
* **Class variable**, yaitu variable yang digunakan bersama oleh object dalam satu class dan menggunakan `static`.
* **Local variable**, yaitu variable yang dibuat di dalam method atau bagian tertentu dan hanya dapat digunakan pada bagian tersebut.
* **Parameter variable**, yaitu variable yang menerima nilai ketika method atau constructor dipanggil.

### 3.7 Hubungan Konsep OOP

Class, object, method, package, constructor, dan variable merupakan konsep yang saling berhubungan.

Class digunakan sebagai rancangan untuk membuat object. Object merupakan instance dari class yang memiliki atribut dan method. Constructor digunakan ketika object dibuat untuk memberikan nilai awal. Variable digunakan untuk menyimpan data, sedangkan package digunakan untuk mengelompokkan bagian program agar lebih teratur dan mudah dikelola.

Pemahaman hubungan antar konsep tersebut menjadi dasar dalam membuat program Java dengan pendekatan OOP.

---

## 4. Studi Kasus Praktikum

Pada praktikum ini dibuat program Java untuk **mengelola data nilai siswa dalam sebuah kelas**.

Program dirancang agar pengguna dapat memasukkan beberapa data siswa. Setiap siswa memiliki nama, nilai, dan status kelulusan. Setelah seluruh data dimasukkan, program melakukan proses pengecekan kelulusan, menghitung total nilai, menghitung rata-rata nilai kelas, serta menghitung jumlah siswa yang lulus dan tidak lulus.

Batas nilai kelulusan yang digunakan adalah **70**. Siswa dengan nilai lebih besar atau sama dengan 70 dinyatakan lulus, sedangkan siswa dengan nilai di bawah 70 dinyatakan tidak lulus.

---

## 5. Struktur Program

Program terdiri dari dua class utama, yaitu:

### Student

Class `Student` digunakan untuk merepresentasikan data dari setiap siswa. Class ini memiliki tiga variable utama:

* `name` untuk menyimpan nama siswa.
* `score` untuk menyimpan nilai siswa.
* `passed` untuk menyimpan status kelulusan siswa.

Class ini juga memiliki constructor untuk mengisi nama dan nilai siswa serta method `checkPassed()` untuk menentukan status kelulusan.

### Main

Class `Main` digunakan sebagai tempat utama program dijalankan melalui method `main()`.

Class ini bertanggung jawab terhadap proses input data, pembuatan array object Student, pengecekan kelulusan, pengolahan nilai, dan penampilan hasil program.

---

## 6. Implementasi Konsep OOP

### 6.1 Class dan Object

Konsep class diterapkan melalui class `Student` yang berfungsi sebagai rancangan untuk data siswa. Dari class tersebut kemudian dibuat beberapa object Student berdasarkan jumlah siswa yang dimasukkan oleh pengguna.

Setiap object menyimpan data siswa masing-masing sehingga data satu siswa dapat dikelola secara terpisah dari siswa lainnya.

### 6.2 Constructor

Constructor pada class Student digunakan untuk mengisi nama dan nilai ketika object siswa dibuat. Constructor menerima data nama dan nilai sebagai parameter, kemudian menyimpannya sebagai data milik object.

Variable `passed` diberikan nilai awal `false` dan akan diperbarui setelah proses pengecekan kelulusan dilakukan.

### 6.3 Method

Method `checkPassed()` digunakan untuk menentukan status kelulusan siswa.

Proses penentuan dilakukan menggunakan kondisi nilai:

* Nilai **≥ 70** → siswa dinyatakan **Lulus**.
* Nilai **< 70** → siswa dinyatakan **Tidak Lulus**.

Dengan adanya method tersebut, proses pengecekan status siswa dapat dilakukan berdasarkan data nilai yang dimiliki masing-masing object.

### 6.4 Variable dan Data Type

Program menggunakan beberapa jenis data type sesuai kebutuhan data.

Variable `name` menggunakan `String` untuk menyimpan nama siswa. Variable `score` menggunakan `double` untuk menyimpan nilai siswa, sedangkan `passed` menggunakan `boolean` untuk menyimpan status kelulusan.

Selain itu, program menggunakan `int` untuk menyimpan jumlah siswa dan berbagai perhitungan jumlah siswa. Penggunaan data type yang sesuai membuat setiap data dapat disimpan dan diproses sesuai kebutuhannya.

### 6.5 Array Object

Program menggunakan array untuk menyimpan beberapa object Student.

Ukuran array ditentukan berdasarkan jumlah siswa yang dimasukkan oleh pengguna. Sebagai contoh, jika pengguna memasukkan tiga siswa, maka array digunakan untuk menyimpan tiga object Student.

### 6.6 Scanner

Program menggunakan Scanner untuk menerima input dari pengguna melalui keyboard.

Input yang diterima meliputi jumlah siswa, nama siswa, dan nilai siswa. Penggunaan Scanner membuat program dapat menerima data secara langsung ketika program dijalankan.

### 6.7 For Loop

For loop digunakan untuk melakukan proses berulang terhadap data siswa.

Loop digunakan untuk memasukkan data setiap siswa, membuat object Student, mengecek status kelulusan, dan melakukan pengolahan data. Jumlah pengulangan disesuaikan dengan jumlah siswa yang dimasukkan pengguna.

### 6.8 Kondisional

Kondisional if-else digunakan untuk menentukan apakah seorang siswa lulus atau tidak lulus.

Jika nilai siswa memenuhi batas kelulusan, status `passed` menjadi benar. Jika tidak memenuhi batas tersebut, status menjadi salah. Kondisional juga digunakan ketika program menampilkan teks status dan menghitung jumlah siswa berdasarkan status kelulusannya.

---

## 7. Alur Kerja Program

Secara keseluruhan, program bekerja dengan urutan sebagai berikut:

1. Program dimulai.
2. Pengguna memasukkan jumlah siswa.
3. Program membuat array Student sesuai jumlah siswa.
4. Pengguna memasukkan nama dan nilai setiap siswa.
5. Program membuat object Student berdasarkan data yang dimasukkan.
6. Program mengecek status kelulusan setiap siswa.
7. Program menghitung total seluruh nilai siswa.
8. Program menentukan jumlah siswa yang lulus.
9. Program menentukan jumlah siswa yang tidak lulus.
10. Program menghitung rata-rata nilai kelas.
11. Program menampilkan data siswa dan hasil perhitungan.
12. Program selesai.

Alur tersebut menunjukkan bahwa setiap bagian program memiliki fungsi yang saling berhubungan, mulai dari proses input sampai menghasilkan informasi akhir.

---

## 8. Pengolahan Data

### Total Nilai

Total nilai diperoleh dengan menjumlahkan seluruh nilai siswa. Proses penjumlahan dilakukan terhadap nilai yang tersimpan pada setiap object Student.

### Rata-Rata Nilai

Rata-rata nilai kelas diperoleh dengan membagi total seluruh nilai dengan jumlah siswa.

Hasil rata-rata ditampilkan dengan dua angka di belakang koma agar lebih mudah dibaca.

### Jumlah Siswa Lulus dan Tidak Lulus

Program menghitung jumlah siswa yang lulus dan tidak lulus berdasarkan hasil pengecekan status masing-masing siswa.

Apabila status siswa adalah lulus, jumlah siswa lulus bertambah. Sebaliknya, apabila status siswa adalah tidak lulus, jumlah siswa tidak lulus bertambah.

---

## 9. Contoh Hasil Program

Sebagai contoh pengujian, digunakan tiga data siswa:

* Alice memperoleh nilai 85.
* Bob memperoleh nilai 60.
* Charlie memperoleh nilai 75.

Berdasarkan batas kelulusan 70, Alice dan Charlie dinyatakan lulus, sedangkan Bob dinyatakan tidak lulus.

Rata-rata nilai kelas dihitung dengan:

**(85 + 60 + 75) / 3 = 73,33**

Dengan demikian, dari tiga siswa tersebut terdapat dua siswa yang lulus dan satu siswa yang tidak lulus.

---

## 10. Analisis Hasil Praktikum

Program yang dibuat telah menerapkan beberapa konsep dasar Pemrograman Berorientasi Objek secara bersamaan. Class Student digunakan sebagai rancangan untuk menyimpan dan mengelola data siswa, sedangkan object Student digunakan untuk merepresentasikan setiap siswa.

Constructor membantu memberikan nilai awal pada object ketika data siswa dibuat. Method `checkPassed()` digunakan untuk memisahkan proses pengecekan kelulusan dari bagian utama program. Dengan demikian, setiap bagian memiliki fungsi yang jelas.

Penggunaan array object memungkinkan beberapa data siswa disimpan dalam satu struktur. Sementara itu, Scanner digunakan agar data dapat dimasukkan oleh pengguna secara langsung.

For loop membuat proses input dan pengolahan data dapat dilakukan secara berulang sesuai jumlah siswa. Kondisional if-else kemudian digunakan untuk menentukan status kelulusan berdasarkan nilai.

Dari hasil tersebut dapat dilihat bahwa konsep OOP dapat digunakan untuk membuat pengelolaan data menjadi lebih terstruktur. Data siswa, proses pengecekan, serta proses pengolahan nilai dapat dibagi berdasarkan fungsi masing-masing.

---

## 11. Teknologi yang Digunakan

Teknologi dan konsep yang digunakan dalam praktikum ini meliputi:

* **Bahasa Pemrograman:** Java
* **Konsep Pemrograman:** Object-Oriented Programming (OOP)
* **Class:** Student dan Main
* **Object:** Object Student
* **Constructor:** Inisialisasi data siswa
* **Method:** Pengecekan status kelulusan
* **Variable:** name, score, passed, dan variable pendukung lainnya
* **Array:** Penyimpanan beberapa object Student
* **Input:** Scanner
* **Perulangan:** For loop
* **Kondisional:** If-else

---

## 12. Kesimpulan

Berdasarkan praktikum yang telah dilakukan, program Java yang dibuat berhasil menerapkan konsep dasar Pemrograman Berorientasi Objek dalam pengelolaan data nilai siswa.

Class Student digunakan untuk merepresentasikan data setiap siswa, sedangkan object digunakan untuk menyimpan data siswa secara individual. Constructor digunakan untuk memberikan nilai awal berupa nama dan nilai siswa, sementara method checkPassed() digunakan untuk menentukan status kelulusan berdasarkan batas nilai 70.

Program juga menerapkan berbagai data type, array object, Scanner, for loop, dan kondisional if-else. Seluruh komponen tersebut digunakan untuk mendukung proses input, pengecekan kelulusan, perhitungan total dan rata-rata nilai, serta penghitungan jumlah siswa yang lulus dan tidak lulus.

Secara keseluruhan, praktikum ini memberikan pemahaman mengenai bagaimana konsep **class, object, constructor, method, variable, array, looping, kondisional, dan input menggunakan Scanner** dapat digunakan secara bersama-sama untuk membuat program Java yang terstruktur dan dapat digunakan untuk mengolah data siswa.

---

## 13. Identitas Praktikum

**Mata Kuliah:** Pemrograman Berorientasi Objek<br>
**Modul:** 01<br>
**Materi:** Class, Object, Method, Package, Constructor, Variable<br>
**Nama:** Nabila Salma Az Zahra<br>
**NIM:** L0325031<br>
**Asisten Praktikum :** Hammam Ibnu Adi Abdillah<br>
**NIM Asisten :** L0324015<br>
**Asisten Praktikum :** Muhammad Ihsaan Al Fikri<br>
**NIM Asisten :** L0324024<br>
**Program Studi:** Informatika PSDKU Kebumen<br>
**Universitas:** Universitas Sebelas Maret<br>
**Tahun:** 2026