package job4j.level1.collectionSet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * метод принимает отображение в котором содержатся пары ключ(число) - значение(строка),
 * при этом строка - это имя пользователя(в отображении они представлены пустой строкой),
 * ключ - его id. Также в качестве аргумента метод принимает список пользователей.
 * Необходимо реализовать метод, который произведет ассоциацию id и name пользователя в отображении.
 * При этом:
 * 1. Если такой ключ уже есть в отображении - метод должен обновить ассоциацию(используйте computeIfPresent()).
 * 2. Если такого ключа нет - метод должен добавить ассоциацию(используйте computeIfAbsent()).
 */
public class Task6 {
    public static Map<Integer, String> collectData(Map<Integer, String> names, List<User> users) {
        for (User user : users) {
            if (names.containsKey(user.getId())) {
                names.computeIfPresent(user.getId(), (key, value) -> user.getName());
            } else {
                names.computeIfAbsent(user.getId(), key -> user.getName());
            }
        }
        return names;
    }

    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Task6.User user = (Task6.User) o;
            return Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
}
