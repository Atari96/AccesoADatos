public interface Impresora {
    String imprimir(String texto);
    double getVelocidad();

    public default Impresora esMasRapida(Impresora impresora1){
        Impresora impresora=null;
        if (impresora1.getVelocidad() > this.getVelocidad()){
            impresora=impresora1;
        }
        if (impresora1.getVelocidad() < this.getVelocidad()){
            impresora=this;
        }
        
        return impresora;
    }
}
