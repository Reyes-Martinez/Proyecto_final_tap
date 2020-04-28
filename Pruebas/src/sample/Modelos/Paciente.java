package sample.Modelos;
public class Paciente {
    private String nombre;
    private String apellidos;
    private String direccion;
    private String estado;
    private String municipio;
    private String pais;
    private String fNacimiento;
    private int telefono;
    private String alergias;
    private String enfermedades;
    private String cirugia;
    private String covid;
    private String usuario;
    private String contraseña;

    public Paciente() {

    }

    public Paciente(String nombre, String apellidos, String direccion, String estado, String municipio, String pais, String fNacimiento, int telefono, String alergias, String enfermedades, String cirugia, String usuario, String contraseña) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.estado = estado;
        this.municipio = municipio;
        this.pais = pais;
        this.fNacimiento = fNacimiento;
        this.telefono = telefono;
        this.alergias = alergias;
        this.enfermedades = enfermedades;
        this.cirugia = cirugia;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(String fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }

    public String getCirugia() {
        return cirugia;
    }

    public void setCirugia(String cirugia) {
        this.cirugia = cirugia;
    }

    public String getCovid() {
        return covid;
    }

    public void setCovid(String covid) {
        this.covid = covid;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}