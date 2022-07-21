import java.time.Duration;
import java.util.List;

public class Song {
    
    int songId;
    String songName;
    Duration duration;
    List<Artist> artistList;
    List<Genre> genreList;
    
    public Song() {
    }

    public Song(int songId, String songName, Duration duration, List<Artist> artistList, List<Genre> genreList) {
        this.songId = songId;
        this.songName = songName;
        this.duration = duration;
        this.artistList = artistList;
        this.genreList = genreList;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof Song)) {
            return false;
        }

        Song s = (Song)obj;

        return this.songName.equals(s.songName) && this.songId == s.songId;
    }

    public int getSongId() {
        return songId;
    }
    public void setSongId(int songId) {
        this.songId = songId;
    }
    public String getSongName() {
        return songName;
    }
    public void setSongName(String songName) {
        this.songName = songName;
    }
    public Duration getDuration() {
        return duration;
    }
    public void setDuration(Duration duration) {
        this.duration = duration;
    }
    public List<Artist> getArtistList() {
        return artistList;
    }
    public void setArtistList(List<Artist> artistList) {
        this.artistList = artistList;
    }
    public List<Genre> getGenreList() {
        return genreList;
    }
    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }

    @Override
    public String toString() {
        return "songName=" + songName + ", artistList=" + artistList + ", duration=" + duration + ", genreList=" + genreList + ", songId="
                + songId;
    }

}
