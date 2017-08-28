import Evenements.Combat;
import Evenements.Salle;
import Lieux.Zone;
import Outils.Coord;
import Personnages.Kromrak;

import java.util.Scanner;

/**
 * Created by lapb290796 on 2017-03-28.
 */
public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Test combat
        //Combat.getInstance().newCombat().combattre();

        //test salle avec combat :
        //Kromrak.getInstance().setSalle(new Salle(new Coord(2,2)));
        //Kromrak.getInstance().setSalle(new Salle());

        //Test zone avec salle avec combat (sans déplacement)
        Zone zone = new Zone();
        zone.entree.activer();
        zone.getSalle(new Coord(1,0)).activer();
        zone.getSalle(new Coord(0,0)).activer();



        System.out.println(Kromrak.getInstance().toString() + System.lineSeparator() +
                System.lineSeparator() + "Appuyez sur 'Enter' pour continuer.");;
        scanner.nextLine();
    }
}
