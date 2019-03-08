package com.liu.domain.oauthserver.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.liu.domain.entity.SysUser;
import com.liu.domain.oauthserver.dto.AuthMarkingDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author ZYW
 * @since 2018-05-03
 */
@Mapper
public interface SysUserOauthMapper extends BaseMapper<SysUser> {

    List<AuthMarkingDTO> findAuthMarkingByUserId(@Param("userId") Long userId);

}
