package idh.java;

// Dieser statische Import lädt alle "assert..." Methoden (wie assertArrayEquals, assertThrows).
import static org.junit.jupiter.api.Assertions.*;

// Dieser Import lädt die @Test Annotation, damit Java weiß, welche Methoden ausgeführt werden sollen.
import org.junit.jupiter.api.Test;

class TestATM {

    // Wir erstellen uns eine ATM-Instanz, die wir für die Tests nutzen können
    ATM atm = new ATM();

    @Test
    void testValidAmounts() throws ATM.IllegalInputException {
        // Testfall 1: Ein typischer Betrag (65)
        // Erwartet: 0x500, 0x200, 0x100, 1x50, 0x20, 1x10, 1x5
        int[] expected65 = {0, 0, 0, 1, 0, 1, 1};
        assertArrayEquals(expected65, atm.convertToBills(65));

        // Testfall 2: Ein großer Betrag (885)
        // Erwartet: 1x500, 1x200, 1x100, 1x50, 1x20, 1x10, 1x5
        int[] expected885 = {1, 1, 1, 1, 1, 1, 1};
        assertArrayEquals(expected885, atm.convertToBills(885));
        
        // Testfall 3: Extremfall 0
        int[] expected0 = {0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(expected0, atm.convertToBills(0));

        // Testfall 4: Extremfall - größtmögliche durch 5 teilbare Zahl
        // Integer.MAX_VALUE ist 2147483647. Der nächste durch 5 teilbare Wert ist 2147483645.
        // Das Programm darf hier nicht abstürzen (wirft keine Exception).
        int maxDiv5 = Integer.MAX_VALUE - 2;
        assertNotNull(atm.convertToBills(maxDiv5));
    }

    @Test
    void testNegativeAmount() throws ATM.IllegalInputException {
        // Laut Aufgabe: "Bei Eingabe einer negativen Zahl wird ein Array mit Nullen zurückgegeben."
        int[] expectedZeros = {0, 0, 0, 0, 0, 0, 0};

        // Test mit normaler negativer Zahl
        assertArrayEquals(expectedZeros, atm.convertToBills(-15));
        
        // Test mit Extremwert
        assertArrayEquals(expectedZeros, atm.convertToBills(-999999));
    }

    @Test
    void testInvalidAmount() {
        // Laut Aufgabe: "Bei Eingabe einer Zahl die nicht durch fünf teilbar ist, wird eine Exception [...] geworfen."
        
        // Testfall 1: Zahl ist knapp nicht durch 5 teilbar
        assertThrows(ATM.IllegalInputException.class, () -> {
            atm.convertToBills(12);
        });

        // Testfall 2: Eine kleine Zahl, die nicht durch 5 teilbar ist
        assertThrows(ATM.IllegalInputException.class, () -> {
            atm.convertToBills(1);
        });
    }
}