package io.falcon.assignment.controller;

import io.falcon.assignment.converter.EnrichedMessageConverter;
import io.falcon.assignment.domain.EnrichedMessageResponse;
import io.falcon.assignment.service.EnrichedMessageProvider;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class EnrichedMessageProviderRestController {

    private EnrichedMessageProvider enrichedMessageProvider;

    private EnrichedMessageConverter converter;

    @GetMapping("api/v1/messages/all")
    public List<EnrichedMessageResponse> retrieveAll() {
        return enrichedMessageProvider.findAll().stream().map(converter::convert).collect(Collectors.toList());
    }

}
