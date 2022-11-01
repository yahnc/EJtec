package employee.model;

public class Client {
    String id;
    String employee_name;
    String employee_salary;
    String employee_age;
    String profile_image;

    public Client(String id, String employee_name, String employee_salary, String employee_age, String profile_image) {
        this.id = id;
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
        this.profile_image = profile_image;
    }

    public String getId() {
        return id;
    }

    public String getemployee_name() {
        return employee_name;
    }

    public String getemployee_salary() {
        return employee_salary;
    }

    public String getemployee_age() {
        return employee_age;
    }
    public String getprofile_image() {
        return profile_image;
    }

    public static final class Builder {
        String id;
        String employee_name;
        String employee_salary;
        String employee_age;
        String profile_image;

        private Builder() {
        }

        public static Builder aClient() {
            return new Builder();
        }

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withemployee_name(String employee_name) {
            this.employee_name = employee_name;
            return this;
        }

        public Builder withemployee_salary(String employee_salary) {
            this.employee_salary = employee_salary;
            return this;
        }

        public Builder withemployee_age(String employee_age) {
            this.employee_age = employee_age;
            return this;
        }

        public Builder withprofile_image(String profile_image) {
            this.profile_image = profile_image;
            return this;
        }

        public Client build() {
            return new Client(id, employee_name, employee_salary, employee_age, profile_image);
        }
    }
}
