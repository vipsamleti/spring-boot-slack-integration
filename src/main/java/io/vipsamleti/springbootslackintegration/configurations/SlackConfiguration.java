package io.vipsamleti.springbootslackintegration.configurations;

import com.hubspot.slack.client.SlackClient;
import com.hubspot.slack.client.SlackClientFactory;
import com.hubspot.slack.client.SlackClientRuntimeConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SlackConfiguration {

    @Value("${slack.api-token}")
    private String SLACK_API_TOKEN;

    @Bean
    public SlackClient getSlackClient(){

        SlackClientRuntimeConfig runtimeConfig = SlackClientRuntimeConfig.builder()
                                                .setTokenSupplier(() -> SLACK_API_TOKEN)
                                                .build();

        return SlackClientFactory.defaultFactory().build(runtimeConfig);
    }
}
