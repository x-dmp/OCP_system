package cn.edu.cuit.model.entity;

import java.io.Serializable;

public class OperRole implements Serializable {
    /**
     * @description:
     * @author: zaoweiceng
     * @time: 2020/12/25 16:00
     */
    private Integer id;
    private String roleName;
    private Integer roleState;
    private String roleDescription;
    private String letter;

    public OperRole() {
    }

    @Override
    public String toString() {
        return "OperRole{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleState=" + roleState +
                ", roleDescription='" + roleDescription + '\'' +
                ", letter='" + letter + '\'' +
                '}';
    }

    public OperRole(Integer id, String roleName, Integer roleState, String roleDescription, String letter) {
        this.id = id;
        this.roleName = roleName;
        this.roleState = roleState;
        this.roleDescription = roleDescription;
        this.letter = letter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getRoleState() {
        return roleState;
    }

    public void setRoleState(Integer roleState) {
        this.roleState = roleState;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public String getLetter() {
        return letter;
    }

    public OperRole setLetter(String letter) {
        this.letter = letter;
        return this;
    }
}
