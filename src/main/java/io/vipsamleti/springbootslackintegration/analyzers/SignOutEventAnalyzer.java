package io.vipsamleti.springbootslackintegration.analyzers;

import io.vipsamleti.springbootslackintegration.models.User;
import io.vipsamleti.springbootslackintegration.reporters.EventsReporter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.FileSystems;

public class SignOutEventAnalyzer implements EventsAnalyzer {

    private static final Logger LOG = LoggerFactory.getLogger(SignOutEventAnalyzer.class);


    @Override
    public String analyze(User user) {
        return "user has logged out";
    }

        /*
        FileSystems.getDefault().getFileStores().forEach(fileStore -> {
            try {
                long totalSpace = fileStore.getTotalSpace();
                long usableSpace = fileStore.getUsableSpace();
                double usablePercentage = ((double) usableSpace) / totalSpace;

                if (totalSpace > 0 && usablePercentage < limit) {
                    String slackMessage = String.format("File store %s only has %d%% usable disk space",
                            fileStore.name(), (int)(usablePercentage * 100));
                    eventsReporter.triggerOnSlack(slackMessage, user);
                }
            } catch (IOException e) {
                LOG.error("Error getting disk space for file store {}", fileStore, e);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        }
        */


}
