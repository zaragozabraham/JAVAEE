package pia1;


public class Lavadora extends Electrodomestico {
    private int carga;
    

    public Lavadora() {
        setCarga(5);
    }

    public Lavadora(int precio, String color, char consumo, int peso, int carga) {
        super(precio, color, consumo, peso);
        setCarga(carga);
    }
    
    @Override
    public int precioFinal() {
        char c = getConsumoEnergetico();
        int peso = getPeso();
        int carga = getCarga();
        int pc=0, pp=0, pcarga=0, precioFinal;
        switch(c){
            case 'a': 
                pc = 1000;
                break;
            case 'b':
                pc = 800;
                break;
            case 'c':
                pc = 600;
                break;
            case 'd':
                pc = 500;
                break;
            case 'e':
                pc = 300;
                break;
            case 'f':
                pc = 100;
                break;
            default: break;
        }
        
        if(peso >=0 && peso <=19){
            pp = 100;
        }else if(peso >=20 && peso <=49){
            pp = 500;
        }else if(peso>=50 && peso <= 79){
            pp = 800;
        }else if(peso>=80){
            pp = 1000;
        }else{
            System.out.println("Error: Peso no valido.");
        }
        
        if(carga > 30){
            pcarga = 500;
        }
        
        precioFinal = pc+pp+pcarga+getPrecioBase();
        return precioFinal;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }
    
}
