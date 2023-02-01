package org.ujar.jh.petclinic.reactbdd.config;

import reactor.blockhound.BlockHound;
import reactor.blockhound.integration.BlockHoundIntegration;

public class JHipsterBlockHoundIntegration implements BlockHoundIntegration {

    @Override
    public void applyTo(BlockHound.Builder builder) {
        // Workaround until https://github.com/reactor/reactor-core/issues/2137 is fixed
        builder.allowBlockingCallsInside("reactor.core.scheduler.BoundedElasticScheduler$BoundedState", "dispose");
        builder.allowBlockingCallsInside("reactor.core.scheduler.BoundedElasticScheduler", "schedule");
        builder.allowBlockingCallsInside("org.springframework.validation.beanvalidation.SpringValidatorAdapter", "validate");
        builder.allowBlockingCallsInside("org.ujar.jh.petclinic.reactbdd.service.MailService", "sendEmailFromTemplate");
        builder.allowBlockingCallsInside("org.ujar.jh.petclinic.reactbdd.security.DomainUserDetailsService", "createSpringSecurityUser");
        builder.allowBlockingCallsInside("org.mariadb.r2dbc.message.client.HandshakeResponse", "writeConnectAttributes");
        builder.allowBlockingCallsInside("org.mariadb.r2dbc.client.MariadbPacketDecoder", "decode");
        builder.allowBlockingCallsInside("org.elasticsearch.client.indices.CreateIndexRequest", "settings");
    }
}
