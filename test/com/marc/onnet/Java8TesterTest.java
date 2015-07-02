package com.marc.onnet;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * Created by marcona on 06/06/15.
 */
public class Java8TesterTest {
    @Test
    public void test_loadFile() throws Exception {
        WorkLogs workLogs = new Java8Tester().loadFile();

        workLogs.spoolDays();

        workLogs.calculTotal();
    }


    @Test
    public void test_streams() throws Exception {
        Stream<String> currencies = Stream.of("GBP", "EUR", "USD", "CAD", "AUD", "JPY", "HKD");

        currencies
              .filter(c -> c.matches("GBP|EUR"))
              .forEach(ccy -> System.out.println(ccy));
    }


    @Test
    public void test_streamsMatches() throws Exception {
        Stream<String> currencies = Stream.of("GBP", "EUR", "USD", "CAD", "AUD", "JPY", "HKD");

        boolean match = currencies.allMatch(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() == 3;
            }
        });

        assertThat(match, is(true));
    }


    @Test
    public void test_eliott() throws Exception {
        System.out.println("Coucou Eliott ca va ?");
        System.out.println("Je vais faire un calcul: 350 /50, d'accord ?");

        int resultat = 150098 / 3445;

        System.out.println("       150098 / 3445 = " + resultat);

        System.out.println("resultat * 8 = " + resultat * 8);

        String un = "Bonjour";
        String deux = "Eliott";
        String trois = "chéri";
        String cestLesVacances = "faux";

        System.out.println(un + " " + deux + " " + trois);

        if (cestLesVacances.equals("vrai")) {
            System.out.println("C'est les vacances !!!");
        }
        else {
            System.out.println("Ho zutttt c'est pas encore les vacances !!!");
        }

        System.out.println("----------------------------------------------");
        System.out.println("pa je vais à la piscine avec mes amis. ");

        String ouiOuNon = "non";

        if (ouiOuNon.equals("oui")) {
            System.out.println("Ok Eliott pas de problème");
        }
        else {
            System.out.println("tu dois d'abord finir tes devoirs !");
        }
        System.out.println("Merci pilpouce");

        ouiOuNon = "oui";
    }
}
