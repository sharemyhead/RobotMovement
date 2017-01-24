package com.sharemyhead.model;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public Direction changeDirection(InstructionType instructionType) {
        int rotatorFlag = 0;
        if(instructionType == InstructionType.LEFT) {
            rotatorFlag = -1;
        } else if (instructionType == InstructionType.RIGHT) {
            rotatorFlag = 1;
        }
        int newPostion = this.ordinal() + rotatorFlag;
        if(newPostion < 0) {
            newPostion = 3;
        }
        int newIndex = newPostion % Direction.values().length;
        return Direction.values()[newIndex];
    }
}
