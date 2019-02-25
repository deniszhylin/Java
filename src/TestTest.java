
import java.util.Objects;

public class TestTest {
    private String a;
    private Long b;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestTest testTest = (TestTest) o;
        return Objects.equals(a, testTest.a) &&
                Objects.equals(b, testTest.b);
    }

    @Override
    public int hashCode() {

        return Objects.hash(a, b);
    }
}
