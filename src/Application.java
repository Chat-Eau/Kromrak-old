import Evenements.Combat;
import Evenements.Salle;
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
        Kromrak.getInstance().setSalle(new Salle());



        System.out.println(Kromrak.getInstance().toString() + System.lineSeparator() +
                System.lineSeparator() + "Appuyez sur 'Enter' pour continuer.");;
        scanner.nextLine();
    }
}
