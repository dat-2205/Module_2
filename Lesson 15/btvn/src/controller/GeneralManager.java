package controller;

public interface GeneralManager <T>{
    void showAll();
    void addNew(T t);
    void update(String id, T t);
    void remove(String id);
}
