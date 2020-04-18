package io.vipsamleti.springbootslackintegration.reporters;

import com.hubspot.slack.client.SlackClient;
import com.hubspot.slack.client.methods.params.chat.ChatPostMessageParams;
import io.vipsamleti.springbootslackintegration.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class EventsReporterImpl implements EventsReporter {

    @Autowired
    private SlackClient slackClient;

    @Value("${slack.channel}")
    private String SLACK_CHANNEL;

    @Override
    public void signOutEvent(String slackMessage, User user) {
        slackClient.postMessage(
                ChatPostMessageParams.builder()
                        .setText(slackMessage)
                        .setChannelId(SLACK_CHANNEL)
                        .setUsername("Event Bot")
                        .setIconEmoji(":rocket:")
                        .build()
        ).join().unwrapOrElseThrow();
    }
}