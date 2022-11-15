package ru.croc.task9.normalize_path;

public class NormalizePath {
    /**
     * Нормализация пути
     *
     * @param path - путь, который должен быть нормализован
     * @return
     */
    public String normalizePath(String path) {
        path = path.replaceAll("/./", "/");//удаляем все вхождения подстроки "./"
        for (int i = 0; i < path.length() - 3; i++) {
            if (path.substring(i, i + 3).equals("../")) {//ищем вхождения подстроки "../"
                for (int j = i - 1; j > 0; j--) {//если нашли, то ищем слово слева
                    if (path.charAt(j) != '/' && path.charAt(j) != '.') {
                        int oldSize = path.length();//записываем текущий размер строки, чтобы потом актуализировать i
                        path = path.substring(0, i - 1) + path.substring(i + 2);//удаляем "../"
                        path = deliteWordPart(path, j);//вызываем функцию удаления слова
                        if (i > oldSize - path.length()) {
                            i = i - (oldSize - path.length());//актуализируем i
                        }
                        break;
                    }

                }


            }
        }
        if (path.charAt(0) == '/') {
            path = removeByIndex(path, 0);
        }
        return path;
    }

    /**
     * Удаляет слово
     *
     * @param path  - строка, в которой надо удалить слово
     * @param index - индекс последнего символа слова
     * @return
     */
    private String deliteWordPart(String path, int index) {

        for (int i = index; i >= 0; i--) {
            if (path.charAt(i) != '/' && path.charAt(i) != '.') {
                path = removeByIndex(path, i);

            } else {
                path = removeByIndex(path, i);
                break;
            }

        }

        return path;
    }

    /**
     * Удаляет символ по индексу
     *
     * @param str   - строка, в которой надо удалить символ
     * @param index - индекс символа
     * @return
     */
    private static String removeByIndex(String str, int index) {
        StringBuilder sb = new StringBuilder();
        if (index > 0) {
            sb.append(str, 0, index);
        }
        if (index < str.length() - 1) {
            sb.append(str, index + 1, str.length());
        }
        return sb.toString();
    }
}