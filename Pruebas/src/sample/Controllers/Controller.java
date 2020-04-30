package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DataBase.DoctorDAO;
import sample.DataBase.MySQL;
import sample.DataBase.PacienteDAO;
import sample.Modelos.Paciente;


import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    DoctorDAO doctorDAO = new DoctorDAO(MySQL.getConnection());
    PacienteDAO pacienteDAO = new PacienteDAO(MySQL.getConnection());
    @FXML
    TextField usuario;
    @FXML
    PasswordField contraseña;
    @FXML
    Button acceder,registrar;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acceder.setOnAction(acceso);
        registrar.setOnAction(acceso);
    }
    EventHandler<ActionEvent> acceso= new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource()==acceder) {
                System.out.println(contraseña.getText());

                System.out.println(usuario.getText());
                    if(doctorDAO.doctorExiste(usuario.getText(),contraseña.getText())){
                        System.out.println("es un doctor");
                    }
                    else if (pacienteDAO.pacienteExiste(usuario.getText(),contraseña.getText())){
                        System.out.println("es un paciente");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"El usuario no existe ");
                    }
            }
            if(actionEvent.getSource()==registrar){
                String usuario= JOptionPane.showInputDialog("Tipo de usuario(Doctor/Paciente)");
                if(usuario.equals("Doctor")){
                    System.out.println("doctor");
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(getClass().getResource("/sample/Vistas/Registro/registroD.fxml"));
                        Scene scene = new Scene(fxmlLoader.load(),900,506);
                        Stage stage = new Stage();
                        stage.setTitle("Registro para doctores");
                        stage.setScene(scene);
                        stage.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else if(usuario.equals("Paciente")){
                    System.out.println("paciente");
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(getClass().getResource("/sample/Vistas/Registro/registroP.fxml"));
                        Scene scene = new Scene(fxmlLoader.load(),900,506);
                        Stage stage = new Stage();
                        stage.setTitle("Registro para pacientes");
                        stage.setScene(scene);
                        stage.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    };
}
