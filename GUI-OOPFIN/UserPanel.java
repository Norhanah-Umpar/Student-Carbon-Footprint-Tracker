import javax.swing.*;
import java.awt.*;

public class UserPanel {
    private JPanel userPanel;

    public UserPanel() {
        userPanel = new JPanel(new BorderLayout());
        userPanel.setBackground(Color.WHITE);

        // Label for "User Profile" at the top
        JLabel userLabelTop = new JLabel("User Profile");
        userLabelTop.setFont(new Font("SansSerif", Font.PLAIN, 40));
        userLabelTop.setForeground(new Color(0, 100, 0));
        userPanel.add(userLabelTop, BorderLayout.NORTH);

        // Panel for the image with GridBagLayout
        JPanel imagePanel = new JPanel(new GridBagLayout());
        //imagePanel.setBackground(Color.WHITE);//background of the panel //new
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;

        ImageIcon image = new ImageIcon("photos/chicken.png");
        Image scaledImage = image.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

        JLabel imageLabel = new JLabel(scaledImageIcon);
        gbc.anchor = GridBagConstraints.CENTER;
        imagePanel.add(imageLabel, gbc);

        // Labels for the user information using GridLayout
        JPanel infoPanel = new JPanel(new GridLayout(4, 1, 0, 5));
        //infoPanel.setBackground(Color.WHITE);

        String username = new String(LoginGUI.getUsername());
        String email = new String(RegisterPanel.getEmail());
        String firstname = new String(RegisterPanel.getFirstname());
        String lastname = new String(RegisterPanel.getLastname());
        
        Font labelFont = new Font("SansSerif", Font.PLAIN, 30);
        Color labelColor = new Color(0, 100, 0);

        JLabel usernameLabel = new JLabel(username, SwingConstants.CENTER);
        JLabel emailLabel = new JLabel(email, SwingConstants.CENTER);
        JLabel firstnameLabel = new JLabel(firstname, SwingConstants.CENTER);
        JLabel lastnameLabel = new JLabel(lastname, SwingConstants.CENTER);

        usernameLabel.setFont(labelFont);
        usernameLabel.setForeground(labelColor);
        emailLabel.setFont(labelFont);
        emailLabel.setForeground(labelColor);
        firstnameLabel.setFont(labelFont);
        firstnameLabel.setForeground(labelColor);
        lastnameLabel.setFont(labelFont);
        lastnameLabel.setForeground(labelColor);

        infoPanel.add(usernameLabel);
        infoPanel.add(emailLabel);
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        namePanel.add(firstnameLabel);//new
        namePanel.add(new JLabel(" "));//new
        namePanel.add(lastnameLabel);//new

        infoPanel.add(namePanel);

        // Add the infoPanel to the imagePanel
        gbc.gridy = 1;
        imagePanel.add(infoPanel, gbc);

        // Add the imagePanel to the userPanel
        userPanel.add(imagePanel, BorderLayout.CENTER);
    
    }

    public JPanel getPanel() {
        return userPanel;
    }
}