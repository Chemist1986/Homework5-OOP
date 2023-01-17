package OOP5.di;

import OOP5.Controllers.UserController;
import OOP5.model.FileOperation;
import OOP5.model.Repository;
import OOP5.views.ViewUser;

public class Component {
    public FileOperation fileOperation;
    public Repository repository;
    public UserController userController;
    public ViewUser viewUser;

    public Component() {
        fileOperation = Module.provideFileOPeration();
        repository = Module.provideRepository(fileOperation, Module.provideMapper());
        userController = Module.provideUserController(repository);
        viewUser = Module.provideViewUser(userController);
    }
}