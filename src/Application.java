import Evenements.Combat;
import Personnages.Kromrak;

import java.util.Scanner;

/**
 * Created by lapb290796 on 2017-03-28.
 */
public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Combat combat1 = new Combat();
        combat1.combattre();
        System.out.println(Kromrak.getInstance().toString() + System.lineSeparator() +
                System.lineSeparator() + "Appuyez sur 'Enter' pour continuer.");;
        scanner.nextLine();

        Combat combat2 = new Combat();
        combat2.combattre();
        System.out.println(Kromrak.getInstance().toString() + System.lineSeparator() +
                System.lineSeparator() + "Appuyez sur 'Enter' pour continuer.");;        scanner.nextLine();
    }
}
