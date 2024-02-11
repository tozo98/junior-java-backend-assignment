package io.falcon.assignment.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EnrichedMessageResponse {
    private String content;
    private String timestamp;
    @JsonProperty("longest_palindrom_size")
    private int longestPalindromSize;
}
