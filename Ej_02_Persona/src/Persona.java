public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private Sexo sexo;
    private double peso;
    private double altura;

    public Persona() {
        this.nombre = "";
        this.edad = 0;
        this.sexo = Sexo.HOMBRE;
        this.peso = 0;
        this.altura = 0;
    }

    public Persona(String nombre, int edad, Sexo sexo){
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }

    public Persona(String nombre, int edad, String dni, Sexo sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        int imc=0;
        imc=(int)(peso/(altura*altura));
        return imc;
    }

    public boolean validarDNI(String dni){
        boolean validacion=false;
        if (dni.length()==9){
            String letraDni=dni.substring(8, 9);
            String num=dni.substring(0, 8);
            while (num.startsWith("0")){
                int cifra=8;
                num=num.substring(1,cifra);
                cifra-=1;
            }
            int numero=Integer.parseInt(num);
            String letra="";
            switch(numero%23){
            case 0:
                letra="T";
                break;
            case 1:
                letra="R";
                break;
            case 2:
                letra="W";
                break;
            case 3:
                letra="A";
                break;
            case 4:
                letra="G";
                break;
            case 5:
                letra="M";
                break;
            case 6:
                letra="Y";
                break;
            case 7:
                letra="F";
                break;
            case 8:
                letra="P";
                break;
            case 9:
                letra="D";
                break;
            case 10:
                letra="X";
                break;
            case 11:
                letra="B";
                break;
            case 12:
                letra="N";
                break;
            case 13:
                letra="J";
                break;
            case 14:
                letra="Z";
                break;
            case 15:
                letra="S";
                break;
            case 16:
                letra="Q";
                break;
            case 17:
                letra="V";
                break;
            case 18:
                letra="H";
                break;
            case 19:
                letra="L";
                break;
            case 20:
                letra="C";
                break;
            case 21:
                letra="K";
                break;
            case 22:
                letra="E";
                break;
            }
            if (letra.equalsIgnoreCase(letraDni)){
                validacion=true;
            }
        }
        return validacion;
    }

    public Sexo validarSexo(Persona persona){
        return sexo=persona.getSexo();
    }

    public String generarDNI(){
        String dni="";
        for (int i=0; i<8; i++){
            dni=dni+((int)(Math.random()*10));
        }
        int idni=Integer.parseInt(dni);
        String letra="";
        switch(idni%23){
            case 0:
                letra="T";
                break;
            case 1:
                letra="R";
                break;
            case 2:
                letra="W";
                break;
            case 3:
                letra="A";
                break;
            case 4:
                letra="G";
                break;
            case 5:
                letra="M";
                break;
            case 6:
                letra="Y";
                break;
            case 7:
                letra="F";
                break;
            case 8:
                letra="P";
                break;
            case 9:
                letra="D";
                break;
            case 10:
                letra="X";
                break;
            case 11:
                letra="B";
                break;
            case 12:
                letra="N";
                break;
            case 13:
                letra="J";
                break;
            case 14:
                letra="Z";
                break;
            case 15:
                letra="S";
                break;
            case 16:
                letra="Q";
                break;
            case 17:
                letra="V";
                break;
            case 18:
                letra="H";
                break;
            case 19:
                letra="L";
                break;
            case 20:
                letra="C";
                break;
            case 21:
                letra="K";
                break;
            case 22:
                letra="E";
                break;
        }
        dni=dni+letra;
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", edad=" + edad + ", dni=" + dni + ", sexo=" + sexo + ", peso=" + peso
                + ", altura=" + altura + "]";
    }

    

    
}