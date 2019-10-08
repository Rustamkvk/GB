package Lesson_1.marathon;

import Lesson_1.marathon.Competitors.*;
import Lesson_1.marathon.obstacles.*;

public class Main {
    public static void main(String[] args) {

        Competitor[] competitors = {new Human("Боб"), new Cat("Барсик"), new Dog("Бобик")};
        Obstacle[] obstacles = {new Cross(400), new Wall(2), new Water(1)};

        Team team = new Team("Одуванчик", competitors);

        System.out.println("===========Новая команда=============");
        System.out.println(team.getTeamName());

        System.out.println("============Члены команды============");
        team.showResults();

        // новая трасса
        Course course = new Course(obstacles);

        System.out.println("============Команда вышлла на трассу============");
        course.doIt(team);

        System.out.println("============Общий результат============");
        team.showResults();

        System.out.println("============Прошли трассу============");
        team.showMembersFinishedCourse();
    }
}
