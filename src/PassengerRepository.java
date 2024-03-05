import java.io.*;
import java.util.*;

public class PassengerRepository {
    private Map<String, Passenger> passengers = new HashMap<>();

    public PassengerRepository() {
        String csvFilePath ="data/passenger.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            boolean isFirstLine = true;
            String[] headers = null;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    // Assume the first line contains headers
                    headers = line.split(",");
                    isFirstLine = false;
                } else {
                    String[] values = line.split(",");
                    Map<String, String> fileDetails = new HashMap<>();

                    for (int i = 0; i < headers.length; i++) {
                        fileDetails.put(headers[i], values[i]);
                    }

                    // Create an instance of Passenger and add it to the map
                    Passenger passenger = new Passenger(
                            fileDetails.get("bookingRef"),
                            fileDetails.get("flightCode"),
                            fileDetails.get("firstName"),
                            fileDetails.get("lastName"),
                            Boolean.parseBoolean(fileDetails.get("checkedIn").trim())
                    );

                    // Assume bookingRef is unique and used as the key
                    passengers.put(fileDetails.get("bookingRef").trim(), passenger);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Passenger findByBookingRef(String bookingRef){
      for (Map.Entry<String, Passenger> entry : passengers.entrySet()) {
           if (entry.getKey().equals(bookingRef)){
               return entry.getValue();
           }
      }
      return null;
  }

    public void checkInByBookingRef(String bookingRef){
        for (Map.Entry<String, Passenger> entry : passengers.entrySet()) {
            if (entry.getKey().equals(bookingRef)){
                entry.getValue().setCheckedIn(true);
            }
        }
    }

}
