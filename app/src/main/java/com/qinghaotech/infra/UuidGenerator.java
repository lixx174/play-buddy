package com.qinghaotech.infra;

import com.qinghaotech.domain.service.IdGenerator;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * @author Jinx
 */
@Component
public class UuidGenerator implements IdGenerator {

    @Override
    public String generateOrderNumber() {
        String prefix = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
        String part = UUID.randomUUID()
                .toString()
                .replace("-", "")
                .substring(0, 12);
        return prefix + part;
    }
}
