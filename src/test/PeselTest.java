import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PeselTest {

    Person pesel;
    final static Logger logger = Logger.getLogger(Person.class);

    @Before
    public void setUp(){
        logger.info("Odpalam setUpa");
        pesel = new Person();
    }

    @Test
    public void NiepoprawnyPesel() {
        String a = "123456789a1";
        assertFalse(Person.isValidPesel(a));
    }

    @Test
    public void PoprawnyPesel() {
        String a = "98032004385";
        assertTrue(Person.isValidPesel(a));
    }

    @Test
    public void KrotkiPesel() {
        String a = "1234567";
        assertFalse(Person.isValidPesel(a));
    }

}