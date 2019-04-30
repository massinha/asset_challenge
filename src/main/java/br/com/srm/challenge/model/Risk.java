package br.com.srm.challenge.model;

public enum Risk {
    A('A', .0),
    B('B', 10.),
    C('C', 20.);

    private char riskType;
    private Double riskTax;

    Risk(char riskType, Double riskTax){
        this.riskType = riskType;
        this.riskTax = riskTax;
    }

    public static Double getTaxByRisk(Risk riskType) throws Exception {
        for (Risk risk : Risk.values()){
            if (riskType.equals(risk))
                return risk.riskTax;
        }
        throw new Exception("Incorrect param value for risk. Only 'A','B' or 'C' allowed");
    }

}
