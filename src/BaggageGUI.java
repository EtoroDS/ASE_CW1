import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static java.lang.Double.parseDouble;

public class BaggageGUI extends JFrame {
    private CheckInApp app;
    private Passenger passengerInfo;
    private Flight flightInfo;
    private Baggage baggageInfo;
    private Double chargeInfo;
    private JPanel BaggageGUI;
    private JTextPane displayPane;
    private JTextField baggageWeight;
    private JTextField baggageLength;
    private JTextField baggageBreath;
    private JTextField baggageHeight;
    private JButton calculateExcessFeeButton;
    private JLabel enterBaggageWeightLabel;
    private JLabel enterBaggageLengthLabel;
    private JLabel enterBaggageBreathLabel;
    private JTextField feePane;
    private JButton checkInButton;
    private JButton cancelButton;
    private JTable displayTable;
    private JLabel status;

    public BaggageGUI( CheckInApp app, Passenger passengerInfo, Flight flightInfo ) {
        this.app = app;
        this.passengerInfo = passengerInfo;
        this.flightInfo = flightInfo;
        status.setVisible(false);

        updateDisplay( flightInfo, passengerInfo );
        checkInButton.setVisible(false);
        calculateExcessFeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                status.setVisible(false);
                try {
                    double weight = Double.parseDouble(baggageWeight.getText().trim());
                    double height = Double.parseDouble(baggageHeight.getText().trim());
                    double length = Double.parseDouble(baggageLength.getText().trim());
                    double breath = Double.parseDouble(baggageBreath.getText().trim());
                    if(weight < 0) {
                        status.setText("<html><font color = 'red'>"
                                + "The weight is invalid!: "+weight+"</font>"
                                + "</html>");
                        status.setVisible(true);
                        return;
                    }
                    if(height < 0) {
                        status.setText("<html><font color = 'red'>"
                                + "The height is invalid!: "+height+"</font>"
                                + "</html>");
                        status.setVisible(true);
                        return;
                    }
                    if(length < 0) {
                        status.setText("<html><font color = 'red'>"
                                + "The length is invalid!: "+length+"</font>"
                                + "</html>");
                        status.setVisible(true);
                        return;
                    }
                    if(breath < 0) {
                        status.setText("<html><font color = 'red'>"
                                + "The breath is invalid!: "+breath+"</font>"
                                + "</html>");
                        status.setVisible(true);
                        return;
                    }
                    baggageInfo= new Baggage(weight, height, length, breath);
                    chargeInfo = app.calculateExcessBaggage(flightInfo, baggageInfo);
                    feePane.setText(String.format("$%.2f",chargeInfo));
                    checkInButton.setVisible(true);
                    JOptionPane.showMessageDialog(calculateExcessFeeButton, String.format("Kindly know that you would be charged at the counter a fee of $: %.2f\nKindly check-in to proceed", chargeInfo));
                } catch (NumberFormatException exerpt) {
                    status.setText("<html><font color = 'red'>"
                            + "Invalid input! : " + exerpt.getMessage()+"</font>"
                            + "</html>");
                    status.setVisible(true);
                }
            }
        });
        checkInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.checkIn(passengerInfo.getBookingRef());
                app.updateFlightDetails(flightInfo.getFlightCode(),baggageInfo.getVolume(),baggageInfo.getWeight(),chargeInfo);
                JOptionPane.showMessageDialog(checkInButton,"Passenger with the record below is checked in: \n\tBooking Ref: "+passengerInfo.getBookingRef().trim()+"\n\tLastname: "+passengerInfo.getLastName().trim());
                dispose();
                CheckInGUI checkIn = new CheckInGUI(app);
                checkIn.showCheckInGUI();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                CheckInGUI checkIn = new CheckInGUI(app);
                checkIn.showCheckInGUI();
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                app.generateFlightReport();
            }
        });
    }

    public void showBaggageGUI(){
        setContentPane(BaggageGUI);
        setTitle("HW Airport CheckIn System");
        setSize(600, 300);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void updateDisplay( Flight flightInfo, Passenger passengerInfo ){

        DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Field", "Value"}, 0);
        tableModel.addRow(new Object[]{"Booking Reference:", passengerInfo.getBookingRef()});
        tableModel.addRow(new Object[]{"Name", passengerInfo.getFirstName() + " " + passengerInfo.getLastName()});
        tableModel.addRow(new Object[]{"Flight No:", flightInfo.getFlightCode()});
        tableModel.addRow(new Object[]{"Destination:", flightInfo.getDestination()});
        tableModel.addRow(new Object[]{"Carrier:", flightInfo.getCarrier()});
        tableModel.addRow(new Object[]{"Departure Time:", flightInfo.getDepartureTime()});
        displayTable.setModel(tableModel);
        displayTable.setEnabled(false);
        displayTable.setFocusable(false);
        displayTable.setRowSelectionAllowed(false);
        displayTable.setColumnSelectionAllowed(false);
    }
}
