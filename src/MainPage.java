import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MainPage extends JFrame implements ActionListener {

//    Quests quest1 = new Quests("SINGLE LINKED LISTS", "REVERSE A SINGLE LINKED LIST");
//    Quests quest2 = new Quests("SINGLE LINKED LISTS", "DELETE THE FIRST NODE");
//    Quests quest3 = new Quests("SINGLE LINKED LISTS", "INSERT A KEY");
//    Quests quest4 = new Quests("SINGLE LINKED LISTS", "DELETE THE LAST NODE");
    //Guest guest = new Guest();
    JFrame mainPage = new JFrame("LitoDSA");
    JPanel leftPanel = new JPanel();
    JPanel mainPanel = new JPanel();
    JLabel nameProfile = new JLabel("NAME: GUEST");
    private static JLabel rankProfile = new JLabel("RANK: " + Guest.getRank());
    JLabel badgesProfile = new JLabel("BADGES: " + Guest.getBadgesNumber());
    JLabel tokensProfile = new JLabel("TOKENS: " + Guest.getTokens());
    JButton questButton = new JButton("QUESTS");
    JButton createQuestButton = new JButton("CREATE  QUEST");
    JButton badgesButton = new JButton("BADGES");
    JButton rulesButton = new JButton ("RULES");
    ImageIcon guestIcon = new ImageIcon("guestIcon.png");



    private void updateGuestInfo() {

        String newRank = null;

        if(Guest.getQuests()>=70){
            newRank = "DIAMOND";
        }
        else if(Guest.getQuests()>=45){
            newRank = "PLATINUM";
        }
        else if(Guest.getQuests()>=25){
            newRank = "GOLD";
        }
        else if(Guest.getQuests()>=10){
            newRank = "SILVER";
        }
        else if(Guest.getQuests()>=5){
            newRank = "BRONZE";
        }

        if (newRank != null && !newRank.equals(Guest.getRank())) {
            Guest.setRank(newRank);
            JOptionPane.showMessageDialog(this, "You have just ranked up to "+ Guest.getRank());
        }

        rankProfile.setText("RANK: " + Guest.getRank());
        badgesProfile.setText("BADGES: " + Guest.getBadgesNumber());
        tokensProfile.setText("TOKENS: " + Guest.getTokens());

    }

    MainPage(Guest guest){

        updateGuestInfo();

        rankProfile = new JLabel("RANK: " + Guest.getRank());
        badgesProfile = new JLabel("BADGES: " + Guest.getBadgesNumber());
        tokensProfile = new JLabel("TOKENS: " + Guest.getTokens());

        Font customFont = null;
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("ARCADECLASSIC.TTF"));
            customFont = customFont.deriveFont(Font.PLAIN, 20);

            badgesButton.setFont(customFont.deriveFont(Font.PLAIN, 24));
            questButton.setFont(customFont.deriveFont(Font.PLAIN, 24));
            createQuestButton.setFont(customFont.deriveFont(Font.PLAIN, 24));
            rulesButton.setFont(customFont.deriveFont(Font.PLAIN, 24));
            nameProfile.setFont(customFont.deriveFont(Font.PLAIN, 14));
            tokensProfile.setFont(customFont.deriveFont(Font.PLAIN, 18));
            badgesProfile.setFont(customFont.deriveFont(Font.PLAIN, 18));
            rankProfile.setFont(customFont.deriveFont(Font.PLAIN, 18));


        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }


        mainPage.setSize(600, 600);
        mainPage.getContentPane().setBackground(Color.decode("#A384D0"));
        mainPage.setResizable(false);
        mainPage.setIconImage(new ImageIcon("icon.png").getImage());
        mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPage.setLayout(new BorderLayout());

        leftPanel.setBackground(Color.decode("#84D0A3"));
        leftPanel.setPreferredSize(new Dimension(150,100));
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));

        mainPanel.setLayout(new GridLayout(2,2));
        mainPanel.setBackground(Color.decode("#A384D0"));

        badgesButton.addActionListener(this);
        badgesButton.setFocusable(false);
        badgesButton.setBackground(Color.decode("#A384D0"));

        createQuestButton.addActionListener(this);
        createQuestButton.setFocusable(false);
        createQuestButton.setBackground(Color.decode("#A384D0"));

        rulesButton.addActionListener(this);
        rulesButton.setFocusable(false);
        rulesButton.setBackground(Color.decode("#A384D0"));

        questButton.addActionListener(this);
        questButton.setFocusable(false);
        questButton.setBackground(Color.decode("#A384D0"));

        Image image  = guestIcon.getImage();
        Image newing = image.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
        guestIcon = new ImageIcon(newing);
        nameProfile.setIcon(guestIcon);

        leftPanel.add(nameProfile);
        leftPanel.add(rankProfile);
        leftPanel.add(tokensProfile);
        mainPanel.add(createQuestButton);
        mainPanel.add(rulesButton);
        mainPanel.add(badgesButton);
        mainPanel.add(questButton);
        mainPage.add(mainPanel, BorderLayout.CENTER);
        mainPage.add(leftPanel, BorderLayout.WEST);
        mainPage.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==questButton) {
            //System.out.println("quest");
            updateGuestInfo();
            QuestPage questPage = new QuestPage();
        }
        else if(e.getSource()==rulesButton){
            //System.out.println("rules");
            RulesPage rulesPage = new RulesPage();
        }
        else if(e.getSource()==createQuestButton){
            if(Guest.getRank().equals("GOLD") || Guest.getRank().equals("PLATINUM")||(Guest.getRank().equals("DIAMOND")))
            {
                CreateQuestPage createQuestPage = new CreateQuestPage();
            }
            else
                JOptionPane.showMessageDialog(this, "You must be at least GOLD rank in order to create quests!");
            //System.out.println("create");
        }
        else if(e.getSource()==badgesButton){
            //System.out.println("badge");
            BadgesPage badgesPage = new BadgesPage();
        }

    }
}
