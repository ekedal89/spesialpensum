package org.example;

public class BankService {

    /**
     * Metode for å overføre penger mellom to Konto-objekter.
     */
    public void overfor(Konto fraKonto, Konto tilKonto, int belop) {
        if (fraKonto == null || tilKonto == null) {
            throw new IllegalArgumentException("Kontoreferanser kan ikke være null.");
        }
        if (belop <= 0) {
            throw new IllegalArgumentException("Beløpet må være positivt.");
        }

        fraKonto.taUt(belop);   // kaster unntak hvis beløpet overstiger saldo
        tilKonto.setteInn(belop);
    }
}


