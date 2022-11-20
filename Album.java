import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Album {

    int albumId;
    String albumName;
    Date releaseYear;
    // List<Song> songList = new ArrayList<>();//clean this up
    List<Artist> artistList = new ArrayList<>();

    DatabaseService databaseService = new DatabaseService();

    public Album() {
    }

    public Album(int albumId, String albumName, Date releaseYear, List<Artist> artistList) {
        this.albumId = albumId;
        this.albumName = albumName;
        this.releaseYear = releaseYear;
        // this.songList = songList;
        this.artistList = artistList;
    }

    // public void addSong(Song song) {
    // if (!songList.contains(song)) {
    // this.songList.add(song);
    // } else {
    // System.out.println(song.getSongName() + " Song already present!!!");
    // }
    // }

    // public void addSongs(List<Song> songs) {
    // for (Song song : songs) {
    // if (songList.isEmpty()) {
    // this.songList.add(song);
    // } else if (!songList.contains(song)) {
    // this.songList.add(song);
    // } else {
    // System.out.println(song.getSongName() + " Song already present!!!");
    // }
    // }
    // }

    public Album(int albumId, String albumName) {
        this.albumId = albumId;
        this.albumName = albumName;
    }

    public Album(String albumName) {
        this.albumName = albumName;
    }

    public void addArtist(Artist artist) {
        if (!artistList.contains(artist)) {
            this.artistList.add(artist);
        } else {
            System.out.println(artist.getArtistName() + " Artist already present!!!");
        }
    }

    public void addArtists(List<Artist> artists) {
        for (Artist artist : artists) {
            if (!artistList.contains(artist)) {
                this.artistList.add(artist);
            } else {
                System.out.println(artist.getArtistName() + " Artist already present!!!");
            }
        }
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    // public List<Song> getSongList() {
    // return songList;
    // }

    // public void setSongList(List<Song> songList) {
    // this.songList = songList;
    // }

    public List<Artist> getArtistList() {
        return artistList;
    }

    public void setArtistList(List<Artist> artistList) {
        this.artistList = artistList;
    }

    // @Override
    // public String toString() {
    // return "albumId=" + albumId + ", albumName=" + albumName + ", artistList=" +
    // artistList
    // + ", releaseYear=" + releaseYear;
    // }

    @Override
    public String toString() {
        return albumId + ":  " + albumName;
    }

}
