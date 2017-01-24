package com.sharemyhead.instructions.impl;

import com.sharemyhead.instructions.Instruction;
import com.sharemyhead.model.Direction;
import com.sharemyhead.model.ToyRobot;

public final class Place implements Instruction {

    private final int xPosition;

    private final int yPosition;

    private final Direction direction;

    public Place(int xPosition, int yPosition, Direction direction) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.direction = direction;
    }

    public boolean canProcess(ToyRobot toyRobot) {
        return isxPositionValid(toyRobot) && isyPositionValid(toyRobot);
    }

    private boolean isyPositionValid(ToyRobot toyRobot) {
        return this.yPosition >= 0 && this.yPosition < toyRobot.getBoard().getColumns();
    }

    private boolean isxPositionValid(ToyRobot toyRobot) {
        return this.xPosition >= 0 && this.xPosition < toyRobot.getBoard().getRows();
    }

    public void process(ToyRobot toyRobot) {
        if(canProcess(toyRobot)) {
            toyRobot.setxPosition(this.xPosition);
            toyRobot.setyPosition(this.yPosition);
            toyRobot.setDirection(this.direction);
            toyRobot.setPlaced(true);
        }
    }
}
