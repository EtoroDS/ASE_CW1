public class Baggage  {
    private Double weight;
    private Double height;
    private Double length;
    private Double breath;

    public Baggage(Double weight, Double height, Double length, Double breath) {
        if (weight == null || height == null || length == null || breath == null) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }

        if (weight < 0 || height < 0 || length < 0 || breath < 0) {
            throw new IllegalArgumentException("Dimensions cannot be negative");
        }
        this.weight = weight;
        this.height = height;
        this.length = length;
        this.breath = breath;
    }

    public Double getHeight() {
        return height;
    }

    public Double getLength() {
        return length;
    }

    public Double getBreath() {
        return breath;
    }

    public Double getVolume(){
        return height * length * breath;
    }

    public Double getWeight() {
        return weight;
    }

}
