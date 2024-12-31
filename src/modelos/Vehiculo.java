package modelos;

public abstract class Vehiculo implements Crear{
    private String marca;
    private String modelo;
    private int anio;
    private double precio;
    private static int id;
    private int idVehiculo;
    private double impuesto;

    protected Vehiculo() {
        id++;
    }

    public String getMarca() {
        return marca;
    }

    public Vehiculo setMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public String getModelo() {
        return modelo;
    }

    public Vehiculo setModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public int getAnio() {
        return anio;
    }

    public Vehiculo setAnio(int anio) {
        this.anio = anio;
        return this;
    }

    public double getPrecio() {
        return precio;
    }

    public Vehiculo setPrecio(double precio) {
        this.precio = precio;
        return this;
    }

    public static int getId() {
        return id;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public abstract void cacularImpuesto();

    @Override
    public String toString() {
        return  ", marca = '" + marca + '\'' +
                ", modelo = '" + modelo + '\'' +
                ", año = " + anio +
                ", precio = " + precio +
                ", ID = " + idVehiculo +
                ", impuesto = " + impuesto +
                ", precio total = " + (impuesto+precio) +
                '}';
    }
}
