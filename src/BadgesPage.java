import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class BadgesPage extends JFrame implements ActionListener {

    JFrame badgesPage = new JFrame("LitoDSA");
    JPanel badgePanel = new JPanel();
    JLabel badgeTitlePage = new JLabel("BADGES");
    private static Badges badge1 = new Badges("WELCOME","COMPLETE 1 QUEST",false);
    private static Badges badge2 = new Badges("BEGINNER","COMPLETE 5 QUESTS",false);
    private static Badges badge3 = new Badges("KEEP GOING!","COMPLETE 15 QUESTS",false);
    private static Badges badge4 = new Badges("FAST LEARNER","OBTAIN THE GOLD RANK",false);
    private static Badges badge5 = new Badges("RICH LEARNER","OBTAIN 500 TOKENS",false);


    private void updateGuestInfo() {
        String newBadgeName = null;

        if (Guest.getQuests() >= 1 && !badge1.isEarned()) {
            newBadgeName = badge1.getBadgeName() + " (EARNED)";
        } else if (Guest.getQuests() >= 5 && !badge2.isEarned()) {
            newBadgeName = badge2.getBadgeName() + " (EARNED)";
        } else if (Guest.getQuests() >= 15 && !badge3.isEarned()) {
            newBadgeName = badge3.getBadgeName() + " (EARNED)";
        } else if (Guest.getRank().equals("GOLD") && !badge4.isEarned()) {
            newBadgeName = badge4.getBadgeName() + " (EARNED)";
        } else if (Guest.getTokens() >= 500 && !badge5.isEarned()) {
            newBadgeName = badge5.getBadgeName() + " (EARNED)";
        }

        if (newBadgeName != null) {
            JOptionPane.showMessageDialog(this, "You have earned a new badge!");
            switch (newBadgeName) {
                case "WELCOME (EARNED)":
                    badge1.setEarned(true);
                    badge1.setBadgeName(newBadgeName);
                    newBadgeName = null;
                    break;
                case "BEGINNER (EARNED)":
                    badge2.setEarned(true);
                    badge2.setBadgeName(newBadgeName);
                    newBadgeName = null;
                    break;
                case "KEEP GOING! (EARNED)":
                    badge3.setEarned(true);
                    badge3.setBadgeName(newBadgeName);
                    newBadgeName = null;
                    break;
                case "FAST LEARNER (EARNED)":
                    badge4.setEarned(true);
                    badge4.setBadgeName(newBadgeName);
                    newBadgeName = null;
                    break;
            }
        }
    }

    BadgesPage(){

        updateGuestInfo();

        JLabel badgeTitle1 = new JLabel(badge1.getBadgeName());
        JLabel badgeTitle2 = new JLabel(badge2.getBadgeName());
        JLabel badgeTitle3 = new JLabel(badge3.getBadgeName());
        JLabel badgeTitle4 = new JLabel(badge4.getBadgeName());
        JLabel badgeTitle5 = new JLabel(badge5.getBadgeName());
        JLabel badgeDec1 = new JLabel(badge1.getBadgeDec());
        JLabel badgeDec2 = new JLabel(badge2.getBadgeDec());
        JLabel badgeDec3 = new JLabel(badge3.getBadgeDec());
        JLabel badgeDec4 = new JLabel(badge4.getBadgeDec());
        JLabel badgeDec5 = new JLabel(badge5.getBadgeDec());

        Font customFont = null;
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("ARCADECLASSIC.TTF"));
            customFont = customFont.deriveFont(Font.PLAIN, 20);

            badgeTitlePage.setFont(customFont.deriveFont(Font.PLAIN, 24));
            badgeTitle1.setFont(customFont.deriveFont(Font.PLAIN, 20));
            badgeTitle2.setFont(customFont.deriveFont(Font.PLAIN, 20));
            badgeTitle3.setFont(customFont.deriveFont(Font.PLAIN, 20));
            badgeTitle4.setFont(customFont.deriveFont(Font.PLAIN, 20));
            badgeTitle5.setFont(customFont.deriveFont(Font.PLAIN, 20));
            badgeDec1.setFont(customFont.deriveFont(Font.PLAIN, 16));
            badgeDec2.setFont(customFont.deriveFont(Font.PLAIN, 16));
            badgeDec3.setFont(customFont.deriveFont(Font.PLAIN, 16));
            badgeDec4.setFont(customFont.deriveFont(Font.PLAIN, 16));
            badgeDec5.setFont(customFont.deriveFont(Font.PLAIN, 16));


        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }


        badgesPage.setSize(600, 600);
        badgesPage.getContentPane().setBackground(Color.decode("#A384D0"));
        badgesPage.setResizable(false);
        badgesPage.setIconImage(new ImageIcon("icon.png").getImage());
        badgesPage.setLayout(null);

        badgePanel.setLayout(null);
        badgePanel.setBounds(40, 40, 500, 500);
        badgePanel.setBackground(Color.decode("#84D0A3"));

        badgeTitlePage.setBounds(200,0,200,150);

        badgeTitle1.setBounds(50,70,500,100);
        badgeDec1.setBounds(50,90,300,100);

        badgeTitle2.setBounds(50,130,500,100);
        badgeDec2.setBounds(50,150,500,100);

        badgeTitle3.setBounds(50,190,500,100);
        badgeDec3.setBounds(50,210,500,100);

        badgeTitle4.setBounds(50,260,500,100);
        badgeDec4.setBounds(50,280,500,100);

        badgeTitle5.setBounds(50,320,500,100);
        badgeDec5.setBounds(50,340,500,100);

        badgePanel.add(badgeTitle1);
        badgePanel.add(badgeDec1);
        badgePanel.add(badgeTitle2);
        badgePanel.add(badgeDec2);
        badgePanel.add(badgeTitle3);
        badgePanel.add(badgeDec3);
        badgePanel.add(badgeTitle4);
        badgePanel.add(badgeDec4);
        badgePanel.add(badgeTitle5);
        badgePanel.add(badgeDec5);
        badgePanel.add(badgeTitlePage);
        badgesPage.add(badgePanel);
        badgesPage.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
