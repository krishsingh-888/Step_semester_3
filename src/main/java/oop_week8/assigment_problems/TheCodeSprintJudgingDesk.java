package main.java.oop_week8.assigment_problems;

import java.util.ArrayList;
import java.util.List;

interface TrackScoring {
    double calculateScore(double idea, double execution, double presentation);
}

class InnovationTrack implements TrackScoring {
    @Override
    public double calculateScore(double idea, double execution, double presentation) {
        return (idea * 0.50) + (execution * 0.30) + (presentation * 0.20);
    }
}

class OpenTrack implements TrackScoring {
    @Override
    public double calculateScore(double idea, double execution, double presentation) {
        return (idea + execution + presentation) / 3.0;
    }
}

class Team {
    private String teamName;
    private List<String> members;
    private TrackScoring track;
    private double finalScore = -1.0;
    private boolean submitted = false;

    public Team(String teamName, List<String> members, TrackScoring track) {
        if (members.size() < 2 || members.size() > 4) {
            throw new IllegalArgumentException("Registration failed: A team must have between 2 and 4 members.");
        }
        this.teamName = teamName;
        this.members = members;
        this.track = track;
    }

    public void submitProject(String projectName) {
        this.submitted = true;
    }

    public void evaluate(double idea, double execution, double presentation) {
        this.finalScore = track.calculateScore(idea, execution, presentation);
    }

    public double getFinalScore() { return finalScore; }
    public boolean isSubmitted() { return submitted; }
}

public class TheCodeSprintJudgingDesk {
    // Hackathon Judging Desk container implementation
}