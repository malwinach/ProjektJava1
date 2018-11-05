import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.quartz.DateBuilder.dateOf;

public class PrzerwaTest {

    Date data;
    final static Logger logger = Logger.getLogger(Time.class);

    @Before
    public void setUp(){
        logger.info("Odpalam setUpa");
        data = new Date();
    }

    @Test
    public void Przerwa() {
        data = dateOf(13,17,00);
        assertTrue(Time.Przerwa(data));
    }

    @Test
    public void NieMaPrzerwy() {
        data = dateOf(8, 20, 00);
        assertFalse(Time.Przerwa(data));
    }


}