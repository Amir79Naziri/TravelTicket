package model.connections.usersInformationServer.serverStorage;


import model.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;


/**
 * this class is Users Storage
 */
public class UsersStorage implements Serializable
{

    private ArrayList<User> users;
    private Semaphore semaphore;


    /**
     * creates a User Storage
     */
    public UsersStorage ()
    {
        users = new ArrayList<> ();
        semaphore = new Semaphore (1);
    }


    /**
     * add User
     * @param user user
     */
    public void addUser (User user)
    {
        try {
            semaphore.acquire ();
            if (user == null)
                return;
            users.add (user);
        } catch (InterruptedException e)
        {
            System.out.println (e.getMessage ());
        } finally {
            semaphore.release ();
        }
    }

    /**
     * update users
     * @param user user
     * @return result
     */
    public String update (User user)
    {
        try {
            semaphore.acquire ();
            for (User user1 : users)
            {
                if (user1.idEquals (user))
                {
                    boolean phoneNumber = true, email = true;

                    if (!(user1.getPhoneNumber ().equals (user.getPhoneNumber ())) &&
                            !(user1.getEmail ().equals (user.getEmail ())))
                    {
                        int counter = 0;
                        for (User user2 : users)
                        {
                            if (user2.getPhoneNumber ().equals (user.getPhoneNumber ()))
                            {
                                phoneNumber = false;
                                counter++;
                            }

                            if (user2.getEmail ().equals (user.getEmail ()))
                            {
                                email = false;
                                counter++;
                            }

                            if (counter == 2)
                                break;
                        }
                    }
                    else if (!(user1.getPhoneNumber ().equals (user.getPhoneNumber ())))
                    {
                        for (User user2 : users)
                        {
                            if (user2.getPhoneNumber ().equals (user.getPhoneNumber ()))
                            {
                                phoneNumber = false;
                                break;
                            }
                        }
                    }
                    else if (!(user1.getEmail ().equals (user.getEmail ())))
                    {
                        for (User user2 : users)
                        {
                            if (user2.getEmail ().equals (user.getEmail ()))
                            {
                                email = false;
                                break;
                            }

                        }
                    }
                    String res;
                    if (!phoneNumber && !email)
                        res =  "Error_1";
                    else if (!phoneNumber)
                        res = "Error_2";
                    else if (!email)
                        res = "Error_3";
                    else
                        res = "Successful";
                    user1.update (user, res);

                    return res;

                }
            }

            return "Error_4";
        } catch (InterruptedException e)
        {
            System.out.println (e.getMessage ());
            return "Error_4";
        } finally {
            semaphore.release ();
        }
    }

    /**
     * get user
     * @param field email or password
     * @param password password
     * @param type 1 means phone , 2 means email
     * @return user
     */
    public User getUser (String field, String password, int type)
    {
        try {
            semaphore.acquire ();
            User user1 = new User (field,password,type);
            for (User user : users)
            {
                if (user.equals (user1))
                {
                    return user;
                }
            }
            return null;
        } catch (InterruptedException e)
        {
            System.out.println (e.getMessage ());
            return null;
        } finally {
            semaphore.release ();
        }
    }

    public boolean hasFieldUsed (String field, int type)
    {
        try {
            semaphore.acquire ();
            User user1 = new User (field,"",type);
            for (User user : users)
            {
                if (user.fieldEquals (user1))
                {
                    return true;
                }
            }
            return false;
        } catch (InterruptedException e)
        {
            System.out.println (e.getMessage ());
            return true;
        } finally {
            semaphore.release ();
        }

    }


}
