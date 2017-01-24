package com.sharemyhead.instructions.impl;

import com.sharemyhead.instructions.Instruction;
import com.sharemyhead.model.ToyRobot;

public class Report implements Instruction {

    public boolean canProcess(ToyRobot toyRobot) {
        return toyRobot.isPlaced();
    }

    public void process(ToyRobot toyRobot) {
        if(canProcess(toyRobot)) {
            System.out.println(toyRobot);
        }
    }
}
