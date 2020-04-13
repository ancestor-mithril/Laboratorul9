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
        //album1.setArtistsByArtistId(artist1);
//        List<Album> albums=new ArrayList<>();
//        albums.add(album1);
//
        ArtistRepository artistRepository=new ArtistRepository();
//        artistRepository.create(artist1);
//
//        PersistanceUtil.getInstance().setEntityManagerFactory();
        AlbumRepository albumRepository=new AlbumRepository();
        albumRepository.create(album1);
        PersistanceUtil.getInstance().setEntityManagerFactory();
        //Album album = AlbumRepository.findById(1);

        //Artist artist = ArtistRepository.findById((long) 1);
//        List<Album> artists=albumRepository.findByName("Winnie Bago");
//        for (Album album: artists)
//            System.out.println(album.getName());
    }
}
