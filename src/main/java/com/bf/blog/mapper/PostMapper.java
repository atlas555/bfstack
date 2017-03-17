package com.bf.blog.mapper;

import com.bf.blog.domain.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zhangxiaolong
 * @date 16/2/4 上午10:23
 */
@Mapper
public interface PostMapper {

    static final String TABLE = " jb_posts ";

    String col_without_id = " author_id,title,content,catalog_id,tags,status,delete_flag,create_time,update_time ";
    String col_with_id = " id, " + col_without_id;

    @Insert("insert into " + TABLE + " ( " + col_without_id
        + " ) values ( #{authorId},#{title},#{content},#{catalogId},#{tags},#{status},#{deleteFlag},now(),now())")
    public int insert(Post post);

    @Select("select " + col_with_id + " from " + TABLE + " where delete_flag=false")
    public List<Post> getArticles();

    @Delete("delete from " + TABLE + " where id = #{id}")
    public int delArticle(Long id);

    @Update("update " + TABLE + " set title=#{title},content=#{content},catalog_id=#{catalogId},tags=#{tags}")
    public int updateArticle(Post post);

    @Select("select " + col_with_id + " from " + TABLE + " where id=#{id} and delete_flag=false and status = 1")
    public Post getArticleById(Long id);

}
