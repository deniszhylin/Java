package by.group12.zhylin.task1.creator;

import by.group12.zhylin.task1.entity.Point;
import by.group12.zhylin.task1.entity.Tetrahedron;
import by.group12.zhylin.task1.exception.CustomException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class CreateTetrahedron {
    private static final Logger LOGGER = LogManager.getLogger();

    public ArrayList<Tetrahedron> createTetrahedronList(ArrayList<Double> arrayListDataPoints) throws CustomException {
        ArrayList<Tetrahedron> createdTetrahedronList = new ArrayList<>();
        if (arrayListDataPoints.isEmpty()) {
            LOGGER.log(Level.WARN, "List of points is empty!");
            throw new CustomException("List of points is empty!");
        } else {
            int count = 0;
            while (count < arrayListDataPoints.size()) {
                Point pointA = new Point(arrayListDataPoints.get(count++),
                        arrayListDataPoints.get(count++), arrayListDataPoints.get(count++));
                Point pointB = new Point(arrayListDataPoints.get(count++),
                        arrayListDataPoints.get(count++), arrayListDataPoints.get(count++));
                Tetrahedron tetrahedron = new Tetrahedron(pointA, pointB);
                createdTetrahedronList.add(tetrahedron);
                LOGGER.log(Level.INFO, "Figure created!");
            }
        }
        return createdTetrahedronList;
    }
}