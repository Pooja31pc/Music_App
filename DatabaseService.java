import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService {

    public DatabaseService() {
        initialiseConnection();
    }

    List<Album> albumList = new ArrayList<>();

    Connection conn = null;

    public void initialiseConnection() { // ye static ho skat hai ya ni? - hr entity class ko db access krna hai, db
                                         // access krega ek connection k through to wo connection static ho skat hai k
                                         // ni, sbko to ek hi link lgegi na connection bnane k lie? - So we can make it
                                         // static but it's not a good practice and also agr static krna hai to ise ek
                                         // function m ni kr skte.
        // initialise connection
        String url = "jdbc:mysql://localhost:3306/playlist";
        String username = "root";
        String password = "Password@123";

        try {

            conn = DriverManager.getConnection(url, username, password);

            if (conn != null) {
                System.out.println("Connected");
                conn.setAutoCommit(true);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // public void insertGenre(Class<Genre> genres) {
    public void insertGenre(Genre genre) {
        String sql = "INSERT INTO genre (genreName) VALUES (?)";

        PreparedStatement statement;
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, genre.name());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new genre is inserted successfully!");
            } else {
                System.out.println("Genre already present");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void insertArtist(Artist artist) {
        String sql = "INSERT INTO artist (artistId, artistName) VALUES (?, ?)";

        PreparedStatement statement;
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, artist.artistId);
            statement.setString(2, artist.artistName);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new artist is inserted successfully!");
            } else {
                System.out.println("Genre already present");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    // public void addSongToAlbum(){

    // }

    public void insertSong(Song song) {
        System.out.println("In insertSong function");
        String sql = "INSERT INTO song (songId, songName, albumId) VALUES (?, ?, ?)";
        // Album album = new Album();
        PreparedStatement statement;
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, song.songId);
            statement.setString(2, song.songName);
            statement.setInt(3, song.album.albumId);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new song is inserted successfully!");
            } else {
                System.out.println("Genre already present");
            }
            insertArtistSong(song.artistList, song);
            insertGenreSong(song.genreList, song);
            System.out.println("Check insertSong");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void insertArtistSong(List<Artist> artistList, Song song) { // Private bnao iss fun. ko kunki kyu jrurt hai
        // kisi or ko
        // ise call krne ko, ye srf insertsong() fn k under s hi
        // call hoga
        System.out.println("In insertArtistSong function");
        String sql = "INSERT INTO artist_song (artistId, songId) VALUES (?, ?)";
        PreparedStatement statement;
        try {
            statement = conn.prepareStatement(sql);
            for (int index = 0; index <= artistList.size() - 1; index++) {
                statement.setInt(1, artistList.get(index).artistId);
                statement.setInt(2, song.songId);
                System.out.println("Artist id: " + artistList.get(index).artistId + " and song Id: " + song.songId);
                statement.addBatch();
            }

            int[] rowsInserted = statement.executeBatch();
            if (rowsInserted.length > 0) {
                System.out.println("A new data in artist_song table is inserted successfully!");
            } else {
                System.out.println("check in insertArtistSong");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void insertAlbum(Album album) {
        String sql = "INSERT INTO album (albumId, albumName) VALUES (?, ?)";
        PreparedStatement statement;
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, album.albumId);
            statement.setString(2, album.albumName);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new song is inserted successfully!");
            } else {
                System.out.println("Genre already present");
            }
            insertAlbumArtist(album.artistList, album);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void insertAlbumArtist(List<Artist> artistList, Album album) { // Private bnao iss fun. ko kunki kyu jrurt
                                                                           // hai
        // kisi or ko
        // ise call krne ko, ye srf insertsong() fn k under s hi
        // call hoga

        System.out.println("In insertAlbumArtist function");
        String sql = "INSERT INTO album_artist (albumId, artistId) VALUES (?, ?)";
        PreparedStatement statement;
        try {
            statement = conn.prepareStatement(sql);
            for (int artistindex = 0; artistindex <= artistList.size() - 1; artistindex++) {
                statement.setInt(1, album.albumId);
                statement.setInt(2, artistList.get(artistindex).artistId);
                System.out.println(
                        "Artist id: " + artistList.get(artistindex).artistId + " and album Id: " + album.albumId);
                statement.addBatch();
            }

            int[] rowsInserted = statement.executeBatch();
            if (rowsInserted.length > 0) {
                System.out.println("A new data in album_artist table is inserted successfully!");
            } else {
                System.out.println("check in insertAlbumArtist");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void insertGenreSong(List<Genre> genreList, Song song) {
        String sql = "INSERT INTO artist_song (genreName, songId) VALUES (?, ?)";
        PreparedStatement statement;
        try {
            statement = conn.prepareStatement(sql);
            for (int index = 0; index <= genreList.size() - 1; index++) {
                statement.setString(1, genreList.get(index).name());
                statement.setInt(2, song.songId);
                statement.addBatch();
            }

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new data in genre_song table is inserted successfully!");
            } else {
                System.out.println("check in insertGenreSong");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void insertPlayList(PlayList playList) {
        String sql = "INSERT INTO playList (playListId, playListName) VALUES (?, ?)";

        PreparedStatement statement;
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, playList.playListId);
            statement.setString(2, playList.playListName);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new play list is inserted successfully!");
            } else {
                System.out.println("Play list already present");
            }
            Helper helper = new Helper();

            // helper.homePage(albumList);
            // insertPlaylistSong(playList, playList.songList);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void insertPlaylistSong(int playListId, int songId) { // My logic- ye to tb tk call hoga jb tk user
                                                                 // song input dega playlist m insert krne k
                                                                 // lie
        String sql = "INSERT INTO palyList_song (playListId, songId) VALUES (?, ?)";
        PreparedStatement statement;
        try {
            statement = conn.prepareStatement(sql);
            // for (int index = 0; index <= song.size() - 1; index++) {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, playListId);
            statement.setInt(2, songId);
            // statement.addBatch();
            // }

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new data in playlist_song table is inserted successfully!");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public List<Album> getAlbumList() {
        String sql = "SELECT albumId, albumName FROM album";
        ResultSet rs = null;
        List<Album> album = new ArrayList<Album>();
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(sql); // Create a Statement object 1
            rs = statement.executeQuery(); // 2
            // Get the result table from the query
            // while (rs.next()) { // Position the cursor 3
            // int id = rs.getInt("albumId");
            // String name = rs.getString("albumName");
            // System.out.println(id + "\t\t" + name);
            // }

            while (rs.next()) {
                String name = rs.getString("albumName");
                int id = rs.getInt("albumId");
                // System.out.println("album name " + name);
                album.add(new Album(id, name));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return album;
    }

    public List<PlayList> getPlayListList() {
        String sql = "SELECT playListId, playListName FROM playList";
        ResultSet rs = null;
        List<PlayList> playList = new ArrayList<PlayList>();
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(sql); // Create a Statement object 1
            rs = statement.executeQuery(); // 2
            // Get the result table from the query
            // while (rs.next()) { // Position the cursor 3
            // int id = rs.getInt("albumId");
            // String name = rs.getString("albumName");
            // System.out.println(id + "\t\t" + name);
            // }

            while (rs.next()) {
                String name = rs.getString("playListName");
                int id = rs.getInt("playListId");
                // System.out.println("Playlist name " + name);
                playList.add(new PlayList(id, name));
            }
            // helper.homePage(albumList); //UNCOMMENT IT LATER CURRENTLY SHOWING ERRORS
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return playList;
    }

    public List<Song> getSongList(int albumIdx) {
        String sql = "SELECT * FROM song where albumId =" + albumIdx;
        ResultSet rs = null;
        List<Song> songList = new ArrayList<Song>();
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(sql); // Create a Statement object 1
            rs = statement.executeQuery(); // 2
            // Get the result table from the query
            // while (rs.next()) { // Position the cursor 3
            // int id = rs.getInt("albumId");
            // String name = rs.getString("albumName");
            // System.out.println(id + "\t\t" + name);
            // }

            while (rs.next()) {
                String name = rs.getString("songName");
                // System.out.println("song name " + name);
                // String sql2 = "SELECT songid FROM song where songName =" + name;
                // statement = conn.prepareStatement(sql2);
                int id = rs.getInt("songid");
                // int id = song.getSongId(new Song(name));
                songList.add(new Song(id, name));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return songList;
    }

    public List<Song> getSongListInPlayList(int playListIdx) {
        String sql = "SELECT * FROM palyList_song INNER JOIN song on palyList_song.songId = song.songId where palyList_song.playListId ="
                + playListIdx;
        // String sql = "SELECT * FROM palyList_song where playListId =" + playListIdx
        // + " INNER JOIN song on palyList_song.songId = song.songId"; // do inner join
        // or something also
        // to get the song name from song
        // table (currently getting songid
        // only)
        ResultSet rs = null;
        List<Song> songList = new ArrayList<Song>();
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(sql); // Create a Statement object 1
            rs = statement.executeQuery(); // 2
            // Get the result table from the query
            // while (rs.next()) { // Position the cursor 3
            // int id = rs.getInt("albumId");
            // String name = rs.getString("albumName");
            // System.out.println(id + "\t\t" + name);
            // }

            while (rs.next()) {
                int songId = rs.getInt("songId");
                String songName = rs.getString("songname");
                // System.out.println("song name " + name);
                // String sql2 = "SELECT songid FROM song where songName =" + name;
                // statement = conn.prepareStatement(sql2);
                // int d = rs.getInt("songid");
                // int id = song.getSongId(new Song(name));
                songList.add(new Song(songId, songName));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return songList;
    }

}