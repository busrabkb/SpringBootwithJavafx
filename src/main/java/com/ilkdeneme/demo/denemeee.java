package com.ilkdeneme.demo;

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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component("deneme")
public class denemeee  implements Initializable {
    @Qualifier ("foodRepository")
@Autowired
    FoodRepository foodRepository;


    public denemeee( ) {

    }
    void abc() throws IOException {

        Food f=new Food();
        f.setId(4L);
        f.setName("de");
        foodRepository.save(f);
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("fx2.fxml");
        //  loader.setControllerFactory(springContext::getBean);

        loader.setLocation( getClass().getClassLoader().getResource("fx2.fxml"));
        Parent root = loader.load();

 Stage s=new Stage();
 s.setScene(new Scene(root));
      s.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            abc();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println( foodRepository.findAll());

    }
}
