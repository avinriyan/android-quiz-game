package com.example.asus.kuis;

/**
 * Created by asus on 15/05/2017.
 */

public class Soal {

    public String Soal[] = {
            "Ibu kota negara Perancis adalah",
            "Satuan SI untuk Arus Listrik",
            "2,3,5,7,11,13,17,...,23",
            "Blue(english) = ...(bahasa)",
            "16 + 2 * 2=",
            "Mata uang negara Indonesia",
            "A=5, B=4, A+B*A=",
            "Rumus mencari luas balok",
            "Yang tidak termasuk software Microsoft Office",
            "1 jam = ... detik",
    };

    private String Pilihan[][] = {
            {"London", "Bern", "Paris", "Amsterdam"},
            {"Ohm", "Volt", "Ampere", "Watt"},
            {"18", "19", "21", "23"},
            {"Red", "Gray", "Blue", "Green"},
            {"36", "20", "26", "30"},
            {"Dollar", "Euro", "Yen", "Rupiah"},
            {"45", "35", "25", "15"},
            {"sisi*sisi*sisi", "panjang*lebar", "alas*tinggi*0.5", "panjang*lebar*tinggi"},
            {"Word", "Excel", "Photoshop", "Powerpoint"},
            {"60", "600", "360", "3600"},
    };

    private String Jawaban[] = {"Paris","Ampere","19","Blue","20","Rupiah","25","panjang*lebar*tinggi","Photoshop","3600"};

    public String Koreksi(int a){
        String soal = Soal[a];
        return soal;
    }

    public String Milih1(int a){
        String pilihan = Pilihan[a][0];
        return pilihan;
    }
    public String Milih2(int a){
        String pilihan = Pilihan[a][1];
        return pilihan;
    }
    public String Milih3(int a){
        String pilihan = Pilihan[a][2];
        return pilihan;
    }
    public String Milih4(int a){
        String pilihan = Pilihan[a][3];
        return pilihan;
    }

    public String JawabanBener(int a){
        String jawaban = Jawaban[a];
        return jawaban;
    }


    public String Soal2[] = {
            "Tidur (bahasa inggris)",
            "5+4",
            "7*8",
            "Ibu kota negara Jepang",
            "bulan ke 5",
            "satuan panjang",
            "5-2",
            "Warna #ffffff",
            "10*10",
            "60/5",
    };


    private String Jawaban2[] = {"Sleep","9","56","Tokyo","Mei","Meter","3","Putih","100","12"};

    public String Koreksi2(int a){
        String soal2 = Soal2[a];
        return soal2;
    }

    public String JawabanBener2(int a){
        String jawaban2 = Jawaban2[a];
        return jawaban2;
    }

    public String Soal3[] = {
            "1+1=2",
            "1+1=1",
            "Bulan ke-8 adalah Agustus",
            "Bulan ke-6 adalah Juli",
            "Madrid adalah ibukota negara spanyol",
            "Milan adalah ibukota negara Italia",
            "Mata uang Malaysia adalah Ringgit",
            "Ibu kota provinsi Jawa Tengah adalah Solo ",
            "Bandung ada di Jawa Barat",
            "22+3=21",
    };


    private String Jawaban3[] = {"Benar","Salah","Benar","Salah","Benar","Salah","Benar","Salah","Benar","Salah"};

    public String Koreksi3(int a){
        String soal3 = Soal3[a];
        return soal3;
    }

    public String JawabanBener3(int a){
        String jawaban3 = Jawaban3[a];
        return jawaban3;
    }
}
