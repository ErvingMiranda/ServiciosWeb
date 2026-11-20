package org.ezone.pae.serviciosweb;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.io.IOException;

public class Navegacion {

    public static Scene crearEscena(boolean iniciarClientes) throws IOException {

        FXMLLoader loaderUsuarios = new FXMLLoader(
                Navegacion.class.getResource("usuarios-view.fxml")
        );

        FXMLLoader loaderClientes = new FXMLLoader(
                Navegacion.class.getResource("clientes-view.fxml")
        );

        Tab tabUsuarios = new Tab("Usuarios públicos", loaderUsuarios.load());
        Tab tabClientes = new Tab("Clientes privados", loaderClientes.load());

        tabUsuarios.setClosable(false);
        tabClientes.setClosable(false);

        TabPane tabPane = new TabPane(tabUsuarios, tabClientes);

        tabPane.getSelectionModel().select(
                iniciarClientes ? tabClientes : tabUsuarios
        );

        return new Scene(tabPane, 1150, 700);
    }
}