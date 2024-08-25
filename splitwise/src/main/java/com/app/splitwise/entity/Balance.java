package com.app.splitwise.entity;

import lombok.Data;

@Data
public class Balance {
    Double oweAmount; // How much you owe to friend
    Double getBackAmount; // How much you get back from friend

    public Balance() {
        this.oweAmount = 0.0;
        this.getBackAmount = 0.0;
    }
}
