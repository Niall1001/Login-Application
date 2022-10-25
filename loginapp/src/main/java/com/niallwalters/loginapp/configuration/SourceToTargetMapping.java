package com.niallwalters.loginapp.configuration;

import org.modelmapper.PropertyMap;

public interface SourceToTargetMapping<T, U> {
    PropertyMap<T, U> mapFromSourceToTarget();
}
