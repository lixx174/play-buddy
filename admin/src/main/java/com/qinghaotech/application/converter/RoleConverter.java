package com.qinghaotech.application.converter;

import com.qinghaotech.application.model.dto.AuthorityTreeDto;
import com.qinghaotech.application.model.dto.RoleDetailDto;
import com.qinghaotech.application.model.dto.RoleSummaryDto;
import com.qinghaotech.infra.repository.persistence.model.RoleDo;
import org.mapstruct.Mapper;

import java.util.Collection;

/**
 * @author Jinx
 */
@Mapper
public interface RoleConverter {

    RoleSummaryDto summaryConvert(RoleDo role);

    Collection<RoleSummaryDto> summaryConvert(Collection<RoleDo> roleDos);

    RoleDetailDto detailConvert(RoleDo role, Collection<AuthorityTreeDto> authorities);
}
