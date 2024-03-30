package dev.jensderuiter.minecraftfortnite.build.style;

import org.bukkit.Location;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class WallBuildStyle extends BaseBuildStyle {

    @Override
    public List<Location> getStructure() {
        Vector rightVector = this.getRightVector();
        Vector leftVector = rightVector.clone().multiply(-1);
        Location baseLocation = this.getBaseLocation();
        List<Location> locations = new ArrayList<>();
        locations.add(baseLocation.getBlock().getLocation());
        locations.add(baseLocation.getBlock().getLocation().add(0, 1, 0));
        locations.add(baseLocation.getBlock().getLocation().add(0, -1, 0));
        locations.add(baseLocation.getBlock().getLocation().add(leftVector));
        locations.add(baseLocation.getBlock().getLocation().add(leftVector).add(0, 1, 0));
        locations.add(baseLocation.getBlock().getLocation().add(leftVector).add(0, -1, 0));
        locations.add(baseLocation.getBlock().getLocation().add(rightVector));
        locations.add(baseLocation.getBlock().getLocation().add(rightVector).add(0, 1, 0));
        locations.add(baseLocation.getBlock().getLocation().add(rightVector).add(0, -1, 0));
        return locations;
    }
}
