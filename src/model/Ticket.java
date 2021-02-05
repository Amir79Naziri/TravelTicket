package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Ticket implements Serializable
{
    private String departureCity, arrivalCity, airLineName;
    private int departureHour, departureMinute, arrivalHour, arrivalMinute;
    private LocalDate departureDate, arrivalDate;
    private int code, price;
    private User passengers;

    public Ticket(String departureCity, String arrivalCity, String airLineName,
            int departureHour, int departureMinute, int arrivalHour, int arrivalMinute,
                          int departureYear, int departureMonth, int departureDay,
                          int arrivalYear, int arrivalMonth, int arrivalDay,
                          int code, int price)
    {
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.airLineName = airLineName;
        this.departureHour = departureHour;
        this.departureMinute = departureMinute;
        this.arrivalHour = arrivalHour;
        this.arrivalMinute = arrivalMinute;
        this.departureDate = LocalDate.of(departureYear, departureMonth, departureDay);
        this.arrivalDate = LocalDate.of(arrivalYear, arrivalMonth, arrivalDay);
        this.code = code;
        this.price = price;
        passengers = null;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getAirLineName() {
        return airLineName;
    }

    public void setAirLineName(String airLineName) {
        this.airLineName = airLineName;
    }

    public int getDepartureHour() {
        return departureHour;
    }

    public void setDepartureHour(int departureHour) {
        this.departureHour = departureHour;
    }

    public int getDepartureMinute() {
        return departureMinute;
    }

    public void setDepartureMinute(int departureMinute) {
        this.departureMinute = departureMinute;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public int getArrivalHour() {
        return arrivalHour;
    }

    public void setArrivalHour(int arrivalHour) {
        this.arrivalHour = arrivalHour;
    }

    public int getArrivalMinute() {
        return arrivalMinute;
    }

    public void setArrivalMinute(int arrivalMinute) {
        this.arrivalMinute = arrivalMinute;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public User getPassengers() {
        return passengers;
    }

    public void setPassengers(User passengers) {
        this.passengers = passengers;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void sellTicket(User user)
    {
        if(passengers == null)
        {
            passengers = user;
            System.out.println("Buying Ticket was successful");
        }
        else
            System.out.println("There is no more capacity");
    }

    public void retrieveTicket(User user)
    {
        if(passengers != null)
        {
            passengers = null;
            System.out.println("Retrieving Ticket was successful");
            return;
        }

        System.out.println("There isn't any Passenger with This information!!!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;
        Ticket ticket = (Ticket) o;
        return code == ticket.code;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "departureCity='" + departureCity + '\'' +
                ", arrivalCity='" + arrivalCity + '\'' +
                ", airLineName='" + airLineName + '\'' +
                ", departureHour=" + departureHour +
                ", departureMinute=" + departureMinute +
                ", departureDate=" + departureDate +
                ", code=" + code +
                ", price=" + price +
                '}';
    }
}
