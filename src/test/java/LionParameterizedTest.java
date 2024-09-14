import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class LionParameterizedTest {
    private final String sex;
    private final boolean expected;

    // Создали конструктор, который принимает параметры для параметризованного теста
    public LionParameterizedTest(String sex, boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }

    // Создали двумерный массив с двумя наборами параметров
    @Parameterized.Parameters
    public static Object[][] getHasManeValue() {
        return new Object[][] {
                {"Самка", false},
                {"Самец", true},
        };
    }

    // Проверка работы метода doesHaveMane() в классе Lion
    @Test
    public void valueLionManeTest() throws Exception {
        Lion lion = new Lion(sex, null);
        boolean actual = lion.doesHaveMane();
        Assert.assertEquals(expected, actual);
    }


}
