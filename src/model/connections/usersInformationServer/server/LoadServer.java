package model.connections.usersInformationServer.server;


import model.connections.usersInformationServer.serverStorage.UsersStorage;

/**
 * this Server get's User for Login or Refresh
 */
public class LoadServer extends Server
{

    /**
     * creates a new Load Server
     * @param usersStorage usersStorage
     */
    public LoadServer (UsersStorage usersStorage) {
        super (8083,usersStorage);
    }
}
