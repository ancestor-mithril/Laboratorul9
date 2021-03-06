package org.example.app;

import com.github.javafaker.Faker;
import org.example.entity.Album;
import org.example.entity.Artist;

import org.example.repo.AlbumRepository;
import org.example.repo.ArtistRepository;
import org.example.util.PersistanceUtil;

import java.util.ArrayList;
import java.util.List;

public class ArtistManager {
    /**
     * initializam niste artisti si niste albume si le introducem in db
     */
    public void doStuff(){
        PersistanceUtil.getInstance().setEntityManagerFactory();
        Artist artist1=new Artist();
        artist1.setCountry("da");
        artist1.setId(1);
        artist1.setName(new Faker().funnyName().name());
        Album album1=new Album();
        album1.setId(100);
        album1.setName(new Faker().funnyName().name());
        album1.setReleaseYear((long) 2019);
        album1.setArtistId((long) 1);

        ArtistRepository artistRepository=new ArtistRepository();
       artistRepository.create(artist1);

        PersistanceUtil.getInstance().setEntityManagerFactory();
        AlbumRepository albumRepository=new AlbumRepository();
        albumRepository.create(album1);
        PersistanceUtil.getInstance().setEntityManagerFactory();
        //Album album = albumRepository.findById(1);        //daca aceasta linie este documentata oracle da fail pentru ca nu este compatibil cu acest framework
        //in concluzie: schimbam frameworkul, sau folosim sql din Oracle si nu un middle-man

        //https://www.ibm.com/support/pages/error-message-javasqlsqlexception-ora-00933-sql-command-not-properly-ended-appears-when-using-alias-select-statement


    }
}
