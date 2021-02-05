package model;

import java.io.Serializable;
import java.util.*;

public class Ticket implements Serializable
{
    private String departureCity, arrivalCity, airLineName;
    private int departureHour, departureMinute, arrivalHour, arrivalMinute;
    private int departureYear, departureMonth, departureDay;
    private int arrivalYear,arrivalMonth, arrivalDay;
    private int capacity, sold, code;
    private List<User> passengers;

    public Ticket(String departureCity, String arrivalCity, String airLineName,
            int departureHour, int departureMinute, int arrivalHour, int arrivalMinute,
                          int departureYear, int departureMonth, int departureDay,
                          int arrivalYear, int arrivalMonth, int arrivalDay,
                          int capacity, int code)
    {
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.airLineName = airLineName;
        this.departureHour = departureHour;
        this.departureMinute = departureMinute;
        this.arrivalHour = arrivalHour;
        this.arrivalMinute = arrivalMinute;
        this.departureYear = departureYear;
        this.departureMonth = departureMonth;
        this.departureDay = departureDay;
        this.arrivalYear = arrivalYear;
        this.arrivalMonth = arrivalMonth;
        this.arrivalDay = arrivalDay;
        this.capacity = capacity;
        this.sold = 0;
        this.code = code;
        passengers = Collections.synchronizedList(new ArrayList<>());
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

    public int getDepartureYear() {
        return departureYear;
    }

    public void setDepartureYear(int departureYear) {
        this.departureYear = departureYear;
    }

    public int getDepartureMonth() {
        return departureMonth;
    }

    public void setDepartureMonth(int departureMonth) {
        this.departureMonth = departureMonth;
    }

    public int getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(int departureDay) {
        this.departureDay = departureDay;
    }

    public int getArrivalYear() {
        return arrivalYear;
    }

    public void setArrivalYear(int arrivalYear) {
        this.arrivalYear = arrivalYear;
    }

    public int getArrivalMonth() {
        return arrivalMonth;
    }

    public void setArrivalMonth(int arrivalMonth) {
        this.arrivalMonth = arrivalMonth;
    }

    public int getArrivalDay() {
        return arrivalDay;
    }

    public void setArrivalDay(int arrivalDay) {
        this.arrivalDay = arrivalDay;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<User> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<User> passengers) {
        this.passengers = passengers;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void sellTicket(User user)
    {
        if(sold < capacity)
        {
            sold++;
            passengers.add(user);
            System.out.println("Buying Ticket was successful");
        }
        else
            System.out.println("There is no more capacity");
    }

    public void retrieveTicket(User user)
    {
        Iterator<User> iterator = passengers.iterator();
        while(iterator.hasNext())
        {
            User temp = iterator.next();
            if(temp.equals(user))
            {
                sold--;
                passengers.remove(temp);
                System.out.println("Retrieving Ticket was successful");
                return;
            }
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
}
