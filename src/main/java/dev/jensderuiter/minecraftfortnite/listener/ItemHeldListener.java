package dev.jensderuiter.minecraftfortnite.listener;

import dev.jensderuiter.minecraftfortnite.RuntimeData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;

public class ItemHeldListener implements Listener {

    @EventHandler
    public void onChangeItemHeld(PlayerItemHeldEvent event) {
        RuntimeData.playerSession.get(event.getPlayer()).removePreview();
    }

}
