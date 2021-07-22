package pia1;

// @author Zaragoza
import java.util.Arrays;
import java.util.List;

public class Electrodomestico {

    private int precioBase;
    private String color;
    private char consumoEnergetico;
    private int peso;

    char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
    List<String> colores = Arrays.asList("blanco", "negro", "rojo", "azul", "gris");

    Electrodomestico() {
        precioBase = 1000;
        color = "blanco";
        consumoEnergetico = 'f';
        peso = 5;
    }
    
    Electrodomestico(int precio, String color, char consumo, int peso){
        setPrecioBase(precio);
        setColor(color);
        setConsumoEnergetico(consumo);
        setPeso(peso);
    }

    public Boolean comprobarConsumoEnergetico() {
        char x = getConsumoEnergetico();
        if (new String(charArray).indexOf(x) > 0) {
            // System.out.println("[Debug]: Si se es un valor correcto.");
            return true;
        }else{
            setConsumoEnergetico('f');
            return false;
        }
    }
    
    public Boolean comprobarColor() {
        String y = getColor();
        Boolean match = colores.stream().anyMatch(x -> colores.contains(y));
        if(match == false){
            setColor("blanco");
        }
        return match;
    }
    
    public int precioFinal() {
        char c = getConsumoEnergetico();
        int peso = getPeso();
        int pc=0, pp=0, precioFinal;
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
        
        precioFinal = pc+pp+getPrecioBase();
        return precioFinal;
    }

    public int getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(int precioBase) {
        this.precioBase = precioBase;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public void setConsumoEnergetico(char consumoEnergetico) {
        this.consumoEnergetico = consumoEnergetico;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
