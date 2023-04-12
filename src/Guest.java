public class Guest {
    private static int tokens;
    private static int badgesNumber;
    private static int questsNumber;
    private static String rank;

    public Guest(){
        this.tokens=0;
        this.badgesNumber=0;
        this.rank="UNRANKED";
    }

    public static int getTokens(){
        return tokens;
    }

    public static void setTokens(int tokens) {
        Guest.tokens += tokens;
    }

    public static int getBadgesNumber(){
        return badgesNumber;
    }

    public void setBadgesNumber(int badgesNumber){
        Guest.badgesNumber +=badgesNumber;
    }

    public static String getRank(){
        return rank;
    }

    public static void setRank(String rank){
        Guest.rank = rank;
    }

    public static int getQuests(){
        return Guest.questsNumber;
    }

    public static void setQuestsCounting(){
        Guest.questsNumber++;
    }

    public static int getBadgeNumber(){
        return Guest.badgesNumber;
    }

    public static void setBadgesNumber(){
        Guest.badgesNumber++;
    }

}
