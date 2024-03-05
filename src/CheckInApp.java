import org.jetbrains.annotations.NotNull;

public class CheckInApp {

    private PassengerRepository passengerRepo = new PassengerRepository();
    private FlightRepository flightRepo = new FlightRepository();

    public Passenger searchBooking(String bookingRef, String lastName){
        Passenger passengerInfo = passengerRepo.findByBookingRef(bookingRef);
        if (passengerInfo != null && passengerInfo.getLastName().equalsIgnoreCase(lastName)) {
            return passengerInfo;
        }
        return null;
    }
    public Boolean isCheckedIn(String bookingRef){
        Passenger passengerInfo = passengerRepo.findByBookingRef(bookingRef);
        return passengerInfo.getCheckedIn();
    }
    public void checkIn(String bookingRef) {
        passengerRepo.checkInByBookingRef(bookingRef);
    }
    public Flight getFlightDetails(String flightCode){
        return flightRepo.findByFlightCode(flightCode);
    }
    public void updateFlightDetails(String flightCode, Double baggageVolume, Double baggageWeight, Double chargeFee){
         flightRepo.updateFlightInfo(flightCode, baggageVolume, baggageWeight, chargeFee);
    }
    public Double calculateExcessBaggage(@NotNull Flight flightInfo, @NotNull Baggage baggageInfo){
        double excessVolumeCharge = 0.0, excessWeightCharge = 0.0;
        if (baggageInfo.getVolume() > flightInfo.getAllowedBaggageVolume() || baggageInfo.getWeight() > flightInfo.getAllowedBaggageWeight()){
            if (baggageInfo.getVolume() > flightInfo.getAllowedBaggageVolume()){
                excessVolumeCharge = (baggageInfo.getVolume() - flightInfo.getAllowedBaggageVolume()) * flightInfo.getExcessBaggageFee();
            }
            if (baggageInfo.getWeight() > flightInfo.getAllowedBaggageWeight()){
                excessWeightCharge = (baggageInfo.getWeight() - flightInfo.getAllowedBaggageWeight()) * flightInfo.getExcessBaggageFee();
            }
            return excessVolumeCharge + excessWeightCharge;
        }
        return 0.0;
    }
    public void generateFlightReport(){
        ReportRepository reportRepo = new ReportRepository();
        reportRepo.insertRecords(flightRepo.getFlights());
        reportRepo.exportRecords();
    }

}
