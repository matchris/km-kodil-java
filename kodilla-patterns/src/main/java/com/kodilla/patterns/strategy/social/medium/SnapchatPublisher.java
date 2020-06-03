package com.kodilla.patterns.strategy.social.medium;

import com.kodilla.patterns.strategy.social.SocialPublisher;

public class SnapchatPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "sharing on Snapchat";
    }
}
