import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import org.json.*;
import java.io.BufferedReader;

public class Helper {
    DatabaseService databaseService = new DatabaseService();
    private Scanner sc;
    List<Album> albumList = new ArrayList<>();
    PlayList playList = new PlayList();
    HashMap<String, Integer> playListListMap = new HashMap<>();
    HashMap<Integer, String> songMap = new HashMap<>();
    List<PlayList> playListList = new ArrayList<>();
    List<Song> songList = new ArrayList<>();

    public Helper(Scanner sc) {
        this.sc = sc;
        mapping();
    }

    public Helper() {
    }

    public void mapping() {

        // for playList list mapping.
        playListList = databaseService.getPlayListList();
        for (int i = 0; i < playListList.size(); i++) {
            playListListMap.put(playListList.get(i).getPlayListName(), playListList.get(i).getPlayListId());
        }
        System.out.println("Check Map");
        System.out.println(playListListMap);

        // for songList mapping. - Do it later.
    }

    public void showAlbum(List<Album> albumList, String userPlayListNameInput) {

        // databaseService.getPlayListList();

        // check playlist is present in DB or not if not then add
        // if() {
        // playList.setPlayListName(userPlayListNameInput);
        // databaseService.insertPlayList(playList);
        // }

        for (int i = 0; i < albumList.size(); i++) {
            System.out.println(i + 1 + ". " + albumList.get(i));
        }
        System.out.println("Enter 100 to EXIT: ");
        System.out.println("Enter 111 to go to Home Page: ");
        int userInputSelectAlbum = sc.nextInt();
        if (userInputSelectAlbum == 100) {
            exitPlayList();
        } else if (userInputSelectAlbum == 111) {
            homePage(albumList);
        } else {
            showSongListSelectedAlbum(albumList, userInputSelectAlbum, userPlayListNameInput);
        }
    }

    public void showSongListSelectedAlbum(List<Album> albumList, int albumIndex, String userPlayListNameInput) {
        // List<Song> list = albumList.get(albumIndex - 1).getSongList();//
        // getSOngsOfAlbum naam ka fn bnao service m -
        // returns songList
        // System.out.println(albumList.get(albumIndex - 1) + "Album id: " +
        // albumList.get(albumIndex - 1).getAlbumId());
        songList = databaseService.getSongList(albumList.get(albumIndex - 1).getAlbumId());

        // Mapping song list.
        for (int i = 0; i < songList.size(); i++) {
            songMap.put(songList.get(i).getSongId(), songList.get(i).getSongName());
        }
        System.out.println("Check Map");
        System.out.println(songMap);

        // int idx = 0;
        // for (Song song : songList) {
        // System.out.println(idx + 1 + ". " + song);
        // idx++;
        // }

        int idx = 0;
        for (Song song : songList) {
            System.out.println(song);
            idx++;
        }

        System.out.println("Enter 111 to go to Home Page: ");
        System.out.println("Enter 100 to EXIT: ");
        System.out.println("Enter 101 to Return to album list: ");
        // System.out.println("Enter 1001 to add songs to PlayList: ");
        int userInputSelectSongs = sc.nextInt();

        if (userInputSelectSongs == 111) {
            homePage(albumList);
        } else if (userInputSelectSongs == 100) {
            exitPlayList();
        } else if (userInputSelectSongs == 101) {
            showAlbum(albumList, userPlayListNameInput);
        } else { // if (userInputSelectSongs == 1001)
            System.out.println("Enter the song name:");
            System.out.println();
            // String userSelectedSongName = "";
            // while (userSelectedSongName != "Exit") {
            // userSelectedSongName = sc.next();
            mapping();
            int selectedPlayListId = playListListMap.get(userPlayListNameInput);
            String selectedSongId = songMap.get(userInputSelectSongs);
            databaseService.insertPlaylistSong(selectedPlayListId, userInputSelectSongs);
            showSongListSelectedAlbum(albumList, albumIndex, userPlayListNameInput);
            // }
            // addSongtoPlayList(list, userInputSelectSongs, albumList, albumIndex,
            // userPlayListNameInput);
        }
    }

    public void addSongtoPlayList(List<Song> list, int songIndex, List<Album> albumList, int albumIndex,
            String userPlayListNameInput) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            // Create new file
            // int s = -1;
            // while (s != 3) {
            // s = sc.nextInt();
            PlayList playList = new PlayList();
            playList.setPlayListName(userPlayListNameInput);
            databaseService.insertPlayList(playList);

            playList.addSong(list.get(songIndex - 1));

            // }

            // String path = "E:\\Pooja_Project_Dump\\PlayList.txt";
            String path = "/home/poojachouhary/POOJA_Project_Practice/Play_List_Folder\\" + userPlayListNameInput;
            File file = new File(path);

            // If file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);

            JSONObject playListObj = new JSONObject(playList);
            System.out.println(playListObj);
            bw.write(playListObj.toString() + "\n");

            // List<Song> pList = playList.getSongList();

            // for (Song song : pList) {
            // System.out.println(song);
            // // Write in file
            // bw.write(song.toString() + "\n");
            // }

            // Close connection
            bw.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        showSongListSelectedAlbum(albumList, albumIndex, userPlayListNameInput);

        // addSongtoPlayList(list, songIndexAddList);
    }

    public void exitPlayList() {
        System.out.println("Exited the playlist, come again!!!");
    }

    public void welcomePlayList() { // name it passwordCheck
        System.out.println("Welcome to the playlist!!!");
        System.out.print("Press 777 to login to Playlist ");
    }

    public void getFilenNames(String folderDirectory) {
        File folder = new File(folderDirectory);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
            }
        }
    }

    public void homePage(List<Album> albumList) {
        System.out.println("Press 0 to load existing Playlist List");
        System.out.println("Press 100 to Exit!");
        int userInput = sc.nextInt();
        String userPlayListNameInput;
        List<PlayList> playListList = new ArrayList<>();

        if (userInput == 100) {
            exitPlayList();
            return;
        } else if (userInput == 0) { // yaha p existing playlist fetch kr rhe
            printPlayListList();
            // loadExistingPlayList(userPlayListNameInput);
        }

        System.out.println();
        System.out.println("Press 0 to create new playlist : ");
        System.out.println("Press 1 to add song or check present songs in existing playlist ");

        userInput = sc.nextInt();

        if (userInput == 0) {
            System.out.println();
            System.out.println("Enter the Playlist name: ");
            String userPlayListName = sc.next();
            playList.setPlayListName(userPlayListName);
            databaseService.insertPlayList(playList);
            printPlayListList();
            System.out.println("Enter the name of the Playlist: ");
            userPlayListNameInput = sc.next();
            showAlbum(albumList, userPlayListNameInput);
        } else if (userInput == 1) {
            System.out.println();
            printPlayListList();
            System.out.println("Enter the name of the Playlist: ");
            System.out.println();
            userPlayListNameInput = sc.next();
            System.out.println();
            System.out.println(
                    "You selected " + userPlayListNameInput
                            + " playlist.");
            System.out.println();

            // System.out.println(playListListMap);
            int selectedPlayListIdIp = playListListMap.get(userPlayListNameInput);
            showSongsPresentInSelectedPlayList(selectedPlayListIdIp);
            System.out.println();
            System.out.println("Available album list: ");
            System.out.println();
            showAlbum(albumList, userPlayListNameInput);
        }

        // show all the available palylist name - give this as options. Also handle when
        // there is no playlist file present
        // System.out.println("Choose Playlist: ");
        // databaseService.getPlayListList();
        // getFilenNames("/home/poojachouhary/POOJA_Project_Practice/Play_List_Folder");
        // // yaha p ab data playlist list ka
        // DB s lana hoga

        if (userInput == 1) { // yaha p playlist ka naam pass kr rhe - is m jaa kr check kro k playlist exist
                              // krta hai k ni agr krta hai then select that playlist add songs otherwise add
                              // playlist first then start adding songs
            // showAlbum(albumList, userPlayListNameInput);
        }
    }

    public void printPlayListList() {
        playListList = databaseService.getPlayListList();
        if (playListList.size() == 0) {
            System.out.println();
            System.out.println("No PlayList present, Please create one!!!");
            System.out.println();
        } else {
            for (int i = 0; i < playListList.size(); i++) {
                System.out.println(playListList.get(i));
            }
        }
    }

    public void loadExistingPlayList(String playListName) {
        BufferedReader br = null;

        try {
            String sCurrentLine;
            br = new BufferedReader(
                    new FileReader("/home/poojachouhary/POOJA_Project_Practice/Play_List_Folder/" + playListName));

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }
            homePage(albumList);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void showSongsPresentInSelectedPlayList(int playListIdx) {
        List<Song> songListAvailable = databaseService.getSongListInPlayList(playListIdx);
        if (songListAvailable.size() > 0) {
            System.out.println("Below are the songs already present in this playlist!!!");
            for (Song song : songListAvailable) {
                System.out.println(song);
            }
        } else {
            System.out.println("No songs available in this playlis. Waiting!!!");
        }
    }

}

// public void homePage(List<Album> albumList) {
// System.out.println("Press 1 to create playlist or to add song to existing
// playlist ");
// System.out.println("Press 0 to load existing playlist ");
// System.out.println("Press 100 to Exit!");
// int userInput = sc.nextInt();

// if (userInput == 100) {
// exitPlayList();
// return;
// }

// // show all the available palylist name - give this as options. Also handle
// when
// // there is no playlist file present
// System.out.println("Choose Playlist: ");
// databaseService.getPlayListList();
// //
// getFilenNames("/home/poojachouhary/POOJA_Project_Practice/Play_List_Folder");
// // // yaha p ab data playlist list ka
// // DB s lana hoga

// // databaseService.getPlayListList();

// // System.out.println("Enter PlayList name: ");
// String userPlayListNameInput = sc.next();

// if (userInput == 1) { // yaha p playlist ka naam pass kr rhe - is m jaa kr
// check kro k playlist exist
// // krta hai k ni agr krta hai then select that playlist add songs otherwise
// add
// // playlist first then start adding songs
// showAlbum(albumList, userPlayListNameInput);
// } else if (userInput == 0) { // yaha p existing playlist fetch kr rhe
// databaseService.getPlayListList();
// loadExistingPlayList(userPlayListNameInput);
// }
// }
