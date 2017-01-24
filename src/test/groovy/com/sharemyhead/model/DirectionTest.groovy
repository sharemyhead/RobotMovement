package com.sharemyhead.model

import spock.lang.Specification

class DirectionTest extends Specification {

    def "ChangeDirection should change direction from NORTH to EAST on RIGHT instruction"() {
        setup:
            Direction direction = Direction.NORTH

        when:
            Direction newDirection = direction.changeDirection(InstructionType.RIGHT)

        then:
            newDirection == Direction.EAST
    }

    def "ChangeDirection should change direction from EAST to SOUTH on RIGHT instruction"() {
        setup:
        Direction direction = Direction.EAST

        when:
        Direction newDirection = direction.changeDirection(InstructionType.RIGHT)

        then:
        newDirection == Direction.SOUTH
    }

    def "ChangeDirection should change direction from SOUTH to WEST on RIGHT instruction"() {
        setup:
        Direction direction = Direction.SOUTH

        when:
        Direction newDirection = direction.changeDirection(InstructionType.RIGHT)

        then:
        newDirection == Direction.WEST
    }

    def "ChangeDirection should change direction from WEST to NORTH on RIGHT instruction"() {
        setup:
        Direction direction = Direction.WEST

        when:
        Direction newDirection = direction.changeDirection(InstructionType.RIGHT)

        then:
        newDirection == Direction.NORTH
    }

    def "ChangeDirection should change direction from NORTH to WEST on LEFT instruction"() {
        setup:
        Direction direction = Direction.NORTH

        when:
        Direction newDirection = direction.changeDirection(InstructionType.LEFT)

        then:
        newDirection == Direction.WEST
    }

    def "ChangeDirection should change direction from WEST to SOUTH on LEFT instruction"() {
        setup:
        Direction direction = Direction.WEST

        when:
        Direction newDirection = direction.changeDirection(InstructionType.LEFT)

        then:
        newDirection == Direction.SOUTH
    }

    def "ChangeDirection should change direction from SOUTH to EAST on LEFT instruction"() {
        setup:
        Direction direction = Direction.SOUTH

        when:
        Direction newDirection = direction.changeDirection(InstructionType.LEFT)

        then:
        newDirection == Direction.EAST
    }

    def "ChangeDirection should change direction from EAST to NORTH on LEFT instruction"() {
        setup:
        Direction direction = Direction.EAST

        when:
        Direction newDirection = direction.changeDirection(InstructionType.LEFT)

        then:
        newDirection == Direction.NORTH
    }

    def "ChangeDirection should not change direction PLACE instruction"() {
        setup:
        Direction direction = Direction.NORTH

        when:
        Direction newDirection = direction.changeDirection(InstructionType.PLACE)

        then:
        newDirection == Direction.NORTH
    }

    def "ChangeDirection should not change direction on REPORT instruction"() {
        setup:
        Direction direction = Direction.NORTH

        when:
        Direction newDirection = direction.changeDirection(InstructionType.REPORT)

        then:
        newDirection == Direction.NORTH
    }

    def "ChangeDirection should not change direction on MOVE instruction"() {
        setup:
        Direction direction = Direction.NORTH

        when:
        Direction newDirection = direction.changeDirection(InstructionType.MOVE)

        then:
        newDirection == Direction.NORTH
    }

}
