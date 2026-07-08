package pageobjects;

public class UserFlowPages {
    public UsersPage users;
    public AddUserPage addUser;

    public UserFlowPages(UsersPage users, AddUserPage addUser) {
        this.users = users;
        this.addUser = addUser;
    }
}