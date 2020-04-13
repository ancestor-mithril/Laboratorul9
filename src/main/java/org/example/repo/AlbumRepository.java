package org.example.repo;

import com.github.javafaker.Artist;
import org.example.entity.Album;

import org.example.util.PersistanceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class AlbumRepository {
    public void create(Album album) {
        EntityManagerFactory emf= PersistanceUtil.getInstance().getEntityManagerFactory();
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(album);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    public static Album findById(long id){
        EntityManagerFactory emf=PersistanceUtil.getInstance().getEntityManagerFactory();
        EntityManager em=emf.createEntityManager();
        Album album=em.find(Album.class, id);
        return album;
    }

    public List<Album> findByName(String name) {
        EntityManagerFactory emf=PersistanceUtil.getInstance().getEntityManagerFactory();
        EntityManager em=emf.createEntityManager();
        Query query = em.createQuery(
                "SELECT p FROM Album p WHERE p.name LIKE :personName")
                .setParameter("personName", name)
                .setMaxResults(10);
        return query.getResultList();
    }

    public List<Artist> findByArtist(Artist artist) {
        EntityManagerFactory emf=PersistanceUtil.getInstance().getEntityManagerFactory();
        EntityManager em=emf.createEntityManager();
        Query query = em.createQuery(
                "SELECT p FROM Album p WHERE p.artistId = :personName")
                .setParameter("personName", artist)
                .setMaxResults(10);
        return query.getResultList();
    }

}
