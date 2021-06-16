package com.hedgeness.app.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class HedgenessAppAuditor implements AuditorAware<String> {

    /**
     * Returns the current auditor of the application.
     *
     * @return the current auditor
     */
    @Override
    public String getCurrentAuditor() {
        if(SecurityContextHolder.getContext().getAuthentication()!=null){
            return SecurityContextHolder.getContext().getAuthentication().getName();
        }else {
            return null;
        }

    }
}
