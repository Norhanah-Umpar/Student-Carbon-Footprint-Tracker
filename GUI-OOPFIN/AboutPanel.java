import javax.swing.*;
import java.awt.*;

public class AboutPanel {
    private JPanel panel;

    public AboutPanel() {
        panel = new JPanel(new BorderLayout());

        JLabel aboutLabel = new JLabel("  ABOUT");
        aboutLabel.setFont(new Font("SansSerif", Font.PLAIN, 40));
        aboutLabel.setForeground(new Color(0, 100, 0));
        // panel.setBackground(new Color(187, 214, 108));
        panel.setBackground(Color.WHITE);
        panel.add(aboutLabel, BorderLayout.NORTH);

        JPanel textimagePanel = new JPanel(new BorderLayout()); 

        JTextArea aboutTextArea = new JTextArea();
        aboutTextArea.setLineWrap(true);
        aboutTextArea.setWrapStyleWord(true);
        aboutTextArea.setEditable(false);
        aboutTextArea.setBackground(new Color(121, 180, 101));
        aboutTextArea.setBorder(null);
        
        Font textAreaFont = new Font("SansSerif", Font.PLAIN, 20);
        aboutTextArea.setFont(textAreaFont);
        aboutTextArea.setForeground(Color.WHITE);

        aboutTextArea.setText("Education isn't just about learning; it's about the tools we use and their environmental impact. " +
                "The Carbon Footprint Tracker presented herein is grounded in an in-depth analysis conducted under the research titled \"Analysis of Students' Carbon Footprint in Higher Education Institutions Amidst the Pandemic.\""+
                "This tracker provides a comprehensive examination of the environmental impact of students' activities during the pandemic, offering valuable insights into their carbon footprint within higher education institutions. \n\n" +
                "The activities, along with their respective CO2 emission factors, were subsequently subjected to calculations using activity intensity."+
                "These intensities were then multiplied by emission factors obtained from other studies to determine the individuals' carbon footprints. \n\n" +
                "This tracker is designed to utilize the study, allowing users to gain an understanding of their carbon footprint and serving as a means of raising awareness." +
                "Understanding this carbon footprint is vital for sustainable education. Raising awareness about eco-friendly practices with school supplies, " +
                "like adopting energy-efficient devices and promoting digital submissions, can significantly reduce this impact. " +
                "Integrating sustainability into the curriculum empowers students to make informed choices, minimizing their environmental footprint.\n\n" +
                "Ultimately, acknowledging and addressing the carbon footprint tied to educational tools is pivotal. " +
                "Educational institutions can pioneer environmentally conscious practices among students, forging a more sustainable path forward.\n");

        JScrollPane scrollPane = new JScrollPane(aboutTextArea);
        textimagePanel.add(scrollPane, BorderLayout.CENTER);
        
        ImageIcon image = new ImageIcon("photos/CO2e.png");
        Image scaledImage = image.getImage().getScaledInstance(300, 555, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

        JLabel imageLabel = new JLabel(scaledImageIcon);
        textimagePanel.add(imageLabel, BorderLayout.WEST);

        // Add the text and image panel to the main panel
        panel.add(textimagePanel, BorderLayout.CENTER);
    }

    public JPanel getPanel() {
        return panel;
    }
}
