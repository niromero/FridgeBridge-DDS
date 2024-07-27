package org.grupo11.Services.Fridge;

import org.grupo11.Constants;
import org.grupo11.Services.Contributor.ContributorCard;
import org.grupo11.Utils.DateUtils;

public class FridgeSolicitude {
    private ContributorCard issuedBy;
    private Fridge fridge;
    private long issuedAt;
    private boolean alreadyUsed;

    public FridgeSolicitude(ContributorCard issuedBy, long issuedAt, Fridge fridge) {
        this.fridge = fridge;
        this.issuedAt = issuedAt;
        this.issuedBy = issuedBy;
        this.alreadyUsed = false;
    }

    // permission is valid if and only if it has passed less than an hour from the
    // issuing of the permission
    public boolean isValid() {
        long timeDifference = DateUtils.getCurrentTimeInMs() - issuedAt;
        long threeHoursInMillis = Constants.COLLAB_PERMISSION_EXPIRATION_HS * 60 * 60 * 1000; // 3 hours * 60
                                                                                              // minutes/hour * 60
        // seconds/minute * 1000

        return timeDifference <= threeHoursInMillis;
    }

    public ContributorCard getIssuedBy() {
        return this.issuedBy;
    }

    public Fridge getFridge() {
        return this.fridge;
    }

    public long getIssuedAt() {
        return this.issuedAt;
    }

    public boolean hasBeenUsed() {
        return this.alreadyUsed;
    }

    public void markAsUsed() {
        this.alreadyUsed = true;
    }

}
