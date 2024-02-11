package io.falcon.assignment.service;

import io.falcon.assignment.domain.MessageEntity;

import javax.validation.constraints.NotNull;

public interface MessageSaverService {

    void save(@NotNull MessageEntity message);
}
