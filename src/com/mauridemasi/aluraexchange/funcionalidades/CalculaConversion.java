package com.mauridemasi.aluraexchange.funcionalidades;

public class CalculaConversion extends Peticion {

    public String generarConversionADol(double amount, String base_code, String target_code) {
        double valueOfConversion = generarValorDeConversion(base_code, target_code) * amount;
        return "El valor: " + amount + " [" + base_code + "] corresponde al valor final de =>>>" + valueOfConversion + " [" + target_code + "]";
    }

    public String generarConversionAOtraMoneda(double amount, String base_code, String target_code) {

        double valueOfConversion= generarValorDeConversion(base_code, target_code);
        double convertedValue = amount * valueOfConversion;

        return "El valor: "+ amount + " [" + this.getBase_code() + "] corresponde al valor final de =>>>" +
                convertedValue + " [" + this.getTarget_code() + "]";
    }
}
