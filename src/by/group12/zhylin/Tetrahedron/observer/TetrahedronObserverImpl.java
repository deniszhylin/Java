package by.group12.zhylin.Tetrahedron.observer;

import by.group12.zhylin.Tetrahedron.action.Calculation;
import by.group12.zhylin.Tetrahedron.entity.Tetrahedron;
import by.group12.zhylin.Tetrahedron.entity.TetrahedronProperty;
import by.group12.zhylin.Tetrahedron.register.TetrahedronPropertiesRegister;

public class TetrahedronObserverImpl implements TetrahedronObserver<Tetrahedron>{
    @Override
    public void update(Tetrahedron tetrahedron) {
        TetrahedronProperty tetrahedronProperty = new TetrahedronProperty(Calculation.calcAreaSurfaceTetrahedron(tetrahedron),
                Calculation.calcVolumeTetrahedron(tetrahedron));
        TetrahedronPropertiesRegister.getInstance().putTetrahedronToRegister(tetrahedron,tetrahedronProperty);
    }
}