package by.group12.zhylin.Tetrahedron.register;

import by.group12.zhylin.Tetrahedron.entity.Tetrahedron;
import by.group12.zhylin.Tetrahedron.entity.TetrahedronProperty;

import java.util.HashMap;
import java.util.Map;

public class TetrahedronPropertiesRegister {
    private Map<Long, TetrahedronProperty> TetrahedronPropertiesMap = new HashMap<>();
    private static TetrahedronPropertiesRegister instance = new TetrahedronPropertiesRegister();

    private TetrahedronPropertiesRegister() {
    }

    public static TetrahedronPropertiesRegister getInstance() {
        return instance;
    }

    public void putTetrahedronToRegister(Tetrahedron tetrahedron, TetrahedronProperty tetrahedronProperty) {
        TetrahedronPropertiesMap.put(tetrahedron.getIdTetrahedron(), tetrahedronProperty);
    }
}
