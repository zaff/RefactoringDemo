
import com.scrumtrek.simplestore.*;
import org.junit.Test;

import java.util.Locale;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by user on 19.11.2015.
 * more
 * more
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

    @Test
    public void CheckNewRelease() {
        Rental rental = buildRentalTestee(newRelease, 5);
        assertThat(rental.calculateAmount()).isEqualTo(15);
        assertThat(rental.calculatePoints()).isEqualTo(2);
    }

    @Test
    public void CheckNewReleaseForOneDay() {
        Rental rental = buildRentalTestee(newRelease, 1);
        assertThat(rental.calculateAmount()).isEqualTo(3);
        assertThat(rental.calculatePoints()).isEqualTo(1);
    }

    @Test
    public void CheckChildrenRelease() {
        Rental rental = buildRentalTestee(childrenRelease, 5);
        assertThat(rental.calculateAmount()).isEqualTo(3);
        assertThat(rental.calculatePoints()).isEqualTo(1);
    }

    @Test
    public void CheckRegularRelease() {
        Rental rental = buildRentalTestee(regularRelease, 5);
        assertThat(rental.calculateAmount()).isEqualTo(6.5);
        assertThat(rental.calculatePoints()).isEqualTo(1);
    }

    @Test
    public void CheckChildrenReleaseForOneDay() {
        Rental rental = buildRentalTestee(childrenRelease, 1);
        assertThat(rental.calculateAmount()).isEqualTo(1.5);
        assertThat(rental.calculatePoints()).isEqualTo(1);
    }

    @Test
    public void CheckRegularReleaseForOneDay() {
        Rental rental = buildRentalTestee(regularRelease, 1);
        assertThat(rental.calculateAmount()).isEqualTo(2);
        assertThat(rental.calculatePoints()).isEqualTo(1);
    }

    private Rental buildRentalTestee(IRentalCategory rentalCategory, int days) {
        Movie movie = new Movie(MOVIE_NAME, rentalCategory);
        return new Rental(movie, days);
    }

    private void checkStatement(Customer customer, double amount, int points) {
        assertThat(new TextStatementGenerator().generate(customer).getRawContent()).isEqualTo(String.format(
                Locale.US,
                "Rental record for %s%5$s\t%s\t%.1f%5$sAmount owed is %3$.1f" +
                        "%5$sYou earned %d frequent renter points.",
                CUSTOMER_NAME, MOVIE_NAME, amount, points, System.lineSeparator()));
    }

    private Customer buildTestee(IRentalCategory rentalCategory, int days) {
        Customer customer = new Customer(CUSTOMER_NAME);
        Movie movie = new Movie(MOVIE_NAME, rentalCategory);
        Rental rental = new Rental(movie, days);
        customer.addRental(rental);
        return customer;
    }
}
