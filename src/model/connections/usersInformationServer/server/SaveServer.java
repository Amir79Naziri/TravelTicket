package model.connections.usersInformationServer.server;

import model.connections.usersInformationServer.serverStorage.UsersStorage;

/**
 * this Server Update's storage from client
 * mainly used for Saving
 */
public class SaveServer extends Server
{

    /**
     * creates a new Save Server
     * @param usersStorage usersStorage
     */
    public SaveServer (UsersStorage usersStorage) {
        super (4787,usersStorage);
    }
}