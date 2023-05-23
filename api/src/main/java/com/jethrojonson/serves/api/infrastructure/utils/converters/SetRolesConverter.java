package com.jethrojonson.serves.api.infrastructure.utils.converters;

import com.jethrojonson.serves.api.domain.enums.UserRoles;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Converter
public class SetRolesConverter implements AttributeConverter<Set<UserRoles>, String> {

    private final String SEPARATOR= ",";


    @Override
    public String convertToDatabaseColumn(Set<UserRoles> attribute) {
        return !attribute.isEmpty() ?
                attribute.stream()
                        .map(UserRoles::name)
                        .collect(Collectors.joining(SEPARATOR))
                : null;
    }

    @Override
    public Set<UserRoles> convertToEntityAttribute(String dbData) {
        return dbData != null && !dbData.isBlank()?
                Arrays.stream(dbData.split(SEPARATOR))
                        .map(UserRoles::valueOf)
                        .collect(Collectors.toCollection(HashSet::new))
                : new HashSet<UserRoles>();
    }
}
