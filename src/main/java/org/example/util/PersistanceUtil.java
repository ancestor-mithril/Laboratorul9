package org.example.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUtil;

public class PersistanceUtil {
    private static PersistanceUtil instance;
    EntityManagerFactory obj;
    private PersistanceUtil() {

    }
    public static PersistanceUtil getInstance() {
        if (instance == null)
            instance = new PersistanceUtil();
        return instance;
    }
    public EntityManagerFactory getEntityManagerFactory() {
        return this.obj;
    }
    public void setEntityManagerFactory() {
        this.obj= Persistence.createEntityManagerFactory("MusicAlbumPU");
    }
}
