package com.qinghaotech.api;

import com.qinghaotech.application.Result;
import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.command.role.CreateRoleCommand;
import com.qinghaotech.application.model.command.role.ModifyRoleCommand;
import com.qinghaotech.application.model.dto.RoleDetailDto;
import com.qinghaotech.application.model.dto.RoleSummaryDto;
import com.qinghaotech.application.model.query.RolePageQuery;
import com.qinghaotech.application.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * 角色管理 API
 *
 * @author Jinx
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
public class RoleController {

    private final RoleService service;

    /**
     * 分页
     *
     * @param query 分页条件
     * @return 系统角色分页信息
     */
    @GetMapping("/page")
    public Result<PageReply<RoleSummaryDto>> page(RolePageQuery query) {
        return Result.succeed(service.page(query));
    }

    /**
     * 详情
     *
     * @param id 系统角色唯一标识
     * @return 系统角色详情
     */
    @GetMapping("/detail")
    public Result<RoleDetailDto> detail(Integer id) {
        return Result.succeed(service.detail(id));
    }

    /**
     * 新增
     *
     * @param command 系统角色新增模型
     * @return void
     */
    @PostMapping("/create")
    public Result<Void> create(@RequestBody CreateRoleCommand command) {
        return Result.succeed(() -> service.create(command));
    }

    /**
     * 修改
     *
     * @param command 系统角色修改模型
     * @return void
     */
    @PostMapping("/modify")
    public Result<Void> modify(@RequestBody ModifyRoleCommand command) {
        return Result.succeed(() -> service.modify(command));
    }

    /**
     * 删除
     *
     * @param ids 系统角色唯一标识数组
     * @return void
     */
    @DeleteMapping("/remove")
    public Result<Void> remove(@RequestBody Set<Integer> ids) {
        return Result.succeed(() -> service.remove(ids));
    }
}
