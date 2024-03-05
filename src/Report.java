public class Report {
    private String flightCode;
    private Integer totalCheckedin;
    private Double totalBaggageWeight;
    private Double totalBaggageVolume;
    private Double totalExcessCharges;
    private String remarks;

    public Report(String flightCode, Integer totalCheckedin, Double totalBaggageWeight, Double totalBaggageVolume, Double totalExcessCharges, String remarks) {

        if (flightCode == null || remarks == null) {
            throw new IllegalArgumentException("flightCode and remarks cannot be null");
        }

        if (flightCode.trim().isEmpty() || remarks.trim().isEmpty()) {
            throw new IllegalArgumentException("flightCode and remarks cannot be empty");
        }

        if (totalCheckedin < 0 || totalBaggageWeight < 0.0 || totalBaggageVolume < 0.0 || totalExcessCharges < 0.0) {
            throw new IllegalArgumentException("Numeric parameters totalCheckedin, totalBaggageWeight, totalBaggageVolume must be non-negative");
        }

        this.flightCode = flightCode;
        this.totalCheckedin = totalCheckedin;
        this.totalBaggageWeight = totalBaggageWeight;
        this.totalBaggageVolume = totalBaggageVolume;
        this.totalExcessCharges = totalExcessCharges;
        this.remarks = remarks;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public Integer getTotalCheckedin() {
        return totalCheckedin;
    }

    public Double getTotalBaggageWeight() {
        return totalBaggageWeight;
    }

    public Double getTotalBaggageVolume() {
        return totalBaggageVolume;
    }

    public Double getTotalExcessCharges() {
        return totalExcessCharges;
    }

    public String getRemarks() {
        return remarks;
    }
}
