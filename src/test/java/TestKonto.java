import org.example.Konto;
import org.junit.jupiter.api.Test;
// Test
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}