import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    // Мокируем объект класса feline
    @Mock
    Feline feline;

    private String sex;
    private String invalidSex;

    @Before
    public void setUp() {
        sex = "Самка";
        invalidSex = "Test";
    }


    // Проверяем метод getKittens() класса Lion
    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    // Проверяем метод getFood() класса Lion
    @Test
    public void getFoodLionTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    // Проверяем корректную обработку исключений в конструкторе Lion
    @Test
    public void lionExceptionTest() throws Exception {
        String message = "Используйте допустимые значения пола животного - самец или самка";
        try {
            new Lion(invalidSex, feline);
            // Если исключение не выбрасывается, тест не должен пройти
            Assert.fail("Исключение не было выброшено");
        } catch (Exception exception) {
            Assert.assertEquals(message, exception.getMessage());
        }

    }
}
