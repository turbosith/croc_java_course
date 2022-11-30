package ru.croc.task13;

import java.io.*;
import java.util.*;

public class Task13 {
    public static void main(String[] args) throws  IOException,NoSuchElementException,IllegalStateException {
        Map<Integer, String> films = new HashMap<>();
        try (Scanner s = new Scanner(new FileReader("films.txt"))) {
            while (s.hasNextLine()){
                String scan=s.nextLine();
                films.put(scan.charAt(0)-'0',scan.substring(2));}
        }
        List<int[]> users = new ArrayList<>();
        try (Scanner s = new Scanner(new FileReader("users.txt"))) {
            while (s.hasNextLine()) {
                int iterationCount = 0;
                String scan = s.nextLine();
                int[] user = new int[scan.length() / 2 + 1];
                for (int i = 0; i < scan.length(); i += 2, iterationCount += 1) {
                    user[iterationCount]=scan.charAt(i) - '0';
                }
                users.add(user);
            }

        }
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
