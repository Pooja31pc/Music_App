import java.time.Duration;
import java.util.List;

public class Song {

    int songId;
    String songName;
    Duration duration;
    List<Artist> artistList;
    List<Genre> genreList;
    Album album; // Create gettre setter everything

    public Song() {
    }

    public Song(int songId, String songName, Duration duration, List<Artist> artistList, List<Genre> genreList,
            Album album) {
        this.songId = songId;
        this.songName = songName;
        this.duration = duration;
        this.artistList = artistList;
        this.genreList = genreList;
        this.album = album;
    }

    public Song(String songName) {
        this.songName = songName;
    }

    public Song(int songId) {
        this.songId = songId;
    }

    public Song(int songId, String songName) {
        this.songName = songName;
        this.songId = songId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Song)) {
            return false;
        }

        Song s = (Song) obj;

        return this.songName.equals(s.songName) && this.songId == s.songId;
    }

    public int getSongId() {
        return songId;
    }

    public int getSongId(Song songName) {
        this.songId = songName.getSongId();
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

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    // @Override
    // public String toString() { // *******iska return value object p depend krta
    // hai - object k details s hi bn
    // // rhi hai - so object bnae bina toString ni bn skta to islie isko static
    // // ni kr skte ise agr static kr die to sb k lie song name(say) same ho jaega
    // return "songName=" + songName + ", artistList=" + artistList + ", duration="
    // + duration + ", genreList="
    // + genreList + ", songId=" + songId + ", album=" + album;
    // }

    @Override
    public String toString() {
        return songId + ":  " + songName;
    }

}
