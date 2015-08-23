package com.mibeez.hub.model;

/**
 * Zigbee or other non IP address.
 */
public class LanAddress {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LanAddress that = (LanAddress) o;

        return !(address != null ? !address.equals(that.address) : that.address != null);

    }

    @Override
    public int hashCode() {
        return address != null ? address.hashCode() : 0;
    }
}
