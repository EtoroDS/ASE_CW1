import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class FlightTest {
    private Flight flight;

    @BeforeEach
    public void setUp() {
        // Initialize a sample Flight object for testing
        flight = new Flight("ABC123", "New York", LocalDateTime.now(), "AirlineXYZ", 150, 20.0, 30.0, 25.0, 35.0, 10.0, 0, 0.0, 0.0, 0.0);
    }

    @Test
    public void testConstructorWithValidParameters() {
        assertNotNull(flight);
        assertEquals("ABC123", flight.getFlightCode());
        assertEquals("New York", flight.getDestination());
        assertNotNull(flight.getDepartureTime());
        assertEquals("AirlineXYZ", flight.getCarrier());
        assertEquals(Integer.valueOf(150), flight.getCapacity());
        assertEquals(Double.valueOf(25.0), flight.getMaxBaggageWeight());
        assertEquals(Double.valueOf(35.0), flight.getMaxBaggageVolume());
        assertEquals(Double.valueOf(10.0), flight.getExcessBaggageFee());
    }

    @Test
    public void testConstructorWithNullParameters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Flight(null, "Paris", LocalDateTime.now(), "AirlineABC", 200, 25.0, 40.0, 30.0, 40.0, 15.0, 0, 0.0, 0.0, 0.0);
        });
    }

    @Test
    public void testConstructorWithEmptyStringParameters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Flight("XYZ456", "", LocalDateTime.now(), "AirlineXYZ", 100, 15.0, 20.0, 15.0, 25.0, 5.0, 0, 0.0, 0.0, 0.0);
        });
    }

    @Test
    public void testConstructorWithNegativeNumericParameters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Flight("DEF789", "London", LocalDateTime.now(), "AirlineXYZ", -50, -10.0, -15.0, -12.0, -18.0, -5.0, 0, 0.0, 0.0, 0.0);
        });
    }

    @Test
    public void testSetTotalCheckedIn() {
        flight.setTotalCheckedIn();
        assertEquals(Integer.valueOf(1), flight.getTotalCheckedIn());
    }

    @Test
    public void testSetTotalBaggageWeight() {
        flight.setTotalBaggageWeight(15.0);
        assertEquals(Double.valueOf(15.0), flight.getTotalBaggageWeight());
    }

    @Test
    public void testSetTotalBaggageVolume() {
        flight.setTotalBaggageVolume(25.0);
        assertEquals(Double.valueOf(25.0), flight.getTotalBaggageVolume());
    }

    @Test
    public void testSetTotalCollectedExcessBaggageFee() {
        flight.setTotalCollectedExcessBaggageFee(8.0);
        assertEquals(Double.valueOf(8.0), flight.getTotalCollectedExcessBaggageFee());
    }

    // Add more tests for other methods as needed
}
