package model;

public class Classes {
    private String id;
    private String className;

    public Classes() {
    }

    public Classes(String id, String className) {
        this.id = id;
        this.className = className;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Classes: " +
                "id='" + id + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
