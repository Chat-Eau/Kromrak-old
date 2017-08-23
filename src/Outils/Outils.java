package Outils;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by lapb290796 on 2017-02-21.
 */
public class Outils {
    private Outils() {}

    static public int lancerDes(int nbDés) {
        int total = 0;

        for (int x = 0; x < nbDés; x++)
            total += new Random().nextInt(4) + 1;

        return total;
    }

    static public int maxCap(int stat, int max){
        return stat > max ? max : stat;
    }
    static public int minCap(int stat, int min){
        return stat < min ? min : stat;
    }
    static public int minMaxCap(int stat, int min, int max){
        stat = stat > max ? max : stat;
        return stat < min ? min : stat;
    }

    static public int choixNumerique(int min, int max) {
        boolean mauvaisChoix = false;
        Scanner scanner = new Scanner(System.in);
        int choix;
        do{ choix = scanner.nextInt();
        } while (choix < min || choix > max);
        System.out.println();

        return choix;
    }
}
