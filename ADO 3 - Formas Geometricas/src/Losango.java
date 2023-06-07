public class Losango extends Formas{
    private double diagonalMe;
    private double diagonalMa;

    public Losango(){
    }

    public void setDiagonalMe(double diagonalMe){this.diagonalMe = diagonalMe;}
    public void setDiagonalMa(double diagonalMa){this.diagonalMa = diagonalMa;}

    public double Area(){return diagonalMe * diagonalMa/2.0;}

    public String imprimir(){
        return super.imprimir() + " Diagonal Menor = " + diagonalMe + ", Diagonal Maior = " + diagonalMa + ", Área = " + Area();
    }
}
