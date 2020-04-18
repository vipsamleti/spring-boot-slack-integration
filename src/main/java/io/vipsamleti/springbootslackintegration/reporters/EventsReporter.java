package io.vipsamleti.springbootslackintegration.reporters;

import io.vipsamleti.springbootslackintegration.models.User;

public interface EventsReporter {
    void signOutEvent(String slackMessage, User user);
}
