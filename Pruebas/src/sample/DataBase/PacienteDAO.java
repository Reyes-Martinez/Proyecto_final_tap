package sample.DataBase;

import org.apache.commons.codec.digest.DigestUtils;
import sample.Modelos.Paciente;

import java.sql.*;

public class PacienteDAO {
    Connection connection;

    public PacienteDAO(Connection connection) {
        this.connection = connection;
    }

    public void fetcAll(){
        try {
            String query = "SELECT * FROM paciente";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            String paciente= "";
            while(rs.next()) {
                paciente =paciente +
                        rs.getString("nombres")+ rs.getString("apellidos")
                        +rs.getString("direccion")+rs.getString("municipio")
                        +rs.getString("estado")+rs.getString("pais")
                        +rs.getInt("fnacimiento")+rs.getString("telefono")
                        +rs.getString("alergias")+rs.getString("ecronicas")
                        +rs.getString("cirugias")+rs.getString("covid")
                        +rs.getString("usuario")+rs.getString("contraseña")+"\n";
            }
            rs.close();
            st.close();
            System.out.println(paciente);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
    }

    public Boolean insert(Paciente paciente) {
        try {
            String query = "insert into paciente "
                    + "(nombres,apellidos,direccion,municipio ,estado,pais,fnacimiento,telefono,alergias,ecronicas, cirugias, covid ,usuario,contraseña)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, paciente.getNombre());
            st.setString(2, paciente.getApellidos());
            st.setString(3, paciente.getDireccion());
            st.setString(4, paciente.getMunicipio());
            st.setString(5, paciente.getEstado());
            st.setString(6, paciente.getPais());
            st.setString(7, paciente.getfNacimiento());
            st.setString(8, paciente.getTelefono());
            st.setString(9, paciente.getAlergias());
            st.setString(10, paciente.getEnfermedades());
            st.setString(11, paciente.getCirugia());
            st.setString(12, paciente.getCovid());
            st.setString(13, paciente.getUsuario());
            st.setString(14,paciente.getContraseña());
            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Boolean pacienteExiste(String usuario, String contraseña){
        String contraseñacodificada = DigestUtils.md5Hex(contraseña);
        boolean existe= false;
        try {
            String query = "SELECT * FROM paciente";
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
