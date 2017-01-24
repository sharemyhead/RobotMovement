package com.sharemyhead.instructions;

import com.sharemyhead.model.ToyRobot;

public interface Instruction {

    boolean canProcess(ToyRobot toyRobot);

    void process(ToyRobot toyRobot);
}
