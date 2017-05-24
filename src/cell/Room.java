package cell;

import constraints.Constraint;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ionutciuta24@gmail.com on 24.05.2017.
 */
public class Room {
    private int id;
    private Set<Equipment> equipments;
    private int size;

    public Room(int id, int size) {
        this.id = id;
        this.size = size;
        this.equipments = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Set<Equipment> getEquipments() {
        return equipments;
    }

    private void addEquipment(Equipment equipment) {
        this.equipments.add(equipment);
    }

    private boolean hasEquipment(Equipment equipment) {
        return this.equipments.contains(equipment);
    }

    @Override
    public String toString() {
        return "Room: " + "id=" + id + ", equipments=" + equipments + ", size=" + size;
    }
}
