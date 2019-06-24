package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.File;

public class Controller {
    @FXML private ListView listListView;
    @FXML private Button sendButton;
    @FXML private ComboBox listOfUsers;
    @FXML private Label currentActionLabel;
    private static String path;
    private static File[] listOfFiles;

    @FXML
    public  void initialize(){
        currentActionLabel.setText("test");
        listOfUsers.getItems().addAll("TEST1", "TEST2", "TEST3");
        getListOfFiles();
        listListView.getItems().addAll(listOfFiles);
    }

    @FXML
    public void onSendButtonClicked(){
        String selectedUser = listOfUsers.getValue().toString();
        currentActionLabel.setText(selectedUser);
    }

    public void getListOfFiles(){
        File folder = new File("C:/");
        listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
    }

    public static String getPath() {
        return path;
    }

    public static void setPath(String path) {
        Controller.path = path;
    }
}
