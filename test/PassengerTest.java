import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PassengerTest {

    @Test
    public void testPassengerConstructor() {
        // Valid input
        Passenger validPassenger = new Passenger("BR123", "FL001", "John", "Doe", false);
        assertEquals("BR123", validPassenger.getBookingRef());
        assertEquals("FL001", validPassenger.getFlightCode());
        assertEquals("John", validPassenger.getFirstName());
        assertEquals("Doe", validPassenger.getLastName());
        assertFalse(validPassenger.getCheckedIn());

        // Null input
        assertThrows(IllegalArgumentException.class, () -> new Passenger(null, "FL001", "John", "Doe", false));
        assertThrows(IllegalArgumentException.class, () -> new Passenger("BR123", null, "John", "Doe", false));
        assertThrows(IllegalArgumentException.class, () -> new Passenger("BR123", "FL001", null, "Doe", false));
        assertThrows(IllegalArgumentException.class, () -> new Passenger("BR123", "FL001", "John", null, false));
        assertThrows(IllegalArgumentException.class, () -> new Passenger("BR123", "FL001", "John", "Doe", null));

        // Empty string input
        assertThrows(IllegalArgumentException.class, () -> new Passenger("", "FL001", "John", "Doe", false));
        assertThrows(IllegalArgumentException.class, () -> new Passenger("BR123", "", "John", "Doe", false));
        assertThrows(IllegalArgumentException.class, () -> new Passenger("BR123", "FL001", "", "Doe", false));
        assertThrows(IllegalArgumentException.class, () -> new Passenger("BR123", "FL001", "John", "", false));

        // Invalid names
        assertThrows(IllegalArgumentException.class, () -> new Passenger("BR123", "FL001", "John123", "Doe", false));
        assertThrows(IllegalArgumentException.class, () -> new Passenger("BR123", "FL001", "John", "Doe123", false));
        assertThrows(IllegalArgumentException.class, () -> new Passenger("BR123", "FL001", "John 123", "Doe", false));
        assertThrows(IllegalArgumentException.class, () -> new Passenger("BR123", "FL001", "John", "Doe 123", false));
        assertThrows(IllegalArgumentException.class, () -> new Passenger("BR123", "FL001", "John@", "Doe", false));
        assertThrows(IllegalArgumentException.class, () -> new Passenger("BR123", "FL001", "John", "Doe@", false));
    }

    @Test
    public void testSetCheckedIn() {
        Passenger passenger = new Passenger("BR123", "FL001", "John", "Doe", false);

        // Change checked-in status
        passenger.setCheckedIn(true);
        assertTrue(passenger.getCheckedIn());
    }
}
