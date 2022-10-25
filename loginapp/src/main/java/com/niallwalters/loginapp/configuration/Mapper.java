package com.niallwalters.loginapp.configuration;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Mapper extends ModelMapper {
    public <D, T> List<D> map(final Iterable<T> entityList, Class<D> outCLass) {
        Objects.requireNonNull(entityList);
        Objects.requireNonNull(outCLass);
        return StreamSupport.stream(entityList.spliterator(), true)
                .map(entity -> map(entity, outCLass))
                .collect(Collectors.toList());
    }

    public <D, T> Set<D> map(final Set<T> entityList, Class<D> outCLass) {
        Objects.requireNonNull(entityList);
        Objects.requireNonNull(outCLass);
        return entityList.stream()
                .map(entity -> map(entity, outCLass))
                .collect(Collectors.toSet());
    }
}
