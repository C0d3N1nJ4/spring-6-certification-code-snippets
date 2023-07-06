package com.spring;

public interface SequenceDao {

    Sequence getSequence(String sequenceId);

    int getNextValue(String sequenceId);
}
