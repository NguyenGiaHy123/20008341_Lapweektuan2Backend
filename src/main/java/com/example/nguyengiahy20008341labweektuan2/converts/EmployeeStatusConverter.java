package com.example.nguyengiahy20008341labweektuan2.converts;

import com.example.nguyengiahy20008341labweektuan2.models.IEmployee;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;


@Converter(autoApply = true)
public class EmployeeStatusConverter implements AttributeConverter<IEmployee, Integer> {
    @Override
    public Integer convertToDatabaseColumn(IEmployee attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getValue();
    }
    @Override
    public IEmployee convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }
        return Stream.of(IEmployee.values())
                .filter(c -> c.getValue() == dbData)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
