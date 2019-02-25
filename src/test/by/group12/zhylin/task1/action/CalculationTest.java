package test.by.group12.zhylin.task1.action;

import by.group12.zhylin.task1.action.Calculation;
import by.group12.zhylin.task1.entity.Point;
import by.group12.zhylin.task1.entity.Tetrahedron;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class CalculationTest {

    Calculation calculation;
    Tetrahedron tetrahedron;
    Point pointA;
    Point pointB;

    @BeforeClass
    public void setUp() {
        calculation = new Calculation();
        pointA = new Point(1.3, 1.5, 1);
        pointB = new Point(2.1, 2, 2.8);
        tetrahedron = new Tetrahedron(pointA, pointB);
    }

    @AfterClass
    public void tierDown() {
        calculation = null;
        tetrahedron = null;
        pointA = null;
        pointB = null;
    }

    @Test(description = "calcRibTetrahedron metod test1")
    public void calcRibTetrahedronTest1() {
        double actualRezult = calculation.calcRibTetrahedron(1,1,2,2,3,3);
        double expectedRezult = 1;
        Assert.assertEquals(expectedRezult, actualRezult, "Not correct parameter");
    }
    @Test(description = "calcRibTetrahedron metod test2")
    public void calcRibTetrahedronTest2() {
        double actualRezult = calculation.calcRibTetrahedron(1,2,3,4,5,6);
        double expectedRezult = 1.7320508075688772;
        Assert.assertEquals(expectedRezult, actualRezult, "Not correct parameter");
    }

    @Test(description = "Aria Tetrahedron metod test")
    public void calcAreaSurfaceTest() {
        double actualRezult = calculation.calcAreaSurfaceTetrahedron(tetrahedron);
        double expectedRezult = 7.15;
        Assert.assertEquals(expectedRezult, actualRezult, "Not correct parameter");
    }

    @Test(description = "Volume Tetrahedron metod test")
    public void calcVolumeTest() {
        double actualRezult = calculation.calcVolumeTetrahedron(tetrahedron);
        double expectedRezult = 0.99;
        Assert.assertEquals(expectedRezult, actualRezult, " Not correct ");
    }
}