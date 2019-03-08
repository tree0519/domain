package com.liu.domain.oauthserver.service;

import com.liu.domain.oauthserver.config.ResourceServerConfig;
import com.liu.domain.oauthserver.util.OauthConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * @author liuxinghong
 * @Description:
 * @date 2018/6/27/02718:26
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private RedisConnectionFactory connectionFactory;
    @Bean
    public RedisTokenStore tokenStore() {
        return new RedisTokenStore(connectionFactory);
    }
    @Autowired
    private StringRedisTemplate stringRedisTemplate;


//    @Override
//    public void logOut(String mobileId ,String type) {
//        Collection<OAuth2AccessToken> mobiles = tokenStore().findTokensByClientIdAndUserName("mobile",mobileId);
//        Collection<OAuth2AccessToken> tokens = tokenStore().findTokensByClientIdAndUserName("verification", mobileId);
//        List<OAuth2AccessToken> result = Lists.newArrayList();
//        if(!CollectionUtils.isEmpty(mobiles)) {
//            result.addAll(mobiles);
//        }
//        if (!CollectionUtils.isEmpty(tokens)){
//            result.addAll(tokens);
//        }
//        if(!CollectionUtils.isEmpty(result)){
//            for(OAuth2AccessToken token : result) {
//                tokenStore().removeAccessToken(token);
//            }
//        }
//        stringRedisTemplate.boundValueOps(ResourceServerConfig.USER_STATUS_KEY+mobileId).set(type,1, TimeUnit.DAYS);
//    }

    @Override
    public void cleanToken(String username) {
        Collection<OAuth2AccessToken>  tokens = tokenStore().findTokensByClientIdAndUserName(OauthConstants.CLIENT_ID_WEBAPP,username);
        for(OAuth2AccessToken token : tokens) {
            tokenStore().removeAccessToken(token);
        }
        stringRedisTemplate.boundValueOps(ResourceServerConfig.USER_STATUS_KEY+username).set("1",1, TimeUnit.DAYS);
    }
}
