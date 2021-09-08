package controller;

public interface ManagementInterface<T> {
    void add(T t);
    void update(int index, T t);
    void delete(String id);
    void showAll();
    int findById(String id);

}
