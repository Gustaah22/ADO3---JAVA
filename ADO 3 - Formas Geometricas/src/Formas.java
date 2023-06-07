public abstract class Formas {
    private  String nome;

    public Formas(){
    }

    public void setNome(String nome){this.nome = nome;}

    public abstract double Area();

    public String imprimir(){ return this.nome;}
}
