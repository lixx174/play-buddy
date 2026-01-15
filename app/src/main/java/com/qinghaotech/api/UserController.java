package com.qinghaotech.api;

import com.qinghaotech.application.Result;
import com.qinghaotech.application.model.command.ModifyUserCommand;
import com.qinghaotech.application.model.dto.UserDto;
import com.qinghaotech.application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户 API
 *
 * @author Jinx
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    /**
     * 登录用户个人信息
     *
     * @return 个人信息
     */
    @GetMapping("/profile")
    public Result<UserDto> profile() {
        return Result.succeed(service.profile());
    }

    /**
     * 修改用户信息
     *
     * @param command 个人信息修改命令
     * @return Void
     * @apiNote 一般用于微信信息同步，也可以自定义。
     */
    @PutMapping("/modify")
    public Result<Void> modify(@RequestBody ModifyUserCommand command) {
        return Result.succeed(() -> service.modify(command));
    }
}
