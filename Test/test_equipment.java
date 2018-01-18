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

        assert !equipment.isEquiped();

        kromrak.getInventaire().add(equipment);

        assert !equipment.isEquiped();

        assert kromrak.getInventaire().find(equipment);

        kromrak.equip(equipment);

        assert !kromrak.getInventaire().find(equipment);

        assert equipment.isEquiped();
    }
}
