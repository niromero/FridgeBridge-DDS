package org.grupo11.services.Shipping;

import org.grupo11.services.Client;
import org.grupo11.utils.Crypto;

public class Shipping {
    private Client sender;
    private Client receiver;
    private float price;
    private int trackingCode;
    private Track track;

    public Shipping(Client sender, Client receiver, float price, Track track) {
        this.sender = sender;
        this.receiver = receiver;
        this.price = price;
        this.trackingCode = Crypto.generateRandomCode(6);
        this.track = track;
        track.getPostman().addShipping(this);
    }

    // Getters
    public Client getSender() {
        return sender;
    }

    public Client getReceiver() {
        return receiver;
    }

    public float getPrice() {
        return price;
    }

    public int getTrackingCode() {
        return trackingCode;
    }

    public Track getTrack() {
        return track;
    }

}