package com.java.concepts.pattern.proxy;

public class CommandExecutorTest {
    public static void main(String[] args) {
        CommandExecutor commandExecutor = new CommandExecutorProxy("Anuj","2323");
        try{
            commandExecutor.runCommand("ls -l");
            commandExecutor.runCommand("rm -R *");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
