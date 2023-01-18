package logic;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
import logic.factory.BaseObject;
import logic.model.Sticker;
import logic.model.Card;
import logic.viewachievements.ViewAchievementsController;
import logic.viewachievements.ViewAchievementsListBean;
import logic.viewcard.ViewCardController;
import logic.viewcard.ViewCardUserBean;
import logic.viewstickers.ViewStickersController;
import logic.viewstickers.ViewStickersListBean;
import logic.viewtasks.ViewTasksController;
import logic.viewtasks.ViewTasksListBean;

import java.sql.SQLException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private static List<BaseObject> achList;
    private static List<BaseObject> tskList;
    private static List<Sticker> stkList;

    private static Card card;


    //-----------------------------------------BUTTONS
    @FXML
    private Button achievement1;
    @FXML
    private Button achievement2;
    @FXML
    private Button achievement3;
    @FXML
    private Button achievement4;
    @FXML
    private Button achievement5;
    @FXML
    private Button achievement6;

    @FXML
    private Button achievement7;
    @FXML
    private Button achievement8;
    @FXML
    private Button achievement9;
    @FXML
    private Button achievement10;
    @FXML
    private Button achievement11;

    @FXML
    private Button dailyTask1;
    @FXML
    private Button dailyTask2;
    @FXML
    private Button dailyTask3;
    @FXML
    private Button dailyTask4;
    @FXML
    private Button weeklyTask1;
    @FXML
    private Button weeklyTask2;

    //setText,setColo,setStyle,completeAchiementTry

    //-----------------------------------------LABELS
    @FXML
    private Label usernameLabel;

    @FXML
    private Label levelLabel;

    @FXML
    private Label experienceLabel;

    @FXML
    private Label completeTaskRewardLabel;

    @FXML
    private Label completeAchievementRewardLabel;

    //---------------------------------------IMAGE VIEWS
    @FXML
    private ImageView cardView;

    @FXML
    private ImageView profilePic;

    @FXML
    private ImageView slot1;

    @FXML
    private ImageView slot2;

    @FXML
    private ImageView slot3;

    @FXML
    private ImageView slot4;

    @FXML
    private ImageView slot5;

    @FXML
    private ImageView slot6;

    @FXML
    private ImageView slot7;

    @FXML
    private ImageView slot8;
    @FXML
    private List<ImageView> slotImage = new ArrayList<>() {{add(slot1); add(slot2); add(slot3); add(slot4); add(slot4); add(slot5); add(slot6); add(slot7); add(slot8); }};

    //---------------------------------------LIST VIEWS
    @FXML
    private ListView<String> availableStickersListView;


    @FXML
    private ListView<String> slotsListView;
    String[] slots = {"Slot1", "Slot2", "Slot3", "Slot4", "Slot5", "Slot6", "Slot7", "Slot8", "Remove all stickers"};
    String currentSlots;

    String mySticker;
    String mySlot;

    @FXML
    private ListView<String> achListView;

    //---------------------------------------TEXT FIELDS
    @FXML
    private TextField usernameTextField;

    //---------------------------------------DIALOG PANES

    @FXML
    private DialogPane achievementLoadingDialogPane;
    @FXML
    private DialogPane startingMessageDialogPane;
    @FXML
    private DialogPane logoutDialogPane;

    @FXML
    private DialogPane askMoteeveDialogPane;

    @FXML
    private DialogPane changeUsernameDialogPane;

    @FXML
    private DialogPane completeTaskDialogPane;

    @FXML
    private DialogPane completeAchievementDialogPane;

    @FXML
    private DialogPane customizeProfileDialogPane;

    @FXML
    private DialogPane selectStickerDialogPane;

    @FXML
    private DialogPane selectSlotDialogPane;

    //------------------------------------------------------STARTING SETUP
    public static void setUp() throws Exception {
        setAchievementLIst();
        setTaskList();
        setStickerList();
        setCard();
    }
    private static void setAchievementLIst() throws Exception {
        ViewAchievementsController controller = new ViewAchievementsController();
        ViewAchievementsListBean bean = controller.createAchList();
        achList = bean.getBean();
    }
    private static void setTaskList() throws Exception {
        ViewTasksController controller = new ViewTasksController();
        ViewTasksListBean bean = controller.createTskList();
        tskList = bean.getBean();
    }

    private static void setStickerList() throws Exception {
        ViewStickersController controller = new ViewStickersController();
        ViewStickersListBean bean = controller.createStkList();
        stkList = bean.getBean();
    }
    private static void setCard() throws Exception {
        //bisogna modificare tutta la classe e tutto il model per fare la card, metti tutti gli otto sticker dellla card di base "empty"
           ViewCardController controller = new ViewCardController();
           ViewCardUserBean bean = controller.createCard();
           card = bean.getBean();
    }



    //-----------------------------------------------------MANAGEMENT
    public void setAllDialogPanesInvisible() {

        logoutDialogPane.setVisible(false);
        askMoteeveDialogPane.setVisible(false);
        changeUsernameDialogPane.setVisible(false);
        customizeProfileDialogPane.setVisible(false);
        selectStickerDialogPane.setVisible(false);
        selectSlotDialogPane.setVisible(false);

    }

    //-----------------------------------------------------STAGE SWITCH
    @FXML
    public void switchToProfileScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("profileScene.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToMainScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("mainScene.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToAchievementScene(ActionEvent event) throws IOException, InterruptedException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("achievementScene.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void putOffStartingMessage(){
        usernameLabel.setText(card.getUserName());
        experienceLabel.setText(String.valueOf(card.getExp()));
        levelLabel.setText(String.valueOf(card.getLevel()));

       int i = 1 ;
        for (Sticker stk: card.getSlots()) {
                if(stk.getName().equals("Vuoto")) {
            }else{
                applicateStickerToSlot("Slot" + i,stk.getStickerUrl());
            }
                i= i+1;
        }
        startingMessageDialogPane.setVisible(false);
    }

    @FXML
    public void refreshAchievementPage(){
        System.out.println("gay");
    }

    @FXML
    public void refreshTaskPage() {
        String message = "NESSUNA TASK PRESENTE, CHIEDI A MOTEEVE DI DARTENE UNA NUOVA!";

        //------DAILY TASK1-------
        if (tskList.get(0).getScript().equals("Completato")){
            dailyTask1.setText(message);
        } else {
            dailyTask1.setText(tskList.get(0).getScript());
            dailyTask1.setStyle("-fx-background-color: " + tskList.get(0).getColor());
        }

        //------DAILY TASK2-------
        if (tskList.get(1).getScript().equals("Completato")){
            dailyTask1.setText(message);
        } else {
            dailyTask2.setText(tskList.get(1).getScript());
            dailyTask2.setStyle("-fx-background-color: " + tskList.get(1).getColor());
        }

        //------DAILY TASK3-------
        if (tskList.get(2).getScript().equals("Completato")){
            dailyTask1.setText(message);
        } else {
            dailyTask3.setText(tskList.get(2).getScript());
            dailyTask3.setStyle("-fx-background-color: " + tskList.get(2).getColor());
        }

        //------DAILY TASK4-------
        if (tskList.get(3).getScript().equals("Completato")){
            dailyTask1.setText(message);
        } else {
            dailyTask4.setText(tskList.get(3).getScript());
            dailyTask4.setStyle("-fx-background-color: " + tskList.get(3).getColor());
        }
        //------WEEKLY TASK1------
        if (tskList.get(4).getScript().equals("Completato")){
            dailyTask1.setText(message);
        } else {
            weeklyTask1.setText(tskList.get(4).getScript());
            weeklyTask1.setStyle("-fx-background-color: " + tskList.get(4).getColor());
        }

        //------WEEKLY TASK2-------
        if (tskList.get(5).getScript().equals("Completato")){
            dailyTask1.setText(message);
        } else {
            weeklyTask2.setText(tskList.get(5).getScript());
            weeklyTask2.setStyle("-fx-background-color: " + tskList.get(5).getColor());
        }

    }
    //-------------------------------------------------CHANGE USERNAME
    @FXML
    public void changeUsernameTry() {
        setAllDialogPanesInvisible();
        changeUsernameDialogPane.setVisible(true);
    }

    @FXML
    public void changeUsernameFail() {
        changeUsernameDialogPane.setVisible(false);
    }

    @FXML
    public void changeUsernameSuccess() throws SQLException {
        String username = usernameTextField.getText();
        //qui una volta c era il caso d uso di federico RIP
        changeUsernameDialogPane.setVisible(false);
    }

    //-----------------------------------------------------ASK MOTEEVE
    @FXML
    public void askMoteeveTry() {
        setAllDialogPanesInvisible();
        askMoteeveDialogPane.setVisible(true);
    }

    @FXML
    public void askMoteeveSuccess() {
        askMoteeveDialogPane.setVisible(false);
    }

    //------------------------------------------------------LOGOUT
    @FXML
    public void logoutTry() {
        setAllDialogPanesInvisible();
        logoutDialogPane.setVisible(true);
    }

    @FXML
    public void logoutFail() {
        logoutDialogPane.setVisible(false);
    }

    @FXML
    public void logoutSuccess() {
        System.exit(0);
    }

    //------------------------------------------------------COMPLETE TASK
    @FXML
    public void completeDailyTaskTry() {
        completeTaskDialogPane.setVisible(true);
        completeTaskRewardLabel.setText("Rewards: 100 experience points");
    }

    @FXML
    public void completeWeeklyTaskTry() {
        completeTaskDialogPane.setVisible(true);
        completeTaskRewardLabel.setText("Rewards: 500 experience points");
    }

    @FXML
    public void completeTaskFail() {
        completeTaskDialogPane.setVisible(false);
    }

    @FXML
    public void completeTaskSuccess() throws SQLException {
        completeTaskDialogPane.setVisible(false);
    }

    //-----------------------------------------------------COMPLETE ACHIEVEMENTS
    @FXML
    public void completeAchievementTry() {
        completeAchievementDialogPane.setVisible(true);
        completeAchievementRewardLabel.setText("Rewards: " + "INFO FROM DB");
    }

    @FXML
    public void completeAchievementFail() {
        completeAchievementDialogPane.setVisible(false);
    }

    @FXML
    public void completeAchievementSuccess() {
        System.out.println("TBD");
        completeAchievementDialogPane.setVisible(false);
    }

    //------------------------------------------------CUSTOMIZE PROFILE
    @FXML
    public void customizeProfileTry() {
        setAllDialogPanesInvisible();
        customizeProfileDialogPane.setVisible(true);
    }

    @FXML
    public void customizeProfileFail() {
        customizeProfileDialogPane.setVisible(false);
    }

    @FXML
    public void changeProfilePic() {

        //FILE SELECTION
        FileChooser chooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter1 = new FileChooser.ExtensionFilter("Images", "*.png");
        chooser.setTitle("Select new profile pic (must be png format)");
        chooser.getExtensionFilters().addAll(extFilter1);
        File selectedFile = chooser.showOpenDialog(stage);

        //AFTER FILE SELECTION
        if (selectedFile != null) {

            Circle clip = new Circle(profilePic.getFitWidth());
            clip.setRadius(50.0);
            clip.setCenterX(profilePic.getX() + 50);
            clip.setCenterY(profilePic.getY() + 50);
            profilePic.setClip(clip);

            Image myPic = new Image(selectedFile.getPath());
            profilePic.setImage(myPic);
            setAllDialogPanesInvisible();

        }

    }

    @FXML
    public void addStickersToCardTry() {

        setAllDialogPanesInvisible();
        selectStickerDialogPane.setVisible(true);
        availableStickersListView.getItems().clear();


        for(Sticker stk : stkList) {
            if(stk != null && stk.getStickerUrl() != null) {
                availableStickersListView.getItems().addAll(stk.getName());
            }
        }
    }

    @FXML
    public void addStickersToCardFail() {
        setAllDialogPanesInvisible();
        customizeProfileDialogPane.setVisible(true);
    }

    @FXML
    public void addStickersToCardSuccess() {

        //metti l url dello sticker selezionato come immagine dello slot
        setAllDialogPanesInvisible();

    }

    @FXML
    public void selectSlotTry() {
        setAllDialogPanesInvisible();
        selectSlotDialogPane.setVisible(true);
        slotsListView.getItems().clear();
        slotsListView.getItems().addAll(slots);
    }

    @FXML
    public void selectSlotFail() {
        setAllDialogPanesInvisible();
        selectStickerDialogPane.setVisible(true);
    }

    @FXML
    public void selectSlotSuccess() {

        String selectedSlot = slotsListView.getSelectionModel().getSelectedItem();
        if (selectedSlot != null) {
            System.out.println("Your selected slot: " + selectedSlot);
            String mySlot = selectedSlot;
            applicateStickerToSlot(mySlot,"cabula");
        } else {
            System.out.println("No Slot was selected");
        }

    }

    public void applicateStickerToSlot(String mySlot,String finalUrl) {

        //RETRIEVE STICKER URL SEARCHING BY NAME IN THE DB
        Image stickerToAdd = new Image(finalUrl);

        switch (mySlot) {

            case "Slot1":
                slot1.setImage(stickerToAdd);
                break;
            case "Slot2":
                slot2.setImage(stickerToAdd);
                break;
            case "Slot3":
                slot3.setImage(stickerToAdd);
                break;
            case "Slot4":
                slot4.setImage(stickerToAdd);
                break;
            case "Slot5":
                slot5.setImage(stickerToAdd);
                break;
            case "Slot6":
                slot6.setImage(stickerToAdd);
                break;
            case "Slot7":
                slot7.setImage(stickerToAdd);
                break;
            case "Slot8":
                slot8.setImage(stickerToAdd);
                break;
            case "Remove all stickers":
                slot1.setImage(null);
                slot2.setImage(null);
                slot3.setImage(null);
                slot4.setImage(null);
                slot5.setImage(null);
                slot6.setImage(null);
                slot7.setImage(null);
                slot8.setImage(null);
            default :
                System.out.println("Error");
                break;
        }
        setAllDialogPanesInvisible();
    }

}
