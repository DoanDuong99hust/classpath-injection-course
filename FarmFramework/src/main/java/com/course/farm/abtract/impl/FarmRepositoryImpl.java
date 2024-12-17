package com.course.farm.abtract.impl;

import com.course.farm.abtract.Repository;
import com.course.farm.annotation.FarmRepository;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@FarmRepository
public class FarmRepositoryImpl<T,ID> implements Repository<T, ID> {

    public FarmRepositoryImpl() {
    }

    private Class<T> entityClass;
    private Connection connection;

    public FarmRepositoryImpl(Class<T> entityClass, Connection connection) {
        this.entityClass = entityClass;
        this.connection = connection;
    }



    @Override
    public Optional<T> findById(ID id) {
        try {
            String tableName = entityClass.getSimpleName().toLowerCase(); // Assuming table name matches class name
            String idColumn = "id"; // Assuming `id` is the primary key column name
            String query = "SELECT * FROM " + tableName + " WHERE " + idColumn + " = ?";

            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setObject(1, id);

            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                T entity = mapResultSetToEntity(resultSet);
                return Optional.of(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<T> findAll() {
        List<T> entities = new ArrayList<>();
        try {
            String tableName = entityClass.getSimpleName().toLowerCase(); // Assuming table name matches class name
            String query = "SELECT * FROM " + tableName;

            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                T entity = mapResultSetToEntity(resultSet);
                entities.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entities;
    }

    @Override
    public T save(T entity) {
        // Use reflection to generate INSERT or UPDATE SQL queries
        // Simplified here for brevity, assuming all entities have an `id` field
        try {
            String tableName = entityClass.getSimpleName().toLowerCase();
            String query = generateInsertOrUpdateQuery(entity);

            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            setPreparedStatementValues(stmt, entity);
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                // Set the generated ID back to the entity
                // Use reflection to set the value
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public void deleteById(ID id) {
        try {
            String tableName = entityClass.getSimpleName().toLowerCase();
            String query = "DELETE FROM " + tableName + " WHERE id = ?";

            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setObject(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(T entity) {
        try {
            // Extract ID using reflection and call deleteById
            ID id = extractIdFromEntity(entity);
            deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private T mapResultSetToEntity(ResultSet resultSet) throws Exception {
        T entity = entityClass.getDeclaredConstructor().newInstance();
        ResultSetMetaData metaData = resultSet.getMetaData();

        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            String columnName = metaData.getColumnName(i);
            Object value = resultSet.getObject(columnName);

            // Set value to the entity field using reflection
            entityClass.getDeclaredField(columnName).setAccessible(true);
            entityClass.getDeclaredField(columnName).set(entity, value);
        }
        return entity;
    }

    private String generateInsertOrUpdateQuery(T entity) {
        // Generate INSERT or UPDATE SQL query based on the entity fields
        // Simplified for brevity
        return "INSERT INTO ...";
    }

    private void setPreparedStatementValues(PreparedStatement stmt, T entity) throws Exception {
        // Use reflection to set values from the entity to the PreparedStatement
    }

    private ID extractIdFromEntity(T entity) throws Exception {
        // Use reflection to get the ID value from the entity
        return null;
    }

}
