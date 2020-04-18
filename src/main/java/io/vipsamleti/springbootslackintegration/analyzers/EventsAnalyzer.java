package io.vipsamleti.springbootslackintegration.analyzers;

import io.vipsamleti.springbootslackintegration.models.User;

public interface EventsAnalyzer {
    String analyze(User user);
}
