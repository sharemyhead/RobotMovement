package com.sharemyhead.instructions.impl

import com.sharemyhead.instructions.impl.Left
import com.sharemyhead.model.Board
import com.sharemyhead.model.Direction
import com.sharemyhead.model.ToyRobot
import spock.lang.Specification

class LeftTest extends Specification {

    def "CanProcess"() {
        setup:
            Board board = new Board(5, 5);
            ToyRobot toyRobot = new ToyRobot(board)
            Place place = new Place(0, 0, Direction.NORTH)
            Left left = new Left()
        when:
            place.process(toyRobot)
            def canProcess = left.canProcess(toyRobot)
        then :
            canProcess
    }

    def "CanProcess returns false when robot not placed"() {
        setup:
            Left left = new Left()
            Board board = new Board(5, 5);
            ToyRobot toyRobot = new ToyRobot(board)
        when:
            def canProcess = left.canProcess(toyRobot)
        then :
            !canProcess
    }

    def "Process changes direction from NORTH to WEST"() {
        setup:
            Board board = new Board(5, 5)
            ToyRobot robot = new ToyRobot(board)
            Place place = new Place(0, 0, Direction.NORTH)
            Left left = new Left()
        when:
            place.process(robot)
            left.process(robot)
        then:
            robot.getDirection() == Direction.WEST
    }

    def "Process changes direction from WEST to SOUTH"() {
        setup:
            Board board = new Board(5, 5)
            ToyRobot robot = new ToyRobot(board)
            Place place = new Place(0, 0, Direction.WEST)
            Left left = new Left()
        when:
            place.process(robot)
            left.process(robot)
        then:
            robot.getDirection() == Direction.SOUTH
    }

    def "Process changes direction from SOUTH to EAST"() {
        setup:
            Board board = new Board(5, 5)
            ToyRobot robot = new ToyRobot(board)
            Place place = new Place(0, 0, Direction.SOUTH)
            Left left = new Left()
        when:
            place.process(robot)
            left.process(robot)
        then:
            robot.getDirection() == Direction.EAST
    }

    def "Process changes direction from EAST to NORTH"() {
        setup:
            Board board = new Board(5, 5)
            ToyRobot robot = new ToyRobot(board)
            Place place = new Place(0, 0, Direction.EAST)
            Left left = new Left()
        when:
            place.process(robot)
            left.process(robot)
        then:
            robot.getDirection() == Direction.NORTH
    }

    def "Process does not change direction from EAST to NORTH when robot not placed"() {
        setup:
            Board board = new Board(5, 5)
            ToyRobot robot = new ToyRobot(board)
            Left left = new Left()
        when:
            left.process(robot)
        then:
            robot.getDirection() == null
    }
}
