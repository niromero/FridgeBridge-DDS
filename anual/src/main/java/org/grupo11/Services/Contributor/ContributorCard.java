package org.grupo11.Services.Contributor;

import java.util.List;

import org.grupo11.Services.Fridge.FridgeSolicitude;
import org.grupo11.Services.Fridge.Fridge;
import org.grupo11.Utils.DateUtils;

public class ContributorCard {
    private int id;
    private Contributor owner;
    private List<FridgeSolicitude> permissions;

    public ContributorCard(int id, Contributor owner, List<FridgeSolicitude> permissions) {
        this.id = id;
        this.owner = owner;
        this.permissions = permissions;
    }

    public void registerPermission(Fridge fridge) {
        FridgeSolicitude solicitude = new FridgeSolicitude(this, DateUtils.getCurrentTimeInMs(), fridge);
        permissions.add(solicitude);
        fridge.addSolicitudes(solicitude);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contributor getOwner() {
        return this.owner;
    }

    public void setOwner(Contributor owner) {
        this.owner = owner;
    }

    public List<FridgeSolicitude> getPermissions() {
        return this.permissions;
    }

    public void setPermissions(List<FridgeSolicitude> permissions) {
        this.permissions = permissions;
    }

}
