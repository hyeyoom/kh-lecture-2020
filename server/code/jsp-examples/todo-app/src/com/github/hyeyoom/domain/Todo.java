package com.github.hyeyoom.domain;

public class Todo {
    private final String whatToDo;
    private final String myName;

    public Todo(String whatToDo, String myName) {
        this.whatToDo = whatToDo;
        this.myName = myName;
    }

    public String getWhatToDo() {
        return whatToDo;
    }

    public String getMyName() {
        return myName;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "whatToDo='" + whatToDo + '\'' +
                ", myName='" + myName + '\'' +
                '}';
    }
}
