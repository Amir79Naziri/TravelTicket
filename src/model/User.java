package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class User implements Serializable
{
    private ArrayList<Ticket> tickets;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String socialSecurityNumber;
    private String bankAccountNumber;
    private String password;
    private Wallet wallet;


    public User (String field, String password, int type)
    {
        this.tickets = new ArrayList<> ();
        this.firstName = "";
        this.lastName = "";
        if (type == 1)
        {
            this.phoneNumber = field;
            this.email = "";
        }
        else
        {
            this.email = field;
            this.phoneNumber = "";
        }
        this.socialSecurityNumber = "";
        this.bankAccountNumber = "";
        this.password = password;
        this.wallet = null;
    }


    public void setFirstName (String firstName) {
        this.firstName = Objects.requireNonNull (firstName, "");;
    }

    public void setEmail (String email) {
        this.email = Objects.requireNonNull (email, "");;
    }

    public void setLastName (String lastName) {
        this.lastName = Objects.requireNonNull (lastName, "");;
    }

    public void setPhoneNumber (String phoneNumber) {
        this.phoneNumber = Objects.requireNonNull (phoneNumber, "");;
    }

    public void addTicket (Ticket ticket) {
        if (ticket != null)
            this.tickets.add (ticket);
    }

    public Ticket removeTicket (int index) {
        return this.tickets.remove (index);
    }

    public boolean removeTicket (Ticket ticket) {
        return this.tickets.remove (ticket);
    }

    public void setBankAccountNumber (String bankAccountNumber) {
        this.bankAccountNumber = Objects.requireNonNull (bankAccountNumber, "");
    }

    public void setPassword (String newPassword, String oldPassword) {
        if (oldPassword != null && oldPassword.equals (this.password))
        {
            this.password = Objects.requireNonNullElse (newPassword, "");
        }
    }

    public void setSocialSecurityNumber (String socialSecurityNumber) {
        this.socialSecurityNumber = Objects.requireNonNull (socialSecurityNumber, "");
    }

    public ArrayList<Ticket> getTickets () {
        return tickets;
    }

    public String getEmail () {
        return email;
    }

    public String getFirstName () {
        return firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public String getPhoneNumber () {
        return phoneNumber;
    }

    public String getBankAccountNumber () {
        return bankAccountNumber;
    }

    public String getSocialSecurityNumber () {
        return socialSecurityNumber;
    }

    public void createWallet (Wallet wallet) {
        if (this.wallet == null)
            this.wallet = wallet;
    }
}
