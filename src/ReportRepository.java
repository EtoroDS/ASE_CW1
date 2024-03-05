import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportRepository {
    private List<Report> reportRepo = new ArrayList<>();

    public void insertRecords(@NotNull Map<String, Flight> flightData){
        String remarks ;
        for (Map.Entry<String, Flight> entry : flightData.entrySet()){
            if (entry.getValue().getTotalBaggageWeight() > entry.getValue().getMaxBaggageWeight() && entry.getValue().getTotalBaggageVolume() > entry.getValue().getMaxBaggageVolume()){
                remarks = "The flight has exceeded both it's maximum weight and volume limit";
            }
            else if (entry.getValue().getTotalBaggageWeight() > entry.getValue().getMaxBaggageWeight() || entry.getValue().getTotalBaggageVolume() > entry.getValue().getMaxBaggageVolume()){
                if (entry.getValue().getTotalBaggageVolume() > entry.getValue().getMaxBaggageVolume()){
                    remarks = "The flight has exceeded it's maximum volume limit";
                }
                else {
                    remarks = "The flight has exceeded it's maximum weight limit";
                }
            }
            else{
                remarks = "The flight is within capacity";
            }
            Report report = new Report (
                    entry.getValue().getFlightCode(),
                    entry.getValue().getTotalCheckedIn(),
                    entry.getValue().getTotalBaggageWeight(),
                    entry.getValue().getTotalBaggageVolume(),
                    entry.getValue().getTotalCollectedExcessBaggageFee(),
                    remarks
            );
            reportRepo.add(report);
        }
    }

    public void exportRecords(){
        String csvFilePath = "data/report.csv";
//        File directory = new File(csvFilePath.substring(0, csvFilePath.lastIndexOf(File.separator)));
//        if (!directory.exists()) {
//            directory.mkdirs();
//        }
        try (PrintWriter writer = new PrintWriter(new FileWriter(csvFilePath))) {
            // Write headers
            writer.println("flightCode,totalCheckedIn,totalBaggageWeight,totalBaggageVolume,totalExcessChargeCollected,remarks");

            // Write data
            for (Report report : reportRepo) {
                writer.println(String.format("%s,%d,%.2f,%.2f,%.2f,%s", report.getFlightCode(),
                                                                        report.getTotalCheckedin(),
                                                                        report.getTotalBaggageWeight(),
                                                                        report.getTotalBaggageVolume(),
                                                                        report.getTotalExcessCharges(),
                                                                        report.getRemarks()));

            }
            System.out.println("CSV file created successfully at: " + csvFilePath);
        } catch (IOException e) {
            System.err.println("Error writing CSV file: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
