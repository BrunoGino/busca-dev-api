package br.com.buscadevapi.model.converter;

import com.fasterxml.jackson.databind.util.StdConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateStringConverter extends StdConverter<LocalDate, String> {
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public String convert(LocalDate localDate) {
        return dateFormatter.format(localDate);
    }
}
