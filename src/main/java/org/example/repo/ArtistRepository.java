package org.example.repo;



import org.example.entity.Artist;
import org.example.util.PersistanceUtil;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.Order;
import java.util.Date;
import java.util.List;


public class ArtistRepository {

    public void create(Artist artist) {
        EntityManagerFactory emf=PersistanceUtil.getInstance().getEntityManagerFactory();
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(artist);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
//    public Artist findById(long id){
//        EntityManagerFactory emf=PersistanceUtil.getInstance().getEntityManagerFactory();
//        EntityManager em=emf.createEntityManager();
//        em.getTransaction().begin();
//        Artist artist=em.find(Artist.class, id);
//        em.getTransaction().commit();
//        return artist;
//    }
    public static Artist findById (Long e){
        EntityManager em = Persistence.createEntityManagerFactory("MusicAlbumPU").createEntityManager();
        em.getTransaction().begin();
        Artist al = em.find(Artist.class, e);
        em.getTransaction().commit();
        em.close();
        return al;
    }

    public List<Artist> findByName(String name) {
        EntityManagerFactory emf=PersistanceUtil.getInstance().getEntityManagerFactory();
        EntityManager em=emf.createEntityManager();
        Query query = em.createQuery(
                "SELECT p FROM Artist p WHERE p.name LIKE :personName")
                .setParameter("personName", name)
                .setMaxResults(10);
        return query.getResultList();
    }

}
