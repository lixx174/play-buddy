package com.qinghaotech.infra;

import com.qinghaotech.domain.service.IdGenerator;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Jinx
 */
@Component
public class InMemoryDailySequenceGenerator implements IdGenerator {

    private final AtomicLong seq = new AtomicLong(0);
    private LocalDate currentDate = LocalDate.now();

    @Override
    public String generateOrderNumber() {
        LocalDate today = LocalDate.now();

        // 并发问题
        if (!today.equals(currentDate)) {
            currentDate = today;
            seq.set(0);
        }

        String idPrefix = today.format(DateTimeFormatter.BASIC_ISO_DATE);
        return "%s%08d".formatted(idPrefix, seq.incrementAndGet());
    }
}
