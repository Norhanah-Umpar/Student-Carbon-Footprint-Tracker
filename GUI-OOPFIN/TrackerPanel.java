import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrackerPanel {
    private JPanel panel;
    private JButton calculateButton;
    private JTextArea resultTextArea;

    public TrackerPanel() {
        panel = new JPanel(new BorderLayout());

        JLabel trackerLabel = new JLabel("CALCULATE YOUR CARBON FOOTPRINT");
        trackerLabel.setFont(new Font("SansSerif", Font.PLAIN, 40));
        trackerLabel.setForeground(new Color(0, 100, 0));
        trackerLabel.setBackground(Color.WHITE);
        
        panel.add(trackerLabel, BorderLayout.NORTH);

        // Create the text area to display results
        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);
        
        // Create the button to calculate carbon footprint
        calculateButton = new JButton("Press to Calculate Carbon Footprint");
        calculateButton.setBackground(new Color(144, 238, 144));
        calculateButton.setPreferredSize(new Dimension(140, 40));
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateCarbonFootprint();
            }
        });

        // Add components to the panel
        panel.add(resultTextArea, BorderLayout.CENTER);
        panel.add(calculateButton, BorderLayout.SOUTH);
    }

    private void calculateCarbonFootprint() {
    double totalCO2 = getCarbonFootprint();

    // Display the results in the text area
    resultTextArea.setFont(new Font("SansSerif", Font.PLAIN, 24));
    resultTextArea.setForeground(new Color(0, 100, 0));

    ImageIcon tableImage = new ImageIcon("photos/formula.png");
    Image scaledImage = tableImage.getImage().getScaledInstance(800, 400, Image.SCALE_SMOOTH);
    ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

    JLabel imageLabel = new JLabel(scaledImageIcon);

    // Set the layout to BorderLayout
    resultTextArea.setLayout(new BorderLayout());

    // Set the text at the CENTER position
    resultTextArea.setText("Total Carbon Footprint Estimate: " + totalCO2 + "\n");

    if (totalCO2 > 2554.59) {
        resultTextArea.append(
                "Your Carbon footprint is higher than the average yearly 2554.59 tons per person.\n" +
                        "Please reevaluate your daily life to reduce your CO2 emission");
    } else if (totalCO2 < 2554.59) {
        resultTextArea.append("Your Carbon footprint is lower than the average yearly 2554.59 tons per person.\n" +
                "Please keep up this habit");
    }

    // Add the image at the SOUTH position
    resultTextArea.add(imageLabel, BorderLayout.SOUTH);
}


    private double getCarbonFootprint() {
        double electricityUsage = getDoubleInput("How many kiloWatts does your household use in a month? Please refer to your electric bill")* 0.548*12;
        double lpgUsage = getDoubleInput("How many kilograms of LPG does your household use in a year? Please refer to your recent purchase and multiply it to the times you bought")*3.02;

        double porkConsumption = getDoubleInput("How often do you eat pork in a week?") * 0.0292 * 52 * 12.1;
        double chickenConsumption = getDoubleInput("How often do you eat chicken in a week?") * 0.0366 * 52 * 6.9;
        double vegetableConsumption = getDoubleInput("How often do you eat vegetables in a week?") * 0.123 * 52 * 2.0;
        double fishConsumption = getDoubleInput("How often do you eat fish in a week?") * 0.0986 * 52 * 6.1;

        double computerUsageCO2 = getDoubleInput("How many hours do you use your Personal Computer in a day?") * 0.079
                * 365;
        double scannedPagesCO2 = getDoubleInput("How many pages do you scan in a month?") * 0.0013 * 12;
        double printedPagesCO2 = getDoubleInput("How many pages do you print in a month?") * 0.0043 * 12;
        double smartphoneUsageCO2 = getDoubleInput("How many hours do you use your smartphone?") * 0.011 * 365;

        double disHoSch = getDoubleInput("Estimated kilometers from school to home:");
        double jeepCO2 = getDoubleInput("How many times do you use a multicab/jeep in a month?") * 0.022 * disHoSch * 30
                * 12;
        double busCO2 = getDoubleInput("How many times do you use a bus in a month?") * 0.015 * disHoSch * 30 * 12;
        double vanCO2 = getDoubleInput("How many times do you use a van in a month?") * 0.029 * disHoSch * 30 * 12;
        double tricycleCO2 = getDoubleInput("How many times do you use a tricycle in a month?") * 0.022 * disHoSch * 30
                * 12;
        double bikeCO2 = getDoubleInput("How many times do you use a bicycle in a month?") * 0;

        double carCO2 = 0.0;
        String ans;
        do {
            ans = JOptionPane.showInputDialog(panel, "Do you have your own personal car? a)YES b)NO").toLowerCase();
            if (ans.equals("a")) {
                String fuel;
                do {
                    fuel = JOptionPane
                            .showInputDialog(panel,
                                    "If you have a personal car, what type of fuel do you use? a)diesel b)gasoline c)unleaded")
                            .toLowerCase();
                    if (fuel.equals("a")) {
                        carCO2 = getDoubleInput(
                                "How many liters of diesel do you use for your personal car in a month?") * 2.64
                                * disHoSch * 12;
                    } else if (fuel.equals("b")) {
                        carCO2 = getDoubleInput(
                                "How many liters of gasoline do you use for your personal car in a month?")
                                * 2.30 * disHoSch * 12;
                    } else if (fuel.equals("c")) {
                        carCO2 = getDoubleInput(
                                "How many liters of unleaded do you use for your personal car in a month?")
                                * 2.39 * disHoSch * 12;
                    } else {
                        JOptionPane.showMessageDialog(panel, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } while (!fuel.equals("a") && !fuel.equals("b") && !fuel.equals("c"));
            } else if (!ans.equals("b")) {
                JOptionPane.showMessageDialog(panel, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (!ans.equals("a") && !ans.equals("b"));

        double airplaneCO2 = 0.0;
        String ans2;
        do {
            ans2 = JOptionPane.showInputDialog(panel, "Did you ride an airplane this year? a)YES b)NO").toLowerCase();
            if (ans2.equals("a")) {
                //double ride = getDoubleInput("How many times did you ride an airplane this year");
                //if (ride > 0) {
                    airplaneCO2 = getDoubleInput("Input the estimated kilometers of your airplane ride") * 12.7; //* ride;
                //}
            } else if (!ans2.equals("b")) {
                JOptionPane.showMessageDialog(panel, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (!ans2.equals("a") && !ans2.equals("b"));

        return electricityUsage + lpgUsage + porkConsumption + chickenConsumption +
                vegetableConsumption + fishConsumption + computerUsageCO2 +
                scannedPagesCO2 + printedPagesCO2 + smartphoneUsageCO2 +
                jeepCO2 + vanCO2 + busCO2 + bikeCO2 + tricycleCO2 +
                carCO2 + airplaneCO2;
    }

    private double getDoubleInput(String question) {
        String userInput = JOptionPane.showInputDialog(panel, question);
        try {
            return Double.parseDouble(userInput);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(panel, "Invalid input. Please enter a numerical value.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return getDoubleInput(question);
        }
    }

    public JPanel getPanel() {
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Carbon Footprint Tracker");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                TrackerPanel trackerPanel = new TrackerPanel();
                frame.add(trackerPanel.getPanel());

                frame.setSize(400, 300);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}