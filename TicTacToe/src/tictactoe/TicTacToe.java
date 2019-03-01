
package tictactoe;

import java.util.Scanner;
import static tictactoe.oyunTahtasi.boyut;


public class TicTacToe {
   public static void main(String[] args) {
        oyuncu insan = null;
        oyuncu pc = null;
        Scanner verial = new Scanner(System.in); 
        System.out.println("Kullanici Ismini Giriniz...");
        oyuncu.KullaniciAdi = verial.next();      
        System.out.println("Oyun Tahtasinin Boyutunu Giriniz...( 3 - 5 - 7 )");
        do {
            boyut = verial.nextInt();
            if (boyut != 3 && boyut != 5 && boyut != 7) {
                System.out.println("Hatali Secim Yaptiniz. Seciminizi Tekrar Giriniz..");
                boyut = verial.nextInt();
            }
        } while (boyut == 3 && boyut == 5 && boyut == 7);
        boolean dsecim, dsecim2;
        do {
            System.out.println("Oynamak İstediginiz Harfi Belirlemek İster Misiniz?...( evet - hayir) ");
            String secim;
            secim = verial.next();
            dsecim = secim.equalsIgnoreCase("evet");
            dsecim2 = secim.equalsIgnoreCase("hayır");
            if (dsecim == false && dsecim2 == false) {
                System.out.println("Hatali Secim Yaptiniz. Seciminizi Tekrar Giriniz..");
                secim = verial.next();
                dsecim = secim.equalsIgnoreCase("evet");
                dsecim2 = secim.equalsIgnoreCase("hayır");
            }
        } while (dsecim == true && dsecim2 == true);
        boolean harf1,harf2;
        if (dsecim == true) {   // Oynamak istedigi hamleyi kullanici belirliyor
            System.out.println("Oynamak İstediginiz Harfi Girin..( X - O )");
            String harf;
            harf = verial.next();
            harf = harf.toUpperCase();
            harf1=harf.equalsIgnoreCase("X");
            harf2=harf.equalsIgnoreCase("O");
            while(harf1==false && harf2==false){
                System.out.println("Hatali Secim Yaptiniz. Seciminizi Tekrar Giriniz..");
                harf = verial.next();
                harf = harf.toUpperCase();
                harf1=harf.equalsIgnoreCase("X");
                harf2=harf.equalsIgnoreCase("O");
            }
            char oyunharf = harf.charAt(0);
            insan = new oyuncu(true, oyunharf);
            if (oyunharf == 'X') {
                pc = new oyuncu(false, 'O');
            }
            if (oyunharf == 'O') {
                pc = new oyuncu(false, 'X');
            }
            
        }
        if (dsecim2 == true) {
            insan = new oyuncu(true);
            pc = new oyuncu(false);
        }
        oyunTahtasi oyunalani = new oyunTahtasi(oyunTahtasi.oyunalani);
        oyunTahtasi.oyunTahtasiniYazdir();
       
        do {
            System.out.println();
            System.out.println("Oyun Sirasi " + oyuncu.KullaniciAdi + "\'de...\n");
            boolean hamle = oyunTahtasi.hamleyiYaz(insan.oyuncununHamlesiniAl(), insan.karakteriAl());
            while (false == hamle && !oyunTahtasi.beraberlikKontrol()) {
                System.out.println("Girdiğiniz koordinat dolu..");
                hamle = oyunTahtasi.hamleyiYaz(insan.insanOyuncuHamlesiniKontrol(), insan.karakteriAl());
            }
            oyunTahtasi.oyunTahtasiniYazdir();
            if (oyunTahtasi.kazanan() == true) {
                System.out.println("\nOyunu " + oyuncu.KullaniciAdi + " Kazandi....\n");
                break;
            }
            System.out.println();
            System.out.println("Oyun Sirasi Bilgisayarda...\n");
            boolean hamle1 = oyunTahtasi.hamleyiYaz(pc.oyuncununHamlesiniAl(), pc.karakteriAl());
            while (hamle1 == false && !oyunTahtasi.beraberlikKontrol()) {
                hamle1 = oyunTahtasi.hamleyiYaz(pc.bilgisayarHamlesiUret(), pc.karakteriAl());
            }
            oyunTahtasi.oyunTahtasiniYazdir();
            if (oyunTahtasi.kazanan() == true) {
                System.out.println("\nOyunu Bilgisayar Kazandi....\n");
                break;
            }
        } while (!oyunTahtasi.beraberlikKontrol() && !oyunTahtasi.kazanan());

        if (oyunTahtasi.beraberlikKontrol() == true && oyunTahtasi.kazanan() == false) {
            System.out.println("\nOyun Berabere Bitti....\n");
        }
    }
}
