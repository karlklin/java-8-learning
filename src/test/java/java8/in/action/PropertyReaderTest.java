package java8.in.action;

import java8.in.action.optional.PropertyReader;
import org.junit.Before;
import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.assertEquals;


public class PropertyReaderTest {

    private PropertyReader reader;
    private Properties properties;

    @Before
    public void setUp() {
        reader = new PropertyReader();
        properties = new Properties();

        properties.setProperty("a", "-3");
        properties.setProperty("b", "0");
        properties.setProperty("c", "5");
    }

    @Test
    public void readDurationImperative() {
        assertEquals(0, reader.readDurationImperative(properties, "a"));
        assertEquals(0, reader.readDurationImperative(properties, "b"));
        assertEquals(5, reader.readDurationImperative(properties, "c"));
        assertEquals(0, reader.readDurationImperative(properties, "d"));
    }

    @Test
    public void readDurationDeclarative() {
        assertEquals(0, reader.readDurationDeclarative(properties, "a"));
        assertEquals(0, reader.readDurationDeclarative(properties, "b"));
        assertEquals(5, reader.readDurationDeclarative(properties, "c"));
        assertEquals(0, reader.readDurationDeclarative(properties, "d"));

    }

}