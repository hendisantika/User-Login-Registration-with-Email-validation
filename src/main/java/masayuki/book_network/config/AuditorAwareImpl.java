package masayuki.book_network.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : User-Login-Registration-with-Email-validation
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 01/06/24
 * Time: 14.06
 * To change this template use File | Settings | File Templates.
 */
@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Medium");

        /*
        Some basic examples to get the logged-in user's id
        if you're using Spring Security.

        -- Example 1:
        return Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .filter(Authentication::isAuthenticated)
                .map(Authentication::getPrincipal)
                .map(User.class::cast)
                .map(User::getUsername);

        -- Example 2:
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String auditor = "System";

        if (Objects.nonNull(authentication)) {
            auditor = authentication.getName();

            if (auditor.equals("anonymousUser")) {
                return Optional.of("System");
            }
        }

        return Optional.of(auditor);

         */
    }
}
