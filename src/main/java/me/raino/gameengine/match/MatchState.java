package me.raino.gameengine.match;

public enum MatchState {

    IDLE("Idle"),
    STARTING("Starting"),
    RUNNING("Running"),
    FINISHED("Finished");

    private String state;

    MatchState(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }
}
