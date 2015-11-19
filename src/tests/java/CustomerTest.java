import com.scrumtrek.simplestore.Customer;
import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.PriceCodes;
import com.scrumtrek.simplestore.Rental;
import org.junit.Assert;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Created by user on 19.11.2015.
 */
public class CustomerTest {

    @Test
    public void ShouldGetStatementWhenAddNewRelease(){
        Movie newRelease = new Movie("Gladiator", PriceCodes.NewRelease);
        Customer customer = new Customer("Mickey Mouse");
        Rental rental = new Rental(newRelease, 5);
        customer.addRental(rental);

        assertThat(customer.Statement()).isEqualTo(
                "Rental record for Mickey Mouse\n" +
                "\tGladiator\t15.0\n" +
                "Amount owed is 15.0\n" +
                "You earned 2 frequent renter points.");
    }

    @Test
    public void ShouldGetStatementWhenAddChildrenRelease(){
        Movie childrenRelease = new Movie("Gladiator", PriceCodes.Childrens);
        Customer customer = new Customer("Mickey Mouse");
        Rental rental = new Rental(childrenRelease, 5);
        customer.addRental(rental);

        assertThat(customer.Statement()).isEqualTo(
                "Rental record for Mickey Mouse\n" +
                        "\tGladiator\t3.0\n" +
                        "Amount owed is 3.0\n" +
                        "You earned 1 frequent renter points.");
    }

    @Test
    public void ShouldGetStatementWhenAddRegularRelease() {
        Movie regularRelease = new Movie("Gladiator", PriceCodes.Regular);
        Customer customer = new Customer("Mickey Mouse");
        Rental rental = new Rental(regularRelease, 5);
        customer.addRental(rental);

        assertThat(customer.Statement()).isEqualTo(
                "Rental record for Mickey Mouse\n" +
                        "\tGladiator\t6.5\n" +
                        "Amount owed is 6.5\n" +
                        "You earned 1 frequent renter points.");
    }
}
