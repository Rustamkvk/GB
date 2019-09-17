package Lesson_1.marathon.obstacles;

import Lesson_1.marathon.Competitors.Competitor;
import Lesson_1.marathon.obstacles.Obstacle;

public class Wall extends Obstacle {
    int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.jump(height);
    }

    @Override
    public void run(int dist) {

    }

    @Override
    public void swim(int dist) {

    }

    @Override
    public void jump(int height) {

    }

    @Override
    public boolean isOnDistance() {
        return false;
    }

    @Override
    public void info() {

    }
}