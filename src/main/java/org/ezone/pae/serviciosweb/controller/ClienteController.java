
package org.ezone.pae.serviciosweb.controller;

import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import org.ezone.pae.serviciosweb.model.Cliente;
import org.ezone.pae.serviciosweb.service.ClienteService;

import java.math.BigDecimal;
import java.util.List;

public class ClienteController {

    // Tabla y columnas.
    @FXML private TableView<Cliente> tblClientes;
    @FXML private TableColumn<Cliente, Long> colId;
    @FXML private TableColumn<Cliente, String> colNombre;
    @FXML private TableColumn<Cliente, String> colApellido;
    @FXML private TableColumn<Cliente, String> colCorreo;
    @FXML private TableColumn<Cliente, String> colTelefono;
    @FXML private TableColumn<Cliente, String> colNacimiento;
    @FXML private TableColumn<Cliente, String> colPais;
    @FXML private TableColumn<Cliente, String> colCiudad;
    @FXML private TableColumn<Cliente, String> colDireccion;
    @FXML private TableColumn<Cliente, BigDecimal> colIngreso;
    @FXML private TableColumn<Cliente, Integer> colPuntaje;
    @FXML private TableColumn<Cliente, Boolean> colDeuda;
    @FXML private TableColumn<Cliente, BigDecimal> colMontoDeuda;
    @FXML private TableColumn<Cliente, String> colEstado;
    @FXML private TableColumn<Cliente, String> colCreacion;
    @FXML private TableColumn<Cliente, String> colActualizacion;

    @FXML private Button btnConsultar;
    @FXML private Label lblEstado;

    private final ClienteService service = new ClienteService();

    @FXML
    public void initialize() {

        // Asociamos las columnas con las propiedades de Cliente.
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colNacimiento.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        colPais.setCellValueFactory(new PropertyValueFactory<>("country"));
        colCiudad.setCellValueFactory(new PropertyValueFactory<>("city"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("address"));
        colIngreso.setCellValueFactory(new PropertyValueFactory<>("annualIncome"));
        colPuntaje.setCellValueFactory(new PropertyValueFactory<>("creditScore"));
        colDeuda.setCellValueFactory(new PropertyValueFactory<>("hasUnpaidDebt"));
        colMontoDeuda.setCellValueFactory(new PropertyValueFactory<>("unpaidDebtAmount"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("status"));
        colCreacion.setCellValueFactory(new PropertyValueFactory<>("createdAt"));
        colActualizacion.setCellValueFactory(new PropertyValueFactory<>("updatedAt"));
    }

    // Consulta el servicio privado sin bloquear JavaFX.
    @FXML
    private void consultarClientes() {

        Task<List<Cliente>> task = new Task<List<Cliente>>() {
            @Override
            protected List<Cliente> call() throws Exception {
                return service.obtenerClientes();
            }
        };

        btnConsultar.setDisable(true);
        lblEstado.setText("Consultando servicio privado...");

        task.setOnSucceeded(e -> {

            List<Cliente> clientes = task.getValue();

            tblClientes.setItems(
                    FXCollections.observableArrayList(clientes)
            );
            //Arregla un bug todo raro :V
            tblClientes.scrollTo(0);

            btnConsultar.setDisable(false);
            lblEstado.setText(clientes.size() + " clientes recuperados.");
        });

        // Mostramos una alerta cuando falla la consulta.
        task.setOnFailed(e -> {

            Throwable error = task.getException();

            btnConsultar.setDisable(false);
            lblEstado.setText("Error al consultar clientes.");

            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("No se pudo consultar el servicio");
            alerta.setContentText(error == null
                    ? "Ocurrió un error desconocido."
                    : error.getMessage());
            alerta.showAndWait();
        });

        Thread hilo = new Thread(task);
        hilo.setDaemon(true);
        hilo.start();
    }
}
