import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline feline; // Шпион для проверки метода getFamily() класса Feline


    // Проверка работы метода eatMeat() класса Feline
    @Test
    public void eatMeatFelineTest() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline,Mockito.times(1)).getFood("Хищник");
    }

    // Проверка метода getKittens() класса Feline
    @Test
    public void getKittensWithoutArgsTest() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    // Проверка метода getKittens(int kittensCount) класса Feline
    @Test
    public void getKittensWithArgsTest() {
        int expected = 10;
        int actual = feline.getKittens(expected);
        Assert.assertEquals(expected, actual);
    }

    // проверка метода getFamily() класса Feline
    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        String actual = feline.getFamily();
        String expected = "Кошачьи";
        Assert.assertEquals(expected, actual);
    }

}
