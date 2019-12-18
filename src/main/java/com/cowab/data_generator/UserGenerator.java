package com.cowab.data_generator;

import com.cowab.objects.User;
import lombok.Data;

@Data
public class UserGenerator {

    public static User generateUserSE() {
        return new User(
                "111111-1111",
                "+46712345671",
                "Test Adddress",
                "41669",
                "Göteborg",
                "+46712345672",
                "vikentiy.kelevich@gmail.com",
                "manythanks4thisday");
    }

    public static User generateUserNO() {
        return new User(
                "111111-1111",
                "+46712345671",
                "Test Adddress",
                "41669",
                "Göteborg",
                "+46712345672",
                "vikentiy.kelevich@gmail.com",
                "manythanks4thisday");
    }


}
