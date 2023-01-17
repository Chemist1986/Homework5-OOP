package OOP5.di;

import OOP5.Controllers.UserController;
import OOP5.model.FileOperation;
import OOP5.model.FileOperationImpl;
import OOP5.model.Mapper;
import OOP5.model.Repository;
import OOP5.model.RepositoryAlternativeFile;
import OOP5.model.UserMapperAlternative;
import OOP5.views.ViewUser;

public class Module {
    public static FileOperation provideFileOPeration() {
        return new FileOperationImpl("users.txt");
    }

    public static Mapper provideMapper() {
        return new UserMapperAlternative();
    }

    public static Repository provideRepository(
            FileOperation fileOperation,
            Mapper mapper
    ) {
        return new RepositoryAlternativeFile(mapper ,fileOperation);
    }

    public static UserController provideUserController(
            Repository repository
    ) {
        return new UserController(repository);
    }

    public static ViewUser provideViewUser(
            UserController controller
    ) {
        return new ViewUser(controller);
    }
}