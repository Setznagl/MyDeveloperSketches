import java.util.Objects;

public class AnimalClass implements Cloneable {
    String name;
    int age;
    public AnimalClass(String name , int age) {
        this.name = name;
        this.age = age;
    }

    String getName() {return name;}
    int getAge() {return age;}

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) { this.age = age; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AnimalClass that = (AnimalClass) o;
        return getAge() == that.getAge() && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

    @Override
    public AnimalClass clone() {
        try {
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return (AnimalClass) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

