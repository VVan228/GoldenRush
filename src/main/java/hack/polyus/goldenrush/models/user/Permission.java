package hack.polyus.goldenrush.models.user;


import lombok.Getter;

@Getter
public enum Permission {

    ADMIN("admin");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

}
