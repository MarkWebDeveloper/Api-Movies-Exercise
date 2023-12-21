package dev.mark.apimovies.services;

import java.util.List;

public interface IGenericService<T> {
    public List<T> getAll();
    public T getById();
    public T save();
    public T update();
    public String delete();
}
