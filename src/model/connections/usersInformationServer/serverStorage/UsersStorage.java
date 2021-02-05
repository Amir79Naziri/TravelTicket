package model.connections.usersInformationServer.serverStorage;


import model.User;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * this class is Users Storage
 */
public class UsersStorage implements Serializable
{

    private ArrayList<User> users;


    /**
     * creates a User Storage
     */
    public UsersStorage ()
    {
        users = new ArrayList<> ();
    }


    /**
     * add User
     * @param user user
     */
    public synchronized void addUser (User user)
    {
        if (user == null)
            return;
        users.add (user);
    }

    /**
     * update users
     * @param user user
     * @return result
     */
    public synchronized boolean update (User user)
    {

        for (User user1 : users)
        {
            if (user1.fieldEquals (user))
            {
                user1.update (user);
                return true;
            }
        }
        return false;
    }

    /**
     * get user
     * @param field email or password
     * @param password password
     * @param type 1 means phone , 2 means email
     * @return user
     */
    public synchronized User getUser (String field, String password, int type)
    {
        User user1 = new User (field,password,type);
        for (User user : users)
        {
            if (user.equals (user1))
            {
                return user;
            }
        }
        return null;
    }

    public synchronized boolean hasFieldUsed (String field, int type)
    {
        User user1 = new User (field,"1",type);
        for (User user : users)
        {
            if (user.fieldEquals (user1))
            {
                return true;
            }
        }
        return false;
    }


}
