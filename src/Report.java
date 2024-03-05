public class Report {
    private String flightCode;
    private Integer totalCheckedin;
    private Double totalBaggageWeight;
    private Double totalBaggageVolume;
    private Double totalExcessCharges;
    private String remarks;

    public Report(String flightCode, Integer totalCheckedin, Double totalBaggageWeight, Double totalBaggageVolume, Double totalExcessCharges, String remarks) {
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
