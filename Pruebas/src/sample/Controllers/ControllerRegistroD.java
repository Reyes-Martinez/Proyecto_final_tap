package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.apache.commons.codec.digest.DigestUtils;
import sample.DataBase.DoctorDAO;
import sample.DataBase.MySQL;
import sample.Modelos.Doctor;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerRegistroD implements Initializable {
    DoctorDAO doctorDAO = new DoctorDAO(MySQL.getConnection());
    @FXML
    TextField  nombre,apellidos,especialidad,ncedula,direccion,municipio,estado,pais,telefono,correo,precio,usuario;
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
                nuevoDoctor();
            }
        }
    };

    private void nuevoDoctor() {
        Doctor doctor = new Doctor();
        doctor.setNombres(nombre.getText());
        doctor.setApellidos(apellidos.getText());
        doctor.setEspecialidad(especialidad.getText());
        doctor.setCedula(Integer.valueOf(ncedula.getText()));
        doctor.setDireccion(direccion.getText());
        doctor.setMunicipio(municipio.getText());
        doctor.setEstado(estado.getText());
        doctor.setPais(pais.getText());
        doctor.setTelefono(telefono.getText());
        doctor.setCorreo(correo.getText());
        doctor.setPrecio(Integer.valueOf(precio.getText()));
        doctor.setUsuario(usuario.getText());
        doctor.setContraseña(DigestUtils.md5Hex(contraseña.getText()));
        System.out.println("la contraseña es:"+doctor.getContraseña());
        if(doctorDAO.insert(doctor)){
            System.out.println("el registro fue exitoso");
        }
    }

}
