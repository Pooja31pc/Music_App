import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.json.*;
import java.io.BufferedReader;

public class Helper {
    private Scanner sc;
    List<Album> albumList = new ArrayList<>();

    public Helper(Scanner sc) {
        this.sc = sc;
    }

    public Helper() {
    }

    public void showAlbum(List<Album> albumList, String userPlayListNameInput) {
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
        List<Song> list = albumList.get(albumIndex - 1).getSongList();
        int idx = 0;
        for (Song song : list) {
            System.out.println(idx + 1 + ". " + song);
            idx++;
        }
        System.out.println("Enter 111 to go to Home Page: ");
        System.out.println("Enter 100 to EXIT: ");
        System.out.println("Enter 101 to Return to album loist: ");
        int userInputSelectSongs = sc.nextInt();

        if (userInputSelectSongs == 111) {
            homePage(albumList);
        } else if (userInputSelectSongs == 100) {
            exitPlayList();
        } else if (userInputSelectSongs == 101) {
            showAlbum(albumList, userPlayListNameInput);
        } else {
            addSongtoPlayList(list, userInputSelectSongs, albumList, albumIndex, userPlayListNameInput);
        }
    }

    public void addSongtoPlayList(List<Song> list, int songIndex, List<Album> albumList, int albumIndex,
            String userPlayListNameInput) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            // Create new file
            // int s = -1;
            PlayList playList = new PlayList();
            // while (s != 3) {
            // s = sc.nextInt();
            playList.setPlayListName(userPlayListNameInput);
            playList.addSong(list.get(songIndex - 1));
            // }

            // String path = "E:\\Pooja_Project_Dump\\PlayList.txt";
            String path = "E:\\Pooja_Project_Dump\\" + userPlayListNameInput;
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
        System.out.println("Press 1 to create playlist or to add song to existing playlist ");
        System.out.println("Press 0 to load existing playlist ");
        System.out.println("Press 100 to Exit!");
        int userInput = sc.nextInt();

        if (userInput == 100) {
            exitPlayList();
            return;
        }

        // show all the available palylist name - give this as options
        System.out.println("Choose Playlist: ");
        getFilenNames("E:\\Pooja_Project_Dump\\");
        // System.out.println("Enter PlayList name: ");
        String userPlayListNameInput = sc.next();

        if (userInput == 1) {
            showAlbum(albumList, userPlayListNameInput);
        } else if (userInput == 0) {
            loadExistingPlayList(userPlayListNameInput);
        }
    }

    public void loadExistingPlayList(String playLisytName) {
        BufferedReader br = null;

        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader("E:\\Pooja_Project_Dump\\" + playLisytName));

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
}
