package com.formation.infotel.interfaces;

import java.util.List;

public interface Dao {

    public <T> T save(final T o);

    public void delete(final Object object);

    public <T> T get(final Class<T> type, final int id);

    public <T> T merge(final T o);

    public <T> void saveOrUpdate(final T o);

    public <T> List getAll(final Class<T> type);
}
