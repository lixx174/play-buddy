package com.qinghaotech.application.converter;

import com.qinghaotech.application.model.dto.AuthorityDetailDto;
import com.qinghaotech.application.model.dto.AuthoritySummaryDto;
import com.qinghaotech.application.model.dto.AuthorityTreeDto;
import com.qinghaotech.infra.repository.persistence.model.AuthorityDo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Collection;

/**
 * @author Jinx
 */
@Mapper
public interface AuthorityConverter {

    @Mappings({
            @Mapping(target = "type", source = "resource.type"),
            @Mapping(target = "path", source = "resource.path"),
    })
    AuthoritySummaryDto summaryConvert(AuthorityDo authorityDo);

    Collection<AuthoritySummaryDto> summaryConvert(Collection<AuthorityDo> authorityDos);

    @Mappings({
            @Mapping(target = "type", source = "resource.type"),
            @Mapping(target = "path", source = "resource.path"),
    })
    AuthorityDetailDto detailConvert(AuthorityDo authorityDo);

    AuthorityTreeDto treeConvert(AuthorityDo authorityDo);

    Collection<AuthorityTreeDto> treeConvert(Collection<AuthorityDo> authorityDos);
}
