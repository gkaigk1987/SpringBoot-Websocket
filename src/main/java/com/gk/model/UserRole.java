package com.gk.model;

/**
 * Database Table Remarks:
 *   用户角色表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table t_user_role
 */
public class UserRole {
    /**
     * Database Column Remarks:
     *   自增主键
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_role.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * Database Column Remarks:
     *   用户id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_role.user_id
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     * Database Column Remarks:
     *   角色id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_role.role_id
     *
     * @mbg.generated
     */
    private Integer roleId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_role.id
     *
     * @return the value of t_user_role.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_role.id
     *
     * @param id the value for t_user_role.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_role.user_id
     *
     * @return the value of t_user_role.user_id
     *
     * @mbg.generated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_role.user_id
     *
     * @param userId the value for t_user_role.user_id
     *
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_role.role_id
     *
     * @return the value of t_user_role.role_id
     *
     * @mbg.generated
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_role.role_id
     *
     * @param roleId the value for t_user_role.role_id
     *
     * @mbg.generated
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}