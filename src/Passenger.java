public class Passenger {
    private final String bookingRef;
    private final String flightCode;
    private final String firstName;
    private final String lastName;
    private Boolean checkedIn;

    public Passenger(String bookingRef, String flightCode, String firstName, String lastName, Boolean checkedIn) {

        if (bookingRef == null || flightCode == null || firstName == null || lastName == null || checkedIn == null) {
            throw new IllegalArgumentException("Parameters  bookingRef, flightCode, firstName, lastName, checkedIn cannot be null");
        }

        if (bookingRef.trim().isEmpty() || flightCode.trim().isEmpty() || firstName.trim().isEmpty() || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("String parameters bookingRef, flightCode, firstName, lastName cannot be empty");
        }

        if (!lastName.trim().matches("[a-zA-Z:-]+") || !firstName.trim().matches("[a-zA-Z:-]+")) {
            throw new IllegalArgumentException("Invalid name input for lastName or firstName");
        }

        this.bookingRef = bookingRef;
        this.flightCode = flightCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.checkedIn = checkedIn;
    }
    public String getBookingRef( ) {
        return bookingRef;
    }

    public String getFlightCode( ) {
        return flightCode;
    }

    public String getFirstName( ) {
        return firstName;
    }

    public String getLastName( ) {
        return lastName;
    }

    public Boolean getCheckedIn( ) {
        return checkedIn;
    }

    public void setCheckedIn(Boolean checkedIn) {
        this.checkedIn = checkedIn;
    }
}
