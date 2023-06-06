package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.apache.commons.lang3.RandomStringUtils;


import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class TestBun {
    private Bun bun;
    private String name;
    private float price;

    public TestBun(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] bunTestVariants() {

        return new Object[][] {
                {"Космобулка", 15F},
                {"", 0.1F},
                {null, 0F},
                {RandomStringUtils.randomAscii(200), Float.MIN_VALUE},
                {RandomStringUtils.randomAlphabetic(32000), Float.MAX_VALUE},
        };
    }

    @Before
    public void setUp () {
        bun = new Bun(name, price);
    }
    @Test
    public void testGetNameReturnBunName (){
        assertEquals(name, bun.getName());
    }
    @Test
    public void testGetNameReturnBunPrice (){
        assertEquals(price, bun.getPrice(), 0f);
    }
}
