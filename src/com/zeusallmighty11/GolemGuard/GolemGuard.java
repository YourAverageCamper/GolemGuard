package com.zeusallmighty11.GolemGuard;


import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/** Why are you viewing this? */
public class GolemGuard extends JavaPlugin
{
    /* ==================================================================== */

    private static GolemGuard instance;
    List<String> owners;
    File dir;
    File config;
    File data;

    /* ==================================================================== */



    public void onEnable()
    {
        instance = this;
        owners = new ArrayList<>();

        try
        {
            dir = new File(getDataFolder() + "");
            if (!dir.exists())
                dir.mkdir();

            config = new File(getDataFolder() + "/config.yml");
            if (!config.exists())
                saveDefaultConfig();

            data = new File(getDataFolder() + "/data.txt");
            if (!data.exists())
                data.createNewFile();

        } catch (IOException ioe)
        {
            ioe.printStackTrace();
        }

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                owners = DataReader.getPlayers(data);
            }
        }.runTaskAsynchronously(this);

    }



    public void onDisable()
    {
        instance = null;
    }



    /* ==================================================================== */





    /* ==================================================================== */



    public static GolemGuard getInstance()
    {
        return instance;
    }



    public boolean hasEconomyHook()
    {
        return this.getServer().getPluginManager().getPlugin("Vault") != null;
    }

    /* ==================================================================== */
}
