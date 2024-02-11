package io.falcon.assignment.service;

import io.falcon.assignment.dataaccess.MessageRepository;
import io.falcon.assignment.domain.EnrichedMessageEntity;
import io.falcon.assignment.domain.MessageEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EnrichedMessageProviderImpl implements EnrichedMessageProvider {

    private MessageRepository messageRepository;

    private PalindromFinderService palindromFinderService;


    @Override
    @NotNull
    public List<EnrichedMessageEntity> findAll() {
        return messageRepository.findAll().stream().map(this::map).collect(Collectors.toList());
    }

    protected EnrichedMessageEntity map(MessageEntity messageEntity) {
        EnrichedMessageEntity enrichedMessage = new EnrichedMessageEntity();
        enrichedMessage.setMessageEntity(messageEntity);
        enrichedMessage.setLongestPalindromSize(palindromFinderService.findLongestPalindromSize(messageEntity.getContent()));
        return enrichedMessage;
    }
}
