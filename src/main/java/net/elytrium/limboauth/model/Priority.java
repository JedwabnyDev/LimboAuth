package net.elytrium.limboauth.model;


import com.velocitypowered.api.proxy.Player;

import java.util.List;

public class Priority {

    private int priorValue;
    private String permission;


    public Priority(int priorValue) {
        this.priorValue = priorValue;
        this.permission = "jd.queue.default";
    }

    public int getPriorValue() {
        return priorValue;
    }

    public String getPermission() {
        return permission;
    }

    public Priority(int priorValue, String permission) {
        this.priorValue = priorValue;
        this.permission = permission;
    }


    //TODO map once; (performance improvement)
    public static Priority reflectFromPermission(Player player, List<String> priorities) {

       return priorities.stream().map(s -> {

            String[] args = s.split(":");
            String permission = args[0];
            int priority = Integer.parseInt(args[1]);

            return new Priority(priority, permission);
        }).filter(priority -> player.hasPermission(priority.getPermission())).findFirst().orElse(new Priority(0));

    }
}
