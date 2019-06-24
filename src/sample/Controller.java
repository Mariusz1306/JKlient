package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class Controller {
    @FXML private ListView filesListView;
    @FXML private Button sendButton;
    @FXML private ComboBox listOfUsers;
    @FXML private Label currentActionLabel;
    private static String path;
    private static ArrayList<String> listOfFiles = new ArrayList<>();

    @FXML
    public  void initialize(){
        currentActionLabel.setText("test");
        listOfUsers.getItems().addAll("TEST1", "TEST2", "TEST3");
        getListOfFiles();
        filesListView.getItems().addAll(listOfFiles);
    }

    @FXML
    public void onSendButtonClicked(){
        System.out.println(filesListView.getSelectionModel().getSelectedItems());
        String selectedUser = listOfUsers.getValue().toString();
        currentActionLabel.setText(selectedUser);
    }

    public void getListOfFiles(){
        File folder = new File("C:\\Users\\Marius\\Desktop\\Justii");
        File[] listofFilesAndDirectoried = folder.listFiles();

        for (int i = 0; i < listofFilesAndDirectoried.length; i++)
            if (listofFilesAndDirectoried[i].isFile())
                listOfFiles.add(listofFilesAndDirectoried[i].getName());
    }

    public static String getPath() {
        return path;
    }

    public static void setPath(String path) {
        Controller.path = path;
    }
}
