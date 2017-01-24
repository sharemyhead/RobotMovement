package com.sharemyhead.instructions.impl

import com.sharemyhead.instructions.impl.Move
import com.sharemyhead.model.Board
import com.sharemyhead.model.Direction
import com.sharemyhead.model.ToyRobot
import spock.lang.Specification

class MoveTest extends Specification {

    def "CanProcess returns false for a allowed move when facing NORTH but robot not placed"() {
        setup:
            Board board = new Board(5, 5)
            ToyRobot toyRobot = new ToyRobot(board)
            Move move = new Move()
        when:
            def canProcess = move.canProcess(toyRobot)
        then:
            !canProcess
    }

    def "CanProcess returns true for a allowed move when facing NORTH"() {
        setup:
            Board board = new Board(5, 5)
            ToyRobot toyRobot = new ToyRobot(board)
            Place place = new Place(0, 0, Direction.NORTH)
            Move move = new Move()
        when:
            place.process(toyRobot)
            def canProcess = move.canProcess(toyRobot)
        then:
            canProcess
    }

    def "CanProcess returns false for a disallowed move when facing NORTH"() {
        setup:
            Board board = new Board(5, 5)
            ToyRobot toyRobot = new ToyRobot(board)
            Place place = new Place(0, 4, Direction.NORTH)
            Move move = new Move()
        when:
            place.process(toyRobot)
            def canProcess = move.canProcess(toyRobot)
        then:
            !canProcess
    }

    def "CanProcess returns true for a allowed move when facing EAST"() {
        setup:
            Board board = new Board(5, 5)
            ToyRobot toyRobot = new ToyRobot(board)
            Place place = new Place(0, 0, Direction.EAST)
            Move move = new Move()
        when:
            place.process(toyRobot)
            def canProcess = move.canProcess(toyRobot)
        then:
            canProcess
    }

    def "CanProcess returns false for a disallowed move when facing EAST"() {
        setup:
            Board board = new Board(5, 5)
            ToyRobot toyRobot = new ToyRobot(board)
            Place place = new Place(4, 0, Direction.EAST)
            Move move = new Move()
        when:
            place.process(toyRobot)
            def canProcess = move.canProcess(toyRobot)
        then:
            !canProcess
    }

    def "CanProcess returns true for a allowed move when facing SOUTH"() {
        setup:
            Board board = new Board(5, 5)
            ToyRobot toyRobot = new ToyRobot(board)
            Place place = new Place(0, 1, Direction.SOUTH)
            Move move = new Move()
        when:
            place.process(toyRobot)
            def canProcess = move.canProcess(toyRobot)
        then:
            canProcess

    }

    def "CanProcess returns false for a disallowed move when facing SOUTH"() {
        setup:
            Board board = new Board(5, 5)
            ToyRobot toyRobot = new ToyRobot(board)
            Place place = new Place(0, 0, Direction.SOUTH)
            Move move = new Move()
        when:
            place.process(toyRobot)
            def canProcess = move.canProcess(toyRobot)
        then:
            !canProcess
    }

    def "CanProcess returns true for a allowed move when facing WEST"() {
        setup:
            Board board = new Board(5, 5)
            ToyRobot toyRobot = new ToyRobot(board)
            Place place = new Place(1, 0, Direction.WEST)
            Move move = new Move()
        when:
            place.process(toyRobot)
            def canProcess = move.canProcess(toyRobot)
        then:
            canProcess
    }

    def "CanProcess returns false for a disallowed move when facing WEST"() {
        setup:
            Board board = new Board(5, 5)
            ToyRobot toyRobot = new ToyRobot(board)
            Place place = new Place(0, 0, Direction.WEST)
            Move move = new Move()
        when:
            place.process(toyRobot)
            def canProcess = move.canProcess(toyRobot)
        then:
            !canProcess
    }

    def "Process moves the robot 1 position to the NORTH"() {
        setup:
            Board board = new Board(5, 5)
            ToyRobot toyRobot = new ToyRobot(board)
            Place place = new Place(0, 0, Direction.NORTH);
            Move move = new Move()
        when:
            place.process(toyRobot)
            move.process(toyRobot)
        then:
            toyRobot.getyPosition() == 1
            toyRobot.getxPosition() == 0
    }

    def "Process does not move the robot 1 position to the NORTH"() {
        setup:
            Board board = new Board(5, 5)
            ToyRobot toyRobot = new ToyRobot(board)
            Place place = new Place(0, 4, Direction.NORTH);
            Move move = new Move()
        when:
            place.process(toyRobot)
            move.process(toyRobot)
        then:
            toyRobot.getyPosition() == 4
            toyRobot.getxPosition() == 0
    }

    def "Process moves the robot 1 position to the EAST"() {
        setup:
            Board board = new Board(5, 5)
            ToyRobot toyRobot = new ToyRobot(board)
            Place place = new Place(0, 4, Direction.EAST)
            Move move = new Move()
        when:
            place.process(toyRobot)
            move.process(toyRobot)
        then:
            toyRobot.getyPosition() == 4
            toyRobot.getxPosition() == 1

    }

    def "Process does not move the robot 1 position to the EAST"() {
        setup:
            Board board = new Board(5, 5)
            ToyRobot toyRobot = new ToyRobot(board)
            Place place = new Place(4, 0, Direction.EAST)
            Move move = new Move()
        when:
            place.process(toyRobot)
            move.process(toyRobot)
        then:
            toyRobot.getyPosition() == 0
            toyRobot.getxPosition() == 4
    }

    def "Process moves the robot 1 position to the SOUTH"() {
        setup:
            Board board = new Board(5, 5)
            ToyRobot toyRobot = new ToyRobot(board)
            Place place = new Place(4, 4, Direction.SOUTH)
            Move move = new Move()
        when:
            place.process(toyRobot)
            move.process(toyRobot)
        then:
            toyRobot.getyPosition() == 3
            toyRobot.getxPosition() == 4
    }

    def "Process does not move the robot 1 position to the SOUTH"() {
        setup:
            Board board = new Board(5, 5)
            ToyRobot toyRobot = new ToyRobot(board)
            Place place = new Place(0, 0, Direction.SOUTH)
            Move move = new Move()
        when:
            place.process(toyRobot)
            move.process(toyRobot)
        then:
            toyRobot.getyPosition() == 0
            toyRobot.getxPosition() == 0
    }

    def "Process moves the robot 1 position to the WEST"() {
        setup:
            Board board = new Board(5, 5)
            ToyRobot toyRobot = new ToyRobot(board)
            Place place = new Place(1, 4, Direction.WEST)
            Move move = new Move()
        when:
            place.process(toyRobot)
            move.process(toyRobot)
        then:
            toyRobot.getyPosition() == 4
            toyRobot.getxPosition() == 0
    }

    def "Process does not move the robot 1 position to the WEST"() {
        setup:
            Board board = new Board(5, 5)
            ToyRobot toyRobot = new ToyRobot(board)
            Place place = new Place(0, 4, Direction.WEST)
            Move move = new Move()
        when:
            place.process(toyRobot)
            move.process(toyRobot)
        then:
            toyRobot.getyPosition() == 4
            toyRobot.getxPosition() == 0
    }

}
