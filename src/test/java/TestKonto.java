import org.example.Konto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestKonto {

    @Test
    public void testSetteInn() {
        Konto konto = new Konto(12345, 1000); // Oppretter konto med startsaldo 1000
        konto.setteInn(500); // Setter inn 500
        assertEquals(1500, konto.getSaldo()); // Sjekker at saldo øker
    }

    @Test
    public void testTaUt() {
        Konto konto = new Konto(12345, 1000); // Oppretter konto med startsaldo 1000
        konto.taUt(300); // Tar ut 300
        assertEquals(700, konto.getSaldo()); // Sjekker at saldo reduseres
    }

    @Test
    public void testUlovligBelopVedInnskudd() {
        Konto konto = new Konto(12345, 1000);
        assertThrows(IllegalArgumentException.class, () -> konto.setteInn(-100)); // Negativt innskudd
    }

    @Test
    public void testUlovligBelopVedUttak() {
        Konto konto = new Konto(12345, 1000);
        assertThrows(IllegalArgumentException.class, () -> konto.taUt(2000)); // Uttak overstiger saldo
    }

    @Test
    public void testTomKonto() {
        Konto konto = new Konto(0, 0); // Oppretter konto med saldo 0
        assertNotNull(konto); // Sjekker at konto er opprettet (ikke null)
        assertEquals(0, konto.getSaldo()); // Sjekker at saldoen er 0
    }

    @Test
    public void testHelhetligScenario() {
        Konto konto = new Konto(12345, 1000); // Konto med saldo 1000

        // Setter inn penger
        konto.setteInn(500); // Saldo skal nå være 1500
        assertEquals(1500, konto.getSaldo(), "Saldoen etter innskudd er feil.");

        // Tar ut penger
        konto.taUt(300); // Saldo skal nå være 1200
        assertEquals(1200, konto.getSaldo(), "Saldoen etter uttak er feil.");

        // Henter kontoinformasjon og validerer innholdet
        String forventetInfo = "Kontonummer: 12345\nSaldo: 1200";
        assertEquals(forventetInfo, konto.infoKonto(), "Kontoinformasjonen stemmer ikke.");

        // Tester nye innskudd og uttak
        konto.setteInn(100); // Saldo skal nå være 1300
        konto.taUt(1300);    // Saldo skal nå være 0
        assertEquals(0, konto.getSaldo(), "Saldoen etter flere operasjoner er feil.");
    }


}