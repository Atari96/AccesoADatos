public class Portatil extends Ordenador{
    
    private double peso;

    public Portatil(int codigo, int ram, String cpu, double precio, double peso) {
        super(codigo, ram, cpu, precio);
        this.peso=peso;
        
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getCaracteristicas(){
        String caracteristica=getCaracteristica()+" "+getPeso();
        return caracteristica;
    }

    @Override
    public String toString() {
        return super.toString()+"Portatil [peso=" + peso + "]";
    }
}
