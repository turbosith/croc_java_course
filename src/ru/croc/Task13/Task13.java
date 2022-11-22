package ru.croc.Task13;

import java.util.*;

public class Task13 {
    public static void main(String[] args) {
        Map<Integer, String> films = new HashMap<>();
        films.put(1, "Мстители: Финал");
        films.put(2, "Хатико");
        films.put(3, "Дюна");
        films.put(4, "Унесенные призраками");
        int[] user;
        List<int[]> users = new ArrayList<>();
        user = new int[]{2, 1, 3};
        users.add(user);
        user = new int[]{1, 4, 3};
        users.add(user);
        user = new int[]{2, 2, 2, 2, 2, 3};
        users.add(user);
        List<Integer> movies = new ArrayList<>();
        int iterationCount = 0;
        Scanner s = new Scanner(System.in);
        String userMovies = s.nextLine();
        for (int i = 0; i < userMovies.length(); i += 2, iterationCount += 1) {
            movies.add(userMovies.charAt(i) - '0');
        }
        MovieRecommendations movieRecommendations = new MovieRecommendations(movies);
        System.out.println(movieRecommendations.getFilmRecomendation(films, users));
    }
}
