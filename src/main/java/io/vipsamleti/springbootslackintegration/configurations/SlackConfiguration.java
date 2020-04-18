package io.vipsamleti.springbootslackintegration.configurations;

import com.hubspot.slack.client.SlackClient;
import com.hubspot.slack.client.SlackClientFactory;
import com.hubspot.slack.client.SlackClientRuntimeConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SlackConfiguration {

    //@Value("${slack.api-token}")
    //String SLACK_API_TOKEN = "";


    String str1 = "xoxb-1064399718182-1083774805649-";
    String str2 = "ZqEvdhTIbV5hCosju5HHLojE";



    @Bean
    public SlackClient getSlackClient(){

        SlackClientRuntimeConfig runtimeConfig = SlackClientRuntimeConfig.builder()
                                                .setTokenSupplier(() -> str1+str2)
                                                .build();

        return SlackClientFactory.defaultFactory().build(runtimeConfig);
    }
}
