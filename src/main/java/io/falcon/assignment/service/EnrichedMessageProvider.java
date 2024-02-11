package io.falcon.assignment.service;

import io.falcon.assignment.domain.EnrichedMessageEntity;

import java.util.List;

public interface EnrichedMessageProvider {

    List<EnrichedMessageEntity> findAll();
}
