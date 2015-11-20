import com.scrumtrek.simplestore.*;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by user on 19.11.2015.
 */
public class CustomerTest {

    private Customer customer;
    Movie regularRelease = new Movie("Gladiator", new RegularCategory());
    Movie newRelease = new Movie("Gladiator", new NewReleaseCategory());
    Movie childrenRelease = new Movie("Gladiator", new ChildrenCategory());

    @Before
    public void TestInitialize(){
        customer = new Customer("Mickey Mouse");
    }

    @Test
    public void ShouldGetStatementWhenAddNewRelease(){
        Rental rental = new Rental(newRelease, 5);
        customer.addRental(rental);
        assertThat(customer.Statement()).isEqualTo(
                "Rental record for Mickey Mouse" + System.lineSeparator() +
                        "\tGladiator\t15.0" + System.lineSeparator() +
                        "Amount owed is 15.0" + System.lineSeparator() +
                        "You earned 2 frequent renter points.");
    }

    @Test
    public void ShouldGetStatementWhenAddNewReleaseForOneDay(){
        Rental rental = new Rental(newRelease, 1);
        customer.addRental(rental);

        assertThat(customer.Statement()).isEqualTo(
                "Rental record for Mickey Mouse" + System.lineSeparator() +
                        "\tGladiator\t3.0" + System.lineSeparator() +
                        "Amount owed is 3.0" + System.lineSeparator() +
                        "You earned 1 frequent renter points.");
    }

    @Test
    public void ShouldGetStatementWhenAddChildrenRelease(){
        Rental rental = new Rental(childrenRelease, 5);
        customer.addRental(rental);
        assertThat(customer.Statement()).isEqualTo(
                "Rental record for Mickey Mouse" + System.lineSeparator() +
                        "\tGladiator\t3.0" + System.lineSeparator() +
                        "Amount owed is 3.0" + System.lineSeparator() +
                        "You earned 1 frequent renter points.");
    }

    @Test
    public void ShouldGetStatementWhenAddRegularRelease() {
        Rental rental = new Rental(regularRelease, 5);
        customer.addRental(rental);

        assertThat(customer.Statement()).isEqualTo(
                "Rental record for Mickey Mouse" + System.lineSeparator() +
                        "\tGladiator\t6.5" + System.lineSeparator() +
                        "Amount owed is 6.5" + System.lineSeparator() +
                        "You earned 1 frequent renter points.");
    }

    @Test
    public void ShouldGetStatementWhenAddChildrenReleaseForOneDay(){
        Rental rental = new Rental(childrenRelease, 1);
        customer.addRental(rental);

        assertThat(customer.Statement()).isEqualTo(
                "Rental record for Mickey Mouse" + System.lineSeparator() +
                        "\tGladiator\t1.5" + System.lineSeparator() +
                        "Amount owed is 1.5" + System.lineSeparator() +
                        "You earned 1 frequent renter points.");
    }

    @Test
    public void ShouldGetStatementWhenAddRegularReleaseForOneDay() {
        Rental rental = new Rental(regularRelease, 1);
        customer.addRental(rental);

        assertThat(customer.Statement()).isEqualTo(
                "Rental record for Mickey Mouse" + System.lineSeparator() +
                        "\tGladiator\t2.0" + System.lineSeparator() +
                        "Amount owed is 2.0" + System.lineSeparator() +
                        "You earned 1 frequent renter points.");
    }
}
