package org.example;

public class Konto {

    public int kontoNr;
    public int saldo;

    public Konto(int startKontoNr, int startSaldo) {
        this.kontoNr = startKontoNr;
        this.saldo = startSaldo;
    }

    // Metode for å sette inn et beløp
    public void setteInn(int belop) {
        if (belop > 0) {
            saldo += belop;
        } else {
            throw new IllegalArgumentException("Beløpet må være positivt!");
        }
    }

    // Metode for å ta ut et beløp
    public void taUt(int belop) {
        if (belop > 0 && belop <= saldo) {
            saldo -= belop;
        } else if (belop > saldo) {
            throw new IllegalArgumentException("Ikke nok saldo på kontoen!");
        } else {
            throw new IllegalArgumentException("Beløpet må være positivt!");
        }
    }

    // Henter informasjon om kontoen
    public String infoKonto() {
        return "Kontonummer: " + kontoNr + "\nSaldo: " + saldo;
    }

    // Getter for saldo
    public int getSaldo() {
        return saldo;
    }
}