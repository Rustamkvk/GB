package Lesson_1.marathon.obstacles;


import Lesson_1.marathon.Competitors.Competitor;
import Lesson_1.marathon.Competitors.Team;

public class Course {

    Obstacle[] obstacles;

    public Course(Obstacle[] obstacles){
        this.obstacles = obstacles;
    }

    public void doIt(Team team){
        Competitor[] teamMembers = team.getMembers();
        if(teamMembers.length > 0){
            for (Competitor c: teamMembers){
                for (Obstacle o: obstacles){
                    o.doIt(c);
                    if (!c.isOnDistance()) break;
                }
            }
        } else {
            System.out.println("There are no members in the team!");
        }
    }
}