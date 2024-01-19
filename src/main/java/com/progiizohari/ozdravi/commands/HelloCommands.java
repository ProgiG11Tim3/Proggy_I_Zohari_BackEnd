package com.progiizohari.ozdravi.commands;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class HelloCommands {
    @ShellMethod(key = "hello", value = "Say hello")
    public String hello() {
        return "Hello World!";
    }

    public String hello(String name) {
        return "Hello " + name + "!";
    }
}
