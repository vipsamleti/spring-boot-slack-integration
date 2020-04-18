package io.vipsamleti.springbootslackintegration.controllers;

import io.vipsamleti.springbootslackintegration.analyzers.EventsAnalyzer;
import io.vipsamleti.springbootslackintegration.models.User;
import io.vipsamleti.springbootslackintegration.reporters.EventsReporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventsAnalyzer eventsAnalyzer;

    @Autowired
    private EventsReporter eventsReporter;

    @GetMapping("/sign-out")
    public String signOutEvent(){
        User user = new User();

        String analyzedMessage = eventsAnalyzer.analyze(user);

        eventsReporter.signOutEvent(analyzedMessage, user);

        return "Sent event on slack";
    }

    @RequestMapping(value = "/send-mail",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String onReceiveSlashCommand(@RequestParam("team_id") String teamId,
                                        @RequestParam("team_domain") String teamDomain,
                                        @RequestParam("channel_id") String channelId,
                                        @RequestParam("channel_name") String channelName,
                                        @RequestParam("user_id") String userId,
                                        @RequestParam("user_name") String userName,
                                        @RequestParam("command") String command,
                                        @RequestParam("text") String text,
                                        @RequestParam("response_url") String responseUrl) {
        return text + " This is my JSON response";
    }


}
