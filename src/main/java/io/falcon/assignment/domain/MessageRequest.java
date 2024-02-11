package io.falcon.assignment.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class MessageRequest {
    @NotNull
    private String content;
    @NotNull
    private String timestamp;
}
