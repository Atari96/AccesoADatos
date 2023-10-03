public class Complejo {
    private double parteReal;
    private double parteImaginaria;

    public Complejo() {    
    }

    public void asignar (double x, double y){
        this.parteReal=x;
        this.parteImaginaria=y;
    }

    public static Complejo sumar (Complejo c1, Complejo c2){
        Complejo c3=new Complejo();
        c3.asignar(c1.getParteReal()+c2.getParteReal(),c1.getParteImaginaria()+c2.getParteImaginaria());
        
        return c3;
    }
    
    public void imprimir (){
        System.out.println("La suma de los numeros complejos es: ("+this.parteReal+" , "+this.parteImaginaria+")");
    }

    public double getParteReal() {
        return parteReal;
    }

    public void setParteReal(double parteReal) {
        this.parteReal = parteReal;
    }

    public double getParteImaginaria() {
        return parteImaginaria;
    }

    public void setParteImaginaria(double parteImaginaria) {
        this.parteImaginaria = parteImaginaria;
    }

    @Override
    public String toString() {
        return "(" + parteReal + " , " + parteImaginaria + ")";
    }

    
    
}
