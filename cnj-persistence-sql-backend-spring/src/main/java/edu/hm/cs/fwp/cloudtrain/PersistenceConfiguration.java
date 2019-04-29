package edu.hm.cs.fwp.cloudtrain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.security.Principal;
import java.util.Optional;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
@EnableJpaAuditing
public class PersistenceConfiguration {

    @Bean
    public AuditorAware<String> auditorAware() {
        return new SpringSecurityBasedAuditorAware();
    }

    private static class SpringSecurityBasedAuditorAware implements AuditorAware<String> {

        @Override
        public Optional<String> getCurrentAuditor() {
            Optional<String> result = Optional.of("anonymous");
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication.isAuthenticated()) {
                Principal principal = (Principal) authentication.getPrincipal();
                result = Optional.of(principal.getName());
            }
            return result;
        }
    }
}
