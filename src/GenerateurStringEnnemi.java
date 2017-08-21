import java.util.Scanner;

import static Outils.Constantes.SEP;

/**
 * Created by lapb290796 on 2017-03-28.
 */
public class GenerateurStringEnnemi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pvie = 0;
        int pforce = 0;
        int pintelligence = 0;
        int pdextérité = 0;
        int pvitesse = 0;
        int pendurance = 0;
        int pCA = 0;
        int pdvie = 0;
        int pdforce = 0;
        int pdintelligence = 0;
        int pddextérité = 0;
        int pdvitesse = 0;
        int pdendurance = 0;
        int pdCA = 0;


        System.out.print("Nom du monstre : ");
        String nom = scanner.next();
        System.out.print(SEP + "Niveau : ");
        int lvl = scanner.nextInt();
        System.out.print(SEP + "Type : ");
        String type = scanner.next();
        System.out.print(SEP + "Tier : ");
        int tier = scanner.nextInt();
        System.out.print(SEP + "Rareté : ");
        int rarete = scanner.nextInt();
        System.out.print(SEP + "Vie maximum : ");
        int vieMax = scanner.nextInt();
        System.out.print(SEP + "Vie au spawn : ");
        int vie = scanner.nextInt();
        System.out.print(SEP + "Force : ");
        int force = scanner.nextInt();
        System.out.print(SEP + "Intelligence : ");
        int intelligence = scanner.nextInt();
        System.out.print(SEP + "Dextérité : ");
        int dextérité = scanner.nextInt();
        System.out.print(SEP + "Vitesse : ");
        int vitesse = scanner.nextInt();
        System.out.print(SEP + "Endurance : ");
        int endurance = scanner.nextInt();
        System.out.print(SEP + "CA : ");
        int CA = scanner.nextInt();
        System.out.print(SEP + "D4 de vie au spawn : ");
        int dvie = scanner.nextInt();
        System.out.print(SEP + "D4 de force : ");
        int dforce = scanner.nextInt();
        System.out.print(SEP + "D4 d'intelligence : ");
        int dintelligence = scanner.nextInt();
        System.out.print(SEP + "D4 de dextérité : ");
        int ddextérité = scanner.nextInt();
        System.out.print(SEP + "D4 de vitesse : ");
        int dvitesse = scanner.nextInt();
        System.out.print(SEP + "D4 d'endurance : ");
        int dendurance = scanner.nextInt();
        System.out.print(SEP + "D4 de CA : ");
        int dCA = scanner.nextInt();

        System.out.println("Voulez vous implementer des stats par niveau au mob? (O/N)");
        String choix = scanner.next();
        choix = choix.toLowerCase();
        if (choix.charAt(0) == 'o') {
            System.out.print(SEP + "Pallier par niveau de vie au spawn : ");
            pvie = scanner.nextInt();
            System.out.print(SEP + "Pallier par niveau de force : ");
            pforce = scanner.nextInt();
            System.out.print(SEP + "Pallier par niveau d'intelligence : ");
            pintelligence = scanner.nextInt();
            System.out.print(SEP + "Pallier par niveau de dextérité : ");
            pdextérité = scanner.nextInt();
            System.out.print(SEP + "Pallier par niveau de vitesse : ");
            pvitesse = scanner.nextInt();
            System.out.print(SEP + "Pallier par niveau d'endurance : ");
            pendurance = scanner.nextInt();
            System.out.print(SEP + "Pallier par niveau de CA : ");
            pCA = scanner.nextInt();
            System.out.print(SEP + "Pallier par niveau de D4 de vie au spawn : ");
            pdvie = scanner.nextInt();
            System.out.print(SEP + "Pallier par niveau de D4 de force : ");
            pdforce = scanner.nextInt();
            System.out.print(SEP + "Pallier par niveau de D4 d'intelligence : ");
            pdintelligence = scanner.nextInt();
            System.out.print(SEP + "Pallier par niveau de D4 de dextérité : ");
            pddextérité = scanner.nextInt();
            System.out.print(SEP + "Pallier par niveau de D4 de vitesse : ");
            pdvitesse = scanner.nextInt();
            System.out.print(SEP + "Pallier par niveau de D4 d'endurance : ");
            pdendurance = scanner.nextInt();
            System.out.print(SEP + "Pallier par niveau de D4 de CA : ");
            pdCA = scanner.nextInt();
        }

        System.out.println(SEP + SEP + "Vous devrez rajouter les types secondaires et objets manuellement : " + SEP + SEP);

        System.out.print("Nom:" + nom + " ; " +
                "Lvl:" + lvl + " ; " +
                "Type:" + type + " ; " +
                "Tier:" + tier + " ; " +
                "Rarete:" + rarete + " ; " +
                "PdvMax:" + vieMax + " ; " +
                "pdv:" + vie + " ; " +
                "force:" + force + " ; " +
                "Intel:" + intelligence + " ; " +
                "Dex:" + dextérité + " ; " +
                "Vit:" + vitesse + " ; " +
                "End:" + endurance + " ; " +
                "CA:" + CA + " ; " +
                "dpdv:" + dvie + " ; " +
                "dforce:" + dforce + " ; " +
                "dIntel:" + dintelligence + " ; " +
                "dDex:" + ddextérité + " ; " +
                "dVit:" + dvitesse + " ; " +
                "dEnd:" + dendurance + " ; " +
                "dCA:" + dCA + " ; " +
                "ppdv:" + pvie + " ; " +
                "pforce:" + pforce + " ; " +
                "pIntel:" + pintelligence + " ; " +
                "pDex:" + pdextérité + " ; " +
                "pVit:" + pvitesse + " ; " +
                "pEnd:" + pendurance + " ; " +
                "pCA:" + pCA + " ; " +
                "pdpdv:" + pdvie + " ; " +
                "pdforce:" + pdforce + " ; " +
                "pdIntel:" + pdintelligence + " ; " +
                "pdDex:" + pddextérité + " ; " +
                "pdVit:" + pdvitesse + " ; " +
                "pdEnd:" + pdendurance + " ; " +
                "pdCA:" + pdCA);
    }
}
