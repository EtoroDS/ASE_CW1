import javax.swing.*;
import java.awt.event.*;

public class CheckInGUI extends JFrame {
    private CheckInApp app;
    private JPanel CheckInAppGUI;
    private JTextField bookingReferenceTextField;
    private JTextField lastNameTextField;
    private JButton searchButton;
    private JLabel lastNameLabel;
    private JLabel bookingReferenceLabel;
    private JLabel status;

    public CheckInGUI(CheckInApp app) {
        this.app = app;
        status.setVisible(false);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                status.setVisible(false);
                if (bookingReferenceTextField.getText().trim().isEmpty()){
                    status.setText("<html><font color = 'red'>"
                            + "Please supply a booking reference!</font>"
                            + "</html>");
                    status.setVisible(true);
                    return;
                }
                if (!bookingReferenceTextField.getText().trim().matches("[a-zA-Z0-9]{6}")){
                    status.setText("<html><font color = 'red'>"
                            + "Invalid booking reference!</font>"
                            + "</html>");
                    status.setVisible(true);
                    return;
                }
                if(lastNameTextField.getText().trim().isEmpty()) {
                    status.setText("<html><font color = 'red'>"
                            + "Please supply a last name!</font>"
                            + "</html>");
                    status.setVisible(true);
                    return;
                }
                if(!lastNameTextField.getText().trim().matches("[a-zA-Z:-]+")) {
                    status.setText("<html><font color = 'red'>"
                            + "Last name entered is invalid !</font>"
                            + "</html>");
                    status.setVisible(true);
                    return;
                }
                Passenger passengerInfo =  app.searchBooking(bookingReferenceTextField.getText().trim(),lastNameTextField.getText().trim());
                if (passengerInfo != null && !(app.isCheckedIn(bookingReferenceTextField.getText().trim()))) {
                    Flight flightInfo = app.getFlightDetails(passengerInfo.getFlightCode());
                    dispose();
                    BaggageGUI baggageGUI = new BaggageGUI(app, passengerInfo, flightInfo);
                    baggageGUI.showBaggageGUI();
                }
                else {
                    if (passengerInfo == null) {
                        JOptionPane.showMessageDialog(searchButton,"There is no record for passenger with: \n\tBooking Ref: "+ bookingReferenceTextField.getText().trim()+"\n\tLastname: "+lastNameTextField.getText().trim());
                        status.setText("<html><font color = 'red'>There is no record for passenger with Booking Ref: "+ bookingReferenceTextField.getText().trim()+" & Lastname: "+lastNameTextField.getText().trim() + "</font></html>");
                    }
                    if (passengerInfo != null && app.isCheckedIn(bookingReferenceTextField.getText().trim())) {
                        JOptionPane.showMessageDialog(searchButton,"Passenger with the record below is checked in: \n\tBooking Ref: "+ bookingReferenceTextField.getText().trim()+"\n\tLastname: "+lastNameTextField.getText().trim());
                    }
                }
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                app.generateFlightReport();
            }
        });
    }
    public void showCheckInGUI(){
        setContentPane(CheckInAppGUI);
        setTitle("HW Airport CheckIn System");
        setSize(600, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        CheckInApp app = new CheckInApp();
        CheckInGUI checkIn = new CheckInGUI(app);
        checkIn.showCheckInGUI();
    }

}
