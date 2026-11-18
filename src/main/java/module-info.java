module org.ezone.pae.serviciosweb {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.ezone.pae.serviciosweb to javafx.fxml;
    exports org.ezone.pae.serviciosweb;
}