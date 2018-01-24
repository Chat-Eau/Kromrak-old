import Objets.Equipment;
import Personnages.Kromrak;
import org.junit.jupiter.api.Test;

/**
 * Created by Benjamin Laprise on 2018-01-17.
 */
public class test_equipment {
    @Test
    public void testEquip() {
        Kromrak kromrak = Kromrak.getInstance();
        Equipment equipment = new Equipment("Gants du test de la destinée",0,"Main");

        assert !equipment.isEquiped();
        assert !kromrak.getInventaire().find(equipment);

        kromrak.getInventaire().add(equipment);

        assert !equipment.isEquiped();
        assert kromrak.getInventaire().find(equipment);

        kromrak.equip(equipment);

        assert equipment.isEquiped();
        assert !kromrak.getInventaire().find(equipment);

        kromrak.unequip(equipment);

        assert !equipment.isEquiped();
        assert kromrak.getInventaire().find(equipment);
    }

    @Test
    public void receiveArmorReducedDamage() {
        Kromrak kromrak = Kromrak.getInstance();
        //TODO:GLM:Donner 1 CA minimum à l'armure, dans le futur, puisque les équipements ne donnent pas encore de stats.
        Equipment chestPlate = new Equipment("Thick Honey chest plate", 8, "Chest");
        kromrak.getInventaire().add(chestPlate);
        kromrak.equip(chestPlate);
        kromrak.setVieMax(1000);
        kromrak.setVie(1000);
        Integer lifeBackup = kromrak.getVie();
        Integer CABackup = kromrak.getCA();

        kromrak.recevoirDegats(300);

        assert ((lifeBackup - 299 + CABackup) == kromrak.getVie());

        kromrak.unequip(chestPlate);
        lifeBackup = kromrak.getVie();
        kromrak.recevoirDegats(300);

        assert ((lifeBackup - 300 + CABackup) == kromrak.getVie());

    }
}
