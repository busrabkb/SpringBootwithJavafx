package com.ilkdeneme.demo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Component
public class StageController {
    public   Stage mainStage;

public void loadNewScene(String sceneName) throws IOException {

    mainStage.getScene().getWindow().hide();
    FXMLLoader loader = new FXMLLoader();
    URL xmlUrl = getClass().getResource("fx2.fxml");
    //  loader.setControllerFactory(springContext::getBean);

    loader.setLocation( getClass().getClassLoader().getResource("fx2.fxml"));
    Parent root = loader.load();
mainStage=new Stage();
    mainStage.setScene(new Scene(root));
    mainStage.show();


}

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    public  Stage getMainStage() {
        return mainStage;
    }
}
