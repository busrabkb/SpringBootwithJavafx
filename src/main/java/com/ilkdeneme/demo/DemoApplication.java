package com.ilkdeneme.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.net.URL;
@SpringBootApplication
public class DemoApplication extends Application  {

    private ApplicationContext springContext;

    StageController stageController;

	public static void main(String[] args) {
     launch(args);
    }

    @Override
    public void init() throws Exception {
        super.init();
        springContext = SpringApplication.run(DemoApplication.class);
  stageController= (StageController) springContext.getBean(StageController.class);
	}

    @Override
    public void start(Stage stage) throws Exception {
     FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("defx.fxml");
        loader.setControllerFactory(springContext::getBean);
        loader.setLocation( getClass().getClassLoader().getResource("defx.fxml"));

        Parent root = loader.load();
      stage.setScene(new Scene(root));
        stageController.setMainStage(stage);


        stage .show();
        }

}
