package io.falcon.assignment.domain;

import lombok.Data;

@Data
public class EnrichedMessageEntity {
    private MessageEntity messageEntity;
    private int longestPalindromSize;
}
