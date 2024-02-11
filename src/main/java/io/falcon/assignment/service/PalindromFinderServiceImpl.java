package io.falcon.assignment.service;

import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Comparator;

@Service
public class PalindromFinderServiceImpl implements PalindromFinderService {

    @Override
    public int findLongestPalindromSize(@NotNull String input) {
        return Arrays.stream(input.split(" "))
                .map(str -> str.replaceAll("[^a-zA-Z]", ""))
                .map(this::calculateTheLongestPalindromSize)
                .max(Comparator.naturalOrder())
                .orElse(0);
    }

    private int calculateTheLongestPalindromSize(String input) {
        int maxLength = 0, start = 0;
        for (int i = 0; i < input.length(); i++) {
            for (int j = i; j < input.length(); j++) {
                int flag = 1;
                for (int k = 0; k < (j - i + 1) / 2; k++) {
                    if (input.charAt(i + k) != input.charAt(j - k)) {
                        flag = 0;
                    }
                }
                if (flag != 0 && (j - i + 1) > maxLength) {
                    start = i;
                    maxLength = j - i + 1;
                }
            }
        }
        return maxLength;
    }
}
