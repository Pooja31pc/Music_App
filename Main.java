import java.sql.Date;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Main {

        public static void main(String[] args) {
                DatabaseService databaseService = new DatabaseService();

                databaseService.insertGenre(Genre.Romantic);
                databaseService.insertGenre(Genre.Classic);
                databaseService.insertGenre(Genre.Jazz);
                databaseService.insertGenre(Genre.Pop);
                System.out.println("Genre Inserted Check");

                List<Album> albumList = new ArrayList<>();

                /**
                 * Album Number 1
                 */
                String str1 = "2014-03-31";
                Date date1 = Date.valueOf(str1);// converting string into sql date

                Artist albumArtistShankar = new Artist(201, "Shankar");
                Artist albumArtistEhsan = new Artist(202, "Ehsan");
                Artist albumArtistLoy = new Artist(203, "Loy");
                ArrayList<Artist> albumArtistList = new ArrayList<>();
                albumArtistList.add(albumArtistShankar);
                albumArtistList.add(albumArtistEhsan);
                albumArtistList.add(albumArtistLoy);

                databaseService.insertArtist(albumArtistShankar);
                databaseService.insertArtist(albumArtistEhsan);
                databaseService.insertArtist(albumArtistLoy);

                Album album = new Album(101, "2 States", date1, albumArtistList);
                databaseService.insertAlbum(album);

                /**
                 * 
                 */
                // Genre romanticGenre = new Genre(301, "Romantic");
                ArrayList<Genre> genreList1 = new ArrayList<>();
                genreList1.add(Genre.Romantic);

                /**
                 * 
                 */
                // Genre jazzGenre = new Genre(301, "Jazz");
                ArrayList<Genre> genreList2 = new ArrayList<>();
                genreList2.add(Genre.Jazz);

                /**
                 * 
                 */
                // Genre classicGenre = new Genre(301, "Classic");
                ArrayList<Genre> genreList3 = new ArrayList<>();
                genreList3.add(Genre.Classic);

                /**
                 * 
                 */
                Artist offoSongArtistAditi = new Artist(204, "Aditi Singh Sharma");
                Artist offoSongArtistAmitabh = new Artist(205, "Amitabh Bhattacharya");
                ArrayList<Artist> offoSongArtistList = new ArrayList<>();
                offoSongArtistList.add(offoSongArtistAditi);
                offoSongArtistList.add(offoSongArtistAmitabh);

                /**
                 * 
                 */
                Artist lochaSongArtistBenny = new Artist(206, "Benny Dayal");
                ArrayList<Artist> lochaSongArtistList = new ArrayList<>();
                lochaSongArtistList.add(lochaSongArtistBenny);

                /**
                 * 
                 */
                Artist maganSongArtistArijit = new Artist(207, "Arijit Singh");
                Artist maganSongArtistChinmayi = new Artist(208, "Chinmayi");
                ArrayList<Artist> maganSongArtistList = new ArrayList<>();
                maganSongArtistList.add(maganSongArtistArijit);
                maganSongArtistList.add(maganSongArtistChinmayi);

                /**
                 * 
                 */
                Artist iskiuskiSongArtistAkriti = new Artist(209, "Akriti Kakkar");
                Artist iskiuskiSongArtistShahid = new Artist(210, "Shahid Mallya");
                ArrayList<Artist> iskiuskiSongArtistList = new ArrayList<>();
                iskiuskiSongArtistList.add(iskiuskiSongArtistAkriti);
                iskiuskiSongArtistList.add(iskiuskiSongArtistShahid);

                /**
                 * 
                 */
                Artist chaandaniyaSongArtistMohan = new Artist(211, "Mohan Kannan");
                Artist chaandaniyaSongArtistYashita = new Artist(212, "Yashita Sharma");
                ArrayList<Artist> chaandaniyaSongArtistList = new ArrayList<>();
                chaandaniyaSongArtistList.add(chaandaniyaSongArtistMohan);
                chaandaniyaSongArtistList.add(chaandaniyaSongArtistYashita);

                /**
                 * 
                 */
                Artist hullareSongArtistShankar = new Artist(213, "Shankar Mahadevan");
                Artist hullareSongArtistSiddharth = new Artist(214, "Siddharth Mahadevan");
                Artist hullareSongArtistRasika = new Artist(215, "Rasika Shekhar");
                ArrayList<Artist> hullareSongArtistList = new ArrayList<>();
                hullareSongArtistList.add(hullareSongArtistShankar);
                hullareSongArtistList.add(hullareSongArtistSiddharth);
                hullareSongArtistList.add(hullareSongArtistRasika);

                databaseService.insertArtist(offoSongArtistAditi);
                databaseService.insertArtist(offoSongArtistAmitabh);
                databaseService.insertArtist(lochaSongArtistBenny);
                databaseService.insertArtist(maganSongArtistArijit);
                databaseService.insertArtist(maganSongArtistChinmayi);
                databaseService.insertArtist(iskiuskiSongArtistAkriti);
                databaseService.insertArtist(iskiuskiSongArtistShahid);
                databaseService.insertArtist(chaandaniyaSongArtistMohan);
                databaseService.insertArtist(chaandaniyaSongArtistYashita);
                databaseService.insertArtist(hullareSongArtistRasika);
                databaseService.insertArtist(hullareSongArtistShankar);
                databaseService.insertArtist(hullareSongArtistSiddharth);

                Song song1 = new Song(601, "Offo", Duration.ofMinutes(5).plusSeconds(5), offoSongArtistList,
                                genreList2, album);
                Song song2 = new Song(602, "Locha-E-Ulfat", Duration.ofMinutes(4).plusSeconds(3), lochaSongArtistList,
                                genreList2, album);
                Song song3 = new Song(603, "Mast Magan", Duration.ofMinutes(3).plusSeconds(6), maganSongArtistList,
                                genreList1, album);
                Song song4 = new Song(604, "Iski Uski", Duration.ofMinutes(4), iskiuskiSongArtistList, genreList2,
                                album);
                Song song5 = new Song(605, "Chnadaniya", Duration.ofMinutes(5), chaandaniyaSongArtistList, genreList3,
                                album);
                Song song6 = new Song(606, "Hulla Re", Duration.ofMinutes(2).plusSeconds(52), hullareSongArtistList,
                                genreList2, album);

                ArrayList<Song> songList = new ArrayList<>();
                songList.add(song1);
                songList.add(song2);
                songList.add(song3);
                songList.add(song4);
                songList.add(song5);
                songList.add(song6);

                // album.addSongs(songList);

                databaseService.insertSong(song1);
                databaseService.insertSong(song2);
                databaseService.insertSong(song3);
                databaseService.insertSong(song4);
                databaseService.insertSong(song5);
                databaseService.insertSong(song6);

                /**
                 * Album Number 2
                 */
                String str2 = "2011-03-31";
                Date date2 = Date.valueOf(str2);// converting string into sql date

                Artist albumArtistPritam = new Artist(216, "Pritam");
                Artist albumArtistTanishk = new Artist(217, "Tanishk Bagchi");
                ArrayList<Artist> bb2AlbumArtistList = new ArrayList<>();
                bb2AlbumArtistList.add(albumArtistPritam);
                bb2AlbumArtistList.add(albumArtistTanishk);

                Album bb2album = new Album(102, "Bhool Bhulaiya 2", date2, bb2AlbumArtistList);
                databaseService.insertAlbum(bb2album);

                Artist bb2TitleTrackSongArtistPritam = new Artist(218, "Pritam");
                Artist bb2TitleTrackSongArtistTanishk = new Artist(219, "Tanishk Bagchee");
                Artist bb2TitleTrackSongArtistNeeraj = new Artist(220, "Neeraj Shridhar");
                ArrayList<Artist> bb2TitleTrackSongArtistList = new ArrayList<>();
                bb2TitleTrackSongArtistList.add(bb2TitleTrackSongArtistPritam);
                bb2TitleTrackSongArtistList.add(bb2TitleTrackSongArtistTanishk);
                bb2TitleTrackSongArtistList.add(bb2TitleTrackSongArtistNeeraj);

                /**
                 * 
                 */
                Artist nasheSongArtistPritam = new Artist(221, "Pritam");
                Artist nasheSongArtistArijit = new Artist(222, "Arijit Singh");
                Artist nasheSongArtistTulsi = new Artist(223, "Tulsi Kumar");
                ArrayList<Artist> nasheSongArtistList = new ArrayList<>();
                nasheSongArtistList.add(nasheSongArtistPritam);
                nasheSongArtistList.add(nasheSongArtistArijit);
                nasheSongArtistList.add(nasheSongArtistTulsi);

                /**
                 * 
                 */
                Artist taaliSongArtistPritam = new Artist(224, "Pritam");
                Artist taaliSongArtistHoney = new Artist(225, "Yo Yo Honey Singh");
                Artist taaliSongArtistArmaan = new Artist(226, "rmaan Mallik");
                ArrayList<Artist> taaliSongArtistList = new ArrayList<>();
                taaliSongArtistList.add(taaliSongArtistPritam);
                taaliSongArtistList.add(taaliSongArtistHoney);
                taaliSongArtistList.add(taaliSongArtistArmaan);

                /**
                 * 
                 */
                Artist dholnaSongArtistPritam = new Artist(227, "Pritam");
                Artist dholnaSongArtistArijit = new Artist(228, "Arijit SIngh");
                ArrayList<Artist> dholnaSongArtistList = new ArrayList<>();
                dholnaSongArtistList.add(dholnaSongArtistPritam);
                dholnaSongArtistList.add(dholnaSongArtistArijit);

                databaseService.insertArtist(bb2TitleTrackSongArtistTanishk);
                databaseService.insertArtist(bb2TitleTrackSongArtistPritam);
                databaseService.insertArtist(bb2TitleTrackSongArtistNeeraj);
                databaseService.insertArtist(nasheSongArtistTulsi);
                databaseService.insertArtist(nasheSongArtistArijit);
                databaseService.insertArtist(nasheSongArtistPritam);
                databaseService.insertArtist(taaliSongArtistPritam);
                databaseService.insertArtist(taaliSongArtistHoney);
                databaseService.insertArtist(taaliSongArtistArmaan);
                databaseService.insertArtist(dholnaSongArtistPritam);
                databaseService.insertArtist(dholnaSongArtistArijit);

                Song bb2TitleTrackSong = new Song(607, "Bhool Bhulaiya 2 Title Track",
                                Duration.ofMinutes(5).plusSeconds(5),
                                bb2AlbumArtistList, genreList2, bb2album);
                Song nasheSong = new Song(608, "Hum Nashe Mein Toh Nahin", Duration.ofMinutes(4).plusSeconds(3),
                                nasheSongArtistList, genreList2, bb2album);
                Song taaliSong = new Song(609, "De Taali", Duration.ofMinutes(3).plusSeconds(6), taaliSongArtistList,
                                genreList1, bb2album);
                Song dholnaSong = new Song(610, "Mere Dholna", Duration.ofMinutes(4), dholnaSongArtistList, genreList2,
                                bb2album);
                Song tomarSong = new Song(611, "Ami Je Tomar", Duration.ofMinutes(5), dholnaSongArtistList, genreList3,
                                bb2album);
                // as dholna and tomar both have same set of singers

                ArrayList<Song> bb2SongList = new ArrayList<>();
                bb2SongList.add(bb2TitleTrackSong);
                bb2SongList.add(nasheSong);
                bb2SongList.add(taaliSong);
                bb2SongList.add(dholnaSong);
                bb2SongList.add(tomarSong);

                // bb2album.addSongs(bb2SongList);

                databaseService.insertSong(bb2TitleTrackSong);
                databaseService.insertSong(nasheSong);
                databaseService.insertSong(taaliSong);
                databaseService.insertSong(dholnaSong);
                databaseService.insertSong(tomarSong);

                // albumList.add(album);
                // albumList.add(bb2album);

                albumList = databaseService.getAlbumList();

                // create new function for this later
                Scanner sc = new Scanner(System.in);

                // System.out.print("1: Press 1 to Create Playlist ");
                Helper helpObj = new Helper(sc);
                helpObj.welcomePlayList();

                int entryIdx = sc.nextInt();

                if (entryIdx == 777) {
                        System.out.println("Logged In Successfully!!!");
                        helpObj.homePage(albumList);
                }
        }
}
