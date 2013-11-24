package com.zeusallmighty11.GolemGuard;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/** Why are you viewing this? */
public class DataReader
{

    public static List<String> getPlayers(File f)
    {
        try
        {
            List<String> temp = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            while ((line = br.readLine()) != null)
                temp.add(line);
            br.close();
            return temp;
        } catch (IOException e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return new ArrayList<>();
        }
    }

}
