import com.scrumtrek.simplestore.*;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by user on 19.11.2015.
 */
public class CustomerTest {
    IRentalCategory regularRelease = new RegularCategory();
    IRentalCategory newRelease = new NewReleaseCategory();
    IRentalCategory childrenRelease = new ChildrenCategory();

    @Test
    public void ShouldGetStatementWhenAddNewRelease() {
        Customer customer = buildTestee(newRelease, 5);

        assertThat(customer.buildStatement()).isEqualTo(
                "Rental record for Mickey Mouse" + System.lineSeparator() +
                        "\tGladiator\t15.0" + System.lineSeparator() +
                        "Amount owed is 15.0" + System.lineSeparator() +
                        "You earned 2 frequent renter points.");
    }

    @Test
    public void ShouldGetStatementWhenAddNewReleaseForOneDay() {
        Customer customer = buildTestee(newRelease, 1);

        assertThat(customer.buildStatement()).isEqualTo(
                "Rental record for Mickey Mouse" + System.lineSeparator() +
                        "\tGladiator\t3.0" + System.lineSeparator() +
                        "Amount owed is 3.0" + System.lineSeparator() +
                        "You earned 1 frequent renter points.");
    }

    @Test
    public void ShouldGetStatementWhenAddChildrenRelease() {
        Customer customer = buildTestee(childrenRelease, 5);

        assertThat(customer.buildStatement()).isEqualTo(
                "Rental record for Mickey Mouse" + System.lineSeparator() +
                        "\tGladiator\t3.0" + System.lineSeparator() +
                        "Amount owed is 3.0" + System.lineSeparator() +
                        "You earned 1 frequent renter points.");
    }

    @Test
    public void ShouldGetStatementWhenAddRegularRelease() {
        Customer customer = buildTestee(regularRelease, 5);
        assertThat(customer.buildStatement()).isEqualTo(
                "Rental record for Mickey Mouse" + System.lineSeparator() +
                        "\tGladiator\t6.5" + System.lineSeparator() +
                        "Amount owed is 6.5" + System.lineSeparator() +
                        "You earned 1 frequent renter points.");
    }

    @Test
    public void ShouldGetStatementWhenAddChildrenReleaseForOneDay() {
        Customer customer = buildTestee(childrenRelease, 1);

        assertThat(customer.buildStatement()).isEqualTo(
                "Rental record for Mickey Mouse" + System.lineSeparator() +
                        "\tGladiator\t1.5" + System.lineSeparator() +
                        "Amount owed is 1.5" + System.lineSeparator() +
                        "You earned 1 frequent renter points.");
    }

    @Test
    public void ShouldGetStatementWhenAddRegularReleaseForOneDay() {
        Customer customer = buildTestee(regularRelease, 1);

        assertThat(customer.buildStatement()).isEqualTo(
                "Rental record for Mickey Mouse" + System.lineSeparator() +
                        "\tGladiator\t2.0" + System.lineSeparator() +
                        "Amount owed is 2.0" + System.lineSeparator() +
                        "You earned 1 frequent renter points.");
    }

    private Customer buildTestee(IRentalCategory rentalCategory, int days) {
        Customer customer = new Customer("Mickey Mouse");
        Movie movie = new Movie("Gladiator", rentalCategory);
        Rental rental = new Rental(movie, days);
        customer.addRental(rental);
        return customer;
    }
}
