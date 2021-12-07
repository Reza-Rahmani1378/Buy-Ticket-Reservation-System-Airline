package ir.maktab.btrs.btrsa.service.impl;


import ir.maktab.btrs.btrsa.base.service.impl.BaseServiceImpl;
import ir.maktab.btrs.btrsa.domain.User;
import ir.maktab.btrs.btrsa.domain.enumeration.UserType;
import ir.maktab.btrs.btrsa.repository.UserRepository;
import ir.maktab.btrs.btrsa.service.UserService;
import ir.maktab.btrs.btrsa.utility.input.Input;
import ir.maktab.btrs.btrsa.utility.input.InputInformation;

public class UserServiceImpl extends BaseServiceImpl<User, Long, UserRepository> implements
        UserService {

    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public User login() {

        String username = new Input("Enter your username :").getInputString();
        String password = new Input("Enter your password :").getInputString();
        User user = repository.existByUsername(username);
        try {
            if (user.getPassword().equals(password)) {
                return user;
            }
        } catch (NullPointerException ignored) {

        }
        return null;
    }

    @Override
    public void singUp() {
        User user = new User();
        user.setFirst_name(InputInformation.getFirstName());
        user.setLast_name(InputInformation.getLastName());
        String username = new Input("Enter your username").getInputString();

        while (repository.existByUsername(username) != null) {
            System.out.println("this username is token before");
            username = new Input("Enter your username :").getInputString();
        }
        user.setNational_code(InputInformation.getNationalCode());
        user.setUsername(username);
        user.setPassword(InputInformation.getPassword());
        user.setUserType(UserType.CUSTOMER);
        user.setBirth_day(InputInformation.getBirthDay());

        repository.getEntityManager().getTransaction().begin();
        repository.save(user);
        repository.getEntityManager().getTransaction().commit();


    }

    @Override
    public User existByUsername(String username) {
        return repository.existByUsername(username);
    }
}
