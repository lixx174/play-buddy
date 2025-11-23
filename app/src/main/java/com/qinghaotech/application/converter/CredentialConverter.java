package com.qinghaotech.application.converter;

import com.qinghaotech.application.model.dto.CredentialDto;
import com.qinghaotech.domain.primitive.Credential;
import org.mapstruct.Mapper;

/**
 * @author Jinx
 */
@Mapper
public interface CredentialConverter {

    CredentialDto convert(Credential credential);
}
