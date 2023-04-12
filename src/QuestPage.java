import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class QuestPage extends JFrame implements ActionListener {

    JFrame questPage = new JFrame("LitoDSA");
    JPanel normalQuests = new JPanel();
    static JPanel createdQuest = new JPanel();
    JLabel title1 = new JLabel("NORMAL QUESTS");
    JLabel title2 = new JLabel("CREATED QUEST");
    JButton finish1 = new JButton("FINISH");
    JButton finish2 = new JButton("FINISH");
    JButton finish3 = new JButton("FINISH");
    JButton finish4 = new JButton("FINISH");
    Quests quest1 = new Quests("SINGLE LINKED LISTS", "REVERSE A SINGLE LINKED LIST");
    Quests quest2 = new Quests("SINGLE LINKED LISTS", "DELETE THE FIRST NODE");
    Quests quest3 = new Quests("SINGLE LINKED LISTS", "INSERT A KEY");
    Quests quest4 = new Quests("SINGLE LINKED LISTS", "DELETE THE LAST NODE");
    JLabel questName1 = new JLabel(quest1.getQuestName());
    JLabel questName2 = new JLabel(quest2.getQuestName());
    JLabel questName3 = new JLabel(quest3.getQuestName());
    JLabel questName4 = new JLabel(quest4.getQuestName());
    JLabel questDec1 = new JLabel(quest1.questDes());
    JLabel questDec2 = new JLabel(quest2.questDes());
    JLabel questDec3 = new JLabel(quest3.questDes());
    JLabel questDec4 = new JLabel(quest4.questDes());

    QuestPage(){

        Font customFont = null;
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("ARCADECLASSIC.TTF"));
            customFont = customFont.deriveFont(Font.PLAIN, 20);

            title1.setFont(customFont.deriveFont(Font.PLAIN, 26));
            title2.setFont(customFont.deriveFont(Font.PLAIN, 26));
            questName1.setFont(customFont.deriveFont(Font.PLAIN, 22));
            questDec1.setFont(customFont.deriveFont(Font.PLAIN, 16));
            questName2.setFont(customFont.deriveFont(Font.PLAIN, 22));
            questDec2.setFont(customFont.deriveFont(Font.PLAIN, 16));
            questName3.setFont(customFont.deriveFont(Font.PLAIN, 22));
            questDec3.setFont(customFont.deriveFont(Font.PLAIN, 16));
            questName4.setFont(customFont.deriveFont(Font.PLAIN, 22));
            questDec4.setFont(customFont.deriveFont(Font.PLAIN, 16));
            finish1.setFont(customFont.deriveFont(Font.PLAIN, 14));
            finish2.setFont(customFont.deriveFont(Font.PLAIN, 14));
            finish3.setFont(customFont.deriveFont(Font.PLAIN, 14));
            finish4.setFont(customFont.deriveFont(Font.PLAIN, 14));


        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }


        questPage.setSize(600, 600);
        questPage.getContentPane().setBackground(Color.decode("#A384D0"));
        questPage.setResizable(false);
        questPage.setIconImage(new ImageIcon("icon.png").getImage());
        questPage.setLayout(null);

        normalQuests.setLayout(null);
        normalQuests.setBounds(40, 40, 250, 500);
        normalQuests.setBackground(Color.decode("#84D0A3"));

        createdQuest.setLayout(null);
        createdQuest.setBounds(300, 40, 250, 200);
        createdQuest.setBackground(Color.decode("#84D0A3"));

        title1.setBounds(40,40,250,100);
        title2.setBounds(30,40,250,100);

        questName1.setBounds(15,80,250,100);
        questDec1.setBounds(15,100,250,100);
        finish1.setBounds(75,160,100,25);
        finish1.setFocusable(false);
        finish1.addActionListener(this);

        questName2.setBounds(15,170,250,100);
        questDec2.setBounds(15,190,250,100);
        finish2.setBounds(75,250,100,25);
        finish2.setFocusable(false);
        finish2.addActionListener(this);

        questName3.setBounds(15,260,250,100);
        questDec3.setBounds(15,280,250,100);
        finish3.setBounds(75,340,100,25);
        finish3.setFocusable(false);
        finish3.addActionListener(this);

        questName4.setBounds(15,350,250,100);
        questDec4.setBounds(15,370,250,100);
        finish4.setBounds(75,430,100,25);
        finish4.setFocusable(false);
        finish4.addActionListener(this);

        createdQuest.add(title2);
        normalQuests.add(title1);
        normalQuests.add(questName1);
        normalQuests.add(questDec1);
        normalQuests.add(finish1);
        normalQuests.add(questName2);
        normalQuests.add(questDec2);
        normalQuests.add(finish2);
        normalQuests.add(questName3);
        normalQuests.add(questDec3);
        normalQuests.add(finish3);
        normalQuests.add(questName4);
        normalQuests.add(questDec4);
        normalQuests.add(finish4);
        questPage.add(normalQuests);
        questPage.add(createdQuest);
        questPage.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==finish1){
            finish1.setVisible(false);
            questName1.setVisible(false);
            questDec1.setVisible(false);
            JOptionPane.showMessageDialog(this, "Quest completed!");
            Guest.setTokens(20);
            Guest.setQuestsCounting();
            System.out.println(Guest.getQuests());


        }
        if(e.getSource()==finish2){
            finish2.setVisible(false);
            questName2.setVisible(false);
            questDec2.setVisible(false);
            JOptionPane.showMessageDialog(this, "Quest completed!");
            Guest.setTokens(20);
            Guest.setQuestsCounting();
            System.out.println(Guest.getQuests());

        }
        if(e.getSource()==finish3){
            finish3.setVisible(false);
            questName3.setVisible(false);
            questDec3.setVisible(false);
            JOptionPane.showMessageDialog(this, "Quest completed!");
            Guest.setTokens(20);
            Guest.setQuestsCounting();
            System.out.println(Guest.getQuests());

        }
        if(e.getSource()==finish4){
            finish4.setVisible(false);
            questName4.setVisible(false);
            questDec4.setVisible(false);
            JOptionPane.showMessageDialog(this, "Quest completed!");
            Guest.setTokens(20);
            Guest.setQuestsCounting();
            System.out.println(Guest.getQuests());

        }
    }

}
