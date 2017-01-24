package com.sharemyhead.instructions.impl

import com.sharemyhead.instructions.impl.Report
import com.sharemyhead.model.Board
import com.sharemyhead.model.Direction
import com.sharemyhead.model.ToyRobot
import spock.lang.Specification

class ReportTest extends Specification {

    def "CanProcess returns true when robot is placed"() {
        setup:
            Board board = new Board(5, 5)
            ToyRobot toyRobot = new ToyRobot(board)
            Place place = new Place(0, 0, Direction.NORTH)
            Report report = new Report()
        when:
            place.process(toyRobot)
            def canProcess = report.canProcess(toyRobot)
        then:
            canProcess
    }

    def "CanProcess returns false when robot is not placed"() {
        setup:
            Board board = new Board(5, 5)
            ToyRobot toyRobot = new ToyRobot(board)
            Report report = new Report()
        when:
            def canProcess = report.canProcess(toyRobot)
        then:
            !canProcess
    }
}
