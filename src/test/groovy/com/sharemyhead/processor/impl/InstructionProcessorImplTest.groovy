package com.sharemyhead.processor.impl

import com.sharemyhead.instructions.Instruction
import com.sharemyhead.instructions.impl.Left
import com.sharemyhead.instructions.impl.Move
import com.sharemyhead.instructions.impl.Place
import com.sharemyhead.instructions.impl.Report
import com.sharemyhead.instructions.impl.Right
import com.sharemyhead.model.Board
import com.sharemyhead.model.Direction
import com.sharemyhead.model.ToyRobot
import com.sharemyhead.processor.InstructionProcessor
import spock.lang.Specification

class InstructionProcessorImplTest extends Specification {

    private InstructionProcessor instructionProcessor

    void setup() {
        instructionProcessor = new InstructionProcessorImpl()
    }

    def "ProcessInstructions with single MOVE"() {
        setup:
            Board board = new Board(5, 5)
            ToyRobot toyRobot = new ToyRobot(board)
            List<Instruction> instructions = new ArrayList<>()
            instructions.add(new Place(0, 0, Direction.NORTH))
            instructions.add(new Move())
            instructions.add(new Report())
        when:
            instructionProcessor.processInstructions(instructions, toyRobot)
        then:
            toyRobot.getxPosition() == 0
            toyRobot.getyPosition() == 1
            toyRobot.getDirection() == Direction.NORTH
    }

    def "ProcessInstructions with single LEFT"() {
        setup:
        Board board = new Board(5, 5)
        ToyRobot toyRobot = new ToyRobot(board)
        List<Instruction> instructions = new ArrayList<>()
        instructions.add(new Place(0, 0, Direction.NORTH))
        instructions.add(new Left())
        instructions.add(new Report())
        when:
        instructionProcessor.processInstructions(instructions, toyRobot)
        then:
        toyRobot.getxPosition() == 0
        toyRobot.getyPosition() == 0
        toyRobot.getDirection() == Direction.WEST
    }

    def "ProcessInstructions with many MOVE, LEFT & REPORT instructions"() {
        setup:
            Board board = new Board(5, 5)
            ToyRobot toyRobot = new ToyRobot(board)
            List<Instruction> instructions = new ArrayList<>()
            instructions.add(new Place(1, 2, Direction.EAST))
            instructions.add(new Move())
            instructions.add(new Move())
            instructions.add(new Left())
            instructions.add(new Move())
            instructions.add(new Report())
        when:
            instructionProcessor.processInstructions(instructions, toyRobot)
        then:
            toyRobot.getxPosition() == 3
            toyRobot.getyPosition() == 3
            toyRobot.getDirection() == Direction.NORTH
    }

    def "ProcessInstructions with multiple MOVE, LEFT, RIGHT & REPORT instructions"() {
        setup:
            Board board = new Board(5, 5)
            ToyRobot toyRobot = new ToyRobot(board)
            List<Instruction> instructions = new ArrayList<>()
            instructions.add(new Place(0, 0, Direction.NORTH))
            instructions.add(new Right())
            instructions.add(new Move())
            instructions.add(new Left())
            instructions.add(new Move())
            instructions.add(new Report())
            instructions.add(new Right())
            instructions.add(new Move())
            instructions.add(new Left())
            instructions.add(new Move())
            instructions.add(new Report())
            instructions.add(new Right())
            instructions.add(new Move())
            instructions.add(new Left())
            instructions.add(new Move())
            instructions.add(new Report())
            instructions.add(new Right())
            instructions.add(new Move())
            instructions.add(new Left())
            instructions.add(new Move())
            instructions.add(new Report())
            // The following instructions should cause the robot to fall off the board
            instructions.add(new Right())
            instructions.add(new Move())
            instructions.add(new Left())
            instructions.add(new Move())
            instructions.add(new Report())
        when:
            instructionProcessor.processInstructions(instructions, toyRobot)
        then:
            toyRobot.getxPosition() == 4
            toyRobot.getyPosition() == 4
            toyRobot.getDirection() == Direction.NORTH
    }

    def "ProcessInstructions with incorrect PLACE, followed by instructions and correct PLACE followed by instructions"() {
        setup:
        Board board = new Board(5, 5)
        ToyRobot toyRobot = new ToyRobot(board)
        List<Instruction> instructions = new ArrayList<>()
        instructions.add(new Place(5, 5, Direction.EAST))
        instructions.add(new Move())
        instructions.add(new Move())
        instructions.add(new Left())
        instructions.add(new Move())
        instructions.add(new Report())
        instructions.add(new Place(0, 0, Direction.EAST))
        instructions.add(new Move())
        instructions.add(new Move())
        instructions.add(new Left())
        instructions.add(new Move())
        instructions.add(new Report())
        when:
        instructionProcessor.processInstructions(instructions, toyRobot)
        then:
        toyRobot.getxPosition() == 2
        toyRobot.getyPosition() == 1
        toyRobot.getDirection() == Direction.NORTH
    }
}
