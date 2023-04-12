public class Badges {

    private String name;
    private String description;
    private boolean earned;

    public Badges(String name, String description, boolean earned){
        this.name = name;
        this.description = description;
        this.earned = earned;
    }

    public String getBadgeName(){
        return this.name;
    }

    public void setBadgeName(String name){
        this.name = name;
    }

    public String getBadgeDec(){
        return this.description;
    }

    public boolean isEarned(){
        return this.earned;
    }

    public void setEarned(boolean earned){
        this.earned = earned;
    }
}