package co.uniquindio.controller;
import co.uniquindio.model.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


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

    @FXML
    private ComboBox<String> cmbTipoCuenta;

    private String nombre;
    private String cedula ;
    private String email ;
    private String apellido;
    private String direccion;
    private String tipoCuenta;

    private Cliente clienteSelected;



    private void cargarCamposTexto(){

         nombre = txtNombre.getText();
         cedula = txtCedula.getText();
         email = txtEmail.getText();
         apellido = txtApellido.getText();
         direccion = txtdireccion.getText();
         tipoCuenta = cmbTipoCuenta.getValue();

    }


    @FXML
    void actualizarCliente(ActionEvent event) {

        cargarCamposTexto();
        Cliente clienteNuevo = new Cliente(nombre, apellido, cedula, direccion, email, tipoCuenta);

        super.actualizarCliente(clienteSelected, clienteNuevo);
        limpiarCamposTexto();
        actualizarTabla();
    }

    @FXML
    void crearCliente(ActionEvent event) {
        cargarCamposTexto();
        Cliente cliente = new Cliente(nombre, apellido, cedula, direccion, email, tipoCuenta);
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
        super.depositar();
        System.out.println("depositar");
    }

    @FXML
    void eliminarCliente(ActionEvent event) {

        if(clienteSelected != null){
            super.eliminarCliente(clienteSelected);
            actualizarTabla();
            limpiarCamposTexto();
        }

    }

    @FXML
    void retirar(ActionEvent event) {

        super.retirar();

    }

    @FXML
    void solicitarSaldo(ActionEvent event) {
        super.solicitarSaldo();
    }


    @FXML
    public void initialize() {
        this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.colApellidos.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        this.colCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        this.colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        this.colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        cmbTipoCuenta.getItems().addAll("Ahorros", "Corriente");
    }



    public void actualizarTabla(){
        listaClientes.clear();
        tblClientes.getItems().clear();
        super.getListaCliente().forEach(System.out::println);
        listaClientes.addAll(super.getListaCliente());
        tblClientes.getItems().addAll(listaClientes);
        tblClientes.refresh();
    }

    @FXML
    void llenarCamposTexto(MouseEvent event) {
        clienteSelected = tblClientes.getSelectionModel().getSelectedItem();
        if(clienteSelected != null){
            clienteSelected = (Cliente) tblClientes.getSelectionModel().getSelectedItem();
            txtNombre.setText(clienteSelected.getNombre());
            txtEmail.setText(clienteSelected.getEmail());
            txtdireccion.setText(clienteSelected.getDireccion());
            txtCedula.setText(clienteSelected.getCedula());
            txtApellido.setText(clienteSelected.getApellido());
        }

    }

}
