package io.falcon.assignment.service;

import javax.validation.constraints.NotNull;

public interface PalindromFinderService {
    int findLongestPalindromSize(@NotNull String input);
}
