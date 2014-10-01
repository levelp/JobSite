package model;

import java.util.List;

/**
 * Created by dimashilin on 26.09.14.
 */
public class Resume {
    private List<String> citizenship, countOfLanguage, education, skills, employment;
    private String infAboutUser;
    private int salary;
    private String phone;
    private User user;
    public Resume(User user, String phone) {
        this.phone = phone;
        this.user = user;
    }
}
