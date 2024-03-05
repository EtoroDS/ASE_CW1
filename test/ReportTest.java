import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ReportTest {
    private ReportRepository reportRepository;

    @BeforeEach
    public void setUp() {
        reportRepository = new ReportRepository();
    }

    @Test
    public void testInsertRecords() {
        // Create a test flight data
        Map<String, Flight> flightData = new HashMap<>();
        Flight testFlight = new Flight("TestFlight", "calagari", LocalDateTime.now(), "British Airways", 10, 150.0,
                20.0,
                25.0,
                180.0,
                200.0,
                4,
                120.0,
                3000.0,
                3500.0);
        flightData.put("TestFlight", testFlight);

        // Call the method to be tested
        reportRepository.insertRecords(flightData);

        // Check if the reportRepo has one report
        assertEquals(1, reportRepository.getReportRepo().size());

        // Check if the report in the reportRepo has the expected values
        Report insertedReport = reportRepository.getReportRepo().get(0);
        assertEquals("TestFlight", insertedReport.getFlightCode());
        assertEquals(4, insertedReport.getTotalCheckedin());  // Corrected value
        assertEquals(120.0, insertedReport.getTotalBaggageWeight(), 0.001);
        assertEquals(3000.0, insertedReport.getTotalBaggageVolume(), 0.001);
        assertEquals(3500, insertedReport.getTotalExcessCharges(), 0.001);
    }

    @Test
    public void testExportRecords() {
            // Create a test report
            Report testReport = new Report("TestFlight", 100, 50.0, 30.0, 0.0, "Within capacity");
            reportRepository.getReportRepo().add(testReport);

            // Redirect System.out to capture console output
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));

            // Call the method to be tested
            reportRepository.exportRecords();

            // Reset System.out
            System.setOut(System.out);

            // Check if the CSV file is created successfully
            assertTrue(outContent.toString().contains("CSV file created successfully"));
    }

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
