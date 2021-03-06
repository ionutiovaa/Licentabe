package be.manager.impl;

import be.dao.TokenDao;
import be.dto.TokenDTO;
import be.dtoEntityMappers.TokenDTOEntityMapper;
import be.entity.Token;
import be.manager.remote.TokenManagerRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TokenManager implements TokenManagerRemote {

    @Autowired
    private TokenDao tokenDao;

    @Override
    public TokenDTO findTokenByToken(String token) {
        Token tokenFound = tokenDao.findByToken(token);
        TokenDTO tokenDTO = TokenDTOEntityMapper.getDTOFromToken(tokenFound);
        return tokenDTO;
    }
}
