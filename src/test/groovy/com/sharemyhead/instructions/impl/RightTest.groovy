package com.sharemyhead.instructions.impl

import com.sharemyhead.instructions.impl.Right
import com.sharemyhead.model.Board
import com.sharemyhead.model.Direction
import com.sharemyhead.model.ToyRobot
import spock.lang.Specification

class RightTest extends Specification {

    def "CanProcess"() {
        setup:
            Board board = new Board(5, 5)
            ToyRobot robot = new ToyRobot(board)
            Place place = new Place(0, 0, Direction.NORTH)
            Right right = new Right()
        when:
            place.process(robot)
            def canProcess = right.canProcess(robot)
        then:
            canProcess
    }

    def "CanProcess returns false when robot not placed"() {
        setup:
            Right right = new Right()
            Board board = new Board(5, 5)
            ToyRobot robot = new ToyRobot(board)
        when:
            def canProcess = right.canProcess(robot)
        then:
            !canProcess
    }

    def "Process changes direction from NORTH to EAST"() {
        setup:
        Board board = new Board(5, 5)
        ToyRobot robot = new ToyRobot(board)
        Place place = new Place(0, 0, Direction.NORTH)
        Right right = new Right()
        when:
        place.process(robot)
        right.process(robot)
        then:
        robot.getDirection() == Direction.EAST
    }

    def "Process changes direction from EAST to SOUTH"() {
        setup:
        Board board = new Board(5, 5)
        ToyRobot robot = new ToyRobot(board)
        Place place = new Place(0, 0, Direction.EAST)
        Right right = new Right()
        when:
        place.process(robot)
        right.process(robot)
        then:
        robot.getDirection() == Direction.SOUTH
    }

    def "Process changes direction from SOUTH to WEST"() {
        setup:
        Board board = new Board(5, 5)
        ToyRobot robot = new ToyRobot(board)
        Place place = new Place(0, 0, Direction.SOUTH)
        Right right = new Right()
        when:
        place.process(robot)
        right.process(robot)
        then:
        robot.getDirection() == Direction.WEST
    }

    def "Process changes direction from WEST to NORTH"() {
        setup:
        Board board = new Board(5, 5)
        ToyRobot robot = new ToyRobot(board)
        Place place = new Place(0, 0, Direction.WEST)
        Right right = new Right()
        when:
        place.process(robot)
        right.process(robot)
        then:
        robot.getDirection() == Direction.NORTH
    }

    def "Process does not change direction from WEST to NORTH as robot not placed"() {
        setup:
        Board board = new Board(5, 5)
        ToyRobot robot = new ToyRobot(board)
        Right right = new Right()
        when:
        right.process(robot)
        then:
        robot.getDirection() == null
    }
}
