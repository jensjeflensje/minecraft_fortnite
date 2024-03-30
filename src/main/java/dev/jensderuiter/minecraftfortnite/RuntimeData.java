package dev.jensderuiter.minecraftfortnite;

import dev.jensderuiter.minecraftfortnite.build.BuildSession;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class RuntimeData {

    public static HashMap<Player, BuildSession> playerSession = new HashMap<>();

}
