package com.init.index.module.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface iPermsMapper {
    /*
     * 功能:权限查询列表
     * */

    @Select(value = "SELECT\n"
            + "\tp.perms \n"
            + "FROM\n"
            + "\tperms AS p\n"
            + "\tINNER JOIN perms_roles AS pr ON p.id = pr.id\n"
            + "\tINNER JOIN roles AS r ON r.id = pr.id\n"
            + "\tINNER JOIN roles_users AS ru ON ru.id = r.id\n"
            + "\tINNER JOIN users AS u ON u.id = ru.id \n"
            + "WHERE\n"
            + "\tu.username = #{username}")
    List<String> selectPerms ( String username );
}
