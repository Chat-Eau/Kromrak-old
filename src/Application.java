import Evenements.Combat;
import Evenements.Salle;
import Lieux.Zone;
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

        //Test salle avec combat :
        Kromrak.getInstance().setSalle(new Salle());
        //Kromrak.getInstance().setSalle(new Salle());

//        //Test zone avec salle avec combat (sans déplacement)
//        Zone zone = new Zone();
//        Kromrak.getInstance().setSalle(zone.salles[3][3]);
//        Kromrak.getInstance().setSalle(zone.salles[1][7]);
//        Kromrak.getInstance().setSalle(zone.salles[6][9]);


        System.out.println(Kromrak.getInstance().toString() + System.lineSeparator() +
                System.lineSeparator() + "Appuyez sur 'Enter' pour continuer.");;
        scanner.nextLine();
    }
}
