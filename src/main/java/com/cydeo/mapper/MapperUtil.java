package com.cydeo.mapper;

import org.modelmapper.ModelMapper;

import java.lang.reflect.Type;
import java.rmi.MarshalledObject;

public class MapperUtil {

    private final ModelMapper modelMapper;

    public MapperUtil(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <T> T convert(Object objectToConvert, T convertedObject){
        return modelMapper.map(objectToConvert, (Type) convertedObject.getClass());
    }
}
