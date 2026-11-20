package org.ezone.pae.serviciosweb;

import javafx.application.Application;

public class Launcher {

    public static void main(String[] args) {

        if (args.length > 0 && args[0].equalsIgnoreCase("clientes")) {
            Application.launch(ClienteApplication.class, args);
        } else {
            Application.launch(UsuarioApplication.class, args);
        }
    }
}