package com.example.dragger2.command;

import java.util.List;

import javax.inject.Inject;

final class HelloWorldCommand implements Command {

    private final Outputter outputter;

    @Inject
    HelloWorldCommand(Outputter outputter) {
        this.outputter = outputter;
    }

    @Override
    public Status handleInput(List<String> input) {
        outputter.output("world!");
        return Status.HANDLED;
    }
//
//    @Inject
//    HelloWorldCommand() {
//    }

    @Override
    public String key() {
        return "hello";
    }
//
//    @Override
//    public Status handleInput(List<String> input) {
//        if (!input.isEmpty()) {
//            return Status.INVALID;
//        }
//        System.out.println("world!");
//        return Status.HANDLED;
//    }
}
