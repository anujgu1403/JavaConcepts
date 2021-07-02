package com.java.concepts.lld;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    List<ParkingFloor> parkingFloors;
    List<Entrance> entrances;
    List<Exit> exits;
    Address address;
    String parkingLotName;

    public boolean isParkingSpaceAvailableForParking(Vehicle vehicle) {
        return false;
    }

    public boolean updateParkingAttendant(ParkingAttendant parkingAttendant, int gateId) {
        return false;
    }
}

class ParkingFloor {
    int levelId;
    boolean isFree;
    List<ParkingSpace> parkingSpaces;
    ParkingDisplayBoard parkingDisplayBoard;
}

class Gate {
    int gateId;
    ParkingAttendant parkingAttendant;
}

class Entrance extends Gate {
    public ParkingTicket getParkingTicket(Vehicle vehicle) {
        return null;
    }
}

class Exit extends Gate {
    public ParkingTicket processPayment(ParkingTicket parkingTicket, PaymentType paymentType) {
        return null;
    }
}

class Address {
    String addressLine1;
    String addressLine2;
    String country;
    String state;
    String pinCode;
}

class ParkingSpace {
    int spaceId;
    boolean isFree;
    double costPerHour;
    Vehicle vehicle;
    ParkingSpaceType parkingSpaceType;
}

class ParkingDisplayBoard {
    Map<ParkingSpaceType, Integer> freeSpotAvailable;

    public void updateFreeSpotsAvailable(ParkingSpaceType parkingSpaceType, int noOfSpots) {
    }
}

class Account {
    int empId;
    String name;
    String email;
    String phone;
    String password;
    Address address;
}

class Admin extends Account {
    public boolean addParkingFloor(ParkingLot parkingLot, ParkingFloor parkingFloor) {
        return false;
    }

    public boolean addParkingSpace(ParkingFloor parkingFloor, ParkingSpace parkingSpace) {
        return false;
    }

    public boolean addParkingDisplayBoard(ParkingFloor parkingFloor, ParkingDisplayBoard parkingDisplayBoard) {
        return false;
    }
}

class ParkingAttendant extends Account {
    public boolean processVehicleEntry(Vehicle vehicle) {
        return false;
    }

    public PaymentInfo processPayment(ParkingTicket parkingTicket, PaymentType paymentType) {
        return null;
    }
}

class Vehicle {
    String licenseNumber;
    VehicleType vehicleType;
    PaymentInfo paymentInfo;
    ParkingTicket parkingTicket;
}

class ParkingTicket {
    int ticketId;
    int levelId;
    int spaceId;
    Date vehicleEntryDateTime;
    Date vehicleExitDateTime;
    ParkingSpaceType parkingSpaceType;
    double totalCost;
    ParkingTicketStatus parkingTicketStatus;

    public void updateTotalCost() {
    }

    public void updateVehicleExitTime(Date vehicleExitDateTime) {
    }

}

enum PaymentType {
    DEBIT_CARD, CREDIT_CARD, CASH, UPI
}

enum VehicleType {
    BIKE, CAR, TRUCK
}

enum ParkingSpaceType {
    CAR, BIKE, TRUCK
}

class PaymentInfo {
    double amount;
    Date paymentDate;
    int transactionId;
    ParkingTicket parkingTicket;
    PaymentStatus paymentStatus;
}

enum PaymentStatus {
    UNPAID, PENDING, COMPLETED, DECLINED, CANCELLED, REFUNDED
}

enum ParkingTicketStatus {
    PAID, ACTIVE
}