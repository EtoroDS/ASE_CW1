import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class PassengerTest {

    @Test
    public void testGetters() {
        Passenger passenger = new Passenger("ABC123", "FL123", "John", "Doe", false);

        assertEquals("ABC123", passenger.getBookingRef());
        assertEquals("FL123", passenger.getFlightCode());
        assertEquals("John", passenger.getFirstName());
        assertEquals("Doe", passenger.getLastName());
        assertFalse(passenger.getCheckedIn());
    }

    @Test
    public void testSetter() {
        Passenger passenger = new Passenger("ABC123", "FL123", "John", "Doe", false);

        assertFalse(passenger.getCheckedIn());

        passenger.setCheckedIn(true);

        assertTrue(passenger.getCheckedIn());
    }

    @Test
    public void testConstructorWithNullParameters() {
        assertThrows(IllegalArgumentException.class, () ->
                new Passenger(null, "FL123", "John", "Doe", false)
        );

        assertThrows(IllegalArgumentException.class, () ->
                new Passenger("ABC123", null, "John", "Doe", false)
        );

        assertThrows(IllegalArgumentException.class, () ->
                new Passenger("ABC123", "FL123", null, "Doe", false)
        );

        assertThrows(IllegalArgumentException.class, () ->
                new Passenger("ABC123", "FL123", "John", null, false)
        );

        assertThrows(IllegalArgumentException.class, () ->
                new Passenger("ABC123", "FL123", "John", "Doe", null)
        );
    }

    @Test
    public void testConstructorWithEmptyStrings() {
        assertThrows(IllegalArgumentException.class, () ->
                new Passenger("", "FL123", "John", "Doe", false)
        );

        assertThrows(IllegalArgumentException.class, () ->
                new Passenger("ABC123", "", "John", "Doe", false)
        );

        assertThrows(IllegalArgumentException.class, () ->
                new Passenger("ABC123", "FL123", "", "Doe", false)
        );

        assertThrows(IllegalArgumentException.class, () ->
                new Passenger("ABC123", "FL123", "John", "", false)
        );
    }

    @Test
    public void testConstructorWithInvalidName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Passenger("ABC123", "FL123", "John", "Doe123", false)
        );

        assertThrows(IllegalArgumentException.class, () ->
                new Passenger("ABC123", "FL123", "John123", "Doe", false)
        );
    }

    @Test
    public void testConstructorWithInvalidBookingRef() {
        assertThrows(IllegalArgumentException.class, () ->
                new Passenger("ABC12@", "FL123", "John", "Doe", false)
        );

        assertThrows(IllegalArgumentException.class, () ->
                new Passenger("ABC", "FL123", "John", "Doe", false)
        );
    }

}
