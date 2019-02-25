package by.group12.zhylin.task1.action;

import by.group12.zhylin.task1.entity.Tetrahedron;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculation {

    private static final Logger LOGGER = LogManager.getLogger();

    public static double calcRibTetrahedron(double x1, double x2, double y1, double y2, double z1, double z2) {
        double ribTetrahedrom;
        if (x1 == x2 && y1 == y2 && z1 == z2) {
            LOGGER.log(Level.INFO, "The edge of figure cannot be negative!");
            return ribTetrahedrom = 1;
        } else {
            ribTetrahedrom = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) + Math.pow(z2 - z1, 2));
        }
        return ribTetrahedrom;
    }

    public static double calcAreaSurfaceTetrahedron(Tetrahedron tetrahedron) {
        double AreaSurfaceTetrahedron = Math.pow(calcRibTetrahedron(tetrahedron.getPointA().getX(),
                tetrahedron.getPointB().getX(), tetrahedron.getPointA().getY(), tetrahedron.getPointB().getY(),
                tetrahedron.getPointA().getZ(), tetrahedron.getPointB().getZ()), 2) * Math.sqrt(3);
        BigDecimal bd = new BigDecimal(AreaSurfaceTetrahedron);
        AreaSurfaceTetrahedron = (bd.setScale(2, RoundingMode.HALF_UP)).doubleValue();
        return AreaSurfaceTetrahedron;
    }

    public static double calcVolumeTetrahedron(Tetrahedron tetrahedron) {
        double VolumeTetrahedron = Math.pow(calcRibTetrahedron(tetrahedron.getPointA().getX(),
                tetrahedron.getPointB().getX(), tetrahedron.getPointA().getY(), tetrahedron.getPointB().getY(),
                tetrahedron.getPointA().getZ(), tetrahedron.getPointB().getZ()), 3) * Math.sqrt(2) / 12;
        BigDecimal bd = new BigDecimal(VolumeTetrahedron);
        VolumeTetrahedron = (bd.setScale(2, RoundingMode.HALF_UP)).doubleValue();
        return VolumeTetrahedron;
    }
}