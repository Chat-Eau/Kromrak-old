import Conteneur.Inventaire;
import Objets.Equipement;
import Personnages.Kromrak;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Benjamin Laprise on 2018-01-17.
 */
public class test_equipment {
    @Test
    public void testEquip() {
        Kromrak kromrak = Kromrak.getInstance();
        Equipement equipment = new Equipement();
        Inventaire invBackup = new Inventaire("Copied Krompockets™", kromrak.getInventaire());

        assert !equipment.isEquiped();
        assert !kromrak.getInventaire().find(equipment);

        kromrak.getInventaire().add(equipment);

        assert !equipment.isEquiped();
        assert kromrak.getInventaire().find(equipment);

        kromrak.equip(equipment);

        assert equipment.isEquiped();
        assert !kromrak.getInventaire().find(equipment);
        assert kromrak.getInventaire() == invBackup;

        kromrak.unequip(equipment);

        assert !equipment.isEquiped();
        assert kromrak.getInventaire().find(equipment);
        assert !(kromrak.getInventaire() == invBackup);

        System.out.println(kromrak.toString());
    }
}
