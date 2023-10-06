abstract class Figura {
    
    double total=0;
    // Método ya implementado que heredan las clases
    public void mostrarArea(){
        System.out.println("Área calculada de "+this.getClass()+" es: "+total);
    }
    //Método que deben implementar las clases
    abstract public void calcularArea();
}
