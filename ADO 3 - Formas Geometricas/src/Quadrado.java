public class Quadrado extends Formas{
    private double lado;

    public Quadrado(){
    }

    public void setLado(double lado){
        this.lado = lado;
    }

    public double Area(){
        return lado * lado;
    }

    public String imprimir(){
        String impressao = super.imprimir();
        return impressao + " Lado = " + lado + ", " + " Área = " + Area();
    }
}
