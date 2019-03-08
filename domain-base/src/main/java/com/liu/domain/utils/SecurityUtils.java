package com.liu.domain.utils;

import com.google.common.base.Splitter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.util.Map;


public final class SecurityUtils {

    public static String getCurrentUserUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = null;
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
             currentUserName = authentication.getName();
             if(StringUtils.isNotEmpty(currentUserName) && StringUtils.contains(currentUserName,":")) {
                 currentUserName = Splitter.on(":").splitToList(currentUserName).get(1);
             }
        }
        return currentUserName ;
    }

    public static Long getCurrentUserId() {
        Map<String,Object> principal = (Map) ((OAuth2Authentication)SecurityContextHolder.getContext().getAuthentication()).getUserAuthentication().getDetails();
        Long currentUserId = null;
        if(principal != null) {
            Map<String,Object> userInfo = (Map)principal.get("principal");
            if (userInfo != null) {
                currentUserId = Long.valueOf(String.valueOf(userInfo.get("id")));
            }
        }
        return currentUserId ;
    }

}
