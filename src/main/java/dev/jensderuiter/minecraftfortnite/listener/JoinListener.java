package dev.jensderuiter.minecraftfortnite.listener;

import dev.jensderuiter.minecraftfortnite.build.BuildSession;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        BuildSession.init(event.getPlayer());
    }

}