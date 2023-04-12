public class Quests {

    private String name;
    private String description;
    static int questCount;

    Quests(String name, String description){
        this.name = name;
        this.description = description;
        this.questCount=0;
    }

    public String getQuestName(){
        return this.name;
    }

    public void setQuestName(String name){
        this.name=name;
    }

    public String questDes(){
        return this.description;
    }

    public void setQuestDes(String des){
        this.description=des;
    }

}
