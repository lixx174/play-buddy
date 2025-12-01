package com.qinghaotech.api;

import com.qinghaotech.application.Result;
import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.command.CreateUserCommand;
import com.qinghaotech.application.model.command.ModifyUserCommand;
import com.qinghaotech.application.model.dto.UserDto;
import com.qinghaotech.application.model.query.UserPageQuery;
import com.qinghaotech.application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * 后台用户管理API
 *
 * @author Jinx
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    /**
     * 分页
     *
     * @param query 分页条件
     * @return 系统用户用户分页信息
     */
    @GetMapping("/page")
    public Result<PageReply<UserDto>> page(UserPageQuery query) {
        return Result.succeed(service.page(query));
    }

    /**
     * 详情
     *
     * @param id 系统用户id
     * @return 系统用户详情
     */
    @GetMapping("/detail")
    public Result<UserDto> detail(Integer id) {
        return Result.succeed(service.detail(id));
    }

    /**
     * 新增
     *
     * @param command 系统用户新增模型
     * @return void
     */
    @PostMapping("/create")
    public Result<Void> create(@RequestBody CreateUserCommand command) {
        return Result.succeed(() -> service.create(command));
    }

    /**
     * 修改
     *
     * @param command 系统用户修改模型
     * @return void
     */
    @PostMapping("/modify")
    public Result<Void> modify(@RequestBody ModifyUserCommand command) {
        return Result.succeed(() -> service.modify(command));
    }

    /**
     * 删除
     *
     * @param ids 系统用户id数组
     * @return void
     */
    @DeleteMapping("/remove")
    public Result<Void> remove(@RequestBody Collection<Integer> ids) {
        return Result.succeed(() -> service.remove(ids));
    }

    /**
     * 登录系统用户个人信息
     *
     * @return 个人信息
     */
    @GetMapping("/profile")
    public Result<UserDto> profile() {
        return Result.succeed(service.profile());
    }
}
