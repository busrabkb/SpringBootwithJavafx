package com.ilkdeneme.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javassist.CtField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component("deneme")
public class denemeee  implements Initializable {
    @FXML
    javafx.scene.control.Button btn1;
    @Qualifier ("foodRepository")
@Autowired
    FoodRepository foodRepository;
    @Autowired
StageController stageController;

    public denemeee( ) {

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

      btn1.setOnAction(event -> onClickComponents(event));


        System.out.println( foodRepository.findAll());

    }

    private void onClickComponents(javafx.event.ActionEvent event) {
        try { Food f = new Food();
            if (event.getSource().equals("btn1"))

            f.setId(5L);
            f.setName("de");
            stageController.loadNewScene("ffds");

            foodRepository.save(f);      } catch (Exception e)  {}
    }
}
