package com.sharemyhead.processor.impl;

import com.sharemyhead.instructions.Instruction;
import com.sharemyhead.model.ToyRobot;
import com.sharemyhead.processor.InstructionProcessor;

import java.util.List;

public class InstructionProcessorImpl implements InstructionProcessor {

    public void processInstructions(List<Instruction> instructions, ToyRobot toyRobot) {
        for(Instruction instruction : instructions) {
            instruction.process(toyRobot);
        }
    }
}
