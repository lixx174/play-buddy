package com.qinghaotech.application.service;

import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.command.role.CreateRoleCommand;
import com.qinghaotech.application.model.command.role.ModifyRoleCommand;
import com.qinghaotech.application.model.dto.RoleDetailDto;
import com.qinghaotech.application.model.dto.RoleSummaryDto;
import com.qinghaotech.application.model.query.RolePageQuery;
import com.qinghaotech.application.repository.RoleQueryRepository;
import com.qinghaotech.domain.entity.role.Role;
import com.qinghaotech.domain.repository.AuthorityRepository;
import com.qinghaotech.domain.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author Jinx
 */
@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleQueryRepository roleQueryRepository;
    private final RoleRepository roleRepository;
    private final AuthorityRepository authorityRepository;


    public PageReply<RoleSummaryDto> page(RolePageQuery query) {
        return roleQueryRepository.findAll(query);
    }


    public RoleDetailDto detail(Integer id) {
        return roleQueryRepository.findById(id);
    }

    public void create(CreateRoleCommand command) {
        var authorities = authorityRepository.findByIdsOrElseThrow(command.getAuthorityIds());

        Role role = new Role(command.getName(), command.getRemark(), authorities);
        roleRepository.save(role);
    }

    public void modify(ModifyRoleCommand command) {
        Role role = roleRepository.findByIdOrElseThrow(command.getId());
        var authorities = authorityRepository.findByIdsOrElseThrow(command.getAuthorityIds());

        role.changeProfile(command.getName(), command.getRemark());
        role.changeAuthorities(authorities);
        role.changeStatus(command.getStatus());

        roleRepository.save(role);
    }

    public void remove(Set<Integer> ids) {
        var roles = roleRepository.findByIdsOrElseThrow(ids);
        roleRepository.remove(roles);
    }
}
