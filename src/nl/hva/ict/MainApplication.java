package nl.hva.ict;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import nl.hva.ict.controllers.MainController;
import nl.hva.ict.data.MongoDB.MongoReizigers;
import nl.hva.ict.data.MySQL.*;

public class MainApplication extends Application {

    private static final String TITLE = "Practicumopdracht DB2";

    //MySQL
    private static final String MYSQL_HOST = "jdbc:mysql://localhost:3306/big_five_safari?autoReconnect=true&serverTimezone=Europe/Amsterdam&useSSL=False";
    private static final String MYSQL_USERNAME = "root";
    private static final String MYSQL_PASSWORD = "";

    //Mongo NoSQL
    private static final String NOSQL_HOST = "mongodb+srv://user:userpassword@cluster0-ireom.azure.mongodb.net/test?retryWrites=true&w=majority";
    private static final String NOSQL_DATABASE = "big_five_safari";

    //JavaFX
    private static Stage stage;
    private static MainController mainController;

    //Static dataconnectors
    private static MySQLReizigers mySQLReizigers = new MySQLReizigers();
    private static MySQLHotels mySQLHotels = new MySQLHotels();
    private static MySQLLodges mySQLLodges = new MySQLLodges();
    private static MySQLBoekingsOverzicht mySQLBoekingsOverzicht= new MySQLBoekingsOverzicht();
    private static MySQLAccommodaties mySQLAccommodaties = new MySQLAccommodaties();

    private static MongoReizigers mongoReizigers = new MongoReizigers();

    private final int WIDTH = 800;
    private final int HEIGHT = 800;

    public static void switchController(Parent pane) {
        mainController.getBorderPane().setCenter(pane);
    }

    public static String getMysqlHost() {
        return MYSQL_HOST;
    }

    public static String getMysqlUsername() {
        return MYSQL_USERNAME;
    }

    public static String getMysqlPassword() {
        return MYSQL_PASSWORD;
    }

    public static String getNosqlHost() {
        return NOSQL_HOST;
    }

    public static String getNosqlDatabase() {
        return NOSQL_DATABASE;
    }

    public static String getTITLE() {
        return TITLE;
    }

    public static MySQLReizigers getMySQLReizigers() { return mySQLReizigers; }

    public static MySQLHotels getMySQLHotels() { return mySQLHotels; }

    public static MySQLLodges getMySQLLodges() { return mySQLLodges; }

    public static MySQLBoekingsOverzicht getMySQLBoekingsOverzicht() { return mySQLBoekingsOverzicht; }

    public static MySQLAccommodaties getMySQLAccommodaties() {
        return mySQLAccommodaties;
    }

    public static MongoReizigers getMongoReizigers() {
        return mongoReizigers;
    }

    @Override
    public void start(Stage stage) {
        MainApplication.stage = stage;
        MainApplication.stage.setTitle(TITLE);
        MainApplication.stage.setWidth(WIDTH);
        MainApplication.stage.setHeight(HEIGHT);
        mainController = new MainController();

        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        MainApplication.stage.setX((primaryScreenBounds.getWidth() - WIDTH) / 2f);
        MainApplication.stage.setY((primaryScreenBounds.getHeight() - HEIGHT) / 2f);

        stage.setScene(new Scene(mainController.getView().getRoot()));
        stage.show();
    }
}

