package Lesson_1.marathon.Competitors;

public class Team {
    String teamName;
    Competitor[] teamMembers = new Competitor[4];


    public Team(String teamName, Competitor[] teamMembers){
        this.teamName = teamName;
        this.teamMembers = teamMembers;
    }

    public String getTeamName(){
        return "Название команды: "+teamName;
    }

    public Competitor[] getMembers(){
        return teamMembers;
    }

    public void showResults(){
        for(Competitor c: teamMembers){
            c.info();
        }
    }

    public void showMembersFinishedCourse(){
        for(Competitor c: teamMembers){
            if(c.isOnDistance())
                c.info();
        }
    }
}