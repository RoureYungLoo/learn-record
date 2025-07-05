package com.luruoyang.mapper;

import com.luruoyang.entity.Author;
import lombok.NonNull;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface AuthorMapper {

  int insertAuthor(Author author);

  int updateAuthor(Author author);

  int deleteAuthor(Integer authorId);

  void insertAuthors(List<Author> authorList);

  //  Author selectAuthorById(int authorId);
  Map<String, Object> selectAuthorById(int authorId);

  Map<String, Object> sqlFragsTableName(int authorId);

  Author selectById(int authorId);

  Author findByColumn(@Param("column") @NonNull String column, @Param("value") @NonNull Object value);

  Map<String, Object> findByColumnWithResultTypeMap(@Param("column") @NonNull String column, @Param("value") @NonNull Object value);
}
