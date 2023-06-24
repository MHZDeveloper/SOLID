package org.udemy.logging;

public class ConsoleLogger {

    public void writeInfo(String msg) {
        System.out.println("Info : " + msg);
    }

    public void writeError(String msg, Exception exception) {
        System.out.println("Error : " + msg + "; " + exception);
    }
}
