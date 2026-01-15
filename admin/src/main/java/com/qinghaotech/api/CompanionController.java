package com.qinghaotech.api;

import com.qinghaotech.application.Result;
import com.qinghaotech.application.model.PageQuery;
import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.command.CreateCompanionCommand;
import com.qinghaotech.application.model.command.ModifyCompanionCommand;
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
 * 陪玩师管理 API
 *
 * @author Jinx
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/companion")
public class CompanionController {

    private final CompanionService service;

    /**
     * 分页
     *
     * @return 陪玩师简介分页
     */
    @GetMapping("/page")
    public Result<PageReply<CompanionPageDto>> page(PageQuery query) {
        return Result.succeed(service.page(query));
    }

    /**
     * 详情
     *
     * @param id 陪玩师唯一标识
     * @return 陪玩师详情
     */
    @PutMapping("/detail")
    public Result<CompanionDto> detail(Integer id) {
        return Result.succeed(service.detail(id));
    }


    /**
     * 新增
     *
     * @param command 陪玩师新增模型
     * @return void
     */
    @PostMapping("/create")
    public Result<Void> create(@RequestBody CreateCompanionCommand command) {
        return Result.succeed(() -> service.create(command));
    }

    /**
     * 修改
     *
     * @param command 陪玩师修改模型
     * @return void
     */
    @PostMapping("/create")
    public Result<Void> modify(@RequestBody ModifyCompanionCommand command) {
        return Result.succeed(() -> service.modify(command));
    }
}
