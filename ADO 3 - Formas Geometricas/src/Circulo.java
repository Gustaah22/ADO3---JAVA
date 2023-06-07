public class Circulo extends Formas{
    private double raio;

    public Circulo(){
    }

    public void setRaio(double raio) {this.raio = raio;}

    public double Area(){return Math.PI * (raio * raio);}

    public String imprimir(){
        String impressao = super.imprimir();
        return impressao + " Raio = " + raio + ", " + "Área = " + Area();
    }
}
