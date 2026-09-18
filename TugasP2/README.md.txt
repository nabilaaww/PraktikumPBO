# 📚 Laporan Praktikum Pemrograman Berorientasi Objek (PBO)
**Modul 01 - Class, Object, Method, Package, Constructor, Variable**

---

## 👤 Identitas
* **Nama** : Nabila Salma Az Zahra[cite: 10]
* **NIM** : L0325031[cite: 10]
* **Prodi** : Informatika PSDKU Kebumen[cite: 10]
* **Instansi** : Universitas Sebelas Maret[cite: 10]

---

## 🚀 Fitur Utama
* Pengelolaan data siswa berbasis Objek (`Class Student`)[cite: 10].
* Pengisian data otomatis menggunakan `Constructor`[cite: 10].
* Evaluasi kelulusan otomatis menggunakan method `checkPassed()` dengan kriteria nilai minimal 70[cite: 10].
* Penerimaan input dinamis menggunakan `Scanner` dan penampungan data berbasis `Array of Objects`[cite: 10].
* Kalkulasi total nilai, rerata kelas, serta rekapitulasi jumlah siswa lulus dan tidak lulus[cite: 10].

---

## 💻 Penjelasan Kode
Program ini dibangun menggunakan paradigma Pemrograman Berorientasi Objek dengan dua class utama, yaitu `Student` dan `Main`[cite: 10]. Class `Student` berfungsi sebagai blueprint yang menyimpan variabel nama, nilai, serta status kelulusan[cite: 10]. Di dalam class ini terdapat constructor untuk menginisialisasi nama dan nilai saat objek dibuat, serta method `checkPassed()` yang berisi logika kondisional `if-else` untuk menentukan apakah siswa lulus atau tidak berdasarkan ambang batas nilai 70[cite: 10]. 

Pada class `Main`, program menggunakan objek `Scanner` untuk meminta pengguna memasukkan jumlah siswa yang akan didata[cite: 10]. Berdasarkan jumlah tersebut, sebuah `Array of Objects` dibuat untuk menyimpan setiap instance `Student`[cite: 10]. Melalui perulangan `for`, program mengumpulkan data nama dan nilai tiap siswa, mengevaluasi status kelulusannya, menjumlahkan akumulasi nilai, serta menampilkan rekapitulasi data hasil pengolahan ke layar secara terstruktur[cite: 10].

---

## 📊 Penjelasan Hasil
Berdasarkan uji coba program dengan memasukkan data tiga orang siswa (Alice dengan nilai 85, Bob dengan nilai 60, dan Charlie dengan nilai 75), program berhasil mengolah data secara tepat[cite: 10]. Alice dan Charlie ditetapkan berstatus **Lulus** karena nilainya memenuhi syarat batas minimal ($\ge 70$), sedangkan Bob berstatus **Tidak Lulus** karena nilainya di bawah syarat[cite: 10]. Program kemudian menghitung total nilai seluruh siswa dan menghasilkan rata-rata nilai kelas sebesar **73.33**[cite: 10]. Hasil rekapitulasi akhir juga secara akurat menampilkan jumlah siswa lulus sebanyak **2 orang** dan siswa tidak lulus sebanyak **1 orang**[cite: 10].

---

## 📝 Kesimpulan
Praktikum ini memberikan pemahaman mendalam mengenai penerapan konsep dasar Object-Oriented Programming (OOP) pada bahasa Java, khususnya penggunaan class, object, constructor, method, dan variabel[cite: 10]. Penerapan struktur array of objects yang dikombinasikan dengan perulangan dan kondisional terbukti efektif untuk mengelola serta mengolah data dalam jumlah banyak secara terstruktur dan otomatis[cite: 10].