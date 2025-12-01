package com.qinghaotech.api;

import com.qinghaotech.application.Result;
import com.qinghaotech.application.model.command.CreateOrderCommand;
import com.qinghaotech.application.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单API
 *
 * @author Jinx
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService service;

    /**
     * 陪玩下单
     *
     * @return 陪玩师简介分页
     */
    @GetMapping("/create")
    public Result<Void> create(@RequestBody CreateOrderCommand command) {
        return Result.succeed(() -> service.create(command));
    }
}
