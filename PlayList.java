import java.util.ArrayList;
import java.util.List;

public class PlayList {

    int playListId;
    String playListName;
    List<Song> songList = new ArrayList<>();

    public PlayList() {
    }

    public PlayList(int playListId, String playListName, List<Song> songList) {
        this.playListId = playListId;
        this.playListName = playListName;
        this.songList = songList;
    }

    public PlayList(int playListId, String playListName) {
        this.playListId = playListId;
        this.playListName = playListName;
    }

    public void addSong(Song song) {
        if (!songList.contains(song)) {
            this.songList.add(song);
        } else {
            System.out.println(song + " Song already present!!!");
        }
    }

    public void addSongs(List<Song> songs) {
        for (Song song : songs) {
            if (!songList.contains(song)) {
                this.songList.add(song);
            } else {
                System.out.println(song + " Song already present!!!");
            }
        }
    }

    public void addPlayList(String playListName, int playListId) {

    }

    public int getPlayListId() {
        return playListId;
    }

    public void setPlayListId(int playListId) {
        this.playListId = playListId;
    }

    public String getPlayListName() {
        return playListName;
    }

    public void setPlayListName(String playListName) {
        this.playListName = playListName;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    @Override
    public String toString() {
        return playListId + ":  " + playListName;
    }

}
