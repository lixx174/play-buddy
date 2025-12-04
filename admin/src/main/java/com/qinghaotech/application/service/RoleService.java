package com.qinghaotech.application.service;

import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.command.role.CreateRoleCommand;
import com.qinghaotech.application.model.command.role.ModifyRoleCommand;
import com.qinghaotech.application.model.dto.RoleDto;
import com.qinghaotech.application.model.query.RolePageQuery;
import com.qinghaotech.application.repository.UserQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author Jinx
 */
@Service
@RequiredArgsConstructor
public class RoleService {


    private final UserQueryRepository userQueryRepository;


    public PageReply<RoleDto> page(RolePageQuery query) {
        return null;
    }


    public RoleDto detail(Integer id) {
        return null;
    }

    public void create(CreateRoleCommand command) {

    }

    public void modify(ModifyRoleCommand command) {

    }

    public void remove(Collection<Integer> ids) {

    }
}
