package org.ezone.pae.serviciosweb;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ClienteApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        Scene scene = Navegacion.crearEscena(true);

        stage.setTitle("Servicios Web - Clientes privados");
        stage.setScene(scene);
        stage.show();
    }
}