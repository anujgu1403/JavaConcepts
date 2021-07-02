package com.java.concepts.gs;

import java.util.HashMap;
import java.util.Map;

public class AverageScore {

    private class Score {
        private int score;
        private int count;

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    public int calculateBestAvgScore(String[][] studentData) {

        Map<String, Score> map = new HashMap<>();
        int records = studentData.length;
        String studentName;
        int avgScore;
        for (int i = 0; i < records; i++) {
            studentName = studentData[i][0];
            avgScore = Integer.parseInt(studentData[i][1]);

            if (map.containsKey(studentName)) {
                Score score = map.get(studentName);
                score.setScore(score.getScore() + avgScore);
                score.setCount(score.getCount() + 1);
                map.put(studentName, score);
            } else {
                Score score = new Score();
                score.setCount(1);
                score.setScore(avgScore);
                map.put(studentName, score);
            }
        }

        //Find the best score
        int bestScore = 0;
        for (String name : map.keySet()) {
            Score score = map.get(name);
            int tempBestScore = score.getScore() / score.getCount();
            if (bestScore < tempBestScore)
                bestScore = tempBestScore;
        }
        return bestScore;
    }

    public static void main(String[] args) {
        String[][] studentData = {{"Bob", "65"}, {"Ron", "87"}, {"Jack", "78"}, {"Bob", "95"}};

        AverageScore as = new AverageScore();
        System.out.println(as.calculateBestAvgScore(studentData));
    }
}
