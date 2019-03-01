package tictactoe;

import java.util.Scanner;

public class oyuncu {

    char oyuncuHarfi;
    boolean insanmiKontrol;
    static String koordinat;
    static String KullaniciAdi;

    public oyuncu() {
        this.oyuncuHarfi = 'X';
        this.insanmiKontrol = true;
    }

    public oyuncu(boolean insanmiKontrolu) {
        this.insanmiKontrol = insanmiKontrolu;
        if (this.insanmiKontrol == true) {
            this.oyuncuHarfi = 'X';
        } else {
            this.oyuncuHarfi = 'O';
        }
    }

    public oyuncu(boolean insanmiKontrolu, char oyuncuHarfi) {
        this.insanmiKontrol = insanmiKontrolu;
        this.oyuncuHarfi = oyuncuHarfi;
    }

    char karakteriAl() {
        return this.oyuncuHarfi;
    }

    boolean oyuncuTurunuAl() {
        return insanmiKontrol == true;
    }

    public String oyuncununHamlesiniAl() {
        if (insanmiKontrol == true) {
            koordinat = insanOyuncuHamlesiniKontrol();
        } else {
            koordinat = bilgisayarHamlesiUret();
        }
        return koordinat;
    }

    public String insanOyuncuHamlesiniKontrol() {
        Scanner verial = new Scanner(System.in);
        System.out.println("Hamle Yapmak İstediginiz Koordinati Giriniz..");
        koordinat = verial.next();
        koordinat = koordinat.toUpperCase();
        char satir=koordinat.charAt(1);
        char sutun=koordinat.charAt(0);
        
        while(koordinat.length()!=2 || (int)sutun<65 || (int)sutun>=65+oyunTahtasi.boyut || (int)satir<48 || (int)satir>=48+oyunTahtasi.boyut){
          System.out.println("Hatali Secim Yaptiniz. Seciminizi Tekrar Giriniz..");
          koordinat = verial.next();
          koordinat = koordinat.toUpperCase();
          satir=koordinat.charAt(1);
          sutun=koordinat.charAt(0);
        }
        
        System.out.println();   
        return koordinat;
    }

    public String bilgisayarHamlesiUret() {
        String satir;
        int s;
        s = (int) (Math.random() * (oyunTahtasi.boyut));
        satir = String.valueOf(s);
        char sutun;
        sutun = (char) (65 + Math.random() * oyunTahtasi.boyut);
        koordinat = sutun + satir;
        return koordinat;
    }

}
