package org.example;




import org.example.app.ArtistManager;
import org.example.util.PersistanceUtil;

import javax.persistence.EntityManagerFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class App {
    public static void main(String[] args) {
        ArtistManager a=new ArtistManager();
        a.doStuff();
    }

}
