package dev.jensderuiter.minecraftfortnite.listener;

import dev.jensderuiter.minecraftfortnite.RuntimeData;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;

public class ItemClickListener implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        if (event.getMaterial() != Material.BLAZE_ROD) return;

        if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
            RuntimeData.playerSession.get(event.getPlayer()).build();
        } else if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            RuntimeData.playerSession.get(event.getPlayer()).scrollForward();
            RuntimeData.playerSession.get(event.getPlayer()).removePreview();
            RuntimeData.playerSession.get(event.getPlayer()).preview();
        }

        event.setCancelled(true);
    }

}
