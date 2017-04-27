package Outils;

import java.util.Random;

/**
 * Created by lapb290796 on 2017-02-21.
 */
public class Outils {
    static public int lancerDes(int nbDés, int base, double multiplicateur) {
        int total = 0;

        for (int x = 0; x < nbDés; x++)
            total += new Random().nextInt(4) + 1 + base;
        total *= multiplicateur;

        return total > 0 ? total : 0;
    }

    static public int lancerDes(int nbDés, int base) {
        int total = 0;

        for (int x = 0; x < nbDés; x++)
            total += new Random().nextInt(4) + 1 + base;

        return total > 0 ? total : 0;
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
}
