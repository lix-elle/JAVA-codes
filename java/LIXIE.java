import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LIXIE {
    public static void main(String[] args) {
        JFrame frame = new JFrame("** L I X I E **");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center window
        ImageIcon icon = new ImageIcon("C:/Users/Lynsy/OneDrive/Desktop/Programming/Java programs/LOGIN Program/kitty2.jpg");
        frame.setIconImage(icon.getImage()); //icon sa frame
        
        // Create a custom panel with an image background
        BackgroundPanel panel = new BackgroundPanel("C:/Users/Lynsy/OneDrive/Desktop/Programming/Java programs/LOGIN Program/download (4).jpg");
        panel.setLayout(new GridBagLayout()); // Use GridBagLayout
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        JLabel title = new JLabel("Login", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.BOLD,90));
        title.setForeground(new Color(208, 240, 192)); // Make text visible over the image
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(title, gbc);

        // Username Label
        JLabel userLabel = new JLabel("Username:");
        userLabel.setFont(new Font("OLD BAKERSVILLE", Font.BOLD, 28));
        userLabel.setForeground(new Color(0, 100, 0));
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1;
        panel.add(userLabel, gbc);

        // Username Field
        JTextField userText = new JTextField(20);
        gbc.gridx = 1; gbc.gridy = 1;
        gbc.ipadx = 0; // Width padding (resize width)
        gbc.ipady = 10;  // Height padding (resize height)
        userText.setFont(new Font("Courier New", Font.BOLD, 15));
        userText.setForeground(new Color (34, 139, 34));
        panel.add(userText, gbc);

        // Password Label
        JLabel passLabel = new JLabel("Password:");
        passLabel.setFont(new Font("OLD BAKERSVILLE", Font.BOLD, 28));
        passLabel.setForeground(new Color(0, 100, 0));
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(passLabel, gbc);

        // Password Field
        JPasswordField passText = new JPasswordField(15);
        gbc.gridx = 1; gbc.gridy = 2;
        passText.setForeground(new Color(34, 139, 34));
        panel.add(passText, gbc);      

        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(new Color(34, 150, 34));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("OLD BAKERSVILLE", Font.BOLD,20));
        
        
        gbc.gridx = 0; gbc.gridy = 10; gbc.gridwidth = 10;
        panel.add(loginButton, gbc);
        
        loginButton.addActionListener(e -> 
        {
            String username = userText.getText();
            String password = new String(passText.getPassword());
            
            //UIManager.put("OptionPane.background", new Color(208, 240, 192));
            //UIManager.put("Panel.background", new Color(208, 240, 192));
            UIManager.put("OptionPane.messageFont", new Font("OLD BAKERSVILLE", Font.BOLD, 15));
            
            if(username.equals("LIXIE") && password.equals("qtsisirjewel"))
            {  
               UIManager.put("OptionPane.background", new Color(208, 240, 192));
               UIManager.put("Panel.background", new Color(208, 240, 192));
               UIManager.put("OptionPane.messageForeground", new Color(34, 139, 34));
               UIManager.put("Button.background", new Color(34, 139, 34));
               UIManager.put("Button.foreground", Color.WHITE); 

               JOptionPane.showMessageDialog(frame, "Successfully Logged IN! ^^");
            }
            else
            {
               UIManager.put("OptionPane.background", new Color(255, 194, 194));
               UIManager.put("Panel.background", new Color(255, 194, 194));
               UIManager.put("OptionPane.messageForeground", new Color(178, 34, 34));   
               UIManager.put("Button.background", new Color(178, 34, 34)); // Red Button
               UIManager.put("Button.foreground", Color.WHITE); // White Text on Button
            
               JOptionPane.showMessageDialog(frame, "Invalid credentials :<");
            }
        });

        // Add panel to frame
        frame.add(panel);
        frame.setVisible(true);
        
    }
}

// Custom JPanel to Paint Background Image
class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(String imagePath) {
        backgroundImage = new ImageIcon("C:/Users/Lynsy/OneDrive/Desktop/Programming/Java programs/LOGIN Program/download (4).jpg").getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
