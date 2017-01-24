package com.sharemyhead.instructions.impl;

import com.sharemyhead.instructions.Instruction;
import com.sharemyhead.model.ToyRobot;

public class Move implements Instruction {

    public boolean canProcess(ToyRobot toyRobot) {
        if(toyRobot.isPlaced()) {
            switch (toyRobot.getDirection()) {
                case NORTH: return toyRobot.getyPosition() + 1 < toyRobot.getBoard().getRows();
                case SOUTH: return toyRobot.getyPosition() - 1 >= 0;
                case EAST: return toyRobot.getxPosition() + 1 < toyRobot.getBoard().getColumns();
                case WEST: return toyRobot.getxPosition() - 1 >= 0;
            }
        }
        return false;
    }

    public void process(ToyRobot toyRobot) {
        if(canProcess(toyRobot)) {
            switch (toyRobot.getDirection()) {
                case NORTH: {
                    toyRobot.setyPosition(toyRobot.getyPosition() + 1);
                    break;
                }
                case SOUTH: {
                    toyRobot.setyPosition(toyRobot.getyPosition() - 1);
                    break;
                }
                case EAST: {
                    toyRobot.setxPosition(toyRobot.getxPosition() + 1);
                    break;
                }
                case WEST: {
                    toyRobot.setxPosition(toyRobot.getxPosition() - 1);
                    break;
                }
            }
        }
    }
}
