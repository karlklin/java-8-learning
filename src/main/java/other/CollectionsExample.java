package other;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class MyCar {
    private String name;

    public MyCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyCar myCar = (MyCar) o;

        return name != null ? name.equals(myCar.name) : myCar.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}

public class

CollectionsExample {

    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();

        treeSet.add("A");
        treeSet.add("C");
        treeSet.add("B");

        System.out.println(treeSet);

        Map<String, MyCar> name2CarMap = new HashMap<>();
        MyCar carA = new MyCar("a");
        name2CarMap.put("a", carA);
        name2CarMap.put("b", new MyCar("b"));
        name2CarMap.put("c", new MyCar("c"));

        System.out.println(name2CarMap);
        System.out.println(name2CarMap.get("a") == carA);

        // if we remove hashCode from MyCar then equaled objects are stored under different hashCode and the HashMap doesn't fulfil its contract and

        Map<MyCar, String> car2NameMap = new HashMap<>();
        MyCar newCarA = new MyCar("a");

        car2NameMap.put(carA, "carAName");
        car2NameMap.put(newCarA, "carANewName");

        System.out.println(car2NameMap);
        System.out.println(car2NameMap.get(carA));
        System.out.println(car2NameMap.get(newCarA));
    }
}
