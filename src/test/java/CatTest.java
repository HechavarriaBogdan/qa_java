import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    // Мокируем объект класса feline
    @Mock
    Feline feline;

    // Проверяем метод getFood() класса Cat
    @Test
    public void getFoodTest() throws Exception {
        Cat cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }

    // Проверяем метод getSound() класса Cat
    @Test
    public void getSoundTest() {
        Cat cat = new Cat(feline);
        String actual = cat.getSound();
        Assert.assertEquals("Мяу", actual);
    }

}
