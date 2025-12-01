package com.qinghaotech.api;

import com.qinghaotech.application.Result;
import com.qinghaotech.application.model.PageQuery;
import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.command.ApplyCompanionCommand;
import com.qinghaotech.application.model.dto.CompanionDto;
import com.qinghaotech.application.model.dto.CompanionPageDto;
import com.qinghaotech.application.service.CompanionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 陪玩师API
 *
 * @author Jinx
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/companion")
public class CompanionController {

    private final CompanionService service;

    /**
     * 陪玩师分页
     *
     * @return 陪玩师简介分页
     */
    @GetMapping("/page")
    public Result<PageReply<CompanionPageDto>> page(PageQuery query) {
        return Result.succeed(service.page(query));
    }

    /**
     * 陪玩师详情
     *
     * @param id 陪玩师id
     * @return 陪玩师详情
     */
    @PutMapping("/detail")
    public Result<CompanionDto> detail(Integer id) {
        return Result.succeed(service.detail(id));
    }

    /**
     * 申请成为陪玩
     *
     * @param command 申请模型
     * @return void
     */
    @PostMapping("/apply")
    public Result<Void> apply(@RequestBody ApplyCompanionCommand command) {
        return Result.succeed(() -> service.apply(command));
    }
}
