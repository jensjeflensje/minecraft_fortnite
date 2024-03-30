package dev.jensderuiter.minecraftfortnite.listener;

import dev.jensderuiter.minecraftfortnite.RuntimeData;
import dev.jensderuiter.minecraftfortnite.build.BuildSession;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveListener implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        if (event.getPlayer().getInventory().getItemInMainHand().getType() != Material.BLAZE_ROD) return;

        RuntimeData.playerSession.get(event.getPlayer()).preview();
    }

}