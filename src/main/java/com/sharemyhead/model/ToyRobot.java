package com.sharemyhead.model;

public class ToyRobot {

    private int xPosition;

    private int yPosition;

    private Direction direction;

    private boolean placed;

    private Board board;

    public ToyRobot(Board board) {
        this.board = board;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isPlaced() {
        return placed;
    }

    public void setPlaced(boolean placed) {
        this.placed = placed;
    }

    public Board getBoard() {
        return board;
    }

    @Override
    public String toString() {
        return "ToyRobot: {xPosition: " + xPosition +
                ", yPosition: " + yPosition +
                ", direction: " + direction + "}";
    }
}
