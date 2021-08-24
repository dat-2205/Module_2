public class NhanVien extends CanBo {
    private int level;

    public NhanVien() {
    }

    public NhanVien(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "name= " + getName() +
                ", birthday= " + getBirthDay() +
                ", sex= " + getSex() +
                ", address= " + getAddress() +
                ", level= " + level +
                '}';
    }
}
