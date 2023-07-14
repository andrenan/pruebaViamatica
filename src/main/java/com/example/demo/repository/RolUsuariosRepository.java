package com.example.demo.repository;

import com.example.demo.model.Persona;
import com.example.demo.model.RolUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface RolUsuariosRepository extends JpaRepository<RolUsuarios, Long> {
    @Override
    default List<RolUsuarios> findAll() {
        return null;
    }

    @Override
    default List<RolUsuarios> findAll(Sort sort) {
        return null;
    }

    @Override
    default List<RolUsuarios> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    default <S extends RolUsuarios> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    default void flush() {

    }

    @Override
    default <S extends RolUsuarios> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    default <S extends RolUsuarios> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    default void deleteAllInBatch(Iterable<RolUsuarios> entities) {

    }

    @Override
    default void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    default void deleteAllInBatch() {

    }

    @Override
    default RolUsuarios getOne(Long aLong) {
        return null;
    }

    @Override
    default RolUsuarios getById(Long aLong) {
        return null;
    }

    @Override
    default RolUsuarios getReferenceById(Long aLong) {
        return null;
    }

    @Override
    default <S extends RolUsuarios> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    default <S extends RolUsuarios> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    default Page<RolUsuarios> findAll(Pageable pageable) {
        return null;
    }

    @Override
    default <S extends RolUsuarios> S save(S entity) {
        return null;
    }

    @Override
    default Optional<RolUsuarios> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    default boolean existsById(Long aLong) {
        return false;
    }

    @Override
    default long count() {
        return 0;
    }

    @Override
    default void deleteById(Long aLong) {

    }

    @Override
    default void delete(RolUsuarios entity) {

    }

    @Override
    default void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    default void deleteAll(Iterable<? extends RolUsuarios> entities) {

    }

    @Override
    default void deleteAll() {

    }

    @Override
    default <S extends RolUsuarios> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    default <S extends RolUsuarios> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    default <S extends RolUsuarios> long count(Example<S> example) {
        return 0;
    }

    @Override
    default <S extends RolUsuarios> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    default <S extends RolUsuarios, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Query(value = "select * from  rol_usuarios  p where p.usuarios = :idd",nativeQuery = true)
    public RolUsuarios getByUsuarios(Long idd);

    @Query(value = "select * from  rol_usuarios  p where p.usuarios = :idd",nativeQuery = true)
    public List<RolUsuarios> getAllByUsuarios(Long idd);
}
