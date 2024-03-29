package mvc_example.controller;


import mvc_example.model.Model;
import mvc_example.view.EditUserView;
import mvc_example.view.UsersView;

/**
 * Этот класс будет получать запрос от клиента,
 * оповещать Модель об этом, а Модель, в свою очередь,
 * будет обновлять ModelData.
 */
public class Controller {

    private Model model;
    private UsersView usersView;
    private EditUserView editUserView;

    public void setModel(Model model) {
        this.model = model;
    }

    /**
     * который должен обратиться к модели
     * и инициировать загрузку пользователей
     */
    public void onShowAllUsers(){
        model.loadUsers();
        usersView.refresh(model.getModelData());
    }

    public void setUsersView(UsersView usersView) {
        this.usersView = usersView;
    }

    public void onShowAllDeletedUsers() {
        model.loadDeletedUsers();
        usersView.refresh(model.getModelData());
    }

    public void onOpenUserEditForm(long userId) {
        model.loadUserById(userId);
        editUserView.refresh(model.getModelData());
    }

    public void onUserDelete(long id){
        model.deleteUserById(id);
        usersView.refresh(model.getModelData());
    }

    public EditUserView getEditUserView() {
        return editUserView;
    }

    public void setEditUserView(EditUserView editUserView) {
        this.editUserView = editUserView;
    }

}
