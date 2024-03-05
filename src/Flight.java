import java.time.*;
public class Flight {
    private String flightCode;
    private String destination;
    private LocalDateTime departureTime;
    private String carrier;
    private Integer capacity;
    private Double allowedBaggageWeight;
    private Double allowedBaggageVolume;
    private Double maxBaggageWeight;
    private Double maxBaggageVolume;
    private Double excessBaggageFee;
    private Integer totalCheckedIn;
    private Double totalBaggageWeight;
    private Double totalBaggageVolume;
    private Double totalCollectedExcessBaggageFee;

    public Flight(String flightCode, String destination, LocalDateTime departureTime, String carrier, Integer capacity, Double allowedBaggageWeight, Double allowedBaggageVolume, Double maxBaggageWeight, Double maxBaggageVolume, Double excessBaggageFee, Integer totalCheckedIn, Double totalBaggageWeight, Double totalBaggageVolume, Double totalCollectedExcessBaggageFee ) {
        if (flightCode == null || destination == null || departureTime == null || carrier == null) {
            throw new IllegalArgumentException("Parameters flightCode, destination, departureTime, carrier cannot be null");
        }

        if (flightCode.trim().isEmpty() || destination.trim().isEmpty() || carrier.trim().isEmpty()) {
            throw new IllegalArgumentException("String parameters flightCode, destination, carrier cannot be empty");
        }

        if (capacity <= 0 || allowedBaggageWeight <= 0 || allowedBaggageVolume <= 0 || maxBaggageWeight <= 0 || maxBaggageVolume <= 0 || excessBaggageFee < 0 || totalCheckedIn < 0 || totalBaggageWeight < 0 || totalBaggageVolume < 0 || totalCollectedExcessBaggageFee < 0) {
            throw new IllegalArgumentException("Numeric parameters capacity, allowedBaggageWeight, allowedBaggageVolume, maxBaggageWeight, maxBaggageVolume, excessBaggageFee, totalCheckedIn must be positive");
        }


        this.flightCode = flightCode;
        this.destination = destination;
        this.departureTime = departureTime;
        this.carrier = carrier;
        this.capacity = capacity;
        this.allowedBaggageWeight = allowedBaggageWeight;
        this.allowedBaggageVolume = allowedBaggageVolume;
        this.maxBaggageWeight = maxBaggageWeight;
        this.maxBaggageVolume = maxBaggageVolume;
        this.excessBaggageFee = excessBaggageFee;
        this.totalCheckedIn = totalCheckedIn;
        this.totalBaggageWeight = totalBaggageWeight;
        this.totalBaggageVolume = totalBaggageVolume;
        this.totalCollectedExcessBaggageFee = totalCollectedExcessBaggageFee;
    }

    public String getFlightCode( ) {
        return flightCode;
    }
    public String getDestination( ) {
        return destination;
    }
    public LocalDateTime getDepartureTime( ) {
        return departureTime;
    }
    public String getCarrier( ) {
        return carrier;
    }
    public Integer getCapacity( ) {
        return capacity;
    }
    public Double getMaxBaggageWeight( ) {
        return maxBaggageWeight;
    }
    public Double getMaxBaggageVolume( ) {
        return maxBaggageVolume;
    }
    public Double getExcessBaggageFee( ) {
        return excessBaggageFee;
    }

    public Double getAllowedBaggageWeight( ) {
        return allowedBaggageWeight;
    }

    public Double getAllowedBaggageVolume( ) {
        return allowedBaggageVolume;
    }
    public Integer getTotalCheckedIn( ) {
        return totalCheckedIn;
    }
    public Double getTotalBaggageWeight( ) {
        return totalBaggageWeight;
    }
    public Double getTotalBaggageVolume( ) {
        return totalBaggageVolume;
    }
    public Double getTotalCollectedExcessBaggageFee( ){
        return totalCollectedExcessBaggageFee;
    }
    public void setTotalCheckedIn( ) {
        this.totalCheckedIn ++ ;
    }
    public void setTotalBaggageWeight(Double BaggageWeight) {
        this.totalBaggageWeight += BaggageWeight;
    }
    public void setTotalBaggageVolume(Double BaggageVolume) {
        this.totalBaggageVolume += BaggageVolume;
    }
    public void setTotalCollectedExcessBaggageFee(Double chargeFee){
        this.totalCollectedExcessBaggageFee += chargeFee;
    }
}
