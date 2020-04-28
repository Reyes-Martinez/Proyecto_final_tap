package sample.DataBase;

import org.apache.commons.codec.digest.DigestUtils;
import sample.Modelos.Doctor;

import java.sql.*;

public class DoctorDAO{
    Connection connection;

    public DoctorDAO(Connection connection){
    this.connection=connection;
    }

    public void fetcAll(){
        try {
            String query = "SELECT * FROM doctor";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            String doctor= "";
            while(rs.next()) {
                doctor =doctor+
                        rs.getString("nombre")+ rs.getString("apellidos")
                        +rs.getString("especialidad")+rs.getInt("ncedula")
                        +rs.getString("direccion")+rs.getString("municipio")
                        +rs.getString("estado")+rs.getString("pais")
                        +rs.getInt("telefono")+rs.getString("correo")
                        +rs.getInt("precio")+rs.getString("usuario")
                        +rs.getString("contraseña")+"\n";
            }
            rs.close();
            st.close();
            System.out.println(doctor);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
    }

    public Boolean insert(Doctor doctor) {
        String contraseña=doctor.getContraseña();
        try {
            String query = "insert into doctor "
                    + "(nombres,apellidos,especialidad,ncedula ,direccion,municipio ,estado,pais ,telefono,correo ,precio,usuario,contraseña)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, doctor.getNombres());
            st.setString(2, doctor.getApellidos());
            st.setString(3, doctor.getEspecialidad());
            st.setInt(4, doctor.getCedula());
            st.setString(5, doctor.getDireccion());
            st.setString(6, doctor.getMunicipio());
            st.setString(7, doctor.getEstado());
            st.setString(8, doctor.getPais());
            st.setString(9, doctor.getTelefono());
            st.setString(10, doctor.getCorreo());
            st.setInt(11, doctor.getPrecio());
            st.setString(12, doctor.getUsuario());
            st.setString(13, doctor.getContraseña());
            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Boolean doctorExiste(String usuario, String contraseña){
        String contraseñacodificada = DigestUtils.md5Hex(contraseña);
        boolean existe= false;
        try {
            String query = "SELECT * FROM doctor";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                if(usuario.equals(rs.getString("usuario")) && contraseñacodificada.equals(rs.getString("contraseña"))){
                    existe= true;
                }
            }

        }catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return  existe;
    }

}
