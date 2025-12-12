package com.qinghaotech.application.service;

import com.qinghaotech.application.model.PageReply;
import com.qinghaotech.application.model.command.authority.CreateAuthorityCommand;
import com.qinghaotech.application.model.command.authority.ModifyAuthorityCommand;
import com.qinghaotech.application.model.dto.AuthorityDetailDto;
import com.qinghaotech.application.model.dto.AuthoritySummaryDto;
import com.qinghaotech.application.model.query.AuthorityPageQuery;
import com.qinghaotech.application.repository.AuthorityQueryRepository;
import com.qinghaotech.domain.entity.authority.Authority;
import com.qinghaotech.domain.factory.EntityFactory;
import com.qinghaotech.domain.repository.AuthorityRepository;
import com.qinghaotech.domain.service.AuthorityDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

/**
 * @author Jinx
 */
@Service
@RequiredArgsConstructor
public class AuthorityService {

    private final AuthorityQueryRepository authorityQueryRepository;
    private final AuthorityRepository authorityRepository;
    private final EntityFactory<Authority> entityFactory;
    private final AuthorityDomainService authorityDomainService;

    public PageReply<AuthoritySummaryDto> page(AuthorityPageQuery query) {
        return authorityQueryRepository.findAll(query);
    }

    public AuthorityDetailDto detail(Integer id) {
        return authorityQueryRepository.findById(id);
    }

    public void create(CreateAuthorityCommand command) {
        Authority authority = entityFactory.create(command);
        authorityRepository.save(authority);
    }

    public void modify(ModifyAuthorityCommand command) {
        Authority authority = authorityRepository.findByIdOrElseThrow(command.getId());

        authority.reassignParent(command.getParentId(), authorityRepository::isExisted);
        authority.rename(command.getName(), authorityRepository::isNameExisted);
        authority.changeResource(command.getType(), command.getPath());
        authority.changePermission(command.getName(), authorityRepository::isPermissionExisted);
        authority.reorder(command.getSortNo());

        authorityRepository.save(authority);
    }

    public void remove(Set<Integer> ids) {
        Collection<Authority> authorities = authorityRepository.findByIds(ids);
        authorityDomainService.remove(authorities);
    }
}
