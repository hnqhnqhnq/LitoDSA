import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class CreateQuestPage extends JFrame implements ActionListener {

    JFrame createQuestPage = new JFrame("LitoDSA");
    JPanel createQuestPanel = new JPanel();
    JTextField nameQuest = new JTextField();
    JTextField descQuest = new JTextField();
    JLabel enterName = new JLabel("ENTER THE NAME");
    JLabel enterDesc = new JLabel("ENTER THE DESCRIPTION");
    JLabel title = new JLabel("CREATE QUESTS");
    JButton createQuestButton = new JButton("CREATE QUEST");
    private static int newQuestCount=0;

    CreateQuestPage(){

        Font customFont = null;
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("ARCADECLASSIC.TTF"));
            customFont = customFont.deriveFont(Font.PLAIN, 20);

            title.setFont(customFont.deriveFont(Font.PLAIN, 24));
            nameQuest.setFont(customFont.deriveFont(Font.PLAIN, 18));
            descQuest.setFont(customFont.deriveFont(Font.PLAIN, 18));
            enterName.setFont(customFont.deriveFont(Font.PLAIN, 18));
            enterDesc.setFont(customFont.deriveFont(Font.PLAIN, 18));
            createQuestButton.setFont(customFont.deriveFont(Font.PLAIN, 18));

        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        createQuestPage.setSize(600, 600);
        createQuestPage.getContentPane().setBackground(Color.decode("#A384D0"));
        createQuestPage.setResizable(false);
        createQuestPage.setIconImage(new ImageIcon("icon.png").getImage());
        createQuestPage.setLayout(null);

        createQuestPanel.setLayout(null);
        createQuestPanel.setBounds(40, 40, 500, 500);
        createQuestPanel.setBackground(Color.decode("#84D0A3"));

        title.setBounds(200,40,250,100);

        enterName.setBounds(60,130,200,20);

        nameQuest.setBounds(160,90,200,20);

        enterDesc.setBounds(60,170,250,20);

        descQuest.setBounds(270,170,200,20);

        createQuestButton.setBounds(125,200,200,50);
        createQuestButton.setFocusable(false);
        createQuestButton.addActionListener(this);

        createQuestPage.add(title);
        createQuestPanel.add(nameQuest);
        createQuestPage.add(descQuest);
        createQuestPage.add(enterName);
        createQuestPage.add(enterDesc);
        createQuestPanel.add(createQuestButton);
        createQuestPage.add(createQuestPanel);
        createQuestPage.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent d) {
        if (d.getSource() == createQuestButton) {
            String name = new String(nameQuest.getText());
            String description = new String(descQuest.getText());

            if (name.isEmpty() || description.isEmpty()) {
                JOptionPane.showMessageDialog(createQuestPage, "Please fill in both the name and description fields");
                return;
            }

            if(newQuestCount == 1){
                JOptionPane.showMessageDialog(createQuestPage, "You cannnot create more than 1 quest! Do not abuse this system!");
                return;
            }
            else{
                newQuestCount++;
            }

            JOptionPane.showMessageDialog(createQuestPage, "You have just created a quest!");
            Quests createdQuest = new Quests(name,description);
            JLabel newQuestName = new JLabel(name);
            JLabel newQuestDesc = new JLabel(description);
            JButton finishNew = new JButton("finish");

            Font customFont = null;
            try {
                customFont = Font.createFont(Font.TRUETYPE_FONT, new File("ARCADECLASSIC.TTF"));
                customFont = customFont.deriveFont(Font.PLAIN, 20);

                newQuestName.setFont(customFont.deriveFont(Font.PLAIN,22));
                newQuestDesc.setFont(customFont.deriveFont(Font.PLAIN,16));
                finishNew.setFont(customFont.deriveFont(Font.PLAIN,14));

            } catch (IOException | FontFormatException e) {
                e.printStackTrace();
            }

            newQuestName.setBounds(15,80,250,100);
            newQuestDesc.setBounds(15,100,250,100);
            finishNew.setBounds(75,160,100,25);
            finishNew.setFocusable(false);

            QuestPage.createdQuest.add(newQuestName);
            QuestPage.createdQuest.add(newQuestDesc);
            QuestPage.createdQuest.add(finishNew);

            finishNew.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource()==finishNew){
                        newQuestCount--;
                        finishNew.setVisible(false);
                        newQuestName.setVisible(false);
                        newQuestDesc.setVisible(false);
                        JOptionPane.showMessageDialog(createQuestPage, "Quest completed!");
                        Guest.setTokens(20);
                        Guest.setQuestsCounting();
                        System.out.println(Guest.getQuests());
                    }
                }
            });

        }
    }
}
