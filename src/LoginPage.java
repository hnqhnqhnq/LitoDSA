import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoginPage extends JFrame implements ActionListener {

    JFrame loginPage = new JFrame("LitoDSA");
    JButton submitButton = new JButton("SUBMIT");
    JTextField userField = new JTextField();
    JPasswordField passField = new JPasswordField();
    JPanel loginPanel = new JPanel();
    JLabel userLabel = new JLabel("USER ");
    JLabel passLabel = new JLabel("PASS ");
    JLabel titleLabelDown = new JLabel("DATA  STRUCTURES  AND  ALGORITHMS");
    JLabel titleLabelUp = new JLabel("LITO");

    LoginPage() {

        Font customFont = null;
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("ARCADECLASSIC.TTF"));
            customFont = customFont.deriveFont(Font.PLAIN, 20);

            userLabel.setFont(customFont.deriveFont(Font.PLAIN, 16));
            passLabel.setFont(customFont.deriveFont(Font.PLAIN, 16));
            passField.setFont(customFont.deriveFont(Font.PLAIN, 16));
            userField.setFont(customFont.deriveFont(Font.PLAIN, 16));
            submitButton.setFont(customFont.deriveFont(Font.PLAIN, 16));
            titleLabelDown.setFont(customFont.deriveFont(Font.PLAIN, 32));
            titleLabelUp.setFont(customFont.deriveFont(Font.PLAIN, 32));

        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        loginPage.setSize(600, 600);
        loginPage.getContentPane().setBackground(Color.decode("#A384D0"));
        loginPage.setResizable(false);
        loginPage.setIconImage(new ImageIcon("icon.png").getImage());
        loginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginPage.setLayout(null);

        loginPanel.setLayout(null);
        loginPanel.setBounds(200, 350, 200, 150);
        loginPanel.setBackground(Color.decode("#84D0A3"));

        userField.setBounds(55, 25, 100, 25);

        passField.setBounds(55,65,100,25);

        userLabel.setBounds(15,25,100,25);

        passLabel.setBounds(15,65,100,25);

        submitButton.setBounds(55,110,100,25);
        submitButton.addActionListener(this);
        submitButton.setFocusable(false);

        titleLabelDown.setBounds(45, 85, 500, 200);
        //titleLabel.setIcon(new ImageIcon("title-export.png"));
        titleLabelUp.setBounds(245, 60, 500, 200);

        loginPanel.add(submitButton);
        loginPanel.add(userLabel);
        loginPanel.add(passLabel);
        loginPanel.add(passField);
        loginPanel.add(userField);
        loginPage.add(loginPanel);
        loginPage.add(titleLabelDown);
        loginPage.add(titleLabelUp);
        titleLabelUp.setVisible(true);
        titleLabelDown.setVisible(true);
        loginPage.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    if(e.getSource()==submitButton){
        String username = userField.getText();
        String password = new String(passField.getText());

        if(username.equals("guest") && password.equals("12345"))
        {
            loginPage.dispose();
            Guest guest = new Guest();
            MainPage mainPage = new MainPage(guest);
        }
        else{
            JOptionPane.showMessageDialog(this,"Please use a valid account!");
        }
    }

    }
}
