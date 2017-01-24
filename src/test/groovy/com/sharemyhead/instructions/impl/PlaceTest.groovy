package com.sharemyhead.instructions.impl

import com.sharemyhead.instructions.impl.Place
import com.sharemyhead.model.Board
import com.sharemyhead.model.Direction
import com.sharemyhead.model.ToyRobot
import spock.lang.Specification

class PlaceTest extends Specification {

    def "CanProcess returns false for negative xPosition"() {
        setup:
            Board board = new Board(5, 5)
            ToyRobot toyRobot = new ToyRobot(board)
            Place place = new Place(-1, 2, Direction.NORTH)
        when:
            def canProcess = place.canProcess(toyRobot)
        then:
            !canProcess
    }

    def "CanProcess returns false for xPosition >= columns"() {
        setup:
            Board board = new Board(5, 5)
            ToyRobot toyRobot = new ToyRobot(board)
            Place place = new Place(5, 2, Direction.NORTH)
        when:
            def canProcess = place.canProcess(toyRobot)
        then:
            !canProcess
    }

    def "CanProcess returns true for allowed xPosition"() {
        setup:
            Board board = new Board(5, 5)
            ToyRobot toyRobot = new ToyRobot(board)
            Place place = new Place(1, 2, Direction.NORTH)
        when:
            def canProcess = place.canProcess(toyRobot)
        then:
            canProcess
    }

    def "CanProcess returns false for negative yPosition"() {
        setup:
            Board board = new Board(5, 5)
            ToyRobot toyRobot = new ToyRobot(board)
            Place place = new Place(1, -2, Direction.NORTH)
        when:
            def canProcess = place.canProcess(toyRobot)
        then:
            !canProcess
    }

    def "CanProcess returns false for yPosition > rows"() {
        setup:
            Board board = new Board(5, 5)
            ToyRobot toyRobot = new ToyRobot(board)
            Place place = new Place(1, 5, Direction.NORTH)
        when:
            def canProcess = place.canProcess(toyRobot)
        then:
            !canProcess
    }

    def "CanProcess returns true for allowed yPosition"() {
        setup:
            Board board = new Board(5, 5)
            ToyRobot toyRobot = new ToyRobot(board)
            Place place = new Place(1, 2, Direction.NORTH)
        when:
            def canProcess = place.canProcess(toyRobot)
        then:
            canProcess
    }

    def "Process changes the position of the robot"() {
        setup:
            Board board = new Board(5, 5)
            ToyRobot toyRobot = new ToyRobot(board)
            Place place = new Place(1, 2, Direction.EAST)
        when:
            place.process(toyRobot)
        then:
            toyRobot.getxPosition() == 1
            toyRobot.getyPosition() == 2
            toyRobot.getDirection() == Direction.EAST
    }

    def "Process does not change the position of the robot"() {
        setup:
            Board board = new Board(5, 5)
            ToyRobot toyRobot = new ToyRobot(board)
            Place place = new Place(1, 5, Direction.EAST)
        when:
            place.process(toyRobot)
        then:
            toyRobot.getxPosition() == 0
            toyRobot.getyPosition() == 0
            toyRobot.getDirection() == null
    }
}
