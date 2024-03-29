package com.autovend.software.controllers;

public class SuspendController {
    public Station station;
    public boolean suspended; // Indicates if the station is currently suspended

    // Constructor
    public SuspendController(Station station) {
        if (station == null) {
            this.station = new Station("", false);
        } else {
            this.station = station;
            this.station.inUse = station.inUse;
        }
        this.suspended = false; // Initialize the station as not suspended before anything happens.
    }

    public void stationSetUp() {

        this.suspended = true; // Initialize the station as suspended
    }

    // Method to suspend the station
    public boolean suspend() {
        if (!suspended && !station.isInUse()) {
            // Check if the station is not already suspended and not in use
            System.out.println("The Station has been suspended.");
            suspended = true;
            return suspended;
        } else if (suspended) {
            System.out.println("The Station is already suspended.");
            suspended = false;
            return suspended;
        } else {
            //The system won't be suspended when user is in use.
            System.out.println("Cannot suspend the station when customer is using it.");
            return suspended;
        }
    }

    // Method to unsuspended the station after maintenance
    public void unsuspend() {
        if (suspended) {
            System.out.println("Station has been unsuspended and is ready for use.");
            suspended = false;
        } else {
            System.out.println("Station is not currently suspended.");
        }
    }

    // Method to check if the station is currently suspended
    public boolean isSuspended() {

        return suspended;
    }

    //Create a Station class for suspendController test.
    public class Station {
        private final String name;
        private boolean inUse = false;

        public Station(String name, boolean inUse) {
            this.name = name;
            this.inUse = inUse;
        }

        public String getName() {
            return name;
        }

        public boolean isInUse() {
            return inUse;
        }

        public void setInUse(boolean inUse) {
            this.inUse = inUse;
        }
    }
}
