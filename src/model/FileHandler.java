package model;

import java.io.*;

public class FileHandler
{
    /**
     * save file
     */
    public static synchronized void save (Serializable object, String address)
    {
        try (ObjectOutputStream out = new ObjectOutputStream (
                new FileOutputStream (
                        new File (address)))){

            out.writeObject (object);
        } catch (IOException e)
        {
            System.out.println ("some thing went wrong in save");

        }
    }

    /**
     * load file
     */
    public static synchronized Serializable load (String address)
    {
        try (ObjectInputStream in = new ObjectInputStream (
                new FileInputStream (
                        new File (address)))){
            return (Serializable) in.readObject ();

        }
        catch (FileNotFoundException e)
        {
            return null;
        }
        catch (IOException | ClassNotFoundException e)
        {
            System.out.println ("some thing was wrong in load");
            return null;
        }
    }
}
