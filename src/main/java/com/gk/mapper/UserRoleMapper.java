package com.gk.mapper;

import com.gk.model.UserRole;
import com.gk.model.UserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbg.generated
     */
    long countByExample(UserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbg.generated
     */
    int deleteByExample(UserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbg.generated
     */
    int insert(UserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbg.generated
     */
    int insertSelective(UserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbg.generated
     */
    List<UserRole> selectByExample(UserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbg.generated
     */
    UserRole selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") UserRole record, @Param("example") UserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") UserRole record, @Param("example") UserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(UserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(UserRole record);
}