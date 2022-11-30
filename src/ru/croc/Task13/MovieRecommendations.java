package ru.croc.task13;

import java.util.*;

public class MovieRecommendations {
    private Map<Integer, String> films = new HashMap<>();
    private List<int[]> users;
    private final List<Integer> userMovies;

    /**
     * Создаёт @code MovieRecommendations
     *
     * @param userMovies - фильмы, которые смотрел пользователь
     */
    public MovieRecommendations(List<Integer> userMovies) {
        this.userMovies = userMovies;
    }

    /**
     * @param films-словарь с номерами фильмов и их названиями
     * @param users-        истории просмотров пользователей
     * @return - рекомендация пользователю(фильм, который ему понравится)
     */
    String getFilmRecomendation(Map<Integer, String> films, List<int[]> users) {
        this.films = films;
        this.users = users;
        List<int[]> similarUsers = coincidences();
        Set<Integer> moviesWithoutRepetions = removeRepetitions(similarUsers);
        return finalRecomendation(moviesWithoutRepetions);
    }

    /**
     * Вычисляет финальную рекомендацию для пользователя
     *
     * @param moviesWithoutRepetions - фильмы не просмотренные пользователем
     * @return - название фильма, который понравится пользователю
     */
    private String finalRecomendation(Set<Integer> moviesWithoutRepetions) {
        Map<String, Integer> countFilms = new HashMap<>();
        for (int film : moviesWithoutRepetions) {
            countFilms.put(films.get(film), 0);
        }
        for (int[] user : users) {
            for (int j : user) {
                Integer count = countFilms.get(films.get(j));

                if (count != null) {

                    countFilms.put(films.get(j), count + 1);
                }
            }
        }

        int max = 0;
        Collection<Integer> counts = countFilms.values();
        for (Integer count : counts) {
            if (max < count) {
                max = count;
            }
        }

        Set<String> keys = countFilms.keySet();
        for (String film : keys) {
            if (countFilms.get(film) == max) {
                return film;
            }
        }
        return null;
    }

    /**
     * Удаление просмотренных пользователем фильмов
     *
     * @param similarUsers - пользователи со схожими интересами
     * @return - фильмы, интересные пользователю, которые он не видел
     */
    private Set<Integer> removeRepetitions(List<int[]> similarUsers) {
        Set<Integer> moviesWithoutRepetions = new HashSet<>();
        for (int[] user : similarUsers) {
            for (int k : user) {
                boolean flag = false;
                for (Integer userMovie : userMovies) {
                    if (k == userMovie) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    moviesWithoutRepetions.add(k);
                }

            }
        }
        return moviesWithoutRepetions;
    }

    /**
     * Поиск похожих по интересам зрителей
     *
     * @return - просмотры похожих зрителей
     */
    private List<int[]> coincidences() {
        List<int[]> similarUsers = new ArrayList<>();
        for (int[] user : users) {
            List<Integer> viewedMovies = new ArrayList<>();

            for (int k : user) {
                for (Integer userMovie : userMovies) {
                    if (k == userMovie) {
                        viewedMovies.add(k);

                    }
                }

            }

            if (viewedMovies.size() >= userMovies.size() / 2) {
                similarUsers.add(user);

            }

        }
        return similarUsers;
    }

}
