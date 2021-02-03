package model.connections.usersInformationServer.serverStorage;


import model.User;
import java.util.ArrayList;

/**
 * this class is Users Storage
 */
public class UsersStorage
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
     * sets Users
     * @param users users
     */
    public synchronized void setUsers (ArrayList<User> users) {
        this.users = users;
    }

    /**
     * get Users
     * @return users
     */
    public synchronized ArrayList<User> getUsers () {
        return users;
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
            if (user1.equals (user))
            {
                user1.update (user);
                return true;
            }
        }
        return false;
    }

//    /**
//     * get user
//     * @param userName userName
//     * @param password password
//     * @return user
//     */
//    public User getUser (String userName, char[] password)
//    {
//        isIterate = true;
//        User user1 = new User (userName,password,null);
//        for (User user : users)
//        {
//            if (user.equals (user1))
//            {
//                isIterate = false;
//                return user;
//            }
//        }
//        isIterate = false;
//        return null;
//    }
//
//    /**
//     * has username used
//     * @param userName userName
//     * @return result
//     */
//    public boolean hasUserNameUsed (String userName)
//    {
//        User user = new User (userName,new char[]{'.','.','.'},null);
//        isIterate = true;
//        for (User user1 : users)
//        {
//            if (user1.getUserName ().equals (user.getUserName ()))
//            {
//                isIterate = false;
//                return true;
//            }
//        }
//        isIterate = false;
//        return false;
//    }
}
