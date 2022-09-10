package com.cloudsoftware.todolist.constant;

public enum PasswordRule {

    SIZE(
            "Minimum 8 karakter olmalıdır",
            "^.{8,}$"
    ),
    WITHOUT_SPACE(
            "Boşluk içeremez",
            "^[^\\s]+$"
    ),
    INCLUDING_MIN_ONE_NUMBER(
            "En az 1 tane rakam kullanılmalıdır",
            ".*[0-9]+.*"
    ),
    INCLUDING_MIN_ONE_SPECIAL_CHARACTER(
            "En az 1 tane özel karakter (._-) kullanılmalıdır",
            "(.*)([-_.])(.*)"
    ),

    INCLUDING_MIN_ONE_UPPER_CASE(
            "En az 1 tane büyük harf içermelidir",
            ".*[A-Z]+.*"
    ),

    INCLUDING_MIN_ONE_LOWER_CASE(
            "En az 1 tane küçük harf içermelidir",
            ".*[a-z]+.*"
    );

    private final String detail;
    private final String regex;

    PasswordRule(String detail, String regex) {
        this.detail = detail;
        this.regex = regex;
    }

    public String getDetail() {
        return detail;
    }

    public String getRegex() {
        return regex;
    }
}
