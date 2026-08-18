package ph.edu.dlsu.lbycpob.lakbay.service;

import java.util.List;

public interface GenericService<T> {
    void add(T item);
    List<T> getAll();
}