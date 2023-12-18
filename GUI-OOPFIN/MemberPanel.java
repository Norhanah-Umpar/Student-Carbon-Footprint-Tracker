import javax.swing.*;
import java.awt.*;

public class MemberPanel {
    private JPanel panel;

    public MemberPanel() {
        panel = new JPanel(new BorderLayout());

        JLabel trackerLabel = new JLabel("MEMBERS");
        JLabel smallLabel = new JLabel("People behind the STUDENT CARBON FOOTPRINT TRACKER");

        trackerLabel.setFont(new Font("SansSerif", Font.PLAIN, 40));
        trackerLabel.setForeground(new Color(0, 100, 0));
        panel.setBackground(Color.WHITE);

        smallLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
        smallLabel.setForeground(new Color(0, 100, 0));

        panel.add(trackerLabel, BorderLayout.NORTH);
        panel.add(smallLabel, BorderLayout.SOUTH);

        JPanel memberNamesPanel = new JPanel(new GridLayout(2, 4, 10, 10));
        memberNamesPanel.setBackground(Color.WHITE);

        addMemberWithImage(memberNamesPanel, "Umpar, Norhanah", "photos/umpar.jpg");
        addMemberWithImage(memberNamesPanel, "Gutierrez, Mj", "photos/mj.jpg");
        addMemberWithImage(memberNamesPanel, "Lopez, Marcielo", "photos/marcielo.jpg");
        addMemberWithImage(memberNamesPanel, "Moritcho, Ruby John", "photos/moritcho.jpg");
        addMemberWithImage(memberNamesPanel, "Halasan, Xavier", "photos/halasan.jpg");
        addMemberWithImage(memberNamesPanel, "Cayacap, Al", "photos/cayacap.jpg");
        addMemberWithImage(memberNamesPanel, "Armenion, Reymar", "photos/armenion.jpg");
        addMemberWithImage(memberNamesPanel, "Manloloyo, Benedict", "photos/manloloyo.jpg");

        panel.add(memberNamesPanel, BorderLayout.CENTER);
    }

    private void addMemberWithImage(JPanel panel, String memberName, String imagePath) {
        JPanel memberPanel = new JPanel(new BorderLayout());
        memberPanel.setBackground(new Color(121, 180, 101));

        // Load and resize the image
        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(350, 300, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        // Image label
        JLabel imageLabel = new JLabel(resizedIcon);
        memberPanel.add(imageLabel, BorderLayout.CENTER);

        // Name label
        JLabel nameLabel = new JLabel(memberName);
        nameLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setForeground(Color.WHITE);
        memberPanel.add(nameLabel, BorderLayout.SOUTH);

        panel.add(memberPanel);
    }

    public JPanel getPanel() {
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("MemberPanel Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setContentPane(new MemberPanel().getPanel());
            frame.setVisible(true);
        });
    }
}
