import com.scrumtrek.simplestore.*;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by user on 19.11.2015.
 */
public class CustomerTest {
    /* default */ private static final String MOVIE_NAME = "Gladiator";
    /* default */ private static final String CUSTOMER_NAME = "Mickey Mouse";

    IRentalCategory regularRelease = new RegularCategory();
    IRentalCategory newRelease = new NewReleaseCategory();
    IRentalCategory childrenRelease = new ChildrenCategory();

    @Test
    public void ShouldGetStatementWhenAddNewRelease() {
        Customer customer = buildTestee(newRelease, 5);
        checkStatement(customer, 15, 2);
    }

    @Test
    public void ShouldGetStatementWhenAddNewReleaseForOneDay() {
        Customer customer = buildTestee(newRelease, 1);
        checkStatement(customer, 3, 1);
    }

    @Test
    public void ShouldGetStatementWhenAddChildrenRelease() {
        Customer customer = buildTestee(childrenRelease, 5);
        checkStatement(customer, 3, 1);
    }

    @Test
    public void ShouldGetStatementWhenAddRegularRelease() {
        Customer customer = buildTestee(regularRelease, 5);
        checkStatement(customer, 6.5, 1);
    }

    @Test
    public void ShouldGetStatementWhenAddChildrenReleaseForOneDay() {
        Customer customer = buildTestee(childrenRelease, 1);
        checkStatement(customer, 1.5, 1);
    }

    @Test
    public void ShouldGetStatementWhenAddRegularReleaseForOneDay() {
        Customer customer = buildTestee(regularRelease, 1);
        checkStatement(customer, 2, 1);
    }

    private void checkStatement(Customer customer, double amount, int points) {
        assertThat(customer.buildStatement()).isEqualTo(String.format(
                "Rental record for %s" + System.lineSeparator() + "\t%s\t" +
                        amount + System.lineSeparator() +
                        "Amount owed is " + amount + System.lineSeparator() +
                        "You earned " + points + " frequent renter points.", CUSTOMER_NAME, MOVIE_NAME));
    }

    private Customer buildTestee(IRentalCategory rentalCategory, int days) {
        Customer customer = new Customer(CUSTOMER_NAME);
        Movie movie = new Movie(MOVIE_NAME, rentalCategory);
        Rental rental = new Rental(movie, days);
        customer.addRental(rental);
        return customer;
    }
}
