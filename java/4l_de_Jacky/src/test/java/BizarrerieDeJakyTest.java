import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BizarrerieDeJakyTest {

    private Mileage mileage;

    BizarrerieDeJaky bizzarrerieDeJaky;

    @Before
    public void setUp() throws Exception {
        bizzarrerieDeJaky = new BizarrerieDeJaky();
    }

    @Test
    public void should_return_false_if_mileage_is_not_birth_of_jaky() throws Exception {
        //Given
        mileage = new Mileage("10");

        //When
        final boolean instagrammable = bizzarrerieDeJaky.isInstagrammable(mileage);

        //Then
        assertFalse(instagrammable);

    }


    @Test
    public void should_return_true_if_mileage_is_birth_of_jaky() throws Exception {
        //Given
        mileage = new Mileage("01011970");

        //When
        final boolean instagrammable = bizzarrerieDeJaky.isInstagrammable(mileage);

        //Then
        assertTrue(instagrammable);
    }

    @Test
    public void should_return_true_if_mileage_is_birth_non_y2k_compliant_of_jaky() throws Exception {
        //Given
        mileage = new Mileage("010170");

        //When
        final boolean instagrammable = bizzarrerieDeJaky.isInstagrammable(mileage);

        //Then
        assertTrue(instagrammable);
    }

    @Test
    public void should_return_true_if_mileage_is_tribute_to_james_bond() throws Exception {
        //Given
        mileage = new Mileage("1007");

        //When
        final boolean instagrammable = bizzarrerieDeJaky.isInstagrammable(mileage);

        //Then
        assertTrue(instagrammable);
    }

    @Test
    public void should_return_true_if_mileage_is_really_licensed_to_kill() throws Exception {
        //Given
        Mileage zeroZeroOneMilage = new Mileage("001");

        //When
        final boolean instagrammable = bizzarrerieDeJaky.isInstagrammable(zeroZeroOneMilage);

        //Then
        assertTrue(instagrammable);
    }

    @Test
    public void should_return_true_if_mileage_is_ascending_figures() throws Exception {
        //Given
        Mileage zeroZeroOneMilage = new Mileage("123456789");

        //When
        final boolean instagrammable = bizzarrerieDeJaky.isInstagrammable(zeroZeroOneMilage);

        //Then
        assertTrue(instagrammable);
    }

    @Test
    public void should_return_true_if_mileage_is_ascending_figures_starting_from_4() throws Exception {
        //Given
        Mileage zeroZeroOneMilage = new Mileage("456789");

        //When
        final boolean instagrammable = bizzarrerieDeJaky.isInstagrammable(zeroZeroOneMilage);

        //Then
        assertTrue(instagrammable);
    }

    @Test
    public void should_return_false_if_mileage_is_not_strictly_ascending_figures() throws Exception {
        //Given
        mileage = new Mileage("122345");

        //When
        final boolean instagrammable = bizzarrerieDeJaky.isInstagrammable(mileage);

        //Then
        assertFalse(instagrammable);
    }

    @Test
    public void should_return_false_if_mileage_is_ascending_not_following_figures() throws Exception {
        //Given
        mileage = new Mileage("12356");

        //When
        final boolean instagrammable = bizzarrerieDeJaky.isInstagrammable(mileage);

        //Then
        assertFalse(instagrammable);
    }
}