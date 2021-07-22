package pia1;


public class Television extends Electrodomestico {
    private int resolucion;
    private Boolean sintonizadorTDT;

    public Television() {
        setResolucion(20);
        setSintonizadorTDT(false);
    }

    public Television(int precio, String color, char consumo, int peso, int res, Boolean tdt) {
        super(precio, color, consumo, peso);
        setResolucion(res);
        setSintonizadorTDT(tdt);
    }
    
    @Override
    public int precioFinal() {
        char c = getConsumoEnergetico();
        int peso = getPeso();
        int pc=0, pp=0, ptdt=0, precioFinal;
        int res = getResolucion();
        Boolean pRes, tdt;
        
        if(res > 40){
            pRes=true;
        }else{
            pRes=false;
        }
        
        tdt = getSintonizadorTDT();
                
        if(tdt){
            ptdt = 500;
        }
        
        
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
        
        if(pRes){
            double precio = (pc+pp+ptdt+getPrecioBase())*(1.3);
            precioFinal = (int) precio;
        }else{
            precioFinal = pc+pp+ptdt+getPrecioBase();
        }
        
        
        return precioFinal;
    }

    public int getResolucion() {
        return resolucion;
    }

    public void setResolucion(int resolucion) {
        this.resolucion = resolucion;
    }

    public Boolean getSintonizadorTDT() {
        return sintonizadorTDT;
    }

    public void setSintonizadorTDT(Boolean sintonizadorTDT) {
        this.sintonizadorTDT = sintonizadorTDT;
    }
    
}
