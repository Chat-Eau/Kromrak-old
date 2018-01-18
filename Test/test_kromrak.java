import Personnages.Kromrak;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Benjamin Laprise on 2018-01-17.
 */
public class test_kromrak {

    @Test
    public void testConstructor() {
        Kromrak kromrak = Kromrak.getInstance();

        assertEquals(kromrak.getNom().compareTo("Kromrak"), 0);
    }

    @Test
    public void testOneDamage() {
        Kromrak kromrak = Kromrak.getInstance();
        int vieInitiale = kromrak.getVie();
        kromrak.recevoirDegats(1);
        assertEquals(kromrak.getVie(), vieInitiale - 1 );
    }

}
