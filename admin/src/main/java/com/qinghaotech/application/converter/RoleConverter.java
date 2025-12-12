package com.qinghaotech.application.converter;

import com.qinghaotech.application.model.dto.RoleDetailDto;
import com.qinghaotech.application.model.dto.RoleSummaryDto;
import com.qinghaotech.domain.entity.role.Role;
import org.mapstruct.Mapper;

/**
 * @author Jinx
 */
@Mapper
public interface RoleConverter {

    RoleSummaryDto summaryConvert(Role role);

    RoleDetailDto detailConvert(Role role);
}
