package com.sharemyhead.main;

import com.sharemyhead.instructions.Instruction;
import com.sharemyhead.instructions.impl.*;
import com.sharemyhead.model.Board;
import com.sharemyhead.model.Direction;
import com.sharemyhead.model.InstructionType;
import com.sharemyhead.model.ToyRobot;
import com.sharemyhead.processor.InstructionProcessor;
import com.sharemyhead.processor.impl.InstructionProcessorImpl;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RobotMovementApp {

    private InstructionProcessor instructionProcessor;
    private Board board;
    private ToyRobot toyRobot;

    private static final int ROWS = 5;
    private static final int COLUMNS = 5;

    public RobotMovementApp(int rows, int columns) {
        instructionProcessor = new InstructionProcessorImpl();
        board = new Board(rows, columns);
        toyRobot = new ToyRobot(board);
    }

    private static List<Instruction> extractInstructions() {
        final List<Instruction> instructions = new ArrayList<>();
        String fileName = "test-data.txt";
        try (Stream<String> stream = Files.lines(Paths.get(Thread.currentThread().getContextClassLoader().getResource(fileName).toURI()))) {
            stream.forEach(line -> {
                final String[] splitted = line.split("\\s+");
                String type = splitted[0];
                if(type.equals(InstructionType.PLACE.name())) {
                    String placeDetails = splitted[1];
                    if(StringUtils.isNotEmpty(placeDetails) && placeDetails.split(",").length == 3) {
                        String[] detailsArr = placeDetails.split(",");
                        if(StringUtils.isNumeric(detailsArr[0]) && StringUtils.isNumeric(detailsArr[1])) {
                            instructions.add(
                                    new Place(Integer.parseInt(detailsArr[0]),
                                            Integer.parseInt(detailsArr[1]),
                                            Direction.valueOf(detailsArr[2])));
                        }
                    }
                }
                if(type.equals(InstructionType.LEFT.name())) {
                    instructions.add(new Left());
                }
                if(type.equals(InstructionType.MOVE.name())) {
                    instructions.add(new Move());
                }
                if(type.equals(InstructionType.RIGHT.name())) {
                    instructions.add(new Right());
                }
                if(type.equals(InstructionType.REPORT.name())) {
                    instructions.add(new Report());
                }
            });
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        return instructions;
    }

    public void processInstructions(List<Instruction> instructions) {
        instructionProcessor.processInstructions(instructions, toyRobot);
    }

    public static void main(String[] args) {
        RobotMovementApp robotMovementApp = new RobotMovementApp(ROWS, COLUMNS);
        final List<Instruction> instructions = extractInstructions();
        robotMovementApp.processInstructions(instructions);
    }

}
