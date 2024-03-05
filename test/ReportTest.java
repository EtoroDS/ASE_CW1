import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ReportTest {
    @Test
    public void testConstructorWithValidParameters() {
        Report report = new Report("ABC123", 50, 25.0, 30.0, 15.0, "Valid report");

        assertNotNull(report);
        assertEquals("ABC123", report.getFlightCode());
        assertEquals(Integer.valueOf(50), report.getTotalCheckedin());
        assertEquals(Double.valueOf(25.0), report.getTotalBaggageWeight());
        assertEquals(Double.valueOf(30.0), report.getTotalBaggageVolume());
        assertEquals(Double.valueOf(15.0), report.getTotalExcessCharges());
        assertEquals("Valid report", report.getRemarks());
    }

    @Test
    public void testConstructorWithNullParameters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Report(null, 50, 25.0, 30.0, 15.0, "Valid report");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Report("ABC123", 50, 25.0, 30.0, 15.0, null);
        });
    }

    @Test
    public void testConstructorWithEmptyStringParameters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Report("", 50, 25.0, 30.0, 15.0, "Valid report");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Report("ABC123", 50, 25.0, 30.0, 15.0, "");
        });
    }

    @Test
    public void testConstructorWithNegativeNumericParameters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Report("ABC123", -10, 25.0, 30.0, 15.0, "Valid report");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Report("ABC123", 50, -25.0, 30.0, 15.0, "Valid report");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Report("ABC123", 50, 25.0, -30.0, 15.0, "Valid report");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Report("ABC123", 50, 25.0, 30.0, -15.0, "Valid report");
        });
    }
}