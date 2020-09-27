class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        List<String> bannedWords = new ArrayList<>();
        for (String s : banned) {
            bannedWords.add(s);
        }
        paragraph = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
        String[] words = paragraph.split("\\s+");
        Map<String, Integer> frequency = new HashMap<>();
        for (String word : words) {
            if (!bannedWords.contains(word)) {
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }
        }

        return Collections.max(frequency.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}