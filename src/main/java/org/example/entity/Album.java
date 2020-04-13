package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "ALBUMS", schema = "DBB", catalog = "")
//@Table(name = "ALBUMS")
@NamedQueries({
        @NamedQuery(name = "Album.findByName",
                query = "SELECT p FROM Album p WHERE p.name=:name"),
        @NamedQuery(name = "Album.findByArtist",
                query = "SELECT p FROM Album p WHERE p.artistId=:name")
})
public class Album {
    private long id;
    private String name;
    private Long releaseYear;
    private Long artistId;
//    private Artist artistsByArtistId;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "RELEASE_YEAR", nullable = true, precision = 0)
    public Long getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Long releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Basic
    @Column(name = "ARTIST_ID", nullable = false, precision = 0)
    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Album album = (Album) o;

        if (id != album.id) return false;
        if (name != null ? !name.equals(album.name) : album.name != null) return false;
        if (releaseYear != null ? !releaseYear.equals(album.releaseYear) : album.releaseYear != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (releaseYear != null ? releaseYear.hashCode() : 0);
        return result;
    }

//    @ManyToOne
//    @JoinColumn(name = "ARTIST_ID", referencedColumnName = "ID", nullable = false)
//    public Artist getArtistsByArtistId() {
//        return artistsByArtistId;
//    }
//
//    public void setArtistsByArtistId(Artist artistsByArtistId) {
//        this.artistsByArtistId = artistsByArtistId;
//    }


}
