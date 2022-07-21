import java.sql.Date;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
                System.out.println("HELLO!!!");

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

                Album album = new Album(101, "2 States", date1, albumArtistList);

                /**
                 * 
                 */
                Genre romanticGenre = new Genre(301, "Romantic");
                ArrayList<Genre> genreList1 = new ArrayList<>();
                genreList1.add(romanticGenre);

                /**
                 * 
                 */
                Genre jazzGenre = new Genre(301, "Jazz");
                ArrayList<Genre> genreList2 = new ArrayList<>();
                genreList2.add(jazzGenre);

                /**
                 * 
                 */
                Genre classicGenre = new Genre(301, "Classic");
                ArrayList<Genre> genreList3 = new ArrayList<>();
                genreList3.add(classicGenre);

                /**
                 * 
                 */
                Artist offoSongArtistAditi = new Artist(201, "Aditi Singh Sharma");
                Artist offoSongArtistAmitabh = new Artist(202, "Amitabh Bhattacharya");
                ArrayList<Artist> offoSongArtistList = new ArrayList<>();
                offoSongArtistList.add(offoSongArtistAditi);
                offoSongArtistList.add(offoSongArtistAmitabh);

                /**
                 * 
                 */
                Artist lochaSongArtistBenny = new Artist(201, "Benny Dayal");
                ArrayList<Artist> lochaSongArtistList = new ArrayList<>();
                lochaSongArtistList.add(lochaSongArtistBenny);

                /**
                 * 
                 */
                Artist maganSongArtistArijit = new Artist(201, "Arijit Singh");
                Artist maganSongArtistChinmayi = new Artist(202, "Chinmayi");
                ArrayList<Artist> maganSongArtistList = new ArrayList<>();
                maganSongArtistList.add(maganSongArtistArijit);
                maganSongArtistList.add(maganSongArtistChinmayi);

                /**
                 * 
                 */
                Artist iskiuskiSongArtistAkriti = new Artist(201, "Akriti Kakkar");
                Artist iskiuskiSongArtistShahid = new Artist(202, "Shahid Mallya");
                ArrayList<Artist> iskiuskiSongArtistList = new ArrayList<>();
                iskiuskiSongArtistList.add(iskiuskiSongArtistAkriti);
                iskiuskiSongArtistList.add(iskiuskiSongArtistShahid);

                /**
                 * 
                 */
                Artist chaandaniyaSongArtistMohan = new Artist(201, "Mohan Kannan");
                Artist chaandaniyaSongArtistYashita = new Artist(202, "Yashita Sharma");
                ArrayList<Artist> chaandaniyaSongArtistList = new ArrayList<>();
                chaandaniyaSongArtistList.add(chaandaniyaSongArtistMohan);
                chaandaniyaSongArtistList.add(chaandaniyaSongArtistYashita);

                /**
                 * 
                 */
                Artist hullareSongArtistShankar = new Artist(201, "Shankar Mahadevan");
                Artist hullareSongArtistSiddharth = new Artist(202, "Siddharth Mahadevan");
                Artist hullareSongArtistRasika = new Artist(202, "Rasika Shekhar");
                ArrayList<Artist> hullareSongArtistList = new ArrayList<>();
                hullareSongArtistList.add(hullareSongArtistShankar);
                hullareSongArtistList.add(hullareSongArtistSiddharth);
                hullareSongArtistList.add(hullareSongArtistRasika);

                Song song1 = new Song(601, "Offo", Duration.ofMinutes(5).plusSeconds(5), offoSongArtistList,
                                genreList2);
                Song song2 = new Song(601, "Locha-E-Ulfat", Duration.ofMinutes(4).plusSeconds(3), lochaSongArtistList,
                                genreList2);
                Song song3 = new Song(601, "Mast Magan", Duration.ofMinutes(3).plusSeconds(6), maganSongArtistList,
                                genreList1);
                Song song4 = new Song(601, "Iski Uski", Duration.ofMinutes(4), iskiuskiSongArtistList, genreList2);
                Song song5 = new Song(601, "Chnadaniya", Duration.ofMinutes(5), chaandaniyaSongArtistList, genreList3);
                Song song6 = new Song(601, "Hulla Re", Duration.ofMinutes(2).plusSeconds(52), hullareSongArtistList,
                                genreList2);

                ArrayList<Song> songList = new ArrayList<>();
                songList.add(song1);
                songList.add(song2);
                songList.add(song3);
                songList.add(song4);
                songList.add(song5);
                songList.add(song6);

                album.addSongs(songList);

                /**
                 * Album Number 2
                 */
                String str2 = "2011-03-31";
                Date date2 = Date.valueOf(str2);// converting string into sql date

                Artist albumArtistPritam = new Artist(201, "Pritam");
                Artist albumArtistTanishk = new Artist(202, "Tanishk Bagchi");
                ArrayList<Artist> bb2AlbumArtistList = new ArrayList<>();
                bb2AlbumArtistList.add(albumArtistPritam);
                bb2AlbumArtistList.add(albumArtistTanishk);

                Album bb2album = new Album(102, "Bhool Bhulaiya 2", date2, bb2AlbumArtistList);

                /**
                 * 
                 */
                // Genre romanticGenre = new Genre(301, "Romantic");
                // ArrayList<Genre> genreList1 = new ArrayList<>();
                // genreList1.add(romanticGenre);

                /**
                 * 
                 */
                // Genre jazzGenre = new Genre(301, "Jazz");
                // ArrayList<Genre> genreList2 = new ArrayList<>();
                // genreList2.add(jazzGenre);

                /**
                 * 
                 */
                // Genre classicGenre = new Genre(301, "Classic");
                // ArrayList<Genre> genreList3 = new ArrayList<>();
                // genreList3.add(classicGenre);

                /**
                 * 
                 */
                Artist bb2TitleTrackSongArtistPritam = new Artist(201, "Pritam");
                Artist bb2TitleTrackSongArtistTanishk = new Artist(202, "Tanishk Bagchee");
                Artist bb2TitleTrackSongArtistNeeraj = new Artist(202, "Neeraj Shridhar");
                ArrayList<Artist> bb2TitleTrackSongArtistList = new ArrayList<>();
                bb2TitleTrackSongArtistList.add(bb2TitleTrackSongArtistPritam);
                bb2TitleTrackSongArtistList.add(bb2TitleTrackSongArtistTanishk);
                bb2TitleTrackSongArtistList.add(bb2TitleTrackSongArtistNeeraj);

                /**
                 * 
                 */
                Artist nasheSongArtistPritam = new Artist(201, "Pritam");
                Artist nasheSongArtistArijit = new Artist(201, "Arijit Singh");
                Artist nasheSongArtistTulsi = new Artist(201, "Tulsi Kumar");
                ArrayList<Artist> nasheSongArtistList = new ArrayList<>();
                nasheSongArtistList.add(nasheSongArtistPritam);
                nasheSongArtistList.add(nasheSongArtistArijit);
                nasheSongArtistList.add(nasheSongArtistTulsi);

                /**
                 * 
                 */
                Artist taaliSongArtistPritam = new Artist(201, "Pritam");
                Artist taaliSongArtistHoney = new Artist(202, "Yo Yo Honey Singh");
                Artist taaliSongArtistArmaan = new Artist(202, "rmaan Mallik");
                ArrayList<Artist> taaliSongArtistList = new ArrayList<>();
                taaliSongArtistList.add(taaliSongArtistPritam);
                taaliSongArtistList.add(taaliSongArtistHoney);
                taaliSongArtistList.add(taaliSongArtistArmaan);

                /**
                 * 
                 */
                Artist dholnaSongArtistPritam = new Artist(201, "Pritam");
                Artist dholnaSongArtistArijit = new Artist(202, "Arijit SIngh");
                ArrayList<Artist> dholnaSongArtistList = new ArrayList<>();
                dholnaSongArtistList.add(dholnaSongArtistPritam);
                dholnaSongArtistList.add(dholnaSongArtistArijit);

                /**
                 * 
                 */
                // Artist tomarSongArtistPritam = new Artist(201,"Pritam");
                // Artist tomarSongArtistArijit = new Artist(202,"Arijit Singh");
                // ArrayList<Artist> tomarSongArtistList = new ArrayList<>();
                // tomarSongArtistList.add(tomarSongArtistPritam);
                // tomarSongArtistList.add(tomarSongArtistArijit);

                Song bb2TitleTrackSong = new Song(601, "Bhool Bhulaiya 2 Title Track",
                                Duration.ofMinutes(5).plusSeconds(5),
                                bb2AlbumArtistList, genreList2);
                Song nasheSong = new Song(601, "Hum Nashe Mein Toh Nahin", Duration.ofMinutes(4).plusSeconds(3),
                                nasheSongArtistList, genreList2);
                Song taaliSong = new Song(601, "De Taali", Duration.ofMinutes(3).plusSeconds(6), taaliSongArtistList,
                                genreList1);
                Song dholnaSong = new Song(601, "Mere Dholna", Duration.ofMinutes(4), dholnaSongArtistList, genreList2);
                Song tomarSong = new Song(601, "Ami Je Tomar", Duration.ofMinutes(5), dholnaSongArtistList, genreList3);
                // as dholna and tomar both have same set of singers

                ArrayList<Song> bb2SongList = new ArrayList<>();
                bb2SongList.add(bb2TitleTrackSong);
                bb2SongList.add(nasheSong);
                bb2SongList.add(taaliSong);
                bb2SongList.add(dholnaSong);
                bb2SongList.add(tomarSong);

                bb2album.addSongs(bb2SongList);

                albumList.add(album);
                albumList.add(bb2album);

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
