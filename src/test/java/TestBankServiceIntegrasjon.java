import org.example.BankService;
import org.example.Konto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestBankServiceIntegrasjon {

    private BankService bankService;
    private Konto kontoA;
    private Konto kontoB;

    @BeforeEach
    public void setUp() {
        bankService = new BankService();
        kontoA = new Konto(11111, 1000);
        kontoB = new Konto(22222, 500);
    }

    @Test
    public void testOverforing() {
        // Overfør 300 fra kontoA til kontoB
        bankService.overfor(kontoA, kontoB, 300);

        // saldoA blir 700, saldoB blir 800
        assertEquals(700, kontoA.getSaldo());
        assertEquals(800, kontoB.getSaldo());
    }

    @Test
    public void testOverforingUgyldigBelop() {
        // Forsøk på å overføre negativt beløp
        assertThrows(IllegalArgumentException.class,
                () -> bankService.overfor(kontoA, kontoB, -100));
    }

    @Test
    public void testOverforingMerEnnSaldo() {
        // Forsøk å overføre mer enn kontoA har
        assertThrows(IllegalArgumentException.class,
                () -> bankService.overfor(kontoA, kontoB, 2000));
    }

    @Test
    public void testOverforingNullKonto() {
        // Forsøk å overføre mellom en null-konto og en ekte konto
        assertThrows(IllegalArgumentException.class,
                () -> bankService.overfor(null, kontoB, 100));
    }
}
//