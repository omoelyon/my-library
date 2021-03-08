package com.adeola.libraryapp.mylibrary.interfaces;

import java.util.List;

public interface Search<T, R> {
    public List<R> search(T t);
}
