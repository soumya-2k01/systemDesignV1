package org.example.manager;

import org.example.entity.PlayerType;
import org.example.entity.ShipRequest;

public interface LocationValidator {
    boolean validateLocation(ShipRequest shipRequest, int n);
}
