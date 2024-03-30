package dev.jensderuiter.minecraftfortnite.build;

import dev.jensderuiter.minecraftfortnite.RuntimeData;
import dev.jensderuiter.minecraftfortnite.build.style.BuildStyle;
import dev.jensderuiter.minecraftfortnite.build.style.FloorBuildStyle;
import dev.jensderuiter.minecraftfortnite.build.style.StairBuildStyle;
import dev.jensderuiter.minecraftfortnite.build.style.WallBuildStyle;
import lombok.SneakyThrows;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.List;

public class BuildSession {

    private List<Class<? extends BuildStyle>> BUILD_STYLES = List.of(
            WallBuildStyle.class,
            StairBuildStyle.class,
            FloorBuildStyle.class
    );

    private Player player;
    private int styleIndex;
    private BuildStyle lastStyle = null;

    public static void init(Player player) {
        RuntimeData.playerSession.put(player, new BuildSession(player));
    }

    public BuildSession(Player player) {
        this.player = player;
        this.styleIndex = 0;
    }

    public void scrollForward() {
        this.styleIndex++;
        if (this.styleIndex == BUILD_STYLES.size()) this.styleIndex = 0;
    }

    public void scrollBackward() {
        this.styleIndex--;
        if (this.styleIndex == -1) this.styleIndex = BUILD_STYLES.size() - 1;
    }

    public Class<? extends BuildStyle> currentStyleClass() {
        return BUILD_STYLES.get(this.styleIndex);
    }

    /**
     * Get the current style with default settings for location and material.
     * @return BuildStyle of the current style
     */
    @SneakyThrows
    public BuildStyle currentStyle() {
        BuildStyle style = this.currentStyleClass().getConstructor().newInstance();
        style.setLocation(this.getLocation());
        style.setMaterial(Material.OAK_PLANKS);
        return style;
    }

    /**
     * @return The player's base location rounded to a number without decimals. Contains yaw/pitch.
     */
    protected Location getLocation() {
        Location location = this.player.getEyeLocation().getBlock().getLocation();
        location.setYaw(this.player.getEyeLocation().getYaw());
        location.setPitch(this.player.getEyeLocation().getPitch());
        return location;
    }

    public void removePreview() {
        if (lastStyle == null) return;
        lastStyle.removePreview();
        lastStyle = null;
    }

    public void preview() {
        // first check whether the orientation changed (isMovable), and if so: just move it
        if (lastStyle != null && lastStyle.isMovable(this.getLocation())) {
            Vector offset = this.getLocation().subtract(lastStyle.getLocation()).toVector();
            if (offset.lengthSquared() != 0) lastStyle.move(offset);
            return;
        }

        // re-render
        this.removePreview();
        BuildStyle style = this.currentStyle();
        style.setMaterial(Material.YELLOW_STAINED_GLASS);
        style.preview();
        lastStyle = style;
    }

    public void build() {
        this.removePreview();
        this.currentStyle().build();
    }

}
