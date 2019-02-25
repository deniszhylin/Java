package by.group12.zhylin.task1.observer;

import by.group12.zhylin.task1.action.Calculation;
import by.group12.zhylin.task1.entity.Tetrahedron;
import by.group12.zhylin.task1.entity.TetrahedronProperty;
import by.group12.zhylin.task1.register.TetrahedronPropertiesRegister;

public class TetrahedronObserverImpl implements TetrahedronObserver<Tetrahedron>{
    @Override
    public void update(Tetrahedron tetrahedron) {
        TetrahedronProperty tetrahedronProperty = new TetrahedronProperty(Calculation.calcAreaSurfaceTetrahedron(tetrahedron),
                Calculation.calcVolumeTetrahedron(tetrahedron));
        TetrahedronPropertiesRegister.getInstance().putTetrahedronToRegister(tetrahedron,tetrahedronProperty);
    }
}