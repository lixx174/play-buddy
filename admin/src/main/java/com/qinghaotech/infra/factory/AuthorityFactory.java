package com.qinghaotech.infra.factory;

import com.qinghaotech.application.model.command.authority.CreateAuthorityCommand;
import com.qinghaotech.domain.entity.authority.Authority;
import com.qinghaotech.domain.exception.UnprocessableException;
import com.qinghaotech.domain.factory.EntityFactory;
import com.qinghaotech.domain.repository.AuthorityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * @author Jinx
 */
@Component
@RequiredArgsConstructor
public class AuthorityFactory implements EntityFactory<Authority> {

    private final AuthorityRepository authorityRepository;

    @Override
    public Authority create(@NonNull Object source, Consumer<Authority> callback) {
        return switch (source) {
            case CreateAuthorityCommand command -> doCreate(command, callback);
            default -> throw new UnprocessableException("不支持的类型: %s".formatted(source.getClass().getName()));
        };
    }

    public Authority doCreate(CreateAuthorityCommand command, Consumer<Authority> callback) {
        if (authorityRepository.isNameExisted(command.getName())) {
            throw new UnsupportedOperationException("名字: %s 已存在".formatted(command.getName()));
        }
        if (authorityRepository.isPermissionExisted(command.getPermission())) {
            throw new UnsupportedOperationException("权限标识: %s 已存在".formatted(command.getPermission()));
        }
        if (command.getParentId() != null) {
            authorityRepository.isExisted(command.getParentId());
        }

        Authority authority = Authority.builder()
                .parentId(command.getParentId())
                .name(command.getName())
                .type(command.getType())
                .path(command.getPath())
                .permission(command.getPermission())
                .sortNo(command.getSortNo())
                .build();

        callback.accept(authority);

        return authority;
    }
}
