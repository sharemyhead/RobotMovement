package com.sharemyhead.instructions.impl;

import com.sharemyhead.instructions.Instruction;
import com.sharemyhead.model.InstructionType;
import com.sharemyhead.model.ToyRobot;

public class Right implements Instruction {

    public boolean canProcess(ToyRobot toyRobot) {
        return toyRobot.isPlaced();
    }

    public void process(ToyRobot toyRobot) {
        if(canProcess(toyRobot)) {
            toyRobot.setDirection(toyRobot.getDirection().changeDirection(InstructionType.RIGHT));
        }
    }
}
