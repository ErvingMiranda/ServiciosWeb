package org.ezone.pae.serviciosweb;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class UsuarioApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        Scene scene = Navegacion.crearEscena(false);

        stage.setTitle("Servicios Web - Usuarios públicos");
        stage.setScene(scene);
        stage.show();
    }
}