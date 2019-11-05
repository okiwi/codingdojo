import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SoundexTest {

    private Soundex soundex;

    @BeforeEach
    void setUp() {
        soundex = new Soundex();
    }

    private void assertSoundex(String word, String soundexValue) {
        assertThat(soundex.compute(word)).isEqualTo(soundexValue);
    }

    private void assertSoundex2(String word, String soundexValue) {
        assertThat(soundex.compute2(word)).isEqualTo(soundexValue);
    }

    @Test
    void first_test_robert_2() {
        assertSoundex2("Robert", "R163");
    }

    @Test
    void first_test_robert_with_space_2() {
        assertSoundex2("R  ob  ert   ", "R163");
    }

    @Test
    void test_bebastien_2() {
        assertSoundex2("Bebastien", "B183");
    }

    @Test
    void test_sebastien_2() {
        assertSoundex2("Sebastien", "S183");
    }

    @Test
    void test_sebastien_with_space_2() {
        assertSoundex2("Sebast   ien   ", "S183");
    }

    @Test
    void test_sebastien_with_even_more_space_2() {
        assertSoundex2("S  eb   ast   ien   ", "S183");
    }


    @Test
    void test_char_uppercased_2() {
        assertSoundex2("sebastien", "S183");
    }

    @Test
    void test_sbastien_return_183_2() {
        assertSoundex2("sbastien", "S183");
    }

    @Test
    void test_edouard_return_E363_2() {
        assertSoundex2("edouard", "E363");
    }

    @Test
    void test_edouardaeiouywh_return_E363_2() {
        assertSoundex2("edouardaeiouywh", "E363");
    }

    @Test
    void test_sepastien_return_183_2() {
        assertSoundex2("spastien", "S183");
    }

    @Test
    void test_etouard_return_E363_2() {
        assertSoundex2("etouard", "E363");
    }
}