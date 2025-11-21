package webapp.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dimashilin on 26.09.14.
 */
public class ResumeTest extends Assert {
    @Test
    public void Test() {
        User user = new User().createMale("GlobalBubble", "GlobalBubble@mail.ru", "11111");
    }

    @Test
    public void testResumeCreation() {
        User user = new User();
        Resume resume = new Resume(user, "123-456-7890");

        assertNotNull(resume);
        assertEquals(user, resume.getUser());
        assertEquals("123-456-7890", resume.getPhone());
    }

    @Test
    public void testCitizenship() {
        User user = new User();
        Resume resume = new Resume(user, "123-456");
        List<String> citizenship = Arrays.asList("Russian", "American");

        resume.setCitizenship(citizenship);
        assertEquals(citizenship, resume.getCitizenship());
    }

    @Test
    public void testCountOfLanguage() {
        User user = new User();
        Resume resume = new Resume(user, "123-456");
        List<String> languages = Arrays.asList("English", "Russian");

        resume.setCountOfLanguage(languages);
        assertEquals(languages, resume.getCountOfLanguage());
    }

    @Test
    public void testEducation() {
        User user = new User();
        Resume resume = new Resume(user, "123-456");
        List<String> education = Arrays.asList("Bachelor's", "Master's");

        resume.setEducation(education);
        assertEquals(education, resume.getEducation());
    }

    @Test
    public void testSkills() {
        User user = new User();
        Resume resume = new Resume(user, "123-456");
        List<String> skills = Arrays.asList("Java", "Python", "JavaScript");

        resume.setSkills(skills);
        assertEquals(skills, resume.getSkills());
    }

    @Test
    public void testEmployment() {
        User user = new User();
        Resume resume = new Resume(user, "123-456");
        List<String> employment = Arrays.asList("Full-time", "Contract");

        resume.setEmployment(employment);
        assertEquals(employment, resume.getEmployment());
    }

    @Test
    public void testInfAboutUser() {
        User user = new User();
        Resume resume = new Resume(user, "123-456");
        String info = "Experienced developer";

        resume.setInfAboutUser(info);
        assertEquals(info, resume.getInfAboutUser());
    }

    @Test
    public void testSalary() {
        User user = new User();
        Resume resume = new Resume(user, "123-456");

        resume.setSalary(100000);
        assertEquals(100000, resume.getSalary());
    }

    @Test
    public void testPhone() {
        User user = new User();
        Resume resume = new Resume(user, "123-456");

        resume.setPhone("987-654-3210");
        assertEquals("987-654-3210", resume.getPhone());
    }

    @Test
    public void testUser() {
        User user1 = new User();
        User user2 = new User();
        Resume resume = new Resume(user1, "123-456");

        assertEquals(user1, resume.getUser());

        resume.setUser(user2);
        assertEquals(user2, resume.getUser());
    }

    @Test
    public void testLocation() {
        User user = new User();
        Resume resume = new Resume(user, "123-456");

        resume.setLocation("Moscow");
        assertEquals("Moscow", resume.getLocation());
    }
}
