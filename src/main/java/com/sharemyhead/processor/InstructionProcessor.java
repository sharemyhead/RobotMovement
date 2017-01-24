package com.sharemyhead.processor;

import com.sharemyhead.instructions.Instruction;
import com.sharemyhead.model.ToyRobot;

import java.util.List;

public interface InstructionProcessor {

    void processInstructions(List<Instruction> instructions, ToyRobot toyRobot);
}
