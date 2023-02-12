package co.uniquindio.controller;
import co.uniquindio.model.Cliente;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class UnibancoViewInicioController extends Controller{
    @FXML
    private ObservableList < Cliente> listaClientes = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Cliente, String> colApellidos;

    @FXML
    private TableColumn<Cliente, String> colCedula;

    @FXML
    private TableColumn<Cliente, String> colDireccion;

    @FXML
    private TableColumn<Cliente, String> colEmail;

    @FXML
    private TableColumn<Cliente, String> colNombre;

    @FXML
    private TableView<Cliente> tblClientes;


    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtdireccion;


    private String nombre;
    private String cedula ;
    private String email ;
    private String apellido;
    private String direccion;



    private void cargarCamposTexto(){

        String nombre = txtNombre.getText();
        String cedula = txtCedula.getText();
        String email = txtEmail.getText();
        String apellido = txtApellido.getText();
        String direccion = txtdireccion.getText();

    }






    @FXML
    void actualizarCliente(ActionEvent event) {




        super.actualizarCliente();
    }

    @FXML
    void crearCliente(ActionEvent event) {
        cargarCamposTexto();
        Cliente cliente = new Cliente(nombre, apellido, cedula, direccion, email);
        super.crearCliente(cliente);
        limpiarCamposTexto();
        actualizarTabla();
    }

    private void limpiarCamposTexto() {
        txtApellido.setText("");
        txtdireccion.setText("");
        txtCedula.setText("");
        txtEmail.setText("");
        txtNombre.setText("");
    }

    @FXML
    void depositar(ActionEvent event) {
        System.out.println("depositar");
    }

    @FXML
    void eliminarCliente(ActionEvent event) {

       Cliente cliente = (Cliente) tblClientes.getSelectionModel().getSelectedItem();
       txtNombre.setText(cliente.getNombre());
       txtEmail.setText(cliente.getEmail());
       txtdireccion.setText(cliente.getDireccion());
       txtCedula.setText(cliente.getCedula());
       txtApellido.setText(cliente.getApellido());

    }

    @FXML
    void retirar(ActionEvent event) {
        System.out.println("retirar");
    }

    @FXML
    void solicitarSaldo(ActionEvent event) {
        System.out.println("solicitarSaldo");
    }



    public void initialize() {
        this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.colApellidos.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        this.colCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        this.colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        this.colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    }

    private void getListaClientesData() {

        listaClientes.clear();
        listaClientes.addAll(super.getListaCliente());

    }

    public void actualizarTabla(){
        tblClientes.getItems().clear();
        getListaClientesData();
        tblClientes.setItems(listaClientes);
        tblClientes.refresh();

    }

}
