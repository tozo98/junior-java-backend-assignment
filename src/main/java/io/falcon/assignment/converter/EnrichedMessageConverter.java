package io.falcon.assignment.converter;

import io.falcon.assignment.domain.EnrichedMessageEntity;
import io.falcon.assignment.domain.EnrichedMessageResponse;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EnrichedMessageConverter implements Converter<EnrichedMessageEntity, EnrichedMessageResponse> {

    private TimestampConverter timestampConverter;

    @Override
    public EnrichedMessageResponse convert(EnrichedMessageEntity enrichedMessageEntity) {
        EnrichedMessageResponse response = new EnrichedMessageResponse();
        response.setContent(enrichedMessageEntity.getMessageEntity().getContent());
        response.setTimestamp(timestampConverter.getString(enrichedMessageEntity.getMessageEntity().getTimestamp()));
        response.setLongestPalindromSize(enrichedMessageEntity.getLongestPalindromSize());
        return response;
    }
}
