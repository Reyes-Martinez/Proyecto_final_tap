package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.apache.commons.codec.digest.DigestUtils;
import sample.DataBase.MySQL;
import sample.DataBase.PacienteDAO;
import sample.Modelos.Doctor;
import sample.Modelos.Paciente;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerRegistroP implements Initializable {
    PacienteDAO pacienteDAO = new PacienteDAO(MySQL.getConnection());
    @FXML
    TextField  nombres,apellidos,direccion,municipio,estado,pais,telefono,fecha,alergia,enfeCronicas,cirugias,usuario;
    @FXML
    PasswordField contraseña;
    @FXML
    Button registar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        registar.setOnAction(registo);
    }
    EventHandler<ActionEvent> registo= new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            if(actionEvent.getSource()==registar){
                if (pacienteDAO.pacienteExiste(usuario.getText(),contraseña.getText())==false) {
                    nuevoPaciente();
                }
                else{
                    showMessage("Nombre de usuario no valido","Es posible que el nombre de usuario ya este ocupadp");
                }
            }
        }
    };

    private void nuevoPaciente(){
        Paciente paciente = new Paciente();
        paciente.setNombre(nombres.getText());
        paciente.setApellidos(apellidos.getText());
        paciente.setDireccion(direccion.getText());
        paciente.setMunicipio(municipio.getText());
        paciente.setEstado(estado.getText());
        paciente.setPais(pais.getText());
        paciente.setfNacimiento(fecha.getText());
        paciente.setTelefono(telefono.getText());
        paciente.setAlergias(alergia.getText());
        paciente.setEnfermedades(enfeCronicas.getText());
        paciente.setCirugia(cirugias.getText());
        paciente.setUsuario(usuario.getText());
        paciente.setContraseña(DigestUtils.md5Hex(contraseña.getText()));
        System.out.println("la contraseña es:"+paciente.getContraseña());
        if(pacienteDAO.insert(paciente)){
            System.out.println("el registro fue exitoso");
        }
    }
    private  void showMessage(String title, String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.show();
    }
}
