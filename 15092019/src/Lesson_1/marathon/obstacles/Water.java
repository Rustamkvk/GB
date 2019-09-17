package Lesson_1.marathon.obstacles;

import Lesson_1.marathon.Competitors.Competitor;
import Lesson_1.marathon.obstacles.Obstacle;

public class Water extends Obstacle {
    int length;

    public Water(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.swim(length);
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