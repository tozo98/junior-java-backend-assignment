package io.falcon.assignment.service;

import io.falcon.assignment.dataaccess.MessageRepository;
import io.falcon.assignment.domain.MessageEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
@AllArgsConstructor
public class MessageSaverServiceImpl implements MessageSaverService {

    private MessageRepository messageRepository;

    @Override
    public void save(@NotNull MessageEntity message) {
        messageRepository.save(message);
    }
}
