package org.example.repo;

import com.github.javafaker.Artist;
import org.example.entity.Album;

import org.example.util.PersistanceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class AlbumRepository {
    /**
     * introducem in DB un album
     * @param album
     */
    public void create(Album album) {
        EntityManagerFactory emf= PersistanceUtil.getInstance().getEntityManagerFactory();
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(album);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    /**
     * cautam dupa id un album
     * @param id
     * @return
     */
    public  Album findById(long id){
        EntityManagerFactory emf=PersistanceUtil.getInstance().getEntityManagerFactory();
        EntityManager em=emf.createEntityManager();
        Album album=em.find(Album.class, id);
        return album;
    }

    /**
     * cautam o lista de albume dupa nume
     * @param name
     * @return
     */
    public List<Album> findByName(String name) {
        EntityManagerFactory emf=PersistanceUtil.getInstance().getEntityManagerFactory();
        EntityManager em=emf.createEntityManager();
        Query query = em.createQuery(
                "SELECT p FROM Album p WHERE p.name LIKE :personName")
                .setParameter("personName", name)
                .setMaxResults(10);
        return query.getResultList();
    }

    /**
     * cautam un album dupa id-ul artistului
     * @param id
     * @return
     */
    public List<Artist> findByArtist(long id) {
        EntityManagerFactory emf=PersistanceUtil.getInstance().getEntityManagerFactory();
        EntityManager em=emf.createEntityManager();
        Query query = em.createQuery(
                "SELECT p FROM Album p WHERE p.artistId = :personName")
                .setParameter("personName", id)
                .setMaxResults(10);
        return query.getResultList();
    }

}
