package dev.jensderuiter.minecraftfortnite.build.style;

import org.bukkit.Location;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class StairBuildStyle extends BaseBuildStyle {

    @Override
    public List<Location> getStructure() {
        Vector rightVector = this.getRightVector();
        Vector backwardVector = this.getForwardVector().multiply(-1);
        Vector backwardTwoVector = this.getForwardVector().multiply(-2);
        Vector leftVector = rightVector.clone().multiply(-1);
        Location baseLocation = this.getBaseLocation();
        List<Location> locations = new ArrayList<>();
        locations.add(baseLocation.getBlock().getLocation().add(0, 1, 0));
        locations.add(baseLocation.getBlock().getLocation().add(leftVector).add(0, 1, 0));
        locations.add(baseLocation.getBlock().getLocation().add(rightVector).add(0, 1, 0));

        locations.add(baseLocation.getBlock().getLocation().add(backwardVector));
        locations.add(baseLocation.getBlock().getLocation().add(backwardVector).add(leftVector));
        locations.add(baseLocation.getBlock().getLocation().add(backwardVector).add(rightVector));

        locations.add(baseLocation.getBlock().getLocation()
                .add(backwardTwoVector).add(0, -1, 0));
        locations.add(baseLocation.getBlock().getLocation()
                .add(backwardTwoVector).add(leftVector).add(0, -1, 0));
        locations.add(baseLocation.getBlock().getLocation()
                .add(backwardTwoVector).add(rightVector).add(0, -1, 0));

        return locations;
    }
}
