import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BaggageTest {

    @Test
    public void testBaggageConstructor() {
        // Valid input
        Baggage validBaggage = new Baggage(10.0, 20.0, 30.0, 5.0);
        assertEquals(10.0, validBaggage.getWeight());
        assertEquals(20.0, validBaggage.getHeight());
        assertEquals(30.0, validBaggage.getLength());
        assertEquals(5.0, validBaggage.getBreath());

        // Null input
        assertThrows(IllegalArgumentException.class, () -> new Baggage(null, 20.0, 30.0, 5.0));
        assertThrows(IllegalArgumentException.class, () -> new Baggage(10.0, null, 30.0, 5.0));
        assertThrows(IllegalArgumentException.class, () -> new Baggage(10.0, 20.0, null, 5.0));
        assertThrows(IllegalArgumentException.class, () -> new Baggage(10.0, 20.0, 30.0, null));

        // Negative dimensions
        assertThrows(IllegalArgumentException.class, () -> new Baggage(-10.0, 20.0, 30.0, 5.0));
        assertThrows(IllegalArgumentException.class, () -> new Baggage(10.0, -20.0, 30.0, 5.0));
        assertThrows(IllegalArgumentException.class, () -> new Baggage(10.0, 20.0, -30.0, 5.0));
        assertThrows(IllegalArgumentException.class, () -> new Baggage(10.0, 20.0, 30.0, -5.0));
    }

    @Test
    public void testGetVolume() {
        Baggage baggage = new Baggage(10.0, 20.0, 30.0, 5.0);
        assertEquals(3000.0, baggage.getVolume(), 0.01);
    }
    @Test
    public void testGetHeight() {
        Baggage baggage = new Baggage(10.0, 5.0, 3.0, 2.0);
        assertEquals(Double.valueOf(5.0), baggage.getHeight());
    }

    @Test
    public void testGetLength() {
        Baggage baggage = new Baggage(10.0, 5.0, 3.0, 2.0);
        assertEquals(Double.valueOf(3.0), baggage.getLength());
    }

    @Test
    public void testGetBreath() {
        Baggage baggage = new Baggage(10.0, 5.0, 3.0, 2.0);
        assertEquals(Double.valueOf(2.0), baggage.getBreath());
    }


    @Test
    public void testGetWeight() {
        Baggage baggage = new Baggage(10.0, 5.0, 3.0, 2.0);
        assertEquals(Double.valueOf(10.0), baggage.getWeight());
    }
}