package com.scrumtrek.simplestore;

/**
 * Created by user on 19.11.2015.
 */
public interface IStatementGenerator {
    IStatement generate(Customer customer);
}
