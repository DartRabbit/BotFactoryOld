package com.botfactory.factory;

import com.botfactory.factory.model.User;

import static com.botfactory.factory.model.AbstractBaseEntity.START_SEQ;


public class UserTestData {
    public static final int USER_ID = START_SEQ;
    public static final int ADMIN_ID = START_SEQ + 1;

    public static final User USER = new User(USER_ID, "User", "user@yandex.ru", "password", true);
    public static final User ADMIN = new User(ADMIN_ID, "Admin", "admin@gmail.com", "admin", true);

//    public static final BeanMatcher<User> MATCHER = BeanMatcher.of(User.class,
//            (expected, actual) -> expected == actual ||
//                    (Objects.equals(expected.getPassword(), actual.getPassword())
//                            && Objects.equals(expected.getId(), actual.getId())
//                            && Objects.equals(expected.getName(), actual.getName())
//                            && Objects.equals(expected.getEmail(), actual.getEmail())
//                            && Objects.equals(expected.getCaloriesPerDay(), actual.getCaloriesPerDay())
//                            && Objects.equals(expected.isEnabled(), actual.isEnabled())
//                            && Objects.equals(expected.getRoles(), actual.getRoles())
//                    )
//    );
}
