package model;

/**
 * Работал в организации
 */
public class OrganizationSection extends Section<Organization> {
    public static final OrganizationSection EMPTY = new OrganizationSection(Organization.EMPTY);
    static final long serialVersionUID = 1L;

    public OrganizationSection() {
    }

    public OrganizationSection(Organization... organizations) {
        super(organizations);
    }
}
