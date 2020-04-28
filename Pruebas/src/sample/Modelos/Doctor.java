package sample.Modelos;

public class Doctor {
    private String nombres;
    private String apellidos;
    private String  especialidad;
    private int cedula;
    private String direccion;//no es necesario
    private String municipio;
    private String estado;
    private String pais;
    private String telefono;//no es necesario
    private String correo;
    private int precio;
    private String usuario;
    private String contraseña;

    public Doctor(){

    }
    public Doctor(String nombres, String apellidos, String especialidad, int cedula, String direccion, String municipio, String estado, String pais, String telefono, String correo, int precio, String usuario, String contraseña) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.especialidad = especialidad;
        this.cedula = cedula;
        this.direccion = direccion;
        this.municipio = municipio;
        this.estado = estado;
        this.pais = pais;
        this.telefono = telefono;
        this.correo = correo;
        this.precio = precio;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
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
