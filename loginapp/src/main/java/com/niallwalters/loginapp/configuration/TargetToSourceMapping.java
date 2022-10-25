package com.niallwalters.loginapp.configuration;

import org.modelmapper.PropertyMap;

public interface TargetToSourceMapping<T, U> {
    PropertyMap<T, U> mapFromTargetToSource();
}
