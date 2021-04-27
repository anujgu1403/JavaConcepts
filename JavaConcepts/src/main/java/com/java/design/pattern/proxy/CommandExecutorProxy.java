package com.java.design.pattern.proxy;

public class CommandExecutorProxy implements CommandExecutor{
    private boolean isAdmin;
    private  CommandExecutor commandExecutor; // Proxy object


    public CommandExecutorProxy(String username, String password) {
    if(username.equals("Anuj") && password.equals("12342")) isAdmin = true;
        this.commandExecutor = new CommandExecutorImpl();
    }

    @Override
    public void runCommand(String command) throws Exception {

        if(isAdmin){
            commandExecutor.runCommand(command);
        }else
        {
            if(command.startsWith("rm")){
                throw new Exception("rm command not allowed to non admin user");
            }else{
                commandExecutor.runCommand(command);
            }
        }
    }
}
