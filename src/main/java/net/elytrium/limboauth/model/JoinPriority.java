package net.elytrium.limboauth.model;

import com.velocitypowered.api.proxy.Player;
import net.elytrium.limboapi.api.player.LimboPlayer;

import java.util.Objects;

public class JoinPriority  {

    private String playerUuid;
    private Priority priority;

    public JoinPriority(String playerUuid, Priority priority) {
        this.playerUuid = playerUuid;
        this.priority = priority;
    }

    public JoinPriority(String playerUuid) {
        this.playerUuid = playerUuid;
        this.priority = new Priority(0);
    }

    public String getPlayerUuid() {
        return playerUuid;
    }

    public void setPlayerUuid(String playerUuid) {
        this.playerUuid = playerUuid;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(obj instanceof JoinPriority){
            return ((JoinPriority) obj).getPlayerUuid().equals(playerUuid);
        }


        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerUuid);
    }

    public static JoinPriority dummy(Player player){
        return new JoinPriority(player.getUniqueId().toString());
    }

    public static JoinPriority dummy(LimboPlayer limboPlayer){
        return new JoinPriority(limboPlayer.getProxyPlayer().getUniqueId().toString());
    }
}
