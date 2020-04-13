package org.example.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUtil;

public class PersistanceUtil {
    private static PersistanceUtil instance;
    static EntityManagerFactory obj;

    /**
     * constructorul este privat
     */
    private PersistanceUtil() {
        setEntityManagerFactory();
    }

    /**
     * primim instanta de singleton
     * @return
     */
    public static PersistanceUtil getInstance() {
        if (instance == null)
            instance = new PersistanceUtil();
        return instance;
    }

    /**
     * returnam un entity factory manager
     * @return
     */
    public EntityManagerFactory getEntityManagerFactory() {
        return this.obj;
    }

    /**
     * seta, un entity managet factory
     */
    public void setEntityManagerFactory() {
        this.obj= Persistence.createEntityManagerFactory("MusicAlbumPU");
    }
}
