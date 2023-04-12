import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class RulesPage extends JFrame implements ActionListener {

    JFrame rulesPage = new JFrame("LitoDSA");
    JLabel title = new JLabel("RULES");
    JPanel contentPanel = new JPanel();

    JLabel rule1 = new JLabel("CONSULT YOUR TEACHER ABOUT CHECKING THE QUESTS");
    JLabel rule2 = new JLabel("WHEN CREATING A QUEST IT MUST FOCUS ON THE TOPIC");
    JLabel rule3 = new JLabel("MORE KNOWLEDGE MEANS HIGHER RANK SO KEEP LEARNING");
    JLabel rule4 = new JLabel("MOST IMPORTANT RULE HAVE FUN LEARNING");
    JLabel rule5 = new JLabel("EVERY COMPLETED QUEST IS REWARDED WITH 20 TOKENS");

    RulesPage(){

        Font customFont = null;
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("ARCADECLASSIC.TTF"));
            customFont = customFont.deriveFont(Font.PLAIN, 20);

            title.setFont(customFont.deriveFont(Font.PLAIN, 28));
            rule1.setFont(customFont.deriveFont(Font.PLAIN, 17));
            rule2.setFont(customFont.deriveFont(Font.PLAIN, 17));
            rule3.setFont(customFont.deriveFont(Font.PLAIN, 17));
            rule4.setFont(customFont.deriveFont(Font.PLAIN, 17));
            rule5.setFont(customFont.deriveFont(Font.PLAIN, 17));

        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        rulesPage.setSize(600, 600);
        rulesPage.getContentPane().setBackground(Color.decode("#A384D0"));
        rulesPage.setResizable(false);
        rulesPage.setIconImage(new ImageIcon("icon.png").getImage());
        rulesPage.setLayout(null);

        contentPanel.setLayout(null);
        contentPanel.setBounds(55, 55, 450, 450);
        contentPanel.setBackground(Color.decode("#84D0A3"));

        title.setBounds(200,40,100,100);

        rule1.setBounds(10,100,500,100);
        rule2.setBounds(10,150,500,100);
        rule3.setBounds(10,200,500,100);
        rule4.setBounds(10,250,500,100);
        rule5.setBounds(10,300,500,100);

        contentPanel.add(title);
        contentPanel.add(rule1);
        contentPanel.add(rule2);
        contentPanel.add(rule3);
        contentPanel.add(rule4);
        contentPanel.add(rule5);
        rulesPage.add(contentPanel);
        rulesPage.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
