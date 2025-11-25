package com.qinghaotech.api;

import com.qinghaotech.application.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 约定API
 *
 * @author Jinx
 */
@RestController
public class WellKnownController {

    @GetMapping("/ping")
    public Result<String> ping() {
        return Result.succeed("pong");
    }
}
