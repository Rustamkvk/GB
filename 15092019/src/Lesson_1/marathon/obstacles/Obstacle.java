package Lesson_1.marathon.obstacles;

import Lesson_1.marathon.Competitors.Competitor;

public abstract class Obstacle implements Competitor {
    public abstract void doIt(Competitor competitor);
}