package io.falcon.assignment.converter;

import io.falcon.assignment.domain.MessageEntity;
import io.falcon.assignment.domain.MessageRequest;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MessageConverter implements Converter<MessageRequest, MessageEntity> {

    private TimestampConverter timestampConverter;

    @Override
    public MessageEntity convert(MessageRequest messageRequest) {
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setContent(messageRequest.getContent());
        messageEntity.setTimestamp(timestampConverter.getZonedDateTime(messageRequest.getTimestamp()));
        return messageEntity;
    }

}
