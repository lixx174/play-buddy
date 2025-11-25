package com.qinghaotech.domain.primitive;

import java.time.LocalDateTime;

/**
 * @author Jinx
 */
@Deprecated
public class Audit {

    private LocalDateTime createAt;
    private LocalDateTime createBy;
    private LocalDateTime modifyAt;
    private LocalDateTime modifyBy;
}
