package com.qinghaotech.api;

import com.qinghaotech.application.Result;
import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.command.authority.CreateAuthorityCommand;
import com.qinghaotech.application.model.command.authority.ModifyAuthorityCommand;
import com.qinghaotech.application.model.dto.AuthorityDetailDto;
import com.qinghaotech.application.model.dto.AuthoritySummaryDto;
import com.qinghaotech.application.model.query.AuthorityPageQuery;
import com.qinghaotech.application.service.AuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * 权限管理 API
 *
 * @author Jinx
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/authority")
public class AuthorityController {

    private final AuthorityService service;

    /**
     * 分页
     *
     * @param query 分页条件
     * @return 权限分页信息
     */
    @GetMapping("/page")
    public Result<PageReply<AuthoritySummaryDto>> page(AuthorityPageQuery query) {
        return Result.succeed(service.page(query));
    }

    /**
     * 详情
     *
     * @param id 系统权限唯一标识
     * @return 权限详情
     */
    @GetMapping("/detail")
    public Result<AuthorityDetailDto> detail(Integer id) {
        return Result.succeed(service.detail(id));
    }

    /**
     * 新增
     *
     * @param command 权限新增模型
     * @return void
     */
    @PostMapping("/create")
    public Result<Void> create(@RequestBody CreateAuthorityCommand command) {
        return Result.succeed(() -> service.create(command));
    }

    /**
     * 修改
     *
     * @param command 权限修改模型
     * @return void
     */
    @PostMapping("/modify")
    public Result<Void> modify(@RequestBody ModifyAuthorityCommand command) {
        return Result.succeed(() -> service.modify(command));
    }

    /**
     * 删除
     *
     * @param ids 权限唯一标识数组
     * @return void
     */
    @DeleteMapping("/remove")
    public Result<Void> remove(@RequestBody Set<Integer> ids) {
        return Result.succeed(() -> service.remove(ids));
    }
}
