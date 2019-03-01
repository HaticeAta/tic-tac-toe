package tictactoe;

public class oyunTahtasi {

    static int boyut;
    static char[][] oyunalani;

    public oyunTahtasi() {
         oyunTahtasi.oyunalani = oyunTahtasiniAl();
    }

    public oyunTahtasi(char[][] oyunalani) {
        oyunTahtasi.oyunalani = oyunTahtasiniAl();
    }

    public static char[][] oyunTahtasiniAl() {
       oyunalani = new char[boyut][boyut];
        for (int i = 0; i < boyut; ++i) {
            for (int j = 0; j < boyut; ++j) {
                oyunalani[i][j] = '-';
            }
        }
        return oyunalani;
    }

    static public void oyunTahtasiniYazdir() {
        System.out.print("  ");
        for (int i = 65; i < 65 + boyut; i++) {
            System.out.print((char) i + " ");
        }
        System.out.println();
        for (int i = 0; i < boyut; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < boyut; j++) {
                System.out.print(oyunalani[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean hamleyiYaz(String koordinat, char oyuncu) {
        int satir = Integer.valueOf(koordinat.charAt(1)) - 48;
        int sutun = Integer.valueOf(koordinat.charAt(0)) - 65;
        for (int i = 0; i < boyut; i++) {
            for (int j = 0; j < boyut; j++) {
                if (i == satir && j == sutun && oyunalani[i][j] == '-') {
                    oyunalani[i][j] = oyuncu;
                    return true;
                }
            }
        }
        return false;
    }

    static boolean beraberlikKontrol() {
        int sayac = 0;
        for (int i = 0; i < boyut; i++) {
            for (int j = 0; j < boyut; j++) {
                if (oyunalani[i][j] != '-') {
                    sayac = sayac + 1;
                }
            }
        }
        return sayac == (boyut * boyut);
    }

    static boolean kazanan() {
        int sayac;
        boolean capraz = false;
        boolean terscapraz = false;
        boolean satir = false;
        boolean sutun = false;
        if (oyunalani[0][0] == 'X' || oyunalani[0][0] == 'O') {
            sayac = 1;
            for (int i = 0; i < boyut - 1; i++) {
                if (oyunalani[i][i] == oyunalani[i + 1][i + 1]) {
                    sayac = sayac + 1;
                }
            }
            if (sayac == boyut) {
                capraz = true;
            }
        }
        if (oyunalani[0][boyut - 1] == 'X' || oyunalani[0][boyut - 1] == 'O') {
            sayac = 1;
            for (int i = 0; i < boyut - 1; i++) {
                if (oyunalani[i][boyut - i - 1] == oyunalani[i + 1][boyut - i - 2]) {
                    sayac = sayac + 1;
                }
            }
            if (sayac == boyut) {
                terscapraz = true;
            }
        }
        for (int i = 0; i < boyut; i++) {
            sayac = 1;
            if (oyunalani[i][0] == 'X' || oyunalani[i][0] == 'O') {
                for (int j = 0; j < boyut - 1; j++) {
                    if (oyunalani[i][j] == oyunalani[i][j + 1]) {
                        sayac = sayac + 1;
                    }
                }
                if (sayac == boyut) {
                    satir = true;
                    break;
                }
            }
        }
        for (int i = 0; i < boyut; i++) {
            sayac = 1;
            if (oyunalani[0][i] == 'X' || oyunalani[0][i] == 'O') {
                for (int j = 0; j < boyut - 1; j++) {
                    if (oyunalani[j][i] == oyunalani[j + 1][i]) {
                        sayac = sayac + 1;
                    }
                }
                if (sayac == boyut) {
                    sutun = true;
                    break;
                }
            }
        }
        return capraz || terscapraz || satir || sutun;
    }
}
