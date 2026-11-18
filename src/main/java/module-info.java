
module org.ezone.pae.serviciosweb {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;

    opens org.ezone.pae.serviciosweb to javafx.fxml;
    opens org.ezone.pae.serviciosweb.controller to javafx.fxml;
    opens org.ezone.pae.serviciosweb.model
            to javafx.base, com.fasterxml.jackson.databind;

    exports org.ezone.pae.serviciosweb;
}
