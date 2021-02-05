package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class User implements Serializable
{
    private HashMap<Integer, Ticket> tickets;
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
        this.tickets = new HashMap<> ();
        this.firstName = "";
        this.lastName = "";
        if (type == 1)
        {
            this.phoneNumber = Objects.requireNonNull (field, "");
            this.email = "";
        }
        else
        {
            this.email = Objects.requireNonNull (field, "");
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

    private void setTickets (HashMap<Integer, Ticket> tickets) {
        this.tickets = tickets;
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

    public void addTicket (int id, Ticket ticket) {
        if (ticket != null)
            this.tickets.put (id, ticket);
    }

    public void removeTicket (int id) {
        this.tickets.remove (id);
    }



    public void setBankAccountNumber (String bankAccountNumber) {
        this.bankAccountNumber = Objects.requireNonNull (bankAccountNumber, "");
    }

    public void changePassword (String newPassword, String oldPassword) {
        if (oldPassword != null && oldPassword.equals (this.password))
        {
            this.password = Objects.requireNonNullElse (newPassword, "");
        }
    }

    private void setPassword(String password)
    {
        this.password = Objects.requireNonNull (password, "");
    }

    private void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public void createWallet (Wallet wallet) {
        if (this.wallet == null)
            this.wallet = wallet;
    }

    public void setSocialSecurityNumber (String socialSecurityNumber) {
        this.socialSecurityNumber = Objects.requireNonNull (socialSecurityNumber, "");
    }

    public HashMap<Integer, Ticket> getTickets () {
        return new HashMap<> (tickets);
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

    private Wallet getWallet()
    {
        return wallet;
    }

    private String getPassword()
    {
        return password;
    }

    public void update(User user)
    {
        if (user == null)
            return;

        this.setFirstName (user.getFirstName ());
        this.setLastName (user.getLastName ());
        this.setBankAccountNumber (user.getBankAccountNumber ());
        this.setEmail (user.getEmail ());
        this.setWallet (user.getWallet ());
        this.setPhoneNumber (user.getPhoneNumber ());
        this.setPassword (user.getPassword ());
        this.setSocialSecurityNumber (user.getSocialSecurityNumber ());
        this.setTickets (user.getTickets ());
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        boolean res1 = Objects.equals (getPassword (), user.getPassword ());
        boolean res2 = Objects.equals (getPhoneNumber (), user.getPhoneNumber ());
        boolean res3 = Objects.equals (getEmail (), user.getEmail ());

        if (getPhoneNumber ().equals ("") && user.getPhoneNumber ().equals (""))
            res2 = false;

        if (getEmail ().equals ("") && user.getEmail ().equals (""))
            res3 = false;

        return (res1) && (res2 || res3);
    }


    public boolean fieldEquals (Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;


        boolean res2 = Objects.equals (getPhoneNumber (), user.getPhoneNumber ());
        boolean res3 = Objects.equals (getEmail (), user.getEmail ());

        if (getPhoneNumber ().equals ("") && user.getPhoneNumber ().equals (""))
            res2 = false;

        if (getEmail ().equals ("") && user.getEmail ().equals (""))
            res3 = false;

        return (res2 || res3);
    }
}
