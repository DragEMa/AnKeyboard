/*
 * AnKeyboard - A smart learning keyboard for Android
 * Copyright (C) 2026 AnerysRynz
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.ankeyboard.app;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class LearningDictionary {
    private SharedPreferences prefs;
    private static final String PREF_NAME = "AnKeyboard_Brain";

    public LearningDictionary(Context context) {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void learnWord(String word) {
        if (prefs == null || word == null) return;
        word = word.trim();
        if (word.length() < 2) return; // ignore very short words

        String key = word.toLowerCase();

        int currentFreq = prefs.getInt(key, 0);
        prefs.edit().putInt(key, currentFreq + 1).apply();
    }

    public List<String> getPredictions(String composingText) {
        if (composingText == null) {
            return new ArrayList<>();
        }
        String prefix = composingText.toLowerCase();
        Map<String, ?> allMap = prefs.getAll();
        if (allMap == null) {
            return new ArrayList<>();
        }
        List<Map.Entry<String, ?>> allWords = new ArrayList<>(allMap.entrySet());
        List<Map.Entry<String, ?>> matches = new ArrayList<>();

        for (Map.Entry<String, ?> entry : allWords) {
            if (entry.getValue() instanceof Integer) {
                if (entry.getKey().startsWith(prefix)) {
                    matches.add(entry);
                }
            }
        }

        Collections.sort(matches, new Comparator<Map.Entry<String, ?>>() {
            @Override
            public int compare(Map.Entry<String, ?> o1, Map.Entry<String, ?> o2) {
                Integer freq1 = (Integer) o1.getValue();
                Integer freq2 = (Integer) o2.getValue();
                return freq2.compareTo(freq1);
            }
        });

        List<String> results = new ArrayList<>();
        if (!prefix.isEmpty()) {
            results.add(composingText); 
        }

        for (int i = 0; i < Math.min(10, matches.size()); i++) {
            String word = matches.get(i).getKey();
            if (!word.equalsIgnoreCase(composingText)) {
                results.add(word);
            }
        }
        
        return results;
    }
}
