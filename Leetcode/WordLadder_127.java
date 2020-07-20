import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordLadder_127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<Integer>> transMap = new HashMap<>();
        int listSize = wordList.size();
        int endWordIndex = -1;
        for (int i = 0; i < listSize; ++i) {
            int index = i;
            String word = wordList.get(index);
            if (endWordIndex < 0 && endWord.equals(word)) endWordIndex = index;
            for (String key : getKeys(word)) {
                if (transMap.containsKey(key)) transMap.get(key).add(index);
                else { transMap.put(key, new ArrayList<Integer>() {{ add(index); }}); }
            }
        }
        if (endWordIndex < 0) return 0;

        wordList.add(beginWord);
        boolean[] visited1 = new boolean[listSize], visited2 = new boolean[listSize];
        List<Integer> candidates1 = new ArrayList<>(), candidates2 = new ArrayList<>();
        candidates1.add(listSize);
        candidates2.add(endWordIndex);
        visited2[endWordIndex] = true;
        int count = 1, size;
        while (!candidates1.isEmpty()) {
            ++count; size = candidates1.size();
            for (int i = 0; i < size; ++i) {
                for (String key : getKeys(wordList.get(candidates1.remove(0)))) {
                    if (transMap.containsKey(key)) {
                        for (int index : transMap.get(key)) {
                            if (visited1[index]) continue;
                            visited1[index] = true;
                            candidates1.add(index);
                        }
                    }
                }
            }
            for (int i : candidates1) {
                for (int j : candidates2) { if (i == j) return count; }
            }
            ++count; size = candidates2.size();
            for (int i = 0; i < size; ++i) {
                for (String key : getKeys(wordList.get(candidates2.remove(0)))) {
                    if (transMap.containsKey(key)) {
                        for (int index : transMap.get(key)) {
                            if (visited2[index]) continue;
                            visited2[index] = true;
                            candidates2.add(index);
                        }
                    }
                }
            }
            for (int i : candidates1) {
                for (int j : candidates2) { if (i == j) return count; }
            }
        }

        return 0;
    }

    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<Integer>> transMap = new HashMap<>();
        int listSize = wordList.size();
        int endWordIndex = -1;
        for (int i = 0; i < listSize; ++i) {
            int index = i;
            String word = wordList.get(index);
            if (endWordIndex < 0 && endWord.equals(word)) endWordIndex = index;
            for (String key : getKeys(word)) {
                if (transMap.containsKey(key)) transMap.get(key).add(index);
                else { transMap.put(key, new ArrayList<Integer>() {{ add(index); }}); }
            }
        }
        if (endWordIndex < 0) return 0;

        boolean[] visited = new boolean[listSize];
        List<String> candidates = new ArrayList<>();
        candidates.add(beginWord);
        int count = 1, size;
        while (!candidates.isEmpty()) {
            ++count; size = candidates.size();
            for (int i = 0; i < size; ++i) {
                for (String key : getKeys(candidates.remove(0))) {
                    if (transMap.containsKey(key)) {
                        for (int index : transMap.get(key)) {
                            if (index == endWordIndex) return count;
                            if (visited[index]) continue;
                            visited[index] = true;
                            candidates.add(wordList.get(index));
                        }
                    }
                }
            }
        }

        return 0;
    }

    private String[] getKeys(String word) {
        String[] keys = new String[word.length()];
        for (int i = 0; i < keys.length; ++i)
            keys[i] = word.substring(0, i) + "?" + word.substring(i + 1);
        return keys;
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        int listLength = wordList.size();
        int endWordIndex = -1;
        boolean endWordExist = false;

        List<List<Integer>> adjLists = new ArrayList<>(listLength);
        for (int i = 0; i < listLength; ++i) adjLists.add(new ArrayList<>());
        for (int i = 0; i < listLength; ++i) {
            String str = wordList.get(i);
            if (!endWordExist && endWord.equals(str)) { endWordExist = true; endWordIndex = i; }
            for (int j = i + 1; j < listLength; ++j) {
                if (isTransformable(str, wordList.get(j))) { adjLists.get(i).add(j); adjLists.get(j).add(i); }
            }
        }
        if (!endWordExist) return 0;

        boolean[] visited = new boolean[listLength];
        List<Integer> candidates = new ArrayList<>();
        candidates.add(listLength - 1);
        visited[listLength - 1] = true;

        int count = 1, size;
        while (candidates.size() != 0) {
            ++count;
            size = candidates.size();
            for (int i = 0; i < size; ++i) {
                for (Integer adj : adjLists.get(candidates.remove(0))) {
                    if (visited[adj]) continue;
                    if (adj == endWordIndex) return count;
                    visited[adj] = true;
                    candidates.add(adj);
                }
            }
        }
        return 0;
    }

    public int ladderLength3(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        int listLength = wordList.size(), wordLength = beginWord.length();
        int endWordIndex = wordList.indexOf(endWord);
        if (endWordIndex < 0) return 0;

        boolean[] visited = new boolean[listLength];
        List<Integer> candidates = new ArrayList<>();
        candidates.add(listLength - 1);
        visited[listLength - 1] = true;

        String str, compStr;
        int count = 1, size, diffCount;
        while (candidates.size() != 0) {
            ++count;
            size = candidates.size();
            for (int i = 0; i < size; ++i) {
                int candidate = candidates.remove(0);
                str = wordList.get(candidate);
                for (int adj = 0; adj < listLength; ++adj) {
                    if (candidate == adj || visited[adj]) continue;
                    diffCount = 0;
                    compStr = wordList.get(adj);
                    for (int k = 0; k < wordLength; ++k) {
                        if (str.charAt(k) != compStr.charAt(k)) ++diffCount;
                        if (diffCount > 1) break;
                    }
                    if (diffCount == 1) {
                        if (adj == endWordIndex) return count;
                        visited[adj] = true; candidates.add(adj);
                    }
                }
            }
        }
        return 0;
    }

    private boolean isTransformable(String str1, String str2) {
        int diffCount = 0;
        for (int i = 0; i < str1.length(); ++i) {
            if (str1.charAt(i) != str2.charAt(i)) ++diffCount;
            if (diffCount > 1) break;
        }
        return diffCount == 1;
    }

}
